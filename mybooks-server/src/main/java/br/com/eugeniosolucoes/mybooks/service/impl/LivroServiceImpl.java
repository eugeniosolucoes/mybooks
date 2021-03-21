/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eugeniosolucoes.mybooks.service.impl;

import br.com.eugeniosolucoes.mybooks.model.Livro;
import br.com.eugeniosolucoes.mybooks.repository.LivroRepository;
import br.com.eugeniosolucoes.mybooks.service.LivroService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service( "livroService" )
public class LivroServiceImpl implements LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Override
    public Page<Livro> findAll( Pageable pageable ) {
        return livroRepository.findAll( pageable );
    }

    @Override
    public Optional<Livro> findById( String id ) {
        return livroRepository.findById( Long.valueOf( id ) );
    }

    @Override
    public Livro save( Livro livro ) {
        return livroRepository.save( livro );
    }

    @Override
    public void delete( Livro livro ) {
        livroRepository.delete( livro );
    }

}
