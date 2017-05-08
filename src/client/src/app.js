import React from 'react';
import { render } from 'react-dom';
import { Router, Route, IndexRoute, Link, hashHistory, browserHistory } from 'react-router';
//Layout.
import Header from './layouts/Header.js';
import MenuLeft from './layouts/MenuLeft.js';

//Components
import Overview from './component/Overview.js';
import MerchantList from './component/MerchantList.js';

const App = (props) => (
    <div className="app-container">
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
    </div >
);

const routes =
    <Route path="/" component={App}>
        <IndexRoute component={Overview} />
        <Route path="overview" component={Overview} />
        <Route path="merchant" component={MerchantList} />
    </Route>

render((
    <Router history={hashHistory} routes={routes} />
), document.body);