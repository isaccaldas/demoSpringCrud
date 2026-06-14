package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Produto;


public interface ProdutoRepository 
        extends JpaRepository<Produto, Long> { //Pega o Produto e o tipo do id 

}