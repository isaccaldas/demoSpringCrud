package com.example.demo.controller;




import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {


    private final ProdutoRepository repository;


    public ProdutoController(ProdutoRepository repository){
        this.repository = repository;
    }


    @GetMapping
    public List<Produto> listar(){

        return repository.findAll();
    }



    @PostMapping
    public Produto salvar(
            @RequestBody Produto produto){

        return repository.save(produto);
    }



    @GetMapping("/{id}")
    public Produto buscar(
            @PathVariable Long id){

        return repository.findById(id)
                .orElseThrow();
    }



    @PutMapping("/{id}")
    public Produto atualizar(
            @PathVariable Long id,
            @RequestBody Produto produto){

        produto.setId(id);

        return repository.save(produto);
    }



    @DeleteMapping("/{id}")
    public void excluir(
            @PathVariable Long id){

        repository.deleteById(id);
    }

}
