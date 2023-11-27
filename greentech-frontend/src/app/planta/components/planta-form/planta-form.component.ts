import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Especie } from 'src/app/models/especie.model';
import { Familia } from 'src/app/models/familia.model';
import { Planta } from 'src/app/models/planta.model';
import { TipoSolo } from 'src/app/models/tipo-solo.model';
import { EspecieService } from 'src/app/services/especie.service';
import { FamiliaService } from 'src/app/services/familia.service';
import { PlantaService } from 'src/app/services/planta.service';
import { TipoSoloService } from 'src/app/services/tipo-solo.service';

@Component({
  selector: 'app-planta-form',
  templateUrl: './planta-form.component.html',
  styleUrls: ['./planta-form.component.css']
})
export class PlantaFormComponent implements OnInit {

  formGroup: FormGroup;
  apiResponse: any = null;
  plantas: Planta[] = [];
  tipoSolos: TipoSolo[] = [];
  familias: Familia[] = [];

  totalRegistros = 17;
  pageSize = 10;
  pagina = 0;

  ngOnInit(): void {

    // buscando todos os plantas para o select
    this.tipoSoloService.findAll().subscribe(data => {
      this.tipoSolos = data;
      this.initializeForm();
    });
    this.familiaService.findAll().subscribe(data => {
      this.familias = data;
      this.initializeForm();
    });

    this.initializeForm();
  }

constructor(private formBuilder: FormBuilder,
  private activatedRoute: ActivatedRoute,
  private router: Router,
  private plantaService: PlantaService,
  private tipoSoloService: TipoSoloService,
  private familiaService: FamiliaService) {

    this.formGroup = this.formBuilder.group({
      id:[null],
      nome:[ '', Validators.required],
      nomeImagem:[ '', Validators.required],
      descricao:[ '', Validators.required],
      tipoSolo: [null],
      especie: this.formBuilder.group({
        nome:[ '', Validators.required],
        caracteristica:[ '', Validators.required],
        familia:[null]
      })
    })
}

initializeForm(){
  const planta: Planta = this.activatedRoute.snapshot.data['planta'];

  const tipoSolo = this.tipoSolos.find(tipoSolo => tipoSolo.id === (planta?.tipoSolo?.id || null));

  const familia = this.familias.find(familia => familia.id === (planta?.especie?.familia?.id || null));

  this.formGroup = this.formBuilder.group({
    id: [(planta && planta.id) ? planta.id : null],
    nome: [(planta && planta.nome) ? planta.nome : '', Validators.required],
    nomeImagem: [(planta && planta.nomeImagem) ? planta.nomeImagem : '', Validators.required],
    descricao: [(planta && planta.descricao) ? planta.descricao : '', Validators.required],
    tipoSolo:[tipoSolo],
    especie: this.formBuilder.group({
        nome: [(planta && planta.especie && planta.especie.nome) || '', Validators.required],
        caracteristica: [ (planta && planta.especie && planta.especie.caracteristicas) || '', Validators.required],
        familia: [familia]
    }),
  })

  this.formGroup = this.formBuilder.group({
    id: [(planta && planta.id) ? planta.id : null],
    nome: [(planta && planta.nome) ? planta.nome : '', Validators.required],
    nomeImagem: [(planta && planta.nomeImagem) ? planta.nomeImagem : '', Validators.required],
    descricao: [(planta && planta.descricao) ? planta.descricao : '', Validators.required],
    tipoSolo:[tipoSolo],
    especie: this.formBuilder.group({
      nome: [(planta && planta.especie && planta.especie.nome) || '', Validators.required],
      caracteristica: [ (planta && planta.especie && planta.especie.caracteristicas) || '', Validators.required],
      familia: [familia]
  }),
  })

}

salvar() {
  if (this.formGroup.valid) {
    const planta = this.formGroup.value;
    console.log(planta);
    if (planta.id == null) {
      this.plantaService.save(planta).subscribe({
        next: (plantaCadastrada) => {
          this.router.navigateByUrl('/plantas/card-list');
        }}
        )
      }
      }
}

}
