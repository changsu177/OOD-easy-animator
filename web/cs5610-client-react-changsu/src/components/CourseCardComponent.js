import React from "react";
import Dropdown from 'react-dropdown';
import 'react-dropdown/style.css';
import {Link} from "react-router-dom";
import {updateCourse} from "../services/CourseService";
const options = [
    'Delete', 'Edit'
];
const defaultOption = options[0];

export default class CourseCardComponent extends React.Component {
    state = {
        editing: false,
        course: this.props.course,
    }

    render() { return (
        <div className={"col-xs-12 col-sm-6 col-md-4 col-lg-3 col-xl-2"}>
            <div className="card">
                <img className="card-img-top"
                     src="https://picsum.photos/300/200"/>
                <div className="card-body">
                    {this.state.editing &&
                    <input
                        className="form-control"
                        onChange={(event) => {
                            const newTitle = event.target.value
                            this.setState(prevState => ({
                                course: {...prevState.course, title: newTitle}
                            }))}
                        }
                        value={this.state.course.title}/>
                    } {
                    !this.state.editing &&
                    <Link to={`/edit/${this.props.course._id}` } style={{ color: 'black' }} >{this.state.course.title}</Link>
                    }
                    <p className="card-text">Modified: {this.props.course.modified}</p>
                    <p className="card-text">Owner: {this.props.course.owner}</p>
                    <i className="fa fa-trash fa-lg"
                       onClick={() => this.props.deleteCourse(this.props.course)}
                       style={{marginRight : "15px"}}
                    >
                    </i>
                    {
                        !this.state.editing &&
                        <i className="fa fa-pencil fa-lg"
                           onClick={() => this.setState({editing: true})}
                        >
                        </i>
                    }

                    {
                        this.state.editing &&
                        <i className="fa fa-check fa-lg"
                           onClick={() => {
                               updateCourse(this.state.course._id, this.state.course)
                                   .then(status => this.setState({ editing: false}))
                           }}
                        >
                        </i>
                    }
                </div>
            </div>
        </div>
    )}}
