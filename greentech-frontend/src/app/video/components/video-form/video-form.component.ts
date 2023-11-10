import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Video } from 'src/app/models/video.model';

@Component({
  selector: 'app-video-form',
  templateUrl: './video-form.component.html',
  styleUrls: ['./video-form.component.css']
})
export class VideoFormComponent {

  formGroup: FormGroup;
  apiResponse: any = null;
  videos: Video[] = [];

  totalRegistros = 17;
  pageSize = 10;
  pagina = 0;

constructor(private formBuilder: FormBuilder,
  private activatedRoute: ActivatedRoute) {

  const video: Video = this.activatedRoute.snapshot.data['video'];
  this.formGroup = formBuilder.group({
    id: [(video && video.id) ? video.id : null],
    nome: [(video && video.nome) ? video.nome : '', Validators.required],
    descricao: [(video && video.descricao) ? video.descricao : '', Validators.required]
  })
}

}
