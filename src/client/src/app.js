import React from 'react';
import { render } from 'react-dom';
import { Router, Route, IndexRoute, Link, hashHistory, browserHistory } from 'react-router';
//Layout.
import Header from './layouts/Header.js';

//Containers
import MerchantContainer from './containers/MerchantContainer.js';

//Components
import Overview from './component/Overview.js';
import MerchantList from './component/MerchantList.js';
import MerchantRegistration from './component/MerchantRegistration.js';

const App = (props) => (
    <div className="app-container">
        <Header />
        <div id="page-body">
            <div className="container-fluid">
                <div className="content-wrap">
                    {props.children}
                    {/*<div className="loading"></div>*/}
                </div>
            </div>
        </div>
    </div >
);

const routes =
    <Route path="/" component={App}>
        <IndexRoute component={Overview} />
        <Route path="overview" component={Overview} />
        <Route path="merchant" component={MerchantContainer}>
            <Route path="list" component={MerchantList} />
            <Route path="create" component={MerchantRegistration} />
        </Route>
    </Route>

render((
    <Router history={hashHistory} routes={routes} />
), document.body);