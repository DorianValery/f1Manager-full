import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from '../app-config.service';
import { EcurieService } from '../ecurie/ecurie.service';
import { InventaireService } from '../inventaire/inventaire.service';
import { Ecurie, Voiture } from '../model';

@Injectable({
  providedIn: 'root'
})
export class VoitureInventaireService {

  voitureInventaireUrl: string;
  voitures: Array<Voiture>;


  constructor(private http: HttpClient, private appConfig: AppConfigService, private ecurieService: EcurieService, private inventaireService: InventaireService) {
    this.voitureInventaireUrl = this.appConfig.backEndUrl + "voiture/";
    this.load();
  }

  findVoitureById(id: number): Observable<Voiture> {
    return this.http.get<Voiture>(this.voitureInventaireUrl + id);
  }

  findAll(): Array<Voiture> {
    return this.voitures;
  }

  load() {
    this.http.get<Array<Voiture>>(this.voitureInventaireUrl).subscribe(response => {    
      this.voitures = response;
      this.inventaireService.loadVoitures().subscribe(resp =>{
          this.voitures.forEach(v => {
            if(resp.includes(v.id)) {
              v.etat = true;
            }
          });
        }, err => console.log(err));
    }, error => console.log(error));
  }

loadEcurie(id: number): Observable < Ecurie > {
  return this.http.get<Ecurie>(this.ecurieService.ecurieUrl + id);
}

saveEcurie(ecurie: Ecurie){
  this.http.put<Ecurie>(this.ecurieService.ecurieUrl + ecurie.id, ecurie).subscribe(resp => {
    this.load();
    this.loadEcurie(ecurie.id);
  }, error => console.log(error));
}
}