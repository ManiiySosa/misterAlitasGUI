/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misterAlitas;

import java.awt.Dimension;
import java.awt.Graphics;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MenuPrincipal extends javax.swing.JFrame implements Comunica {

    public class Imagen extends javax.swing.JPanel{
    
        public Imagen(){
            this.setSize(699,530);
      
        }
        
        public void paint (Graphics grafico){
            Dimension height = getSize();
            ImageIcon img = new ImageIcon(getClass().getResource("/Imagenes/fondoAlitas.jpg"));
            grafico.drawImage(img.getImage(), 0, 0, height.width, height.height, null);
            setOpaque(false);
            super.paintComponent(grafico);
        }
    
    }
    
    boolean banderaClase=false;
    
    public MenuPrincipal() {
        //if(bandera==true){
        initComponents();
        setTitle("Menú Principal");
        setLocationRelativeTo(null);
        setResizable(false);
        
        //Pone el fondo en el panel
        Imagen Imagen = new Imagen();
        jPanel1.add(Imagen);
        jPanel1.repaint();
       // }
        
    }

    EditarCliente ve = new EditarCliente(this,banderaClase);
    
    boolean bandera=true;
    
        String nom="";
        String ape="";
        String tel="";
        String email="";
        String dir="";
        String cp="";
        String ciud="";
        
    public void llenarCampos(){
        
        
        String num = JOptionPane.showInputDialog("Ingresa tu número de Teléfono");
        
        String sql = "SELECT * FROM cliente WHERE telefono='"+num+"'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            
           
            while(rs.next()){
                nom=rs.getString("nombre");
                ape=rs.getString("apellidos");
                tel=rs.getString("telefono");
                email=rs.getString("email");
                dir=rs.getString("direccion");
                cp=rs.getString("codigoPostal");
                ciud=rs.getString("ciudad");
                
            }
                       
            bandera=true;
            
            
            } catch (SQLException ex) {
                bandera=false;
            Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        botonPedido = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        editarUsuario = new javax.swing.JMenuItem();
        eliminarUsaurio = new javax.swing.JMenuItem();
        menuCerrarSesion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Menú Principal");

        botonPedido.setText("Realizar Pedido");
        botonPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(botonPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(164, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(108, 108, 108)
                .addComponent(botonPedido)
                .addContainerGap(166, Short.MAX_VALUE))
        );

        jMenu1.setText("Menú");

        jMenu3.setText("Usuario");

        editarUsuario.setText("Editar Usuario");
        editarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarUsuarioActionPerformed(evt);
            }
        });
        jMenu3.add(editarUsuario);

        eliminarUsaurio.setText("Eliminar Usuario");
        eliminarUsaurio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarUsaurioActionPerformed(evt);
            }
        });
        jMenu3.add(eliminarUsaurio);

        jMenu1.add(jMenu3);

        menuCerrarSesion.setText("Cerrar Sesión");
        menuCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCerrarSesionActionPerformed(evt);
            }
        });
        jMenu1.add(menuCerrarSesion);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarUsuarioActionPerformed
        
        llenarCampos();
        
        if(bandera==true && !"".equals(nom)){
        //Controla la ventana en el método
        ve.setVisible(true);
        ve.pack();
        ve.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ve.setLocationRelativeTo(null);
        
        //Pone en cada campo de texto los elementos seleccionados
        ve.campoNombre.setText(nom);
        ve.campoApellido.setText(ape);
        ve.campoTelefono.setText(tel);
        ve.campoCorreo.setText(email);
        ve.campoDireccion.setText(dir);
        ve.campoCp.setText(cp);
        ve.campoCiudad.setText(ciud);
        
        
        
        
        dispose();
        
        }
        
    }//GEN-LAST:event_editarUsuarioActionPerformed

    private void eliminarUsaurioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarUsaurioActionPerformed
        dispose();
        new EliminarCliente().setVisible(true);
    }//GEN-LAST:event_eliminarUsaurioActionPerformed

    private void menuCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCerrarSesionActionPerformed
        dispose();
        new InicioSesion().setVisible(true);
    }//GEN-LAST:event_menuCerrarSesionActionPerformed

    private void botonPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPedidoActionPerformed
        dispose();
        new RealizarPedidos().setVisible(true);
    }//GEN-LAST:event_botonPedidoActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonPedido;
    private javax.swing.JMenuItem editarUsuario;
    private javax.swing.JMenuItem eliminarUsaurio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem menuCerrarSesion;
    // End of variables declaration//GEN-END:variables
    
    Conectar cc = new Conectar();
    Connection cn= cc.conexion();

}
