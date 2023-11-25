import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Dica } from 'src/app/models/dica.model';
import { DicaService } from 'src/app/services/dica.service';

@Component({
  selector: 'app-dica-view',
  templateUrl: './dica-view.component.html',
  styleUrls: ['./dica-view.component.css']
})
export class DicaViewComponent {

  
  dica!: Dica;

  constructor(private dicaService: DicaService,
    private router: Router,
    private activatedRoute: ActivatedRoute) { }

  ngOnInit() {

    this.initializeForm();
  }

  initializeForm() {

    this.dica = this.activatedRoute.snapshot.data['dica'];

  }

}
