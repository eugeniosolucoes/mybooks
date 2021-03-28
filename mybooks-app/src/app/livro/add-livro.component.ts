import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { Livro } from '../modelo/livro.model';
import { LivroService } from './livro.service';

import { FormLivro } from "./form-livro";

import { COMMA, ENTER } from '@angular/cdk/keycodes';
import { MatChipInputEvent } from '@angular/material/chips';


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
      this.livroService.createLivro(this.livro)
        .subscribe(data => {
          alert("Livro salvo com sucesso!");
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

    // Add valor
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
