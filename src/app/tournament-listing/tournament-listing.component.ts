import { Component, Input } from '@angular/core';
import {Tournament} from '../tournament';

@Component({
  selector: 'app-tournament-listing',
  imports: [],
  templateUrl: './tournament-listing.component.html',
  styleUrl: './tournament-listing.component.css'
})
export class TournamentListingComponent {
	@Input({required: true,}) listing!: Tournament;

}
