import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UsuarioFormComponent } from './components/usuario-form/usuario-form.component';
import { UsuarioLoginComponent } from './components/usuario-login/usuario-login.component';

const routes: Routes = [
 // { path: 'list', component: UsuarioListComponent },
  { path: 'new', component: UsuarioFormComponent },
  { path: 'login', component: UsuarioLoginComponent },
  { path: 'edit/:id', component: UsuarioFormComponent}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UsuarioRoutingModule { }