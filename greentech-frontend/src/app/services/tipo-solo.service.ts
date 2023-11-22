import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TipoSolo } from '../models/tipo-solo.model';

@Injectable({
  providedIn: 'root'
})
export class TipoSoloService {

  private baseURL: string =  'http://localhost:8080';

  constructor(private http: HttpClient) { }

  findAll(): Observable<TipoSolo[]> {
    return this.http.get<TipoSolo[]>(`${this.baseURL}/solos`);
  }

  findAllPaginado(pagina: number, tamanhoPagina: number): Observable<TipoSolo[]> {
    const params = {
      page: pagina.toString(),
      pageSize: tamanhoPagina.toString()
    }
    return this.http.get<TipoSolo[]>(`${this.baseURL}/solos/paginado`, {params});
  }

  findById(id: string): Observable<TipoSolo> {
    return this.http.get<TipoSolo>(`${this.baseURL}/solos/${id}`);
  }

  save(tipoSolo: TipoSolo): Observable<TipoSolo> {
    return this.http.post<TipoSolo>(`${this.baseURL}/solos`, tipoSolo);
  }

  update(tipoSolo: TipoSolo): Observable<TipoSolo> {
    return this.http.put<TipoSolo>(`${this.baseURL}/solos/${tipoSolo.id}`, tipoSolo);
  }

  delete(tipoSolo: TipoSolo): Observable<any> {
    return this.http.delete<any>(`${this.baseURL}/solos/${tipoSolo.id}`);
  }

  findByNome(nome: string, pagina: number, tamanhoPagina: number): Observable<TipoSolo[]> {
    const params = {
      page: pagina.toString(),
      pageSize: tamanhoPagina.toString()
    }
    return this.http.get<TipoSolo[]>(`${this.baseURL}/solos/search/${nome}`, {params});
  }

  count(): Observable<number> {
    return this.http.get<number>(`${this.baseURL}/solos/count`);
  }

  countByNome(nome: string): Observable<number> {
    return this.http.get<number>(`${this.baseURL}/solos/search/${nome}/count`);
  }
}
