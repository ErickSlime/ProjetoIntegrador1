import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PragaRoutingModule } from './praga-routing.module';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { PragaCardListComponent } from './components/praga-card-list/praga-card-list.component';
import { PragaViewComponent } from './components/praga-view/praga-view.component';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatIconModule } from '@angular/material/icon';
import { MatFormFieldModule } from '@angular/material/form-field';


@NgModule({
  declarations: [
    PragaCardListComponent,
    PragaViewComponent
  ],
  imports: [
    CommonModule,
    PragaRoutingModule,
    MatCardModule,
    MatButtonModule,
    MatPaginatorModule,
    MatIconModule,
    MatFormFieldModule
  ]
})
export class PragaModule { }
