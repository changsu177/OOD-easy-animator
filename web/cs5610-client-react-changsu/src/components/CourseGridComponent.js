import React from "react";
import {createCourse, findAllCourses, deleteCourse} from "../services/CourseService";
import CourseCardComponent from "./CourseCardComponent";
import {Link, Route} from "react-router-dom";
import CourseTableComponent from "./CourseTableComponent";

class CourseGridComponent extends React.Component {
    state = {
        courses: [],
        courseBeingEdited: {},
        newTitle : ""
    }
    componentDidMount() {
        findAllCourses()
            .then(courses => {
                this.setState({
                    courses: courses
                })
            })
    }

    deleteCourse = (course) => {
        deleteCourse(course._id)
            .then(status => this.setState(prevState =>({
                    courses: prevState.courses.filter(c => c._id !== course._id)
                })
            ))
            .catch(error => {

            })
    }

    addCourse = () => {
        const newCourse = {
            title: this.state.newTitle,
            owner: "me",
            modified: (new Date()).toDateString()
        }
        createCourse(newCourse)
            .then(actualCourse => this.setState(prevState => ({
                courses: [
                    ...prevState.courses, actualCourse
                ]
            })))
        document.getElementById("input").value = "";
        this.setState({ newTitle: {} })
    }


    editCourse = (course) => {
        this.setState({
            courseBeingEdited: course
        })
    }

    render() {
        return (
            <body style={{ paddingTop: "60px"}}>
            <nav className="navbar navbar-expand-lg fixed-top  navbar-dark bg-primary ml-auto">
                <button className="wbdv-field wbdv-hamburger btn">
                    <i className="fa fa-bars fa-2x" ></i>
                </button>
                <a className="navbar-brand wbdv-label wbdv-course-manager" href="#"> Course
                    Manager</a>
                <button className="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false"
                        aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
                <a className= "wbdv-sticky-add-course-button" style={{
                    position: "fixed",
                    right: "30px",
                    bottom: "30px"
                }}>
                    <i className="fa fa-plus-circle pull-right fa-3x" style={{color:"red"}} aria-hidden="true"/>
                </a>
                <div className="collapse navbar-collapse" id="navbarTogglerDemo02">
                    <ul className="navbar-nav mr-auto mt-2 mt-lg-0">
                        <li className="nav-item active">
                            <input
                                className="form-control"
                                id = "input"
                                size="100"
                                onChange={(event) => {
                                    const newTitle = event.target.value
                                    this.setState({newTitle: newTitle})}
                                }
                                placeholder={"New Course Title"}

                            />
                        </li>
                        <i className="fa fa-plus-circle pull-right fa-2x"
                           style={{color : "red"}}
                           aria-hidden="true" onClick={this.addCourse}>
                        </i>
                        <li className="nav-item">
                        </li>
                    </ul>
                </div>
            </nav>
            <div className={"row"}>
                <div className={"col"} style={ {marginRight : "400px"} }>
               Recent Document
             </div>
                <div className={"d-none d-xl-block d-lg-block d-md-none d-sm-none"} style={ {marginRight : "200px"} }>
                 <select>
                    <option value="Owned by me">Owned by me</option>
                    <option value="Owned by others">Owned by others</option>
                </select>
            </div>
                <Link to="/coursesTable"> <i className="fa fa-th"/></Link>
                <Route path="/coursesTable" exact >
                    <CourseTableComponent/>
                </Route>
            </div>

            <div>
                <div className= "card-deck">
                    { this.state.courses.map(course =>
                        <CourseCardComponent
                            deleteCourse={this.deleteCourse}
                            course={course}/>
                    )
                    }
                </div>
            </div>
            </body>

        );
    }
}

export default CourseGridComponent