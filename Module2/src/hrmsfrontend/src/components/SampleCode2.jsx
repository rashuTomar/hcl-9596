import React, { useState } from 'react'

function SampleCode2() {
    const [counter, setCounter] = useState(20);
  return (
    <div>

        <button onClick={()=>{setCounter(counter+1)}}>Counter value = {counter}</button>
      
    </div>
  )
}

export default SampleCode2
