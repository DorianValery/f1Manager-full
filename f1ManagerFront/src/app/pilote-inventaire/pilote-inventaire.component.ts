import { Component, OnInit } from '@angular/core';
import { Pilote } from '../model';
import { PiloteInventaireHttpService } from './pilote-inventaire-http.service';

@Component({
  selector: 'app-pilote-inventaire',
  templateUrl: './pilote-inventaire.component.html',
  styleUrls: ['./pilote-inventaire.component.scss']
})
export class PiloteInventaireComponent implements OnInit {
  //pilote: Pilote = null;

  constructor(private piloteService: PiloteInventaireHttpService) { }
  
  ngOnInit(): void {}

  list(): Array<Pilote> {
    return this.piloteService.findAll();
  }

}
