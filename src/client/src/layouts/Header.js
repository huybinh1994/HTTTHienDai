<<<<<<< HEAD
import React, { Component } from 'react';
import {login} from '../actions.js';

class Header extends Component {

    constructor(props) {
        super(props);
        login();
    }

    render() {
        return (
            <header id="page-header">
                <nav>
                    <button id="page-header-icon" className="fa fa-bars icon-button">
                        <ul id="page-header-menu" className="animated">
                            <li><a className="brand" href="#">Master</a></li>
                            <li><a className="item" href="#">Danh Sách Merchant</a></li>
                            <li><a className="item" href="#">Tạo Mới Merchant</a></li>

                            <li><a className="brand" href="#">Agent</a></li>
                            <li><a className="item" href="#">Danh Sách Merchant</a></li>
                            <li><a className="item" href="#">Tạo Mới Merchant</a></li>

                            <li><a className="brand" href="#">Merchant</a></li>
                            <li><a className="item" href="#">Thống Kê Chi Tiết</a></li>

                            <li><a className="brand" href="#">Cài Đặt</a></li>
                            <li><a className="item" href="#">Đăng Xuất<i className="fa fa-sign-out" aria-hidden="true"></i></a></li>
                        </ul>
                    </button>
                </nav>
                <div className="avatar-wrap">

                </div>
            </header>
        )
    }
}
=======
import React from 'react';

const Header = (props) => (
    <header id="page-header">
        <nav className="navbar navbar-toggleable-md navbar-inverse fixed-top bg-inverse">
            <button className="navbar-toggler navbar-toggler-right hidden-lg-up" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                <span className="navbar-toggler-icon" />
            </button>
            <a className="navbar-brand" href="#">Dashboard</a>
            <div className="collapse navbar-collapse" id="navbarsExampleDefault">
                <ul className="navbar-nav mr-auto">
                    <li className="nav-item active">
                        <a className="nav-link" href="#">Home <span className="sr-only">(current)</span></a>
                    </li>
                    <li className="nav-item">
                        <a className="nav-link" href="#">Settings</a>
                    </li>
                    <li className="nav-item">
                        <a className="nav-link" href="#">Profile</a>
                    </li>
                    <li className="nav-item">
                        <a className="nav-link" href="#">Help</a>
                    </li>
                </ul>
                <form className="form-inline mt-2 mt-md-0">
                    <input className="form-control mr-sm-2" type="text" placeholder="Search" />
                    <button className="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </div>
        </nav>
    </header>
)
>>>>>>> 9593087fb12bba4e6e2ec9afa573943ea56f96a9

export default Header;