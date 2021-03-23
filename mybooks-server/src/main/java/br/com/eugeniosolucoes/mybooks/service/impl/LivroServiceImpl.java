/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eugeniosolucoes.mybooks.service.impl;

import br.com.eugeniosolucoes.mybooks.dto.LivroDTO;
import br.com.eugeniosolucoes.mybooks.model.Assunto;
import br.com.eugeniosolucoes.mybooks.model.Autor;
import br.com.eugeniosolucoes.mybooks.model.Livro;
import br.com.eugeniosolucoes.mybooks.repository.AssuntoRepository;
import br.com.eugeniosolucoes.mybooks.repository.AutorRepository;
import br.com.eugeniosolucoes.mybooks.repository.LivroRepository;
import br.com.eugeniosolucoes.mybooks.service.LivroService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service( "livroService" )
public class LivroServiceImpl implements LivroService {

    @Autowired
    EntityManager entityManager;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private AssuntoRepository assuntoRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Override
    public List<LivroDTO> findAll() {
        List<Livro> findAll = livroRepository.findAll();
        List<LivroDTO> livroDTOs = new ArrayList<>();
        findAll.stream().map( (livro) -> new LivroDTO( livro ) ).forEachOrdered( (livroDTO) -> {
            livroDTOs.add( livroDTO );
        } );
        return livroDTOs;
    }

    @Override
    public Optional<LivroDTO> findById( String id ) {
        Optional<Livro> livro = livroRepository.findById( Long.valueOf( id ) );
        if ( livro.isPresent() ) {
            LivroDTO livroDTO = new LivroDTO( livro.get() );
            return Optional.of( livroDTO );
        }
        return Optional.empty();
    }

    @Override
    public LivroDTO save( LivroDTO livroDTO ) {
        Livro livro = livroDTO.get();
        tratarAutoresAssuntos( livro );
        Livro saved = livroRepository.save( livro );
        return new LivroDTO( saved );
    }

    @Override
    public void delete( LivroDTO livro ) {
        try {
            livroRepository.deleteById( Long.valueOf( livro.getId() ) );
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }

    private void tratarAutoresAssuntos( Livro livro ) {
        List<Autor> autores = livro.getAutores();
        for ( int i = 0; i < autores.size(); i++ ) {
            Autor autor = autores.get( i );
            Autor findByNome = autorRepository.findByNome( autor.getNome() );
            if ( findByNome != null ) {
                autores.set( i, findByNome );
            } else {
                validarAutor( autor );
                autorRepository.save( autor );
            }
        }
        List<Assunto> assuntos = livro.getAssuntos();
        for ( int i = 0; i < assuntos.size(); i++ ) {
            Assunto assunto = assuntos.get( i );
            Assunto findAssunto = assuntoRepository.findByDescricao( assunto.getDescricao() );
            if ( findAssunto != null ) {
                assuntos.set( i, findAssunto );
            } else {
                validarAssunto( assunto );
                assuntoRepository.save( assunto );
            }
        }
    }

    private void validarAutor( Autor autor ) {
        if ( autor.getNome() == null || autor.getNome().trim().isEmpty() ) {
            throw new IllegalArgumentException( "O autor inválido!" );
        }
        if ( autor.getNome().length() > 40 ) {
            throw new IllegalArgumentException( "O autor deve ter no máximo 40 caracteres!" );
        }
    }

    private void validarAssunto( Assunto assunto ) {
        if ( assunto.getDescricao() == null || assunto.getDescricao().trim().isEmpty() ) {
            throw new IllegalArgumentException( "O assunto inválido!" );
        }
        if ( assunto.getDescricao().length() > 20 ) {
            throw new IllegalArgumentException( "O assunto deve ter no máximo 20 caracteres!" );
        }
    }

}
