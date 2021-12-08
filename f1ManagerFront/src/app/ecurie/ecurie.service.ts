import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from '../app-config.service';
import { Course, Ecurie} from '../model';

@Injectable({
  providedIn: 'root'
})
export class EcurieService {
  
  ecuries: Array<Ecurie> = new Array<Ecurie>();
  ecurie:Ecurie;
  ecurieUrl: string;
  ecurieUrlss: string;
  course : Course;

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.ecurieUrl = this.appConfig.backEndUrl + "ecurie/"
    this.ecurieUrlss = this.appConfig.backEndUrl + "ecurie"
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

  findCourseById(id : number) : Observable<Course> {
    return this.http.get<Course>(this.ecurieUrl + id);
    }

  modify(ecurie: Ecurie){
         this.http.put<Ecurie>(this.ecurieUrl+this.ecurie.id, ecurie).subscribe(response=>{
           this.ecurie.version = response.version;
      //  this.loadEcurie(this.ecurie.id);
     }, error => console.log(error));
    }

    modifyPodium(ecurie: Ecurie, id : number){
      this.http.put<Ecurie>(this.ecurieUrl+id, ecurie).subscribe(response=>{
        ecurie.version = response.version;
        //  this.loadEcurie(this.ecurie.id);
       }, error => console.log(error));
      
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
