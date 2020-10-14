import React from "react";
import CourseRowComponent from "./CourseRowComponent";
import {findAllCourses, updateCourse, deleteCourse, createCourse} from "../services/CourseService";
import CourseGridComponent from "./CourseGridComponent";
import {Link, Route} from "react-router-dom";


class CourseTableComponent extends React.Component {

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
            ));
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
            <a className= "wbdv-sticky-add-course-button" style={{
                position: "fixed",
                right: "30px",
                bottom: "30px"
            }}>
                <i className="fa fa-plus-circle pull-right fa-3x" style={{color:"red"}} aria-hidden="true"/>
            </a>
            <div>
                <table className="table" >
                    <thead>
                    <tr>
                        <th scope="col">Title</th>
                        <th className={"d-none d-sm-table-cell"}  scope="col">Owned by</th>
                        <th className={"d-none d-md-table-cell"} scope="col">Last Modified</th>
                        <th scope="col">
                            <Link to="/coursesGrid"> <i className="fa fa-th"/></Link>
                            <Route path="/coursesGrid" exact >
                                <CourseGridComponent/>
                            </Route>
                            <i className="fas fa-sort-alpha-up"/>
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                    this.state.courses.map(course =>
                        <CourseRowComponent
                            deleteCourse={this.deleteCourse}
                            course={course}

                        />
                      )
                    }

                    </tbody>
                </table>
            </div>
    </body>

        );
    }
}

export default CourseTableComponent