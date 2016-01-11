package gui;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultCaret;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sperez
 */
public class Ventana extends javax.swing.JFrame {

     public boolean terminado;
    public Integer consecutivo_bar;
    public Integer maximo;

    /**
     * Creates new form Principal
     */
    public Ventana() {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        initComponents();

        setLocationRelativeTo(null);

        setAlwaysOnTop(true);

        this.maximizado = true;

        resize();
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
        jProgressBar1 = new javax.swing.JProgressBar();
        btn_detalles = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Replicación");
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setPreferredSize(new java.awt.Dimension(550, 130));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 40, 510, -1));

        btn_detalles.setText("Ver detalles");
        btn_detalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_detallesActionPerformed(evt);
            }
        });
        jPanel1.add(btn_detalles, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 65, 129, -1));

        jLabel1.setText("Replicando...");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 13, 529, 21));

        jButton1.setText("Cerrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 65, -1, -1));

        jTextPane1.setFocusable(false);
        jScrollPane2.setViewportView(jTextPane1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 530, 180));

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

     public void setMaxBar(Integer max) {

        consecutivo_bar = 0;
        maximo = max;
        this.jProgressBar1.setMaximum(maximo);
    }
     
      public void avanzar() {

        consecutivo_bar += 1;
        this.jProgressBar1.setValue(consecutivo_bar);
        System.out.println(consecutivo_bar);
    }
    
    public void setBar(Integer porcentaje) {

        this.jProgressBar1.setValue(porcentaje);

    }

    public void setText(String texto) {

        jLabel1.setText(texto);
    }

    public void addLog(String texto, boolean error) {

        StyleContext sc;
        AttributeSet aset = null;
        sc = StyleContext.getDefaultStyleContext();
        if (error) {

            aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.RED);
            //aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Background, Color.yellow);           

        } else {

            aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.BLACK);
            //aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Background, Color.WHITE);            
        }

        aset = sc.addAttribute(aset, StyleConstants.FontSize, 9);
        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Calibri");//"Lucida Console");
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);

        jTextPane1.setCharacterAttributes(aset, false);
        jTextPane1.replaceSelection(texto);

        //    this.jTextPane1.append(texto);
        int indice_ultima_linea = jTextPane1.getDocument().getLength(); //retorna el numero de lineas
        jTextPane1.setCaretPosition(indice_ultima_linea); //ubica el cursor al final
    }

    private void btn_detallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_detallesActionPerformed

        resize();
    }//GEN-LAST:event_btn_detallesActionPerformed

    public void resize() {
        if (maximizado) {

            btn_detalles.setText("Ver Detalles");
            this.setSize(550, 100);
        } else {

            btn_detalles.setText("Ocultar Detalles");
            this.setSize(550, 300);
        }

        maximizado = !maximizado;
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (!terminado) {

            int opcion;

            opcion = JOptionPane.showConfirmDialog(this, "Al no completar la replicación se pueden producir inconsistencia en la información\n\n"
                    + "¿Desea Terminar la replicación?", "FeddLot Replicator", JOptionPane.YES_NO_OPTION);

            if (opcion == 0) {

                System.exit(0);
            }
        } else {

            System.exit(0);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /*
     public static void main(String args[]) {
   
     try {
     for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
     if ("Windows".equals(info.getName())) {
     javax.swing.UIManager.setLookAndFeel(info.getClassName());
     break;
     }
     }
     } catch (ClassNotFoundException ex) {
     java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
     } catch (InstantiationException ex) {
     java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
     } catch (IllegalAccessException ex) {
     java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
     } catch (javax.swing.UnsupportedLookAndFeelException ex) {
     java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
     }
     //</editor-fold>

   
     java.awt.EventQueue.invokeLater(new Runnable() {
     public void run() {
     new Principal().setVisible(true);
     }
     });
     }
     */
    private boolean maximizado = true;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_detalles;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
