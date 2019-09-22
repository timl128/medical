import React, {Component} from "react";
import {Redirect} from "react-router";
import {Link} from "react-router-dom";
import './RatingPage.css';

class RatingPage extends Component {

    constructor(props) {
        super(props);

        this.state = {
            painLevel: [0, 1, 2, 3, 4],
            redirect: false
        }


    }

    setLevel(level) {
        this.props.illness.painLevel = level;
        console.log(this.props.illness);
    }

    render() {

        if (this.props.illness.newIllnessId == null) {
            return <Redirect to='/'/>;
        }

        return (
            <div>


                <p>Select severity level</p>

                <p>{this.props.illness.newIllnessName}</p>
                <p>Pain level from 0 to 4</p>
                <p>4 is the worst</p>


                {this.state.painLevel.map(
                    (i,index) => {

                        let link = "/result/"
                        return <Link to={{pathname: link}} key={index} onClick={() => this.setLevel(index)}>
                            <button>
                                {i}
                            </button>
                        </Link>
                    })
                }

            </div>


        )
    }


}

export default RatingPage;