/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.test;

import javax.swing.JOptionPane;

/**
 *
 * @author jf_me
 */
public class Radiodlg extends java.awt.Dialog {

    /**
     * Creates new form Radiodlg
     */
    public Radiodlg(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        opt1 = new javax.swing.JRadioButton();
        otp2 = new javax.swing.JRadioButton();
        opt3 = new javax.swing.JRadioButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        btn.setText("ok");
        btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt);
            }
        });
        jPanel1.add(btn);

        add(jPanel1, java.awt.BorderLayout.SOUTH);

        buttonGroup1.add(opt1);
        opt1.setText("A");
        jPanel2.add(opt1);

        buttonGroup1.add(otp2);
        otp2.setText("B");
        jPanel2.add(otp2);

        buttonGroup1.add(opt3);
        opt3.setText("C");
        jPanel2.add(opt3);

        add(jPanel2, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(416, 139));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActionPerformed
        if(buttonGroup1.isSelected(opt1.getModel())){
            JOptionPane.showMessageDialog(jPanel1, "Seleccionado A", "", 1);
        }else{
            JOptionPane.showMessageDialog(this, "none selected", "", JOptionPane.NO_OPTION);
        }
    }//GEN-LAST:event_btnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Radiodlg dialog = new Radiodlg(new java.awt.Frame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton opt1;
    private javax.swing.JRadioButton opt3;
    private javax.swing.JRadioButton otp2;
    // End of variables declaration//GEN-END:variables

}
