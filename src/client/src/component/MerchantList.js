import React, { Component } from 'react';
import { BootstrapGroup } from './CustomFields.js';

//Test data.
import { locations, Messages, merchantTypes, reportTypes } from '../../test/DataSource.js';

class MerchantList extends Component {

    constructor(props) {
        super(props);
        this.state = {
            regions: null,
            merchant_types: null,
            report_types: null
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
        $(".datepicker").datepicker({
            "format": "yyyy-mm-dd",
            calendarWeeks: true,
            autoclose: true,
            todayHighlight: true
        });

        Highcharts.chart('card-type-statistic', {
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

        Highcharts.chart('region-statistic', {
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

        $('[data-toggle="tooltip"]').tooltip();
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
                                <div className="col-sm-6 input-daterange">
                                    <input type="text" className="form-control datepicker from-date" name="form_date" id="form_date" placeholder="Từ Ngày" />
                                    <div className="input group-addon">to</div>
                                    <input type="text" className="form-control datepicker to-date" name="to_date" id="to_date" placeholder="Đến Ngày" />
                                </div>
                            </div>
                            <div className="form-group row">
                                <div className="col-sm-3">
                                    <BootstrapGroup type="text" name="search_string"
                                        options={{
                                            element_only: true
                                        }}
                                        attributes={{
                                            placeholder: "Thông Tin Merchant"
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
                                    <BootstrapGroup type="select" name="report_type"
                                        options={{
                                            element_only: true,
                                            options: this.state.report_types
                                        }}
                                        attributes={{
                                            onChange: (event) => {
                                                console.log(event.target.value);
                                                if (event.target.value) {
                                                    $("#merchant_filter").find(".form-control").attr("disabled", true);
                                                } else {
                                                    $("#merchant_filter").find(".form-control").attr("disabled", false);
                                                }
                                            }
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
                                        <th>Tổng Doanh Thu</th>
                                        <th>Số Lượng Hàng</th>
                                        <th>&nbsp;</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>1,001</td>
                                        <td>Lorem</td>
                                        <td>250.000.000 VND</td>
                                        <td>120.015</td>
                                        <td>
                                            <button type="button" data-toggle="tooltip" data-placement="bottom" title="Tìm kiếm" className="fa fa-search icon-button" aria-hidden="true"></button>
                                            &nbsp;
                                            <button type="button" data-toggle="tooltip" data-placement="bottom" title="Chỉnh sửa thông tin" className="fa fa-pencil-square-o icon-button" aria-hidden="true"></button>
                                            &nbsp;
                                            <button type="button" data-toggle="tooltip" data-placement="bottom" title="Xóa" className="fa fa-trash-o icon-button" aria-hidden="true"></button>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>

                </div>
            </div>
        );
    }
}

export default MerchantList;