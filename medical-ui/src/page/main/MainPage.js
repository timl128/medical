import React, { Component } from 'react';
import axios from "axios";
import './MainPage.css';
import { Link } from "react-router-dom";

class MainPage extends Component {

    constructor (props) {

        super(props);
        this.state = {

            illness:[]
        }

        this.getData();
    }

    setName(id,name){
        this.props.illness.newIllnessId = id;
        this.props.illness.newIllnessName = name;
    }

    getData () {
        axios.get(process.env.REACT_APP_API_URL + '/illnesses')
            .then(response => {
                this.setState({illness: response.data})
            })
    }


    render() {
        return (
            <div className="background">
            <p>Select an illness</p>
            <p className="terms">Please don't use this service if you become a zombie soon.</p>

            {this.state.illness.map(
                i => {

                    let link = "/rating/"
                    return <Link to={{ pathname: link}} key={i.id} onClick={ () => this.setName(i.id,i.name)}>
                    <div className="box">
                        {i.name}
                    </div>
                </Link>}
            )}
        </div>
        )
    }


}

export default MainPage;