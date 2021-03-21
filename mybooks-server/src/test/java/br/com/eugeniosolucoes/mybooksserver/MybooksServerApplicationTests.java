package br.com.eugeniosolucoes.mybooksserver;

import br.com.eugeniosolucoes.mybooks.MybooksServerApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith( SpringExtension.class )
@SpringBootTest( classes = MybooksServerApplication.class )
class MybooksServerApplicationTests {

    @Test
    void contextLoads() {
    }

}
