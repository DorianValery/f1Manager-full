import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '../app-config.service';
import { Pilote } from '../model';

@Injectable({
  providedIn: 'root'
})
export class PiloteInventaireHttpService {

 pilotes: Array<Pilote> = new Array<Pilote>();
  piloteUrl: string;

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.piloteUrl = this.appConfig.backEndUrl + "pilote/"
    this.load();
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
