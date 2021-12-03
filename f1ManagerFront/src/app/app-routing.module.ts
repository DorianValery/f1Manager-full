import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MenuComponent } from './menu/menu.component';
import { PiloteInventaireComponent } from './pilote-inventaire/pilote-inventaire.component';
import { VoitureInventaireComponent } from './voiture-inventaire/voiture-inventaire.component';

const routes: Routes = [
  { path: "pilote", component: PiloteInventaireComponent },
 // { path: "infrastructure", component: InfrastructureInventaireComponent }
  {path: "ecurie", component : MenuComponent},
  {path: "voiture", component: VoitureInventaireComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
