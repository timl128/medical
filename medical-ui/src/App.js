import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import RatingPage from "./page/rate/RatingPage";
import MainPage from "./page/main/MainPage";
import ResultPage from "./page/result/ResultPage";


class App extends Component {


    constructor (props) {

        super(props);
    }

    iData = {
        newIllnessId : null,
        newIllnessName  : null,
        painLevel : null
    }



    render() {
        return (
            <Router>

                <Route path="/" exact
                       component={
                           () => <MainPage illness = {this.iData}/>

                       }
                />
                <Route path="/rating/" component={
                    () => <RatingPage illness = {this.iData}/>

                } />

                <Route path="/result/" component={
                    () => <ResultPage illness = {this.iData}/>

                } />

            </Router>
        )
    }

}


export default App;