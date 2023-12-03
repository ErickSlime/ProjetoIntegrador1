import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Praga } from 'src/app/models/praga.model';
import { PragaService } from 'src/app/services/praga.service';

@Component({
  selector: 'app-praga-view',
  templateUrl: './praga-view.component.html',
  styleUrls: ['./praga-view.component.css']
})
export class PragaViewComponent implements OnInit {

  praga!: Praga;

  constructor(private pragaService: PragaService,
    private router: Router,
    private activatedRoute: ActivatedRoute) { }

  ngOnInit() {

    this.initializeForm();
  }

  initializeForm() {

    this.praga = this.activatedRoute.snapshot.data['praga'];

  }

  excluir(praga: Praga) {
    if (confirm('Deseja realmente excluir a praga?')) {
      this.pragaService.delete(praga).subscribe(
        () => {
          console.log('Praga excluída com sucesso!');
          this.router.navigate(['/pragas/card-list']);
        },
        (error) => {
          console.error('Erro ao excluir a praga:', error);
          // Handle the error as needed.
        }
      );
    }
  }

}
