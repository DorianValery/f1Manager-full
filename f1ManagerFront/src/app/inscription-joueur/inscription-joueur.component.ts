import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppConfigService } from '../app-config.service';
import { Compte, Joueur } from '../model';
import { SeConnecterHttpService } from '../se-connecter/se-connecter-http.service';
import { InscriptionJoueurService } from './inscription-joueur.service';

@Component({
  selector: 'app-inscription-joueur',
  templateUrl: './inscription-joueur.component.html',
  styleUrls: ['./inscription-joueur.component.scss']
})
export class InscriptionJoueurComponent implements OnInit {

  joueurForm: Joueur = null;
  compteForm: Compte = null;
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
    if (!this.joueurForm.id) {
      this.inscriptionService.create(this.joueurForm);
    } else {
      this.inscriptionService.modify(this.joueurForm);
    }
    this.router.navigate(['/seconnecter']);
    this.joueurForm = null;
  }
  cancel() {
    this.router.navigate(['/seconnecter']);
    this.joueurForm = null;
  }
  listCompte(): Array<Compte> {
    return this.seConnecter.findAll();
  }
  saveCompte(){
    if (!this.compteForm.id) {
      this.seConnecter.create(this.compteForm);
    } else {
      this.seConnecter.modify(this.compteForm);
    }
    this.router.navigate(['/seconnecter']);
    this.compteForm = null;
  }

}
