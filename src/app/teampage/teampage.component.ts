import { Component,Input } from '@angular/core';
import {Team} from '../team';
import {TeamsService} from '../teams.service';
import { Observable } from 'rxjs';
import {ActivatedRoute} from '@angular/router';
import {AsyncPipe} from '@angular/common';
import {User} from '../User';

@Component({
  selector: 'app-teampage',
  imports: [AsyncPipe],
  templateUrl: './teampage.component.html',
  styleUrl: './teampage.component.css'
})
export class TeampageComponent {
	currTeam$ : Observable<Team>;
	players$ : Observable<User[]>;
	obsrole : string;
	hasTeam: boolean;
	
	constructor(private ts: TeamsService, private activatedRoute : ActivatedRoute) {
		this.currTeam$ = ts.getByName(String(this.activatedRoute.snapshot.params['name']));
		this.players$ = ts.getPlayersOfTeam(String(this.activatedRoute.snapshot.params['name']));
        this.obsrole = (String(sessionStorage.getItem("role")));
		this.hasTeam = ((String(sessionStorage.getItem("team"))) != "none");		
	}
	becomeManager() : void {
		var m = { "uname": (String(sessionStorage.getItem("username"))),"teamName":(String(sessionStorage.getItem("team")))};
		this.ts.manageTeam(m);
	}		

}
