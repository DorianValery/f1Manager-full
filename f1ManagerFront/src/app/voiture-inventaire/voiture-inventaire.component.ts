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

  constructor(private appConfig: AppConfigService, private voitureInventaireService: VoitureInventaireService) { }

  ngOnInit(): void {
  }

  list(): Array<Voiture> {
    return this.voitureInventaireService.findAll();
  }

}
