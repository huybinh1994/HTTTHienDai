import React from 'react';
import { render } from 'react-dom';
import { Router, Route, IndexRoute, Link, hashHistory, browserHistory } from 'react-router';
//Layout.
import Header from './layouts/Header.js';
import MenuLeft from './layouts/MenuLeft.js';

//Components
import Overview from './component/Overview.js';

const App = (props) => (
    <div className="app-container">
        <Header />
        <div id="page-body">
            <div className="container-fluid">
                <div className="row">
                    <MenuLeft />
                    <main className="col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3">
                        <Overview />
                    </main>
                </div>
            </div>
        </div>
    </div >
);

const routes =
    <Route path="/" component={App}>
        <Route path="/merchant" component={}></Route>
    </Route>

render((
    <Router history={hashHistory} routes={routes} />
), document.body);