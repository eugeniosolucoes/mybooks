/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eugeniosolucoes.mybooks.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author eugenio
 */
@Entity
public class Livro implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column( name = "titulo", nullable = false, length = 40 )
    private String titulo;

    @Column( name = "editora", nullable = false, length = 40 )
    private String editora;

    @Column( name = "edicao", nullable = false )
    private Integer edicao;

    @Column( name = "ano_publicao", nullable = false, length = 4 )
    private String anoPublicacao;

    @Column( name = "valor", precision = 2 )
    private BigDecimal valor;

    @ManyToMany( cascade = CascadeType.PERSIST )
    @CollectionTable( name = "livro_autor" )
    private List<Autor> autores;

    @ManyToMany( cascade = CascadeType.PERSIST )
    @CollectionTable( name = "livro_assunto" )
    private List<Assunto> assuntos;

    public Livro() {
    }

    public Livro( String titulo, String editora, Integer edicao, String anoPublicacao, BigDecimal valor ) {
        this.titulo = titulo;
        this.editora = editora;
        this.edicao = edicao;
        this.anoPublicacao = anoPublicacao;
        this.valor = valor;
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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor( BigDecimal valor ) {
        this.valor = valor;
    }

    public List<Autor> getAutores() {
        if ( autores == null ) {
            autores = new ArrayList<>();
        }
        return autores;
    }

    public void setAutores( List<Autor> autores ) {
        this.autores = autores;
    }

    public List<Assunto> getAssuntos() {
        if ( assuntos == null ) {
            assuntos = new ArrayList<>();
        }
        return assuntos;
    }

    public void setAssuntos( List<Assunto> assuntos ) {
        this.assuntos = assuntos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += ( id != null ? id.hashCode() : 0 );
        return hash;
    }

    @Override
    public boolean equals( Object object ) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if ( !( object instanceof Livro ) ) {
            return false;
        }
        Livro other = (Livro) object;
        return !( ( this.id == null && other.id != null ) || ( this.id != null && !this.id.equals( other.id ) ) );
    }

    @Override
    public String toString() {
        return "Livro{" + "id=" + id + ", titulo=" + titulo + ", editora=" + editora + ", edicao=" + edicao + ", anoPublicacao=" + anoPublicacao + ", valor=" + valor + ", autores=" + autores + ", assuntos=" + assuntos + '}';
    }

}
