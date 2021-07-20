import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { TitleComponent } from './core/components/title/title.component';
import { MatTabsModule } from '@angular/material/tabs';
import { TabsComponent } from './features/components/tabs/tabs.component';
import { HomeComponent } from './features/pages/home/home.component';
import { SidComponent } from './features/pages/home/sid/sid.component';
import { StarComponent } from './features/pages/home/star/star.component';
import { WaypointComponent } from './features/pages/waypoint/waypoint.component';
import { HttpErrorInterceptor } from './core/interceptors/http-error.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    TitleComponent,
    TabsComponent,
    HomeComponent,
    SidComponent,
    StarComponent,
    WaypointComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatTabsModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HttpErrorInterceptor,
      multi:true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
