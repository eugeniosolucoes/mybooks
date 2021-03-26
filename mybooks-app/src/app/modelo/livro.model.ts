export class Livro {

  id: number;
  titulo: string;
  editora: string;
  edicao: number;
  anoPublicacao: number;
  valor: number;
  autores: string[];
  assuntos: string[];


  constructor() {
    this.id = 0;
    this.titulo = "";
    this.editora = "";
    this.edicao = 1;
    this.anoPublicacao = new Date().getFullYear();
    this.valor = 0.00;
    this.autores = [];
    this.assuntos = [];
  }

}
