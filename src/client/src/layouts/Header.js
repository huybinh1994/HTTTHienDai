import React from 'react';

const Header = (props) => (
    <header id="page-header">
        <nav>
            <button id="page-header-icon" className="fa fa-bars icon-button">
                <ul id="page-header-menu">
                    <li><a className="brand" href="#">Master</a></li>
                    <li><a className="item" href="#">Danh Sách Merchant</a></li>
                    <li><a className="item" href="#">Tạo Mới Merchant</a></li>

                    <li><a className="brand" href="#">Agent</a></li>
                    <li><a className="item" href="#">Danh Sách Merchant</a></li>
                    <li><a className="item" href="#">Tạo Mới Merchant</a></li>

                    <li><a className="brand" href="#">Merchant</a></li>
                    <li><a className="item" href="#">Thống Kê Chi Tiết</a></li>

                    <li><a className="brand" href="#">Cài Đặt</a></li>
                    <li><a className="item" href="#">Đăng Xuất</a></li>
                </ul>
            </button>
        </nav>
    </header>
)

export default Header;