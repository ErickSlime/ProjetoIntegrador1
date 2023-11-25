import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Especie } from 'src/app/models/especie.model';
import { Planta } from 'src/app/models/planta.model';
import { TipoSolo } from 'src/app/models/tipo-solo.model';
import { PlantaService } from 'src/app/services/planta.service';

@Component({
  selector: 'app-planta-view',
  templateUrl: './planta-view.component.html',
  styleUrls: ['./planta-view.component.css']
})
export class PlantaViewComponent implements OnInit{

  planta!: Planta;

  especies: Especie[] = [];
  tiposolos: TipoSolo[] = [];

  constructor(private plantaService: PlantaService,
    private router: Router,
    private activatedRoute: ActivatedRoute) { }

  ngOnInit() {

    this.initializeForm();
  }

  initializeForm() {

    this.planta = this.activatedRoute.snapshot.data['planta'];

  }

}
