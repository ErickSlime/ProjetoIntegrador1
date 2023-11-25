import { Component, OnInit, Signal, signal } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { Dica } from 'src/app/models/dica.model';
import { DicaService } from 'src/app/services/dica.service';

type Card = {
  id: number;
  titulo: string;
  descricao: string;
}

@Component({
  selector: 'app-dica-card-list',
  templateUrl: './dica-card-list.component.html',
  styleUrls: ['./dica-card-list.component.css']
})
export class DicaCardListComponent implements OnInit {
  cards = signal<Card[]> ([]);
  dicas: Dica[] = [];
  totalRegistros = 0;
  filtro: string = "";
  pageSize = 10;
  pagina = 0;
  constructor(private dicaService: DicaService) {}

  ngOnInit(): void {
    this.carregarDicas();
    this.carregarTotalRegistros();
  }

  carregarDicas() {
    if(this.filtro){
      this.dicaService.findByNome(this.filtro,this.pagina, this.pageSize).subscribe(data => {
        this.dicas = data;
        this.carregarCards();
      })

    }else{

    this.dicaService.findAll().subscribe(data => {
      this.dicas = data;
      this.carregarCards();
    })
  };
  
  }

  carregarTotalRegistros() {
    if(this.filtro){
      this.dicaService.countByNome(this.filtro).subscribe(data => {
        this.totalRegistros = data;})
    }else{

    this.dicaService.count().subscribe(data => {
      this.totalRegistros = data;
    });
  }
  }

    // Método para paginar os resultados
    paginar(event: PageEvent): void {
      this.pagina = event.pageIndex;
      this.pageSize = event.pageSize;
      this.carregarDicas();
    }

  carregarCards() {
    const cards: Card[] = [];
    this.dicas.forEach(dica => {
      cards.push({
        id: dica.id,
        titulo: dica.nome,
        descricao: dica.nomeImagem
      });
    });
    this.cards.set(cards);
  }

  aplicarFiltro() {
    this.carregarDicas();
  
  }

}
