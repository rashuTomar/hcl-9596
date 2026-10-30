import { useEffect, useMemo, useState } from 'react'
import { useLocation, useNavigate } from 'react-router-dom'
import './AttendanceDashboard.css'

function formatDate(value) {
  if (!value) return '—'
  return new Date(`${value}T00:00:00`).toLocaleDateString('en-IN', {
    day: '2-digit', month: 'short', year: 'numeric'
  })
}

function formatTime(value) {
  if (!value) return '—'
  return new Date(value).toLocaleTimeString('en-IN', {
    hour: '2-digit', minute: '2-digit', hour12: true
  })
}

function Dashboard() {
  const location = useLocation()
  const navigate = useNavigate()
  const empId = location.state?.empId || sessionStorage.getItem('loggedInEmpId')
  const [attendance, setAttendance] = useState([])
  const [search, setSearch] = useState('')
  const [loading, setLoading] = useState(true)
  const [error, setError] = useState('')

  useEffect(() => {
    if (!empId) {
      navigate('/login', { replace: true })
      return
    }

    async function loadAttendance() {
      try {
        const response = await fetch('http://localhost:8080/v1/user/attendance/all')
        if (!response.ok) throw new Error('Unable to load attendance records')
        setAttendance(await response.json())
      } catch (requestError) {
        setError(requestError.message)
      } finally {
        setLoading(false)
      }
    }

    loadAttendance()
  }, [empId, navigate])

  const filteredAttendance = useMemo(() => {
    const query = search.toLowerCase().trim()
    if (!query) return attendance
    return attendance.filter((record) => {
      const employee = record.employee || {}
      return String(employee.empId || '').includes(query)
        || (employee.empName || '').toLowerCase().includes(query)
        || (employee.designation || '').toLowerCase().includes(query)
    })
  }, [attendance, search])

  const presentToday = attendance.filter((record) => {
    const today = new Date().toISOString().slice(0, 10)
    return record.attendancedate === today
  }).length

  function logout() {
    sessionStorage.removeItem('loggedInEmpId')
    navigate('/login', { replace: true })
  }

  return (
    <div className="attendance-shell">
      <aside className="attendance-sidebar">
        <div className="attendance-brand"><span className="attendance-logo">H</span><span>HRMS</span></div>
        <nav className="attendance-nav" aria-label="Dashboard navigation">
          <button className="attendance-nav-item active"><span>⌂</span> Dashboard</button>
          <button className="attendance-nav-item"><span>♧</span> Attendance</button>
          <button className="attendance-nav-item"><span>♙</span> Employees</button>
          <button className="attendance-nav-item"><span>◇</span> Leave</button>
        </nav>
        <button className="attendance-logout" onClick={logout}><span>↪</span> Logout</button>
      </aside>

      <main className="attendance-main">
        <header className="attendance-header">
          <div><p>HR MANAGEMENT</p><h1>Attendance Dashboard</h1></div>
          <div className="attendance-profile"><button aria-label="Notifications">🔔</button><span>{empId}</span><div>{String(empId).charAt(0)}</div></div>
        </header>

        <section className="attendance-summary">
          <article><div className="summary-icon blue">♧</div><div><p>Total Records</p><strong>{attendance.length}</strong></div></article>
          <article><div className="summary-icon green">✓</div><div><p>Present Today</p><strong>{presentToday}</strong></div></article>
          <article><div className="summary-icon purple">◷</div><div><p>Unique Employees</p><strong>{new Set(attendance.map((record) => record.employee?.empId)).size}</strong></div></article>
          <article><div className="summary-icon orange">◇</div><div><p>Selected Date</p><strong>{new Date().toLocaleDateString('en-IN', { day: '2-digit', month: 'short' })}</strong></div></article>
        </section>

        <section className="attendance-card">
          <div className="attendance-card-header">
            <div><p>EMPLOYEE ATTENDANCE</p><h2>Attendance Records</h2></div>
            <div className="attendance-tools">
              <label className="attendance-search"><span>⌕</span><input value={search} onChange={(event) => setSearch(event.target.value)} placeholder="Search employee..." /></label>
            </div>
          </div>

          {error && <div className="attendance-error">{error}</div>}

          <div className="attendance-table-wrap">
            <table className="attendance-table">
              <thead><tr><th>Employee</th><th>Employee ID</th><th>Date</th><th>In Time</th><th>Out Time</th><th>Status</th></tr></thead>
              <tbody>
                {loading ? <tr><td colSpan="6" className="attendance-empty">Loading attendance...</td></tr> : filteredAttendance.length === 0 ? <tr><td colSpan="6" className="attendance-empty">No attendance records found</td></tr> : filteredAttendance.map((record) => {
                  const employee = record.employee || {}
                  return <tr key={record.attendanceId}>
                    <td><div className="employee-cell"><span className="employee-avatar">{(employee.empName || 'E').charAt(0).toUpperCase()}</span><div><strong>{employee.empName || 'Unknown Employee'}</strong><small>{employee.designation || 'Employee'}</small></div></div></td>
                    <td><span className="employee-id">EMP-{employee.empId || '—'}</span></td>
                    <td>{formatDate(record.attendancedate)}</td>
                    <td>{formatTime(record.inTime)}</td>
                    <td>{formatTime(record.outTime)}</td>
                    <td><span className="status-present"><span /> Present</span></td>
                  </tr>
                })}
              </tbody>
            </table>
          </div>
          <div className="attendance-footer"><span>Showing {filteredAttendance.length} of {attendance.length} records</span></div>
        </section>
      </main>
    </div>
  )
}

export default Dashboard
