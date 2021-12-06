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

  ecurie: Ecurie;
  choixVoiture: number = 1;
  voitures: Array<Voiture>=new Array<Voiture>();


  constructor(private appConfig: AppConfigService, private voitureInventaireService: VoitureInventaireService, private ecurieService: EcurieService ) {
    this.listVoituresEcurie(1);
  }

  ngOnInit(): void {
  }

  list(): Array<Voiture> {
    return this.voitureInventaireService.findAll();
    
  }

  listVoituresEcurie(id: number) {
    this.voitureInventaireService.loadEcurie(id).subscribe(response => {
      this.ecurie = response;
      }, error => console.log(error));
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
    console.log(this.voitures);
    console.log(this.ecurieService.ecurie);
    
  }


  
}
