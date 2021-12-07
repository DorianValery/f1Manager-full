import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from '../app-config.service';
import { JoueurService } from '../joueur/joueur.service';
import { Inventaire } from '../model';
import { VoitureInventaireService } from '../voiture-inventaire/voiture-inventaire.service';

@Injectable({
  providedIn: 'root'
})
export class InventaireService {

  inventaireUrl: string;

  constructor(private http: HttpClient, private appConfig: AppConfigService, private joueurService: JoueurService) { 
    this.inventaireUrl=this.appConfig.backEndUrl+"inventaire/";
  }



// create(inventaire: Inventaire) {
//   this.http.post<Inventaire>(this.inventaireUrl, inventaire).subscribe(resp => {
//   }, error => console.log(error));
// }

create(inventaire: Inventaire): Observable<Inventaire> {
  return this.http.post<Inventaire>(this.inventaireUrl, inventaire);
}

 loadVoitures(){
   return this.http.get<Array<number>>(this.inventaireUrl+this.joueurService.joueur.id+"/idVoitures");
 }

 loadInfrastructures(){
  return this.http.get<Array<number>>(this.inventaireUrl+this.joueurService.joueur.id+"/idInfrastructures");
}
}