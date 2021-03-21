package br.com.eugeniosolucoes.mybooks.resource;

import br.com.eugeniosolucoes.mybooks.model.Livro;
import br.com.eugeniosolucoes.mybooks.service.LivroService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin( origins = "*" )
@RestController
@RequestMapping( value = "/api" )
@Api( value = "API REST Livros" )
public class LivroResource {

    @Autowired
    LivroService livroService;

    @ApiOperation( value = "Retornar uma lista de Livros" )
    @GetMapping( "/livros" )
    public ResponseEntity<Page<Livro>> listarTodos( @PageableDefault( page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC ) Pageable pageable ) {
        Page<Livro> livePage = livroService.findAll( pageable );
        if ( livePage.isEmpty() ) {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND );
        } else {
            return new ResponseEntity<Page<Livro>>( livePage, HttpStatus.OK );
        }
    }

    @ApiOperation( value = "Retornar um unico livro" )
    @GetMapping( "/livro/{id}" )
    public ResponseEntity<Livro> retornar( @PathVariable( value = "id" ) String id ) {
        Optional<Livro> livro = livroService.findById( id );
        if ( !livro.isPresent() ) {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND );
        } else {
            return new ResponseEntity<Livro>( livro.get(), HttpStatus.OK );
        }
    }

    @ApiOperation( value = "Salvar um livro" )
    @PostMapping( "/livro" )
    public ResponseEntity<Livro> salvar( @RequestBody @Valid Livro livro ) {
        return new ResponseEntity<Livro>( livroService.save( livro ), HttpStatus.CREATED );
    }

    @ApiOperation( value = "Deletar um livro" )
    @DeleteMapping( "/livro" )
    public ResponseEntity<?> excluir( @PathVariable( value = "id" ) String id ) {
        Optional<Livro> liveO = livroService.findById( id );
        if ( !liveO.isPresent() ) {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND );
        } else {
            livroService.delete( liveO.get() );
            return new ResponseEntity<>( HttpStatus.OK );
        }
    }

    @ApiOperation( value = "Atualizar um livro" )
    @PutMapping( "/livro" )
    public ResponseEntity<Livro> atualizar( @PathVariable( value = "id" ) String id,
            @RequestBody @Valid Livro livro ) {
        Optional<Livro> livroO = livroService.findById( id );
        if ( !livroO.isPresent() ) {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND );
        } else {
            livro.setId( livroO.get().getId() );
            return new ResponseEntity<Livro>( livroService.save( livro ), HttpStatus.OK );
        }
    }

}
