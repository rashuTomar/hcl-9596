import React, { useEffect,useState } from "react";

export default function UseFetchApi() {
const[serverData,setServerData]=useState([]);

  useEffect(() => {
   async function getData() {
      try {
       const serverData= await fetch("http://localhost:8080/");
       const jsonData =await serverData.text();
       console.log(jsonData)
       setServerData(jsonData);     
      } 
      catch (e) {}
    }
    getData();
  },[]);



  return <div>
    
        {
            JSON.stringify(serverData)
        }
    
    
    </div>;
}