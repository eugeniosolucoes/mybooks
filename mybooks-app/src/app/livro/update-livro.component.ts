import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { Livro } from '../modelo/livro.model';
import { LivroService } from './livro.service';

import { FormLivro } from "./form-livro";

import { COMMA, ENTER } from '@angular/cdk/keycodes';
import { MatChipInputEvent } from '@angular/material/chips';


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
      this.livroService.updateLivro(this.livro)
        .subscribe(data => {
          alert("Livro atualizado com sucesso!");
          this.router.navigate(['/livros']);
        });
    } catch (error) {
      alert(error);
    }
  };

  visible = true;
  selectable = true;
  removable = true;
  addOnBlur = true;
  readonly separatorKeysCodes: number[] = [ENTER, COMMA];

  add(event: MatChipInputEvent, lista: any): void {
    const input = event.input;
    const value = event.value;

    // Add assunto
    if ((value || '').trim()) {
      lista.push(value.trim());
    }

    // Reset the input value
    if (input) {
      input.value = '';
    }
  }

  remove(valor: string, lista: any): void {
    const index = lista.indexOf(valor);

    if (index >= 0) {
      lista.splice(index, 1);
    }
  }

}
