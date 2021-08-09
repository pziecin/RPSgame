import '../style/Button.css'


const Button = ({source, id, text, onClick}) => {

    return (
        <button id={id} onClick={onClick} 
        className ="button" style={{color:"black"}}>
            {source !== '' && <img src={source} alt="img"/>}
            {text} 
        </button>
    )
}

export default Button
