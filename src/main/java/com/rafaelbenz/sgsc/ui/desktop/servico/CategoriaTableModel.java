/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelbenz.sgsc.ui.desktop.servico;

import com.rafaelbenz.sgsc.modelo.Categoria;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rafael Benzaquem Neto
 */
public class CategoriaTableModel extends AbstractTableModel {

    private final List<Categoria> categorias;

    public CategoriaTableModel() {
        categorias = new ArrayList<>();
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    /**
     *
     * @param categoria
     * @return
     */
    public boolean addRow(Categoria categoria) {
        if (categorias.contains(categoria)) {
            return false;
        }
        boolean isAdded = categorias.add(categoria);
        fireTableDataChanged();
        return isAdded;
    }

    /**
     *
     * @param id
     * @param nome
     * @return
     */
    public boolean addRow(Integer id, String nome) {
        return addRow(new Categoria(id, nome));
    }

    /**
     *
     * @param rowData
     * @return
     */
    public boolean addRow(Object[] rowData) {
        return addRow(new Categoria((Integer) rowData[0], (String) rowData[1]));
    }

    public boolean removeAll() {
        boolean isRemoved = categorias.removeAll(categorias);
        fireTableDataChanged();
        return isRemoved;
    }

    /**
     *
     * @param categoria
     * @return
     */
    public boolean removeRow(Categoria categoria) {
        boolean isRemoved = categorias.remove(categoria);
        fireTableDataChanged();
        return isRemoved;
    }

    /**
     *
     * @param id
     * @param nome
     * @return
     */
    public boolean removeRow(Integer id, String nome) {
        return removeRow(new Categoria(id, nome));
    }

    /**
     *
     * @param rowData
     * @return
     */
    public boolean removeRow(Object[] rowData) {
        return removeRow(new Categoria((Integer) rowData[0], (String) rowData[1]));
    }

    /**
     *
     * @param rowIndex
     * @return
     */
    public Object[] getRow(int rowIndex) {
        if (categorias.isEmpty()) {
            return null;
        } else {
            Categoria categoria = categorias.get(rowIndex);
            Object[] objects = {categoria.getId(), categoria.getNome()};
            return objects;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (!categorias.isEmpty()) {
            Categoria categoria = categorias.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return categoria.getId();
                case 1:
                    return categoria.getNome();
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
        }
        return "";
    }

    @Override
    public int getRowCount() {
        return categorias.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

}
