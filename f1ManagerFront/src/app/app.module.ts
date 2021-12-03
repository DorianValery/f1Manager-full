import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PiloteInventaireComponent } from './pilote-inventaire/pilote-inventaire.component';
import { AppConfigService } from './app-config.service';
import { MenuHttpService } from './menu/menu-http.service';
import { MenuComponent } from './menu/menu.component';
import { VoitureInventaireComponent } from './voiture-inventaire/voiture-inventaire.component';
import { VoitureInventaireService } from './voiture-inventaire/voiture-inventaire.service';
import { SaisonComponent } from './saison/saison.component';
import { SaisonService } from './saison/saison.service';

@NgModule({
  declarations: [
    AppComponent,
    PiloteInventaireComponent,
    AppComponent,
    MenuComponent,
    VoitureInventaireComponent,
    SaisonComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule, 
  ],
  providers: [AppConfigService,MenuHttpService, VoitureInventaireService, SaisonService],
  bootstrap: [AppComponent]
})
export class AppModule { }
