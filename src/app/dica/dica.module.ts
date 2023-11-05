import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DicaRoutingModule } from './dica-routing.module';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { DicaCardListComponent } from './components/dica-card-list/dica-card-list.component';
import { DicaViewComponent } from './components/dica-view/dica-view.component';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatIconModule } from '@angular/material/icon';
import { MatFormFieldModule } from '@angular/material/form-field';


@NgModule({
  declarations: [
    DicaCardListComponent,
    DicaViewComponent
  ],
  imports: [
    CommonModule,
    DicaRoutingModule,
    MatCardModule,
    MatButtonModule,
    MatPaginatorModule,
    MatIconModule,
    MatFormFieldModule
  ]
})
export class DicaModule { }
