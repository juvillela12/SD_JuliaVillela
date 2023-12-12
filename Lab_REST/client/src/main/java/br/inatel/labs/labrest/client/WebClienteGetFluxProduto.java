package br.inatel.labs.labrest.client;

import br.inatel.labs.labrest.client.model.dto.ProdutoDTO;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class WebClienteGetFluxProduto {


    public static void main(String[] args) {

        List<ProdutoDTO> productList = new ArrayList<ProdutoDTO>();

        Flux<ProdutoDTO> fluxProduto = WebClient.create(Constante.URL).get().uri("/produto").retrieve()
        .bodyToFlux(ProdutoDTO.class);

        fluxProduto.subscribe(p -> listaProduto.add(p));

        fluxProduto.blockLast();

        System.out.println("Lista de produtos:");
        System.out.println(listaProduto);
       
    }
}
