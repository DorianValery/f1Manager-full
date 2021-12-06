import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from '../app-config.service';
import { EcurieService } from '../ecurie/ecurie.service';
import { Ecurie, Pilote } from '../model';

@Injectable({
  providedIn: 'root'
})
export class PiloteInventaireHttpService {

  pilotes: Array<Pilote> = new Array<Pilote>();
  pilote: Pilote;
  piloteUrl: string;

  constructor(private http: HttpClient, private appConfig: AppConfigService, private ecurieService: EcurieService) {
    this.piloteUrl = this.appConfig.backEndUrl + "pilote/"
    this.load();
  }

  findPiloteById(id: number): Observable<Pilote>{
  return this.http.get<Pilote>(this.piloteUrl + id);
  }

  findAll(): Array<Pilote> {
    return this.pilotes;
  }

  load() {
    this.http.get<Array<Pilote>>(this.piloteUrl).subscribe(response => {
      this.pilotes = response;
    }, error => console.log(error));
  }

  loadEcurie(id: number): Observable<Ecurie>{
    return this.http.get<Ecurie>(this.ecurieService.ecurieUrl+id);
  }

  saveEcurie(ecurie: Ecurie){
    this.http.put<Ecurie>(this.ecurieService.ecurieUrl+ecurie.id,ecurie).subscribe(resp=>{
      this.load();
      this.loadEcurie(ecurie.id);
    },error=>console.log(error));
  }

  create(pilote: Pilote) {
    this.http.post<Pilote>(this.piloteUrl, pilote).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  modify(pilote: Pilote) {
    this.http.put<Pilote>(this.piloteUrl + pilote.id, pilote).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  deleteById(id: number) {
    this.http.delete<void>(this.piloteUrl + id).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }
}
