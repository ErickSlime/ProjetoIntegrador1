import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PragaCardListComponent } from './components/praga-card-list/praga-card-list.component';
import { PragaViewComponent } from './components/praga-view/praga-view.component';
import { PragaFormComponent } from './components/praga-form/praga-form.component';
import { pragaResolver } from './resolver/praga.resolver';


const routes: Routes = [
  {path: 'card-list', component: PragaCardListComponent},
  {path: 'view/:id', component: PragaViewComponent, resolve: {praga: pragaResolver}},
  {path: 'praga-form', component: PragaFormComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PragaRoutingModule { }