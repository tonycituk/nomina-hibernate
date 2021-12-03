/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.lemur.nomina.MVC.View;

import com.lemur.nomina.MVC.Controller.AdministradorController;
import com.lemur.nomina.MVC.Model.Administrador;
import com.lemur.nomina.MVC.View.Util.InputValidator;
import javax.swing.JOptionPane;

/**
 *
 * @author tonyc
 */
public class AdminCreate extends javax.swing.JFrame {

    InputValidator iv;
    private AdministradorController admnCntrllr;
    private javax.swing.JFrame parent;
    private Administrador administradorEnDiscordia;

    /**
     * Creates new form AdminCreate
     */
    public AdminCreate(javax.swing.JFrame parent, Administrador administrador) {
        this.administradorEnDiscordia = administrador;
        this.parent = parent;
        this.parent.setEnabled(false);
        admnCntrllr = new AdministradorController();
        iv = new InputValidator();
        initComponents();
        jTextField_adminNombre.setText(administrador.getNombre());
        jTextField_adminNumHorasTrabajadas.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton_guardar = new javax.swing.JButton();
        jLabel_adminNombre = new javax.swing.JLabel();
        jTextField_adminNombre = new javax.swing.JTextField();
        jLabel_adminNumHorasTrabajadas = new javax.swing.JLabel();
        jTextField_adminNumHorasTrabajadas = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nomina: Crear Administrador");

        jButton_guardar.setText("guardar");
        jButton_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_guardarActionPerformed(evt);
            }
        });

        jLabel_adminNombre.setText("nombre");

        jTextField_adminNombre.setText("jTextField1");

        jLabel_adminNumHorasTrabajadas.setText("horas trabajadas");

        jTextField_adminNumHorasTrabajadas.setText("jTextField1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel_adminNumHorasTrabajadas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_adminNumHorasTrabajadas, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel_adminNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_adminNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton_guardar)
                .addGap(63, 63, 63))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_adminNombre)
                            .addComponent(jTextField_adminNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_adminNumHorasTrabajadas)
                            .addComponent(jTextField_adminNumHorasTrabajadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jButton_guardar)))
                .addContainerGap(178, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_guardarActionPerformed
        // TODO add your handling code here:
        boolean validName = iv.isValidNoSQL(jTextField_adminNombre.getText());
        boolean validNumHorasTrabajadas = iv.isValidNumeric(jTextField_adminNumHorasTrabajadas.getText());
        if (!validName) {
            JOptionPane.showMessageDialog(this, "El nombre no es válido.", "Alerta", 0);
            jTextField_adminNombre.setText("");
        } else {
            if (!validNumHorasTrabajadas) {
                JOptionPane.showMessageDialog(this, "El número de horas trabajadas ingresadas no es válido.", "Alerta", 0);
                jTextField_adminNumHorasTrabajadas.setText("");
            } else {
                Administrador administrador = new Administrador(0, jTextField_adminNombre.getText(), Double.parseDouble(jTextField_adminNumHorasTrabajadas.getText()), 0);
                admnCntrllr.addAdmin(administrador);
                JOptionPane.showMessageDialog(this, "Se ha agregado 1 registro.", "Info", 1);
                jTextField_adminNombre.setText("");
                jTextField_adminNumHorasTrabajadas.setText("");
                this.setVisible(false);
                parent.setEnabled(true);

            }
        }
    }//GEN-LAST:event_jButton_guardarActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminCreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminCreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminCreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminCreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminCreate(null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_guardar;
    private javax.swing.JLabel jLabel_adminNombre;
    private javax.swing.JLabel jLabel_adminNumHorasTrabajadas;
    private javax.swing.JTextField jTextField_adminNombre;
    private javax.swing.JTextField jTextField_adminNumHorasTrabajadas;
    // End of variables declaration//GEN-END:variables
}