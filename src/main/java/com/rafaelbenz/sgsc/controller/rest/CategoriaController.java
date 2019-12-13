/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelbenz.sgsc.controller.rest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rafaelbenz.sgsc.controller.IController;
import com.rafaelbenz.sgsc.modelo.Categoria;
import com.rafaelbenz.sgsc.modelo.Servico;
import com.rafson.Rafson;
import com.rafson.Response;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rafael Benzaquem Neto
 */
public class CategoriaController implements IController<Categoria> {

    private final Rafson rafson;
    private final String URI = "http://localhost:8080/categorias/";

    public CategoriaController() {
        this.rafson = new Rafson();
    }

    @Override
    public Boolean salvar(Categoria categoria) {
        String body = new Gson().toJson(categoria);
        Response response = rafson.post(URI, body);
        System.out.println(response.getHeader());
        String code = response.getHeader().get(null).get(0);
        return code.contains("201");
    }

    @Override
    public Categoria ler(Serializable id) {
        Categoria categoria = new Categoria();
        Response response = rafson.get(URI + id);
        System.out.println(response.getHeader());
        String code = response.getHeader().get(null).get(0);
        if (code.contains("200")) {
            String resposta = response.getBody();
            categoria = new Gson().fromJson(resposta, Categoria.class);
        }
        return categoria;
    }

    @Override
    public List<Categoria> listar() {
        List<Categoria> categorias = new ArrayList<>();
        Response response = rafson.get(URI);
        String code = response.getHeader().get(null).get(0);
        if (code.contains("200")) {
            String resposta = response.getBody();
            java.lang.reflect.Type collectionType = new TypeToken<List<Categoria>>() {
            }.getType();
            categorias = new Gson().fromJson(resposta, collectionType);
        }
        return categorias;
    }

    @Override
    public Boolean atualizar(Categoria categoria) {
        String body = new Gson().toJson(categoria);
        Response response = rafson.put(URI + categoria.getId(), body);
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

    public List<Categoria> buscarPorServicos(List<Servico> servicos) {
        List<Categoria> categorias = new ArrayList<>();

        Response response = rafson.get(URI + "/search/?servicos=" + urlServicos(servicos));

        String code = response.getHeader().get(null).get(0);
        if (code.contains("200")) {
            String resposta = response.getBody();
            java.lang.reflect.Type collectionType = new TypeToken<List<Categoria>>() {
            }.getType();
            categorias = new Gson().fromJson(resposta, collectionType);
        }

        return categorias;
    }

    private String urlServicos(List<Servico> servicos) {
        StringBuilder url = new StringBuilder("");
        for (int i = 0; i < servicos.size(); i++) {
            url.append(servicos.get(i).getId());
            if (i < servicos.size() - 1) {
                url.append(",");
            }
        }
        return url.toString();
    }

}
