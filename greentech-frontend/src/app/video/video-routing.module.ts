import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { VideoCardListComponent } from './components/video-card-list/video-card-list.component';
import { VideoViewComponent } from './components/video-view/video-view.component';
import { VideoFormComponent } from './components/video-form/video-form.component';


const routes: Routes = [
  {path: 'card-list', component: VideoCardListComponent},
  {path: 'view', component: VideoViewComponent},
  {path: 'video-form', component: VideoFormComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class VideoRoutingModule { }
