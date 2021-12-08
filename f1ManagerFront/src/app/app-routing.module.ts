import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccueilComponent } from './accueil/accueil.component';
import { CourseComponent } from './course/course.component';
import { InfrastructureInventaireComponent } from './infrastructure-inventaire/infrastructure-inventaire.component';
import { InscriptionJoueurComponent } from './inscription-joueur/inscription-joueur.component';
import { MenuComponent } from './menu/menu.component';
import { PiloteInventaireComponent } from './pilote-inventaire/pilote-inventaire.component';
import { PodiumComponent } from './podium/podium.component';
import { SaisonComponent } from './saison/saison.component';
import { SeConnecterComponent } from './se-connecter/se-connecter.component';
import { VoitureInventaireComponent } from './voiture-inventaire/voiture-inventaire.component';

const routes: Routes = [
  { path: '', redirectTo: '/accueil', pathMatch: 'full' },
  {path: "accueil", component: AccueilComponent},
  {path: "menu", component: MenuComponent},
  {path: "seconnecter", component: SeConnecterComponent},
  {path: "inscription", component: InscriptionJoueurComponent},
  {path: "pilote", component: PiloteInventaireComponent},
  {path: "ecurie", component : MenuComponent},
  {path: "voiture", component: VoitureInventaireComponent},
  {path: "infrastructure", component: InfrastructureInventaireComponent},
  {path: "course", component: SaisonComponent},
  {path: "course/jeu", component: CourseComponent},
  {path: "podium", component: PodiumComponent},
  {path: "podium/course", component: SaisonComponent},
  {path: '', redirectTo: 'seconnecter', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
