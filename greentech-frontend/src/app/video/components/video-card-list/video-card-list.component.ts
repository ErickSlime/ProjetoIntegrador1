import { Component, OnInit, Signal, signal } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { Video } from 'src/app/models/video.model';
import { VideoService } from 'src/app/services/video.service';

type Card = {
  id: number;
  titulo: string;
  descricao: string;
  url: string;
}

@Component({
  selector: 'app-video-card-list',
  templateUrl: './video-card-list.component.html',
  styleUrls: ['./video-card-list.component.css']
})
export class VideoCardListComponent implements OnInit {

  cards = signal<Card[]> ([]);
  videos: Video[] = [];
  totalRegistros = 0;
  filtro: string = "";
  pageSize = 10;
  pagina = 0;
  constructor(private videoService: VideoService) {}

  ngOnInit(): void {
    this.carregarVideos();
    this.carregarTotalRegistros();
  }

  carregarVideos() {
    if(this.filtro){
      this.videoService.findByNome(this.filtro,this.pagina, this.pageSize).subscribe(data => {
        this.videos = data;
        this.carregarCards();
      })

    }else{

    this.videoService.findAll().subscribe(data => {
      this.videos = data;
      this.carregarCards();
    })
  };
  
  }

  carregarTotalRegistros() {
    if(this.filtro){
      this.videoService.countByNome(this.filtro).subscribe(data => {
        this.totalRegistros = data;})
    }else{

    this.videoService.count().subscribe(data => {
      this.totalRegistros = data;
    });
  }
  }

    // Método para paginar os resultados
    paginar(event: PageEvent): void {
      this.pagina = event.pageIndex;
      this.pageSize = event.pageSize;
      this.carregarVideos();
    }

  carregarCards() {
    const cards: Card[] = [];
    this.videos.forEach(video => {
      cards.push({
        id: video.id,
        titulo: video.nome,
        descricao: video.descricao,
        url: video.urlVideo
      });
    });
    this.cards.set(cards);
  }

  aplicarFiltro() {
    this.carregarVideos();
  
  }

}
