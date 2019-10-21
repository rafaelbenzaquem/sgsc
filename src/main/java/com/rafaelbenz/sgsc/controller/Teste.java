/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelbenz.sgsc.controller;

import com.rafson.Rafson;
import com.rafson.Response;

/**
 *
 * @author adm_rafaelneto
 */
public class Teste {
    public static void main(String[] args) {
        String login ="{"
                + "\"login\":\"admin\","
                + "\"senha\":\"admin\""
                + "}";
        
        Response response = new Rafson().post("http://localhost:8080/usuarios/login", login);
        System.out.println(response.getHeader());
        System.out.println(response.getBody());
    }
}
