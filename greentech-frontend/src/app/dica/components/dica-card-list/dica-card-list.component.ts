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
