import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from '../app-config.service';
import { Ecurie, Pilote } from '../model';

@Injectable({
  providedIn: 'root'
})
export class MenuHttpService {

  piloteUrl : string;
  ecurieUrl : string;
  pilotes : Array<Pilote> = new Array<Pilote>();
  pilote : Pilote;
  ecuries : Array<Ecurie> = new Array<Ecurie>();

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.piloteUrl = this.appConfig.backEndUrl + "pilote/"
    this.ecurieUrl = this.appConfig.backEndUrl + "ecurie/"
    this.loadAllPilote();
    this.loadPiloteEcurie();
    // this.findPiloteEtatById()
   }

findAllPilote() : Array<Pilote>{
  return this.pilotes;

}

   findPiloteEtatById(id : number) : Observable<Boolean>
{
  return null;
}

findPiloteById(id : number) : Observable<Pilote> {
  return this.http.get<Pilote>(this.piloteUrl + id);
  }

findEcurieById(id : number) : Observable<Ecurie> {
  return this.http.get<Ecurie>(this.ecurieUrl + id);
  }

// loadPilote(){
//   this.http.get<Pilote>(this.piloteUrl + id).subscribe(response => {
//     this.pilote = response;
//   }, error => console.log(error));;
// }

loadAllPilote(){
  this.http.get<Array<Pilote>>(this.piloteUrl).subscribe(response => {
    this.pilotes = response;
  }, error => console.log(error));
}

loadPiloteEcurie(){
  this.http.get<Array<Ecurie>>(this.ecurieUrl).subscribe(response => {
    this.ecuries = response;
  }, error => console.log(error));
}

ngOnInit(): void {
}
  
}

