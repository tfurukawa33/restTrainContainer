import React from 'react';
import { BrowserRouter as Router, Route } from 'react-router-dom';
import Navbar from './router/Navbar.js';
import ReactDOM from 'react-dom';
import client from './client';
import ActorList from './components/ActorList.js';

class App extends React.Component {
    constructor(props) {
		super(props);
		this.state = {actors: []};
	}

	componentDidMount() {
		client({method: 'GET', path: '/actor/all'}).done(response => {
			this.setState({actors: response.entity.content});
		});
	}

	render() {
		return (
			<div className="App">
				<Router>
					<div>
						<Navbar /><hr/>
					</div>
				</Router>
				<ActorList actors={this.state.actors}/>
			</div>
		)
	}
}

ReactDOM.render(
	<App />,
	document.getElementById('react')
)