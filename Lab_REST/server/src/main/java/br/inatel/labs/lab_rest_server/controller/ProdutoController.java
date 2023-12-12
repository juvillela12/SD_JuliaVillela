package br.inatel.labs.lab_rest_server.controller;

import br.inatel.labs.lab_rest_server.model.Produto;
import br.inatel.labs.lab_rest_server.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public List<Produto> getProdutos(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Produto getProdutoById(@PathVariable("id") Long produtoId){
        Optional<Produto> opProduto = service.findById(produtoId);

        if(opProduto.isPresent()){
            return opProduto.get();
        }

        String msg = String.format("Nenhum produto encontrado com id [%s]", produtoId);
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,msg);

    }

    @PostMapping
    @ResponseStatus(code=HttpStatus.CREATED)
    public Produto postProduto(@RequestBody Produto p){
        Produto produtoCriado = service.create( p );
        return produtoCriado;

    }

    @PutMapping
    @ResponseStatus(code=HttpStatus.NO_CONTENT)
    public void putProduto(Produto p){
        service.update(p);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code=HttpStatus.NO_CONTENT)
    public void deleteProduto(@PathVariable("id") Long produtoId){
        Produto produtoEncontrado = getProdutoById(produtoId);
        service.remove(produtoEncontrado);
    }


}
