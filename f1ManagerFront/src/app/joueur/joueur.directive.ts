import { Directive } from '@angular/core';

import { Ecurie } from '../model';


@Directive({
  selector: '[appJoueur]'
})
export class JoueurDirective {

ecurie:Ecurie;

  constructor() { 

  }

// findEcurie(id:number){
//   return this.ecurieService.findById(id);
// }

}
