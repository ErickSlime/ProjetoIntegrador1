import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Familia } from '../models/familia.model';

@Injectable({
  providedIn: 'root'
})
export class FamiliaService {

  private baseURL: string =  'http://localhost:8080';

  constructor(private http: HttpClient) { }

  findAll(): Observable<Familia[]> {
    return this.http.get<Familia[]>(`${this.baseURL}/familias`);
  }

  findAllPaginado(pagina: number, tamanhoPagina: number): Observable<Familia[]> {
    const params = {
      page: pagina.toString(),
      pageSize: tamanhoPagina.toString()
    }
    return this.http.get<Familia[]>(`${this.baseURL}/familias/paginado`, {params});
  }

  findById(id: string): Observable<Familia> {
    return this.http.get<Familia>(`${this.baseURL}/familias/${id}`);
  }

  save(familia: Familia): Observable<Familia> {
    return this.http.post<Familia>(`${this.baseURL}/familias`, familia);
  }

  update(familia: Familia): Observable<Familia> {
    return this.http.put<Familia>(`${this.baseURL}/familias/${familia.id}`, familia);
  }

  delete(familia: Familia): Observable<any> {
    return this.http.delete<any>(`${this.baseURL}/familias/${familia.id}`);
  }

  findByNome(nome: string, pagina: number, tamanhoPagina: number): Observable<Familia[]> {
    const params = {
      page: pagina.toString(),
      pageSize: tamanhoPagina.toString()
    }
    return this.http.get<Familia[]>(`${this.baseURL}/familias/search/${nome}`, {params});
  }

  count(): Observable<number> {
    return this.http.get<number>(`${this.baseURL}/familias/count`);
  }

  countByNome(nome: string): Observable<number> {
    return this.http.get<number>(`${this.baseURL}/familias/search/${nome}/count`);
  }
}
