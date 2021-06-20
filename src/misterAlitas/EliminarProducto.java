/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misterAlitas;

import entitys.Producto;
import java.awt.Dimension;
import java.awt.Graphics;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class EliminarProducto extends javax.swing.JFrame {

   public class Imagen extends javax.swing.JPanel{
    
        public Imagen(){
            this.setSize(800,800);
      
        }
        
        public void paint (Graphics grafico){
            Dimension height = getSize();
            ImageIcon img = new ImageIcon(getClass().getResource("/Imagenes/fondoVentana.jpg"));
            grafico.drawImage(img.getImage(), 0, 0, height.width, height.height, null);
            setOpaque(false);
            super.paintComponent(grafico);
        }
    
    }
    
    public EliminarProducto() {
        initComponents();
        setTitle("Eliminar Producto");
        setLocationRelativeTo(null);
        setResizable(false);
        
        //Pone el fondo en el panel
        Imagen Imagen = new Imagen();
        jPanel1.add(Imagen);
        jPanel1.repaint();
        String sq = "select * from producto"+";";
        tabla(sq);
    }

    public void tabla(String sq) {

        String data[][] = {};
        String[] col = {"ID Producto", "Nombre", "Código", "Descripción", "Precio", "Restricciones", "Cantidad"};
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
        eliminar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablita = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        botonregresar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        campoBusqueda = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        comboOpciones = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        botonMostrar = new javax.swing.JButton();

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        popup.add(eliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablita.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Producto", "Nombre", "Código", "Descripción", "Precio", "Restricciones", "Cantidad"
            }
        ));
        tablita.setComponentPopupMenu(popup);
        tablita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablitaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablitaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablita);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Eliminar Productos");

        botonregresar.setText("Regresar");
        botonregresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonregresarActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Clic derecho sobre el que quieras eliminar:");

        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        comboOpciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "Nombre", "Código" }));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Selecciona una opción de búsqueda");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(botonregresar)
                            .addGap(13, 13, 13))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(campoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(45, 45, 45)
                            .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonMostrar)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(comboOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(144, 144, 144)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(4, 4, 4)
                .addComponent(comboOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscar)
                    .addComponent(botonMostrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonregresar)
                .addContainerGap(51, Short.MAX_VALUE))
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

    private void tablitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablitaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablitaMouseClicked

    private void tablitaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablitaMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tablitaMousePressed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        int eleccion = JOptionPane.showConfirmDialog(null,"¿Seguro que deseas eliminar este producto?","Confirmar Eliminación",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(eleccion ==JOptionPane.YES_OPTION){
        //Toma el elemento que deseo de la tabla
        int index = tablita.getSelectedRow();//Digo que tabla es sacandola de la seleccion
        TableModel modelito =tablita.getModel();
        int elemento = Integer.parseInt(modelito.getValueAt(index, 0).toString());//aqui eligo el elemento
        //JOptionPane.showMessageDialog(null, elemento);
        
        //el caso para eliminar
        boolean bandera= eliminar(elemento,Producto.class);
        if(bandera){
        JOptionPane.showMessageDialog(null, "Elemento Eliminado con éxito");
        
            String sq = "select * from producto"+";";
            tabla(sq);
             
             
        }
        else
        JOptionPane.showMessageDialog(null, "El elemento no pudo ser eliminado");
        }else{}
    }//GEN-LAST:event_eliminarActionPerformed

    private void botonregresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonregresarActionPerformed
        dispose();
        new MenuPrincipalAdministrador().setVisible(true);
    }//GEN-LAST:event_botonregresarActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
       if (comboOpciones.getSelectedItem() == "Nombre") {
            String nombre = campoBusqueda.getText();
            String sq = "select * from producto where nombreProducto='" + nombre + "';";
            tabla(sq);
            int filas = tablita.getRowCount();
            if (filas == 0) {
                JOptionPane.showMessageDialog(null, "Este registro no existe", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if (comboOpciones.getSelectedItem() == "Código") {
            String codigo = campoBusqueda.getText();
            String sq = "select * from producto where codigo='" + codigo + "';";
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

    private void botonMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMostrarActionPerformed
        String sq = "select * from producto"+";";
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
            java.util.logging.Logger.getLogger(EliminarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EliminarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EliminarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EliminarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EliminarProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonMostrar;
    private javax.swing.JButton botonregresar;
    private javax.swing.JTextField campoBusqueda;
    private javax.swing.JComboBox<String> comboOpciones;
    private javax.swing.JMenuItem eliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu popup;
    private javax.swing.JTable tablita;
    // End of variables declaration//GEN-END:variables

public boolean eliminar(int idEliminar, Class generico){
    boolean estado=false;
    EntityManagerFactory emf = 
    Persistence.createEntityManagerFactory("default");
    EntityManager em = emf.createEntityManager();
    
    try{
    
        Object aux =em.find(generico, idEliminar);
         em.getTransaction().begin();
         em.remove(aux);
         em.getTransaction().commit();
         estado=true;
         
    
    
    }catch(Exception e){
        e.printStackTrace();
        estado=false;
        em.getTransaction().rollback();
        
    }finally{
    em.close();
   
    return estado;
    
    }
    
    
    
    }
}
