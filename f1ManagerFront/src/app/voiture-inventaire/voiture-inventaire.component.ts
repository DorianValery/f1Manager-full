import { Component, OnInit } from '@angular/core';
import { Voiture } from '../model';
import { VoitureInventaireService } from './voiture-inventaire.service';

@Component({
  selector: 'app-voiture-inventaire',
  templateUrl: './voiture-inventaire.component.html',
  styleUrls: ['./voiture-inventaire.component.scss']
})
export class VoitureInventaireComponent implements OnInit {

  constructor(private voitureInventaireService: VoitureInventaireService) { }

  ngOnInit(): void {
  }

  list(): Array<Voiture> {
    return this.voitureInventaireService.findAll();
  }

}
