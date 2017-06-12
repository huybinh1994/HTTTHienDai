import React from 'react';
import { Link } from 'react-router';

const Header = (props) => (
    <header id="page-header">
        <nav>
            <button id="page-header-icon" className="fa fa-bars icon-button">
                <ul id="page-header-menu">
                    <li><a className="brand" href="#">Master</a></li>
                    <li><a className="item" href="#">Agent</a></li>
                    <li><Link className="item" to="/dashboard/merchant/list">Merchant</Link></li>
                    <li><Link className="item" to="/dashboard/merchant/create">Tạo Mới Merchan</Link></li>
                    <li><Link className="item" to="/dashboard/merchant/statistic">Thống Kê</Link></li>
                    <li><a className="item" href="#">Thông báo</a></li>

                    <li><a className="brand" href="#">Agent</a></li>
                    <li><a className="item" href="#">Danh Sách Sub Agent</a></li>
                    <li><Link className="item" to="/dashboard/merchant/list">Danh Sách Merchant</Link></li>
                    <li><a className="item" href="#">Tạo Mới Merchant</a></li>

                    <li><a className="brand" href="#">Sub Agent</a></li>
                    <li><Link className="item" to="/dashboard/merchant/list">Danh Sách Merchant</Link></li>
                    <li><a className="item" href="#">Tạo Mới Merchant</a></li>

                    <li><a className="brand" href="#">Merchant</a></li>
                    <li><a className="item" href="#">Thông Tin Chi Tiết</a></li>

                    <li><a className="brand" href="#">Cài Đặt</a></li>
                    <li><a className="item" href="#">Đăng Xuất</a></li>
                </ul>
            </button>
        </nav>
    </header>
)

export default Header;