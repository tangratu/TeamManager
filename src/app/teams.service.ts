import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {API_ENDPOINT} from  './apiURL';
import {Team} from './team';
import { Observable } from 'rxjs';
import {inject} from '@angular/core';
import {Router} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class TeamsService {
	httpOptions = {
   headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  router : Router = inject(Router);

 constructor(private http: HttpClient) { }
 
 fetchTeams() : Observable<any> {
	 return this.http.get(API_ENDPOINT+'/teams/All',this.httpOptions);
	}
 getByName(name:string) : Observable<any> {
	 return this.http.get(API_ENDPOINT+'/teams/'+name,this.httpOptions);
 }
 goToPage(name: string): void {
	 this.router.navigate(['/index/teampage/'+name]);
    }
}

