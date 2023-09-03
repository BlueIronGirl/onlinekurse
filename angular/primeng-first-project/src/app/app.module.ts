import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {ButtonModule} from 'primeng/button';
import {InputTextModule} from 'primeng/inputtext';
import {TreeTableModule} from 'primeng/treetable';
import { CreateUserComponent } from './admin/create-user/create-user.component';
import { HomeComponent } from './home/home.component';
import {MenubarModule} from "primeng/menubar";
import { UsersComponent } from './users/users.component';

@NgModule({
            declarations: [
              AppComponent,
              CreateUserComponent,
              HomeComponent,
              UsersComponent
            ],
            imports: [
              BrowserModule,
              AppRoutingModule,
              FormsModule,
              ReactiveFormsModule,
              ButtonModule,
              InputTextModule,
              TreeTableModule,
              MenubarModule
            ],
            providers: [],
            bootstrap: [AppComponent]
          })
export class AppModule {
}
