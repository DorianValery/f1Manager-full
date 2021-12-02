import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MenuComponent } from './menu/menu.component';
import { VoitureInventaireComponent } from './voiture-inventaire/voiture-inventaire.component';

const routes: Routes = [
  // { path: "pilote-inventaire", component: PiloteInventaireComponent },
  // { path: "voiture-inventaire", component: VoitureInventaireComponent },
  // { path: "infrastructure-inventaire", component: InfrastructureInventaireComponent }
  {path: "ecurie", component : MenuComponent}
  {path: 'voitureInventaire', component: VoitureInventaireComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
