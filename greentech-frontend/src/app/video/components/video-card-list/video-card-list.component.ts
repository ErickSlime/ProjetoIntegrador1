import { Component, OnInit, Signal, signal } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { Video } from 'src/app/models/video.model';

type Card = {
  titulo: string;
}

@Component({
  selector: 'app-video-card-list',
  templateUrl: './video-card-list.component.html',
  styleUrls: ['./video-card-list.component.css']
})
export class VideoCardListComponent implements OnInit {

  cards = signal<Card[]> ([]);
  videos: Video[] = [];

  totalRegistros = 17;
  pageSize = 10;
  pagina = 0;

  constructor() {}

  ngOnInit(): void {
    this.carregarCards();
  }

  carregarCards() {
    const cards: Card[] = [];
    this.videos.forEach(video => {
      cards.push({
        titulo: video.nome
      });
    });
    this.cards.set(cards);
  }

}
