import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'
import { AppRoutingModule, routingComponents } from './app-routing.module';
import { AppComponent } from './app.component';

import { CarService } from './shared/car/car.service';
import { RideService } from './shared/ride/ride.service';
import { LocationService } from './shared/location/location.service';
import { EmployeeService } from './shared/employee/employee.service';
import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule, MatTableModule, MatPaginatorModule, MatSortModule, MatSidenavModule, MatIconModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from "@angular/common/http";

import { AgmCoreModule } from "@agm/core";

import { NavbarComponent } from './components/navbar/navbar.component';
import { LayoutModule } from '@angular/cdk/layout';
import { DriverCreateComponent } from './components/driver/driver-create/driver-create.component';
import { DriverViewComponent } from './components/driver/driver-view/driver-view.component';
import { Location } from '@angular/common';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    routingComponents,
    DriverCreateComponent,
    DriverViewComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyAcATQVmZqd3v9C-GA5j6mdYYCfalSxmKM'
    }),
    FormsModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    LayoutModule,
    MatSidenavModule,
    MatIconModule
  ],
  providers: [CarService, EmployeeService, RideService, LocationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
