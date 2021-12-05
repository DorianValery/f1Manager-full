import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '../app-config.service';
import { Ecurie, Joueur } from '../model';

@Injectable({
  providedIn: 'root'
})
export class EcurieService {
  
  ecurieUrl: string;
  ecuries: Array<Ecurie> = new Array<Ecurie>();

  constructor(private http: HttpClient, private appConfig: AppConfigService){
    this.ecurieUrl=appConfig.backEndUrl+"ecurie/";

  }

  findById(id: number): Ecurie {
    return this.ecuries.find(ecurie => ecurie.id == id);
  }

}
