import React, { Component } from 'react';

//layout
import Header from '../layouts/Header.js';

class DashBoardContainer extends Component {
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