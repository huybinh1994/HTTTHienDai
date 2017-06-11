import React from 'react';
import { render } from 'react-dom';
import { Router, Route, IndexRoute, Link, hashHistory, browserHistory } from 'react-router';
<<<<<<< HEAD

//Containers
import MerchantContainer from './containers/MerchantContainer.js';
import DashBoardContainer from './containers/DashBoardContainer.js';

//pages
import Login from './page/login.js';
=======
//Layout.
import Header from './layouts/Header.js';
import MenuLeft from './layouts/MenuLeft.js';
>>>>>>> 9593087fb12bba4e6e2ec9afa573943ea56f96a9

//Components
import Overview from './component/Overview.js';
import MerchantList from './component/MerchantList.js';

const App = (props) => (
    <div className="app-container">
<<<<<<< HEAD
        {props.children}
        {/*<div className="loading"></div>*/}
=======
        <Header />
        <div id="page-body">
            <div className="container-fluid">
                <div className="row">
                    <MenuLeft />
                    <main className="col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3">
                        <div className="content-wrap">
                            {props.children}
                            {/*<div className="loading"></div>*/}
                        </div>
                    </main>
                </div>
            </div>
        </div>
>>>>>>> 9593087fb12bba4e6e2ec9afa573943ea56f96a9
    </div >
);

const routes =
    <Route path="/" component={App}>
<<<<<<< HEAD
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
=======
        <IndexRoute component={Overview} />
        <Route path="overview" component={Overview} />
        <Route path="merchant" component={MerchantList} />
>>>>>>> 9593087fb12bba4e6e2ec9afa573943ea56f96a9
    </Route>

render((
    <Router history={hashHistory} routes={routes} />
), document.body);