import { Component, OnInit, signal } from '@angular/core';
import { Dica } from 'src/app/models/dica.model';
import { Planta } from 'src/app/models/planta.model';
import { Praga } from 'src/app/models/praga.model';
import { Video } from 'src/app/models/video.model';
import { DicaService } from 'src/app/services/dica.service';
import { PlantaService } from 'src/app/services/planta.service';
import { PragaService } from 'src/app/services/praga.service';
import { VideoService } from 'src/app/services/video.service';

type Card = {
  id: number;
  titulo: string;
  urlImagem: string;
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

  constructor(private plantaService: PlantaService,
    private pragaService: PragaService,
    private dicaService: DicaService,
    private videoService: VideoService) {}

  ngOnInit(): void {

    // Iniciar um temporizador para trocar de imagem a cada 5 segundos
    setInterval(() => {
      this.currentImageIndex = (this.currentImageIndex + 1) % this.images.length;
    }, 5000);

    this.plantaService.findAll().subscribe(data => {
      this.plantas = data;
      this.carregarCards();
    });

    this.pragaService.findAll().subscribe(data => {
      this.pragas = data;
      this.carregarCards();
    });

    this.dicaService.findAll().subscribe(data => {
      this.dicas = data;
      this.carregarCards();
    });

    this.videoService.findAll().subscribe(data => {
      this.videos = data;
      this.carregarCards();
    });
    
    this.carregarCards();
  }

  carregarCards() {
    const cards: Card[] = [];
    this.plantas.slice(0,5).forEach(planta => {
      cards.push({
        id: planta.id,
        titulo: planta.nome,
        urlImagem: planta.nomeImagem
      });
    });
    this.cards.set(cards);

    const cards2: Card[] = [];
    this.pragas.forEach(praga => {
      cards2.push({
        id: praga.id,
        titulo: praga.nome,
        urlImagem: praga.nomeImagem
      });
    });
    this.cards2.set(cards2);

    const cards3: Card[] = [];
    this.dicas.forEach(dica => {
      cards3.push({
        id: dica.id,
        titulo: dica.nome,
        urlImagem: dica.nomeImagem
      });
    });
    this.cards3.set(cards3);

    const cards4: Card[] = [];
    this.videos.forEach(video => {
      cards4.push({
        id: video.id,
        titulo: video.nome,
        urlImagem: video.urlVideo
      });
    });
    this.cards4.set(cards4);
  }


}
