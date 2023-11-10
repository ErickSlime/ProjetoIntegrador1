import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Usuario } from 'src/app/models/usuario.model';

@Component({
  selector: 'app-usuario-form',
  templateUrl: './usuario-form.component.html',
  styleUrls: ['./usuario-form.component.css']
})
export class UsuarioFormComponent {
  formGroup: FormGroup;
  apiResponse: any = null;
  usuarios: Usuario[] = [];

  totalRegistros = 17;
  pageSize = 10;
  pagina = 0;

constructor(private formBuilder: FormBuilder,
  private activatedRoute: ActivatedRoute) {

  const usuario: Usuario = this.activatedRoute.snapshot.data['usuario'];
  this.formGroup = formBuilder.group({
    id: [(usuario && usuario.id) ? usuario.id : null],
    nome: [(usuario && usuario.nome) ? usuario.nome : '', Validators.required],
    login: [(usuario && usuario.login) ? usuario.login : '', Validators.required],
    email: [(usuario && usuario.email) ? usuario.email : '', Validators.required],
    senha: [(usuario && usuario.senha) ? usuario.senha: '', Validators.required]
  })
}

  salvar(){

  }

  excluir(){
    
  }

}