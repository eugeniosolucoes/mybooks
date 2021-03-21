/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eugeniosolucoes.mybooks.service;

import br.com.eugeniosolucoes.mybooks.model.Livro;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author eugenio
 */
public interface LivroService {

    public Page<Livro> findAll( Pageable pageable );

    public Optional<Livro> findById( String id );

    public Livro save( Livro livro );

    public void delete( Livro livro );

}
