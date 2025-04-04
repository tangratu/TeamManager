import { Component,Input } from '@angular/core';
import {Team} from '../team';
import {TeamsService} from '../teams.service';
import { Observable } from 'rxjs';
import {ActivatedRoute} from '@angular/router';
import {AsyncPipe} from '@angular/common';

@Component({
  selector: 'app-teampage',
  imports: [AsyncPipe],
  templateUrl: './teampage.component.html',
  styleUrl: './teampage.component.css'
})
export class TeampageComponent {
	currTeam$ : Observable<Team>;
	
	constructor(private ts: TeamsService, private activatedRoute : ActivatedRoute) {
		this.currTeam$ = ts.getByName(String(this.activatedRoute.snapshot.params['name']));
		
	}
	
	

}
