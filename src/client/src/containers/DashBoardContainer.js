import React, { Component } from 'react';
import { hashHistory } from 'react-router';
import Header from '../layouts/Header.js';

class DashBoardContainer extends Component {
    
    constructor(props) {
        super(props);
        
        if (localStorage.getItem("user")) {
            
        } else {
            hashHistory.push("/login");
        }
    }

    render() {
        return (
            <div id="dashboard">
                <Header />
                <div id="page-body">
                    <div className="container-fluid">
                        <div className="content-wrap">
                            {this.props.children}
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default DashBoardContainer;