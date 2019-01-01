import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CarListComponent } from './car-list/car-list.component';
import { TrackingComponent } from './tracking/tracking.component';
import { StatisticComponent } from './statistic/statistic.component';
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
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
