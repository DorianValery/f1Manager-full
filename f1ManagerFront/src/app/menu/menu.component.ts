import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppConfigService } from '../app-config.service';
import { EcurieService } from '../ecurie/ecurie.service';
import { Ecurie, Pilote } from '../model';
import { MenuHttpService } from './menu-http.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})
export class MenuComponent implements OnInit {


  
 piloteTest : Pilote;
 ecurie : Ecurie =  this.ecurieService.ecurie;

  constructor(private appConfig: AppConfigService,  private menuService : MenuHttpService, private ecurieService : EcurieService) {
   
   }

findPilote(id : number) {
  this.menuService.findPiloteById(id).subscribe(resp =>{
    this.piloteTest = resp;
  },error=> console.log(error))
}

list(): Array<Pilote> {
  return this.menuService.findAllPilote();
}

findEcurie(id : number) {
  this.menuService.findEcurieById(id).subscribe(resp =>{
    this.ecurie = resp;
  },error=> console.log(error))
}



  ngOnInit(): void {
  }

}
