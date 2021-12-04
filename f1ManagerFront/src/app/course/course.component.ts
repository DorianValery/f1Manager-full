import { Component, OnInit } from '@angular/core';
import { AppConfigService } from '../app-config.service';
import { Course, Ecurie, Pilote, Position } from '../model';
import { PiloteInventaireHttpService } from '../pilote-inventaire/pilote-inventaire-http.service';
import { CourseService } from './course.service';


@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.scss']
})
export class CourseComponent implements OnInit {

  ecuries : Array<Ecurie>;
  classement : Array<Position>;
  course: Course;
  positionFinale: number;
  positionPilote: number;
  positionVoiture: number;
  pilote: Pilote;

  constructor(private appConfig: AppConfigService,  private courseService : CourseService, private piloteService: PiloteInventaireHttpService) { }

  list(): Array<Ecurie> {
    return this.courseService.findAllEcurie();
  }

  findPilote(){
    return this.piloteService.findAll();
  }

  // genererClassement(): Array<Pilote> {
  //   return this.piloteService.findByIdExperience(1); 
  //   this.classement.push(this.position);
  // }


  ngOnInit(): void {
  }

}
