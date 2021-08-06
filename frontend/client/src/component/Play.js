import React, {useState} from 'react'
import Button from './Button'
import Server from './Server'

const Play = ({mode, p1Name, p2Name}) => {

    const [p1, setP1] = useState('') 
    const [p2, setP2] = useState('') 

    
    const onClick = (e) => {
        let value;
        switch (e.target.id) {
            case 4:
                value="ROCK"
                break;
            case 5:
                value="PAPER"
                break;
            case 6:
                value="SCISORS"
                break;
            default:
                value="ROCK"
                break;
        }
        setP1(value)
    }

    const onClick2 = (e) => {
        let value;
        switch (e.target.id) {
            case 1:
                value="ROCK"
                break;
            case 2:
                value="PAPER"
                break;
            case 3:
                value="SCISORS"
                break;
            default:
                value="ROCK"
                break;
        }
        setP2(value)
    }

    return (
        <div>
            <h2>{p1Name}</h2>
            <Button id="1" onClick={onClick} text="ROCK" />
            <Button id="2" onClick={onClick} text="PAPER" />
            <Button id="3" onClick={onClick} text="SCISORS"/>
            {mode==="PVP" && 
            <div>
                <h2>{p2Name}</h2>
                <Button id="4" onClick={onClick2} text="ROCK" />
                <Button id="5" onClick={onClick2} text="PAPER" />
                <Button id="6" onClick={onClick2} text="SCISORS"/>
            </div>}
            {/* <div>{p1} : {p2} </div> */}
            {(mode==="PVP" && p1 !== ''  && p2 !== ''  ) && <Server mode='PVP' p1={p1} p2={p2} p1Name={p1Name} p2Name={p2Name} /> }
            {(mode==="PVE" && p1 !== '') && <Server mode='PVE' p1={p1} p2={p2} p1Name={p1Name} p2Name={p2Name} />}
        </div>
    )
}

export default Play
