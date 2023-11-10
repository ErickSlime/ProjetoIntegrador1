import { Component, OnInit, Signal, signal } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { Planta } from 'src/app/models/planta.model';

type Card = {
  titulo: string;
}

@Component({
  selector: 'app-planta-card-list',
  templateUrl: './planta-card-list.component.html',
  styleUrls: ['./planta-card-list.component.css']
})
export class PlantaCardListComponent implements OnInit {

  cards = signal<Card[]> ([]);
  plantas: Planta[] = [];

  totalRegistros = 17;
  pageSize = 10;
  pagina = 0;

  constructor() {}

  ngOnInit(): void {
    this.plantas.push(
      { id:0, nome: 'Planta 1', descricao: 'sadasd'},
      { id:1, nome: 'Planta 2', descricao: 'sadasd'},
      { id:2, nome: 'Planta 3', descricao: 'sadasd'},
      { id:3, nome: 'Planta 4', descricao: 'sadasd'},
      { id:4, nome: 'Planta 5', descricao: 'sadasd'},
      { id:5, nome: 'Planta 6', descricao: 'sadasd'},
      { id:6, nome: 'Planta 7', descricao: 'sadasd'},
      { id:7, nome: 'Planta 8', descricao: 'sadasd'},
      { id:8, nome: 'Planta 9', descricao: 'sadasd'},
      { id:9, nome: 'Planta 10', descricao: 'sadasd'},
      { id:10, nome: 'Planta 11', descricao: 'sadasd'},
      { id:11, nome: 'Planta 12', descricao: 'sadasd'},
      { id:12, nome: 'Planta 13', descricao: 'sadasd'},
      { id:13, nome: 'Planta 14', descricao: 'sadasd'},
      { id:14, nome: 'Planta 15', descricao: 'sadasd'},
      { id:15, nome: 'Planta 16', descricao: 'sadasd'},
      { id:16, nome: 'Planta 17', descricao: 'sadasd'}
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
