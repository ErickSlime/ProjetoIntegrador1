import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Dica } from 'src/app/models/dica.model';
import { Planta } from 'src/app/models/planta.model';
import { DicaService } from 'src/app/services/dica.service';
import { PlantaService } from 'src/app/services/planta.service';

@Component({
  selector: 'app-dica-form',
  templateUrl: './dica-form.component.html',
  styleUrls: ['./dica-form.component.css']
})
export class DicaFormComponent implements OnInit{

  formGroup: FormGroup;
  apiResponse: any = null;
  dicas: Dica[] = [];
  plantas: Planta[] = [];

  totalRegistros = 17;
  pageSize = 10;
  pagina = 0;

  ngOnInit(): void {

    // buscando todos os plantas para o select
    this.plantaService.findAll().subscribe(data => {
      this.plantas = data;
      this.initializeForm();
    });
    this.initializeForm();
  }

constructor(private formBuilder: FormBuilder,
  private activatedRoute: ActivatedRoute,
  private router: Router,
  private plantaService: PlantaService,
  private dicaService: DicaService) {

    this.formGroup = this.formBuilder.group({
      id:[null],
      nome:[ '', Validators.required],
      descricao:[ '', Validators.required],
      nomeImagem:[ '', Validators.required],
      planta: [null]
    })
}

initializeForm(){
  const dica: Dica = this.activatedRoute.snapshot.data['dica'];

  const planta = this.plantas.find(planta => planta.id === (dica?.planta?.id || null));

  this.formGroup = this.formBuilder.group({
    id: [(dica && dica.id) ? dica.id : null],
    nome: [(dica && dica.nome) ? dica.nome : '', Validators.required],
    descricao: [(dica && dica.descricao) ? dica.descricao : '', Validators.required],
    nomeImagem: [(dica && dica.nomeImagem) ? dica.nomeImagem : '', Validators.required],
    planta:[planta]
  })

}

salvar() {
  if (this.formGroup.valid) {
    const dica = this.formGroup.value;
    console.log(dica);
    if (dica.id == null) {
      this.dicaService.save(dica).subscribe({
        next: (dicaCadastrada) => {
          this.router.navigateByUrl('/dicas/card-list');
        }}
        )
      }
      }
}

}
