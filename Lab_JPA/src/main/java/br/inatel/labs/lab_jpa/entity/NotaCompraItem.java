package br.inatel.labs.lab_jpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Objects;


@Entity
@Data
public class NotaCompraItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Positive
    private BigDecimal valorCompraProduto;

    @NotNull
    @Positive
    private Integer quantidade;

    @ManyToOne
    private NotaCompra notaCompra;

    @ManyToOne
    private Produto produto;
    
    public NotaCompraItem() {
    }

    public NotaCompraItem(NotaCompra notaCompra, Produto produto,@NotNull @Positive BigDecimal valorCompraProduto,@NotNull @Positive Integer quantidade) {
        this.notaCompra = notaCompra;
        this.produto = produto;
        this.valorCompraProduto = valorCompraProduto;
        this.quantidade = quantidade;
    }

    public BigDecimal getCalculoTotalItem(){
        return valorCompraProduto.multiply(BigDecimal.valueOf(quantidade));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotaCompraItem that = (NotaCompraItem) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
