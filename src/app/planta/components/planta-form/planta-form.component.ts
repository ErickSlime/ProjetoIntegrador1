import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Planta } from 'src/app/models/planta.model';

@Component({
  selector: 'app-planta-form',
  templateUrl: './planta-form.component.html',
  styleUrls: ['./planta-form.component.css']
})
export class PlantaFormComponent {

  formGroup: FormGroup;
  apiResponse: any = null;
  plantas: Planta[] = [];

  totalRegistros = 17;
  pageSize = 10;
  pagina = 0;

constructor(private formBuilder: FormBuilder,
  private activatedRoute: ActivatedRoute) {

  const planta: Planta = this.activatedRoute.snapshot.data['planta'];
  this.formGroup = formBuilder.group({
    id: [(planta && planta.id) ? planta.id : null],
    nome: [(planta && planta.nome) ? planta.nome : '', Validators.required],
    descricao: [(planta && planta.descricao) ? planta.descricao : '', Validators.required]
  })
}


}
