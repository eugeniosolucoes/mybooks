/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eugeniosolucoes.mybooks.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Immutable;

/**
 *
 * @author eugenio
 */
@Entity
@Immutable
@Table( name = "vw_livros" )
public class LivroRelatorioView implements Serializable {

    @Id
    private Long id;

    private String titulo;

    private String editora;

    private Integer edicao;

    @Column( name = "ano_publicacao" )
    private String anoPublicacao;

    private Double valor;

    private String autores;

    private String assuntos;

    public LivroRelatorioView() {
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
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

    public Double getValor() {
        return valor;
    }

    public void setValor( Double valor ) {
        this.valor = valor;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores( String autores ) {
        this.autores = autores;
    }

    public String getAssuntos() {
        return assuntos;
    }

    public void setAssuntos( String assuntos ) {
        this.assuntos = assuntos;
    }

}
