import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '../app-config.service';
import { Ecurie } from '../model';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  ecurieUrl : string;
  ecuries : Array<Ecurie> = new Array<Ecurie>();

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.ecurieUrl = this.appConfig.backEndUrl + "ecurie/"
    this.loadEcurie();
    }


  findAllEcurie() : Array<Ecurie>{
    return this.ecuries;
  
  }  


  loadEcurie(){
    this.http.get<Array<Ecurie>>(this.ecurieUrl).subscribe(response => {
      this.ecuries = response;
    }, error => console.log(error));
  }
}
