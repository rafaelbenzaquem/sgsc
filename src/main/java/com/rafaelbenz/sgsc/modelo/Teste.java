/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelbenz.sgsc.modelo;

import com.google.gson.Gson;
import com.rafaelbenz.sgsc.modelo.enums.EstadoPagamento;
import com.rafson.Rafson;
import com.rafson.Response;
import java.util.Date;

/**
 *
 * @author rbnbs
 */
public class Teste {

    public static void main(String[] args) {
        Rafson rafson = new Rafson();
        String URI = "http://localhost:8080/contratos/";

        PagamentoComCartao pagamentoComCartao = new PagamentoComCartao();
//        pagamentoComCartao.setEstado(EstadoPagamento.PENDENTE);
        pagamentoComCartao.setNumeroParcelas(10);
        Contrato contrato = new Contrato(null, null, pagamentoComCartao, new Cliente(1, null, null));

        ItemContrato item = new ItemContrato(null, new Servico(3, null, null), null, 2, null);
        ItemContrato item2 = new ItemContrato(null, new Servico(1, null, null), null, 1, null);
        contrato.getItens().add(item);
        contrato.getItens().add(item2);

        int clientId = contrato.getCliente().getId();
        int numeroParcelas = 10;
        String tipoPagamento = "\"pagamentoComCartao\"";
        String jsonItens = "";

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
                + " \"numeroDeParcelas\" : " + numeroParcelas + ",\n"
                + " \"@type\": " + tipoPagamento + "\n"
                + " },\n"
                + " \"itens\" : [\n"
                + jsonItens
                + " ]\n"
                + "}";

        System.out.println("com.rafaelbenz.sgsc.modelo.Teste.main()\n\n" + body);
        Response response = rafson.post(URI, body);

    }
}
