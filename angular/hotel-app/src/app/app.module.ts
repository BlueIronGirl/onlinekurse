import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BookingsComponent } from './bookings/bookings.component';
import { CreatingBookingComponent } from './creating-booking/creating-booking.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {DateValueAccessorModule} from "angular-date-value-accessor";
import {HttpClientModule} from "@angular/common/http";
import {HttpClientInMemoryWebApiModule} from "angular-in-memory-web-api";
import {InMemoryDataService} from "./shared/in-memory-data.service";

@NgModule({
  declarations: [
    AppComponent,
    BookingsComponent,
    CreatingBookingComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    DateValueAccessorModule,
    HttpClientModule,
    HttpClientInMemoryWebApiModule.forRoot(InMemoryDataService)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
