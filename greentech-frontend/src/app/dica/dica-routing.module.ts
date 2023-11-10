import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DicaCardListComponent } from './components/dica-card-list/dica-card-list.component';
import { DicaViewComponent } from './components/dica-view/dica-view.component';
import { DicaFormComponent } from './components/dica-form/dica-form.component';


const routes: Routes = [
  {path: 'card-list', component: DicaCardListComponent},
  {path: 'view', component: DicaViewComponent},
  {path: 'dica-form', component: DicaFormComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DicaRoutingModule { }
