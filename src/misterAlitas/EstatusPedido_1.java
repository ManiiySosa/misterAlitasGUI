/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misterAlitas;

import entitys.Cliente;
import entitys.Pedido;
import java.awt.Dimension;
import java.awt.Graphics;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class EstatusPedido_1 extends javax.swing.JFrame {

    public class Imagen extends javax.swing.JPanel {

        public Imagen() {
            this.setSize(500, 400);

        }

        public void paint(Graphics grafico) {
            Dimension height = getSize();
            ImageIcon img = new ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"));
            grafico.drawImage(img.getImage(), 0, 0, height.width, height.height, null);
            setOpaque(false);
            super.paintComponent(grafico);
        }

    }
    
    public EstatusPedido_1() {
        initComponents();
        setTitle("Cambiar Estatus Pedido");
        setLocationRelativeTo(null);
        setResizable(false);
        
        //Pone el fondo en el panel
        Imagen Imagen = new Imagen();
        jPanel1.add(Imagen);
        jPanel1.repaint();
        String sq = "select * from pedido"+";";
        tabla(sq);
        
    }
    
    public void tabla(String sq) {
        
        String data[][] = {};
        String[] col = {"ID Pedido", "Fecha del Pedido", "Total", "Estatus", "ID Cliente"};
        mod = new DefaultTableModel(data, col);
        tablita.setModel(mod);
        
        try {
            Conectar con = new Conectar();
            Connection cn = (Connection) con.conexion();
            Statement st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sq);
            ResultSetMetaData rsm = (ResultSetMetaData) rs.getMetaData();
            int c = rsm.getColumnCount();
            while (rs.next()) {
                Object[] fila = new Object[c];
                for (int y = 0; y < c; y++) {
                    fila[y] = rs.getObject(y + 1);
                }
                mod.addRow(fila);
                
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Este registro no existe", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private DefaultTableModel mod = new DefaultTableModel();
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popup = new javax.swing.JPopupMenu();
        estatus = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        campoBusqueda = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        botonBuscar = new javax.swing.JButton();
        botonregresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablita = new javax.swing.JTable();
        comboOpciones = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        botonMostrar = new javax.swing.JButton();

        estatus.setText("Cambiar Estatus");
        estatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estatusActionPerformed(evt);
            }
        });
        popup.add(estatus);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cambiar Estatus de Pedidos");

        campoBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoBusquedaActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ingresa el Número de telefono del Cliente o la Fecha (YYYY-MM-DD)");

        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        botonregresar.setText("Regresar");
        botonregresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonregresarActionPerformed(evt);
            }
        });

        tablita.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Pedido", "Fecha Pedido", "Total", "Estatus", "ID Cliente"
            }
        ));
        tablita.setComponentPopupMenu(popup);
        jScrollPane1.setViewportView(tablita);

        comboOpciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "Usuario", "Fecha" }));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ingresa el Tipo de Búsqueda:");

        botonMostrar.setText("Mostrar Todo");
        botonMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMostrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(campoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(botonregresar))
                                    .addComponent(jLabel3))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(comboOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonMostrar)
                                .addGap(34, 34, 34))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonMostrar))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botonBuscar)
                        .addComponent(botonregresar))
                    .addComponent(campoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

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

    private void campoBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoBusquedaActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        if (comboOpciones.getSelectedItem() == "Usuario") {
            String usuario = campoBusqueda.getText();
            String sq = "select * from pedido where idCliente='" + usuario + "';";
            tabla(sq);
            int filas = tablita.getRowCount();
            if (filas == 0) {
                JOptionPane.showMessageDialog(null, "Este registro no existe", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if (comboOpciones.getSelectedItem() == "Fecha") {
            String fecha = campoBusqueda.getText();
            
            //Date now = new Date(fecha);
            //SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            //SimpleDateFormat hour = new SimpleDateFormat("HH:mm:ss");
            // System.out.println("La fecha es: "+date.format(now)+" "+"La hora es: "+hour.format(now)); 
            
            String sq = "select * from pedido where fechapedido='" + fecha + "';";
            tabla(sq);
            int filas = tablita.getRowCount();
            if (filas == 0) {
                JOptionPane.showMessageDialog(null, "Este registro no existe", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
            
        }
        if (comboOpciones.getSelectedItem() == "Selecciona") {
            JOptionPane.showMessageDialog(null, "Elija una opción de búsqueda", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void estatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estatusActionPerformed
        String[] botones = {" Entregado", " Cancelado", "En Proceso"};
        String ids = JOptionPane.showInputDialog("Ingresa el ID del pedido");
        int id = Integer.parseInt(ids);
        int respuesta = JOptionPane.showOptionDialog(null, " ¿Qué estatus deseas?", "Cambiar Estatus", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null/*icono*/, botones, botones[0]);
        
        if (respuesta == 0) {
            String est = "Entregado";
            Pedido pe = new Pedido();
            pe.setIdpedido(id);
            pe.setEstatusPedido(est);
            editarPedido(pe);
            String usuario = campoBusqueda.getText();
           String sq = "select * from pedido"+";";
            tabla(sq);
        }
        if (respuesta == 1) {
            String est = "Cancelado";
            Pedido pe = new Pedido();
            pe.setIdpedido(id);
            pe.setEstatusPedido(est);
            editarPedido(pe);
            String usuario = campoBusqueda.getText();
            String sq = "select * from pedido"+";";
            tabla(sq);
        }
        if (respuesta == 2) {
            String est = "En Proceso";
            Pedido pe = new Pedido();
            pe.setIdpedido(id);
            pe.setEstatusPedido(est);
            editarPedido(pe);
            String usuario = campoBusqueda.getText();
            String sq = "select * from pedido"+";";
            tabla(sq);
        }
        
    }//GEN-LAST:event_estatusActionPerformed

    private void botonregresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonregresarActionPerformed
        dispose();
        new MenuPrincipalAdministrador().setVisible(true);
    }//GEN-LAST:event_botonregresarActionPerformed

    private void botonMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMostrarActionPerformed
        String sq = "select * from pedido"+";";
        tabla(sq);
    }//GEN-LAST:event_botonMostrarActionPerformed

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
            java.util.logging.Logger.getLogger(EstatusPedido_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EstatusPedido_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EstatusPedido_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EstatusPedido_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EstatusPedido_1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonMostrar;
    private javax.swing.JButton botonregresar;
    private javax.swing.JTextField campoBusqueda;
    private javax.swing.JComboBox<String> comboOpciones;
    private javax.swing.JMenuItem estatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu popup;
    private javax.swing.JTable tablita;
    // End of variables declaration//GEN-END:variables

//Método para editar un elemento
    public void editarPedido(Pedido pedidoOriginal) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        try {
            
            Pedido pedidoAux = em.find(Pedido.class, pedidoOriginal.getIdpedido());
            if (pedidoAux != null) {
                em.getTransaction().begin();
                pedidoAux.setEstatusPedido(pedidoOriginal.getEstatusPedido());
                
                em.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Edición realizada con éxito ;D", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el usuario", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            new MenuPrincipal().setVisible(true);
            
        } finally {
            em.close();
        }
        
    }
    
}
