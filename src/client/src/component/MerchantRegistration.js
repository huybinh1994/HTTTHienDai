import React, { Component } from 'react';
import { BootstrapGroup } from './CustomFields.js';

//Test data.
import { locations, Messages } from '../../test/DataSource.js';

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
            level_3: null
        };
    }

    componentWillMount() {
        let level_1 = [{ value: null, text: "==Tỉnh/Thành Phố==" }];
        getSub(locations, 0, "b").forEach((element) => {
            level_1.push(element);
        })
        getSub(locations, 0, "t").forEach((element) => {
            level_1.push(element);
        })
        getSub(locations, 0, "n").forEach((element) => {
            level_1.push(element);
        })
        
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
                menage_merchant: {
                    required: true
                },
                address_1: {
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
                }
            },
            messages: {
                merchant_name: {
                    required: Messages.required
                },
                merchant_phone_call: {
                    required: Messages.required
                },
                menage_merchant: {
                    required: Messages.required
                },
                address_1: {
                    required: Messages.required
                },
                level_1: {
                    required: Messages.required,
                    number: Messages.number
                },
                level_2: {
                    required: Messages.required,
                    number: Messages.number
                },
                level_3: {
                    required: Messages.required,
                    number: Messages.number
                },
                merchant_username: {
                    required: Messages.required,
                    email: Messages.email
                },
                merchant_password: {
                    required: Messages.required
                }
            }
        });
    }

    render() {
        return (
            <div id="merchant-registration">
                <div className="card">
                    <h3 className="card-header">Tạo Mới Merchant</h3>
                    <div className="card-block">
                        <form id="merchant" name="merchant">
                            <h4 className="card-title">Thông Tin Cơ Bản</h4>
                            <BootstrapGroup type="text" name="merchant_name" label="Tên Merchant" required={true} />
                            <BootstrapGroup type="text" name="merchant_phone_call" label="Số Điện Thoại" required={true} />

                            <BootstrapGroup type="select" name="menage_merchant" label="Được Quản Lý" required={true} />

                            <BootstrapGroup type="text" name="address_1" label="Địa Chỉ" required={true} />

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

                            <h4 className="card-title">Thông Tin Nâng Cao</h4>
                            <BootstrapGroup type="text" name="merchant_username" label="Tên Đăng Nhập" required={true} attributes={{ placeholder: "VD: card@gmail.com" }} />
                            <BootstrapGroup type="text" name="merchant_password" label="Mật Khẩu" required={true}
                                options={{
                                    wrap_classes: "col-sm-8",
                                    post_element: <div className="col-sm-2">
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
        );
    }
}

export default MerchantRegistration;