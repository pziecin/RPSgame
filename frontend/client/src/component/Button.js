const Button = ({id, text, onClick}) => {

    return (
        <button id={id} onClick={onClick} 
        className ="btn">
             {text} 
        </button>
    )
}

export default Button
