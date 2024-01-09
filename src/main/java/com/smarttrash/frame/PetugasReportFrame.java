/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.smarttrash.frame;

/**
 *
 * @author allfiandi
 */

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import net.sf.jasperreports.engine.*;
import com.smarttrash.db.MySqlConnection;
import com.smarttrash.main.MainFrame;

public class PetugasReportFrame extends javax.swing.JFrame {

    /**
     * Creates new form PetugasReportFrame
     */
    public PetugasReportFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelMasyarakatReport = new javax.swing.JLabel();
        ButtonExportPetugas = new javax.swing.JButton();
        ButtonPrintPetugas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LabelMasyarakatReport.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        LabelMasyarakatReport.setText("Petugas Report");

        ButtonExportPetugas.setText("Export");
        ButtonExportPetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonExportPetugasActionPerformed(evt);
            }
        });

        ButtonPrintPetugas.setText("Print");
        ButtonPrintPetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonPrintPetugasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(LabelMasyarakatReport)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(ButtonExportPetugas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addComponent(ButtonPrintPetugas)
                .addGap(86, 86, 86))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(LabelMasyarakatReport)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonExportPetugas)
                    .addComponent(ButtonPrintPetugas))
                .addContainerGap(220, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonExportPetugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonExportPetugasActionPerformed
        // TODO add your handling code here:
        try {
            // reportPath digunakan untuk menyimpan path dari folder report
            String reportPath = System.getProperty("user.dir") + File.separator + "report";
            // atribut path digunakan untuk menyimpan path dari file PetugasReport.jrxml
            String path = System.getProperty("user.dir") + File.separator + "report" + File.separator + "PetugasReport.jrxml";
            // JasperReport digunakan untuk mengcompile file PetugasReport.jrxml
            JasperReport jasperReport = JasperCompileManager.compileReport(path);

            // map yang digunakan untuk menyimpan parameter yang akan digunakan pada file PetugasReport.jrxml
            Map<String, Object> parameters = new HashMap<>();

            // JasperPrint digunakan untuk mengisi file PetugasReport.jrxml dengan data dari database
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,
                MySqlConnection.getInstance().getConnection());

            // JasperPrintManager digunakan untuk mencetak file PetugasReport.jrxml
            JasperPrintManager.printReport(jasperPrint, true);
        }
        catch (JRException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_ButtonExportPetugasActionPerformed

    private void ButtonPrintPetugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonPrintPetugasActionPerformed
        // TODO add your handling code here:
        try {
            // reportPath digunakan untuk menyimpan path dari folder report
            String reportPath = System.getProperty("user.dir") + File.separator + "report";
            // atribut path digunakan untuk menyimpan path dari file PetugasReport.jrxml
            String path = System.getProperty("user.dir") + File.separator + "report" + File.separator + "PetugasReport.jrxml";
            // JasperReport digunakan untuk mengcompile file PetugasReport.jrxml
            JasperReport jasperReport = JasperCompileManager.compileReport(path);

            // map yang digunakan untuk menyimpan parameter yang akan digunakan pada file PetugasReport.jrxml
            Map<String, Object> parameters = new HashMap<>();

            // JasperPrint digunakan untuk mengisi file PetugasReport.jrxml dengan data dari database
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, MySqlConnection.getInstance().getConnection());

            // File outDir digunakan untuk menyimpan file PetugasReport.pdf
            File outDir = new File(System.getProperty("user.dir") + File.separator + "report");
            outDir.mkdirs();

            // JasperExportManager digunakan untuk mengekspor file PetugasReport.jrxml menjadi file PetugasReport.pdf
            JasperExportManager.exportReportToPdfFile(jasperPrint, reportPath + File.separator + "PetugasReport.pdf");
            // JOptionPane digunakan untuk menampilkan pesan bahwa export selesai
            JOptionPane.showMessageDialog(this, "Export Selesai!");
        }
        catch (JRException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_ButtonPrintPetugasActionPerformed

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
            java.util.logging.Logger.getLogger(PetugasReportFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PetugasReportFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PetugasReportFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PetugasReportFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PetugasReportFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonExportPetugas;
    private javax.swing.JButton ButtonPrintPetugas;
    private javax.swing.JLabel LabelMasyarakatReport;
    // End of variables declaration//GEN-END:variables
}
