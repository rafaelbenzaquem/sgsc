/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelbenz.sgsc.ui.desktop.contrato;

import com.rafaelbenz.sgsc.modelo.Cliente;
import com.rafaelbenz.sgsc.modelo.Contrato;
import com.rafaelbenz.sgsc.modelo.Pagamento;
import com.rafaelbenz.sgsc.modelo.PagamentoComBoleto;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rafael Benzaquem Neto
 */
public class ContratoTableModel extends AbstractTableModel {

    private final List<Contrato> contratos;

    public ContratoTableModel() {
        contratos = new ArrayList<>();
    }

    public List<Contrato> getClientes() {
        return contratos;
    }

    /**
     *
     * @param contrato
     * @return
     */
    public boolean addRow(Contrato contrato) {
        if (contratos.contains(contrato)) {
            return false;
        }
        boolean isAdded = contratos.add(contrato);
        fireTableDataChanged();
        return isAdded;
    }

    /**
     *
     * @param id
     * @param date
     * @param pagamento
     * @param cliente
     * @return
     */
    public boolean addRow(Integer id, Long date, Pagamento pagamento, Cliente cliente) {
        return addRow(new Contrato(id, date, pagamento, cliente));
    }

    /**
     *
     * @param rowData
     * @return
     */
    public boolean addRow(Object[] rowData) {
        return addRow(new Contrato((Integer) rowData[0], (Long) rowData[1], (Pagamento) rowData[2], (Cliente) rowData[3]));
    }

    public boolean removeAll() {
        boolean isRemoved = contratos.removeAll(contratos);
        fireTableDataChanged();
        return isRemoved;
    }

    /**
     *
     * @param contrato
     * @return
     */
    public boolean removeRow(Contrato contrato) {
        boolean isRemoved = contratos.remove(contrato);
        fireTableDataChanged();
        return isRemoved;
    }

    /**
     *
     * @param id
     * @param date
     * @param pagamento
     * @param cliente
     * @return
     */
    public boolean removeRow(Integer id, Long date, Pagamento pagamento, Cliente cliente) {
        return removeRow(new Contrato(id, date, pagamento, cliente));
    }

    /**
     *
     * @param rowData
     * @return
     */
    public boolean removeRow(Object[] rowData) {
        return removeRow(new Contrato((Integer) rowData[0], (Long) rowData[1], (Pagamento) rowData[2], (Cliente) rowData[3]));
    }

    /**
     *
     * @param rowIndex
     * @return
     */
    public Object[] getRow(int rowIndex) {
        if (contratos.isEmpty()) {
            return null;
        } else {
            Contrato contrato = contratos.get(rowIndex);
            Object[] objects = {contrato.getId(), contrato.getInstante(), contrato.getPagamento(), contrato.getCliente()};
            return objects;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String pattern = "dd/MM/yyyy HH:mm";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        if (!contratos.isEmpty()) {
            Contrato contrato = contratos.get(rowIndex);
            if (contrato.getPagamento() instanceof PagamentoComBoleto) {

            } else {

            }

            switch (columnIndex) {
                case 0:
                    return contrato.getId();
                case 1:
                    Date d = new Date(contrato.getInstante());
                    return simpleDateFormat.format(d);
                case 2:
                    return contrato.getPagamento().getEstado();
                case 3:
                    return contrato.getCliente().getTipo().getDescricao();
                case 4:
                    return contrato.getCliente().getNome();
                case 5:
                    return "R$:" + contrato.getValorTotal().doubleValue();
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
                return "Data";
            case 2:
                return "Pagamento";
            case 3:
                return "Tipo Cliente";
            case 4:
                return "Nome Cliente";
            case 5:
                return "Valor";
        }
        return "";
    }

    @Override
    public int getRowCount() {
        return contratos.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

}
