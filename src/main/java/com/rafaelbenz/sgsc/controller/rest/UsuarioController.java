/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelbenz.sgsc.controller.rest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rafaelbenz.sgsc.controller.IController;
import com.rafaelbenz.sgsc.modelo.Usuario;
import com.rafson.Rafson;
import com.rafson.Response;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rafael Benzaquem Neto
 */
public class UsuarioController implements IController<Usuario> {

    private final Rafson rafson;
    private final String URI = "http://localhost:8080/usuarios/";

    public UsuarioController() {
        rafson = new Rafson();
    }

    @Override
    public Boolean salvar(Usuario usuario) {
        String body = new Gson().toJson(usuario);
        Response response = rafson.post(URI, body);
        System.out.println(response.getHeader());
        String code = response.getHeader().get(null).get(0);
        return code.contains("201");
    }

    @Override
    public Usuario ler(Serializable id) {
        Usuario usuario = new Usuario();
        Response response = rafson.get(URI + id);
        System.out.println(response.getHeader());
        String code = response.getHeader().get(null).get(0);
        if (code.contains("200")) {
            String resposta = response.getBody();
            usuario = new Gson().fromJson(resposta, Usuario.class);
        }
        return usuario;
    }

    @Override
    public List<Usuario> listar() {
        List<Usuario> usuarios = new ArrayList<>();
        Response response = rafson.get(URI);
        String code = response.getHeader().get(null).get(0);
        if (code.contains("200")) {
            String resposta = response.getBody();
            java.lang.reflect.Type collectionType = new TypeToken<List<Usuario>>() {
            }.getType();
            usuarios = new Gson().fromJson(resposta, collectionType);
        }
        return usuarios;
    }

    @Override
    public Boolean atualizar(Usuario usuario) {
        String body = new Gson().toJson(usuario);
        Response response = rafson.put(URI + usuario.getId(), body);
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

    public Usuario login(String login, String senha) {
        String jsonLogin = "{"
                + "\"login\":\"" + login + "\","
                + "\"senha\":\"" + senha + "\""
                + "}";
        Response response = rafson.post(URI + "/login", jsonLogin);
        System.out.println(response.getHeader());
        Usuario usuarioLogado = new Gson().fromJson(response.getBody(), Usuario.class);
        return usuarioLogado;
    }
}
