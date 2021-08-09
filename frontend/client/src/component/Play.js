import React, {useState} from 'react'
import Button from './Button'
import Server from './Server'

const Play = ({mode, p1Name, p2Name}) => {

    const [p1, setP1] = useState('') 
    const [p2, setP2] = useState('') 

    
    const onClick2 = (e) => {
        switch (e.target.id) {
            case "4":
                setP2("ROCK")
                console.log(4)
                break;
            case "5":
                setP2("PAPER")
                console.log(5)
                break;
            case "6":
                console.log(6)
                setP2("SCISORS")
                break;
            default:
                console.log("DEF")
                setP2("ROCK")
                break;
        }
    }

    const onClick = (e) => {
        switch (e.target.id) {
            case "1":
                setP1("ROCK")
                console.log(1)
                break;
            case "2":
                setP1("PAPER")
                console.log(2)
                break;
            case "3":
                setP1("SCISORS")
                console.log(3)
                break;
            default:
                setP1("ROCK")
                break;
        }
    }

    
    const restart = () => {
        setP1('')
        setP2('')
    }

    return (
        <div>
            <h2 style={{color:"#ffffff"}}>{p1Name}</h2>
            <Button source="../rock.png" id="1" onClick={onClick} text="ROCK" />
            <Button source="../hand.png" id="2" onClick={onClick} text="PAPER" />
            <Button source="../scissors.png" id="3" onClick={onClick} text="SCISSORS"/>
            {mode==="PVP" && 
            <div>
                <h2 style={{color:"#ffffff"}}>{p2Name}</h2>
                <Button source="../rock.png" id="4" onClick={onClick2} text="ROCK" />
                <Button source="../hand.png" id="5" onClick={onClick2} text="PAPER" />
                <Button source="../scissors.png" id="6" onClick={onClick2} text="SCISSORS"/>
            </div>}
            {(mode==="PVP" && p1 !== ''  && p2 !== ''  ) && <Server mode='PVP' p1={p1} p2={p2} p1Name={p1Name} p2Name={p2Name} /> }
            {(mode==="PVE" && p1 !== '') && <Server mode='PVE' p1={p1} p2="BOT" p1Name={p1Name} p2Name="BOT" />}
            {((mode==="PVP" && p1 !== ''  && p2 !== ''  ) || (mode==="PVE" && p1 !== '')) && <button className ="button" onClick={restart}> Restart </button>}


        </div>
    )
}

export default Play
