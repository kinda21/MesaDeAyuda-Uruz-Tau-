package Main.ConfigurarCaso;
import Main.ABMTipoCaso.*;
import Main.DTOTipoCaso;
import Main.ABMSector.*;
import java.util.*;
import Entidades.*;
import Main.DTOSector;
import Main.DTOTipoInstancia;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.*;
import java.lang.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
/**
 *
 * @author FLIA HUDSON
 */
public class SeleccionTipoCaso extends javax.swing.JFrame {
    ControladorConfigurar controladorConfig = new ControladorConfigurar();
    List<DTOTipoCaso> listatipocasos;
    String nomfilTipoCaso;
    javax.swing.table.DefaultTableModel miTabla=new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código Tipo Caso", "Nombre Tipo Caso", "N° Máxima Iteración", "Fecha Fin Vigencia"
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
     * Creates new form SeleccionTipoCaso
     */
    private  List<DTOTipoCaso> ordenaTipoCaso(List<DTOTipoCaso> listadtotc)
    {
        List<DTOTipoCaso> ordenado,aux;
        ordenado=new ArrayList<DTOTipoCaso>();
        aux= new ArrayList<DTOTipoCaso>();
        for (int i=0; i< listadtotc.size();i++)
        {
            aux.add(listadtotc.get(i));
        }
        for (int i=0; i< listadtotc.size();i++)
        {
            int ultCod=0;
            DTOTipoCaso saux=null;
            for(int j=0;j<aux.size();j++)
            {
                if(ultCod ==0)
                {
                    ultCod=aux.get(j).getCodTipoCaso();
                    saux=aux.get(j);
                }
                if (ultCod >aux.get(j).getCodTipoCaso() )
                {
                    ultCod=aux.get(j).getCodTipoCaso();
                    saux=aux.get(j);
                }
            }
            ordenado.add(saux);
            aux.remove(saux);
        }
         return ordenado; 
    }
    public void setVisible(boolean b) {
        if (b==true) {
            listatipocasos = controladorConfig.buscarTipoCasosVigentes(nomTCTextField.getText(),"");
            poblarTabla(listatipocasos);
        }    
        super.setVisible(b);
    }     
    public void poblarTabla (List<DTOTipoCaso> plistadtotc){
        miTabla.setRowCount(0);
        List<DTOTipoCaso> listadtotiposcaso=ordenaTipoCaso(plistadtotc);
        for (int j=0;j<listadtotiposcaso.size();j++)
        {
            DTOTipoCaso unTipoCaso = listadtotiposcaso.get(j);         
            miTabla.addRow(new Object[]{unTipoCaso.getCodTipoCaso(),unTipoCaso.getNombreTipoCaso(),unTipoCaso.getNumeroMaximaIteracion(),unTipoCaso.getFechaFinVigenciaTipoCaso()});
        } 
    //    TablaSectores.setAutoCreateRowSorter(true);
        TablaTipoCasos.setModel(miTabla);
    }
    public SeleccionTipoCaso() {
        initComponents();
        nomTCTextField.setText(null);
        
       
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nomTCTextField = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaTipoCasos = new javax.swing.JTable();
        BackButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Seleccionar Tipo Caso");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nomTCTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomTCTextFieldActionPerformed(evt);
            }
        });
        nomTCTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nomTCTextFieldKeyReleased(evt);
            }
        });
        getContentPane().add(nomTCTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 260, -1));

        TablaTipoCasos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código Tipo Caso", "Nombre Tipo Caso", "N° Máxima Iteración", "Fin Vigencia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TablaTipoCasos.setRowHeight(20);
        TablaTipoCasos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(TablaTipoCasos);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 480, 200));

        BackButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BackButton.setText("Volver");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });
        getContentPane().add(BackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, -1, 60));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Nombre Tipo Caso:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        jButton2.setText("Seleccionar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_BackButtonActionPerformed

    private void nomTCTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomTCTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomTCTextFieldActionPerformed

    private void nomTCTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomTCTextFieldKeyReleased
        nomfilTipoCaso=nomTCTextField.getText();
        List<DTOTipoCaso> listatipocasos = controladorConfig.buscarTipoCasosVigentes(nomfilTipoCaso,"");  
        poblarTabla(listatipocasos);   
    }//GEN-LAST:event_nomTCTextFieldKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Integer a;
        try  {
              a= (Integer) TablaTipoCasos.getModel().getValueAt(TablaTipoCasos.getSelectedRow(), 0);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(this, "Seleccione un Tipo Caso", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String cod=a.toString();
       controladorConfig.abrirABM(cod,this);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(SeleccionTipoCaso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SeleccionTipoCaso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SeleccionTipoCaso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SeleccionTipoCaso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SeleccionTipoCaso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JTable TablaTipoCasos;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField nomTCTextField;
    // End of variables declaration//GEN-END:variables
}