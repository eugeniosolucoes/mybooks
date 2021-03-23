import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './app.component';
import { LivroComponent } from './livro/livro.component';
import { AppRoutingModule } from './app-routing.module';
import { LivroService } from './livro/livro.service';
import { HttpClientModule } from "@angular/common/http";
import { AddLivroComponent } from './livro/add-livro.component';
import { UpdateLivroComponent } from './livro/update-livro.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
    LivroComponent,
    AddLivroComponent,
    UpdateLivroComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule,
    FormsModule,
    BrowserAnimationsModule
  ],
  providers: [LivroService],
  bootstrap: [AppComponent]
})
export class AppModule { }
