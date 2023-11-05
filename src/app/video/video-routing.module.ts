import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { VideoCardListComponent } from './components/video-card-list/video-card-list.component';
import { VideoViewComponent } from './components/video-view/video-view.component';


const routes: Routes = [
  {path: 'card-list', component: VideoCardListComponent},
  {path: 'view', component: VideoViewComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class VideoRoutingModule { }
