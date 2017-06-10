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

export default Header;