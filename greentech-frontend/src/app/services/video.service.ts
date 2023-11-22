import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Video } from '../models/video.model';

@Injectable({
  providedIn: 'root'
})
export class VideoService {

  private baseURL: string =  'http://localhost:8080';

  constructor(private http: HttpClient) { }

  findAll(): Observable<Video[]> {
    return this.http.get<Video[]>(`${this.baseURL}/videos`);
  }

  findAllPaginado(pagina: number, tamanhoPagina: number): Observable<Video[]> {
    const params = {
      page: pagina.toString(),
      pageSize: tamanhoPagina.toString()
    }
    return this.http.get<Video[]>(`${this.baseURL}/videos/paginado`, {params});
  }

  findById(id: string): Observable<Video> {
    return this.http.get<Video>(`${this.baseURL}/videos/${id}`);
  }

  save(video: Video): Observable<Video> {
    return this.http.post<Video>(`${this.baseURL}/videos`, video);
  }

  update(video: Video): Observable<Video> {
    return this.http.put<Video>(`${this.baseURL}/videos/${video.id}`, video);
  }

  delete(video: Video): Observable<any> {
    return this.http.delete<any>(`${this.baseURL}/videos/${video.id}`);
  }

  findByNome(nome: string, pagina: number, tamanhoPagina: number): Observable<Video[]> {
    const params = {
      page: pagina.toString(),
      pageSize: tamanhoPagina.toString()
    }
    return this.http.get<Video[]>(`${this.baseURL}/videos/search/${nome}`, {params});
  }

  count(): Observable<number> {
    return this.http.get<number>(`${this.baseURL}/videos/count`);
  }

  countByNome(nome: string): Observable<number> {
    return this.http.get<number>(`${this.baseURL}/videos/search/${nome}/count`);
  }
}
