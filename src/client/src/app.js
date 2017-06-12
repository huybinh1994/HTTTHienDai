import React from 'react';
import { render } from 'react-dom';
import { Router, Route, IndexRoute, Link, hashHistory, browserHistory } from 'react-router';
//Layout.
import Header from './layouts/Header.js';

//Containers
import AppContainer from './containers/AppContainer.js'
import MerchantContainer from './containers/MerchantContainer.js';
import DashBoardContainer from './containers/DashBoardContainer.js';

//Components
import Overview from './components/Overview.js';
import MerchantList from './components/MerchantList.js';
import MerchantStatistic from './components/MerchantStatistic.js';
import MerchantRegistration from './components/MerchantRegistration.js';
import MerchantEdit from './components/MerchantEdit.js';

//Pages
import Login from './pages/Login.js';

const routes =
    <Route path="/" component={AppContainer}>
        <IndexRoute component={Login} />
        <Route path="/login" component={Login} />
        <Route path="/dashboard" component={DashBoardContainer} >
            <IndexRoute component={Overview} />
            <Route path="overview" component={Overview} />
            <Route path="merchant" component={MerchantContainer}>
                <Route path="list" component={MerchantList} />
                <Route path="create" component={MerchantRegistration} />
                <Route path="edit" component={MerchantEdit} />
                <Route path="statistic" component={MerchantStatistic} />
            </Route>
        </Route>
    </Route>

render((
    <Router history={hashHistory} routes={routes} />
), document.body);