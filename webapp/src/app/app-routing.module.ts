import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CarListComponent } from './components/car/car-list/car-list.component';
import { TrackingComponent } from './components/tracking/tracking.component';
import { StatisticComponent } from './components/statistic/statistic.component';
import { DriversComponent } from './components/drivers/drivers.component';
import { RezervationsComponent } from './components/rezervations/rezervations.component';
import { CarCreateComponent } from './components/car/car-create/car-create.component';
import { CarViewComponent } from './components/car/car-view/car-view.component';
const routes: Routes = [
  { path: 'car-list',
    component: CarListComponent
  },
  {
    path: 'car-create',
    component: CarCreateComponent
  },
  {
    path: 'car-view/:id',
    component: CarViewComponent
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
export const routingComponents = [
  CarListComponent, 
  TrackingComponent, 
  StatisticComponent, 
  DriversComponent,
  RezervationsComponent, 
  CarCreateComponent,
  CarViewComponent
]