import { Component, OnInit } from '@angular/core';
import { AppConfigService } from '../app-config.service';
import { Ecurie, Pilote } from '../model';
import { CourseService } from './course.service';

@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.scss']
})
export class CourseComponent implements OnInit {

  ecuries : Array<Ecurie>;

  constructor(private appConfig: AppConfigService,  private courseService : CourseService) { }

  list(): Array<Ecurie> {
    return this.courseService.findAllEcurie();
  }


  ngOnInit(): void {
  }

}
