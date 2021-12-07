import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppConfigService } from '../app-config.service';
import { EcurieService } from '../ecurie/ecurie.service';
import { MenuHttpService } from '../menu/menu-http.service';
import { Course, Ecurie, Infrastructure, Pilote, Position, Voiture } from '../model';
import { PiloteInventaireHttpService } from '../pilote-inventaire/pilote-inventaire-http.service';
import { SaisonService } from '../saison/saison.service';
import { CourseService } from './course.service';


@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.scss']
})
export class CourseComponent implements OnInit {

  ecuries: Array<Ecurie> = new Array<Ecurie>();
  pilotes: Array<Pilote>;
  course : Course;

  scoreGeneral: any[] = [];
  scoreFin : any[] = [];

  ecurie: Ecurie = this.ecurieService.ecurie;
  ecurieJoueur : Ecurie = this.ecurieService.ecurie;
  courseID : number = this.ecurieService.ecurie.courseEnCours;
  piloteTest: Pilote;
  position: number;
  nbTour: number = 0;


  constructor(private router : Router,private appConfig: AppConfigService, private menuService: MenuHttpService, private courseService: CourseService, private ecurieService: EcurieService, private piloteService: PiloteInventaireHttpService, private saisonService: SaisonService) {
    this.listcourse()
    this.listEcurie()
    this.findCourse(this.courseID);
    console.log(this.courseID);
    this.ecuries =this.list();
    console.log(this.ecuries)
    
    
    console.log(this.ecuries)
  }

  list(): Array<Ecurie> {
    return this.courseService.findAllEcurie();
  }

  listPilote(): Array<Pilote> {
    return this.piloteService.findAll();
  }

  listcourse(): Course {

    return this.course = this.saisonService.course;
    console.log(this.course)
  }

  listEcurie(): Ecurie {
    return this.ecurie = this.ecurieService.ecurie

  }
  

  findPilote(id: number) {
    this.piloteService.findPiloteById(id).subscribe(resp => {
      this.piloteTest = resp;
    }, error => console.log(error))
  }

  getPosition() {
    // this.pilote = this.piloteService.findAll();
    return this.courseService.findPilote();
  }

  // genererClassement(): Array<Pilote> {
  //   return this.piloteService.findByIdExperience(1); 
  //   this.classement.push(this.position);
  // }

  passerTour() {

    this.algoPosition();


    console.log(this.scoreGeneral + "fini");
    this.nbTour++;
  }

  finCourse() {
    this.scoreFin = this.scoreGeneral;
    
    console.log(this.scoreFin);

  }

  findCourse(courseID : number) {
    this.saisonService.findCourseById(courseID).subscribe(resp =>{
      this.course = resp;
      console.log(this.course);
      //sessionStorage.setItem("course",this.saisonTest)
    },error=> console.log(error))
  }

  findEcurie(id: number) {
    this.menuService.findEcurieById(id).subscribe(resp => {
      this.ecurie = resp;
    }, error => console.log(error))
  }

  ngOnInit(): void {
  }

  algoPosition() {
    this.scoreGeneral = [];
    
    
        
    for (let element of this.ecuries) {
     
      for (let el of element.voitures) {
        var scoreVoiture: number =0 ;
        scoreVoiture += ((el.maniabilite + el.vitesse) - el.poids / 10) 
        console.log(scoreVoiture)
      }
      for (let el of element.pilotes) {
        var scorePilote: number=0 ;
        scorePilote+= (el.experience) 
        console.log(scorePilote)
      }
      for (let el of element.infrastructures) {
        var scoreInfra: number=0 ;
        scoreInfra += (el.experience + el.nbIngenieurs + el.pitStop)
        console.log(scoreInfra)
      } 
     
     

      //(((element.voiture.maniabilite + element.voiture.vitesse) - element.voiture.poids / 10) + (element.pilote.experience) + (element.infra.nbIngenieurs) + element.infra.pitStop) * (1 + Math.random());


      let score : number = (scoreVoiture + scorePilote + scoreInfra) * (1 + (Math.random()/10));
      let nomEcurie : string = element.nom;
      
      this.scoreGeneral.push({"ecurie":nomEcurie,"score": score});
            
    }


    this.scoreGeneral = this.scoreGeneral.sort((a, b) => b.score - a.score);
      console.log(this.scoreGeneral)
      
      

    

  }

}
