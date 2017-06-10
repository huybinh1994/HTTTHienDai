import React from 'react';
import { render } from 'react-dom';
import { Router, Route, IndexRoute, Link, hashHistory, browserHistory } from 'react-router';

//Containers
import MerchantContainer from './containers/MerchantContainer.js';
import DashBoardContainer from './containers/DashBoardContainer.js';

//pages
import Login from './page/login.js';

//Components
import Overview from './component/Overview.js';
import MerchantList from './component/MerchantList.js';
import MerchantRegistration from './component/MerchantRegistration.js';

const App = (props) => (
    <div className="app-container">
        {props.children}
        {/*<div className="loading"></div>*/}
    </div >
);

const routes =
    <Route path="/" component={App}>
        <IndexRoute component={Login} />
        <Route path="/login" component={Login} />
        <Route path="/dashboard" component={DashBoardContainer}>
            <IndexRoute component={Overview} />
            <Route path="overview" component={Overview} />
            <Route path="merchant" component={MerchantContainer}>
                <Route path="list" component={MerchantList} />
                <Route path="create" component={MerchantRegistration} />
            </Route>
        </Route>
    </Route>

render((
    <Router history={hashHistory} routes={routes} />
), document.body);