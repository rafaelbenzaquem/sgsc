/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafaelbenz.sgsc.ui.desktop.usuario;

import com.rafaelbenz.sgsc.controller.rest.UsuarioController;
import com.rafaelbenz.sgsc.modelo.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafael Benzaquem Neto
 */
public class UsuarioControleFrame extends javax.swing.JInternalFrame implements UsuarioControleFrameListener {

    private UsuarioTableModel usuarioTableModel = new UsuarioTableModel();
    private UsuarioController usuarioController = new UsuarioController();
    private NovoUsuarioFrame novoUsuarioFrame = new NovoUsuarioFrame();

    public UsuarioControleFrame() {
        initComponents();
        atualizarTabelaCliente();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableUsuario = new javax.swing.JTable();
        jButtonAdicionar = new javax.swing.JButton();
        jButtonVisualizar = new javax.swing.JButton();
        jButtonAtualizar = new javax.swing.JButton();
        jButtonDeletar = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(546, 444));

        jPanel1.setBackground(new java.awt.Color(236, 251, 251));

        jPanel2.setBackground(new java.awt.Color(236, 251, 251));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Controle Usuário"));

        jTableUsuario.setModel(usuarioTableModel);
        jScrollPane1.setViewportView(jTableUsuario);

        jButtonAdicionar.setText("Adicionar");
        jButtonAdicionar.setToolTipText("");
        jButtonAdicionar.setPreferredSize(new java.awt.Dimension(75, 20));
        jButtonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarActionPerformed(evt);
            }
        });

        jButtonVisualizar.setText("Visualizar");
        jButtonVisualizar.setEnabled(false);
        jButtonVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVisualizarActionPerformed(evt);
            }
        });

        jButtonAtualizar.setText("Atualizar");
        jButtonAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizarActionPerformed(evt);
            }
        });

        jButtonDeletar.setText("Deletar");
        jButtonDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeletarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jButtonVisualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jButtonAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jButtonDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonVisualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarActionPerformed
        novoUsuarioFrame = new NovoUsuarioFrame();
        novoUsuarioFrame.setUsuarioFrameListener(this);
        novoUsuarioFrame.setVisible(true);
        novoUsuarioFrame.setClosable(true);
        novoUsuarioFrame.setResizable(false);
        novoUsuarioFrame.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        this.getDesktopPane().add(novoUsuarioFrame, 0);
        this.getDesktopPane().repaint();
    }//GEN-LAST:event_jButtonAdicionarActionPerformed

    private void jButtonVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVisualizarActionPerformed

    }//GEN-LAST:event_jButtonVisualizarActionPerformed

    private void jButtonAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtualizarActionPerformed

    }//GEN-LAST:event_jButtonAtualizarActionPerformed

    private void jButtonDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeletarActionPerformed
        int option = JOptionPane.showConfirmDialog(this, "Você realmente deseja deletar este usuário?", "Deletar Usuário", JOptionPane.YES_NO_OPTION);
        if (option == 0) {
            int indexRow = jTableUsuario.getSelectedRow();
            Object[] objects = usuarioTableModel.getRow(indexRow);
            boolean isDeleted = false;
            if (usuarioTableModel.getRowCount() > 1) {
                isDeleted = usuarioController.deletar((Serializable) objects[0]);
            }
            if (isDeleted) {
                atualizarTabelaCliente();
                JOptionPane.showMessageDialog(this, "O usuário foi deletado com sucesso.", "Deletar Usuário", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Não foi possível deletar esse usuário.", "Deletar Cliente", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButtonDeletarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonAtualizar;
    private javax.swing.JButton jButtonDeletar;
    private javax.swing.JButton jButtonVisualizar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableUsuario;
    // End of variables declaration//GEN-END:variables
//private void atualizarTabelaCliente() {
//        usuarioTableModel.removeAll();
//        List<Usuario> usuarios = usuarioController.listar();
//        usuarios.forEach((cliente) -> {
//            usuarioTableModel.addRow(cliente);
//        });
//    }

    @Override
    public void atualizarUsuarioControleFrame() {
        atualizarTabelaCliente();
    }

    private void atualizarTabelaCliente() {
        usuarioTableModel.removeAll();
        List<Usuario> clientes = usuarioController.listar();
        clientes.forEach((cliente) -> {
            usuarioTableModel.addRow(cliente);
        });
    }

}
