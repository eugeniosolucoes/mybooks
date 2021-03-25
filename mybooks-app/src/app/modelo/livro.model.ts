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
    this.edicao = 0;
    this.anoPublicacao = 0;
    this.valor = 0.00;
    this.autores = [];
    this.assuntos = [];
  }

}
