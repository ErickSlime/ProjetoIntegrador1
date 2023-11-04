import { Component, signal } from '@angular/core';
import { Planta } from 'src/app/models/planta.model';

type Card = {
  titulo: string;
}

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})

export class MainComponent {

  cards = signal<Card[]> ([]);
  plantas: Planta[] = [];

  constructor() {}

  ngOnInit(): void {
    this.plantas.push(
      { id:0, nome: 'Planta 1', descricao: 'sadasd'},
      { id:1, nome: 'Planta 2', descricao: 'sadasd'},
      { id:2, nome: 'Planta 3', descricao: 'sadasd'},
      { id:3, nome: 'Planta 4', descricao: 'sadasd'}
    );

    this.carregarCards();
  }

  carregarCards() {
    const cards: Card[] = [];
    this.plantas.forEach(planta => {
      cards.push({
        titulo: planta.nome
      });
    });
    this.cards.set(cards);
  }


}
