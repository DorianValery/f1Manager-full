import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '../app-config.service';
import { Voiture } from '../model';

@Injectable({
  providedIn: 'root'
})
export class VoitureInventaireService {

  voitureInventaireUrl: string;
  voitures: Array<Voiture> = new Array<Voiture>();

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.voitureInventaireUrl=this.appConfig.backEndUrl+"voiture/";
    this.load();
   }

   findAll(): Array<Voiture> {
    return this.voitures;
  }

   load() {
    this.http.get<Array<Voiture>>(this.voitureInventaireUrl).subscribe(response => {
      this.voitures = response;
    }, error => console.log(error));
  }
}