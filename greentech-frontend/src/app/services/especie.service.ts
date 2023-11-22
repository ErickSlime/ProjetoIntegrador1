import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Especie } from '../models/especie.model';

@Injectable({
  providedIn: 'root'
})
export class EspecieService {

  private baseURL: string =  'http://localhost:8080';

  constructor(private http: HttpClient) { }

  findAll(): Observable<Especie[]> {
    return this.http.get<Especie[]>(`${this.baseURL}/especies`);
  }

  findAllPaginado(pagina: number, tamanhoPagina: number): Observable<Especie[]> {
    const params = {
      page: pagina.toString(),
      pageSize: tamanhoPagina.toString()
    }
    return this.http.get<Especie[]>(`${this.baseURL}/especies/paginado`, {params});
  }

  findById(id: string): Observable<Especie> {
    return this.http.get<Especie>(`${this.baseURL}/especies/${id}`);
  }

  save(especie: Especie): Observable<Especie> {
    return this.http.post<Especie>(`${this.baseURL}/especies`, especie);
  }

  update(especie: Especie): Observable<Especie> {
    return this.http.put<Especie>(`${this.baseURL}/especies/${especie.id}`, especie);
  }

  delete(especie: Especie): Observable<any> {
    return this.http.delete<any>(`${this.baseURL}/especies/${especie.id}`);
  }

  findByNome(nome: string, pagina: number, tamanhoPagina: number): Observable<Especie[]> {
    const params = {
      page: pagina.toString(),
      pageSize: tamanhoPagina.toString()
    }
    return this.http.get<Especie[]>(`${this.baseURL}/especies/search/${nome}`, {params});
  }

  count(): Observable<number> {
    return this.http.get<number>(`${this.baseURL}/especies/count`);
  }

  countByNome(nome: string): Observable<number> {
    return this.http.get<number>(`${this.baseURL}/especies/search/${nome}/count`);
  }
}
