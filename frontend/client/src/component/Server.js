import React, { useState, useEffect} from 'react'

const Server = ({mode, p1,p2,p1Name,p2Name}) => {

  const [value, setValue] = useState('')

  useEffect(()=>{
    getData()
}, [])

  const getData = () => {
        let data = 'mode:'+mode+',p2Name:'+p2Name+',p1:'+p1+',p1Name:'+p1Name+',p2:'+p2
          fetch(window.origin + "/predict", {method: 'POST', headers: {
            'Content-Type': 'application/json'
          },
          body: data
        }).then(response => response.text()).then(text => setValue(text))
        .catch(err => console.log(err));
        
      }

        return (
            <div>
              <h2 style={{color:"#ffffff"}}>{value}</h2>
            </div>
        )
}

export default Server

