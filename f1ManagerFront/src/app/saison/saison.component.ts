import { Component, OnInit } from '@angular/core';
import { AppConfigService } from '../app-config.service';
import { Course, Pilote } from '../model';
import { SaisonService } from './saison.service';


@Component({
  selector: 'app-saison',
  templateUrl: './saison.component.html',
  styleUrls: ['./saison.component.scss']
})
export class SaisonComponent implements OnInit {

 saisonTest : Course;

  constructor(private appConfig: AppConfigService,  private saisonService :SaisonService) {
  
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
