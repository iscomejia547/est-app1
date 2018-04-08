/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import beans.Student;
import model.EstModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jf_me
 */
public class ShowFrame extends javax.swing.JInternalFrame {
    private EstModel mod;
    private final Object[] header={"ID", "Nombres", "Apellidos", "Edad", "Carné", "Carrera","Departamento", "Ciudad"};

    /**
     * Creates new form ShowFrame
     */
    public ShowFrame() {
        initComponents();
    }

    public void setMod(EstModel mod) {
        this.mod = mod;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        searchtxt = new javax.swing.JTextField();
        optcmb = new javax.swing.JComboBox<>();
        okbtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Busqueda");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Buscar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        jPanel1.add(jLabel1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 300;
        gridBagConstraints.insets = new java.awt.Insets(0, 55, 0, 0);
        jPanel1.add(searchtxt, gridBagConstraints);

        optcmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "ID", "Nombre", "Apellido", "Carnet", "Edad", "Carrera", "Ciudad" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 30);
        jPanel1.add(optcmb, gridBagConstraints);

        okbtn.setText("OK");
        okbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okbtnActionPerformed(evt);
            }
        });
        jPanel1.add(okbtn, new java.awt.GridBagConstraints());

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        setBounds(0, 0, 900, 480);
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        try {
            List<Student> studentList=mod.getAll();
            showTable(studentList);
        } catch (IOException | IllegalArgumentException e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_formInternalFrameOpened

    private void okbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okbtnActionPerformed
        int opt=optcmb.getSelectedIndex();
        if(opt==0){
            JOptionPane.showMessageDialog(this, "Seleccione una opcion válida", "", JOptionPane.WARNING_MESSAGE);
        }
        try {
            switch(opt){
                case 1:{
                    Student find=mod.byId(Integer.parseInt(searchtxt.getText()));
                    if(find==null){
                        JOptionPane.showMessageDialog(this, "No se ha encontrado a MCQueen :'v", "",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    List<Student> founds=new ArrayList<>();
                    founds.add(find);
                    showTable(founds);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_okbtnActionPerformed

    private Object[][] toMatrix(List<Student> l){
        Object[][] table=new Object[l.size()][l.get(0).toArray().length];
        int i=0;
        for (Student s:
             l) {
            table[i]=s.toArray();
            i++;
        }
        return table;
    }
    private void showTable(List<Student> st){
        DefaultTableModel tmod= (DefaultTableModel) jTable1.getModel();
        tmod.setRowCount(0);
        tmod.setDataVector(toMatrix(st), header);
        jTable1.setModel(tmod);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(150);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(150);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(150);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(150);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(150);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(200);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton okbtn;
    private javax.swing.JComboBox<String> optcmb;
    private javax.swing.JTextField searchtxt;
    // End of variables declaration//GEN-END:variables
}
