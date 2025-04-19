import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {API_ENDPOINT} from  './apiURL';
import {Tournament} from './tournament';
import { Observable } from 'rxjs';
import {inject} from '@angular/core';
import {Router} from '@angular/router';


@Injectable({
  providedIn: 'root'
})
export class TournamentService {

  httpOptions = {
   headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  router : Router = inject(Router);

 constructor(private http: HttpClient) { }
 
 fetchTournaments() : Observable<any> {
	 return this.http.get(API_ENDPOINT+'/tournaments/all',this.httpOptions);
	}
 getByName(name:string) : Observable<any> {
	 return this.http.get(API_ENDPOINT+'/tournaments/'+name,this.httpOptions);
 }
 goToPage(name: string): void {
	 this.router.navigate(['/index/tournamentpage/'+name]);
    }
 getMatchesOfTournament(name : string) : Observable<any>{
	 return this.http.get(API_ENDPOINT+'/tournaments/matchesOf/'+name,this.httpOptions);
 }
 goToMatch(des : string) : void {
	 
	 this.router.navigate(['/index/matchpage'], {queryParams: {desig: des}});
 }
 
 /* getPlayersOfTeam(name:string) : Observable<any> {
	 return this.http.get(API_ENDPOINT+'/teams/getPlayers/'+name,this.httpOptions);
 } */
}
