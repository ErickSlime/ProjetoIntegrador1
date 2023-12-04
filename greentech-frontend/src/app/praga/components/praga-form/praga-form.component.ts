import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Especie } from 'src/app/models/especie.model';
import { Praga } from 'src/app/models/praga.model';
import { EspecieService } from 'src/app/services/especie.service';
import { PragaService } from 'src/app/services/praga.service';
import { FamiliaService } from 'src/app/services/familia.service';
import { Familia } from 'src/app/models/familia.model';

@Component({
  selector: 'app-praga-form',
  templateUrl: './praga-form.component.html',
  styleUrls: ['./praga-form.component.css']
})
export class PragaFormComponent implements OnInit {

  formGroup: FormGroup;
  apiResponse: any = null;
  pragas: Praga[] = [];
  especies: Especie[] = [];
  familias: Familia[] = [];

  totalRegistros = 17;
  pageSize = 10;
  pagina = 0;

  ngOnInit(): void {

    // buscando todos os especies para o select
    this.familiaService.findAll().subscribe(data => {
      this.familias = data;
      this.initializeForm();
    });
    this.initializeForm();
  }

constructor(private formBuilder: FormBuilder,
  private activatedRoute: ActivatedRoute,
  private router: Router,
  private familiaService: FamiliaService,
  private pragaService: PragaService) {

    this.formGroup = this.formBuilder.group({
      id:[null],
      nome:[ '', Validators.required],
      nomeImagem:[ '', Validators.required],
      descricao:[ '', Validators.required],
      especie: this.formBuilder.group({
        nome:[ '', Validators.required],
        caracteristicas:[ '', Validators.required],
        familia:[null]
      })
    })
}

initializeForm(){
  const praga: Praga = this.activatedRoute.snapshot.data['praga'];

  const familia = this.familias.find(familia => familia.id === (praga?.especie?.familia?.id || null));

  this.formGroup = this.formBuilder.group({
    id: [(praga && praga.id) ? praga.id : null],
    nome: [(praga && praga.nome) ? praga.nome : '', Validators.required],
    nomeImagem: [(praga && praga.nomeImagem) ? praga.nomeImagem : '', Validators.required],
    descricao: [(praga && praga.descricao) ? praga.descricao : '', Validators.required],
    especie: this.formBuilder.group({
      nome: [(praga && praga.especie && praga.especie.nome) || '', Validators.required],
      caracteristicas: [ (praga && praga.especie && praga.especie.caracteristicas) || '', Validators.required],
      familia: [familia]
  }),
  })

  this.formGroup = this.formBuilder.group({
    id: [(praga && praga.id) ? praga.id : null],
    nome: [(praga && praga.nome) ? praga.nome : '', Validators.required],
    nomeImagem: [(praga && praga.nomeImagem) ? praga.nomeImagem : '', Validators.required],
    descricao: [(praga && praga.descricao) ? praga.descricao : '', Validators.required],
    especie: this.formBuilder.group({
      nome: [(praga && praga.especie && praga.especie.nome) || '', Validators.required],
      caracteristicas: [ (praga && praga.especie && praga.especie.caracteristicas) || '', Validators.required],
      familia: [familia]
  }),
  })

}

salvar() {
  if (this.formGroup.valid) {
    const praga = this.formGroup.value;
    console.log(praga);
    if (praga.id == null) {
      this.pragaService.save(praga).subscribe({
        next: (pragaCadastrada) => {
          this.router.navigateByUrl('/pragas/card-list');
        }}
        )
      } else {
        this.pragaService.update(praga).subscribe({
          next: (pragaCadastrado) => {
            this.router.navigateByUrl('/pragas/card-list');
          }})}
      }
}

}
