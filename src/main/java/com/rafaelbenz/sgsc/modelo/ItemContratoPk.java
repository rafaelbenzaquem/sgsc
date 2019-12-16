package com.rafaelbenz.sgsc.modelo;

import java.io.Serializable;
import java.util.Objects;

public class ItemContratoPk implements Serializable {
    private static final long serialVersionUID=1L;

    private Contrato contrato;

    private Servico servico;

    public ItemContratoPk() {
    }

    public ItemContratoPk(Contrato contrato, Servico servico) {
        this.contrato = contrato;
        this.servico = servico;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemContratoPk)) return false;
        ItemContratoPk that = (ItemContratoPk) o;
        return Objects.equals(getContrato(), that.getContrato()) &&
                Objects.equals(getServico(), that.getServico());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getContrato(), getServico());
    }
}
