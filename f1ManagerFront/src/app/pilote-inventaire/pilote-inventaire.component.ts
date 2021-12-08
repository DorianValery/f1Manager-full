import { Component, OnInit } from '@angular/core';
import { AppConfigService } from '../app-config.service';
import { EcurieService } from '../ecurie/ecurie.service';
import { InventaireService } from '../inventaire/inventaire.service';
import { JoueurService } from '../joueur/joueur.service';




import { Ecurie, Inventaire, Pilote } from '../model';
import { SeConnecterHttpService } from '../se-connecter/se-connecter-http.service';
import { PiloteInventaireHttpService } from './pilote-inventaire-http.service';
import { SeConnecterForm } from '../model';

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
  active:number=0;

  constructor(private appConfig: AppConfigService, private piloteService: PiloteInventaireHttpService,private ecurieService: EcurieService, private inventaireService: InventaireService, private joueurService: JoueurService) { 
   this.ecurie=this.ecurieService.ecurie;
   this.pilotes=this.ecurieService.ecurie.pilotes;
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

  //version 1

  /*acheter() {
    //verifier que le solde du pilote est suffisant
    if(this.ecurieService.ecurie.argent>this.piloteService.pilote.prix){
      this.ecurieService.ecurie.argent=this.ecurieService.ecurie.argent-this.piloteService.pilote.prix
      console.log(this.ecurieService.ecurie.argent)
      //save  
      if(this.pilote.id) {
          this.piloteService.pilote=this.pilote;
          this.ecurieService.modify(this.ecurieService.ecurie);
        }
    this.cancel();
  }*/

  //version 2
//   acheter(id: number){

//     this.piloteService.findPiloteById(id).subscribe(response=>{
//     if(this.ecurieService.ecurie.argent>response.prix)
//   {
//     this.ecurieService.ecurie.argent= this.ecurieService.ecurie.argent-response.prix;
//     this.ecurieService.modify(this.ecurieService.ecurie);
//     this.argent=this.ecurieService.ecurie.argent;

//   }
//   }, error => console.log(error))
// }



acheter(pilote: Pilote){
  if (this.ecurieService.ecurie.argent >= pilote.prix){
    this.ecurieService.ecurie.argent = this.ecurieService.ecurie.argent - pilote.prix;
    this.ecurieService.modify(this.ecurieService.ecurie);
    this.ecurie.argent = this.ecurieService.ecurie.argent;
    this.inventaireService.create(new Inventaire(null, null, this.joueurService.joueur, pilote)).subscribe(resp => {
      this.piloteService.load();
      this.active=pilote.id;
    }, error => console.log(error));
  }
}

cancel() {
    this.piloteForm = null;
  }

 
}
  


  // findJoueurEcurie(id:number){
  //   return this.joueurDirective.findEcurie(id);
  // }


