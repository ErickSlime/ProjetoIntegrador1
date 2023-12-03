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
  
  excluir(dica: Dica) {
    if (confirm('Deseja realmente excluir a dica?')) {
      this.dicaService.delete(dica).subscribe(
        () => {
          console.log('Dica excluída com sucesso!');
          this.router.navigate(['/dicas/card-list']);
        },
        (error) => {
          console.error('Erro ao excluir a dica:', error);
          // Handle the error as needed.
        }
      );
    }
  }

}
