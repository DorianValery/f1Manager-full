import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from '../app-config.service';
import { Compte, InscriptionDTO, Joueur } from '../model';
import { SeConnecterHttpService } from '../se-connecter/se-connecter-http.service';

@Injectable({
  providedIn: 'root'
})
export class InscriptionJoueurService {

  inscriptionUrl: string;
  joueurUrl: string;
  compteUrl: string;
  

  constructor(private http: HttpClient, private appConfig: AppConfigService, private seConnecter: SeConnecterHttpService) {
    //this.joueurUrl = this.appConfig.backEndUrl + "joueur/"
    //this.compteUrl = this.appConfig.backEndUrl + "compte/"
    this.inscriptionUrl = this.appConfig.backEndUrl + "compte/inscription/"
  }
  findById(id: number): Observable<Joueur> {
    return this.http.get<Joueur>(this.inscriptionUrl + id);
  }
  create(inscription: InscriptionDTO) {
    /*this.http.post<InscriptionDTO>(this.compteUrl, inscription).subscribe(resp => {

    }, error => console.log(error));
    this.http.post<InscriptionDTO>(this.joueurUrl, inscription).subscribe(resp => {

    }, error => console.log(error));*/
    this.http.post<InscriptionDTO>(this.inscriptionUrl, inscription).subscribe(resp => {

    }, error => console.log(error));
  }
  modify(inscription: InscriptionDTO) {
    this.http.put<InscriptionDTO>(this.inscriptionUrl + inscription.id, inscription).subscribe(resp => {

    }, error => console.log(error));
    
  }

  deleteById(id: number) {
    this.http.delete<void>(this.inscriptionUrl + id).subscribe(resp => {

    }, error => console.log(error));
  }

  
}
