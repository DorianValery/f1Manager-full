import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from '../app-config.service';
import { Ecurie, Joueur } from '../model';

@Injectable({
  providedIn: 'root'
})
export class JoueurService {

  joueurs: Array<Joueur> = new Array<Joueur>();
  joueurUrl: string;
  ecurieUrl: string;

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.joueurUrl = this.appConfig.backEndUrl + "joueur/"
    this.ecurieUrl = this.appConfig.backEndUrl + "ecurie/"
    this.load();
  }

  findAll(): Array<Joueur> {
    return this.joueurs;
  }

  findById(id: number): Observable<Joueur> {
    return this.http.get<Joueur>(this.joueurUrl + id);
  }

  
  findEcurieById(id : number) : Observable<Ecurie> {
    return this.http.get<Ecurie>(this.ecurieUrl + id);
    }

  load() {
    this.http.get<Array<Joueur>>(this.joueurUrl).subscribe(response => {
      this.joueurs = response;
    }, error => console.log(error));
  }
}
