/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelbenz.sgsc.ui.desktop.servico;

import com.rafaelbenz.sgsc.modelo.Servico;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rafael Benzaquem Neto
 */
public class ServicoTableModel extends AbstractTableModel {

    private final List<Servico> servicos;

    public ServicoTableModel() {
        servicos = new ArrayList<>();
    }

    public List<Servico> getClientes() {
        return servicos;
    }

    /**
     *
     * @param servico
     * @return
     */
    public boolean addRow(Servico servico) {
        if (servicos.contains(servico)) {
            return false;
        }
        boolean isAdded = servicos.add(servico);
        fireTableDataChanged();
        return isAdded;
    }

    /**
     *
     * @param id
     * @param nome
     * @param preco
     * @return
     */
    public boolean addRow(Integer id, String nome, double preco) {
        return addRow(new Servico(id, nome, preco));
    }

    /**
     *
     * @param rowData
     * @return
     */
    public boolean addRow(Object[] rowData) {
        return addRow(new Servico((Integer) rowData[0], (String) rowData[1], (double) rowData[2]));
    }

    public boolean removeAll() {
        boolean isRemoved = servicos.removeAll(servicos);
        fireTableDataChanged();
        return isRemoved;
    }

    /**
     *
     * @param servico
     * @return
     */
    public boolean removeRow(Servico servico) {
        boolean isRemoved = servicos.remove(servico);
        fireTableDataChanged();
        return isRemoved;
    }

    /**
     *
     * @param id
     * @param nome
     * @param preco
     * @return
     */
    public boolean removeRow(Integer id, String nome, double preco) {
        return removeRow(new Servico(id, nome, preco));
    }

    /**
     *
     * @param rowData
     * @return
     */
    public boolean removeRow(Object[] rowData) {
        return removeRow(new Servico((Integer) rowData[0], (String) rowData[1], (double) rowData[2]));
    }

    /**
     *
     * @param rowIndex
     * @return
     */
    public Object[] getRow(int rowIndex) {
        if (servicos.isEmpty()) {
            return null;
        } else {
            Servico servico = servicos.get(rowIndex);
            Object[] objects = {servico.getId(), servico.getNome(), servico.getPreco()};
            return objects;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (!servicos.isEmpty()) {
            Servico servico = servicos.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return servico.getId();
                case 1:
                    return servico.getNome();
                case 2:
                    return servico.getPreco();
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
                return "Preco";
        }
        return "";
    }

    @Override
    public int getRowCount() {
        return servicos.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

}
