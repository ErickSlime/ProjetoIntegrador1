import { Injectable } from '@angular/core';
import { Praga } from '../models/praga.model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PragaService {

  private baseURL: string =  'http://localhost:8080';

  constructor(private http: HttpClient) { }

  findAll(): Observable<Praga[]> {
    return this.http.get<Praga[]>(`${this.baseURL}/pragas`);
  }

  findAllPaginado(pagina: number, tamanhoPagina: number): Observable<Praga[]> {
    const params = {
      page: pagina.toString(),
      pageSize: tamanhoPagina.toString()
    }
    return this.http.get<Praga[]>(`${this.baseURL}/pragas/paginado`, {params});
  }

  findById(id: string): Observable<Praga> {
    return this.http.get<Praga>(`${this.baseURL}/pragas/${id}`);
  }

  save(praga: Praga): Observable<Praga> {
    const especieDto = {
      nome: praga.especie.nome,
      caracteristica: praga.especie.caracteristicas,
      familia: praga.especie.familia.id
    }

    const pragaDto = {
      nome: praga.nome,
      nomeImagem: praga.nomeImagem,
      descricao: praga.descricao,
      prevencao: null,
      especie: especieDto
    }
    return this.http.post<Praga>(`${this.baseURL}/pragas`, pragaDto);
  }

  update(praga: Praga): Observable<Praga> {
    return this.http.put<Praga>(`${this.baseURL}/pragas/${praga.id}`, praga);
  }

  delete(praga: Praga): Observable<any> {
    return this.http.delete<any>(`${this.baseURL}/pragas/${praga.id}`);
  }

  findByNome(nome: string, pagina: number, tamanhoPagina: number): Observable<Praga[]> {
    const params = {
      page: pagina.toString(),
      pageSize: tamanhoPagina.toString()
    }
    return this.http.get<Praga[]>(`${this.baseURL}/pragas/search/${nome}`, {params});
  }

  count(): Observable<number> {
    return this.http.get<number>(`${this.baseURL}/pragas/count`);
  }

  countByNome(nome: string): Observable<number> {
    return this.http.get<number>(`${this.baseURL}/pragas/search/${nome}/count`);
  }
}
