import '../style/Button.css'


const Button = ({id, text, onClick}) => {

    return (
        <button id={id} onClick={onClick} 
        className ="button" style={{color:"black"}}>
             {text} 
        </button>
    )
}

export default Button
