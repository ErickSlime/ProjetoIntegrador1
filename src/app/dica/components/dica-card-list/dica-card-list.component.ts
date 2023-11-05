import { Component, OnInit, Signal, signal } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { Dica } from 'src/app/models/dica.model';

type Card = {
  titulo: string;
}

@Component({
  selector: 'app-dica-card-list',
  templateUrl: './dica-card-list.component.html',
  styleUrls: ['./dica-card-list.component.css']
})
export class DicaCardListComponent implements OnInit {

  cards = signal<Card[]> ([]);
  dicas: Dica[] = [];

  totalRegistros = 17;
  pageSize = 10;
  pagina = 0;

  constructor() {}

  ngOnInit(): void {
    this.dicas.push(
      { id:0, nome: 'Dica 1', descricao: 'sadasd'},
      { id:1, nome: 'Dica 2', descricao: 'sadasd'},
      { id:2, nome: 'Dica 3', descricao: 'sadasd'},
      { id:3, nome: 'Dica 4', descricao: 'sadasd'},
      { id:4, nome: 'Dica 5', descricao: 'sadasd'},
      { id:5, nome: 'Dica 6', descricao: 'sadasd'},
      { id:6, nome: 'Dica 7', descricao: 'sadasd'},
      { id:7, nome: 'Dica 8', descricao: 'sadasd'},
      { id:8, nome: 'Dica 9', descricao: 'sadasd'},
      { id:9, nome: 'Dica 10', descricao: 'sadasd'},
      { id:10, nome: 'Dica 11', descricao: 'sadasd'},
      { id:11, nome: 'Dica 12', descricao: 'sadasd'},
      { id:12, nome: 'Dica 13', descricao: 'sadasd'},
      { id:13, nome: 'Dica 14', descricao: 'sadasd'},
      { id:14, nome: 'Dica 15', descricao: 'sadasd'},
      { id:15, nome: 'Dica 16', descricao: 'sadasd'},
      { id:16, nome: 'Dica 17', descricao: 'sadasd'}
    );

    this.carregarCards();
  }

  carregarCards() {
    const cards: Card[] = [];
    this.dicas.forEach(dica => {
      cards.push({
        titulo: dica.nome
      });
    });
    this.cards.set(cards);
  }

}
