package com.rafaelbenz.sgsc.modelo;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.gson.annotations.SerializedName;
import com.rafaelbenz.sgsc.modelo.enums.EstadoPagamento;
import java.io.Serializable;

@JsonTypeName("pagamentoComCartao")
public class PagamentoComCartao extends Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer numeroParcelas;
    @SerializedName("@type")
    private String type;

    public PagamentoComCartao() {
        type = "pagamentoComCartao";
    }

    public PagamentoComCartao(Integer id, EstadoPagamento estado, Contrato pedido, Integer numeroParcelas) {
        super(id, estado, pedido);
        type = "pagamentoComCartao";
        this.numeroParcelas = numeroParcelas;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(Integer numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }
}
