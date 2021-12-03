import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from '../app-config.service';
import { Pilote } from '../model';

@Injectable({
  providedIn: 'root'
})
export class MenuHttpService {

  piloteUrl : string;
  pilotes : Array<Pilote> = new Array<Pilote>();
  pilote : Pilote;

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.piloteUrl = this.appConfig.backEndUrl + "pilote/"
    this.loadAllPilote();
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
ngOnInit(): void {
}
  
}

