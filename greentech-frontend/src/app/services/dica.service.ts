import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Dica } from '../models/dica.model';

@Injectable({
  providedIn: 'root'
})
export class DicaService {

  private baseURL: string =  'http://localhost:8080';

  constructor(private http: HttpClient) { }

  findAll(): Observable<Dica[]> {
    return this.http.get<Dica[]>(`${this.baseURL}/dicas`);
  }

  findAllPaginado(pagina: number, tamanhoPagina: number): Observable<Dica[]> {
    const params = {
      page: pagina.toString(),
      pageSize: tamanhoPagina.toString()
    }
    return this.http.get<Dica[]>(`${this.baseURL}/dicas/paginado`, {params});
  }

  findById(id: string): Observable<Dica> {
    return this.http.get<Dica>(`${this.baseURL}/dicas/${id}`);
  }

  save(dica: Dica): Observable<Dica> {
    return this.http.post<Dica>(`${this.baseURL}/dicas`, dica);
  }

  update(dica: Dica): Observable<Dica> {
    return this.http.put<Dica>(`${this.baseURL}/dicas/${dica.id}`, dica);
  }

  delete(dica: Dica): Observable<any> {
    return this.http.delete<any>(`${this.baseURL}/dicas/${dica.id}`);
  }

  findByNome(nome: string, pagina: number, tamanhoPagina: number): Observable<Dica[]> {
    const params = {
      page: pagina.toString(),
      pageSize: tamanhoPagina.toString()
    }
    return this.http.get<Dica[]>(`${this.baseURL}/dicas/search/${nome}`, {params});
  }

  count(): Observable<number> {
    return this.http.get<number>(`${this.baseURL}/dicas/count`);
  }

  countByNome(nome: string): Observable<number> {
    return this.http.get<number>(`${this.baseURL}/dicas/search/${nome}/count`);
  }
}