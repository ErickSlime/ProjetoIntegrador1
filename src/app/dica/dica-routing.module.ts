import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DicaCardListComponent } from './components/dica-card-list/dica-card-list.component';
import { DicaViewComponent } from './components/dica-view/dica-view.component';


const routes: Routes = [
  {path: 'card-list', component: DicaCardListComponent},
  {path: 'view', component: DicaViewComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DicaRoutingModule { }
