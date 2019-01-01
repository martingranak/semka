import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { CarService } from './shared/car/car.service';
import { CarListComponent } from './car-list/car-list.component';

import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule, MatTableModule, MatPaginatorModule, MatSortModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from "@angular/common/http";

import { AgmCoreModule } from "@agm/core";

import { NavbarComponent } from './navbar/navbar.component';
import { TrackingComponent } from './tracking/tracking.component';
import { StatisticComponent } from './statistic/statistic.component';


@NgModule({
  declarations: [
    AppComponent,
    CarListComponent,
    NavbarComponent,
    TrackingComponent,
    StatisticComponent
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
    MatTableModule,
    MatPaginatorModule,
    MatSortModule
  ],
  providers: [CarService],
  bootstrap: [AppComponent]
})
export class AppModule { }
