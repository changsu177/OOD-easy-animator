import React from "react";
import {BrowserRouter, Route, Link} from "react-router-dom";
import CourseTableComponent from "./CourseTableComponent";
import CourseEditorComponent from "./CourseEditorComponent";
import CourseGridComponent from "./CourseGridComponent";
export class CourseManagerComponent extends React.Component {
    state = {
        courses: []
    }
    render() {
        return (
            <BrowserRouter>
                <div className="container">
                    <Link to="/coursesTable">Courses</Link> |
                    <Link to="/edit">Editor</Link> |
                    <Link to="/coursesGrid">Grid</Link>

                    <Route path="/coursesGrid" exact >
                        <CourseGridComponent courses={this.state.courses} instructor="Jose"/>
                    </Route>
                    <Route path="/coursesTable" exact>
                        <CourseTableComponent courses={this.state.courses} instructor="Jose"/>
                    </Route>
                    <Route
                        path="/edit/:courseId"
                        exact
                        component={CourseEditorComponent}/>
                </div>
            </BrowserRouter>
        );
    }
}