import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Subscription } from 'rxjs';
import { HomeService } from 'src/app/core/services/home.service';

@Component({
  selector: 'app-waypoint',
  templateUrl: './waypoint.component.html',
  styleUrls: ['./waypoint.component.scss']
})
export class WaypointComponent implements OnInit {

  airportId: string;
  private subscriptions: Subscription;

  constructor(
    private activatedRoute:ActivatedRoute,
    private homeService: HomeService
  ) { 
    this.airportId = "";
    this.subscriptions  = new Subscription();
  }

  ngOnInit(): void {
    this.subscriptions.add(this.activatedRoute.params.subscribe((params:Params) => {
      this.airportId = params['id'];
    }))
  }

}
