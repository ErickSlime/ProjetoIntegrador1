import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Usuario } from 'src/app/models/usuario.model';

@Component({
  selector: 'app-usuario-login',
  templateUrl: './usuario-login.component.html',
  styleUrls: ['./usuario-login.component.css']
})
export class UsuarioLoginComponent {
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
    login: [(usuario && usuario.login) ? usuario.login : '', Validators.required],
    senha: [(usuario && usuario.senha) ? usuario.senha: '', Validators.required]
  })
}

  entrar(){

  }
}
