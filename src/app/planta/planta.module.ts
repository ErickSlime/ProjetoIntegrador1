import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PlantaRoutingModule } from './planta-routing.module';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { PlantaCardListComponent } from './components/planta-card-list/planta-card-list.component';
import { PlantaViewComponent } from './components/planta-view/planta-view.component';
import { MatPaginatorModule } from '@angular/material/paginator';


@NgModule({
  declarations: [
    PlantaCardListComponent,
    PlantaViewComponent
  ],
  imports: [
    CommonModule,
    PlantaRoutingModule,
    MatCardModule,
    MatButtonModule,
    MatPaginatorModule
  ]
})
export class PlantaModule { }
