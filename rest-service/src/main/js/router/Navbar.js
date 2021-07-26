import React from "react";
import { Link } from "react-router-dom";

export default class Navbar extends React.Component {
    render() {
        return(
            <div>
                <Link to="/">Actor</Link>
                <Link to="/About">About</Link>
            </div>
        )
    }
}