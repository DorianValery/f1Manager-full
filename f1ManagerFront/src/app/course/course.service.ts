import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '../app-config.service';
import { Ecurie, Pilote, Position } from '../model';


@Injectable({
  providedIn: 'root'
})
export class CourseService {

  ecurieUrl : string;
  positionUrl : string;
  ecuries : Array<Ecurie> = new Array<Ecurie>();
  pilotes : Array<Pilote> = new Array<Pilote>();
  pilote: Pilote;
  piloteUrl : string;
  scoreGeneral: any[] = [];
  scoreFin : any[] = [];
  position : Position = new Position();
  
  

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.ecurieUrl = this.appConfig.backEndUrl + "ecurie/"
    this.positionUrl = this.appConfig.backEndUrl + "position/"
    this.loadEcurie();
    }

    saveScore(position : Position){
      return this.http.post<Position>(this.positionUrl,position).subscribe(resp => {
       
        
      }, error => console.log(error));
    }
    findPiloteExperience(experience: number){
      return this.http.get<Pilote>(this.piloteUrl + experience);
    }

    findPilote(): Array<Pilote>{
      return this.pilotes;
      }

  findAllEcurie() : Array<Ecurie>{
    return this.ecuries;
  }

 findScore() : any[]{
  return this.scoreFin = this.scoreGeneral;
 }
  

  loadEcurie(){
    this.http.get<Array<Ecurie>>(this.ecurieUrl).subscribe(response => {
      this.ecuries = response;
    }, error => console.log(error));
  }

  algoPosition() : any[] {
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
      let ecurie : Ecurie = element;
      
      this.scoreGeneral.push({"ecurie":ecurie,"score": score});
            
    }


    this.scoreGeneral = this.scoreGeneral.sort((a, b) => b.score - a.score);
      console.log(this.scoreGeneral)
      
      return this.scoreGeneral;
      

    

  }

}
