
import { Component, OnInit } from '@angular/core';

import { AppConfigService } from '../app-config.service';
import { Pilote } from '../model';
import { MenuHttpService } from './menu-http.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})
export class MenuComponent implements OnInit {

 piloteTest : Pilote;

  constructor(private appConfig: AppConfigService,  private menuService : MenuHttpService) {
  
   }

findPilote(id : number) {
  this.menuService.findPiloteById(id).subscribe(resp =>{
    this.piloteTest = resp;
  },error=> console.log(error))
}

list(): Array<Pilote> {
  return this.menuService.findAllPilote();
}



  ngOnInit(): void {
  }

}
