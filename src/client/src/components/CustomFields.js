import React, { Component } from 'react';
import PropTypes from 'prop-types';

export class BootstrapGroup extends Component {
    render() {
        let element = null;
        let options = Object.assign({}, this.props.options);

        let groupClasses = options.group_classes ? options.group_classes : "form-group row";
        let wrapClasses = options.wrap_classes ? options.wrap_classes : "col-sm-10";
        let labelClasses = options.label_classes ? options.label_classes : "col-sm-2 col-form-label";

        let postElement = options.post_element ? options.post_element : null;

        let elementOnly = options.element_only ? options.element_only : false;

        if (this.props.type === "text" || this.props.type === "password") {
            let className = this.props.className ? "form-control " + this.props.attributes.className : "form-control";
            element = <input type={this.props.type} {...this.props.attributes} className={className} id={this.props.name} name={this.props.name} maxLength={this.props.maxLength ? this.props.maxLength : 500} />;
        } else if (this.props.type === "select") {
            let className = this.props.className ? "form-control " + this.props.attributes.className : "form-control";
            element =
                <select {...this.props.attributes} className={className} id={this.props.name} name={this.props.name}>
                    {
                        options.options && options.options.map((item, i) => (
                            <option value={item.value} key={i}>{item.text}</option>
                        ))
                    }
                </select>;
        } else if (this.props.type === "date") {
            let className = this.props.className ? "form-control " + this.props.attributes.className : "form-control";
            element = <input type={this.props.type} {...this.props.attributes} className={className} id={this.props.name} name={this.props.name} />;
        }

        if (elementOnly) {
            return (
                element
            )
        } else {
            return (
                <div className={groupClasses}>
                    {this.props.label && <label htmlFor={this.props.name} className={labelClasses}>{this.props.label}{this.props.required ? <span className="required-simple">*</span> : ""}</label>}
                    <div className={wrapClasses}>{element}</div>
                    {postElement}
                </div>
            )
        }
    }
}
BootstrapGroup.propTypes = {
    //Required props
    name: PropTypes.string.isRequired,
    type: PropTypes.string.isRequired,
    label: PropTypes.string,

    //Optional props
    attributes: PropTypes.object,
    options: PropTypes.object,
    required: PropTypes.bool,
    className: PropTypes.string,
    maxLength: PropTypes.number
}
