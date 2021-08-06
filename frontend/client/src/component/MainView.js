import React, {useState} from 'react'
import Play from './Play'
import Menu from './Menu'
import { BrowserRouter, Route, Switch } from "react-router-dom";


const MainView = () => {

    const [textMode, setTextMode] = useState('PVP') 
    const [p1Name, setP1Name] = useState('Player 1') 
    const [p2Name, setP2Name] = useState('Player2')

    return (
        <div>
            <BrowserRouter>
            <Switch>
            <Route exact path="/">
                <Menu setTextMode={setTextMode} setP1Name={setP1Name} setP2Name={setP2Name}/>
            </Route>
            <Route exact path="/play">
                <Play mode={textMode} p1Name={p1Name} p2Name={p2Name} />
            </Route>
            </Switch>
            </BrowserRouter>
        </div>
    )
}

export default MainView
