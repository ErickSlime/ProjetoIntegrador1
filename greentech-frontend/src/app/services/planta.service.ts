import { Injectable } from '@angular/core';
import { Planta } from '../models/planta.model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PlantaService {

  private baseURL: string =  'http://localhost:8080';

  constructor(private http: HttpClient) { }

  findAll(): Observable<Planta[]> {
    return this.http.get<Planta[]>(`${this.baseURL}/plantas`);
  }

  findAllPaginado(pagina: number, tamanhoPagina: number): Observable<Planta[]> {
    const params = {
      page: pagina.toString(),
      pageSize: tamanhoPagina.toString()
    }
    return this.http.get<Planta[]>(`${this.baseURL}/plantas/paginado`, {params});
  }

  findById(id: string): Observable<Planta> {
    return this.http.get<Planta>(`${this.baseURL}/plantas/${id}`);
  }

  save(planta: Planta): Observable<Planta> {
    return this.http.post<Planta>(`${this.baseURL}/plantas`, planta);
  }

  update(planta: Planta): Observable<Planta> {
    return this.http.put<Planta>(`${this.baseURL}/plantas/${planta.id}`, planta);
  }

  delete(planta: Planta): Observable<any> {
    return this.http.delete<any>(`${this.baseURL}/plantas/${planta.id}`);
  }

  findByNome(nome: string, pagina: number, tamanhoPagina: number): Observable<Planta[]> {
    const params = {
      page: pagina.toString(),
      pageSize: tamanhoPagina.toString()
    }
    return this.http.get<Planta[]>(`${this.baseURL}/plantas/search/${nome}`, {params});
  }

  count(): Observable<number> {
    return this.http.get<number>(`${this.baseURL}/plantas/count`);
  }

  countByNome(nome: string): Observable<number> {
    return this.http.get<number>(`${this.baseURL}/plantas/search/${nome}/count`);
  }
}
