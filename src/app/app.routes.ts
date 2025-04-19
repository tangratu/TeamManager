import { Routes } from '@angular/router';
import {LoginComponent} from './login/login.component';
import {RegistrationComponent} from './registration/registration.component';
import {HomepageComponent} from './homepage/homepage.component';
import {basicGuardGuard} from './basic-guard.guard';
import {basicGuardChildGuard} from './basic-guard-child.guard';
import {TeamsComponent} from './teams/teams.component';
import {TournamentsComponent} from './tournaments/tournaments.component';
import {TeampageComponent} from './teampage/teampage.component';
import {ErrorPageComponent} from './error-page/error-page.component';
import {TournamentPageComponent} from './tournament-page/tournament-page.component';
import {MatchpageComponent} from './matchpage/matchpage.component';

export const routes: Routes = [
	{path: 'login', component: LoginComponent},
	{path: 'error', component: ErrorPageComponent},
	{path: 'registration', component: RegistrationComponent},
	{path: 'index', component: HomepageComponent, canActivate: [basicGuardGuard], canActivateChild: [basicGuardChildGuard], children: [
		{path: 'teams', component: TeamsComponent,},
		{path: 'teampage/:name', component: TeampageComponent},
		{path: 'teampage', redirectTo:'/error', pathMatch:'full'},
		{path: 'tournaments', component: TournamentsComponent},
		{path: 'tournamentpage/:name', component: TournamentPageComponent},
		{path: 'tournamentpage', redirectTo:'/error', pathMatch:'full'},
		{path: 'matchpage',component: MatchpageComponent},
	]},
	{path: '**', redirectTo:'/registration', pathMatch:'full'},
	
	
];
