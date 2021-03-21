import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { Livro } from '../modelo/livro.model';
import { LivroService } from './livro.service';

@Component({
  selector: 'app-livro-create',
  templateUrl: './add-livro.component.html'
})

export class AddLivroComponent {

  livro: Livro = new Livro();

  constructor(private router: Router, private livroService: LivroService) {

  }

  createLivro(): void {
    this.livroService.createLivro(this.livro)
      .subscribe(data => {
        alert("Livro salvo com sucesso!");
        this.router.navigate(['/livros']);
      });

  };

}
