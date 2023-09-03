import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {BookingsComponent} from "./bookings/bookings.component";
import {CreatingBookingComponent} from "./creating-booking/creating-booking.component";

const routes: Routes = [
  {path: 'bookings', component: BookingsComponent},
  {path: 'create', component: CreatingBookingComponent},
  {path: 'edit/:id', component: CreatingBookingComponent},
  {path: '', redirectTo: 'bookings', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
