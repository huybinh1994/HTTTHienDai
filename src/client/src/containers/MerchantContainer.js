import React, { Component } from 'react';

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