"use strict";
const debug = process.env.NODE_ENV !== "development";

//webpack.config.js
var webpack = require('webpack');
var path = require('path');

module.exports = {
    entry: path.join(__dirname, 'src', 'app.js'),
    output: {
        path: path.join(__dirname, 'dist'),
        filename: 'main.js'
    },
    // devtool: 'source-map',
    module: {
        rules: [
            {
                test: /\.jsx?$/,
                loader: 'babel-loader',
                exclude: /node_modules/,
                options: {
                    presets: ["es2015", "react"],
                    cacheDirectory: path.join(__dirname, 'dist', 'babel_cache'),
                }
            },
            {
                test: /\.(sass|scss|css)$/,
                use: [
                    'style-loader',
                    'css-loader',
                    'sass-loader',
                ]
            }
        ]
    },
    plugins: []
};
