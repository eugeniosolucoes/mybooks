export class Livro {

  id: number;
  titulo: string;
  editora: string;
  edicao: number;
  anoPublicao: string;
  autores: string[];
  assuntos: string[];


  constructor() {
    this.id = 0;
    this.titulo = "";
    this.editora = "";
    this.edicao = 0;
    this.anoPublicao = "";
    this.autores = [];
    this.assuntos = [];
  }

}
