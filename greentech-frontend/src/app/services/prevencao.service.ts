import { Injectable } from '@angular/core';
import { Prevencao } from '../models/prevencao.model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PrevencaoService {

  private baseURL: string =  'http://localhost:8080';

  constructor(private http: HttpClient) { }

  findAll(): Observable<Prevencao[]> {
    return this.http.get<Prevencao[]>(`${this.baseURL}/prevencaos`);
  }

  findAllPaginado(pagina: number, tamanhoPagina: number): Observable<Prevencao[]> {
    const params = {
      page: pagina.toString(),
      pageSize: tamanhoPagina.toString()
    }
    return this.http.get<Prevencao[]>(`${this.baseURL}/prevencaos/paginado`, {params});
  }

  findById(id: string): Observable<Prevencao> {
    return this.http.get<Prevencao>(`${this.baseURL}/prevencaos/${id}`);
  }

  save(prevencao: Prevencao): Observable<Prevencao> {
    return this.http.post<Prevencao>(`${this.baseURL}/prevencaos`, prevencao);
  }

  update(prevencao: Prevencao): Observable<Prevencao> {
    return this.http.put<Prevencao>(`${this.baseURL}/prevencaos/${prevencao.id}`, prevencao);
  }

  delete(prevencao: Prevencao): Observable<any> {
    return this.http.delete<any>(`${this.baseURL}/prevencaos/${prevencao.id}`);
  }

  findByNome(nome: string, pagina: number, tamanhoPagina: number): Observable<Prevencao[]> {
    const params = {
      page: pagina.toString(),
      pageSize: tamanhoPagina.toString()
    }
    return this.http.get<Prevencao[]>(`${this.baseURL}/prevencaos/search/${nome}`, {params});
  }

  count(): Observable<number> {
    return this.http.get<number>(`${this.baseURL}/prevencaos/count`);
  }

  countByNome(nome: string): Observable<number> {
    return this.http.get<number>(`${this.baseURL}/prevencaos/search/${nome}/count`);
  }
}
