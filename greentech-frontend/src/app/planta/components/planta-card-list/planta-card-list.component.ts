import { Component, OnInit, Signal, signal } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { Planta } from 'src/app/models/planta.model';
import { PlantaService } from 'src/app/services/planta.service';

type Card = {
  id: number;
  titulo: string;
  especieP: string;
  urlImg: string;
}

@Component({
  selector: 'app-planta-card-list',
  templateUrl: './planta-card-list.component.html',
  styleUrls: ['./planta-card-list.component.css']
})
export class PlantaCardListComponent implements OnInit {

  cards = signal<Card[]> ([]);
  plantas: Planta[] = [];
  totalRegistros = 0;
  filtro: string = "";
  pageSize = 10;
  pagina = 0;
  constructor(private plantaService: PlantaService) {}

  ngOnInit(): void {
    this.carregarPlantas();
    this.carregarTotalRegistros();
  }

  carregarPlantas() {
    if(this.filtro){
      this.plantaService.findByNome(this.filtro,this.pagina, this.pageSize).subscribe(data => {
        this.plantas = data;
        this.carregarCards();
      })

    }else{

    this.plantaService.findAll().subscribe(data => {
      this.plantas = data;
      this.carregarCards();
    })
  };
  
  }

  carregarTotalRegistros() {
    if(this.filtro){
      this.plantaService.countByNome(this.filtro).subscribe(data => {
        this.totalRegistros = data;})
    }else{

    this.plantaService.count().subscribe(data => {
      this.totalRegistros = data;
    });
  }
  }

    // Método para paginar os resultados
    paginar(event: PageEvent): void {
      this.pagina = event.pageIndex;
      this.pageSize = event.pageSize;
      this.carregarPlantas();
    }

  carregarCards() {
    const cards: Card[] = [];
    this.plantas.forEach(planta => {
      cards.push({
        id: planta.id,
        titulo: planta.nome,
        especieP: planta.especie.nome,
        urlImg: planta.nomeImagem
      });
    });
    this.cards.set(cards);
  }

  aplicarFiltro() {
    this.carregarPlantas();
  
  }

}
