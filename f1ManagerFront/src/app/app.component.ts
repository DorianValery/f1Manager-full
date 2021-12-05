import { Component } from '@angular/core';
import { SeConnecterHttpService } from './se-connecter/se-connecter-http.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'f1ManagerFront';

  constructor(public seconnecterService: SeConnecterHttpService) {
  }

  sedeconnecter() {
    this.seconnecterService.sedeconnecter();
  }

}
