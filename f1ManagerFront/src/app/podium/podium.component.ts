import { Component, Input, OnInit, TemplateRef } from '@angular/core';
import { CourseComponent } from '../course/course.component';
import { CourseService } from '../course/course.service';
import { EcurieService } from '../ecurie/ecurie.service';
import { Course, Ecurie } from '../model';
import { SaisonService } from '../saison/saison.service';
import { PodiumService } from './podium.service';

@Component({
  selector: 'app-podium',
  templateUrl: './podium.component.html',
  styleUrls: ['./podium.component.scss'],
  
})
export class PodiumComponent implements OnInit {


  elseBlock: TemplateRef<any>|null = null;
  ecurie : Ecurie = this.ecurieService.ecurie;
  course : Course ;
  
  scoreFin : any[];
  courseID : number = this.ecurieService.ecurie.courseEnCours;

  constructor(private courseService : CourseService, private ecurieService : EcurieService, private saisonService : SaisonService,private podiumService :  PodiumService) {

    console.log(this.courseID);
    this.findThecourse(this.courseID);
    this.course = podiumService.findCourse(this.courseID);
   
    console.log(this.course);

   }

   score() : any[]{
     return this.scoreFin = this.courseService.findScore();
   }
   courseSuivante(){
     
    this.courseService.findScore().forEach(( e , i)=>{
      //e.ecurie = new Ecurie(e.ecurie.id,e.ecurie.version,null,e.ecurie.argent,e.ecurie.courseEnCours,null,null,null,null,null);
      e.ecurie.courseEnCours ++;
      e.ecurie.argent += this.course.cashPrize-(i*10000);
      console.log(e.ecurie)
      this.ecurieService.modifyPodium(e.ecurie,e.ecurie.id);
    })
   
   }

   findThecourse(courseID : number){
    this.saisonService.findCourseById(courseID).subscribe(resp =>{
      this.course = resp;
      console.log(this.course);
      //sessionStorage.setItem("course",this.saisonTest)
    },error=> console.log(error));
   }

  ngOnInit(): void {
  }

}
