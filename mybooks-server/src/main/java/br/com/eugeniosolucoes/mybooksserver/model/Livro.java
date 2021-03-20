/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eugeniosolucoes.mybooksserver.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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

    @Column( name = "titulo", length = 40 )
    private String titulo;

    @Column( name = "editora", length = 40 )
    private String editora;

    @Column( name = "edicao" )
    private Integer edicao;

    @Column( name = "ano_publicao", length = 4 )
    private String anoPublicacao;

    @ManyToMany
    @CollectionTable( name = "livro_autor" )
    private List<Autor> autores;

    @ManyToMany
    @CollectionTable( name = "livro_assunto" )
    private List<Assunto> assuntos;

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
        return "br.com.eugeniosolucoes.mybooksserver.model.Livro[ id=" + id + " ]";
    }

}
