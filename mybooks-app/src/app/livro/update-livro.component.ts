import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { Livro } from '../modelo/livro.model';
import { LivroService } from './livro.service';

@Component({
  selector: 'app-livro-update',
  templateUrl: './update-livro.component.html',
})
export class UpdateLivroComponent implements OnInit {

  livro: any = {};

  constructor(private router: Router, private route: ActivatedRoute, private livroService: LivroService) {

  }

  ngOnInit() {
    this.livroService.getLivro(this.route.snapshot.params['id'])
      .subscribe(data => {
        this.livro = data;
      });
  };

  updateLivro(): void {

    if (!Array.isArray(this.livro.autores)) {
      let autores = this.livro.autores.trim().split(",");
      this.livro.autores = autores;
    }
    if (!Array.isArray(this.livro.assuntos)) {
      let assuntos = this.livro.assuntos.trim().split(",");
      this.livro.assuntos = assuntos;
    }

    this.livroService.updateLivro(this.livro)
      .subscribe(data => {
        alert("Livro atualizado com sucesso!");
        this.router.navigate(['/livros']);
      });

  };

}
