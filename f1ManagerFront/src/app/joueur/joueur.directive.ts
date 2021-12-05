import { Directive } from '@angular/core';
import { AppConfigService } from '../app-config.service';
import { EcurieService } from '../ecurie/ecurie.service';

import { Ecurie, Joueur } from '../model';
import { JoueurService } from './joueur.service';


@Directive({
  selector: '[appJoueur]'
})
export class JoueurDirective {
  joueur: Joueur;
  ecurie: Ecurie;

constructor(private appConfig: AppConfigService, private joueurService: JoueurService, private ecurieService: EcurieService) { 
}

ngOnInit(): void {
}

list(): Array<Joueur> {
  return this.joueurService.findAll();
}
/*
listEcurie(): Array<Ecurie> {
  return this.ecurieService.findAll();
}

listEcurieById(id:number){
  return this.ecurieService.findById(id).subscribe(resp =>{
    this.ecurie = resp;
  },error=> console.log(error))
}

findEcurie(id : number) {
  this.joueurService.findEcurieById(id).subscribe(resp =>{
    this.ecurie = resp;
  },error=> console.log(error))
} 

listEcurieByArgent(argent:number){
  return this.ecurieService.findById(argent);
}*/

}
