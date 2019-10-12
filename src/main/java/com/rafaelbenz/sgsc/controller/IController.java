/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelbenz.sgsc.controller;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Rafael Benzaquem Neto
 */
public interface IController<E> {
    
    public Boolean salvar(E e);
    
    public E ler(Serializable id);
    
    public List<E> listar();
    
    public Boolean atualizar(E e);
    
    public Boolean deletar(Serializable id);
        
}
