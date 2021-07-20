const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');

class App extends React.Component {

    constructor(props) {
		super(props);
		this.state = {actors: []};
	}

	componentDidMount() {
		client({method: 'GET', path: '/api/actors'}).done(response => {
			this.setState({actors: response.entity});
		});
	}

	render() {
		return (
			<ActorList actors={this.state.actors}/>
		)
	}
}

class ActorList extends React.Component{
	render() {
		const actors = this.props.actors.map(actor =>
			<Actor key={actor.id} actor={actor}/>
		);
		return (
			<table>
				<tbody>
					<tr>
						<th>ID</th>
						<th>FirstName</th>
						<th>LastName</th>
					</tr>
					{actors}
				</tbody>
			</table>
		)
	}
}

class Actor extends React.Component{
	render() {
		return (
			<tr>
				<td>{this.props.actor.id}</td>
				<td>{this.props.actor.firstName}</td>
				<td>{this.props.actor.lastName}</td>
			</tr>
		)
	}
}

ReactDOM.render(
	<App />,
	document.getElementById('react')
)