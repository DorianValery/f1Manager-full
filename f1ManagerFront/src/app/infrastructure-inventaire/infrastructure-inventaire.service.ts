import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from '../app-config.service';
import { EcurieService } from '../ecurie/ecurie.service';
import { InventaireService } from '../inventaire/inventaire.service';
import { Ecurie, Infrastructure } from '../model';

@Injectable({
  providedIn: 'root'
})
export class InfrastructureInventaireService {

  infrastructures: Array<Infrastructure>;
  infrastructureInventaireUrl: string;
  

  constructor(private http: HttpClient, private appConfig: AppConfigService, private ecurieService: EcurieService, private inventaireService: InventaireService) {
    this.infrastructureInventaireUrl = appConfig.backEndUrl + "infrastructure/";
    this.load();
  }


  findAll(): Array<Infrastructure> {
    return this.infrastructures;
  }

  load() 
  {
    this.http.get<Array<Infrastructure>>(this.infrastructureInventaireUrl).subscribe(response => {    
      this.infrastructures = response;
      this.inventaireService.loadInfrastructures().subscribe(resp => {
          this.infrastructures.forEach(i => {
            if(resp.includes(i.id)) {
              i.etat = true;
            }
          });
      }, err => console.log(err));
  
    }, error => console.log(error));
  }




}
