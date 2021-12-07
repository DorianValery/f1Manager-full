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
  course : Course = this.saisonService.course;
  idCourse : number = this.ecurieService.ecurie.courseEnCours;
  scoreFin : any[];

  constructor(private courseService : CourseService, private ecurieService : EcurieService, private saisonService : SaisonService,private podiumService :  PodiumService) {

   
    console.log(this.scoreFin)

   }

   score() : any[]{
     return this.scoreFin = this.courseService.findScore();
   }
   courseSuivante(){
     
    this.courseService.findScore().forEach(( e , i)=>{
      e.ecurie.courseEnCours ++;
      e.ecurie.argent += (this.podiumService.findCourse(this.idCourse).cashPrize-(i*10000));
      console.log(this.course)
      this.ecurieService.modify(e.ecurie);
    })
   
   }

  ngOnInit(): void {
  }

}
