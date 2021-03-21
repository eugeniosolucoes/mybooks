/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eugeniosolucoes.mybooks.repository;

import br.com.eugeniosolucoes.mybooks.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author eugenio
 */
public interface LivroRepository extends JpaRepository<Livro, Long> {

}
