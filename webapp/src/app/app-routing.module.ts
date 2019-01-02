import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CarListComponent } from './components/car-list/car-list.component';
import { TrackingComponent } from './components/tracking/tracking.component';
import { StatisticComponent } from './components/statistic/statistic.component';
import { DriversComponent } from './components/drivers/drivers.component';
import { RezervationsComponent } from './components/rezervations/rezervations.component';
const routes: Routes = [
  { path: 'car-list',
    component: CarListComponent
  },
  {
    path: 'tracking',
    component: TrackingComponent
  },
  {
    path: 'statistics',
    component: StatisticComponent
  },
  {
    path : 'drivers',
    component: DriversComponent
  },
  {
    path : 'rezervations',
    component: RezervationsComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [CarListComponent, TrackingComponent, StatisticComponent, DriversComponent, RezervationsComponent]