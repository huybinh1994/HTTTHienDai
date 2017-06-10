import React from 'react';
import { Link } from 'react-router';

const MenuLeft = (props) => (
    <nav className="col-sm-3 col-md-2 hidden-xs-down bg-faded sidebar">
        <ul className="nav nav-pills flex-column">
            <li className="nav-item">
                <Link to="/overview" index={true} activeClassName="active" className="nav-link">Tổng Quang</Link>
            </li>
            <li className="nav-item">
                <a className="nav-link" href="#">Reports</a>
            </li>
            <li className="nav-item">
                <a className="nav-link" href="#">Analytics</a>
            </li>
            <li className="nav-item">
                <a className="nav-link" href="#">Export</a>
            </li>
        </ul>
        <ul className="nav nav-pills flex-column">
            <li className="nav-item">
                <Link to="merchant" activeClassName="active" className="nav-link">Quản Lý Merchant</Link>
            </li>
            <li className="nav-item">
                <a className="nav-link" href="#">Nav item again</a>
            </li>
            <li className="nav-item">
                <a className="nav-link" href="#">One more nav</a>
            </li>
            <li className="nav-item">
                <a className="nav-link" href="#">Another nav item</a>
            </li>
        </ul>
        <ul className="nav nav-pills flex-column">
            <li className="nav-item">
                <a className="nav-link" href="#">Nav item again</a>
            </li>
            <li className="nav-item">
                <a className="nav-link" href="#">One more nav</a>
            </li>
            <li className="nav-item">
                <a className="nav-link" href="#">Another nav item</a>
            </li>
        </ul>
    </nav>
);

export default MenuLeft;