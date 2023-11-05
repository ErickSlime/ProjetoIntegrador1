import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [

  {
    path: 'plantas', loadChildren:
      () => import('./planta/planta.module')
        .then(m => m.PlantaModule)
  },

  {
    path: 'home', loadChildren:
      () => import('./home/home.module')
        .then(m => m.HomeModule)
  },

  {
    path: 'usuarios', loadChildren:
      () => import('./usuario/usuario.module')
        .then(m => m.UsuarioModule)
  },

  {
    path: 'pragas', loadChildren:
      () => import('./praga/praga.module')
        .then(m => m.PragaModule)
  },

  {
    path: 'dicas', loadChildren:
      () => import('./dica/dica.module')
        .then(m => m.DicaModule)
  },

  {
    path: 'videos', loadChildren:
      () => import('./video/video.module')
        .then(m => m.VideoModule)
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
