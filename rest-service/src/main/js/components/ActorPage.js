import React from 'react';
import Film from './Film.js';

export default class ActorPage extends React.Component {
    render() {
        const films = this.props.actors.films.map(film =>
            <Film key={film.id} film={actor}/>
        );
        return (
            <div>
                <h1>{this.props.actor.firstName} + {this.props.actor.lastName}</h1>
                <table>
                    <tbody>
                        <tr>
                            <th>ID</th>
                            <th>Title</th>
                            <th>Year</th>
                            <th>Length</th>
                            <th>Category</th>
                            <th>Description</th>
                        </tr>
                        {films}
                    </tbody>
                </table>
            </div>
        )
    }
}