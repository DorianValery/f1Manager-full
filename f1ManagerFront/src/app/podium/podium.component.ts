import { Component, Input, OnInit } from '@angular/core';
import { CourseComponent } from '../course/course.component';
import { CourseService } from '../course/course.service';

@Component({
  selector: 'app-podium',
  templateUrl: './podium.component.html',
  styleUrls: ['./podium.component.scss'],
  
})
export class PodiumComponent implements OnInit {



  
  scoreFin : any[];

  constructor(private courseService : CourseService) {

   
    console.log(this.scoreFin)

   }

   score() : any[]{
     return this.scoreFin = this.courseService.findScore();
   }

  ngOnInit(): void {
  }

}
