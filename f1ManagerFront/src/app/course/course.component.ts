import { Component, OnInit } from '@angular/core';
import { AppConfigService } from '../app-config.service';
import { EcurieService } from '../ecurie/ecurie.service';
import { MenuHttpService } from '../menu/menu-http.service';
import { Course, Ecurie, Infrastructure, Order, Pilote, Position, Voiture } from '../model';
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
  classement: Array<Order> = new Array<Order>();
  course: Course = new Course();

  order: Order = new Order();
  order2: Order = new Order();
  order3: Order = new Order();


  scoreGeneral: number[] = [];

  ecurie: Ecurie = new Ecurie();

  positionFinale: number;
  positionPilote: number;
  positionVoiture: number;
  piloteTest: Pilote;
  position: number;
  nbTour: number = 0;


  constructor(private appConfig: AppConfigService, private menuService: MenuHttpService, private courseService: CourseService, private ecurieService: EcurieService, private piloteService: PiloteInventaireHttpService, private saisonService: SaisonService) {
    this.listcourse()
    this.listEcurie()
    this.saisonService.findCourseById(1);
    this.findCourse(1);
    this.menuService.findEcurieById(1);
    
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
  findCourse(id: number) {
    this.saisonService.findCourseById(id).subscribe(resp => {
      this.course = resp;
      //sessionStorage.setItem("course",this.saisonTest)
    }, error => console.log(error))
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

  findEcurie(id: number) {
    this.menuService.findEcurieById(id).subscribe(resp => {
      this.ecurie = resp;
      this.ecuries.push(this.ecurie);
      this.ecuries.push(this.ecurie);
      this.ecuries.push(this.ecurie);
      this.ecuries.push(this.ecurie);

      this.ecuries.push(this.ecurie);
      this.ecuries.push(this.ecurie);
    }, error => console.log(error))
  }

  ngOnInit(): void {
  }

  algoPosition() {
    this.scoreGeneral = []

    this.classement = new Array<Order>();

    // this.order.voiture = new Voiture(1, 0, "test", 50, 250, 600, true, null, null);
    // this.order.pilote = new Pilote(1, 0, "testPilote", "pilote", 20, null, null, 60, true, null, null)
    // this.order.infra = new Infrastructure(1, 0, "TestInfra", null, 5, 10, 15, true, null)
    // this.classement.push(this.order)
    // this.order2.voiture = new Voiture(2, 0, "test", 60, 2000, 200, true, null, null);
    // this.order2.pilote = new Pilote(2, 0, "testPilote", "pilote", 10, null, null, 50, true, null, null)
    // this.order2.infra = new Infrastructure(2, 0, "TestInfra", null, 5, 10, 15, true, null)
    // this.classement.push(this.order2)
    // this.order3.voiture = new Voiture(3, 0, "test", 10, 250, 100, true, null, null);
    // this.order3.pilote = new Pilote(3, 0, "testPilote", "pilote", 60, null, null, 60, true, null, null)
    // this.order3.infra = new Infrastructure(3, 0, "TestInfra", null, 5, 10, 15, true, null)
    // this.classement.push(this.order3)


    // for(let element of this.ecuries){
    //   this.pilotes.concat(element.pilotes)
    //   this.voitures.concat(element.voitures)
    //   this.infras.concat(element.infrastructures)
    // }

    // var i : number=0;
    // if(i<20)
    //   {
    //     for(let element of this.ecuries)
    //      {
    //       this.positions.set(i,(element.pilotes))
    //       i++;
    //      }
    //   }

    // var j : number=0;
    // if(j<20)
    // {
    //   for(let element of this.voitures)
    //     {
    //     this.positions.set(j,((element.maniabilite+element.vitesse)-element.poids/10))
    //     j++;
    //     }
    // }


    // var h : number=0;
    // if(h<20)
    //   {
    //     for(let element of this.infras)
    //       {
    //       this.positions.set(h,(element.nbIngenieurs + element.pitStop))
    //       h++;
    //       }
    //   } 

    console.log(this.classement)


    for (let element of this.ecuries) {

      for (let el of element.voitures) {
        var scoreVoiture: number = ((el.maniabilite + el.vitesse) - el.poids / 10)
      }
      for (let el of element.pilotes) {
        var scorePilote: number = (el.experience)
      }
      for (let el of element.infrastructures) {
        var scoreInfra: number = (el.experience + el.nbIngenieurs + el.pitStop)
      }


      //(((element.voiture.maniabilite + element.voiture.vitesse) - element.voiture.poids / 10) + (element.pilote.experience) + (element.infra.nbIngenieurs) + element.infra.pitStop) * (1 + Math.random());



      this.scoreGeneral.push((scoreVoiture + scorePilote + scoreInfra) * (1 + Math.random()))


      console.log(this.scoreGeneral)
    }



    // this.scoreGeneral.push(this.order.score);

    // console.log(this.order.score)

    this.scoreGeneral = this.scoreGeneral.sort((a, b) => b - a);
    console.log(this.scoreGeneral + "ok")




  }

}
