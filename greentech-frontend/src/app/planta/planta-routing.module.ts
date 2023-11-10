import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PlantaCardListComponent } from './components/planta-card-list/planta-card-list.component';
import { PlantaViewComponent } from './components/planta-view/planta-view.component';
import { PlantaFormComponent } from './components/planta-form/planta-form.component';


const routes: Routes = [
  {path: 'card-list', component: PlantaCardListComponent},
  {path: 'view', component: PlantaViewComponent},
  {path: 'planta-form', component: PlantaFormComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PlantaRoutingModule { }
