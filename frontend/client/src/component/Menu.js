import React from 'react'
import Button from './Button'
import TextInput from './TextInput'

const Menu = ({setTextMode}) => {

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
            {text==="PVP" && <TextInput multi />}
            {text==="PVE" && <TextInput />}
        </div>
    )
}

export default Menu
