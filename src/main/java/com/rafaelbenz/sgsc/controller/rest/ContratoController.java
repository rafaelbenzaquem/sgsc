/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelbenz.sgsc.controller.rest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rafaelbenz.sgsc.controller.IController;
import com.rafaelbenz.sgsc.modelo.Cliente;
import com.rafaelbenz.sgsc.modelo.Contrato;
import com.rafaelbenz.sgsc.modelo.ItemContrato;
import com.rafaelbenz.sgsc.modelo.PagamentoComBoleto;
import com.rafaelbenz.sgsc.modelo.PagamentoComCartao;
import com.rafson.Rafson;
import com.rafson.Response;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rbnbs
 */
public class ContratoController implements IController<Contrato> {

    private final Rafson rafson;
    private String URI = "http://localhost:8080/contratos/";

    public ContratoController() {
        this.rafson = new Rafson();
    }

    @Override
    public Boolean salvar(Contrato contrato) {
        String body = contratoParse(contrato);
        Response response = rafson.post(URI, body);
        System.out.println(response.getHeader());
        String code = response.getHeader().get(null).get(0);
        return code.contains("201");
    }

    public String contratoParse(Contrato contrato) {
        int clientId = contrato.getCliente().getId();

        String tipoPagamento = "";
        String jsonItens = "";

        if (contrato.getPagamento() instanceof PagamentoComBoleto) {
            PagamentoComBoleto p = (PagamentoComBoleto) contrato.getPagamento();
            tipoPagamento =  "\"@type\": \"" + p.getType() + "\"\n";
        } else if (contrato.getPagamento() instanceof PagamentoComCartao) {
            PagamentoComCartao p = (PagamentoComCartao) contrato.getPagamento();
            tipoPagamento = " \"numeroDeParcelas\" : " + p.getNumeroParcelas() + ",\n"
                    + " \"@type\": \"" + p.getType() + "\"\n";
        }

        for (ItemContrato itemContrato : contrato.getItens()) {
            jsonItens += jsonItens.endsWith("}\n") ? "," : "";
            jsonItens += " {\n"
                    + " \"quantidade\" :" + itemContrato.getQuantidade() + ",\n"
                    + " \"servico\" : {\"id\" : " + itemContrato.getServico().getId() + "}\n"
                    + " }\n";
        }

        String body = "{\n"
                + " \"cliente\" : {\"id\" : " + clientId + "},\n"
                + " \"pagamento\" : {\n"
                + tipoPagamento
                + " },\n"
                + " \"itens\" : [\n"
                + jsonItens
                + " ]\n"
                + "}";

        return body;
    }

    @Override
    public Contrato ler(Serializable id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Contrato> listar() {
        List<Contrato> contratos = new ArrayList<>();
        Response response = rafson.get(URI+"/all");
        System.out.println(response.getHeader());
        String code = response.getHeader().get(null).get(0);
        if (code.contains("200")) {
            String resposta = response.getBody();
            java.lang.reflect.Type collectionType = new TypeToken<List<Contrato>>() {
            }.getType();
            contratos = new Gson().fromJson(resposta, collectionType);
        }
        return contratos;
    }

    @Override
    public Boolean atualizar(Contrato contrato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean deletar(Serializable id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
