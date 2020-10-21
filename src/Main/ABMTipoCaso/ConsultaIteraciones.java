package Main.ABMTipoCaso;

import Main.ABMTipoTarea.*;
import Main.ABMTipoInstancia.ControladorABMTipoInstancia;
import Main.DTOTipoCaso;
import Main.DTOTipoCasoIteracion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FLIA HUDSON
 */
public class ConsultaIteraciones extends javax.swing.JFrame {
    ControladorTipoCaso controladorABMtc;
    DTOTipoCaso tipocaso;
    javax.swing.table.DefaultTableModel miTabla=new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°Iteración","Coeficiente de Reducción"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
    /**
     * Creates new form ConsultaTareas
     */
    public ConsultaIteraciones() {
        initComponents();
    }
    public void inicializaconsulta(ControladorTipoCaso cont,DTOTipoCaso undto){
       controladorABMtc=cont;
       tipocaso = undto;
       codTCTextField.setText((Integer.toString(undto.getCodTipoCaso())));
       nomTCTextField.setText(undto.getNombreTipoCaso());
       maxIteracionesTextField.setText(Integer.toString(undto.getNumeroMaximaIteracion()));
       List <DTOTipoCasoIteracion> listaiteraciones = ordenaDTOTipoTarea(undto.getListaTipoCasoIteracion());
         for (int i=0;i<listaiteraciones.size();i++)
        {
            DTOTipoCasoIteracion untipotarea = listaiteraciones.get(i);
            miTabla.addRow(new Object[]{untipotarea.getNumeroDeIteracion(),untipotarea.getCoeficienteReduccionTipo()});
            TablaIteraciones.setModel(miTabla);
        }
    }
     private  List<DTOTipoCasoIteracion> ordenaDTOTipoTarea(List<DTOTipoCasoIteracion> listadtoiteraciones)
    {
        List<DTOTipoCasoIteracion> ordenado,aux;
        ordenado=new ArrayList<DTOTipoCasoIteracion>();
        aux= new ArrayList<DTOTipoCasoIteracion>();
        for (int i=0; i< listadtoiteraciones.size();i++)
        {
            aux.add(listadtoiteraciones.get(i));
        }
        for (int i=0; i< listadtoiteraciones.size();i++)
        {
            int ultCod=0;
            DTOTipoCasoIteracion saux=null;
            for(int j=0;j<aux.size();j++)
            {
                if(ultCod ==0)
                {
                    ultCod=aux.get(j).getNumeroDeIteracion();
                    saux=aux.get(j);
                }
                if (ultCod >aux.get(j).getNumeroDeIteracion())
                {
                    ultCod=aux.get(j).getNumeroDeIteracion();
                    saux=aux.get(j);
                }
            }
            ordenado.add(saux);
            aux.remove(saux);
        }
         return ordenado; 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        codTCTextField = new javax.swing.JTextField();
        nomTCTextField = new javax.swing.JTextField();
        maxIteracionesTextField = new javax.swing.JTextField();
        backButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaIteraciones = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Información Tipo Caso");

        jLabel1.setText("Código Tipo Caso:");

        jLabel2.setText("Nombre Tipo Caso:");

        jLabel3.setText("Cantidad máxima de iteraciones:");

        codTCTextField.setEditable(false);
        codTCTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codTCTextFieldActionPerformed(evt);
            }
        });

        nomTCTextField.setEditable(false);
        nomTCTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomTCTextFieldActionPerformed(evt);
            }
        });

        maxIteracionesTextField.setEditable(false);
        maxIteracionesTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxIteracionesTextFieldActionPerformed(evt);
            }
        });

        backButton.setText("Volver");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        TablaIteraciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "N° de Iteración", "Coeficiente de Reducción"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TablaIteraciones.setRowHeight(20);
        jScrollPane3.setViewportView(TablaIteraciones);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomTCTextField)
                    .addComponent(maxIteracionesTextField)
                    .addComponent(codTCTextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backButton)
                .addContainerGap())
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(codTCTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nomTCTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(maxIteracionesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void codTCTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codTCTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codTCTextFieldActionPerformed

    private void nomTCTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomTCTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomTCTextFieldActionPerformed

    private void maxIteracionesTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxIteracionesTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maxIteracionesTextFieldActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
       setVisible(false);
       dispose(); 
    }//GEN-LAST:event_backButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultaIteraciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaIteraciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaIteraciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaIteraciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaIteraciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaIteraciones;
    private javax.swing.JButton backButton;
    private javax.swing.JTextField codTCTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField maxIteracionesTextField;
    private javax.swing.JTextField nomTCTextField;
    // End of variables declaration//GEN-END:variables
}