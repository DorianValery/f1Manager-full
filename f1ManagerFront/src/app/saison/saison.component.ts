import { Component, OnInit } from '@angular/core';
import { AppConfigService } from '../app-config.service';
import { Course, Pilote, Voiture } from '../model';
import { SaisonService } from './saison.service';
import { PiloteInventaireHttpService } from '../pilote-inventaire/pilote-inventaire-http.service';
import { VoitureInventaireService } from '../voiture-inventaire/voiture-inventaire.service';


@Component({
  selector: 'app-saison',
  templateUrl: './saison.component.html',
  styleUrls: ['./saison.component.scss']
})
export class SaisonComponent implements OnInit {

 saisonTest : Course;
 piloteTest: Pilote;
 voitureTest: Voiture;

  constructor(private appConfig: AppConfigService,  private saisonService :SaisonService, private piloteService : PiloteInventaireHttpService, private voitureService: VoitureInventaireService) {
  
   }

   findPilote(id : number) {
    this.piloteService.findPiloteById(id).subscribe(resp =>{
      this.piloteTest = resp;
    },error=> console.log(error))
  }

  findVoiture(id : number) {
    this.voitureService.findVoitureById(id).subscribe(resp =>{
      this.voitureTest = resp;
    },error=> console.log(error))
  }

findCourse(id : number) {
  this.saisonService.findCourseById(id).subscribe(resp =>{
    this.saisonTest = resp;
  },error=> console.log(error))
}

listCourse(): Array<Course> {
  return this.saisonService.findAllCourse();
}



  ngOnInit(): void {
  }

}
