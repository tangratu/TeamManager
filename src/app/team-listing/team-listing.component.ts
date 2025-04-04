import { Component, Input } from '@angular/core';
import {Team} from '../team';
@Component({
  selector: 'app-team-listing',
  imports: [],
  templateUrl: './team-listing.component.html',
  styleUrl: './team-listing.component.css'
})
export class TeamListingComponent {
	@Input({required: true,}) listing!: Team;
	@Input() player_count_max : number = 11;
}
