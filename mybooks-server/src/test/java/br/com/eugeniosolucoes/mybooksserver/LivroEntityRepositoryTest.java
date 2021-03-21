/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eugeniosolucoes.mybooksserver;

import br.com.eugeniosolucoes.mybooks.MybooksServerApplication;
import br.com.eugeniosolucoes.mybooks.repository.LivroRepository;
import br.com.eugeniosolucoes.mybooks.service.LivroService;
import javax.persistence.EntityManager;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 *
 * @author eugenio
 */
@ExtendWith( SpringExtension.class )
@SpringBootTest( classes = MybooksServerApplication.class )
class LivroEntityRepositoryTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private LivroService livroService;

    @Autowired
    private LivroRepository livroRepository;

    @Test
    void injectedComponentsAreNotNull() {
        assertThat( entityManager ).isNotNull();
        assertThat( livroRepository ).isNotNull();
    }

}
