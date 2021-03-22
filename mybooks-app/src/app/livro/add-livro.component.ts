import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { Livro } from '../modelo/livro.model';
import { LivroService } from './livro.service';

@Component({
  selector: 'app-livro-create',
  templateUrl: './add-livro.component.html'
})

export class AddLivroComponent {

  livro: any = {};

  constructor(private router: Router, private livroService: LivroService) {

  }

  createLivro(): void {

    console.log(this.livro);

    if (!Array.isArray(this.livro.autores)) {
      let autores = this.livro.autores.trim().split(",");
      this.livro.autores = autores;
    }
    if (!Array.isArray(this.livro.assuntos)) {
      let assuntos = this.livro.assuntos.trim().split(",");
      this.livro.assuntos = assuntos;
    }


    this.livroService.createLivro(this.livro)
      .subscribe(data => {
        alert("Livro salvo com sucesso!");
        this.router.navigate(['/livros']);
      });

  };

}
