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
import { PragaFormComponent } from './components/praga-form/praga-form.component';

import { ReactiveFormsModule } from '@angular/forms';
import { MatTableModule } from '@angular/material/table';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatSelectModule } from '@angular/material/select';
import { MatInputModule } from '@angular/material/input';
import { FormsModule } from '@angular/forms';
import { MatDialogModule } from '@angular/material/dialog';


@NgModule({
  declarations: [
    PragaCardListComponent,
    PragaViewComponent,
    PragaFormComponent
  ],
  imports: [
    CommonModule,
    PragaRoutingModule,
    MatCardModule,
    MatButtonModule,
    MatPaginatorModule,
    MatIconModule,
    MatFormFieldModule,
    MatTableModule,
    MatToolbarModule,
    MatSelectModule,
    MatInputModule,
    FormsModule,
    MatDialogModule,
    ReactiveFormsModule
  ]
})
export class PragaModule { }
