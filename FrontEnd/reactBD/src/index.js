import React from "react";
import {
    Switch,
    Route,
} from "react-router-dom";
import Home from "./components/home";
import 'bootstrap/dist/css/bootstrap.min.css';
import "./styles/styles.css"
import Login from "./components/login"



const App = () => {
    return (
        <div>
            <Switch>
                <Route exact path="/5CM12017631631IDPF/">
                    <Login />
                </Route>
                <Route exact path="/5CM12017631631IDPF/home">
                    <Home />
                </Route>
                <Route path="*" >
			<Login/>
		</Route>

            </Switch>
        </div>
    );
}
export default App;