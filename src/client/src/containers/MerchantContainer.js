import React, { Component } from 'react';
//Layout.
import Header from '../layouts/Header.js';

class MerchantContainer extends Component {
    render() {
        return(
            <div id="merchant-container">
                {this.props.children}
            </div>
        )
    }
}

export default MerchantContainer;