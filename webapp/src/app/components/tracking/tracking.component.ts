import { Component, OnInit } from '@angular/core';
import { LocationService } from '../../shared/location/location.service';
import { ActivatedRoute } from '@angular/router'; 
@Component({
  selector: 'app-tracking',
  templateUrl: './tracking.component.html',
  styleUrls: ['./tracking.component.css']
})
export class TrackingComponent implements OnInit {
  locations: Array<any>;

  lon: number;
  lat: number;

  constructor(private route: ActivatedRoute,private locationService: LocationService) {};
  ngOnInit() {
    this.getLocations(this.route.snapshot.paramMap.get("id"));
  }

  getLocations(id: any):void {
    this.locationService.getAllByRide(id).subscribe( data => {
      this.locations = data;
      this.lat = data[0].latitude;
      this.lon = data[0].longitude
    });
  }
}
