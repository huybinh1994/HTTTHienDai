import React, { Component } from 'react';
import { hashHistory } from 'react-router';
import { BootstrapGroup } from '../components/CustomFields.js';
import { login, displayLoading, hideLoading } from '../actions.js';

//Test Data
import { Messages } from '../../test/DataSource.js';

class Login extends Component {

    constructor(props) {
        super(props);
    }

    componentDidMount() {
        var _this = this;

        $("#login").validate({
            rules: {
                username: {
                    required: true,
                    email: true
                },
                password: {
                    required: true
                }
            },
            messages: {
                username: {
                    required: "Vui lòng không bỏ trống <strong>Username</strong>!",
                    email: "Vui lòng cung cấp một email cho <strong>Username</strong>!"
                },
                password: {
                    required: "Vui lòng không bỏ trống <strong>Password</strong>!"
                }
            },
            errorPlacement: function (error, element) {
                $("#output").empty().append(error);
            },
            invalidHandler: function (event, validator) {
                $("#output").addClass("alert alert-danger animated fadeInUp");
            },
            submitHandler: function (form) {
                let username = form['username'].value;
                let password = form['password'].value;
                displayLoading();
                login(username, password).then((res) => {
                    if (res.statusCode == 200) {
                        localStorage.setItem("user", JSON.stringify(res.data));
                        hashHistory.push("/dashboard/");
                    } else {
                        $("#output").empty().append('<label><strong>Username</strong> hoặc <strong>Password</strong> không đúng.</label>');
                        $("#output").addClass("alert alert-danger animated fadeInUp");
                    }
                    hideLoading();
                }).catch((err) => {
                    hideLoading();
                })
            }
        })
    }

    render() {
        return (
            <div className="container">
                <div className="login-container">

                    <div id="output"></div>

                    <div className="avatar"></div>
                    <div className="form-box">
                        <form id="login">
                            <BootstrapGroup type="text" name="username" required={true}
                                attributes={{
                                    placeholder: "Email"
                                }}
                                options={{
                                    element_only: true
                                }}
                            />
                            <BootstrapGroup type="password" name="password" required={true}
                                attributes={{
                                    placeholder: "Password"
                                }}
                                options={{
                                    element_only: true
                                }}
                            />
                            <button type="" className="btn btn-info btn-block login" type="submit">Login</button>
                        </form>
                    </div>
                </div>
            </div>
        )
    }
}

export default Login;