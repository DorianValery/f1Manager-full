import { Component, OnInit } from '@angular/core';
import { AppConfigService } from '../app-config.service';
import { EcurieService } from '../ecurie/ecurie.service';




import { Ecurie, Pilote } from '../model';
import { PiloteInventaireHttpService } from './pilote-inventaire-http.service';

@Component({
  selector: 'app-pilote-inventaire',
  templateUrl: './pilote-inventaire.component.html',
  styleUrls: ['./pilote-inventaire.component.scss']
})
export class PiloteInventaireComponent implements OnInit {
  //pilote: Pilote = null;
  ecurie: Ecurie;
  choixPilote: number = 1;
  pilotes: Array<Pilote>=new Array<Pilote>()
  piloteForm:Pilote;
  argent: number;
  prix : number;
  pilote : Pilote;

  constructor(private appConfig: AppConfigService, private piloteService: PiloteInventaireHttpService,private ecurieService: EcurieService) { 
    this.listPilotesEcurie(1);
  }
  
  ngOnInit(): void {}

  list(): Array<Pilote> {
    return this.piloteService.findAll();
  }

  listPilotesEcurie(id: number) {
    this.piloteService.loadEcurie(id).subscribe(response => {
      this.ecurie = response;
      }, error => console.log(error));
  }

  select(pilote: Pilote) {
    this.pilotes.splice(this.choixPilote, 1, pilote );
      }

  choixV(id: number) {
    this.choixPilote = id;
  }

  valider()
  {
    this.ecurieService.ecurie.pilotes=this.pilotes;
    console.log(this.pilotes);
    console.log(this.ecurieService.ecurie);
  }

  acheter() {
    //verifier que le solde du pilote est suffisant
    if(this.ecurieService.ecurie.argent>this.piloteService.pilote.prix){
      this.ecurieService.ecurie.argent=this.ecurieService.ecurie.argent-this.piloteService.pilote.prix
      console.log(this.ecurieService.ecurie.argent)
      //save  
      if(this.pilote.id) {
          this.piloteService.pilote=this.pilote;
        }
    this.cancel();
  }
}
  cancel() {
    this.piloteForm = null;
  }


  // findJoueurEcurie(id:number){
  //   return this.joueurDirective.findEcurie(id);
  // }

}
