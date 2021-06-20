package misterAlitas;

import entitys.Cliente;
import entitys.Pedido;
import entitys.Producto;
import entitys.Productospedido;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class EditarPedidos extends javax.swing.JFrame {

    //Obtiene la fecha del sistema y le da el formato
    Date now = new Date(System.currentTimeMillis());
    // SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");

    int cantidad = 0;
    int contadorFila = 1;

    public class Imagen extends javax.swing.JPanel {

        public Imagen() {
            this.setSize(810, 430);

        }

        public void paint(Graphics grafico) {
            Dimension height = getSize();
            ImageIcon img = new ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"));
            grafico.drawImage(img.getImage(), 0, 0, height.width, height.height, null);
            setOpaque(false);
            super.paintComponent(grafico);
        }

    }

//Variables globales
    int cantidadtotal = 0;
    boolean bandera = false;
    HashMap<String, Producto> productos = new HashMap<>();
    Comunica miInterfazRemota;
    int contador = 0;

    public EditarPedidos(Comunica comunicacion) {
        initComponents();
        setTitle("Realizar Pedidos");
        setLocationRelativeTo(null);
        setResizable(false);
        miInterfazRemota = comunicacion;

        //Hacer invisibles los campos de texto
        campoNombreProducto.setVisible(false);
        campoelemento.setVisible(false);

        //Pone el fondo en el panel
        Imagen Imagen = new Imagen();
        jPanel1.add(Imagen);
        jPanel1.repaint();

        //Hace la conexión con la base de datoscon la consulta de productos lleno el combo box
        try {
            Conectar con = new Conectar();
            Connection cn = (Connection) con.conexion();
            Statement st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery("select * from producto");
            while (rs.next()) {
                Producto p = new Producto(rs.getInt("idproducto"), rs.getString("NombreProducto"), rs.getInt("Precio"));
                this.comboProductos.addItem(rs.getString("NombreProducto"));//Agrega al combo box los elementos
                productos.put(p.getNombreProducto(), p);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        //Ponerle un Action listener al combo;
        comboProductos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                campoNombreProducto.setText(comboProductos.getSelectedItem().toString()); //To change body of generated methods, choose Tools | Templates.

            }

        });

    }

    public void tablaEdicion(String sq) {

        String data[][] = {};
        String[] col = {"ID Producto Pedido", "ID Pedido", "ID Producto", "Cantidad"};
        mod = new DefaultTableModel(data, col);
        tablitaEdicion.setModel(mod);

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

    public void iniciaModelo() {
        mod = new DefaultTableModel();
        mod.addColumn("ID Producto Pedido");
        mod.addColumn("ID Pedido");
        mod.addColumn("Producto");
        mod.addColumn("Cantidad");

        tablitaEdicion.setModel(mod); //Automáticamente se refresca la tabla.

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        botonregresar = new javax.swing.JButton();
        botonGuardar = new javax.swing.JButton();
        comboProductos = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablitaEdicion = new javax.swing.JTable();
        campoNombreProducto = new javax.swing.JTextField();
        spinerCantidad = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        botonAgregar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        campoelemento = new javax.swing.JTextField();
        botonEliminarTemporales = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Editar Pedidos");

        botonregresar.setText("Regresar");
        botonregresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonregresarActionPerformed(evt);
            }
        });

        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        comboProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona" }));

        tablitaEdicion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Producto Pedido", "ID Pedido", "Producto", "Cantidad"
            }
        ));
        jScrollPane1.setViewportView(tablitaEdicion);

        spinerCantidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cantidad");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Seleccione el Producto:");

        botonAgregar.setText("Agregar");
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });

        botonEliminar.setText("Eliminar Registrados");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        botonEliminarTemporales.setText("Eliminar");
        botonEliminarTemporales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarTemporalesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(campoelemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(botonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonEliminarTemporales, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(comboProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(55, 55, 55)
                                        .addComponent(campoNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(spinerCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(jLabel2)))
                                .addGap(29, 29, 29)
                                .addComponent(botonEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonregresar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(317, 317, 317))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(campoelemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(192, 192, 192)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonregresar)
                            .addComponent(botonGuardar))
                        .addGap(191, 191, 191))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(botonEliminar)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(comboProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spinerCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(6, 6, 6)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonEliminarTemporales)
                            .addComponent(botonAgregar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(170, 170, 170))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonregresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonregresarActionPerformed
        dispose();

    }//GEN-LAST:event_botonregresarActionPerformed

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        if (contador == 0) {
            tablitaEdicion.removeAll();
            iniciaModelo();
        }
        if (comboProductos.getSelectedItem() != "Selecciona") {
            contador = 1;
            Producto productoSeleccionado = productos.get((String) comboProductos.getSelectedItem());

            DefaultTableModel modelo = (DefaultTableModel) tablitaEdicion.getModel();
            // modelo.setRowCount(0);

            //Agrega los datos de los productos en la tabla 
            Object[] fila = new Object[modelo.getColumnCount()];

            for (int i = 0; i < 1; i++) {
                fila[0] = "";//productoSeleccionado.getIdproducto();//campoIdProducto.getText();
                fila[1] = campoelemento.getText();
                fila[2] = productoSeleccionado.getNombreProducto();  //campoNombreProducto.getText();
                fila[3] = spinerCantidad.getValue();
                modelo.addRow(fila);
            }

            spinerCantidad.setValue(1);
            comboProductos.setSelectedItem("Selecciona");

        } else {
            JOptionPane.showMessageDialog(null, "Selecciona un producto de la lista"); //Excepcion si no se elige un elemento
        }


    }//GEN-LAST:event_botonAgregarActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed

        String idPed = campoelemento.getText();
        int id = Integer.parseInt(idPed);

        Pedido idp = new Pedido();
        idp.setIdpedido(id);

        //Crear la lista de productos:
        Productospedido pp = new Productospedido();
        Producto producto = new Producto();
        String idtabla = "";
        int enterito = 0;

        //For para recorrer la tabla
        for (int i = 0; i < tablitaEdicion.getRowCount(); i++) {

            pp.setIdpedido(idp); //Asignamos el id del pedido a la lista de productos
            //Obtener y asignar el ID del Producto

            Producto productoSeleccionado = productos.get(String.valueOf(tablitaEdicion.getValueAt(i, 2))); //Obtiene el id del hashmap

            enterito = productoSeleccionado.getIdproducto();//obtiene el id y lo asigna a la variable a utilizar
            producto.setIdproducto(enterito);//Toma de la tabla el id del producto y lo asigna al objeto producto
            //producto = (Producto) operaciones.getObjetoPorId((Integer) tablita.getValueAt(i, 0), Producto.class);
            pp.setIdproducto(producto);

            pp.setCantidad((Integer) tablitaEdicion.getValueAt(i, 3)); //Asignamos la cantidad de productos a la lista de pedidos
            guardarElemento(pp);

        }
        JOptionPane.showMessageDialog(null, "Se ha registrado el producto con éxito", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        String sq = "select * from productospedido where idpedido='" + idPed + "';";
        tablaEdicion(sq);


    }//GEN-LAST:event_botonGuardarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        int eleccion = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas eliminar este producto?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (eleccion == JOptionPane.YES_OPTION) {
            int index = tablitaEdicion.getSelectedRow();//Digo que tabla es sacandola de la seleccion
            DefaultTableModel modelo = (DefaultTableModel) tablitaEdicion.getModel();
            Object elementoaeliminar = modelo.getValueAt(index, 0);
            Object elementoactualizar = modelo.getValueAt(index, 1);
            int ea = (int) elementoactualizar;
            String ea2 = String.valueOf(ea);
            int eae = (int) elementoaeliminar;
            boolean banderas = eliminar(eae, Productospedido.class);
            //modelo.removeRow(index);

            if (banderas) {
                JOptionPane.showMessageDialog(null, "Producto Eliminado con éxito");
                String sq = "select * from productospedido where idpedido='" + ea2 + "';";
                tablaEdicion(sq);
            } else {
                JOptionPane.showMessageDialog(null, "El Producto no pudo ser eliminado");
            }
        } else {
        }
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonEliminarTemporalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarTemporalesActionPerformed
        int index = tablitaEdicion.getSelectedRow();//Digo que tabla es sacandola de la seleccion
        DefaultTableModel modelo = (DefaultTableModel) tablitaEdicion.getModel();

        modelo.removeRow(index);
    }//GEN-LAST:event_botonEliminarTemporalesActionPerformed

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
            java.util.logging.Logger.getLogger(EditarPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // new EditarPedidos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonEliminarTemporales;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonregresar;
    private javax.swing.JTextField campoNombreProducto;
    public javax.swing.JTextField campoelemento;
    private javax.swing.JComboBox<String> comboProductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spinerCantidad;
    public javax.swing.JTable tablitaEdicion;
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
            int entero = (int) em.getEntityManagerFactory().getPersistenceUnitUtil().getIdentifier(obj);

            bandera = true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        //dispose();
    }

    public boolean eliminar(int idEliminar, Class generico) {
        boolean estado = false;
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("RicaPizzaPU");
        EntityManager em = emf.createEntityManager();

        try {

            Object aux = em.find(generico, idEliminar);
            em.getTransaction().begin();
            em.remove(aux);
            em.getTransaction().commit();
            estado = true;

        } catch (Exception e) {
            e.printStackTrace();
            estado = false;
            em.getTransaction().rollback();

        } finally {
            em.close();

            return estado;

        }

    }

}
