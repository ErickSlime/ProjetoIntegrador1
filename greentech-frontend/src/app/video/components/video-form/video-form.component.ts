import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Video } from 'src/app/models/video.model';
import { VideoService } from 'src/app/services/video.service';

@Component({
  selector: 'app-video-form',
  templateUrl: './video-form.component.html',
  styleUrls: ['./video-form.component.css']
})
export class VideoFormComponent implements OnInit {

  formGroup: FormGroup;
  apiResponse: any = null;
  videos: Video[] = [];

  totalRegistros = 17;
  pageSize = 10;
  pagina = 0;

  ngOnInit(): void {

    this.videoService.findAll().subscribe(data => {
      this.videos = data;
      this.initializeForm();
    });
    this.initializeForm();
  }

constructor(private formBuilder: FormBuilder,
  private activatedRoute: ActivatedRoute,
  private router: Router,
  private videoService: VideoService) {

    this.formGroup = this.formBuilder.group({
      id:[null],
      nome:[ '', Validators.required],
      urlVideo:[ '', Validators.required],
      descricao:[ '', Validators.required]
    })
}

initializeForm(){
  const video: Video = this.activatedRoute.snapshot.data['video'];

  this.formGroup = this.formBuilder.group({
    id: [(video && video.id) ? video.id : null],
    nome: [(video && video.nome) ? video.nome : '', Validators.required],
    urlVideo: [(video && video.urlVideo) ? video.urlVideo : '', Validators.required],
    descricao: [(video && video.descricao) ? video.descricao : '', Validators.required]
  })

}

salvar() {
  if (this.formGroup.valid) {
    const video = this.formGroup.value;
    console.log(video);
    if (video.id == null) {
      this.videoService.save(video).subscribe({
        next: (videoCadastrada) => {
          this.router.navigateByUrl('/videos/card-list');
        }}
        )
      }
      }
}

}
