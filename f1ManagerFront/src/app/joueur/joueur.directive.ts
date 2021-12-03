import { Directive } from '@angular/core';
import { AppConfigService } from '../app-config.service';
import { EcurieService } from '../ecurie/ecurie.service';
import { Ecurie } from '../model';


@Directive({
  selector: '[appJoueur]'
})
export class JoueurDirective {

ecurie:Ecurie;

  constructor(private appConfig: AppConfigService, private ecurieService: EcurieService) { 

  }

findEcurie(id:number){
  return this.ecurieService.findById(id);
}

}
