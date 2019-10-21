/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelbenz.sgsc.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rafaelbenz.sgsc.modelo.Cliente;
import com.rafson.Rafson;
import com.rafson.Response;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rafael Benzaquem Neto
 */
public class ClienteRafsonController implements IController<Cliente> {

    private final Rafson rafson;
    private String uriClientes = "http://localhost:8080/clientes/";

    public ClienteRafsonController() {
        this.rafson = new Rafson();
    }

    @Override
    public Boolean salvar(Cliente cliente) {
        String body = new Gson().toJson(cliente);
        Response response = rafson.post(uriClientes, body);
        System.out.println(response.getHeader());
        String code = response.getHeader().get(null).get(0);
        return code.contains("201");
    }

    @Override
    public Cliente ler(Serializable id) {
        Cliente cliente = new Cliente();
        Response response = rafson.get(uriClientes + id);
        System.out.println(response.getHeader());
        String code = response.getHeader().get(null).get(0);
        if (code.contains("200")) {
            String resposta = response.getBody();
            cliente = new Gson().fromJson(resposta, Cliente.class);
        }
        return cliente;
    }

    @Override
    public List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<>();
        Response response = rafson.get(uriClientes);
        System.out.println(response.getHeader());
        String code = response.getHeader().get(null).get(0);
        if (code.contains("200")) {
            String resposta = response.getBody();
            java.lang.reflect.Type collectionType = new TypeToken<List<Cliente>>() {
            }.getType();
            clientes = new Gson().fromJson(resposta, collectionType);
        }
        return clientes;
    }

    @Override
    public Boolean atualizar(Cliente cliente) {
        String body = new Gson().toJson(cliente);
        Response response = rafson.put(uriClientes + cliente.getId(), body);
        System.out.println(response.getHeader());
        String code = response.getHeader().get(null).get(0);
        return code.contains("204");
    }

    @Override
    public Boolean deletar(Serializable id) {
        Response response = rafson.delete(uriClientes + id);
        System.out.println(response.getHeader());
        String code = response.getHeader().get(null).get(0);
        return code.contains("200");
    }

}
