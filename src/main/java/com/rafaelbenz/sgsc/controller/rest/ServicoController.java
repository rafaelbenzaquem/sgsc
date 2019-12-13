/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelbenz.sgsc.controller.rest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rafaelbenz.sgsc.modelo.Servico;
import com.rafaelbenz.sgsc.controller.IController;
import com.rafaelbenz.sgsc.modelo.Categoria;
import com.rafson.Rafson;
import com.rafson.Response;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rafael Benzaquem Neto
 */
public class ServicoController implements IController<Servico> {

    private final Rafson rafson;
    private final String URI = "http://localhost:8080/servicos/";

    public ServicoController() {
        rafson = new Rafson();
    }

    @Override
    public Boolean salvar(Servico servico) {
        String body = new Gson().toJson(servico);
        Response response = rafson.post(URI, body);
        System.out.println(response.getHeader());
        String code = response.getHeader().get(null).get(0);
        return code.contains("201");
    }

    @Override
    public Servico ler(Serializable id) {
        Servico servico = new Servico();
        Response response = rafson.get(URI + id);
        System.out.println(response.getHeader());
        String code = response.getHeader().get(null).get(0);
        if (code.contains("200")) {
            String resposta = response.getBody();
            servico = new Gson().fromJson(resposta, Servico.class);
        }
        return servico;
    }

    @Override
    public List<Servico> listar() {
        List<Servico> servicos = new ArrayList<>();
        Response response = rafson.get(URI);
        String code = response.getHeader().get(null).get(0);
        if (code.contains("200")) {
            String resposta = response.getBody();
            java.lang.reflect.Type collectionType = new TypeToken<List<Servico>>() {
            }.getType();
            servicos = new Gson().fromJson(resposta, collectionType);
        }
        return servicos;
    }

    @Override
    public Boolean atualizar(Servico servico) {
        String body = new Gson().toJson(servico);
        Response response = rafson.put(URI + servico.getId(), body);
        System.out.println(response.getHeader());
        String code = response.getHeader().get(null).get(0);
        return code.contains("204");
    }

    @Override
    public Boolean deletar(Serializable id) {
        Response response = rafson.delete(URI + id);
        System.out.println(response.getHeader());
        String code = response.getHeader().get(null).get(0);
        return code.contains("204");
    }
    
    public List<Servico> buscaPorNomeECategorias(String nome, List<Categoria> categorias) {
        List<Servico> servicos = new ArrayList<>();
        Response response;
        if (nome == null || nome.isEmpty()) {
            response = rafson.get(URI + "/search/?categorias=" + urlCategorias(categorias));
        } else if (categorias == null || categorias.isEmpty()) {
            response = rafson.get(URI + "/search/?nome=" + nome);
        } else {
            response = rafson.get(URI + "/search/?nome" + nome + "&categorias=" + urlCategorias(categorias));
        }
        String code = response.getHeader().get(null).get(0);
        if (code.contains("200")) {
            String resposta = response.getBody();
            java.lang.reflect.Type collectionType = new TypeToken<List<Servico>>() {
            }.getType();
            servicos = new Gson().fromJson(resposta, collectionType);
        }
        return servicos;
    }

    private String urlCategorias(List<Categoria> categorias) {
        StringBuilder url = new StringBuilder("");
        for (int i = 0; i < categorias.size(); i++) {
            url.append(categorias.get(i).getId());
            if (i < categorias.size() - 1) {
                url.append(",");
            }
        }
        return url.toString();
    }

}
