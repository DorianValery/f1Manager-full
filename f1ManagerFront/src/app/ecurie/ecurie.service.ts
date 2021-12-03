import { Injectable } from '@angular/core';
import { Ecurie, Joueur } from '../model';

@Injectable({
  providedIn: 'root'
})
export class EcurieService {

  ecuries: Array<Ecurie> = new Array<Ecurie>();

  findById(id: number): Ecurie {
    return this.ecuries.find(ecurie => ecurie.id == id);
  }

}
