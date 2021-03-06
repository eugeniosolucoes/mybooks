/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eugeniosolucoes.mybooks.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
public class Autor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column( name = "nome", nullable = false, length = 40 )
    private String nome;

    @ManyToMany( mappedBy = "autores" )
    private List<Livro> livros;

    public Autor() {
    }

    public Autor( String nome ) {
        this.nome = nome.trim();
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome( String nome ) {
        this.nome = nome;
    }

    public List<Livro> getLivros() {
        if ( livros == null ) {
            livros = new ArrayList<>();
        }
        return livros;
    }

    public void setLivros( List<Livro> livros ) {
        this.livros = livros;
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
        if ( !( object instanceof Autor ) ) {
            return false;
        }
        Autor other = (Autor) object;
        return !( ( this.id == null && other.id != null ) || ( this.id != null && !this.id.equals( other.id ) ) );
    }

    @Override
    public String toString() {
        return "Autor{" + "id=" + id + ", nome=" + nome + '}';
    }

}
