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
    private final String URL = "http://localhost:8080/usuarios";

    public UsuarioController() {
        rafson = new Rafson();
    }

    @Override
    public Boolean salvar(Usuario e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario ler(Serializable id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> listar() {
        List<Usuario> usuarios = new ArrayList<>();
        Response response = rafson.get(URL);
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
    public Boolean atualizar(Usuario e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean deletar(Serializable id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Usuario login(String login, String senha) {
        String jsonLogin = "{"
                + "\"login\":\"" + login + "\","
                + "\"senha\":\"" + senha + "\""
                + "}";
        Response response = rafson.post(URL + "/login", jsonLogin);
        Usuario usuarioLogado = new Gson().fromJson(response.getBody(), Usuario.class);
        return usuarioLogado;
    }
}
