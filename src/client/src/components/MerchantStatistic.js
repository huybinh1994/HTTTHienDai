import React, { Component } from 'react';
import { BootstrapGroup } from './CustomFields.js';

//Test data.
import { locations, Messages, merchantTypes, reportTypes, months, quarters, years, card_typs } from '../../test/DataSource.js';

import { getAgentListFromMaster, getUser, getStatisticNormalDate, getStatisticCardNormalDate, displayLoading, hideLoading } from '../actions.js';

class MerchantStatistic extends Component {

    constructor(props) {
        super(props);
        this.state = {
            regions: null,
            merchant_types: null,
            report_types: null,
            report_type: null,
            agent_list: null,

            months: null,
            quarters: null,
            years: null,

            statistic: null,
            statistic_card: null 
        }
    }

    componentWillMount() {
        let regions = [{ value: null, text: "==Vùng Miền==" }];
        let merchant_types = [{ value: null, text: "==Loại Merchant==" }];
        let report_types = [{ value: null, text: "==Loại Thống Kê==" }];
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
        })
        reportTypes.forEach((element) => {
            report_types.push({
                value: element.value,
                text: element.name
            });
        });
        this.setState({
            regions: regions,
            merchant_types: merchant_types,
            report_types: report_types
        });
    }

    componentDidMount() {

        var _this = this;
        $(".datepicker").datepicker({
            "format": "yyyy-mm-dd",
            calendarWeeks: true,
            autoclose: true,
            todayHighlight: true
        });

        let chart1 = Highcharts.chart('card-type-statistic', {
            chart: {
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false,
                type: 'pie'
            },
            title: {
                text: 'Số lượng bán hàng theo từng loại thẻ'
            },
            tooltip: {
                pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
            },
            plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: false
                    },
                    showInLegend: true
                }
            },
            series: [{
                name: 'Brands',
                colorByPoint: true,
                data: [{
                    name: 'Credit Card',
                    y: 10.38
                }, {
                    name: 'Debit Card',
                    y: 3.77
                }, {
                    name: 'American Express',
                    y: 0.91
                }, {
                    name: 'MasterCard',
                    y: 0.2
                }, {
                    name: 'Discover',
                    y: 1.0
                }]
            }]
        });

        let chart2 = Highcharts.chart('region-statistic', {
            chart: {
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false,
                type: 'pie'
            },
            title: {
                text: 'Tổng tiền trả hàng theo từng loại thẻ'
            },
            tooltip: {
                pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
            },
            plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: false
                    },
                    showInLegend: true
                }
            },
            series: [{
                name: 'Brands',
                colorByPoint: true,
                data: [{
                    name: 'Credit Card',
                    y: 5.38
                }, {
                    name: 'Debit Card',
                    y: 2.77
                }, {
                    name: 'American Express',
                    y: 5.91
                }, {
                    name: 'MasterCard',
                    y: 1.2
                }, {
                    name: 'Discover',
                    y: 1.0
                }]
            }]
        });
        let user = getUser();

        getAgentListFromMaster(user.master.id)
            .then((res) => {
                if (res.statusCode == 200) {
                    let agent_list = [{ value: null, text: "==Agent==" }];
                    res.data.forEach((element) => {
                        agent_list.push({
                            value: element.merchant_code,
                            text: element.merchant_name
                        });
                    });
                    _this.setState({
                        agent_list: agent_list
                    })
                } else {/*DO Nothing.*/ }
            })
            .catch((err) => {
            })

        displayLoading();
        getStatisticNormalDate("1970-01-01T00:00:00Z", "2017-12-01T00:00:00Z")
            .then((res) => {
                _this.setState({
                    statistic: res
                });
                hideLoading();
                getStatisticCardNormalDate("1970-01-01T00:00:00Z", "2017-12-01T00:00:00Z")
                    .then((res) => {
                        _this.setState({
                            statistic_card: res
                        });
                    }).catch((err) => {

                    });
            })
            .catch((err) => {
                hideLoading();
            });
    }

    render() {
        var _this = this;
        return (
            <div id="merchant-statistic">
                <div className="card">
                    <h3 className="card-header">Thống Kê Theo Merchant</h3>

                    <div className="card-block">
                        <h4 className="card-title">Thông Tin Tìm Kiếm</h4>
                        <form id="merchant_filter" name="merchant_filter">

                            <div className="form-group row">
                                <div className="col-sm-6 input-daterange">
                                    <input type="text" className="form-control datepicker from-date" name="form_date" id="form_date" placeholder="Từ Ngày" />
                                    <div className="input group-addon">to</div>
                                    <input type="text" className="form-control datepicker to-date" name="to_date" id="to_date" placeholder="Đến Ngày" />
                                </div>
                            </div>

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
                                <div className="col-sm-3">
                                    <BootstrapGroup type="select" name="agent_code"
                                        options={{
                                            element_only: true,
                                            options: this.state.agent_list
                                        }} />
                                </div>
                            </div>

                            <div className="form-group row">
                                <div className="col-sm-3">
                                    <BootstrapGroup type="select" name="report_type"
                                        options={{
                                            element_only: true,
                                            options: this.state.report_types
                                        }}
                                        attributes={{
                                            onChange: (event) => {
                                                if (!isNaN(event.target.value)) {
                                                    _this.setState({
                                                        report_type: event.target.value
                                                    })
                                                } else {
                                                    _this.setState({
                                                        report_type: null
                                                    })
                                                }
                                            }
                                        }}
                                    />
                                </div>
                                {this.state.report_type == 1 && <div className="col-sm-3">
                                    <BootstrapGroup type="select" name="monthly"
                                        options={{
                                            element_only: true,
                                            options: months
                                        }}
                                    />
                                </div>}
                                {this.state.report_type == 2 && <div className="col-sm-3">
                                    <BootstrapGroup type="select" name="quarterly"
                                        options={{
                                            element_only: true,
                                            options: quarters
                                        }}
                                    />
                                </div>}
                                {this.state.report_type && <div className="col-sm-3">
                                    <BootstrapGroup type="select" name="Yearly"
                                        options={{
                                            element_only: true,
                                            options: years
                                        }}
                                    />
                                </div>}
                            </div>

                            <button type="submit" className="btn btn-primary">Đồng ý</button>
                            &nbsp;
                            <button type="reset" className="btn btn-secondary">Làm mới</button>
                        </form>
                    </div>

                    <div className="horizontal-separator" />

                    <div className="card-block">
                        <h4 className="card-title">Biểu Đồ</h4>
                        <div className="row">
                            <div className="col-sm-6 card-type-statistic-wrap">
                                <div id="card-type-statistic"></div>
                            </div>
                            <div className="col-sm-6 region-statistic-wrap">
                                <div id="region-statistic"></div>
                            </div>
                        </div>
                        <div className="summary-list">
                            <div className="item">
                                <span className="title">Tổng Tiền Bán Hàng: </span>
                                <span className="value">300,000,000 VND</span>
                            </div>
                            <div className="item">
                                <span className="title">Tổng Số Lượng Bán Hàng: </span>
                                <span className="value">12,000</span>
                            </div>
                        </div>
                    </div>

                    <div className="horizontal-separator" />

                    <div className="card-block">
                        <h4 className="card-title">Thông Tin Chi Tiết</h4>
                        <div className="table-responsive">
                            <table className="table table-striped">
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Tên Merchant</th>
                                        <th>Tổng Tiền Bán Hàng</th>
                                        <th>Số Lượng Bán Hàng</th>
                                        <th>Tổng Tiền Trả Hàng</th>
                                        <th>Số Lượng Trả Hàng</th>
                                        <th>&nbsp;</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    {
                                        this.state.statistic
                                        &&
                                        this.state.statistic.map((element, key) => (
                                            <tr key={key}>
                                                <td>{element.merchant_code}</td>
                                                <td>{element.merchant_name}</td>
                                                <td>{element.total_amout_sale}</td>
                                                <td>{element.total_quantity_sale}</td>
                                                <td>{element.total_amout_return}</td>
                                                <td>{element.total_quantity_return}</td>
                                                <td>
                                                    <button type="button" data-toggle="tooltip" data-placement="bottom" title="Tìm kiếm" className="fa fa-search icon-button" aria-hidden="true"></button>
                                                    &nbsp;
                                            <button type="button" data-toggle="tooltip" data-placement="bottom" title="Chỉnh sửa thông tin" className="fa fa-pencil-square-o icon-button" aria-hidden="true"></button>
                                                    &nbsp;
                                            <button type="button" data-toggle="tooltip" data-placement="bottom" title="Xóa" className="fa fa-trash-o icon-button" aria-hidden="true"></button>
                                                </td>
                                            </tr>
                                        ))
                                    }
                                </tbody>
                            </table>
                        </div>
                    </div>

                    <div className="horizontal-separator" />

                    <div className="card-block">
                        <h4 className="card-title">Thông Tin Chi Tiết Theo Card</h4>
                        <div className="table-responsive">
                            <table className="table table-striped">
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Tên Merchant</th>
                                        <th>Loại Thẻ</th>
                                        <th>Tổng Tiền Bán Hàng</th>
                                        <th>Số Lượng Bán Hàng</th>
                                        <th>Tổng Tiền Trả Hàng</th>
                                        <th>Số Lượng Trả Hàng</th>
                                        <th>&nbsp;</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    {
                                        this.state.statistic_card
                                        &&
                                        this.state.statistic_card.map((element, key) => (
                                            <tr key={key}>
                                                <td>{element.merchant_code}</td>
                                                <td>{card_typs[element.card_type]}</td>
                                                <td>{element.total_amout_sale}</td>
                                                <td>{element.total_quantity_sale}</td>
                                                <td>{element.total_amout_return}</td>
                                                <td>{element.total_quantity_return}</td>
                                                <td>
                                                    <button type="button" data-toggle="tooltip" data-placement="bottom" title="Tìm kiếm" className="fa fa-search icon-button" aria-hidden="true"></button>
                                                    &nbsp;
                                            <button type="button" data-toggle="tooltip" data-placement="bottom" title="Chỉnh sửa thông tin" className="fa fa-pencil-square-o icon-button" aria-hidden="true"></button>
                                                    &nbsp;
                                            <button type="button" data-toggle="tooltip" data-placement="bottom" title="Xóa" className="fa fa-trash-o icon-button" aria-hidden="true"></button>
                                                </td>
                                            </tr>
                                        ))
                                    }
                                </tbody>
                            </table>
                        </div>
                    </div>

                </div>
            </div>
        );
    }
}

export default MerchantStatistic;