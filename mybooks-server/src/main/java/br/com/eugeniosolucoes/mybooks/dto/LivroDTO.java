/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eugeniosolucoes.mybooks.dto;

import br.com.eugeniosolucoes.mybooks.model.Assunto;
import br.com.eugeniosolucoes.mybooks.model.Autor;
import br.com.eugeniosolucoes.mybooks.model.Livro;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author eugenio
 */
public class LivroDTO {

    private String id;

    @NotEmpty
    @Size( max = 40 )
    private String titulo;

    @NotEmpty
    @Size( max = 40 )
    private String editora;

    @NotNull
    private Integer edicao;

    @Size( max = 4, message = "O ano da publicação dever ter tamanho 4!" )
    private String anoPublicacao;

    private Double valor;

    private List<String> autores;

    private List<String> assuntos;

    public LivroDTO() {
    }

    /**
     * Fill DTO from Entity
     *
     * @param livro
     */
    public LivroDTO( Livro livro ) {
        this.id = livro.getId() != null ? livro.getId().toString() : null;
        this.titulo = livro.getTitulo();
        this.editora = livro.getEditora();
        this.edicao = livro.getEdicao();
        this.anoPublicacao = livro.getAnoPublicacao();
        this.valor = livro.getValor() != null ? livro.getValor().doubleValue() : null;
        livro.getAutores().forEach( (autor) -> {
            this.getAutores().add( autor.getNome() );
        } );
        livro.getAssuntos().forEach( (assunto) -> {
            this.getAssuntos().add( assunto.getDescricao() );
        } );
    }

    public String getId() {
        return id;
    }

    public void setId( String id ) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo( String titulo ) {
        this.titulo = titulo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora( String editora ) {
        this.editora = editora;
    }

    public Integer getEdicao() {
        return edicao;
    }

    public void setEdicao( Integer edicao ) {
        this.edicao = edicao;
    }

    public String getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao( String anoPublicacao ) {
        this.anoPublicacao = anoPublicacao;
    }

    public List<String> getAutores() {
        if ( autores == null ) {
            autores = new ArrayList<>();
        }
        return autores;
    }

    public void setAutores( List<String> autores ) {
        this.autores = autores;
    }

    public List<String> getAssuntos() {
        if ( assuntos == null ) {
            assuntos = new ArrayList<>();
        }
        return assuntos;
    }

    public void setAssuntos( List<String> assuntos ) {
        this.assuntos = assuntos;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor( Double valor ) {
        this.valor = valor;
    }

    public Livro get() {
        Livro livro = new Livro( this.titulo.trim(), this.editora.trim(), this.edicao, this.anoPublicacao.trim(), new BigDecimal( valor ) );
        if ( this.id != null ) {
            livro.setId( Long.valueOf( this.id ) );
        }
        this.getAutores().forEach( (autor) -> {
            livro.getAutores().add( new Autor( autor ) );
        } );
        this.getAssuntos().forEach( (assunto) -> {
            livro.getAssuntos().add( new Assunto( assunto ) );
        } );
        return livro;
    }
}
