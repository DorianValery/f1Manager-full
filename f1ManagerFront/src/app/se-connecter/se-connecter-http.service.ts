import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from '../app-config.service';
import { Compte, SeConnecterForm } from '../model';


@Injectable({
  providedIn: 'root'
})
export class SeConnecterHttpService {

  compteUrl: string;
  compte: Compte;

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.compteUrl = this.appConfig.backEndUrl + "compte/"
  }

  seconnecter(seconnecter: SeConnecterForm): Observable<Compte> {
    return this.http.post<Compte>(this.compteUrl + "seconnecter", seconnecter);
  }

  sedeconnecter() {
    this.compte = null;
  }
}
