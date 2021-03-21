import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LivroComponent } from './livro/livro.component';
import { AddLivroComponent } from './livro/add-livro.component';
import { UpdateLivroComponent } from './livro/update-livro.component';

const routes: Routes = [
  { path: 'livros', component: LivroComponent },
  { path: 'add', component: AddLivroComponent },
  { path: 'update/:id', component: UpdateLivroComponent },
  { path: '', redirectTo: '/livros', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
