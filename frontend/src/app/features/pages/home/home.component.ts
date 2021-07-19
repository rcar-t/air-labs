import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { Airport } from 'src/app/core/models/Airport';
import { HomeService } from 'src/app/core/services/home.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  private subscriptions: Subscription;
  public airports: Array<Airport>;
  
  constructor(
    private homeService: HomeService,
    private router: Router
  ) { 
    this.subscriptions = new Subscription();
    this.airports = [];
  }

  ngOnInit(): void {
    this.getAllAirports();
  }

  getAllAirports(): void {
    this.subscriptions.add(
      this.homeService
        .getAllAirports()
        .subscribe((airports) => {
          this.airports = airports;
          console.log(airports);
        })
    )
  }

  getWaypoints(id: string) {
    this.router.navigate(['airport', id]);
  }

}
