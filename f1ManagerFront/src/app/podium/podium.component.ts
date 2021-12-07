import { Component, Input, OnInit, TemplateRef } from '@angular/core';
import { CourseComponent } from '../course/course.component';
import { CourseService } from '../course/course.service';
import { EcurieService } from '../ecurie/ecurie.service';
import { Ecurie } from '../model';

@Component({
  selector: 'app-podium',
  templateUrl: './podium.component.html',
  styleUrls: ['./podium.component.scss'],
  
})
export class PodiumComponent implements OnInit {


  elseBlock: TemplateRef<any>|null = null;
  ecurie : Ecurie = this.ecurieService.ecurie;
  
  scoreFin : any[];

  constructor(private courseService : CourseService, private ecurieService : EcurieService) {

   
    console.log(this.scoreFin)

   }

   score() : any[]{
     return this.scoreFin = this.courseService.findScore();
   }

  ngOnInit(): void {
  }

}
