import { Component, OnInit } from '@angular/core';
import { AppConfigService } from '../app-config.service';
import { Course, Ecurie, Pilote, Voiture } from '../model';
import { SaisonService } from './saison.service';
import { PiloteInventaireHttpService } from '../pilote-inventaire/pilote-inventaire-http.service';
import { VoitureInventaireService } from '../voiture-inventaire/voiture-inventaire.service';
import { EcurieService } from '../ecurie/ecurie.service';
import { CourseService } from '../course/course.service';
import { MenuHttpService } from '../menu/menu-http.service';


@Component({
  selector: 'app-saison',
  templateUrl: './saison.component.html',
  styleUrls: ['./saison.component.scss']
})
export class SaisonComponent implements OnInit {


  piloteTest: Pilote;
  voitureTest: Voiture;
  courseTest : Course;
  ecurie : Ecurie = this.ecurieService.ecurie;
  courseID : number = this.ecurieService.ecurie.courseEnCours;

  constructor(private appConfig: AppConfigService,  private saisonService :SaisonService, private courseService: CourseService, private ecurieService : EcurieService) {
    
    this.findCourse(this.courseID);
    console.log(this.courseID);
    console.log( this.ecurieService.ecurie);
   }

   list(): Array<Ecurie> {
    return this.courseService.findAllEcurie();
  }

  
  findEcurie(id : number) {
    this.ecurieService.findById(id).subscribe(resp =>{
      this.ecurie = resp;
    },error=> console.log(error))
  }

  // lancerCourse(){
  //   this.menuService.courseEnCours = this.saisonTest.id;
  // }

  //  findPilote(id : number) {
  //   this.piloteService.findPiloteById(id).subscribe(resp =>{
  //     this.piloteTest = resp;
  //   },error=> console.log(error))
  // }

  // findVoiture(id : number) {
  //   this.voitureService.findVoitureById(id).subscribe(resp =>{
  //     this.voitureTest = resp;
  //   },error=> console.log(error))
  // }

findCourse(courseID : number) {
  this.saisonService.findCourseById(courseID).subscribe(resp =>{
    this.courseTest = resp;
    console.log(this.courseTest);
    //sessionStorage.setItem("course",this.saisonTest)
  },error=> console.log(error))
}

listCourse(): Array<Course> {
  return this.saisonService.findAllCourse();
}



  ngOnInit(): void {
  }

}
