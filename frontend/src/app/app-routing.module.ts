import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './features/pages/home/home.component';
import { WaypointComponent } from './features/pages/waypoint/waypoint.component';

const routes: Routes = [
  {
    path:"",
    component: HomeComponent,
  }, 
  {
    path:"airport/:id",
    component: WaypointComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
