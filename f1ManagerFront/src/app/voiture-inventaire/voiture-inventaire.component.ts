import { Component, OnInit, ɵclearResolutionOfComponentResourcesQueue } from '@angular/core';
import { AppConfigService } from '../app-config.service';
import { EcurieService } from '../ecurie/ecurie.service';
import { Ecurie, Inventaire, Voiture } from '../model';
import { VoitureInventaireService } from './voiture-inventaire.service';

@Component({
  selector: 'app-voiture-inventaire',
  templateUrl: './voiture-inventaire.component.html',
  styleUrls: ['./voiture-inventaire.component.scss']
})
export class VoitureInventaireComponent implements OnInit {

  choixVoiture: number = 1;
  voitures: Array<Voiture>=new Array<Voiture>();
  argent: number=this.ecurieService.ecurie.argent;

  constructor(private appConfig: AppConfigService, private voitureInventaireService: VoitureInventaireService, private ecurieService: EcurieService ) {

  }

  ngOnInit(): void {

  }

  list(): Array<Voiture> {

    return this.voitureInventaireService.findAll();
   
  }


  select(voiture: Voiture) {
    this.voitures.splice(this.choixVoiture, 1, voiture );
      }

  choixV(id: number) {
    this.choixVoiture = id;
  }

  valider()
  {
    this.ecurieService.ecurie.voitures=this.voitures;   
  }

  acheter(id: number){

      this.voitureInventaireService.findVoitureById(id).subscribe(response=>{
      if(this.ecurieService.ecurie.argent>response.prix)
    {
      this.ecurieService.ecurie.argent= this.ecurieService.ecurie.argent-response.prix;
      this.ecurieService.modify(this.ecurieService.ecurie);
      this.argent=this.ecurieService.ecurie.argent;

    }
    }, error => console.log(error))
  }
  
}
