import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';


import { Livro } from '../modelo/livro.model';
import { AppComponent } from "../app.component";

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class LivroService {

  constructor(private http: HttpClient) { }

  private mybooksURL = 'http://' + new AppComponent().myBooksURL + ':8080/api';

  public getLivros() {
    return this.http.get<Livro[]>(this.mybooksURL + "/livros");
  }

  public getLivro(id: number) {
    return this.http.get(this.mybooksURL + "/livro/" + id);
  }

  public deleteLivro(livro: Livro) {
    return this.http.delete(this.mybooksURL + "/livro/" + livro.id);
  }

  public createLivro(livro: Livro) {
    return this.http.post<Livro>(this.mybooksURL + "/livro", livro).pipe(
      retry(1),
      catchError(this.handleError)
    );
  }

  public updateLivro(livro: Livro) {
    return this.http.put<Livro>(this.mybooksURL + "/livro/" + livro.id, livro).pipe(
      retry(1),
      catchError(this.handleError)
    );
  }

  handleError(error: any) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      // client-side error
      errorMessage = `Error: ${error.error.message}`;
    } else {
      // server-side error
      errorMessage = `${error.error.message}`;
    }
    if (Array.isArray(error.error.errors)) {
      errorMessage = error.error.errors[0].defaultMessage;
    }
    if (errorMessage != '') {
      alert(errorMessage);
    }
    return throwError(errorMessage);
  }

  public tratarAutores(livro: Livro) {
    if (!Array.isArray(livro.autores)) {
      let dados: any = livro.autores;
      try {
        let dadosArray = dados.trim().split(",");
        for (let i = 0; i < dadosArray.length; i++) {
          dadosArray[i] = dadosArray[i].trim();
        }
        livro.autores = dadosArray;
      } catch (e) {
        console.log(e);
      }
    }
  }

  public tratarAssuntos(livro: Livro) {
    if (!Array.isArray(livro.assuntos)) {
      let dados: any = livro.assuntos;
      try {
        let dadosArray = dados.trim().split(",");
        for (let i = 0; i < dadosArray.length; i++) {
          dadosArray[i] = dadosArray[i].trim();
        }
        livro.assuntos = dadosArray;
      } catch (e) {
        console.log(e);
      }
    }
  }
}

