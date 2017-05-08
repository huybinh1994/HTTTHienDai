import React, { Component } from 'react';

class Overview extends Component {

    constructor(props) {
        super(props);
    }

    componentDidMount() {
        Highcharts.chart('merchant-sales', {
            chart: {
                type: 'line'
            },
            title: {
                text: 'Doanh Thu Trong Vòng 12 Tháng Của Các Merchant'
            },
            subtitle: {
                text: 'LTVO Cop'
            },
            xAxis: {
                categories: ['Th 1', 'Th 2', 'Th 3', 'Th 4', 'Th 5', 'Th 6', 'Th 7', 'Th 8', 'Th 9', 'Th 10', 'Th 11', 'Th 12']
            },
            yAxis: {
                title: {
                    text: 'Triệu (vnd)'
                }
            },
            plotOptions: {
                line: {
                    dataLabels: {
                        enabled: true
                    },
                    enableMouseTracking: false
                }
            },
            series: [{
                name: 'B\'s Mart',
                data: [7.0, 6.9, 9.5, 14.5, 18.4, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6]
            }, {
                name: 'Cricle K',
                data: [3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8]
            }]
        });
    }

    render() {
        return (
            <div id="overview">
                <h1>Tổng Quan</h1>
                <div id="merchant-sales"></div>
            </div>
        );
    }
}

export default Overview;