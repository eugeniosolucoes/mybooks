package br.com.eugeniosolucoes.mybooks.resource;

import br.com.eugeniosolucoes.mybooks.dto.LivroDTO;
import br.com.eugeniosolucoes.mybooks.service.LivroService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public ResponseEntity<List<LivroDTO>> listarTodos( @PageableDefault( page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC ) Pageable pageable ) {
        List<LivroDTO> list = livroService.findAll();
        if ( list.isEmpty() ) {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND );
        } else {
            return new ResponseEntity<>( list, HttpStatus.OK );
        }
    }

    @ApiOperation( value = "Retornar um unico livro" )
    @GetMapping( "/livro/{id}" )
    public ResponseEntity<LivroDTO> retornar( @PathVariable( value = "id" ) String id ) {
        Optional<LivroDTO> livroO = livroService.findById( id );
        if ( !livroO.isPresent() ) {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND );
        } else {
            return new ResponseEntity<>( livroO.get(), HttpStatus.OK );
        }
    }

    @ApiOperation( value = "Salvar um livro" )
    @PostMapping( "/livro" )
    public ResponseEntity<LivroDTO> salvar( @RequestBody @Valid LivroDTO livro ) {
        return new ResponseEntity<>( livroService.save( livro ), HttpStatus.CREATED );
    }

    @ApiOperation( value = "Deletar um livro" )
    @DeleteMapping( "/livro/{id}" )
    public ResponseEntity<?> excluir( @PathVariable( value = "id" ) String id ) {
        Optional<LivroDTO> livroO = livroService.findById( id );
        if ( !livroO.isPresent() ) {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND );
        } else {
            livroService.delete( livroO.get() );
            return new ResponseEntity<>( HttpStatus.OK );
        }
    }

    @ApiOperation( value = "Atualizar um livro" )
    @PutMapping( "/livro/{id}" )
    public ResponseEntity<LivroDTO> atualizar( @PathVariable( value = "id" ) String id,
            @RequestBody @Valid LivroDTO livro ) {
        Optional<LivroDTO> livroO = livroService.findById( id );
        if ( !livroO.isPresent() ) {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND );
        } else {
            livro.setId( livroO.get().getId() );
            return new ResponseEntity<>( livroService.save( livro ), HttpStatus.OK );
        }
    }

    @RequestMapping( value = "/imprimir", method = RequestMethod.GET )
    public ResponseEntity<byte[]> imprimir() {
        byte[] relatorio = livroService.imprimir();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType( MediaType.APPLICATION_PDF );
        // Here you have to set the actual filename of your pdf
        String filename = "mybooks.pdf";
        headers.setContentDispositionFormData( filename, filename );
        headers.setCacheControl( "must-revalidate, post-check=0, pre-check=0" );
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>( relatorio, headers, HttpStatus.OK );
        return responseEntity;
    }

}
