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


 saisonTest : Course;
 piloteTest: Pilote;
 voitureTest: Voiture;
 ecurie : Ecurie;

  constructor(private appConfig: AppConfigService,  private saisonService :SaisonService, private courseService: CourseService, private menuService : MenuHttpService) {
  
   }

   list(): Array<Ecurie> {
    return this.courseService.findAllEcurie();
  }



  findEcurie(id : number) {
    this.menuService.findEcurieById(id).subscribe(resp =>{
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

findCourse(id : number) {
  this.saisonService.findCourseById(id).subscribe(resp =>{
    this.saisonTest = resp;
    //sessionStorage.setItem("course",this.saisonTest)
  },error=> console.log(error))
}

listCourse(): Array<Course> {
  return this.saisonService.findAllCourse();
}



  ngOnInit(): void {
  }

}
