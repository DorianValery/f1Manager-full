import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from '../app-config.service';
import { EcurieService } from '../ecurie/ecurie.service';
import { Ecurie, Voiture } from '../model';

@Injectable({
  providedIn: 'root'
})
export class VoitureInventaireService {

  voitureInventaireUrl: string;
  voitures: Array<Voiture>;
  ecurieUrl: string;

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.voitureInventaireUrl = this.appConfig.backEndUrl + "voiture/";
    this.ecurieUrl=this.appConfig.backEndUrl+"ecurie/";
    this.load();
    }

   findVoitureById(id: number): Observable<Voiture>{
    return this.http.get<Voiture>(this.voitureInventaireUrl + id);
    }

   findAll(): Array<Voiture> {
    return this.voitures;
  }

  load() {
    this.http.get<Array<Voiture>>(this.voitureInventaireUrl).subscribe(response => {
      this.voitures = response;
    }, error => console.log(error));
  }

  // loadEcurie(id: number){
  //   this.http.get<Ecurie>(this.ecurieUrl+id).subscribe(response=>{
  //     this.ecurie=response;
  //   },error=>console.log(error));
  // }

  loadEcurie(id: number): Observable<Ecurie>{
    return this.http.get<Ecurie>(this.ecurieUrl+id);
  }
}