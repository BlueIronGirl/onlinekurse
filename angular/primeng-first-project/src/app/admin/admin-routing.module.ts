import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CreateUserComponent} from "./create-user/create-user.component";

const routes: Routes = [
  {path: '', redirectTo: 'createuser', pathMatch: 'full'},
  {path: 'createuser', component: CreateUserComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
