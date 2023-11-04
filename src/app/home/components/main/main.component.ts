import { Component, OnInit, signal } from '@angular/core';
import { Planta } from 'src/app/models/planta.model';

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
      src: 'https://dropsdocotidiano.files.wordpress.com/2020/06/cultivo-de-plantas.jpg?w=1200',
      alt: 'Imagem 1',
      link: 'https://www.example.com/image1'
    },
    {
      src: 'https://terramagna.com.br/wp-content/uploads/2022/09/Maos-humanas-muda-solo-cultivo.jpg',
      alt: 'Imagem 2',
      link: 'https://www.example.com/image2'
    },
    {
      src: 'https://www.saude.ce.gov.br/wp-content/uploads/sites/9/2022/01/Horto-1.jpg',
      alt: 'Imagem 3',
      link: 'https://www.example.com/image3'
    }
  ];

  currentImageIndex = 0;

  onImageClick(imageIndex: number) {
    this.currentImageIndex = imageIndex;
  }

  cards = signal<Card[]> ([]);
  plantas: Planta[] = [];

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
