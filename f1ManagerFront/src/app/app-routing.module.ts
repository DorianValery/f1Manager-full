import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CourseComponent } from './course/course.component';
import { InfrastructureInventaireComponent } from './infrastructure-inventaire/infrastructure-inventaire.component';
import { InscriptionJoueurComponent } from './inscription-joueur/inscription-joueur.component';
import { MenuComponent } from './menu/menu.component';
import { PiloteInventaireComponent } from './pilote-inventaire/pilote-inventaire.component';
import { SaisonComponent } from './saison/saison.component';
import { SeConnecterComponent } from './se-connecter/se-connecter.component';
import { VoitureInventaireComponent } from './voiture-inventaire/voiture-inventaire.component';

const routes: Routes = [
  {path: "menu", component: MenuComponent},
  {path: "seconnecter", component: SeConnecterComponent},
  {path: "inscription", component: InscriptionJoueurComponent},
  {path: "pilote", component: PiloteInventaireComponent},
  {path: "ecurie", component : MenuComponent},
  {path: "voiture", component: VoitureInventaireComponent},
  {path: "infrastructure", component: InfrastructureInventaireComponent},
  {path: "course", component: SaisonComponent},
  {path: "jeu", component: CourseComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
