import React from 'react';
import Actor from './Actor.js';

export default class ActorList extends React.Component {
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