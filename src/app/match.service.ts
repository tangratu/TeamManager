import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {API_ENDPOINT} from  './apiURL';
import {Match} from './match';
import { Observable } from 'rxjs';
import {inject} from '@angular/core';
import {Router} from '@angular/router';


@Injectable({
  providedIn: 'root'
})
export class MatchService {

  httpOptions = {
   headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  
  router : Router = inject(Router);

 constructor(private http: HttpClient) { }
 
 
 getByDesig(name:string) : Observable<any> {
	 let httpOptionsAlt = {
		headers: new HttpHeaders({ 'Content-Type': 'application/json' }), params: {'desig' : name},
	 };
	 
	 return this.http.get(API_ENDPOINT+'/matches/info',httpOptionsAlt);
 }
 
}
