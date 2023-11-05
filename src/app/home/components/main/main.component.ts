import { Component, OnInit, signal } from '@angular/core';
import { Dica } from 'src/app/models/dica.model';
import { Planta } from 'src/app/models/planta.model';
import { Praga } from 'src/app/models/praga.model';
import { Video } from 'src/app/models/video.model';

type Card = {
  titulo: string;
}

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})

export class MainComponent implements OnInit{

  images = [
    {
      src: 'https://cdn.manomano.com/media/edison/4/5/1/5/4515c27c3a25.jpg',
      alt: 'Imagem 1',
      link: 'https://www.example.com/image1'
    },
    {
      src: 'https://www.10wallpaper.com/wallpaper/1366x768/1805/Spring_rainy_day_green_plants_leaves_water_droplets_1366x768.jpg',
      alt: 'Imagem 2',
      link: 'https://www.example.com/image2'
    },
    {
      src: 'https://www.10wallpaper.com/wallpaper/1366x768/1812/Green_fresh_plant_sprouts_sunlight_closeup_1366x768.jpg',
      alt: 'Imagem 3',
      link: 'https://www.example.com/image3'
    }
  ];

  currentImageIndex = 0;

  onImageClick(imageIndex: number) {
    this.currentImageIndex = imageIndex;
  }

  cards = signal<Card[]> ([]);
  cards2 = signal<Card[]> ([]);
  cards3 = signal<Card[]> ([]);
  cards4 = signal<Card[]> ([]);
  plantas: Planta[] = [];
  pragas: Praga[] = [];
  dicas: Dica[] = [];
  videos: Video[] = [];

  constructor() {}

  ngOnInit(): void {

    // Iniciar um temporizador para trocar de imagem a cada 5 segundos
    setInterval(() => {
      this.currentImageIndex = (this.currentImageIndex + 1) % this.images.length;
    }, 5000);

    this.plantas.push(
      { id:0, nome: 'Planta 1', descricao: 'sadasd'},
      { id:1, nome: 'Planta 2', descricao: 'sadasd'},
      { id:2, nome: 'Planta 3', descricao: 'sadasd'},
      { id:3, nome: 'Planta 4', descricao: 'sadasd'}
    );

    this.pragas.push(
      { id:0, nome: 'Praga 1', descricao: 'sadasd'},
      { id:1, nome: 'Praga 2', descricao: 'sadasd'},
      { id:2, nome: 'Praga 3', descricao: 'sadasd'},
      { id:3, nome: 'Praga 4', descricao: 'sadasd'}
    );

    this.dicas.push(
      { id:0, nome: 'Dica 1', descricao: 'sadasd'},
      { id:1, nome: 'Dica 2', descricao: 'sadasd'},
      { id:2, nome: 'Dica 3', descricao: 'sadasd'},
      { id:3, nome: 'Dica 4', descricao: 'sadasd'}
    );

    this.videos.push(
      { id:0, nome: 'Video 1', descricao: 'sadasd'},
      { id:1, nome: 'Video 2', descricao: 'sadasd'},
      { id:2, nome: 'Video 3', descricao: 'sadasd'},
      { id:3, nome: 'Video 4', descricao: 'sadasd'}
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

    const cards2: Card[] = [];
    this.pragas.forEach(praga => {
      cards2.push({
        titulo: praga.nome
      });
    });
    this.cards2.set(cards2);

    const cards3: Card[] = [];
    this.dicas.forEach(dica => {
      cards3.push({
        titulo: dica.nome
      });
    });
    this.cards3.set(cards3);

    const cards4: Card[] = [];
    this.videos.forEach(video => {
      cards4.push({
        titulo: video.nome
      });
    });
    this.cards4.set(cards4);
  }


}
