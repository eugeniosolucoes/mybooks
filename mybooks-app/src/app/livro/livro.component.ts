import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Livro } from '../modelo/livro.model';
import { LivroService } from './livro.service';

@Component({
  selector: 'app-livro-read',
  templateUrl: './livro.component.html',
  styles: ['livro.component.css']
})
export class LivroComponent implements OnInit {

  livros: Livro[] = [];

  constructor(private router: Router, private livroService: LivroService) {

  }

  ngOnInit() {
    this.livroService.getLivros()
      .subscribe(data => {
        this.livros = data;
      });
  };

  deleteLivro(livro: Livro): void {

    let result = confirm('Deseja realmente excluir o livro "' + livro.titulo + '"?');
    if (result)
      this.livroService.deleteLivro(livro)
        .subscribe(data => {
          this.livros = this.livros.filter(u => u !== livro);
        });
  };

}
