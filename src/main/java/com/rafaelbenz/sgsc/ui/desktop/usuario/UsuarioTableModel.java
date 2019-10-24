/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelbenz.sgsc.ui.desktop.usuario;

import com.rafaelbenz.sgsc.modelo.Cliente;
import com.rafaelbenz.sgsc.modelo.Usuario;
import com.rafaelbenz.sgsc.modelo.enums.TipoUsuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rafael Benzaquem Neto
 */
public class UsuarioTableModel extends AbstractTableModel {

    private final List<Usuario> usuarios;

    public UsuarioTableModel() {
        usuarios = new ArrayList<>();
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     *
     * @param usuario
     * @return
     */
    public boolean addRow(Usuario usuario) {
        if (usuarios.contains(usuario)) {
            return false;
        }
        boolean isAdded = usuarios.add(usuario);
        fireTableDataChanged();
        return isAdded;
    }

    /**
     *
     * @param id
     * @param nome
     * @param tipo
     * @param login
     * @return
     */
    public boolean addRow(String nome, String login, TipoUsuario tipo) {
        return addRow(new Usuario(nome, login, null, tipo));
    }

    /**
     *
     * @param rowData
     * @return
     */
    public boolean addRow(Object[] rowData) {
        return addRow(new Usuario((String) rowData[0], (String) rowData[1], null, (TipoUsuario) rowData[2]));
    }

    public boolean removeAll() {
        boolean isRemoved = usuarios.removeAll(usuarios);
        fireTableDataChanged();
        return isRemoved;
    }

    /**
     *
     * @param usuario
     * @return
     */
    public boolean removeRow(Usuario usuario) {
        boolean isRemoved = usuarios.remove(usuario);
        fireTableDataChanged();
        return isRemoved;
    }

    /**
     *
     * @param nome
     * @param login
     * @param tipo
     * @return
     */
    public boolean removeRow(String nome, String login, TipoUsuario tipo) {
        return removeRow(new Usuario(nome, login, null, tipo));
    }

    /**
     *
     * @param rowData
     * @return
     */
    public boolean removeRow(Object[] rowData) {
        return removeRow(new Usuario((String) rowData[0], (String) rowData[1], null, (TipoUsuario) rowData[2]));
    }

    /**
     *
     * @param rowIndex
     * @return
     */
    public Object[] getRow(int rowIndex) {
        if (usuarios.isEmpty()) {
            return null;
        } else {
            Usuario usuario = usuarios.get(rowIndex);
            Object[] objects = {usuario.getId(), usuario.getNome(), TipoUsuario.toEnum(usuario.getTipo())};
            return objects;
        }
    }

    /**
     *
     * @param rowIndex
     * @return
     */
    public Usuario getObject(int rowIndex) {
        if (usuarios.isEmpty()) {
            return null;
        } else {
            return usuarios.get(rowIndex);
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (!usuarios.isEmpty()) {
            Usuario usuario = usuarios.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return usuario.getNome();
                case 1:
                    return usuario.getLogin();
                case 2:
                    return TipoUsuario.toEnum(usuario.getTipo());
            }

        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nome";
            case 1:
                return "Login";
            case 2:
                return "Tipo Usuário";
        }
        return "";
    }

    @Override
    public int getRowCount() {
        return usuarios.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

}
