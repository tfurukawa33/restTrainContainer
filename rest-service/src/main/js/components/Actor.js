import React from 'react';

export default class Actor extends React.Component {
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
