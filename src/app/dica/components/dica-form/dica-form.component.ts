import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Dica } from 'src/app/models/dica.model';

@Component({
  selector: 'app-dica-form',
  templateUrl: './dica-form.component.html',
  styleUrls: ['./dica-form.component.css']
})
export class DicaFormComponent {

  formGroup: FormGroup;
  apiResponse: any = null;
  dicas: Dica[] = [];

  totalRegistros = 17;
  pageSize = 10;
  pagina = 0;

constructor(private formBuilder: FormBuilder,
  private activatedRoute: ActivatedRoute) {

  const dica: Dica = this.activatedRoute.snapshot.data['dica'];
  this.formGroup = formBuilder.group({
    id: [(dica && dica.id) ? dica.id : null],
    nome: [(dica && dica.nome) ? dica.nome : '', Validators.required],
    descricao: [(dica && dica.descricao) ? dica.descricao : '', Validators.required]
  })
}

}
