import { Component, OnInit, Signal, signal } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { Praga } from 'src/app/models/praga.model';
import { PragaService } from 'src/app/services/praga.service';

type Card = {
  id: number;
  titulo: string;
  descricao: string;
  urlImg: string;
}

@Component({
  selector: 'app-praga-card-list',
  templateUrl: './praga-card-list.component.html',
  styleUrls: ['./praga-card-list.component.css']
})
export class PragaCardListComponent implements OnInit {
  cards = signal<Card[]> ([]);
  pragas: Praga[] = [];
  totalRegistros = 0;
  filtro: string = "";
  pageSize = 10;
  pagina = 0;
  constructor(private pragaService: PragaService) {}

  ngOnInit(): void {
    this.carregarPragas();
    this.carregarTotalRegistros();
  }

  carregarPragas() {
    if(this.filtro){
      this.pragaService.findByNome(this.filtro,this.pagina, this.pageSize).subscribe(data => {
        this.pragas = data;
        this.carregarCards();
      })

    }else{

    this.pragaService.findAll().subscribe(data => {
      this.pragas = data;
      this.carregarCards();
    })
  };
  
  }

  carregarTotalRegistros() {
    if(this.filtro){
      this.pragaService.countByNome(this.filtro).subscribe(data => {
        this.totalRegistros = data;})
    }else{

    this.pragaService.count().subscribe(data => {
      this.totalRegistros = data;
    });
  }
  }

    // Método para paginar os resultados
    paginar(event: PageEvent): void {
      this.pagina = event.pageIndex;
      this.pageSize = event.pageSize;
      this.carregarPragas();
    }

  carregarCards() {
    const cards: Card[] = [];
    this.pragas.forEach(praga => {
      cards.push({
        id: praga.id,
        titulo: praga.nome,
        descricao: praga.descricao,
        urlImg: praga.nomeImagem
      });
    });
    this.cards.set(cards);
  }

  aplicarFiltro() {
    this.carregarPragas();
  
  }
}
