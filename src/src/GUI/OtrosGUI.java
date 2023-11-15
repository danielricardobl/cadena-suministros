/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Controlador.ControladorOtros;
import Modelo.ConexionBD;
import Modelo.Otros;
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
public class OtrosGUI extends javax.swing.JFrame {
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
    private Otros otr;
    private ControladorOtros con_otr;
    
    public OtrosGUI() {
        initComponents();
        
        con_otr = new ControladorOtros();
        
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
                otr = new Otros();
                
                if(rs.getString("tipo").equals("O")){
                    otr.setNombre(rs.getString("nombre"));
                    otr.setSerial(rs.getInt("serial"));
                    otr.setColor(rs.getString("color"));
                    otr.setImagen(rs.getString("imagen"));
                    otr.setMarca(rs.getString("marca"));
                    otr.setMaterial(rs.getString("material"));
                    otr.setDemanda(rs.getInt("demanda"));
                    otr.setCosto_Produccion(rs.getFloat("costoproduccion"));
                    otr.setPrecio_venta(rs.getFloat("precioventa"));
                    otr.setCosto_almacenamiento(rs.getFloat("costoalmacenamiento"));
                    otr.setId_bodega(rs.getInt("idbodega"));
                    otr.setDescripcion(rs.getString("descripcion"));

                    datos_tabla[0] = otr.getNombre();
                    datos_tabla[1] = otr.getSerial();
                    datos_tabla[2] = otr.getColor();
                    datos_tabla[3] = otr.getMarca();
                    datos_tabla[4] = otr.getMaterial();
                    datos_tabla[5] = otr.getDemanda();
                    datos_tabla[6] = otr.getCosto_Produccion();
                    datos_tabla[7] = otr.getPrecio_venta();
                    datos_tabla[8] = otr.getCosto_almacenamiento();
                    datos_tabla[9] = otr.getId_bodega();

                    modelo.addRow(datos_tabla);
                    con_otr.arregloOtros.add(otr);
                }
            }
        } catch(SQLException ex){
            Logger.getLogger(OtrosGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void insertarBD(Otros p){
        String query = "INSERT INTO `ferreteria`.`producto` (`serial`, `nombre`, `color`, `imagen`, `marca`, `material`, `demanda`, `costoproduccion`, `precioventa`, `costoalmacenamiento`, `idbodega`, `descripcion`, `tipo`)"
        + " VALUES ('"+p.getSerial()+"', '"+p.getNombre()+"', '"+p.getColor()+"', '"+p.getImagen()+"', '"+p.getMarca()+"', '"+p.getMaterial()+"', '"+p.getDemanda()+"', '"+p.getCosto_Produccion()+"', '"+p.getPrecio_venta()+"',"
                + " '"+p.getCosto_almacenamiento()+"', '"+p.getId_bodega()+"', '"+p.getDescripcion()+"', 'O');";
        
        System.out.println(query);
        try{
            st = con.createStatement();
            rsi = st.executeUpdate(query);
        } catch(SQLException ex){
            Logger.getLogger(OtrosGUI.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(j_tabla1, ex);
        }
       
    }
    
    private void BorrarBD(Otros otr){
        String query = "DELETE FROM `ferreteria`.`producto` WHERE (`serial` = '"+otr.getSerial()+"');";
        
        try {
            st = con.createStatement();
            rsi = st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(OtrosGUI.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(j_tabla1, ex);
        }
    }
    
    private void actualizarBD(Otros p){
        String query = "UPDATE `ferreteria`.`producto` SET `nombre` = '"+p.getNombre()+"', `color` = '"+p.getColor()+"', `marca` = '"+p.getMarca()+"', `material` = '"+p.getMaterial()+"', `demanda` = '"+p.getDemanda()+"', `costoproduccion` = '"+p.getCosto_Produccion()+"',"
                + " `precioventa` = '"+p.getPrecio_venta()+"', `costoalmacenamiento` = '"+p.getCosto_almacenamiento()+"', `idbodega` = '"+p.getId_bodega()+"', `descripcion` = '"+p.getDescripcion()+" WHERE (`serial` = '"+p.getSerial()+"');";
        
        try {
            st = con.createStatement();
            rsi = st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(OtrosGUI.class.getName()).log(Level.SEVERE, null, ex);
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
       jta_descripcion.setText("");
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
        l_descripcion = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jta_descripcion = new javax.swing.JTextArea();
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
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl_title.setFont(new java.awt.Font("Eras Bold ITC", 0, 36)); // NOI18N
        jl_title.setForeground(new java.awt.Color(60, 0, 150));
        jl_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_title.setText("Otros Productos");
        jl_title.setToolTipText("");
        jPanel2.add(jl_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 380, 100));

        l_descripcion.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        l_descripcion.setForeground(new java.awt.Color(0, 51, 153));
        l_descripcion.setText("Descripcion del Producto:");
        jPanel2.add(l_descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(664, 6, -1, -1));

        jta_descripcion.setBackground(new java.awt.Color(100, 100, 255));
        jta_descripcion.setColumns(20);
        jta_descripcion.setRows(5);
        jScrollPane2.setViewportView(jta_descripcion);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 400, 77));

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
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(102, 80, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl_serial.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jl_serial.setForeground(new java.awt.Color(0, 51, 153));
        jl_serial.setText("Serial:");
        jPanel6.add(jl_serial, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        l_nombre.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        l_nombre.setForeground(new java.awt.Color(0, 51, 153));
        l_nombre.setText("Nombre:");
        jPanel6.add(l_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jl_color.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jl_color.setForeground(new java.awt.Color(0, 51, 153));
        jl_color.setText("Color:");
        jPanel6.add(jl_color, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        jl_marca.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jl_marca.setForeground(new java.awt.Color(0, 51, 153));
        jl_marca.setText("Marca:");
        jPanel6.add(jl_marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 50, -1));

        jl_material.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jl_material.setForeground(new java.awt.Color(0, 51, 153));
        jl_material.setText("Material:");
        jPanel6.add(jl_material, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, -1, -1));

        jl_demanda.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jl_demanda.setForeground(new java.awt.Color(0, 51, 153));
        jl_demanda.setText("Demanda:");
        jPanel6.add(jl_demanda, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, -1, -1));

        jl_costo_produccion.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jl_costo_produccion.setForeground(new java.awt.Color(0, 51, 153));
        jl_costo_produccion.setText("Costo de producción:");
        jPanel6.add(jl_costo_produccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, -1, -1));

        jl_precio_venta.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jl_precio_venta.setForeground(new java.awt.Color(0, 51, 153));
        jl_precio_venta.setText("Precio de venta:");
        jPanel6.add(jl_precio_venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, -1, -1));

        jl_costo_almacenamiento.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jl_costo_almacenamiento.setForeground(new java.awt.Color(0, 51, 153));
        jl_costo_almacenamiento.setText("Costo de almacenamiento:");
        jPanel6.add(jl_costo_almacenamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, -1, -1));

        jl_bodega.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jl_bodega.setForeground(new java.awt.Color(0, 51, 153));
        jl_bodega.setText("Bodega:");
        jPanel6.add(jl_bodega, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, -1, -1));

        jtf_nombre.setBackground(new java.awt.Color(100, 100, 255));
        jtf_nombre.setBorder(null);
        jtf_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_nombreActionPerformed(evt);
            }
        });
        jPanel6.add(jtf_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 100, 27));

        jtf_serial.setBackground(new java.awt.Color(100, 100, 255));
        jtf_serial.setBorder(null);
        jPanel6.add(jtf_serial, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 100, 27));

        jl_imagen.setBackground(new java.awt.Color(255, 255, 255));
        jl_imagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel6.add(jl_imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 180, 160));

        jtf_color.setBackground(new java.awt.Color(100, 100, 255));
        jtf_color.setBorder(null);
        jPanel6.add(jtf_color, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 100, 27));

        jtf_marca.setBackground(new java.awt.Color(100, 100, 255));
        jtf_marca.setBorder(null);
        jPanel6.add(jtf_marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 100, 27));

        jtf_material.setBackground(new java.awt.Color(100, 100, 255));
        jtf_material.setBorder(null);
        jPanel6.add(jtf_material, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 100, 27));

        jtf_demanda.setBackground(new java.awt.Color(100, 100, 255));
        jtf_demanda.setBorder(null);
        jPanel6.add(jtf_demanda, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 100, 27));

        jtf_precio_venta.setBackground(new java.awt.Color(100, 100, 255));
        jtf_precio_venta.setBorder(null);
        jtf_precio_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_precio_ventaActionPerformed(evt);
            }
        });
        jPanel6.add(jtf_precio_venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, 100, 27));

        jtf_costo_produccion.setBackground(new java.awt.Color(100, 100, 255));
        jtf_costo_produccion.setBorder(null);
        jPanel6.add(jtf_costo_produccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 100, 27));

        jtf_costo_almacenamiento.setBackground(new java.awt.Color(100, 100, 255));
        jtf_costo_almacenamiento.setBorder(null);
        jPanel6.add(jtf_costo_almacenamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 360, 100, 27));

        jtf_bodega.setBackground(new java.awt.Color(100, 100, 255));
        jtf_bodega.setBorder(null);
        jtf_bodega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_bodegaActionPerformed(evt);
            }
        });
        jPanel6.add(jtf_bodega, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 400, 100, 27));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, -1, 460));

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
        jPanel1.add(jb_insertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(706, 177, 103, 32));

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
        jPanel1.add(jb_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(706, 227, 103, 32));

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
        jPanel1.add(jb_borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(706, 277, 103, 32));

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
        jPanel1.add(jb_consultar_uno, new org.netbeans.lib.awtextra.AbsoluteConstraints(665, 439, 210, 32));

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
        jPanel1.add(jb_ordenar_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(674, 389, 192, 32));

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
        jPanel1.add(jb_ordenar_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(691, 339, 144, 32));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jb_insertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_insertarActionPerformed
        //añadir a la tabla.
        otr = new Otros();
        otr.setNombre(jtf_nombre.getText());
        otr.setSerial(Integer.parseInt(jtf_serial.getText()));
        otr.setColor(jtf_color.getText());
        otr.setMarca(jtf_marca.getText());
        otr.setMaterial(jtf_material.getText());
        otr.setDemanda(Integer.parseInt(jtf_demanda.getText()));
        otr.setCosto_Produccion(Float.parseFloat(jtf_costo_produccion.getText()));
        otr.setPrecio_venta(Float.parseFloat(jtf_precio_venta.getText()));
        otr.setCosto_almacenamiento(Float.parseFloat(jtf_costo_almacenamiento.getText()));
        otr.setId_bodega(Integer.parseInt(jtf_bodega.getText()));
        
        otr.setImagen("C:\\Users\\David Reyes\\OneDrive - Universidad Nacional de Colombia\\Documentos\\NetBeansProjects\\EmpresaCadenaSuministros2\\EmpresaCadenaSuministros2\\Imagenes\\"+otr.getNombre()+".jpg");
        ImageIcon image = new ImageIcon(otr.getImagen());
        jl_imagen.setIcon(image);
        
        if(con_otr.insertar(otr)){
            datos_tabla[0] = otr.getNombre();
            datos_tabla[1] = otr.getSerial();
            datos_tabla[2] = otr.getColor();
            datos_tabla[3] = otr.getMarca();
            datos_tabla[4] = otr.getMaterial();
            datos_tabla[5] = otr.getDemanda();
            datos_tabla[6] = otr.getCosto_Produccion();
            datos_tabla[7] = otr.getPrecio_venta();
            datos_tabla[8] = otr.getCosto_almacenamiento();
            datos_tabla[9] = otr.getId_bodega();
            
            modelo.addRow(datos_tabla);
            
            //Insertar en el controlador
            con_otr.arregloOtros.add(otr);
            
            JOptionPane.showMessageDialog(null, "Producto insertado.");
        } else{
            JOptionPane.showMessageDialog(null, "Producto no insertado, serial duplicada.");
        }
        
        //añadir a la base de datos
        insertarBD(otr);
        
        BorrarCampos();
    }//GEN-LAST:event_jb_insertarActionPerformed
    
    
    
    private void jb_ordenar_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_ordenar_idActionPerformed
        //Ordenar Controlador
        con_otr.ordenar();
        
        //Ordenar la tabla
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);
    }//GEN-LAST:event_jb_ordenar_idActionPerformed

    private void jb_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_actualizarActionPerformed
        int row = j_tabla1.getSelectedRow();
        otr = new Otros();
        otr = con_otr.arregloOtros.remove(row);
        
        otr.setNombre(jtf_nombre.getText());
        otr.setColor(jtf_color.getText());
        otr.setMarca(jtf_marca.getText());
        otr.setMaterial(jtf_material.getText());
        otr.setDemanda(Integer.parseInt(jtf_demanda.getText()));
        otr.setCosto_Produccion(Float.parseFloat(jtf_costo_produccion.getText()));
        otr.setPrecio_venta(Float.parseFloat(jtf_precio_venta.getText()));
        otr.setCosto_almacenamiento(Float.parseFloat(jtf_costo_almacenamiento.getText()));
        otr.setId_bodega(Integer.parseInt(jtf_bodega.getText()));
        otr.setDescripcion(jtf_bodega.getText());
        
        otr.setImagen("C:\\Users\\David Reyes\\OneDrive - Universidad Nacional de Colombia\\Documentos\\NetBeansProjects\\EmpresaCadenaSuministros2\\EmpresaCadenaSuministros2\\Imagenes\\"+otr.getNombre()+".jpg");
        ImageIcon image = new ImageIcon(otr.getImagen());
        jl_imagen.setIcon(image);
        
        datos_tabla[0] = otr.getNombre();
        datos_tabla[1] = otr.getSerial();
        datos_tabla[2] = otr.getColor();
        datos_tabla[3] = otr.getMarca();
        datos_tabla[4] = otr.getMaterial();
        datos_tabla[5] = otr.getDemanda();
        datos_tabla[6] = otr.getCosto_Produccion();
        datos_tabla[7] = otr.getPrecio_venta();
        datos_tabla[8] = otr.getCosto_almacenamiento();
        datos_tabla[9] = otr.getId_bodega();
        
        //Insertar en el controlador
        con_otr.arregloOtros.add(otr);
        
        con_otr.arregloOtros.remove(row);
        
        //Actualizar de la tabla
        modelo.removeRow(row);
        modelo.addRow(datos_tabla);
        
        //Actualizar de la base de datos
        actualizarBD(otr);
        
        JOptionPane.showMessageDialog(null, "Producto actualizado.");
    }//GEN-LAST:event_jb_actualizarActionPerformed

    private void jb_ordenar_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_ordenar_nombreActionPerformed
        //Ordenar Controlador
        //con_otr.ordenar();
        
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
        otr = new Otros();
        otr = con_otr.arregloOtros.get(row);
        
        //Eliminar del Controlador
        con_otr.arregloOtros.remove(row);
        
        //Eliminar de la tabla
        modelo.removeRow(row);
        
        //Eliminar de la base de datos
        BorrarBD(otr);
    }//GEN-LAST:event_jb_borrarActionPerformed
    
    private void jtf_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_nombreActionPerformed

    private void jtf_precio_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_precio_ventaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_precio_ventaActionPerformed

    private void j_tabla1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_j_tabla1MouseClicked
        int pos = j_tabla1.getSelectedRow();
        
        otr  = new Otros();
        otr = con_otr.arregloOtros.get(pos);
        
        jtf_serial.setText(otr.getSerial()+"");
        jtf_nombre.setText(otr.getNombre()+"");
        jtf_color.setText(otr.getColor()+"");
        jtf_marca.setText(otr.getMarca()+"");
        jtf_material.setText(otr.getMaterial()+"");
        jtf_demanda.setText(otr.getDemanda()+"");
        jtf_costo_almacenamiento.setText(otr.getCosto_almacenamiento()+"");
        jtf_precio_venta.setText(otr.getPrecio_venta()+"");
        jtf_costo_produccion.setText(otr.getCosto_Produccion()+"");
        jtf_bodega.setText(otr.getId_bodega()+"");
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

    public Otros getPro() {
        return otr;
    }

    public void setPro(Otros otr) {
        this.otr = otr;
    }

    public ControladorOtros getCon_otr() {
        return con_otr;
    }

    public void setCon_otr(ControladorOtros con_otr) {
        this.con_otr = con_otr;
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

    public JLabel getJl_costo_otrduccion() {
        return jl_costo_produccion;
    }

    public void setJl_costo_otrduccion(JLabel jl_costo_otrduccion) {
        this.jl_costo_produccion = jl_costo_otrduccion;
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
            java.util.logging.Logger.getLogger(OtrosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OtrosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OtrosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OtrosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OtrosGUI().setVisible(true);
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
    private javax.swing.JScrollPane jScrollPane2;
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
    private javax.swing.JTextArea jta_descripcion;
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
    private javax.swing.JLabel l_descripcion;
    private javax.swing.JLabel l_nombre;
    // End of variables declaration//GEN-END:variables
}
