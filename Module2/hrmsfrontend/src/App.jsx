
import './App.css'
import SampleCode from './components/SampleCode'
import SampleCode2 from './components/SampleCode2'
import UseFetchApi from './components/UseFetchApi'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import Home from './components/Home'
import Login from './components/Login'
import Registration from './components/Registration'
import Dashboard from './components/Dashboard'


function App() {

  

  return (
    <>
       {/* <UseFetchApi></UseFetchApi>  */}

      <BrowserRouter>
        <Routes>
          <Route path='/' element={<Home></Home>}></Route>
          <Route path='/login' element={<Login></Login>}></Route>
          <Route path='/register' element={<Registration></Registration>}></Route>
          <Route path='/dashboard' element={<Dashboard></Dashboard>}></Route>
          
        </Routes>
      
      </BrowserRouter>


    </>
  )
}

export default App
