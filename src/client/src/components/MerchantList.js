import React, { Component } from 'react';
import { BootstrapGroup } from './CustomFields.js';
import { getMerchantList } from '../actions.js';

import { locations, Messages, merchantTypes, merchantTypes2 } from '../../test/DataSource.js';

class MerchantList extends Component {

    constructor(props) {
        super(props);
        this.state = {
            regions: null,
            merchant_types: null,
            merchant_list: null
        }
    }

    componentWillMount() {
        let regions = [{ value: null, text: "==Vùng Miền==" }];
        let merchant_types = [{ value: null, text: "==Loại Merchant==" }];
        locations.forEach((element) => {
            regions.push({
                value: element.code,
                text: element.name
            })
        });
        merchantTypes.forEach((element) => {
            merchant_types.push({
                value: element.value,
                text: element.name
            })
        });
        this.setState({
            regions: regions,
            merchant_types: merchant_types
        });
    }

    componentDidMount() {
        var _this = this;
        getMerchantList().then((res) => {
            if (res.statusCode == 200 && res.data.length > 0) {
                _this.setState({
                    merchant_list: res.data
                });
            } else {/*Do Nothing*/ }
        }).catch((err) => {
            console.error(err);
        });

        $("#merchant_filter").validate({
            submitHandler: function (form) {
                let merchant_code = form['merchant_code'].value;
                let merchant_region = form['merchant_region'].value;
                let merchant_type = form['merchant_type'].value;
                getMerchantList(merchant_code, merchant_region, merchant_type).then((res) => {
                    if (res.statusCode == 200 && res.data.length > 0) {
                        _this.setState({
                            merchant_list: res.data
                        });
                    } else {/*Do Nothing*/ }
                })
            }
        });
    }

    render() {
        return (
            <div id="merchant-list">
                <div className="card">
                    <h3 className="card-header">Danh Sách Merchant</h3>

                    <div className="card-block">
                        <h4 className="card-title">Thông Tin Tìm Kiếm</h4>
                        <form id="merchant_filter" name="merchant_filter">
                            <div className="form-group row">
                                <div className="col-sm-3">
                                    <BootstrapGroup type="text" name="merchant_code"
                                        options={{
                                            element_only: true
                                        }}
                                        attributes={{
                                            placeholder: "Merchant Code"
                                        }}
                                    />
                                </div>
                                <div className="col-sm-3">
                                    <BootstrapGroup type="select" name="merchant_region"
                                        options={{
                                            element_only: true,
                                            options: this.state.regions
                                        }} />
                                </div>
                                <div className="col-sm-3">
                                    <BootstrapGroup type="select" name="merchant_type"
                                        options={{
                                            element_only: true,
                                            options: this.state.merchant_types
                                        }}
                                    />
                                </div>
                            </div>
                            <button type="submit" className="btn btn-primary">Đồng ý</button>
                            &nbsp;
                            <button type="reset" className="btn btn-secondary">Làm mới</button>
                        </form>
                    </div>

                    <div className="horizontal-separator" />

                    <div className="card-block">
                        <h4 className="card-title">Thông Tin Chi Tiết</h4>
                        <div className="table-responsive">
                            <table className="table table-striped">
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Merchant Code</th>
                                        <th>Merchant Name</th>
                                        <th>Ngày Kích Hoạt</th>
                                        <th>Loại Merchant</th>
                                        <th>Trạng Thái</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    {this.state.merchant_list
                                        && this.state.merchant_list.map((element, key) => {
                                            return (
                                                <tr key={key}>
                                                    <td>{element.id}</td>
                                                    <td>{element.merchant_code}</td>
                                                    <td>{element.merchant_name}</td>
                                                    <td>{element.first_active_date ? element.first_active_date : ""}</td>
                                                    <td>{element.type_id ? merchantTypes2[element.type_id] : ""}</td>
                                                    <td>{element.status ? "Kích Hoạt" : "Không Kích Hoạt"}</td>
                                                </tr>
                                            )
                                        })
                                    }
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

            </div>
        )
    }
}

export default MerchantList;