
package misterAlitas;

import entitys.Producto;
import java.awt.Dimension;
import java.awt.Graphics;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ConsultarProductos extends javax.swing.JFrame implements Comunica{

    public class Imagen extends javax.swing.JPanel {

        public Imagen() {
            this.setSize(800, 800);

        }

        public void paint(Graphics grafico) {
            Dimension height = getSize();
            ImageIcon img = new ImageIcon(getClass().getResource("/Imagenes/fondoVentana.jpg"));
            grafico.drawImage(img.getImage(), 0, 0, height.width, height.height, null);
            setOpaque(false);
            super.paintComponent(grafico);
        }

    }

    public ConsultarProductos() {
        initComponents();
        setTitle("Consultar Productos");
        setLocationRelativeTo(null);
        setResizable(false);

        //Pone el fondo en el panel
        Imagen Imagen = new Imagen();
        jPanel1.add(Imagen);
        jPanel1.repaint();
        String sq = "select * from producto"+";";
        tabla(sq);
        //List<Producto> productos = getAllElementos("SELECT e FROM Pedido e");
        //imprimeElementos(productos);

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
EditarProductos vep = new EditarProductos(this);
    String nompro="";
        String cod="";
        String des="";
        String pre="";
        String res="";
        String cant="";
        String idp="";
        boolean bandera=true;
    
    public void llenarCamposProducto(int elemento){
        
        
        String num = String.valueOf(elemento);
        
        String sql = "SELECT * FROM producto WHERE idproducto='"+num+"'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            
           
            while(rs.next()){
                idp=rs.getString("idproducto");
                nompro=rs.getString("nombreProducto");
                cod=rs.getString("codigo");
                des=rs.getString("descripcion");
                pre=rs.getString("precio");
                res=rs.getString("restricciones");
                cant=rs.getString("cantidad");
                
                
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        popup = new javax.swing.JPopupMenu();
        Editar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        comboOpciones = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        campobusqueda = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        botonRegresar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablita = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        Editar.setText("Editar");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });
        popup.add(Editar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Consultar y Editar Productos");

        comboOpciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "Código", "Nombre" }));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Selecciona el tipo de búsqueda");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Escribe el nombre o el código del producto que deseas buscar");

        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        botonRegresar.setText("Regresar");
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });

        tablita.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Producto", "Nombre", "Código", "Descripción", "Precio", "Restricciones", "Cantidad"
            }
        ));
        tablita.setComponentPopupMenu(popup);
        jScrollPane2.setViewportView(tablita);

        jButton1.setText("Mostrar Todo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(campobusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(33, 33, 33)
                        .addComponent(botonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(116, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(281, 281, 281))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(168, 168, 168))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(139, 139, 139))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(comboOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campobusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonRegresar)
                            .addComponent(botonBuscar))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
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

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        if (comboOpciones.getSelectedItem() == "Nombre") {
            String nombre = campobusqueda.getText();
            String sq = "select * from producto where nombreProducto='" + nombre + "';";
            tabla(sq);
            int filas = tablita.getRowCount();
            if (filas == 0) {
                JOptionPane.showMessageDialog(null, "Este registro no existe", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if (comboOpciones.getSelectedItem() == "Código") {
            String codigo = campobusqueda.getText();
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

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        dispose();
        new MenuPrincipalAdministrador().setVisible(true);
    }//GEN-LAST:event_botonRegresarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String sq = "select * from producto"+";";
        tabla(sq);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
        int index = tablita.getSelectedRow();//Digo que tabla es sacandola de la seleccion
        TableModel modelito =tablita.getModel();
        int elemento = Integer.parseInt(modelito.getValueAt(index, 0).toString());//aqui eligo el elemento
         llenarCamposProducto(elemento);
        
        if(bandera==true && !"".equals(nompro)){
        //Controla la ventana en el método
        vep.setVisible(true);
        vep.pack();
        vep.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        vep.setLocationRelativeTo(null);
        
        //Pone en cada campo de texto los elementos seleccionados
        vep.campoId.setText(idp);
        vep.campoNombre.setText(nompro);
        vep.campoCodigo.setText(cod);
        vep.campoDescripcion.setText(des);
        vep.campoPrecio.setText(pre);
        vep.campoRestricciones.setSelectedItem(res);
        vep.campoCantidad.setText(cant);
        }
        
       
    }//GEN-LAST:event_EditarActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Editar;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JTextField campobusqueda;
    private javax.swing.JComboBox<String> comboOpciones;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JPopupMenu popup;
    private javax.swing.JTable tablita;
    // End of variables declaration//GEN-END:variables
    Conectar cc = new Conectar();
    Connection cn= cc.conexion();
    
    
    public List getAllElementos(String consulta) {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery(consulta);
        return query.getResultList();

    }

    public void imprimeElementos(List<Producto> lista) {

        DefaultTableModel modelo = (DefaultTableModel) tablita.getModel();
        modelo.setRowCount(0);
        Object[] fila = new Object[modelo.getColumnCount()];
        System.out.println(lista.size());
        for (int i = 0; i < lista.size(); i++) {
            fila[0] = lista.get(i).getIdproducto();
            fila[1] = lista.get(i).getNombreProducto();
            //fila[2] = lista.get(i).getCodigo();
            //fila[3] = lista.get(i).getDescripcion();
            //fila[4] = lista.get(i).getPrecio();
            //fila[6] = lista.get(i).getRestricciones();
            //fila[7] = lista.get(i).getCantidad();
            modelo.addRow(fila);
        }

    }

}
