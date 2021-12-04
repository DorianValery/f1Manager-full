import { Component, OnInit } from '@angular/core';
import { AppConfigService } from '../app-config.service';
import { Ecurie, Voiture } from '../model';
import { VoitureInventaireService } from './voiture-inventaire.service';

@Component({
  selector: 'app-voiture-inventaire',
  templateUrl: './voiture-inventaire.component.html',
  styleUrls: ['./voiture-inventaire.component.scss']
})
export class VoitureInventaireComponent implements OnInit {

  ecurie: Ecurie;
  choixVoiture: number = 1;

  constructor(private appConfig: AppConfigService, private voitureInventaireService: VoitureInventaireService) {
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
    this.ecurie.voitures[this.choixVoiture] = voiture;
      }

  choixV(id: number) {
    this.choixVoiture = id;
  }

  valider()
  {
    this.voitureInventaireService.saveEcurie(this.ecurie);
  }
}
