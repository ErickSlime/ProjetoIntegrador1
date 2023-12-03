import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Video } from 'src/app/models/video.model';
import { VideoService } from 'src/app/services/video.service';

@Component({
  selector: 'app-video-view',
  templateUrl: './video-view.component.html',
  styleUrls: ['./video-view.component.css']
})
export class VideoViewComponent {

  video!: Video;

  constructor(private videoService: VideoService,
    private router: Router,
    private activatedRoute: ActivatedRoute) { }

  ngOnInit() {

    this.initializeForm();
  }

  initializeForm() {

    this.video = this.activatedRoute.snapshot.data['video'];
    console.log(this.video.urlVideo);

  }

  excluir(video: Video) {
    if (confirm('Deseja realmente excluir este video?')) {
      this.videoService.delete(video).subscribe(
        () => {
          console.log('Video excluído com sucesso!');
          this.router.navigate(['/videos/card-list']);
        },
        (error) => {
          console.error('Erro ao excluir o video:', error);
          // Handle the error as needed.
        }
      );
    }
  }

}
