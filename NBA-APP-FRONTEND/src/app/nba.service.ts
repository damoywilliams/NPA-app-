import { Injectable } from '@angular/core';
import { Game } from './game'
import {HttpClient} from'@angular/common/http'
import { environment } from './environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NbaService {

  private apiServerUrl= environment.apiBaseUrl


  constructor(private http: HttpClient) { }  
  


  public getLiveGames(): Observable<Game[]>{    // returning an array of game 

    return this.http.get<Game[]>(`${this.apiServerUrl}/client/live`)



  }



}
