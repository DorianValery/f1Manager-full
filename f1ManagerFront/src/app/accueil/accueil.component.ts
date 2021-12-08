import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SeConnecterHttpService } from '../se-connecter/se-connecter-http.service';
import { AccueilService } from './accueil.service';

@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.scss']
})
export class AccueilComponent implements OnInit {

  constructor(private accueilService: AccueilService,private router: Router, private seconnecterService: SeConnecterHttpService) { }

  ngOnInit(): void {
  }
  redirection(){
 this.router.navigate(['/seconnecter']);
  }
 

}
