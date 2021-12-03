import { Component, OnInit } from '@angular/core';
import { AppConfigService } from '../app-config.service';
import { Voiture } from '../model';
import { VoitureInventaireService } from './voiture-inventaire.service';

@Component({
  selector: 'app-voiture-inventaire',
  templateUrl: './voiture-inventaire.component.html',
  styleUrls: ['./voiture-inventaire.component.scss']
})
export class VoitureInventaireComponent implements OnInit {

  voituresEcurie: Array<Voiture>;

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
      this.voituresEcurie = response.voitures;
      console.log(this.voituresEcurie);
    }, error => console.log(error));
  }


}
