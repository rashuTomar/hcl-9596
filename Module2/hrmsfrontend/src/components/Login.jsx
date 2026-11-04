import { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.bundle.min'

function Login() {
  const [empId, setEmpId] = useState('')
  const [password, setPassword] = useState('')
  const [message, setMessage] = useState('')
  const [loading, setLoading] = useState(false)
  const navigate = useNavigate()

  
async function verifyLogin(event) {
  event.preventDefault();
  setLoading(true);
  setMessage('');

  try {
    const params = new URLSearchParams({
      empId: empId,
      password: password
    });

    const response = await fetch(
      `http://localhost:8080/v1/user/login?${params.toString()}`,
      {
        method: 'POST'
      }
    );

    const result = await response.text();

    if (!response.ok) {
      throw new Error(result || 'Login request failed');
    }

    if (result === 'Login successful') {
      sessionStorage.setItem('loggedInEmpId', empId)
      navigate('/dashboard', { state: { empId } })
    } else {
      setMessage(result);
    }
  } catch (error) {
    setMessage(
      error.message || 'Unable to connect to the server'
    );
  } finally {
    setLoading(false);
  }
}

  return (
    <div>
      <form onSubmit={verifyLogin}>
        <div className="form-group">
          <label htmlFor="employeeId">Employee ID</label>
          <input
            type="number"
            className="form-control"
            id="employeeId"
            placeholder="Enter employee ID"
            value={empId}
            onChange={(event) => setEmpId(event.target.value)}
            required
          />
        </div>

        <div className="form-group mt-2">
          <label htmlFor="password">Password</label>
          <input
            type="password"
            className="form-control"
            id="password"
            placeholder="Password"
            value={password}
            onChange={(event) => setPassword(event.target.value)}
            required
          />
        </div>

        <button type="submit" className="btn btn-primary mt-3" disabled={loading}>
          {loading ? 'Logging in...' : 'Login'}
        </button>

        {message && <div className="mt-3 alert alert-danger">{message}</div>}
      </form>
    </div>
  )
}

export default Login
