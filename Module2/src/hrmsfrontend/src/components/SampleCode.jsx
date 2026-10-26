import React from 'react'

function SampleCode({empdata}) {
    

    return (
        <>


        <div >
            <h2>Employee Details</h2>
            <h3>Name: {empdata.ename}</h3>
            <h3>EmpId: {empdata.empId}</h3>
        </div>

        </>

    );
}

export default SampleCode
