import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from '../app-config.service';
import { Ecurie} from '../model';

@Injectable({
  providedIn: 'root'
})
export class EcurieService {
  
  ecuries: Array<Ecurie> = new Array<Ecurie>();
  ecurie:Ecurie;
  ecurieUrl: string;

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.ecurieUrl = this.appConfig.backEndUrl + "ecurie/"
    this.load();
  }

  findAll(): Array<Ecurie> {
    return this.ecuries;
  }

  findById(id: number): Observable<Ecurie> {
    return this.http.get<Ecurie>(this.ecurieUrl + id);
  }

 findByArgent(argent: number): Observable<Ecurie> {
    return this.http.get<Ecurie>(this.ecurieUrl + argent);
  }
  

  load() {
    this.http.get<Array<Ecurie>>(this.ecurieUrl).subscribe(response => {
      this.ecuries = response;
    }, error => console.log(error));
  }

  loadEcurie(id:number){
    this.http.get<Ecurie>(this.ecurieUrl + id).subscribe(response=>{
      this.ecurie=response;
    },error => console.log(error))
  }

}
