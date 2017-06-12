import React, { Component } from 'react';

class AppContainer extends Component {

    componentDidMount() {
        $('[data-toggle="tooltip"]').tooltip();
    }

    render() {
        return (
            <div className="app-container">
                {this.props.children}
                <div id="loading" className="loading"></div>
            </div >
        )
    }
}

export default AppContainer