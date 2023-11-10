import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PlantaRoutingModule } from './planta-routing.module';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { PlantaCardListComponent } from './components/planta-card-list/planta-card-list.component';
import { PlantaViewComponent } from './components/planta-view/planta-view.component';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatIconModule } from '@angular/material/icon';
import { MatFormFieldModule } from '@angular/material/form-field';
import { PlantaFormComponent } from './components/planta-form/planta-form.component';

import { ReactiveFormsModule } from '@angular/forms';
import { MatTableModule } from '@angular/material/table';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatSelectModule } from '@angular/material/select';
import { MatInputModule } from '@angular/material/input';
import { FormsModule } from '@angular/forms';
import { MatDialogModule } from '@angular/material/dialog';


@NgModule({
  declarations: [
    PlantaCardListComponent,
    PlantaViewComponent,
    PlantaFormComponent
  ],
  imports: [
    CommonModule,
    PlantaRoutingModule,
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
export class PlantaModule { }
