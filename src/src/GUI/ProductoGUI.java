/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Controlador.ControladorProducto;
import Modelo.Producto;
import Modelo.ConexionBD;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author David Reyes
 */
public class ProductoGUI extends javax.swing.JFrame {
    //base de datos
    Connection con;
    ConexionBD mysqlcon;
    Statement st;
    ResultSet rs;
    int rsi;
    
    //Arreglos
    Object []datos_tabla;
    DefaultTableModel modelo;
    
    //controladores y elementos
    private Producto pro;
    private ControladorProducto con_pro;
    
    public ProductoGUI() {
        initComponents();
        
        con_pro = new ControladorProducto();
        
        //tabla
        datos_tabla = new Object[11];
        modelo = (DefaultTableModel) j_tabla1.getModel();
        
        //base de datos
        mysqlcon = new ConexionBD();
        con = mysqlcon.mySqlConnection();
        
        datosDefecto();
    }
    
    private void datosDefecto(){
        String query = "select * from producto";
        
        try{
            st = con.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                pro = new Producto();

                pro.setNombre(rs.getString("nombre"));
                pro.setSerial(rs.getInt("serial"));
                pro.setColor(rs.getString("color"));
                pro.setImagen(rs.getString("imagen"));
                pro.setMarca(rs.getString("marca"));
                pro.setMaterial(rs.getString("material"));
                pro.setDemanda(rs.getInt("demanda"));
                pro.setCosto_Produccion(rs.getFloat("costoproduccion"));
                pro.setPrecio_venta(rs.getFloat("precioventa"));
                pro.setCosto_almacenamiento(rs.getFloat("costoalmacenamiento"));
                pro.setId_bodega(rs.getInt("idbodega"));
                
                datos_tabla[0] = pro.getNombre();
                datos_tabla[1] = pro.getSerial();
                datos_tabla[2] = pro.getColor();
                datos_tabla[3] = pro.getMarca();
                datos_tabla[4] = pro.getMaterial();
                datos_tabla[5] = pro.getDemanda();
                datos_tabla[6] = pro.getCosto_Produccion();
                datos_tabla[7] = pro.getPrecio_venta();
                datos_tabla[8] = pro.getCosto_almacenamiento();
                datos_tabla[9] = pro.getId_bodega();

                modelo.addRow(datos_tabla);
                con_pro.arregloProductos.add(pro);
            }
        } catch(SQLException ex){
            Logger.getLogger(ProductoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void insertarBD(Producto p){
        String query = "INSERT INTO `ferreteria`.`producto` (`serial`, `nombre`, `color`, `imagen`, `marca`, `material`, `demanda`, `costoproduccion`, `precioventa`, `costoalmacenamiento`, `idbodega`)"
        + " VALUES ('"+p.getSerial()+"', '"+p.getNombre()+"', '"+p.getColor()+"', '"+p.getImagen()+"', '"+p.getMarca()+"', '"+p.getMaterial()+"', '"+p.getDemanda()+"', '"+p.getCosto_Produccion()+"', '"+p.getPrecio_venta()+"', '"+p.getCosto_almacenamiento()+"', '"+p.getId_bodega()+"');";
        
        System.out.println(query);
        try{
            st = con.createStatement();
            rsi = st.executeUpdate(query);
        } catch(SQLException ex){
            Logger.getLogger(ProductoGUI.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(j_tabla1, ex);
        }
       
    }
    
    private void BorrarBD(Producto pro){
        String query = "DELETE FROM `ferreteria`.`producto` WHERE (`serial` = '"+pro.getSerial()+"');";
        
        try {
            st = con.createStatement();
            rsi = st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ProductoGUI.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(j_tabla1, ex);
        }
    }
    
    private void actualizarBD(Producto p){
        String query = "UPDATE `ferreteria`.`producto` SET `nombre` = '"+p.getNombre()+"', `color` = '"+p.getColor()+"', `marca` = '"+p.getMarca()+"', `material` = '"+p.getMaterial()+"', `demanda` = '"+p.getDemanda()+"', `costoproduccion` = '"+p.getCosto_Produccion()+"',"
                + " `precioventa` = '"+p.getPrecio_venta()+"', `costoalmacenamiento` = '"+p.getCosto_almacenamiento()+"', `idbodega` = '"+p.getId_bodega()+"' WHERE (`serial` = '"+p.getSerial()+"');";
        
        try {
            st = con.createStatement();
            rsi = st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ProductoGUI.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(j_tabla1, ex);
        }
    }
    
    private void BorrarCampos(){
       jtf_serial.setText("");
       jtf_nombre.setText("");
       jtf_color.setText("");
       jtf_marca.setText("");
       jtf_material.setText("");
       jtf_demanda.setText("");
       jtf_costo_produccion.setText("");
       jtf_precio_venta.setText("");
       jtf_costo_almacenamiento.setText("");
       jtf_nombre.setText("");
       jtf_bodega.setText("");
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        j_tabla1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jl_title = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jl_serial = new javax.swing.JLabel();
        l_nombre = new javax.swing.JLabel();
        jl_color = new javax.swing.JLabel();
        jl_marca = new javax.swing.JLabel();
        jl_material = new javax.swing.JLabel();
        jl_demanda = new javax.swing.JLabel();
        jl_costo_produccion = new javax.swing.JLabel();
        jl_precio_venta = new javax.swing.JLabel();
        jl_costo_almacenamiento = new javax.swing.JLabel();
        jl_bodega = new javax.swing.JLabel();
        jtf_nombre = new javax.swing.JTextField();
        jtf_serial = new javax.swing.JTextField();
        jl_imagen = new javax.swing.JLabel();
        jtf_color = new javax.swing.JTextField();
        jtf_marca = new javax.swing.JTextField();
        jtf_material = new javax.swing.JTextField();
        jtf_demanda = new javax.swing.JTextField();
        jtf_precio_venta = new javax.swing.JTextField();
        jtf_costo_produccion = new javax.swing.JTextField();
        jtf_costo_almacenamiento = new javax.swing.JTextField();
        jtf_bodega = new javax.swing.JTextField();
        jb_insertar = new javax.swing.JButton();
        jb_actualizar = new javax.swing.JButton();
        jb_borrar = new javax.swing.JButton();
        jb_consultar_uno = new javax.swing.JButton();
        jb_ordenar_nombre = new javax.swing.JButton();
        jb_ordenar_id = new javax.swing.JButton();

        jPanel3.setBackground(new java.awt.Color(102, 80, 255));

        jLabel1.setBackground(new java.awt.Color(51, 204, 255));
        jLabel1.setFont(new java.awt.Font("Eras Bold ITC", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(60, 0, 150));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Usuarios");
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(685, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        j_tabla1.setBackground(new java.awt.Color(100, 100, 255));
        j_tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Serial", "Color", "Marca", "Material", "Demanda", "Costo de producción", "Predcio de venta", "Costo de almacenamiento", "Bodega"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        j_tabla1.setToolTipText("");
        j_tabla1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                j_tabla1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(j_tabla1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 568, 963, 150));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(434, 481, 41, -1));

        jPanel2.setBackground(new java.awt.Color(102, 80, 255));

        jl_title.setFont(new java.awt.Font("Eras Bold ITC", 0, 36)); // NOI18N
        jl_title.setForeground(new java.awt.Color(60, 0, 150));
        jl_title.setText("Productos Generales");
        jl_title.setToolTipText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jl_title, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(534, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jl_title, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(422, 422, 422))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 110));

        jPanel4.setBackground(new java.awt.Color(102, 80, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.setBackground(new java.awt.Color(102, 51, 255));

        jPanel6.setBackground(new java.awt.Color(102, 80, 255));

        jl_serial.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jl_serial.setForeground(new java.awt.Color(0, 51, 153));
        jl_serial.setText("Serial:");

        l_nombre.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        l_nombre.setForeground(new java.awt.Color(0, 51, 153));
        l_nombre.setText("Nombre:");

        jl_color.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jl_color.setForeground(new java.awt.Color(0, 51, 153));
        jl_color.setText("Color:");

        jl_marca.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jl_marca.setForeground(new java.awt.Color(0, 51, 153));
        jl_marca.setText("Marca:");

        jl_material.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jl_material.setForeground(new java.awt.Color(0, 51, 153));
        jl_material.setText("Material:");

        jl_demanda.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jl_demanda.setForeground(new java.awt.Color(0, 51, 153));
        jl_demanda.setText("Demanda:");

        jl_costo_produccion.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jl_costo_produccion.setForeground(new java.awt.Color(0, 51, 153));
        jl_costo_produccion.setText("Costo de producción:");

        jl_precio_venta.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jl_precio_venta.setForeground(new java.awt.Color(0, 51, 153));
        jl_precio_venta.setText("Precio de venta:");

        jl_costo_almacenamiento.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jl_costo_almacenamiento.setForeground(new java.awt.Color(0, 51, 153));
        jl_costo_almacenamiento.setText("Costo de almacenamiento:");

        jl_bodega.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jl_bodega.setForeground(new java.awt.Color(0, 51, 153));
        jl_bodega.setText("Bodega:");

        jtf_nombre.setBackground(new java.awt.Color(100, 100, 255));
        jtf_nombre.setBorder(null);
        jtf_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_nombreActionPerformed(evt);
            }
        });

        jtf_serial.setBackground(new java.awt.Color(100, 100, 255));
        jtf_serial.setBorder(null);

        jl_imagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jtf_color.setBackground(new java.awt.Color(100, 100, 255));
        jtf_color.setBorder(null);

        jtf_marca.setBackground(new java.awt.Color(100, 100, 255));
        jtf_marca.setBorder(null);

        jtf_material.setBackground(new java.awt.Color(100, 100, 255));
        jtf_material.setBorder(null);

        jtf_demanda.setBackground(new java.awt.Color(100, 100, 255));
        jtf_demanda.setBorder(null);

        jtf_precio_venta.setBackground(new java.awt.Color(100, 100, 255));
        jtf_precio_venta.setBorder(null);
        jtf_precio_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_precio_ventaActionPerformed(evt);
            }
        });

        jtf_costo_produccion.setBackground(new java.awt.Color(100, 100, 255));
        jtf_costo_produccion.setBorder(null);

        jtf_costo_almacenamiento.setBackground(new java.awt.Color(100, 100, 255));
        jtf_costo_almacenamiento.setBorder(null);

        jtf_bodega.setBackground(new java.awt.Color(100, 100, 255));
        jtf_bodega.setBorder(null);
        jtf_bodega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_bodegaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jl_precio_venta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtf_precio_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jl_demanda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtf_demanda, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jl_color)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtf_color, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jl_serial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtf_serial, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(l_nombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jl_costo_produccion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtf_costo_produccion, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jl_bodega)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtf_bodega, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jl_marca, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtf_marca, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jl_material)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtf_material, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jl_costo_almacenamiento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtf_costo_almacenamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jl_imagen, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(l_nombre))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtf_serial, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jl_serial))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtf_color, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jl_color))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtf_marca, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jl_marca)))
                    .addComponent(jl_imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_material, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_material))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_demanda, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_demanda))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_costo_produccion, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_costo_produccion))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_precio_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_precio_venta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_costo_almacenamiento)
                    .addComponent(jtf_costo_almacenamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_bodega)
                    .addComponent(jtf_bodega, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jb_insertar.setBackground(new java.awt.Color(100, 80, 255));
        jb_insertar.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jb_insertar.setForeground(new java.awt.Color(0, 0, 204));
        jb_insertar.setText("Insertar");
        jb_insertar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jb_insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_insertarActionPerformed(evt);
            }
        });

        jb_actualizar.setBackground(new java.awt.Color(100, 80, 255));
        jb_actualizar.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jb_actualizar.setForeground(new java.awt.Color(0, 0, 204));
        jb_actualizar.setText("Actualizar");
        jb_actualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jb_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_actualizarActionPerformed(evt);
            }
        });

        jb_borrar.setBackground(new java.awt.Color(100, 80, 255));
        jb_borrar.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jb_borrar.setForeground(new java.awt.Color(0, 0, 204));
        jb_borrar.setText("Borrar");
        jb_borrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jb_borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_borrarActionPerformed(evt);
            }
        });

        jb_consultar_uno.setBackground(new java.awt.Color(100, 80, 255));
        jb_consultar_uno.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jb_consultar_uno.setForeground(new java.awt.Color(0, 0, 204));
        jb_consultar_uno.setText("Consultar un Producto");
        jb_consultar_uno.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jb_consultar_uno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_consultar_unoActionPerformed(evt);
            }
        });

        jb_ordenar_nombre.setBackground(new java.awt.Color(100, 80, 255));
        jb_ordenar_nombre.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jb_ordenar_nombre.setForeground(new java.awt.Color(0, 0, 204));
        jb_ordenar_nombre.setText("Ordenar por Nombre");
        jb_ordenar_nombre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jb_ordenar_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_ordenar_nombreActionPerformed(evt);
            }
        });

        jb_ordenar_id.setBackground(new java.awt.Color(100, 80, 255));
        jb_ordenar_id.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jb_ordenar_id.setForeground(new java.awt.Color(0, 0, 204));
        jb_ordenar_id.setText("Ordenar por ID");
        jb_ordenar_id.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jb_ordenar_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_ordenar_idActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jb_insertar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jb_actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jb_borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(161, 161, 161))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jb_ordenar_id, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(135, 135, 135))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jb_consultar_uno, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jb_ordenar_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 99, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jb_insertar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jb_actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jb_borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jb_ordenar_id, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jb_ordenar_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jb_consultar_uno, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jb_insertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_insertarActionPerformed
        //añadir a la tabla.
        pro = new Producto();
        pro.setNombre(jtf_nombre.getText());
        pro.setSerial(Integer.parseInt(jtf_serial.getText()));
        pro.setColor(jtf_color.getText());
        pro.setMarca(jtf_marca.getText());
        pro.setMaterial(jtf_material.getText());
        pro.setDemanda(Integer.parseInt(jtf_demanda.getText()));
        pro.setCosto_Produccion(Float.parseFloat(jtf_costo_produccion.getText()));
        pro.setPrecio_venta(Float.parseFloat(jtf_precio_venta.getText()));
        pro.setCosto_almacenamiento(Float.parseFloat(jtf_costo_almacenamiento.getText()));
        pro.setId_bodega(Integer.parseInt(jtf_bodega.getText()));
        
        pro.setImagen("C:\\Users\\David Reyes\\OneDrive - Universidad Nacional de Colombia\\Documentos\\NetBeansProjects\\EmpresaCadenaSuministros2\\EmpresaCadenaSuministros2\\Imagenes\\"+pro.getNombre()+".jpg");
        ImageIcon image = new ImageIcon(pro.getImagen());
        jl_imagen.setIcon(image);
        
        if(con_pro.insertar(pro)){
            datos_tabla[0] = pro.getNombre();
            datos_tabla[1] = pro.getSerial();
            datos_tabla[2] = pro.getColor();
            datos_tabla[3] = pro.getMarca();
            datos_tabla[4] = pro.getMaterial();
            datos_tabla[5] = pro.getDemanda();
            datos_tabla[6] = pro.getCosto_Produccion();
            datos_tabla[7] = pro.getPrecio_venta();
            datos_tabla[8] = pro.getCosto_almacenamiento();
            datos_tabla[9] = pro.getId_bodega();
            
            modelo.addRow(datos_tabla);
            
            //Insertar en el controlador
            con_pro.arregloProductos.add(pro);
            
            JOptionPane.showMessageDialog(null, "Producto insertado.");
        } else{
            JOptionPane.showMessageDialog(null, "Producto no insertado, serial duplicada.");
        }
        
        //añadir a la base de datos
        insertarBD(pro);
        
        BorrarCampos();
    }//GEN-LAST:event_jb_insertarActionPerformed
    
    
    
    private void jb_ordenar_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_ordenar_idActionPerformed
        //Ordenar Controlador
        con_pro.ordenar();
        
        //Ordenar la tabla
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);
    }//GEN-LAST:event_jb_ordenar_idActionPerformed

    private void jb_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_actualizarActionPerformed
        int row = j_tabla1.getSelectedRow();
        pro = new Producto();
        pro = con_pro.arregloProductos.remove(row);
        
        pro.setNombre(jtf_nombre.getText());
        pro.setColor(jtf_color.getText());
        pro.setMarca(jtf_marca.getText());
        pro.setMaterial(jtf_material.getText());
        pro.setDemanda(Integer.parseInt(jtf_demanda.getText()));
        pro.setCosto_Produccion(Float.parseFloat(jtf_costo_produccion.getText()));
        pro.setPrecio_venta(Float.parseFloat(jtf_precio_venta.getText()));
        pro.setCosto_almacenamiento(Float.parseFloat(jtf_costo_almacenamiento.getText()));
        pro.setId_bodega(Integer.parseInt(jtf_bodega.getText()));
        
        pro.setImagen("C:\\Users\\David Reyes\\OneDrive - Universidad Nacional de Colombia\\Documentos\\NetBeansProjects\\EmpresaCadenaSuministros2\\EmpresaCadenaSuministros2\\Imagenes\\"+pro.getNombre()+".jpg");
        ImageIcon image = new ImageIcon(pro.getImagen());
        jl_imagen.setIcon(image);
        
        datos_tabla[0] = pro.getNombre();
        datos_tabla[1] = pro.getSerial();
        datos_tabla[2] = pro.getColor();
        datos_tabla[3] = pro.getMarca();
        datos_tabla[4] = pro.getMaterial();
        datos_tabla[5] = pro.getDemanda();
        datos_tabla[6] = pro.getCosto_Produccion();
        datos_tabla[7] = pro.getPrecio_venta();
        datos_tabla[8] = pro.getCosto_almacenamiento();
        datos_tabla[9] = pro.getId_bodega();
        
        //Insertar en el controlador
        con_pro.arregloProductos.add(pro);
        
        con_pro.arregloProductos.remove(row);
        
        //Actualizar de la tabla
        modelo.removeRow(row);
        modelo.addRow(datos_tabla);
        
        //Actualizar de la base de datos
        actualizarBD(pro);
        
        JOptionPane.showMessageDialog(null, "Producto actualizado.");
    }//GEN-LAST:event_jb_actualizarActionPerformed

    private void jb_ordenar_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_ordenar_nombreActionPerformed
        //Ordenar Controlador
        //con_pro.ordenar();
        
        //Ordenar la tabla
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);
    }//GEN-LAST:event_jb_ordenar_nombreActionPerformed

    private void jb_consultar_unoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_consultar_unoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_consultar_unoActionPerformed

    private void jb_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_borrarActionPerformed
        int row = j_tabla1.getSelectedRow();
        pro = new Producto();
        pro = con_pro.arregloProductos.get(row);
        
        //Eliminar del Controlador
        con_pro.arregloProductos.remove(row);
        
        //Eliminar de la tabla
        modelo.removeRow(row);
        
        //Eliminar de la base de datos
        BorrarBD(pro);
    }//GEN-LAST:event_jb_borrarActionPerformed
    
    private void jtf_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_nombreActionPerformed

    private void jtf_precio_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_precio_ventaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_precio_ventaActionPerformed

    private void j_tabla1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_j_tabla1MouseClicked
        int pos = j_tabla1.getSelectedRow();
        
        pro  = new Producto();
        pro = con_pro.arregloProductos.get(pos);
        
        jtf_serial.setText(pro.getSerial()+"");
        jtf_nombre.setText(pro.getNombre()+"");
        jtf_color.setText(pro.getColor()+"");
        jtf_marca.setText(pro.getMarca()+"");
        jtf_material.setText(pro.getMaterial()+"");
        jtf_demanda.setText(pro.getDemanda()+"");
        jtf_costo_almacenamiento.setText(pro.getCosto_almacenamiento()+"");
        jtf_precio_venta.setText(pro.getPrecio_venta()+"");
        jtf_costo_produccion.setText(pro.getCosto_Produccion()+"");
        jtf_bodega.setText(pro.getId_bodega()+"");
    }//GEN-LAST:event_j_tabla1MouseClicked

    private void jtf_bodegaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_bodegaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_bodegaActionPerformed

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public ConexionBD getMysqlcon() {
        return mysqlcon;
    }

    public void setMysqlcon(ConexionBD mysqlcon) {
        this.mysqlcon = mysqlcon;
    }

    public Statement getSt() {
        return st;
    }

    public void setSt(Statement st) {
        this.st = st;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public int getRsi() {
        return rsi;
    }

    public void setRsi(int rsi) {
        this.rsi = rsi;
    }

    public Object[] getDatos_tabla() {
        return datos_tabla;
    }

    public void setDatos_tabla(Object[] datos_tabla) {
        this.datos_tabla = datos_tabla;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }

    public Producto getPro() {
        return pro;
    }

    public void setPro(Producto pro) {
        this.pro = pro;
    }

    public ControladorProducto getCon_pro() {
        return con_pro;
    }

    public void setCon_pro(ControladorProducto con_pro) {
        this.con_pro = con_pro;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    public JPanel getjPanel3() {
        return jPanel3;
    }

    public void setjPanel3(JPanel jPanel3) {
        this.jPanel3 = jPanel3;
    }

    public JPanel getjPanel4() {
        return jPanel4;
    }

    public void setjPanel4(JPanel jPanel4) {
        this.jPanel4 = jPanel4;
    }

    public JPanel getjPanel6() {
        return jPanel6;
    }

    public void setjPanel6(JPanel jPanel6) {
        this.jPanel6 = jPanel6;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JTable getJ_tabla1() {
        return j_tabla1;
    }

    public void setJ_tabla1(JTable j_tabla1) {
        this.j_tabla1 = j_tabla1;
    }

    public JButton getJb_actualizar() {
        return jb_actualizar;
    }

    public void setJb_actualizar(JButton jb_actualizar) {
        this.jb_actualizar = jb_actualizar;
    }

    public JButton getJb_borrar() {
        return jb_borrar;
    }

    public void setJb_borrar(JButton jb_borrar) {
        this.jb_borrar = jb_borrar;
    }

    public JButton getJb_consultar_uno() {
        return jb_consultar_uno;
    }

    public void setJb_consultar_uno(JButton jb_consultar_uno) {
        this.jb_consultar_uno = jb_consultar_uno;
    }

    public JButton getJb_insertar() {
        return jb_insertar;
    }

    public void setJb_insertar(JButton jb_insertar) {
        this.jb_insertar = jb_insertar;
    }

    public JButton getJb_ordenar_id() {
        return jb_ordenar_id;
    }

    public void setJb_ordenar_id(JButton jb_ordenar_id) {
        this.jb_ordenar_id = jb_ordenar_id;
    }

    public JButton getJb_ordenar_nombre() {
        return jb_ordenar_nombre;
    }

    public void setJb_ordenar_nombre(JButton jb_ordenar_nombre) {
        this.jb_ordenar_nombre = jb_ordenar_nombre;
    }

    public JLabel getJl_bodega() {
        return jl_bodega;
    }

    public void setJl_bodega(JLabel jl_bodega) {
        this.jl_bodega = jl_bodega;
    }

    public JLabel getJl_color() {
        return jl_color;
    }

    public void setJl_color(JLabel jl_color) {
        this.jl_color = jl_color;
    }

    public JLabel getJl_costo_almacenamiento() {
        return jl_costo_almacenamiento;
    }

    public void setJl_costo_almacenamiento(JLabel jl_costo_almacenamiento) {
        this.jl_costo_almacenamiento = jl_costo_almacenamiento;
    }

    public JLabel getJl_costo_produccion() {
        return jl_costo_produccion;
    }

    public void setJl_costo_produccion(JLabel jl_costo_produccion) {
        this.jl_costo_produccion = jl_costo_produccion;
    }

    public JLabel getJl_demanda() {
        return jl_demanda;
    }

    public void setJl_demanda(JLabel jl_demanda) {
        this.jl_demanda = jl_demanda;
    }

    public JLabel getJl_imagen() {
        return jl_imagen;
    }

    public void setJl_imagen(JLabel jl_imagen) {
        this.jl_imagen = jl_imagen;
    }

    public JLabel getJl_marca() {
        return jl_marca;
    }

    public void setJl_marca(JLabel jl_marca) {
        this.jl_marca = jl_marca;
    }

    public JLabel getJl_material() {
        return jl_material;
    }

    public void setJl_material(JLabel jl_material) {
        this.jl_material = jl_material;
    }

    public JLabel getJl_precio_venta() {
        return jl_precio_venta;
    }

    public void setJl_precio_venta(JLabel jl_precio_venta) {
        this.jl_precio_venta = jl_precio_venta;
    }

    public JLabel getJl_serial() {
        return jl_serial;
    }

    public void setJl_serial(JLabel jl_serial) {
        this.jl_serial = jl_serial;
    }

    public JLabel getJl_title() {
        return jl_title;
    }

    public void setJl_title(JLabel jl_title) {
        this.jl_title = jl_title;
    }

    public JTextField getJtf_bodega() {
        return jtf_bodega;
    }

    public void setJtf_bodega(JTextField jtf_bodega) {
        this.jtf_bodega = jtf_bodega;
    }

    public JTextField getJtf_color() {
        return jtf_color;
    }

    public void setJtf_color(JTextField jtf_color) {
        this.jtf_color = jtf_color;
    }

    public JTextField getJtf_costo_almacenamiento() {
        return jtf_costo_almacenamiento;
    }

    public void setJtf_costo_almacenamiento(JTextField jtf_costo_almacenamiento) {
        this.jtf_costo_almacenamiento = jtf_costo_almacenamiento;
    }

    public JTextField getJtf_costo_produccion() {
        return jtf_costo_produccion;
    }

    public void setJtf_costo_produccion(JTextField jtf_costo_produccion) {
        this.jtf_costo_produccion = jtf_costo_produccion;
    }

    public JTextField getJtf_demanda() {
        return jtf_demanda;
    }

    public void setJtf_demanda(JTextField jtf_demanda) {
        this.jtf_demanda = jtf_demanda;
    }

    public JTextField getJtf_marca() {
        return jtf_marca;
    }

    public void setJtf_marca(JTextField jtf_marca) {
        this.jtf_marca = jtf_marca;
    }

    public JTextField getJtf_material() {
        return jtf_material;
    }

    public void setJtf_material(JTextField jtf_material) {
        this.jtf_material = jtf_material;
    }

    public JTextField getJtf_nombre() {
        return jtf_nombre;
    }

    public void setJtf_nombre(JTextField jtf_nombre) {
        this.jtf_nombre = jtf_nombre;
    }

    public JTextField getJtf_precio_venta() {
        return jtf_precio_venta;
    }

    public void setJtf_precio_venta(JTextField jtf_precio_venta) {
        this.jtf_precio_venta = jtf_precio_venta;
    }

    public JTextField getJtf_serial() {
        return jtf_serial;
    }

    public void setJtf_serial(JTextField jtf_serial) {
        this.jtf_serial = jtf_serial;
    }

    public JLabel getL_nombre() {
        return l_nombre;
    }

    public void setL_nombre(JLabel l_nombre) {
        this.l_nombre = l_nombre;
    }
    
    
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
            java.util.logging.Logger.getLogger(ProductoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductoGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable j_tabla1;
    private javax.swing.JButton jb_actualizar;
    private javax.swing.JButton jb_borrar;
    private javax.swing.JButton jb_consultar_uno;
    private javax.swing.JButton jb_insertar;
    private javax.swing.JButton jb_ordenar_id;
    private javax.swing.JButton jb_ordenar_nombre;
    private javax.swing.JLabel jl_bodega;
    private javax.swing.JLabel jl_color;
    private javax.swing.JLabel jl_costo_almacenamiento;
    private javax.swing.JLabel jl_costo_produccion;
    private javax.swing.JLabel jl_demanda;
    private javax.swing.JLabel jl_imagen;
    private javax.swing.JLabel jl_marca;
    private javax.swing.JLabel jl_material;
    private javax.swing.JLabel jl_precio_venta;
    private javax.swing.JLabel jl_serial;
    private javax.swing.JLabel jl_title;
    private javax.swing.JTextField jtf_bodega;
    private javax.swing.JTextField jtf_color;
    private javax.swing.JTextField jtf_costo_almacenamiento;
    private javax.swing.JTextField jtf_costo_produccion;
    private javax.swing.JTextField jtf_demanda;
    private javax.swing.JTextField jtf_marca;
    private javax.swing.JTextField jtf_material;
    private javax.swing.JTextField jtf_nombre;
    private javax.swing.JTextField jtf_precio_venta;
    private javax.swing.JTextField jtf_serial;
    private javax.swing.JLabel l_nombre;
    // End of variables declaration//GEN-END:variables
}
