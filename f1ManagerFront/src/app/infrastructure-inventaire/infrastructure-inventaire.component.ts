import { Component, OnInit } from '@angular/core';
import { AppConfigService } from '../app-config.service';
import { EcurieService } from '../ecurie/ecurie.service';
import { InventaireService } from '../inventaire/inventaire.service';
import { JoueurService } from '../joueur/joueur.service';
import { Ecurie, Infrastructure, Inventaire } from '../model';
import { InfrastructureInventaireService } from './infrastructure-inventaire.service';

@Component({
  selector: 'app-infrastructure-inventaire',
  templateUrl: './infrastructure-inventaire.component.html',
  styleUrls: ['./infrastructure-inventaire.component.scss']
})
export class InfrastructureInventaireComponent implements OnInit {

  ecurie: Ecurie;

  constructor(private appConfig: AppConfigService, private infrastructureInventaireService: InfrastructureInventaireService, private ecurieService: EcurieService, private inventaireService: InventaireService, private joueurService: JoueurService) {
    this.ecurie=this.ecurieService.ecurie;
    console.log(this.ecurie);
  }

  ngOnInit(): void {
  }

  list(): Array<Infrastructure> {
       return this.infrastructureInventaireService.findAll();
    
  }


  // listInfrastructuresEcurie(id: number) {
  //   this.infrastructureInventaireService.loadEcurie(id).subscribe(response => {
  //     this.ecurie = response;
  //     }, error => console.log(error));
  // }

  select(infrastructure: Infrastructure) {
    this.ecurie.infrastructures[0] = infrastructure;
    console.log(this.ecurie);
    console.log(infrastructure);
      }

  valider()
  {
    this.ecurieService.ecurie.infrastructures = this.ecurie.infrastructures;
  }

  acheter(infrastructure: Infrastructure){
    if (this.ecurieService.ecurie.argent > infrastructure.prix){
      this.ecurieService.ecurie.argent = this.ecurieService.ecurie.argent - infrastructure.prix;
      this.ecurieService.modify(this.ecurieService.ecurie);
      this.ecurie.argent = this.ecurieService.ecurie.argent;
      this.inventaireService.create(new Inventaire(null, null, this.joueurService.joueur, null,null, infrastructure)).subscribe(resp => {
        this.infrastructureInventaireService.load();
      }, error => console.log(error));
    }
}
}

