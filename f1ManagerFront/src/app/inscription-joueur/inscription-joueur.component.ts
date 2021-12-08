import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppConfigService } from '../app-config.service';
import { Compte, InscriptionDTO, Joueur } from '../model';
import { SeConnecterHttpService } from '../se-connecter/se-connecter-http.service';
import { InscriptionJoueurService } from './inscription-joueur.service';

@Component({
  selector: 'app-inscription-joueur',
  templateUrl: './inscription-joueur.component.html',
  styleUrls: ['./inscription-joueur.component.scss']
})
export class InscriptionJoueurComponent implements OnInit {

  inscriptionForm: InscriptionDTO = new InscriptionDTO();
  civilites: Array<String> = new Array<String>();

  constructor(private appConfig: AppConfigService, private inscriptionService: InscriptionJoueurService,private seConnecter: SeConnecterHttpService, private router: Router) {
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
    if (!this.inscriptionForm.id) {
      this.inscriptionService.create(this.inscriptionForm);
    } else {
      this.inscriptionService.modify(this.inscriptionForm);
    }
    this.router.navigate(['/seconnecter']);
    this.inscriptionForm = null;
  }
  cancel() {
    this.router.navigate(['/seconnecter']);
    this.inscriptionForm = null;
  }
  listCompte(): Array<Compte> {
    return this.seConnecter.findAll();
  }
  

}
