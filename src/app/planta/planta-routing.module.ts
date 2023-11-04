import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PlantaCardListComponent } from './components/planta-card-list/planta-card-list.component';
import { PlantaViewComponent } from './components/planta-view/planta-view.component';


const routes: Routes = [
  {path: 'card-list', component: PlantaCardListComponent},
  {path: 'view', component: PlantaViewComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PlantaRoutingModule { }
