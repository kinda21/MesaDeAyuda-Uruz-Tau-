package Main.ConfigurarCaso;


import Main.DTOConfiguracionTipoCaso;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author FLIA HUDSON
 */
public class ABMConfigurar extends javax.swing.JFrame {
    ControladorConfigurar contconfig;
    SeleccionTipoCaso seleccion;
    String parcodTC;
    List<DTOConfiguracionTipoCaso> listaconfiguraciones;
    javax.swing.table.DefaultTableModel miTabla=new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°Config", "Nombre Tipo Caso", "Fecha Inicio Vigencia", "FechaFinVigencia", "Fecha Verificacion"
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
     * Creates new form ABMConfigurar
     */
    public void setVisible(boolean b) {
        if (b==true) {
            List<DTOConfiguracionTipoCaso> listaconfiguraciones = contconfig.buscarConfiguraciones(parcodTC);
            poblarTabla(listaconfiguraciones);
            super.setVisible(b);
        }
    }
    public void poblarTabla(List<DTOConfiguracionTipoCaso> listaconfiguraciones) {
        miTabla.setRowCount(0);
        List<DTOConfiguracionTipoCaso> listaconfiguracionesordenadas = ordenaConfiguraciones(listaconfiguraciones);
        for (int i=0;i<listaconfiguracionesordenadas.size();i++)
            {
                DTOConfiguracionTipoCaso unaConfiguracion = listaconfiguracionesordenadas.get(i);
                miTabla.addRow(new Object[]{unaConfiguracion.getNroConfigTC() ,unaConfiguracion.getNombreTC(),unaConfiguracion.getFechaInicioVigencia(),unaConfiguracion.getFechaFinVigencia(),unaConfiguracion.getFechaVerificacion()});
                TablaConfiguraciones.setModel(miTabla);
            }
    }
    private  List<DTOConfiguracionTipoCaso> ordenaConfiguraciones(List<DTOConfiguracionTipoCaso> listaconfiguraciones)
    {
        List<DTOConfiguracionTipoCaso> ordenado,aux;
        ordenado=new ArrayList<DTOConfiguracionTipoCaso>();
        aux= new ArrayList<DTOConfiguracionTipoCaso>();
        for (int i=0; i< listaconfiguraciones.size();i++)
        {
            aux.add(listaconfiguraciones.get(i));
        }
        for (int i=0; i< listaconfiguraciones.size();i++)
        {
            int ultCod=0;
            DTOConfiguracionTipoCaso saux=null;
            for(int j=0;j<aux.size();j++)
            {
                if(ultCod ==0)
                {
                    ultCod=aux.get(j).getNroConfigTC();
                    saux=aux.get(j);
                }
                if (ultCod >aux.get(j).getNroConfigTC())
                {
                    ultCod=aux.get(j).getNroConfigTC();
                    saux=aux.get(j);
                }
            }
            ordenado.add(saux);
            aux.remove(saux);
        }
         return ordenado; 
    }
    public void inicializaABM (ControladorConfigurar cont, String codigoTC, SeleccionTipoCaso select) {
       contconfig = cont;
       seleccion = select;
       parcodTC = codigoTC;
       listaconfiguraciones = new ArrayList<>();
        
    }
    public ABMConfigurar() {
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

        jFrame1 = new javax.swing.JFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaConfiguraciones = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ABM Configuracion");

        TablaConfiguraciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "N°Config", "Nombre Tipo Caso", "Fecha Inicio Vigencia", "FechaFinVigencia", "Fecha Verificacion"
            }
        ));
        jScrollPane1.setViewportView(TablaConfiguraciones);

        jButton1.setText("Alta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Modificar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Baja");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Verificar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        backButton.setText("Volver");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        contconfig.abrirAlta(this,parcodTC, seleccion);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         Integer a;
        try  {
              a= (Integer) TablaConfiguraciones.getModel().getValueAt(TablaConfiguraciones.getSelectedRow(), 0);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(this, "Seleccione una configuración", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
       String nroconf=a.toString();
       contconfig.abrirModificar(this,parcodTC,nroconf, seleccion);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       Integer a;
        try  {
              a= (Integer) TablaConfiguraciones.getModel().getValueAt(TablaConfiguraciones.getSelectedRow(), 0);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(this, "Seleccione una configuración", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
       String nroconf=a.toString();
       contconfig.abrirBaja(this,parcodTC,nroconf, seleccion);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Integer a;
        try  {
              a= (Integer) TablaConfiguraciones.getModel().getValueAt(TablaConfiguraciones.getSelectedRow(), 0);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(this, "Seleccione una configuración", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
       String nroconf=a.toString();
       contconfig.verificarConfiguracion(parcodTC,nroconf);
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(ABMConfigurar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ABMConfigurar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ABMConfigurar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ABMConfigurar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ABMConfigurar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaConfiguraciones;
    private javax.swing.JButton backButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}