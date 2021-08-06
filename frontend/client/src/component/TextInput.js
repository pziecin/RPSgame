import { Link } from "react-router-dom";
import '../style/Form.css'

const TextInput = ({setP1Name, setP2Name, multi}) => {

    const submitForm = () => {
        console.log(this.state.p2)
        setP1Name(this.state.p1)
        setP2Name(this.state.p2)
    }

    return (
        <form onSubmit={submitForm} className='add-form'>
        <div className='form'>
            <label>Player 1 name:</label>
            <input name="p1" type='text' onChange={e=>setP1Name(e.target.value)} placeholder='Type name'/>
        </div>
        {multi && <div className='form'>
            <label>Player 2 name:</label>
            <input name="p2" type='text'onChange={e=>setP2Name(e.target.value)} placeholder='Type name'/>
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
