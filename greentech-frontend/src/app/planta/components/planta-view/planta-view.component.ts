import { Component, OnInit, signal } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Especie } from 'src/app/models/especie.model';
import { Planta } from 'src/app/models/planta.model';
import { Praga } from 'src/app/models/praga.model';
import { TipoSolo } from 'src/app/models/tipo-solo.model';
import { PlantaService } from 'src/app/services/planta.service';

type Card = {
  id: number;
  titulo: string;
  descricao: string;
  urlImg: string;
}

@Component({
  selector: 'app-planta-view',
  templateUrl: './planta-view.component.html',
  styleUrls: ['./planta-view.component.css']
})
export class PlantaViewComponent implements OnInit{

  planta!: Planta;

  cards = signal<Card[]> ([]);
  pragas: Praga[] = [];

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
    this.carregarCards();

  }

  carregarCards() {
    const cards: Card[] = [];
    this.planta.pragas.forEach(praga => {
      cards.push({
        id: praga.id,
        titulo: praga.nome,
        descricao: praga.descricao,
        urlImg: praga.nomeImagem
      });
    });
    this.cards.set(cards);
  }

  excluir(planta: Planta) {
    if (confirm('Deseja realmente excluir a planta?')) {
      this.plantaService.delete(planta).subscribe(
        () => {
          console.log('Planta excluída com sucesso!');
          this.router.navigate(['/plantas/card-list']);
        },
        (error) => {
          console.error('Erro ao excluir a planta:', error);
          // Handle the error as needed.
        }
      );
    }
  }

}
