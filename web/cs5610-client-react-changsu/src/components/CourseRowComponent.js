import React from "react";
import {Link} from "react-router-dom";
import {updateCourse} from "../services/CourseService";
import "font-awesome/css/font-awesome.css";

export default class CourseRowComponent extends React.Component {
    state = {
        editing: false,
        course: this.props.course,
        style:{ backgroundColor: 'white'}

    }

    clickFunction = () => {
        if( this.state.style.backgroundColor === 'white' )
            this.setState( { style : { backgroundColor: "#007bff"} } )
        else
            this.setState( { style : { backgroundColor: 'white'} } )
    }



    render() {
        return(
            <tr id = "selected" onClick= { this.clickFunction } style={ this.state.style } >
                <td>
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
                    }
                    {
                        !this.state.editing &&
                        <Link to={`/edit/${this.props.course._id}` } style={{ color: 'black' }} >
                            <i className="fa fa-file-text-o" aria-hidden="true" style={{marginRight : "10px"}}/>
                        {this.state.course.title}</Link>
                    }
                </td>
                <td className={"d-none d-sm-table-cell"} > {this.props.course.owner}</td>
                <td  className={"d-none d-md-table-cell"}>{this.props.course.modified}</td>
                <td>
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
                </td>
            </tr>
        )
    }
}