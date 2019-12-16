package com.rafaelbenz.sgsc.modelo;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.gson.annotations.SerializedName;
import com.rafaelbenz.sgsc.modelo.enums.EstadoPagamento;
import java.io.Serializable;
import java.util.Date;

@JsonTypeName("pagamentoComBoleto")
public class PagamentoComBoleto extends Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long dataPagamento;
    private Long dataVencimento;
    @SerializedName("@type")
    private String type;

    public PagamentoComBoleto() {
        type = "pagamentoComBoleto";
    }

    public PagamentoComBoleto(Integer id, EstadoPagamento estado, Contrato contrato, Long dataPagamento, Long dataVencimento) {
        super(id, estado, contrato);
        type = "pagamentoComBoleto";
        this.dataPagamento = dataPagamento;
        this.dataVencimento = dataVencimento;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Long dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Long getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Long dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
}
