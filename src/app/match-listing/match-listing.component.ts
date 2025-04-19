import { Component, Input } from '@angular/core';
import {Match} from '../match';

@Component({
  selector: 'app-match-listing',
  imports: [],
  templateUrl: './match-listing.component.html',
  styleUrl: './match-listing.component.css'
})
export class MatchListingComponent {
	@Input({required: true,}) listing!: Match;

}
