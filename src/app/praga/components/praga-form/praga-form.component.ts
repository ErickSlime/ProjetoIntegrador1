import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Praga } from 'src/app/models/praga.model';

@Component({
  selector: 'app-praga-form',
  templateUrl: './praga-form.component.html',
  styleUrls: ['./praga-form.component.css']
})
export class PragaFormComponent {

  formGroup: FormGroup;
  apiResponse: any = null;
  pragas: Praga[] = [];

  totalRegistros = 17;
  pageSize = 10;
  pagina = 0;

constructor(private formBuilder: FormBuilder,
  private activatedRoute: ActivatedRoute) {

  const praga: Praga = this.activatedRoute.snapshot.data['praga'];
  this.formGroup = formBuilder.group({
    id: [(praga && praga.id) ? praga.id : null],
    nome: [(praga && praga.nome) ? praga.nome : '', Validators.required],
    descricao: [(praga && praga.descricao) ? praga.descricao : '', Validators.required]
  })
}

}
