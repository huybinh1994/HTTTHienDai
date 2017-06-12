import React, { Component } from 'react';
import { BootstrapGroup } from './CustomFields.js';
import { hashHistory } from 'react-router';

//Test data.
import { locations, Messages, merchantTypes, merchantStatus } from '../../test/DataSource.js';

//Actions
import { addMerchant, getUser, getMerchantValues, displayLoading, hideLoading } from '../actions.js';

const getSub = (items, i, code) => {
    let element = items[i];
    if (!element) {
        return null;
    } else if (element.code === code) {
        let items = [];
        if (element.subs) {
            for (let j = 0, n = element.subs.length; j < n; j++) {
                items.push({
                    value: element.subs[j].code,
                    text: element.subs[j].name
                });
            }
        } else {/*Do Nothing.*/ }
        return items;
    } else if (Array.isArray(element.subs) && element.subs.length) {
        let result = getSub(element.subs, 0, code);
        if (result !== null) {
            return result;
        } else {/*Do Nothing.*/ }
    }
    return getSub(items, i += 1, code);
}

const randomPassword = () => {
    var length = 8,
        charset = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()",
        retVal = "";
    for (let i = 0, n = charset.length; i < length; ++i) {
        retVal += charset.charAt(Math.floor(Math.random() * n));
    }
    return retVal;
}

class MerchantRegistration extends Component {

    constructor(props) {
        super(props);
        this.state = {
            level_1: null,
            level_2: null,
            level_3: null,

            master_id: null,
            agent_list: null,
            sub_agent_list: null,

            types: null,
            merchants: null
        };
    }

    componentWillMount() {
        let types = [{ value: null, text: "==Loại Merchant==" }];
        merchantTypes.forEach((element) => {
            types.push({
                value: element.value,
                text: element.name
            })
        });
        this.setState({
            types: types
        })
        this.initLevel();
        this.initLocations();
    }

    initLevel() {
        var _this = this;
        // let merchant_code = "T0001A000001S000001M0000000001";
        // let regex = /T([\d]{4})+A([\d]{6})+S([\d]{6})+M([\d]{10})$/;
        var master_id = getUser().master.id;
        displayLoading();
        getMerchantValues()
            .then((res) => {
                hideLoading();
                if (res.statusCode == 200) {
                    let agent_list = [{ value: null, text: "==Agent==" }];
                    let merchants = res.data;
                    let arrAgents = merchants[master_id].list_agent
                    for (let key in arrAgents) {
                        agent_list.push({
                            value: key,
                            text: arrAgents[key].agent_name
                        })
                    }
                    _this.setState({
                        master_id: master_id,
                        agent_list: agent_list,
                        merchants: res.data
                    });
                } else {/*Do Nothing.*/ }
            }).catch((err) => {
                hideLoading();
            });
    }

    initLocations() {
        let level_1 = [{ value: null, text: "==Tỉnh/Thành Phố==" }];
        getSub(locations, 0, "b").forEach((element) => {
            level_1.push(element);
        });
        getSub(locations, 0, "t").forEach((element) => {
            level_1.push(element);
        });
        getSub(locations, 0, "n").forEach((element) => {
            level_1.push(element);
        });
        this.setState({
            level_1: level_1
        });
    }

    componentDidMount() {
        $("#merchant").validate({
            errorClass: "form-control-error",
            validClass: "form-control-success",
            rules: {
                merchant_name: {
                    required: true
                },
                merchant_phone_call: {
                    required: true
                },
                address: {
                    required: true
                },
                level_1: {
                    number: true,
                    required: true
                },
                level_2: {
                    number: true,
                    required: true
                },
                level_3: {
                    number: true,
                    required: true
                },
                merchant_username: {
                    email: true,
                    required: true
                },
                merchant_password: {
                    required: true
                },
                type_id: {
                    number: true,
                    required: true
                },
                agent_id: {
                    number: true,
                    required: true
                },
                sub_agent_id: {
                    number: true,
                    required: true
                }
            },
            messages: {
                merchant_name: {
                    required: Messages.required
                },
                merchant_phone_call: {
                    required: Messages.required
                },
                address: {
                    required: Messages.required
                },
                level_1: {
                    required: Messages.required,
                    number: Messages.required
                },
                level_2: {
                    required: Messages.required,
                    number: Messages.required
                },
                level_3: {
                    required: Messages.required,
                    number: Messages.required
                },
                merchant_username: {
                    required: Messages.required,
                    email: Messages.email
                },
                merchant_password: {
                    required: Messages.required
                },
                type_id: {
                    required: Messages.required,
                    number: Messages.required
                },
                agent_id: {
                    required: Messages.required,
                    number: Messages.required
                },
                sub_agent_id: {
                    required: Messages.required,
                    number: Messages.required
                }
            },
            submitHandler: function (form) {
                displayLoading();
                let user = localStorage.getItem("user");
                if (user) {
                    user = JSON.parse(user);
                } else {/*Do Somthing*/ }
                let data = {
                    merchant_name: form['merchant_name'].value,
                    merchant_phone_call: form['merchant_phone_call'].value,
                    master_id: getUser().master.id,
                    agent_id: form['agent_id'].value*1.0,
                    sub_agent_id: form['sub_agent_id'].value*1.0,
                    address: form['address'].value,
                    province: form['level_1'].value*1.0,
                    district: form['level_2'].value*1.0,
                    ward: form['level_3'].value*1.0,
                    username: form['merchant_username'].value,
                    password: form['merchant_password'].value,
                    active: form['status'].value,
                    level_id: 4,
                    type_id: form['type_id'].value
                }
                addMerchant(data, user.token.token).then((res) => {
                    if (res.statusCode == 200) {
                        hashHistory.push("/dashboard/merchant/list");
                    } else {
                        let message = res.errors[0].message;
                        $("#output").empty().html(`<label>${message}</label>`);
                        $("#output").addClass("alert alert-danger animated fadeInUp");
                    }
                    hideLoading();
                }).catch((err) => {
                    hideLoading();
                });
            }
        });
    }

