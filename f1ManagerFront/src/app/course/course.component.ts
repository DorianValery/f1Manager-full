import { Component, OnInit } from '@angular/core';
import { AppConfigService } from '../app-config.service';
import { Course, Ecurie, Pilote, Position } from '../model';
import { PiloteInventaireHttpService } from '../pilote-inventaire/pilote-inventaire-http.service';
import { SaisonService } from '../saison/saison.service';
import { CourseService } from './course.service';


@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.scss']
})
export class CourseComponent implements OnInit {

  ecuries : Array<Ecurie>;
  pilotes : Array<Pilote>;
  classement : Array<Position>;
  course: Course;
  positionFinale: number;
  positionPilote: number;
  positionVoiture: number;
  piloteTest: Pilote;
  position: number;
  nbTour : number=0;

  constructor(private appConfig: AppConfigService,  private courseService : CourseService, private piloteService: PiloteInventaireHttpService, private saisonService : SaisonService) { 
    
  }

  list(): Array<Ecurie> {
    return this.courseService.findAllEcurie();
  }

  listPilote(): Array<Pilote>{
    return this.piloteService.findAll();
  }

  findPilote(id : number) {
    this.piloteService.findPiloteById(id).subscribe(resp =>{
      this.piloteTest = resp;
    },error=> console.log(error))
  }

  getPosition() {
   // this.pilote = this.piloteService.findAll();
    return this.courseService.findPilote();
      }

  // genererClassement(): Array<Pilote> {
  //   return this.piloteService.findByIdExperience(1); 
  //   this.classement.push(this.position);
  // }

  passerTour(){

    this.saisonService.findCourseById
    this.nbTour ++;
  }

  ngOnInit(): void {
  }

}
