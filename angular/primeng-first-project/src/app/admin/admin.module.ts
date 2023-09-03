import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';
import {ReactiveFormsModule} from "@angular/forms";
import {DateValueAccessorModule} from "angular-date-value-accessor";


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    AdminRoutingModule,
    ReactiveFormsModule,
    DateValueAccessorModule
  ]
})
export class AdminModule { }
