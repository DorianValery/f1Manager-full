import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from '../app-config.service';
import { Pilote } from '../model';

@Injectable({
  providedIn: 'root'
})
export class PiloteInventaireHttpService {

 pilotes: Array<Pilote> = new Array<Pilote>();
 pilote: Pilote;
  piloteUrl: string;

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.piloteUrl = this.appConfig.backEndUrl + "pilote/"
    this.load();
  }

  findPiloteById(id: number): Observable<Pilote>{
  return this.http.get<Pilote>(this.piloteUrl + id);
  }

  findExperience(){
    return this.http.get<Pilote>(this.piloteUrl + this.pilote.experience);
  }

  findAll(): Array<Pilote> {
    return this.pilotes;
  }

  load() {
    this.http.get<Array<Pilote>>(this.piloteUrl).subscribe(response => {
      this.pilotes = response;
    }, error => console.log(error));
  }
}
