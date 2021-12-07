import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from '../app-config.service';
import { Compte, Joueur } from '../model';
import { SeConnecterHttpService } from '../se-connecter/se-connecter-http.service';

@Injectable({
  providedIn: 'root'
})
export class InscriptionJoueurService {

  joueurs: Array<Joueur> = new Array<Joueur>();
  joueurUrl: string;

  constructor(private http: HttpClient, private appConfig: AppConfigService, private seConnecter: SeConnecterHttpService) {
    this.joueurUrl = this.appConfig.backEndUrl + "joueur/"
    this.load();
  }
  findById(id: number): Observable<Joueur> {
    return this.http.get<Joueur>(this.joueurUrl + id);
  }
  create(joueur: Joueur) {
    this.http.post<Joueur>(this.joueurUrl, joueur).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }
  modify(joueur: Joueur) {
    this.http.put<Joueur>(this.joueurUrl + joueur.id, joueur).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  deleteById(id: number) {
    this.http.delete<void>(this.joueurUrl + id).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  load() {
    this.http.get<Array<Joueur>>(this.joueurUrl).subscribe(response => {
      this.joueurs = response;
    }, error => console.log(error));
  }
}
