/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelbenz.sgsc.ui.desktop.contrato;

import com.rafaelbenz.sgsc.modelo.ItemContrato;
import com.rafaelbenz.sgsc.ui.desktop.servico.*;
import com.rafaelbenz.sgsc.modelo.Servico;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rafael Benzaquem Neto
 */
public class ItemContratoTableModel extends AbstractTableModel {

    private final List<ItemContrato> itens;

    public ItemContratoTableModel() {
        itens = new ArrayList<>();
    }

    public List<ItemContrato> getClientes() {
        return itens;
    }

    /**
     *
     * @param itemContrato
     * @return
     */
    public boolean addRow(ItemContrato itemContrato) {
        if (itens.contains(itemContrato)) {
            return false;
        }
        boolean isAdded = itens.add(itemContrato);
        fireTableDataChanged();
        return isAdded;
    }

    /**
     *
     * @param id
     * @param nome
     * @param preco
     * @param quantidade
     * @return
     */
    public boolean addRow(Integer id, String nome, double preco, int quantidade) {
        return addRow(new ItemContrato(null, new Servico(id, nome, preco), null, quantidade, null));
    }

    /**
     *
     * @param rowData
     * @return
     */
    public boolean addRow(Object[] rowData) {
        return addRow(new ItemContrato(null, new Servico((Integer) rowData[0], (String) rowData[1], (double) rowData[2]), null, (Integer) rowData[3], null));
    }

    public boolean removeAll() {
        boolean isRemoved = itens.removeAll(itens);
        fireTableDataChanged();
        return isRemoved;
    }

    /**
     *
     * @param itemContrato
     * @return
     */
    public boolean removeRow(ItemContrato itemContrato) {
        boolean isRemoved = itens.remove(itemContrato);
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
    public boolean removeRow(Integer id, String nome, double preco, int quantidade) {
        return removeRow(new ItemContrato(null, new Servico(id, nome, preco), null, quantidade, null));
    }

    /**
     *
     * @param rowData
     * @return
     */
    public boolean removeRow(Object[] rowData) {
        return removeRow(new ItemContrato(null, new Servico((Integer) rowData[0], (String) rowData[1], (double) rowData[2]), null, (Integer) rowData[3], null));
    }

    /**
     *
     * @param rowIndex
     * @return
     */
    public Object[] getRow(int rowIndex) {
        if (itens.isEmpty()) {
            return null;
        } else {
            ItemContrato itemContrato = itens.get(rowIndex);
            Object[] objects = {itemContrato.getServico().getId(), itemContrato.getServico().getNome(), itemContrato.getServico().getPreco(), itemContrato.getQuantidade()};
            return objects;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (!itens.isEmpty()) {
            ItemContrato itemContrato = itens.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return itemContrato.getServico().getId();
                case 1:
                    return itemContrato.getServico().getNome();
                case 2:
                    return itemContrato.getServico().getPreco();
                case 3:
                    return itemContrato.getQuantidade();
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
            case 3:
                return "Quantidade";
        }
        return "";
    }

    @Override
    public int getRowCount() {
        return itens.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

}
