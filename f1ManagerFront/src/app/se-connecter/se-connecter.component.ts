import { Component, OnInit } from '@angular/core';
import { ActivatedRoute,Router } from '@angular/router';
import { AppRoutingModule } from '../app-routing.module';
import { EcurieService } from '../ecurie/ecurie.service';
import { JoueurService } from '../joueur/joueur.service';
import { SeConnecterForm } from '../model';
import { SeConnecterHttpService } from './se-connecter-http.service';

@Component({
  selector: 'app-se-connecter',
  templateUrl: './se-connecter.component.html',
  styleUrls: ['./se-connecter.component.scss']
})
export class SeConnecterComponent implements OnInit {

  seconnecterForm: SeConnecterForm = new SeConnecterForm();
  errorLogin: String;

  constructor(private seconnecterService: SeConnecterHttpService, private joueurService: JoueurService, private router: Router) { }

  ngOnInit(): void {
  }

  login() {
    this.seconnecterService.seconnecter(this.seconnecterForm).subscribe(resp => {
      this.seconnecterService.compte = resp;
      this.joueurService.loadJoueur(resp.joueur.id);
      this.router.navigate(['/menu']);
      this.errorLogin = null;
    }, error => {
      console.log(error);
      if(error.status == 404) {
        this.errorLogin = "Le compte ou le mot de passe est incorrect !"
      }
    });
  }

}
