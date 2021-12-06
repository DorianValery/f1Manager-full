import { Component, OnInit } from '@angular/core';
import { AppConfigService } from '../app-config.service';
import { Joueur } from '../model';
import { InscriptionJoueurService } from './inscription-joueur.service';

@Component({
  selector: 'app-inscription-joueur',
  templateUrl: './inscription-joueur.component.html',
  styleUrls: ['./inscription-joueur.component.scss']
})
export class InscriptionJoueurComponent implements OnInit {

  joueurForm: Joueur = null;
  civilites: Array<String> = new Array<String>();

  constructor(private appConfig: AppConfigService, private inscriptionService: InscriptionJoueurService) {
    this.loadCivilites();
  }

  ngOnInit(): void {
  }

  loadCivilites() {
    this.appConfig.findAllCivilites().subscribe(resp => {
      this.civilites = resp;
    }, err => console.log(err));
  }

  save() {
    if (!this.joueurForm.id) {
      this.inscriptionService.create(this.joueurForm);
    } else {
      this.inscriptionService.modify(this.joueurForm);
    }
    this.joueurForm = null;
  }

  cancel() {
    this.joueurForm = null;
  }

}
