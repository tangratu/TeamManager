import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import {Tournament} from '../tournament';
import {TournamentService} from '../tournament.service';
import {TournamentListingComponent} from '../tournament-listing/tournament-listing.component';
import {AsyncPipe} from '@angular/common';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-tournaments',
  imports: [RouterModule, TournamentListingComponent,AsyncPipe],
  templateUrl: './tournaments.component.html',
  styleUrl: './tournaments.component.css'
})
export class TournamentsComponent {
	tournaments$: Observable<Tournament[]>;	
	constructor(private ts: TournamentService){
		this.tournaments$=ts.fetchTournaments();
		
	}
	goTo(name: string) {
		this.ts.goToPage(name);
	}
}
