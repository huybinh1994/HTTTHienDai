import React from 'react';
import { render } from 'react-dom';

const App = (props) => (
    <div className="app-container">
        Hello World!
    </div>
);

render(
    <App />, document.getElementById('root')
);