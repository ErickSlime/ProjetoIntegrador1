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
import { DicaFormComponent } from './components/dica-form/dica-form.component';

import { ReactiveFormsModule } from '@angular/forms';
import { MatTableModule } from '@angular/material/table';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatSelectModule } from '@angular/material/select';
import { MatInputModule } from '@angular/material/input';
import { FormsModule } from '@angular/forms';
import { MatDialogModule } from '@angular/material/dialog';


@NgModule({
  declarations: [
    DicaCardListComponent,
    DicaViewComponent,
    DicaFormComponent
  ],
  imports: [
    CommonModule,
    DicaRoutingModule,
    MatCardModule,
    MatButtonModule,
    MatPaginatorModule,
    MatIconModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    MatTableModule,
    MatToolbarModule,
    MatSelectModule,
    MatInputModule,
    FormsModule,
    MatDialogModule
  ]
})
export class DicaModule { }
