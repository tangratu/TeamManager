import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import {Team} from '../team';
import {TeamsService} from '../teams.service';
import {TeamListingComponent} from '../team-listing/team-listing.component';
import {AsyncPipe} from '@angular/common';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-teams',
  imports: [RouterModule, TeamListingComponent,AsyncPipe],
  templateUrl: './teams.component.html',
  styleUrl: './teams.component.css'
})
export class TeamsComponent {
	teams$: Observable<Team[]>;	
	constructor(private ts: TeamsService){
		this.teams$=ts.fetchTeams();
		
	}
	goTo(name: string) {
		this.ts.goToPage(name);
	}
	

}
