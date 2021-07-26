import React from 'react';

export default class Film extends React.Component {
	render() {
		return (
			<tr>
                <td>{this.props.film.id}</td>
                <td>{this.props.film.title}</td>
                <td>{this.props.film.releaseYear}</td>
                <td>{this.props.film.length}</td>
                <td>{this.props.film.categories[0].name}</td>
                <td>{this.props.film.description}</td>
			</tr>
		)
	}
}