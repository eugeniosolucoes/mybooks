import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Livro } from '../modelo/livro.model';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class LivroService {

  constructor(private http: HttpClient) { }

  private mybooksURL = 'http://localhost:8080/api';

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
    return this.http.post<Livro>(this.mybooksURL + "/livro", livro);
  }

  public updateLivro(livro: Livro) {
    return this.http.put<Livro>(this.mybooksURL + "/livro/" + livro.id, livro);
  }

}

