/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eugeniosolucoes.mybooks.service;

import br.com.eugeniosolucoes.mybooks.dto.LivroDTO;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author eugenio
 */
public interface LivroService {

    List<LivroDTO> findAll();

    Optional<LivroDTO> findById( String id );

    LivroDTO save( LivroDTO livro );

    void delete( LivroDTO livro );

}
