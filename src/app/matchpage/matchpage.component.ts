import { Component, Input } from '@angular/core';
import { Match } from '../match';
import {AsyncPipe} from '@angular/common';
import { Observable } from 'rxjs';
import {MatchService} from '../match.service';
import {inject} from '@angular/core';

@Component({
  selector: 'app-matchpage',
  imports: [AsyncPipe],
  templateUrl: './matchpage.component.html',
  styleUrl: './matchpage.component.css'
})
export class MatchpageComponent {
	 match$ : Observable<any>;
	 private ms = inject(MatchService);
	@Input() set desig(value : string) {
		
		this.match$ = this.ms.getByDesig(value);
		
	}
	
}
