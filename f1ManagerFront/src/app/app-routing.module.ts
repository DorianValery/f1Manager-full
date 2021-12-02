import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { VoitureInventaireComponent } from './voiture-inventaire/voiture-inventaire.component';

const routes: Routes = [
  {path: 'voitureInventaire', component: VoitureInventaireComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
