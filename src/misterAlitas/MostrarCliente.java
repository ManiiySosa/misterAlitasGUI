
package misterAlitas;

import entitys.Cliente;
import java.awt.Dimension;
import java.awt.Graphics;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class MostrarCliente extends javax.swing.JFrame {

    public class Imagen extends javax.swing.JPanel {

        public Imagen() {
            this.setSize(800, 600);

        }

        public void paint(Graphics grafico) {
            Dimension height = getSize();
            ImageIcon img = new ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"));
            grafico.drawImage(img.getImage(), 0, 0, height.width, height.height, null);
            setOpaque(false);
            super.paintComponent(grafico);
        }

    }

    public MostrarCliente() {
        initComponents();
        setTitle("Buscar Usuario");
        setLocationRelativeTo(null);
        setResizable(false);
        //Pone el fondo en el panel
        Imagen Imagen = new Imagen();
        jPanel1.add(Imagen);
        jPanel1.repaint();
        String sq = "select * from Cliente"+";";
        tabla(sq);
    }

    boolean bandera = false;

    public void tabla(String sq) {

        String data[][] = {};
        String[] col = {"Teléfono", "Nombre", "Apellido", "E-Mail", "Dirección", "Código Postal", "Ciudad"};
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        campoBusqueda = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablita = new javax.swing.JTable();
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buscar Usuario");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Escribe el nombre o la dirección del cliente que deseas buscar:");

        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        botonCancelar.setText("Regresar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        tablita.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Telefono", "Nombre", "Apellidos", "E-Mail", "Dirección", "Código Postal", "Ciudad"
            }
        ));
        tablita.setComponentPopupMenu(popup);
        jScrollPane1.setViewportView(tablita);

        comboOpciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "Nombre", "Dirección" }));
        comboOpciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboOpcionesActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Selecciona el tipo de búsqueda");

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(286, 286, 286)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(campoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(comboOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonMostrar)
                                .addGap(56, 56, 56)))))
                .addGap(32, 32, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(campoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonMostrar)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonBuscar)
                            .addComponent(botonCancelar))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        dispose();
        new MenuPrincipalAdministrador().setVisible(true);
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        String opcion = (String) comboOpciones.getSelectedItem();
        if(opcion == "Nombre"){
   
        String nombre = campoBusqueda.getText();
        String sq = "select * from cliente where nombre='" + nombre + "';";
        tabla(sq);
        int filas =tablita.getRowCount();
        if(filas ==0){
            JOptionPane.showMessageDialog(null, "Este registro no existe", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }if(opcion == "Dirección"){
    String direccion = campoBusqueda.getText();
        String sq = "select * from cliente where direccion='" + direccion + "';";
        tabla(sq);
        int filas =tablita.getRowCount();
        if(filas ==0){
            JOptionPane.showMessageDialog(null, "Este registro no existe", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    
    }if(opcion == "Selecciona"){
        JOptionPane.showMessageDialog(null, "Elija una opción de búsqueda", "Error", JOptionPane.INFORMATION_MESSAGE);
    }
        
    }

    {
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void comboOpcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboOpcionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboOpcionesActionPerformed

    private void botonMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMostrarActionPerformed
        String sq = "select * from Cliente"+";";
        tabla(sq);
    }//GEN-LAST:event_botonMostrarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        int ax = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas eliminar tu cuenta?");
        if(ax==JOptionPane.YES_OPTION){
       int index = tablita.getSelectedRow();//Digo que tabla es sacandola de la seleccion
        TableModel modelito =tablita.getModel();
        String elemento = modelito.getValueAt(index, 0).toString();//aqui eligo el elemento
        
        boolean bandera= eliminar(elemento,Cliente.class);
        if(bandera){
        JOptionPane.showMessageDialog(null,"Usuario eliminado con éxito","Validacion",JOptionPane.INFORMATION_MESSAGE);
        String sq = "select * from Cliente"+";";
        tabla(sq);
        }else{
        JOptionPane.showMessageDialog(null,"Error al eliminar Usuario","Validacion",JOptionPane.ERROR_MESSAGE);
        }
        dispose();
        }
    }//GEN-LAST:event_eliminarActionPerformed

    
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
            java.util.logging.Logger.getLogger(MostrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MostrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MostrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MostrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MostrarCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonMostrar;
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

public boolean eliminar(String idEliminar, Class generico){
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
        new MenuPrincipalAdministrador().setVisible(true);
        
    }finally{
    em.close();
    return estado;
    }
    
    
    
    }

}
