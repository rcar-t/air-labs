import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { TitleComponent } from './core/components/title/title.component';
import { MatTabsModule } from '@angular/material/tabs';
import { TabsComponent } from './features/components/tabs/tabs.component';
import { HomeComponent } from './features/pages/home/home.component';
import { SidComponent } from './features/pages/home/sid/sid.component';
import { StarComponent } from './features/pages/home/star/star.component';

@NgModule({
  declarations: [
    AppComponent,
    TitleComponent,
    TabsComponent,
    HomeComponent,
    SidComponent,
    StarComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatTabsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
