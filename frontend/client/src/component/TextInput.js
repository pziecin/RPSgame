import { Link } from "react-router-dom";

const TextInput = ({setP1Name, setP2Name, multi}) => {

    const submitForm = () => {
        console.log(this.state.p2)
    }


    return (
        <form onSubmit={submitForm} className='add-form'>
        <div className='form-control'>
            <label>Player 1 name:</label>
            <input name="p1" type='text' placeholder='Type name'/>
        </div>
        {multi && <div className='form-control'>
            <label>Player 2 name:</label>
            <input name="p2" type='text' placeholder='Type name'/>
        </div>}
        <Link to="/play">
            <button >
                Submit 
            </button>
        </Link>
        
        </form>
    )
}

export default TextInput
