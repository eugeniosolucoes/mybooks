import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { Livro } from '../modelo/livro.model';
import { LivroService } from './livro.service';

import { FormLivro } from "./form-livro";

@Component({
  selector: 'app-livro-create',
  templateUrl: './add-livro.component.html'
})

export class AddLivroComponent extends FormLivro {

  livro: Livro = new Livro();

  constructor(private router: Router, private livroService: LivroService) {
    super();
  }

  createLivro(): void {
    try {
      this.livroService.tratarAnoEdicao(this.livro);
      this.livroService.tratarAutores(this.livro);
      this.livroService.tratarAssuntos(this.livro);
      this.livroService.createLivro(this.livro)
        .subscribe(data => {
          alert("Livro salvo com sucesso!");
          this.router.navigate(['/livros']);
        });
    } catch (error) {
      alert(error);
    }
  };

}
