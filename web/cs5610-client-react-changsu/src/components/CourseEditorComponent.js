import React from "react";
import {findCourseById} from "../services/CourseService";
import WidgetListContainer from "../containers/WidgetListContainer";
import WidgetList from "./WidgetListComponent";
import ModuleListComponent from "./ModuleListComponent";
import LessonTabsComponent from "./LessonTabsComponent";
import TopicPillsComponent from "./TopicPillsComponent";

export default class CourseEditorComponent extends React.Component {

    state = {
        course: {
            _id: "",
            title: ""
        }
    }

    componentDidMount() {
        findCourseById(this.props.match.params.courseId)
            .then(actualCourse => this.setState({
                course: actualCourse
            }))
    }
    render() {
        return(
            <div className="container" style={{marginTop : "40px" }}>
                <nav className="navbar fixed-top navbar-expand-lg navbar-dark bg-dark">
                    <a className="wbdv-course-editor wbdv-close text-white" href="#">
                        <i className="fa fa-times pull-left fa-lg"></i>
                    </a>
                    <a className="navbar-brand wbdv-course-title " href="#">{this.state.course.title}</a>
                    <button className="navbar-toggler" type="button" data-toggle="collapse"
                            data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false"
                            aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse" id="navbarTogglerDemo01">
                        <LessonTabsComponent/>
                    </div>
                </nav>

                <div className="row"  >
                    <div className="col-4">
                        <ModuleListComponent/>
                    </div>
                    <div className="col-8">
                        <TopicPillsComponent/>
                    </div>
            </div>
            </div>
        )
    }
}