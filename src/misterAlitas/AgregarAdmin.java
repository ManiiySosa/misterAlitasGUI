/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misterAlitas;

import entitys.Usuario;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class AgregarAdmin extends javax.swing.JFrame {

    boolean bandera = false;

    public class Imagen extends javax.swing.JPanel {

        public Imagen() {
            this.setSize(400, 500);

        }

        public void paint(Graphics grafico) {
            Dimension height = getSize();
            ImageIcon img = new ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"));
            grafico.drawImage(img.getImage(), 0, 0, height.width, height.height, null);
            setOpaque(false);
            super.paintComponent(grafico);
        }

    }

    public AgregarAdmin() {
        //initComponents();
        setTitle("Registrar Administrador");
        setLocationRelativeTo(null);
        setResizable(false);
        //Pone el fondo en el panel
        Imagen Imagen = new Imagen();
        jPanel1.add(Imagen);
        jPanel1.repaint();
    }

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        dispose();
        new VentanaRegistro().setVisible(true);
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarseActionPerformed
        Usuario us = new Usuario();
        String usuario = this.campoUsuario.getText();
        String contraseña = this.campoContra.getText();

        if ((campoContra.getText()).equals((campoConfir.getText()))) {

            us.setNombreUsuario(usuario);
            us.setContraseña(contraseña);
            us.setTipousuario("administrador");
            guardarElemento(us);
        }
        
        if(bandera == true){
        JOptionPane.showMessageDialog(null, "Se ha registrado con éxito", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        dispose();
        new InicioSesion().setVisible(true);    
        }
        else{
        JOptionPane.showMessageDialog(null,"Favor de revisar la contraseña las escribió diferentes","Validacion",JOptionPane.ERROR_MESSAGE);
                
        }
    }//GEN-LAST:event_botonRegistrarseActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonRegistrarse;
    private javax.swing.JPasswordField campoConfir;
    private javax.swing.JPasswordField campoContra;
    private javax.swing.JTextField campoUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
public void guardarElemento(Object obj) {
        //Conexión entre la clase y la base de datos
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        try {

            em.persist(obj);//recibe el objeto
            em.getTransaction().commit();//Funcion de guardardo
            bandera = true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        //dispose();
    }

}
