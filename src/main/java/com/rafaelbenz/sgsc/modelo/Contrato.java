package com.rafaelbenz.sgsc.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

public class Contrato implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Long instante;

    private Cliente cliente;
    private Pagamento pagamento;

    

    private Set<ItemContrato> itens = new HashSet<>();

    public Contrato() {
    }

    public Contrato(Integer id, Long instante, Pagamento pagamento, Cliente cliente) {
        this.id = id;
        this.instante = instante;
        this.pagamento = pagamento;
        this.cliente = cliente;
    }

    @JsonIgnore
    public List<Servico> getServicos() {
        List<Servico> servicos = new ArrayList<>();
        for (ItemContrato item : itens)
            servicos.add(item.getServico());
        return servicos;
    }

    public BigDecimal getValorTotal() {
        BigDecimal soma = new BigDecimal(0.0);
        for (ItemContrato itemPedido : itens) {
            soma = soma.add(itemPedido.getSubTotal());
        }
        return soma;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getInstante() {
        return instante;
    }

    public void setInstante(Long instante) {
        this.instante = instante;
    }

     public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

   

    public Set<ItemContrato> getItens() {
        return itens;
    }

    public void setItens(Set<ItemContrato> itens) {
        this.itens = itens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contrato)) return false;
        Contrato pedido = (Contrato) o;
        return Objects.equals(getId(), pedido.getId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }
}
