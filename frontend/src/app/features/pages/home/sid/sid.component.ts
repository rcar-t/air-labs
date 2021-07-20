import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Subscription } from 'rxjs';
import { Waypoint } from 'src/app/core/models/Waypoint';
import { HomeService } from 'src/app/core/services/home.service';

@Component({
  selector: 'app-sid',
  templateUrl: './sid.component.html',
  styleUrls: ['./sid.component.scss']
})
export class SidComponent implements OnInit {

  airportId: string;
  private subscriptions: Subscription;
  public waypoints: Array<Waypoint>;

  constructor(
    private activatedRoute:ActivatedRoute,
    private homeService: HomeService
    ) { 
      this.airportId = "";
      this.subscriptions  = new Subscription();
      this.waypoints = [];
    }

  ngOnInit(): void {
    this.subscriptions.add(this.activatedRoute.params.subscribe((params:Params) => {
      this.airportId = params['id'];
      this.getWaypoints(this.airportId);
    }));
    
  }

  getWaypoints(airportId:string) {
    this.subscriptions.add(
      this.homeService
        .getTopWaypointsBySid(airportId)
        .subscribe((waypoints) => {
          this.waypoints = waypoints;
          console.log(waypoints);
        })
    )
  }

}
