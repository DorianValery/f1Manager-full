import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '../app-config.service';
import { Ecurie, Pilote } from '../model';
import { CourseComponent } from './course.component';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  ecurieUrl : string;
  ecuries : Array<Ecurie> = new Array<Ecurie>();
  pilotes : Array<Pilote> = new Array<Pilote>();
  pilote: Pilote;
  piloteUrl : string;
  scoreFin : any[] ;
  

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.ecurieUrl = this.appConfig.backEndUrl + "ecurie/"
    this.loadEcurie();
    }

    findPiloteExperience(experience: number){
      return this.http.get<Pilote>(this.piloteUrl + experience);
    }

    findPilote(): Array<Pilote>{
      return this.pilotes;
      }

  findAllEcurie() : Array<Ecurie>{
    return this.ecuries;
  }

 findScore() : any[]{
  return this.scoreFin;
 }
  

  loadEcurie(){
    this.http.get<Array<Ecurie>>(this.ecurieUrl).subscribe(response => {
      this.ecuries = response;
    }, error => console.log(error));
  }
}
