import React, { useEffect, useState } from 'react'

function SampleCode2() {
    const [counter, setCounter] = useState(20);
    const [pointer, setPointer] = useState(100);
    
    useEffect(()=>{
        console.log("component is rendered");
        console.log("counter= "+counter);
        console.log("pointer= "+pointer);
        
        
    },[counter, pointer])

    function changeCounter(){
        setCounter(counter+2);
        
    }
    function changePointer(){
        setPointer(pointer-2);
    }

  return (
    <div>

        <div>Counter value = {counter}</div>
        <div >Pointer value = {pointer}</div>
        <button onClick={changeCounter}>Counter</button>
        <button onClick={changePointer}>Pointer</button>
      
    </div>
  )
}

export default SampleCode2
