import React from 'react'
import Button from './Button'
import TextInput from './TextInput'

const Menu = ({setTextMode, setP1Name, setP2Name}) => {

    const [text, setText] = React.useState('') 

    const onClick = () => {
        setText("PVP")
        setTextMode("PVP")
    }

    
    const onClick2 = (e) => {
        setText("PVE")
        setTextMode("PVE")
    }


    return (
        <div>
            <Button text="PVP" onClick={onClick}></Button>
            <Button text="PVE" onClick={onClick2}></Button>
            {text==="PVP" && <TextInput setP1Name={setP1Name} setP2Name={setP2Name} multi />}
            {text==="PVE" && <TextInput setP1Name={setP1Name} setP2Name={setP2Name} />}
        </div>
    )
}

export default Menu
