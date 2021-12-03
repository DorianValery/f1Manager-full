import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from '../app-config.service';
import { Pilote, Course } from '../model';

@Injectable({
  providedIn: 'root'
})
export class SaisonService {

  saisonUrl : string;
  courses : Array<Course> = new Array<Course>();
  course : Course;

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.saisonUrl = this.appConfig.backEndUrl + "course/"
    this.loadSaison();
    // this.findPiloteEtatById()
   }



findCourseById(id : number) : Observable<Course> {
  return this.http.get<Course>(this.saisonUrl + id);
  }

findAllCourse(): Array<Course> {
  return this.courses;
}

   findPiloteEtatById(id : number) : Observable<Boolean>
{
  return null;
}


// loadPilote(){
//   this.http.get<Pilote>(this.piloteUrl + id).subscribe(response => {
//     this.pilote = response;
//   }, error => console.log(error));;
// }

loadSaison(){
  this.http.get<Array<Course>>(this.saisonUrl).subscribe(response => {
    this.courses = response;
  }, error => console.log(error));
}

  
}
