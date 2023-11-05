import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PragaCardListComponent } from './components/praga-card-list/praga-card-list.component';
import { PragaViewComponent } from './components/praga-view/praga-view.component';


const routes: Routes = [
  {path: 'card-list', component: PragaCardListComponent},
  {path: 'view', component: PragaViewComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PragaRoutingModule { }