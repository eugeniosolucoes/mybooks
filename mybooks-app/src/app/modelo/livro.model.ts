export class Livro {

  id: number;
  titulo: string;
  editora: string;
  edicao: number;
  anoPublicacao: string;
  valor: number;
  autores: string[];
  assuntos: string[];


  constructor() {
    this.id = 0;
    this.titulo = "";
    this.editora = "";
    this.edicao = 0;
    this.anoPublicacao = "";
    this.valor = 0;
    this.autores = [];
    this.assuntos = [];
  }

}
