import React from 'react';
import ReactDOM from 'react-dom';
import "bootstrap/dist/css/bootstrap.min.css"
import App from './App';
import CourseTableComponent from "./components/CourseTableComponent";
import * as serviceWorker from './serviceWorker';
import {CourseManagerComponent} from "./components/CourseManagerComponent";
import {combineReducers, createStore} from "redux";
import {Provider} from "react-redux";
import Counter from "./components/Counter";
import CounterContainer from "./containers/CounterContainer";
import fsm from "./reducers/fsm"
import widgetsReducer from "./reducers/widgetsReducer";
import "bootstrap/dist/css/bootstrap.css";
import ModuleListComponent from "./components/ModuleListComponent";

const reducers = combineReducers({
    fsm, widgetsReducer
})
const store = createStore(reducers)
ReactDOM.render(
    <Provider store={store}>
        <CourseManagerComponent/>
    </Provider>
    ,
    document.getElementById('root')
);

serviceWorker.unregister();