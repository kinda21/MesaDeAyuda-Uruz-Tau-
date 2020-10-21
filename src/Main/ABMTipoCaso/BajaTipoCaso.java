package Main.ABMTipoCaso;

import Main.DTOTipoCaso;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author FLIA HUDSON
 */
public class BajaTipoCaso extends javax.swing.JFrame {
    ControladorTipoCaso controladorABMTC;
    ABMTipoCaso abm;
    String parCodTipoCaso;
    int codTipoCaso;
    /**
     * Creates new form BajaSector
     */
    public BajaTipoCaso() {
        initComponents();
    }
    
    public void inicializaBaja(ControladorTipoCaso cont, ABMTipoCaso abmtc, int cod)
   {
       controladorABMTC=cont;
       abm=abmtc;
       parCodTipoCaso=Integer.toString(cod);
       List<DTOTipoCaso> listadto = controladorABMTC.buscarTipoCasos("",parCodTipoCaso);
       codTipoCasoTextField.setText(parCodTipoCaso);
       nomActualTipoCaso.setText(listadto.get(0).getNombreTipoCaso());
       numMaxIteraciones.setText(Integer.toString(listadto.get(0).getNumeroMaximaIteracion())); 
   }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bajaButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        label1 = new java.awt.Label();
        codTipoCasoTextField = new javax.swing.JTextField();
        label4 = new java.awt.Label();
        nomActualTipoCaso = new javax.swing.JTextField();
        label5 = new java.awt.Label();
        numMaxIteraciones = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Baja Tipo Caso");

        bajaButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bajaButton.setText("Confirmar Baja de Tipo Caso");
        bajaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bajaButtonActionPerformed(evt);
            }
        });

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        label1.setText("Codigo del Tipo Caso:");

        codTipoCasoTextField.setEditable(false);
        codTipoCasoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codTipoCasoTextFieldActionPerformed(evt);
            }
        });

        label4.setText("Nombre actual del Tipo Caso:");

        nomActualTipoCaso.setEditable(false);
        nomActualTipoCaso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomActualTipoCasoActionPerformed(evt);
            }
        });

        label5.setText("N° Máximo de Iteraciones:");

        numMaxIteraciones.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bajaButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(label5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(codTipoCasoTextField)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nomActualTipoCaso, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                                    .addComponent(numMaxIteraciones))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codTipoCasoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomActualTipoCaso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numMaxIteraciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bajaButton)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bajaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bajaButtonActionPerformed
        //Intento obtener codSector
        try  {
            codTipoCaso = Integer.parseInt(codTipoCasoTextField.getText());
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(this, "Error al ingresar codSector", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Boolean exito;
        exito = controladorABMTC.darbajaTipoCaso(codTipoCaso);
        if (exito == true) {
        setVisible(false);
        dispose();
        abm.setVisible(true);
        }
    }//GEN-LAST:event_bajaButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
        dispose();  
    }//GEN-LAST:event_jButton1ActionPerformed

    private void codTipoCasoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codTipoCasoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codTipoCasoTextFieldActionPerformed

    private void nomActualTipoCasoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomActualTipoCasoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomActualTipoCasoActionPerformed

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
            java.util.logging.Logger.getLogger(BajaTipoCaso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BajaTipoCaso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BajaTipoCaso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BajaTipoCaso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BajaTipoCaso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bajaButton;
    private javax.swing.JTextField codTipoCasoTextField;
    private javax.swing.JButton jButton1;
    private java.awt.Label label1;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private javax.swing.JTextField nomActualTipoCaso;
    private javax.swing.JTextField numMaxIteraciones;
    // End of variables declaration//GEN-END:variables
}