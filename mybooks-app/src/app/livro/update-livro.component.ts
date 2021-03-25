import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { Livro } from '../modelo/livro.model';
import { LivroService } from './livro.service';

import { FormLivro } from "./form-livro";

@Component({
  selector: 'app-livro-update',
  templateUrl: './update-livro.component.html',
})
export class UpdateLivroComponent extends FormLivro implements OnInit {

  livro: any = {};

  constructor(private router: Router, private route: ActivatedRoute, private livroService: LivroService) {
    super();
  }

  ngOnInit() {
    this.livroService.getLivro(this.route.snapshot.params['id'])
      .subscribe(data => {
        this.livro = data;
      });
  };

  updateLivro(): void {
    try {
      this.livroService.tratarAnoEdicao(this.livro);
      this.livroService.tratarAutores(this.livro);
      this.livroService.tratarAssuntos(this.livro);
      this.livroService.updateLivro(this.livro)
        .subscribe(data => {
          alert("Livro atualizado com sucesso!");
          this.router.navigate(['/livros']);
        });
    } catch (error) {
      alert(error);
    }
  };

}
