import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PlantaCardListComponent } from './components/planta-card-list/planta-card-list.component';
import { PlantaViewComponent } from './components/planta-view/planta-view.component';
import { PlantaFormComponent } from './components/planta-form/planta-form.component';
import { plantaResolver } from './resolver/planta.resolver';


const routes: Routes = [
  {path: 'card-list', component: PlantaCardListComponent},
  {path: 'view/:id', component: PlantaViewComponent, resolve: {planta: plantaResolver}}, 
  {path: 'planta-form', component: PlantaFormComponent},
  {path: 'edit/:id', component: PlantaFormComponent, resolve: {planta: plantaResolver}}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PlantaRoutingModule { }
