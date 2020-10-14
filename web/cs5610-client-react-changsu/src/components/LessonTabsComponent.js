import React from "react";

export default class LessonTabsComponent extends React.Component {
    render() { return(
        <ul className="wbdv-lesson-tabs navbar-nav mr-auto mt-2 mt-lg-0">
            <li className="nav-item active">
                <a className="nav-link" href="#">Build <span className="sr-only">(current)</span></a>
            </li>
            <li className="nav-item">
                <a className="nav-link" href="#">Pages</a>
            </li>
            <li className="nav-item">
                <a className="nav-link" href="#">Theme</a>
            </li>
            <li className="nav-item">
                <a className="nav-link" href="#">Store</a>
            </li>
            <li className="nav-item">
                <a className="nav-link" href="#">Apps</a>
            </li>
            <li className="nav-item">
                <a className="nav-link" href="#">Settings</a>
            </li>
            <li className="nav-item">
                <a className="wbdv-lesson-add-btn nav-link" href="#">
                    <i className="fa fa-plus fa-lg"></i>
                </a>
            </li>
        </ul>
    )
    }

}