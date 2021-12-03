import { Component, OnInit } from '@angular/core';
import { EcurieService } from '../ecurie/ecurie.service';



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

  constructor(private piloteService: PiloteInventaireHttpService, private ecurieService: EcurieService) { }
  
  ngOnInit(): void {}

  list(): Array<Pilote> {
    return this.piloteService.findAll();
  }

  // findJoueurEcurie(id:number){
  //   return this.joueurDirective.findEcurie(id);
  // }

}
