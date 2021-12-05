import { Component, OnInit } from '@angular/core';
import { AppConfigService } from '../app-config.service';
import { Ecurie, Infrastructure } from '../model';
import { InfrastructureInventaireService } from './infrastructure-inventaire.service';

@Component({
  selector: 'app-infrastructure-inventaire',
  templateUrl: './infrastructure-inventaire.component.html',
  styleUrls: ['./infrastructure-inventaire.component.scss']
})
export class InfrastructureInventaireComponent implements OnInit {

  ecurie: Ecurie;

  constructor(private appConfig: AppConfigService, private infrastructureInventaireService: InfrastructureInventaireService) {
    this.listInfrastructuresEcurie(1);
  }

  ngOnInit(): void {
  }

  list(): Array<Infrastructure> {
       return this.infrastructureInventaireService.findAll();
    
  }


  listInfrastructuresEcurie(id: number) {
    this.infrastructureInventaireService.loadEcurie(id).subscribe(response => {
      this.ecurie = response;
      }, error => console.log(error));
  }

  select(infrastructure: Infrastructure) {
    this.ecurie.infrastructures[0] = infrastructure;
      }

  valider()
  {
    this.infrastructureInventaireService.saveEcurie(this.ecurie);
  }
}

