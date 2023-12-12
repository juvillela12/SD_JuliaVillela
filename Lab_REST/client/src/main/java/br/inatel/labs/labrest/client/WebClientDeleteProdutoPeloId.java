package br.inatel.labs.labrest.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

public class WebClientDeleteProdutoPeloId {

    public static void main(String[] args) {

        try{
            ResponseEntity<Void> responseEntity = WebClient.create(Constante.URL)
                    .delete()
                    .uri("/produto/3")
                    .retrieve()
                    .toBodilessEntity()
                    .block();

            HttpStatusCode statusCode = responseEntity.getStatusCode();

            System.out.println("Produto Removido:");
            System.out.println("Status da resposta: " + statusCode);

        } catch (WebClientResponseException e){
            System.out.println(e.getStatusCode());
        }
    }
}
