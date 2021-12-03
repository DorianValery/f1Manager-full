import { Component, OnInit } from '@angular/core';
import { EcurieService } from '../ecurie/ecurie.service';
import { JoueurDirective } from '../joueur/joueur.directive';


import { Ecurie, Joueur, Pilote } from '../model';
import { PiloteInventaireHttpService } from './pilote-inventaire-http.service';

@Component({
  selector: 'app-pilote-inventaire',
  templateUrl: './pilote-inventaire.component.html',
  styleUrls: ['./pilote-inventaire.component.scss']
})
export class PiloteInventaireComponent implements OnInit {
  //pilote: Pilote = null;
  joueur: Joueur;

  constructor(private piloteService: PiloteInventaireHttpService, private ecurieService: EcurieService, private joueurDirective: JoueurDirective) { }
  
  ngOnInit(): void {}

  list(): Array<Pilote> {
    return this.piloteService.findAll();
  }

  findJoueurEcurie(id:number){
    return this.joueurDirective.findEcurie(id);
  }

}
