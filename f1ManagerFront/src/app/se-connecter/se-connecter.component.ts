import { Component, OnInit } from '@angular/core';
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

  constructor(private seconnecterService: SeConnecterHttpService) { }

  ngOnInit(): void {
  }

  login() {
    this.seconnecterService.seconnecter(this.seconnecterForm).subscribe(resp => {
      this.seconnecterService.compte = resp;
      this.errorLogin = null;
    }, error => {
      console.log(error);
      if(error.status == 404) {
        this.errorLogin = "Le compte ou le mot de passe est incorrect !"
      }
    });
  }

}
