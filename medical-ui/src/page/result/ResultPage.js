import React, { Component } from 'react';
import {Redirect} from "react-router-dom";
import axios from 'axios'
import './ResultPage.css';

class ResultPage extends Component {


    constructor(props){

        super(props)
        this.state = {

            result : []
        }

        this.postData ();
    }

    postData () {

        const data = {
            "illnessId"  : this.props.illness.newIllnessId,
            "painLevel": this.props.illness.painLevel,
        }

        if( this.props.illness.newIllnessId != null && this.props.illness.painLevel!= null){
            axios.post(process.env.REACT_APP_API_URL + '/estimate' ,data)
                .then(response => {
                    this.setState({result: response.data})
                })
        }


    }


    render() {


        if (this.props.illness.newIllnessId == null || this.props.illness.painLevel == null) {
            return <Redirect to='/'/>;
        }

        return (
            <div>
                <p>Our suggested Hospitals</p>

                <table border="1">
                    <thead>
                        <tr>
                            <th>Hospital Name</th>
                            <th>Waiting time</th>
                            <th>distance</th>
                        </tr>
                    </thead>
                    <tbody>
                        {this.state.result.map(
                            i => {

                                return <tr>
                                    <td>{i.hospitalName}</td>
                                    <td className="time"> {i.totalWaitTime} mins</td>
                                    <td> ? </td>
                                </tr>})
                        }
                    </tbody>
                </table>
            </div>
        )
    }

}


export default ResultPage;