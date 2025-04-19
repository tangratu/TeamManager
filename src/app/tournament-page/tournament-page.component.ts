import { Component,Input } from '@angular/core';
import {Tournament} from '../tournament';
import {TournamentService} from '../tournament.service';
import { Observable } from 'rxjs';
import {ActivatedRoute} from '@angular/router';
import {AsyncPipe} from '@angular/common';
import {MatchListingComponent} from '../match-listing/match-listing.component';
import {Match} from '../match';


@Component({
  selector: 'app-tournament-page',
  imports: [AsyncPipe,MatchListingComponent],
  templateUrl: './tournament-page.component.html',
  styleUrl: './tournament-page.component.css'
})
export class TournamentPageComponent {
	currTour$ : Observable<Tournament>;
	matches$ : Observable<Match[]>;
	constructor(private ts: TournamentService, private activatedRoute : ActivatedRoute) {
		this.currTour$ = ts.getByName(String(this.activatedRoute.snapshot.params['name']));
		//this.currTour$.subscribe(tourney => this.matches$ = ts.getMatchesOfTournament(tourney.t_name));
		this.matches$ = ts.getMatchesOfTournament((String(this.activatedRoute.snapshot.params['name'])));
		
				
	}
	goTo(param : string) {
		
		
		this.ts.goToMatch(param);
	}

}
