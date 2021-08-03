import React, {useState} from 'react'
import Play from './Play'
import Menu from './Menu'
import { BrowserRouter, Route, Switch } from "react-router-dom";


const MainView = () => {

    const [textMode, setTextMode] = useState('PVP') 

    return (
        <div>
            <BrowserRouter>
            <Switch>
            <Route exact path="/">
                <Menu setTextMode={setTextMode} />
            </Route>
            <Route exact path="/play">
                <Play mode={textMode} />
            </Route>
            </Switch>
            </BrowserRouter>
        </div>
    )
}

export default MainView
