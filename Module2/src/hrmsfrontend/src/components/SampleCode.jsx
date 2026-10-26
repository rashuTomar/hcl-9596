import React from 'react'
import { useState } from 'react';

function SampleCode({empdata}) {
    const [count, setCount] = useState(0);

    return (
        <>


        <div>
            <h2>Employee Details</h2>
            <h3>Name: {empdata.ename}</h3>
            <h3>EmpId: {empdata.empId}</h3>
        </div>




            <button onClick={() => setCount(count + 1)}>
                Clicked {count} times
            </button>
        </>

    );
}

export default SampleCode
