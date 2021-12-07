import { Injectable } from '@angular/core';
import { EcurieService } from '../ecurie/ecurie.service';
import { Course } from '../model';
import { SaisonService } from '../saison/saison.service';

@Injectable({
  providedIn: 'root'
})
export class PodiumService {

  courseID : number = this.ecurieService.ecurie.courseEnCours;
  course : Course;
  constructor(private saisonService : SaisonService, private ecurieService :EcurieService) { 
    this.findCourse(this.courseID)
  }


  findCourse(courseID : number) : Course {
    this.saisonService.findCourseById(courseID).subscribe(resp =>{
      this.course = resp;
      console.log(this.course);
      //sessionStorage.setItem("course",this.saisonTest)
    },error=> console.log(error))
    return this.course;
  }
}
