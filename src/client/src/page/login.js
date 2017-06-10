import React, { Component } from 'react';

import { BootstrapGroup } from '../component/CustomFields.js';

class Login extends Component {
    render() {
        return (
            <div id="login">
                <form id="form-login">
                    <BootstrapGroup type="text" name="username" label="Tên Đăng Nhập" required={true} />
                    <BootstrapGroup type="password" name="password" label="Mật Khẩu" required={true} />

                    <button type="submit" className="btn btn-primary">Đồng ý</button>
                    &nbsp;
                    <button type="button" className="btn btn-secondary">Hủy Bỏ</button>
                </form>
            </div>
        )
    }
}

export default Login;