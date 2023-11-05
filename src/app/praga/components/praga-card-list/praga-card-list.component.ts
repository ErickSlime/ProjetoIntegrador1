import { Component, OnInit, Signal, signal } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { Praga } from 'src/app/models/praga.model';

type Card = {
  titulo: string;
}

@Component({
  selector: 'app-praga-card-list',
  templateUrl: './praga-card-list.component.html',
  styleUrls: ['./praga-card-list.component.css']
})
export class PragaCardListComponent implements OnInit {

  cards = signal<Card[]> ([]);
  pragas: Praga[] = [];

  totalRegistros = 17;
  pageSize = 10;
  pagina = 0;

  constructor() {}

  ngOnInit(): void {
    this.pragas.push(
      { id:0, nome: 'Praga 1', descricao: 'sadasd'},
      { id:1, nome: 'Praga 2', descricao: 'sadasd'},
      { id:2, nome: 'Praga 3', descricao: 'sadasd'},
      { id:3, nome: 'Praga 4', descricao: 'sadasd'},
      { id:4, nome: 'Praga 5', descricao: 'sadasd'},
      { id:5, nome: 'Praga 6', descricao: 'sadasd'},
      { id:6, nome: 'Praga 7', descricao: 'sadasd'},
      { id:7, nome: 'Praga 8', descricao: 'sadasd'},
      { id:8, nome: 'Praga 9', descricao: 'sadasd'},
      { id:9, nome: 'Praga 10', descricao: 'sadasd'},
      { id:10, nome: 'Praga 11', descricao: 'sadasd'},
      { id:11, nome: 'Praga 12', descricao: 'sadasd'},
      { id:12, nome: 'Praga 13', descricao: 'sadasd'},
      { id:13, nome: 'Praga 14', descricao: 'sadasd'},
      { id:14, nome: 'Praga 15', descricao: 'sadasd'},
      { id:15, nome: 'Praga 16', descricao: 'sadasd'},
    );

    this.carregarCards();
  }

  carregarCards() {
    const cards: Card[] = [];
    this.pragas.forEach(praga => {
      cards.push({
        titulo: praga.nome
      });
    });
    this.cards.set(cards);
  }

}
