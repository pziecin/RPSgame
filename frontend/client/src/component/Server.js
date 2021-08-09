import React, { useState, useEffect} from 'react'

const Server = ({mode, p1,p2,p1Name,p2Name}) => {

  const [value, setValue] = useState('')

  useEffect(()=>{
    const getData = () => {
      let data = 'mode:'+mode+',p2Name:'+p2Name+',p1:'+p1+',p1Name:'+p1Name+',p2:'+p2
        // fetch(window.origin + "/predict", {method: 'POST', headers: {
        fetch("http://127.0.0.1:8000/predict", {method: 'POST', headers: {
          'Content-Type': 'text/plain'
        },
        body: data
      }).then(response => response.text()).then(text => setValue(text))
      .catch(err => console.log(err));
      
    }
    getData()
}, [mode, p1,p2,p1Name,p2Name])

 

        return (
            <div>
              <h2 style={{color:"#ffffff"}}>{value}</h2>
            </div>
        )
}

export default Server

