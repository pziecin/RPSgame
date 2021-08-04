import React, {useState} from 'react'
import Button from './Button'
import Server from './Server'

const Play = ({mode}) => {

    const [p1, setP1] = useState('') 
    const [p2, setP2] = useState('') 

    
    const onClick = (e) => {
        setP1(e.target.id)
    }

    const onClick2 = (e) => {
        setP2(e.target.id)
    }

    return (
        <div>
            <h2>Player 1</h2>
            <Button id="1" onClick={onClick} text="ROCK" />
            <Button id="2" onClick={onClick} text="PAPER" />
            <Button id="3" onClick={onClick} text="SCISORS"/>
            {mode==="PVP" && 
            <div>
                <h2>Player 2</h2>
                <Button id="4" onClick={onClick2} text="ROCK" />
                <Button id="5" onClick={onClick2} text="PAPER" />
                <Button id="6" onClick={onClick2} text="SCISORS"/>
            </div>}
            {(mode==="PVP" && p1 !== ''  && p2 !== ''  ) && <div>{p1} : {p2} </div> }
            {(mode==="PVE" && p1 !== '') && <Server/>}
        </div>
    )
}

export default Play
