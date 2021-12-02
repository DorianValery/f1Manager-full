import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MenuComponent } from './menu/menu.component';

const routes: Routes = [
  // { path: "pilote-inventaire", component: PiloteInventaireComponent },
  // { path: "voiture-inventaire", component: VoitureInventaireComponent },
  // { path: "infrastructure-inventaire", component: InfrastructureInventaireComponent }
  {path: "ecurie", component : MenuComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
