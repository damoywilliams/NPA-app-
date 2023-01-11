import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Game } from './game';
import { NbaService } from './nba.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})


export class AppComponent implements OnInit {

  constructor(private nbaService : NbaService){}
  title = 'NBA-APP';

  public Games!: Game[]; 

ngOnInit(){

this.getGames();
console.log(this.Games)
}


public getGames():void{
this.nbaService.getLiveGames().subscribe(
(response: Game[])=>{this.Games=response; console.log(response)},
(error:HttpErrorResponse)=>{alert(error);}

);

}

}
