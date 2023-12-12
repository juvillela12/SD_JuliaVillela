package br.inatel.labs.lab_rest_server.model;

import java.math.BigDecimal;

public class Produto {
   
    private long id;

    private String descricao;

    private BigDecimal preco;

    //constructor gerado com Ctrl+3 > 'gcuf' (Generate Constructor Using Fields)
    public Produto(long id, String descricao, BigDecimal preco) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
    }

    //constructor padrão
    public Produto(){

    }

    //getters and setters com Ctrl+3 > 'ggas' (Generate Getter and Setter) 
    //equals e hashCode com Ctrl+1 > 'equa' (Selecionar e chegar o 'id')
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
