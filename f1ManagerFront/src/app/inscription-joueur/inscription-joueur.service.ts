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

  joueurUrl: string;
  compteUrl:string;

  constructor(private http: HttpClient, private appConfig: AppConfigService, private seConnecter: SeConnecterHttpService) {
    this.joueurUrl = this.appConfig.backEndUrl + "joueur/"
    this.compteUrl = this.appConfig.backEndUrl + "compte/"
  }
  findById(id: number): Observable<Joueur> {
    return this.http.get<Joueur>(this.joueurUrl + id);
  }
  create(joueur: InscriptionDTO) {
    this.http.post<InscriptionDTO>(this.joueurUrl, joueur).subscribe(resp => {

    }, error => console.log(error));
    this.http.post<InscriptionDTO>(this.compteUrl, joueur).subscribe(resp => {

    }, error => console.log(error));
  }
  modify(joueur: InscriptionDTO) {
    this.http.put<InscriptionDTO>(this.joueurUrl + joueur.id, joueur).subscribe(resp => {

    }, error => console.log(error));
    
  }

  deleteById(id: number) {
    this.http.delete<void>(this.joueurUrl + id).subscribe(resp => {

    }, error => console.log(error));
  }

  
}
