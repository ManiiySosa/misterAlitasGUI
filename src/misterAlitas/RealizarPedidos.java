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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

public class RealizarPedidos extends javax.swing.JFrame {

    //Obtiene la fecha del sistema y le da el formato
    Date now = new Date(System.currentTimeMillis());
   // SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
       
    int cantidad = 0;
    int contadorFila = 1;

    public class Imagen extends javax.swing.JPanel {

        public Imagen() {
            this.setSize(710,430);

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
    HashMap<String,Producto>productos = new HashMap<>();

    public RealizarPedidos() {
        initComponents();
        setTitle("Realizar Pedidos");
        setLocationRelativeTo(null);
        setResizable(false);
        //Hacer invisibles los campos de texto
        campoNombreProducto.setVisible(false);
        
        
       
      
        //Alinear a la derehca el texto de campo total
        campoTotal.setHorizontalAlignment(campoTotal.RIGHT);

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
                Producto p = new Producto(rs.getInt("idproducto"), rs.getString("NombreProducto"),rs.getInt("Precio"));
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        botonregresar = new javax.swing.JButton();
        botonGuardar = new javax.swing.JButton();
        campoTotal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        campotelefono = new javax.swing.JTextField();
        comboProductos = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablita = new javax.swing.JTable();
        campoNombreProducto = new javax.swing.JTextField();
        spinerCantidad = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        botonAgregar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        botonEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Teléfono:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Pedido");

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

        campoTotal.setFont(new java.awt.Font("Tahoma", 0, 32)); // NOI18N
        campoTotal.setText("0");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Total:");

        campotelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campotelefonoKeyTyped(evt);
            }
        });

        comboProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona" }));

        tablita.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Producto", "Producto", "Cantidad", "Precio Unitario", "Precio Total"
            }
        ));
        jScrollPane1.setViewportView(tablita);

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

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("$");

        botonEliminar.setText("Eliminar");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(botonregresar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(campoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel7))))
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(30, 30, 30)
                                .addComponent(campotelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(comboProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(campoNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(jLabel1))
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spinerCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(botonEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(botonAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(383, 383, 383)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(campotelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinerCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(botonAgregar))
                        .addGap(4, 4, 4)
                        .addComponent(botonEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(170, 170, 170))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(campoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonregresar)
                            .addComponent(botonGuardar))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonregresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonregresarActionPerformed
        dispose();
        new MenuPrincipal().setVisible(true);
    }//GEN-LAST:event_botonregresarActionPerformed

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        if (comboProductos.getSelectedItem() != "Selecciona") {
           
            Producto productoSeleccionado = productos.get((String) comboProductos.getSelectedItem());
            
            int pruni = productoSeleccionado.getPrecio();//Toma el precio del producto
            int cant = (int) spinerCantidad.getValue();//Toma el valor del spiner
            int total = (pruni * cant);//operacion entre valor de espiner y precio
            
            
            DefaultTableModel modelo = (DefaultTableModel) tablita.getModel();
            // modelo.setRowCount(0);

            //Agrega los datos de los productos en la tabla 
            Object[] fila = new Object[modelo.getColumnCount()];

            for (int i = 0; i < 1; i++) {
                fila[0] = productoSeleccionado.getIdproducto();//campoIdProducto.getText();
                fila[1] = productoSeleccionado.getNombreProducto();  //campoNombreProducto.getText();
                fila[2] = spinerCantidad.getValue();
                fila[3] = productoSeleccionado.getPrecio();//campoPrecioUnitario.getText();
                fila[4] = total;
                modelo.addRow(fila);
            }

            //Hace el calculo del total a pagar
            cantidadtotal = cantidadtotal + total;
            campoTotal.setText(String.valueOf(cantidadtotal));
            
            spinerCantidad.setValue(1);
            comboProductos.setSelectedItem("Selecciona");

        } else {
            JOptionPane.showMessageDialog(null, "Selecciona un producto de la lista"); //Excepcion si no se elige un elemento
        }

        
        
    }//GEN-LAST:event_botonAgregarActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed

        int t = Integer.parseInt(campoTotal.getText());
        String estatus = "En Proceso";

        Cliente cl = new Cliente();
        cl.setTelefono(campotelefono.getText());

        Pedido pe = new Pedido();
        pe.setFechapedido(now);
        pe.setTotal(t);
        pe.setEstatusPedido(estatus);
        pe.setIdCliente(cl);

        guardarElemento(pe);

        //Resgistrar los productos del pedido
        //Obtener el id del pedido registrado.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("Select p from Pedido p");
        List<Pedido> misPedidos = query.getResultList();
        System.out.println("Elementos en la tabla:" + misPedidos.size());
        System.out.println("Ultimo identificador es:" + misPedidos.get(misPedidos.size() - 1).getIdpedido());
        int idPed = misPedidos.get(misPedidos.size() - 1).getIdpedido(); //asigna la id del pedido a idped

        Pedido idp = new Pedido();
        idp.setIdpedido(idPed);

        //Crear la lista de productos:
        Productospedido pp = new Productospedido();
        Producto producto = new Producto();
        String idtabla = "";
        int enterito = 0;
        //For para recorrer la tabla
        for (int i = 0; i < tablita.getRowCount(); i++) {

            pp.setIdpedido(idp); //Asignamos el id del pedido a la lista de productos
            idtabla = String.valueOf(tablita.getValueAt(i, 0));
            enterito = Integer.parseInt(idtabla);
            producto.setIdproducto(enterito);//Toma de la tabla el id del producto y lo asigna al onjeto producto
            //producto = (Producto) operaciones.getObjetoPorId((Integer) tablita.getValueAt(i, 0), Producto.class);
            pp.setIdproducto(producto);
            pp.setCantidad((Integer) tablita.getValueAt(i, 2)); //Asignamos la cantidad de productos a la lista de pedidos
            guardarElemento(pp);
        }

        JOptionPane.showMessageDialog(null, "Se ha registrado el pedido con éxito", "Aviso", JOptionPane.INFORMATION_MESSAGE);


    }//GEN-LAST:event_botonGuardarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        int index = tablita.getSelectedRow();//Digo que tabla es sacandola de la seleccion
        DefaultTableModel modelo = (DefaultTableModel) tablita.getModel();
        Object menoscantidad = modelo.getValueAt(index, 4);
        int en = (int) (menoscantidad);
        cantidadtotal = cantidadtotal - en;
        campoTotal.setText(String.valueOf(cantidadtotal));
        modelo.removeRow(index);


    }//GEN-LAST:event_botonEliminarActionPerformed

    private void campotelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campotelefonoKeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9') && (c != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Sólo se permiten números", "Validar número", JOptionPane.INFORMATION_MESSAGE);
        }
        String Caracteres = campotelefono.getText();
        if (Caracteres.length() >= 10) {
            evt.consume();

            getToolkit().beep();
        }
    }//GEN-LAST:event_campotelefonoKeyTyped

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
            java.util.logging.Logger.getLogger(RealizarPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RealizarPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RealizarPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RealizarPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RealizarPedidos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonregresar;
    private javax.swing.JTextField campoNombreProducto;
    private javax.swing.JTextField campoTotal;
    private javax.swing.JTextField campotelefono;
    private javax.swing.JComboBox<String> comboProductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spinerCantidad;
    private javax.swing.JTable tablita;
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
            System.out.println("Es el id del objeto:" + entero);

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
