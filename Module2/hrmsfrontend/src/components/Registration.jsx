import React, { use, useState } from 'react'

function Registration() {

    const [empId, setEmpId]= useState();
    const [empName, setEmpName]= useState();
    const[empDesignation, setEmpDesignation]= useState();
    const[empStack, setEmpStack]= useState();
    const[email, setEmail]= useState();
    const[password, setPassword]= useState();
    
    async function sendData(e){

        try{
            e.preventDefault();
            const fetched= await fetch("http://localhost:8080/v1/user/addemp", {
                method:'Post',
                body: JSON.stringify({
    empId: Number(empId),
    empName,
    designation: empDesignation,
    stack: empStack,
    email,
    password
}),
                headers: {"Content-Type" :"application/json"}
            });
            const status = await fetched.text();
        }
        catch(e){
            console.log(e);
            

        }
    }
  return (
    <div>
        <br />
       <form onSubmit={sendData}>

           <div class="form-group">
    <label for="">Employee Id</label>
    <input type="number" onChange={(e)=>setEmpId(e.target.value)} class="form-control" id="" aria-describedby="emailHelp" placeholder="Enter Employee ID" required='true'></input>
    
   
  </div>


        <div class="form-group">
    <label for="">Name</label>
    <input type="text" class="form-control" onChange={(e)=>setEmpName(e.target.value)} id="" aria-describedby="emailHelp" placeholder="Enter Name"></input>
    
   
  </div>


  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input onChange={(e)=>setEmail(e.target.value)} type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email"></input>
    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
    
  </div>

   <div class="form-group">
    <label for="">Designation</label>
    <input onChange={(e)=>setEmpDesignation(e.target.value)} type="text" class="form-control" id="" aria-describedby="emailHelp" placeholder="Enter Designation"></input>
    
   
  </div>
   <div class="form-group">
    <label for="">Stack</label>
    <input onChange={(e)=>setEmpStack(e.target.value)} type="text" class="form-control" id="" aria-describedby="emailHelp" placeholder="Ypur Tech Stack"></input>
    
   
  </div>


  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input onChange={(e)=>setPassword(e.target.value)} type="password" class="form-control" id="exampleInputPassword1" placeholder="Password"></input>
  </div>

 <br />
  <button type="submit" onClick={sendData} class="btn btn-primary">Register</button>
</form>
    </div>
  )
}

export default Registration