    render() {
        var _this = this;
        return (
            <div id="merchant-registration">
                <div className="card">
                    <h3 className="card-header">Tạo Mới Merchant</h3>
                    <div className="card-block">
                        <div className="row">
                            <div className="col-sm-8 offset-sm-2">
                                <div id="output"></div>
                                <form id="merchant" name="merchant">
                                    <h4 className="card-title">Thông Tin Cơ Bản</h4>
                                    <BootstrapGroup type="text" name="merchant_name" label="Tên Merchant" required={true} />
                                    <BootstrapGroup type="text" name="merchant_phone_call" label="Số Điện Thoại" required={true} />

                                    <div className="form-group row">
                                        <label className="col-sm-2 col-form-label">Phân Quyền<span className="required-simple">*</span></label>
                                        <div className="col-sm-5">
                                            <BootstrapGroup type="select" name="agent_id"
                                                options={{
                                                    options: this.state.agent_list,
                                                    element_only: true,
                                                }}
                                                attributes={{
                                                    onClick: (event) => {
                                                        if (!isNaN(event.target.value)) {
                                                            let arrSubAgent = _this.state.merchants[this.state.master_id]["list_agent"][event.target.value]["list_sub_agent"];
                                                            let sub_agent_list = [{ value: null, text: "==Sub Agent==" }];
                                                            for (let key in arrSubAgent) {
                                                                sub_agent_list.push({
                                                                    value: key,
                                                                    text: arrSubAgent[key].sub_agent_name
                                                                });
                                                            }
                                                            this.setState({
                                                                sub_agent_list: sub_agent_list
                                                            })
                                                        } else {
                                                            this.setState({
                                                                sub_agent_list: []
                                                            })
                                                        }
                                                    }
                                                }}
                                            /></div>
                                        <div className="col-sm-5">
                                            <BootstrapGroup type="select" name="sub_agent_id"
                                                options={{
                                                    options: this.state.sub_agent_list,
                                                    element_only: true
                                                }}
                                            />
                                        </div>
                                    </div>

                                    <BootstrapGroup type="select" name="type_id" label="Loại Merchant" required={true} options={{ options: this.state.types }} />

                                    <BootstrapGroup type="text" name="address" label="Địa Chỉ" required={true} />

                                    <BootstrapGroup type="select" name="level_1" label="Tỉnh/Thành Phố" required={true} options={{ options: this.state.level_1 }}
                                        attributes={{
                                            onChange: (event) => {
                                                let level_2 = getSub(locations, 0, event.target.value);
                                                if (level_2) {
                                                    level_2.unshift({ value: null, text: "==Quận/Huyện==" });
                                                } else {/*Do Nothing.*/ }
                                                this.setState({
                                                    level_2: level_2,
                                                    level_3: []
                                                });
                                            }
                                        }} />
                                    <BootstrapGroup type="select" name="level_2" label="Quận/Huyện" required={true} options={{ options: this.state.level_2 }}
                                        attributes={{
                                            onChange: (event) => {
                                                let level_3 = getSub(locations, 0, event.target.value);
                                                if (level_3) {
                                                    level_3.unshift({ value: null, text: "==Phường/Xã==" });
                                                }
                                                this.setState({
                                                    level_3: level_3
                                                })
                                            }
                                        }} />
                                    <BootstrapGroup type="select" name="level_3" label="Phường/Xã" required={true} options={{ options: this.state.level_3 }} />
                                    <BootstrapGroup type="select" name="status" label="Trạng Thái" required={true} options={{ options: merchantStatus }} />

                                    <h4 className="card-title">Thông Tin Đăng Nhập</h4>
                                    <BootstrapGroup type="text" name="merchant_username" label="Email" required={true} attributes={{ placeholder: "VD: card@gmail.com" }} />
                                    <BootstrapGroup type="text" name="merchant_password" label="Mật Khẩu" required={true}
                                        options={{
                                            wrap_classes: "col-sm-8",
                                            post_element: <div className="col-sm-2" style={{ textAlign: "right" }}>
                                                <button type="button" id="random-password" className="btn btn-primary"
                                                    onClick={(event) => {
                                                        $("#merchant_password").val(randomPassword());
                                                    }}>Ngẫu Nhiên</button>
                                            </div>
                                        }}
                                    />

                                    <button type="submit" className="btn btn-primary">Đồng ý</button>
                                    &nbsp;
                                    <button type="button" className="btn btn-secondary">Hủy Bỏ</button>

                                </form>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        );
    }
}

export default MerchantRegistration;