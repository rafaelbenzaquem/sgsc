/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelbenz.sgsc.ui.desktop.cliente;

import com.rafaelbenz.sgsc.modelo.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rafael Benzaquem Neto
 */
public class ClienteTableModel extends AbstractTableModel {

    private final List<Cliente> clientes;

    public ClienteTableModel() {
        clientes = new ArrayList<>();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    /**
     *
     * @param cliente
     * @return
     */
    public boolean addRow(Cliente cliente) {
        if (clientes.contains(cliente)) {
            return false;
        }
        boolean isAdded = clientes.add(cliente);
        fireTableDataChanged();
        return isAdded;
    }

    /**
     *
     * @param id
     * @param nome
     * @param email
     * @return
     */
    public boolean addRow(Integer id, String nome, String email) {
        return addRow(new Cliente(id, nome, email));
    }

    /**
     *
     * @param rowData
     * @return
     */
    public boolean addRow(Object[] rowData) {
        return addRow(new Cliente((Integer) rowData[0], (String) rowData[1], (String) rowData[2]));
    }

    public boolean removeAll() {
        boolean isRemoved = clientes.removeAll(clientes);
        fireTableDataChanged();
        return isRemoved;
    }

    /**
     *
     * @param cliente
     * @return
     */
    public boolean removeRow(Cliente cliente) {
        boolean isRemoved = clientes.remove(cliente);
        fireTableDataChanged();
        return isRemoved;
    }

    /**
     *
     * @param id
     * @param nome
     * @param email
     * @return
     */
    public boolean removeRow(Integer id, String nome, String email) {
        return removeRow(new Cliente(id, nome, email));
    }

    /**
     *
     * @param rowData
     * @return
     */
    public boolean removeRow(Object[] rowData) {
        return removeRow(new Cliente((Integer) rowData[0], (String) rowData[1], (String) rowData[2]));
    }

    /**
     *
     * @param rowIndex
     * @return
     */
    public Object[] getRow(int rowIndex) {
        if (clientes.isEmpty()) {
            return null;
        } else {
            Cliente cliente = clientes.get(rowIndex);
            Object[] objects = {cliente.getId(), cliente.getNome(), cliente.getEmail()};
            return objects;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (!clientes.isEmpty()) {
            Cliente cliente = clientes.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return cliente.getId();
                case 1:
                    return cliente.getNome();
                case 2:
                    return cliente.getEmail();
            }

        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Nome";
            case 2:
                return "Email";
        }
        return "";
    }

    @Override
    public int getRowCount() {
        return clientes.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

}
