/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Controlador.ControladorUsuario;
import Modelo.ConexionBD;
import Modelo.Usuario;
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
import javax.swing.RowSorter.SortKey;
import javax.swing.SortOrder;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author David Reyes
 */
public class UsuarioGUI extends javax.swing.JFrame {
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
    private Usuario usu;
    private ControladorUsuario con_usu;
    
    public UsuarioGUI() {
        initComponents();
        con_usu = new ControladorUsuario();
        
        //tabla
        datos_tabla = new Object[11];
        modelo = (DefaultTableModel) j_tabla1.getModel();
        
        //base de datos
        mysqlcon = new ConexionBD();
        con = mysqlcon.mySqlConnection();
        
        datosDefecto();
    }
    
    private void datosDefecto(){
        String query = "select * from usuario";
        
        try{
            st = con.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                usu = new Usuario();
                
                usu.setId(rs.getInt("id"));
                usu.setNombre(rs.getString("nombre"));
                usu.setApellido(rs.getString("apellido"));
                usu.setTelefono(rs.getString("telefono"));
                usu.setDireccion(rs.getString("direccion"));
                usu.setCorreo(rs.getString("correo"));
                usu.setTipo_usuario(rs.getString("tipo"));
                usu.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
                usu.setContrasena(rs.getString("contrasena"));
                
                datos_tabla[0] = usu.getNombre();
                datos_tabla[1] = usu.getApellido();
                datos_tabla[2] = usu.getId();
                datos_tabla[3] = usu.getTelefono();
                datos_tabla[4] = usu.getDireccion();
                datos_tabla[5] = usu.getCorreo();
                datos_tabla[6] = usu.getTipo_usuario();
                datos_tabla[7] = usu.getFecha_nacimiento();

                modelo.addRow(datos_tabla);
                con_usu.arregloUsuarios.add(usu);
            }
        } catch(SQLException ex){
            Logger.getLogger(ProductoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void insertarBD(Usuario u){
        
        String query = "INSERT INTO `ferreteria`.`usuario` (`id`, `nombre`, `apellido`, `telefono`, `direccion`, `correo`, `tipo`, `fecha_nacimiento`, `contrasena`)"
        + " VALUES ('"+u.getId()+"', '"+u.getNombre()+"', '"+u.getApellido()+"', '"+u.getTelefono()+"', '"+u.getDireccion()+"', '"+u.getCorreo()+"', '"+u.getTipo_usuario()+"', '"+u.getFecha_nacimiento()+"', '"+u.getContrasena()+"');";
        
        System.out.println(query);
        try{
            st = con.createStatement();
            rsi = st.executeUpdate(query);
        } catch(SQLException ex){
            Logger.getLogger(ProductoGUI.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(j_tabla1, ex);
        }
       
    }
    
    private void BorrarBD(Usuario u){
        String query = "DELETE FROM `ferreteria`.`usuario` WHERE (`id` = '"+u.getId()+"');";
        
        try {
            st = con.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ProductoGUI.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(j_tabla1, ex);
        }
    }
    
    private void BorrarCampos(){
       jtf_apellido.setText("");
       jtf_nombre.setText("");
       jtf_identificacion.setText("");
       jtf_telefono.setText("");
       jtf_direccion.setText("");
       jtf_correo.setText("");
       jtf_tipo_usuario.setText("");
       jtf_fecha_nacimiento.setText("");
       jtf_nombre.setText("");
       jpf_contrasena.setText("");
    }
    
    private void actualizarBD(Usuario u){
        String query = "UPDATE `ferreteria`.`usuario` SET `nombre` = '"+u.getNombre()+"', `apellido` = '"+u.getApellido()+"', `telefono` = '"+u.getTelefono()+"', `direccion` = '"+u.getCorreo()+"', `tipo` = '"+u.getTipo_usuario()+"', `fecha_nacimiento` = '"+u.getFecha_nacimiento()+"'"
                +" WHERE (`id` = '"+u.getId()+"');";
        
        try {
            st = con.createStatement();
            rsi = st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ProductoGUI.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(j_tabla1, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        j_tabla1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jb_insertar = new javax.swing.JButton();
        jb_actualizar = new javax.swing.JButton();
        jb_borrar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jtf_tipo_usuario = new javax.swing.JTextField();
        jtf_fecha_nacimiento = new javax.swing.JTextField();
        jpf_contrasena = new javax.swing.JPasswordField();
        jl_fecha_nacimiento = new javax.swing.JLabel();
        jl_contrasena = new javax.swing.JLabel();
        jl_tipo_usuario = new javax.swing.JLabel();
        jl_correo = new javax.swing.JLabel();
        jl_direccion = new javax.swing.JLabel();
        jl_telefono = new javax.swing.JLabel();
        jl_identificacion = new javax.swing.JLabel();
        jl_apellido = new javax.swing.JLabel();
        jl_nombre = new javax.swing.JLabel();
        jtf_nombre = new javax.swing.JTextField();
        jtf_apellido = new javax.swing.JTextField();
        jtf_identificacion = new javax.swing.JTextField();
        jtf_telefono = new javax.swing.JTextField();
        jtf_direccion = new javax.swing.JTextField();
        jtf_correo = new javax.swing.JTextField();
        jb_consultar_uno = new javax.swing.JButton();
        jb_ordenar_nombre = new javax.swing.JButton();
        jb_ordenar_id = new javax.swing.JButton();

        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(51, 204, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        j_tabla1.setBackground(new java.awt.Color(100, 100, 255));
        j_tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido", "Identificacion", "Telefono", "Direccion", "Correo", "Tipo de Usuario", "Fecha de nacimiento", "Contraseña"
            }
        ));
        j_tabla1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        j_tabla1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        j_tabla1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                j_tabla1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(j_tabla1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 981, 163));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 514, 41, -1));

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(942, 112, -1, -1));

        jPanel2.setBackground(new java.awt.Color(102, 51, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel2.add(jb_insertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 160, 100, 35));

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
        jPanel2.add(jb_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 210, 100, 35));

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
        jPanel2.add(jb_borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 260, 100, 35));

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

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 90));

        jPanel4.setBackground(new java.awt.Color(102, 80, 255));

        jtf_tipo_usuario.setBackground(new java.awt.Color(100, 100, 255));
        jtf_tipo_usuario.setBorder(null);
        jtf_tipo_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_tipo_usuarioActionPerformed(evt);
            }
        });

        jtf_fecha_nacimiento.setBackground(new java.awt.Color(100, 100, 255));
        jtf_fecha_nacimiento.setBorder(null);

        jpf_contrasena.setBackground(new java.awt.Color(100, 100, 255));
        jpf_contrasena.setBorder(null);
        jpf_contrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpf_contrasenaActionPerformed(evt);
            }
        });

        jl_fecha_nacimiento.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jl_fecha_nacimiento.setForeground(new java.awt.Color(0, 51, 153));
        jl_fecha_nacimiento.setLabelFor(jtf_fecha_nacimiento);
        jl_fecha_nacimiento.setText("Fecha de nacimiento:");

        jl_contrasena.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jl_contrasena.setForeground(new java.awt.Color(0, 51, 153));
        jl_contrasena.setLabelFor(jpf_contrasena);
        jl_contrasena.setText("Contraseña:");

        jl_tipo_usuario.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jl_tipo_usuario.setForeground(new java.awt.Color(0, 51, 153));
        jl_tipo_usuario.setLabelFor(jtf_tipo_usuario);
        jl_tipo_usuario.setText("Tipo de Usuario");

        jl_correo.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jl_correo.setForeground(new java.awt.Color(0, 51, 153));
        jl_correo.setLabelFor(jtf_correo);
        jl_correo.setText("Correo:");

        jl_direccion.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jl_direccion.setForeground(new java.awt.Color(0, 51, 153));
        jl_direccion.setLabelFor(jtf_direccion);
        jl_direccion.setText("Direccion:");

        jl_telefono.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jl_telefono.setForeground(new java.awt.Color(0, 51, 153));
        jl_telefono.setLabelFor(jtf_telefono);
        jl_telefono.setText("Telefono:");

        jl_identificacion.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jl_identificacion.setForeground(new java.awt.Color(0, 51, 153));
        jl_identificacion.setLabelFor(jtf_identificacion);
        jl_identificacion.setText("Identificacion:");

        jl_apellido.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jl_apellido.setForeground(new java.awt.Color(0, 51, 153));
        jl_apellido.setLabelFor(jtf_apellido);
        jl_apellido.setText("Apellido:");

        jl_nombre.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jl_nombre.setForeground(new java.awt.Color(0, 51, 153));
        jl_nombre.setLabelFor(jtf_nombre);
        jl_nombre.setText("Nombre:");

        jtf_nombre.setBackground(new java.awt.Color(100, 100, 255));
        jtf_nombre.setBorder(null);
        jtf_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_nombreActionPerformed(evt);
            }
        });

        jtf_apellido.setBackground(new java.awt.Color(100, 100, 255));
        jtf_apellido.setBorder(null);

        jtf_identificacion.setBackground(new java.awt.Color(100, 100, 255));
        jtf_identificacion.setBorder(null);

        jtf_telefono.setBackground(new java.awt.Color(100, 100, 255));
        jtf_telefono.setBorder(null);

        jtf_direccion.setBackground(new java.awt.Color(100, 100, 255));
        jtf_direccion.setBorder(null);

        jtf_correo.setBackground(new java.awt.Color(100, 100, 255));
        jtf_correo.setBorder(null);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jl_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jl_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtf_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jl_identificacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtf_identificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jl_telefono)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtf_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jl_direccion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtf_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jl_correo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtf_correo, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jl_tipo_usuario)
                        .addGap(12, 12, 12)
                        .addComponent(jtf_tipo_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jl_fecha_nacimiento)
                        .addGap(12, 12, 12)
                        .addComponent(jtf_fecha_nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jl_contrasena)
                        .addGap(12, 12, 12)
                        .addComponent(jpf_contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(72, 72, 72))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_nombre))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_apellido))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_identificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_identificacion))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_telefono))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_direccion))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_correo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_correo))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jl_tipo_usuario))
                    .addComponent(jtf_tipo_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jl_fecha_nacimiento))
                    .addComponent(jtf_fecha_nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jl_contrasena))
                    .addComponent(jpf_contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, -1, 430));

        jb_consultar_uno.setBackground(new java.awt.Color(100, 80, 255));
        jb_consultar_uno.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jb_consultar_uno.setForeground(new java.awt.Color(0, 0, 204));
        jb_consultar_uno.setText("Consultar un usuario");
        jb_consultar_uno.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jb_consultar_uno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_consultar_unoActionPerformed(evt);
            }
        });
        jPanel2.add(jb_consultar_uno, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 330, 180, 35));

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
        jPanel2.add(jb_ordenar_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 380, 180, 35));

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
        jPanel2.add(jb_ordenar_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 430, 180, 35));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jb_insertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_insertarActionPerformed
        //añadir a la tabla.
        usu = new Usuario();
        usu.setNombre(jtf_nombre.getText());
        usu.setApellido(jtf_apellido.getText());
        usu.setId(Integer.parseInt(jtf_identificacion.getText()));
        usu.setTelefono(jtf_telefono.getText());
        usu.setDireccion(jtf_direccion.getText());
        usu.setCorreo(jtf_correo.getText());
        usu.setTipo_usuario(jtf_tipo_usuario.getText());
        usu.setFecha_nacimiento(jtf_fecha_nacimiento.getText());
        String contra = new String(jpf_contrasena.getPassword());
        usu.setContrasena(contra);
        
        if(con_usu.insertar(usu)){
            datos_tabla[0] = usu.getNombre();
            datos_tabla[1] = usu.getApellido();
            datos_tabla[2] = usu.getId();
            datos_tabla[3] = usu.getTelefono();
            datos_tabla[4] = usu.getDireccion();
            datos_tabla[5] = usu.getCorreo();
            datos_tabla[6] = usu.getTipo_usuario();
            datos_tabla[7] = usu.getFecha_nacimiento();
            datos_tabla[8] = usu.getContrasena();
            
            modelo.addRow(datos_tabla);
            con_usu.arregloUsuarios.add(usu);
            
            JOptionPane.showMessageDialog(null, "Usuario insertado.");
        } else{
            JOptionPane.showMessageDialog(null, "Usuario no insertado, id duplicada.");
        }
        
        //añadir a la base de datos
        insertarBD(usu);
        
        BorrarCampos();
    }//GEN-LAST:event_jb_insertarActionPerformed

    
    
    private void jb_ordenar_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_ordenar_idActionPerformed
        //Ordenar Controlador
        con_usu.ordenar();
        
        //Ordenar la tabla
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
        List<SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new SortKey(2, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);
        
       j_tabla1.setRowSorter(sorter); //Permite hacer que se puedan ordenar los datos en la tabla al tocar un titulo.
    }//GEN-LAST:event_jb_ordenar_idActionPerformed

    private void jb_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_actualizarActionPerformed
        int row = j_tabla1.getSelectedRow();
        usu = new Usuario();
        usu = con_usu.arregloUsuarios.remove(row);
        
        usu.setNombre(jtf_nombre.getText());
        usu.setApellido(jtf_apellido.getText());
        usu.setTelefono(jtf_telefono.getText());
        usu.setDireccion(jtf_direccion.getText());
        usu.setCorreo(jtf_correo.getText());
        usu.setTipo_usuario(jtf_tipo_usuario.getText());
        usu.setFecha_nacimiento(jtf_fecha_nacimiento.getText());
        String contra = new String(jpf_contrasena.getPassword());
        usu.setContrasena(contra);
        
        datos_tabla[0] = usu.getNombre();
        datos_tabla[1] = usu.getApellido();
        datos_tabla[2] = usu.getId();
        datos_tabla[3] = usu.getTelefono();
        datos_tabla[4] = usu.getDireccion();
        datos_tabla[5] = usu.getCorreo();
        datos_tabla[6] = usu.getTipo_usuario();
        datos_tabla[7] = usu.getFecha_nacimiento();
        datos_tabla[8] = usu.getContrasena();
        
        //Insertar en el controlador
        con_usu.arregloUsuarios.add(usu);
        
        con_usu.arregloUsuarios.remove(row);
        
        //Actualizar de la tabla
        modelo.removeRow(row);
        modelo.addRow(datos_tabla);
        
        //Actualizar de la base de datos
        actualizarBD(usu);
        
        JOptionPane.showMessageDialog(null, "Producto actualizado.");
    }//GEN-LAST:event_jb_actualizarActionPerformed

    private void jb_ordenar_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_ordenar_nombreActionPerformed
        //Ordenar Controlador
        //con_usu.ordenar();
        
        //Ordenar la tabla
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
        List<SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new SortKey(0, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);
    }//GEN-LAST:event_jb_ordenar_nombreActionPerformed

    private void jb_consultar_unoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_consultar_unoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_consultar_unoActionPerformed

    private void jb_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_borrarActionPerformed
        int row = j_tabla1.getSelectedRow();
        usu = new Usuario();
        usu = con_usu.arregloUsuarios.get(row);
        
        //Eliminar del Controlador
        con_usu.arregloUsuarios.remove(row);
        
        //Eliminar de la tabla
        modelo.removeRow(row);
        
        //Eliminar de la base de datos
        BorrarBD(usu);
    }//GEN-LAST:event_jb_borrarActionPerformed
    
    private void j_tabla1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_j_tabla1MouseClicked
        int pos = j_tabla1.getSelectedRow();
        
        usu  = new Usuario();
        usu = con_usu.arregloUsuarios.get(pos);
        
        jtf_apellido.setText(usu.getApellido()+"");
        jtf_nombre.setText(usu.getNombre()+"");
        jtf_identificacion.setText(usu.getId()+"");
        jtf_telefono.setText(usu.getTelefono()+"");
        jtf_direccion.setText(usu.getDireccion()+"");
        jtf_fecha_nacimiento.setText(usu.getFecha_nacimiento()+"");
        jtf_tipo_usuario.setText(usu.getTipo_usuario()+"");
        jtf_correo.setText(usu.getCorreo()+"");
        jpf_contrasena.setText(usu.getContrasena()+"");
    }//GEN-LAST:event_j_tabla1MouseClicked

    private void jtf_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_nombreActionPerformed

    private void jpf_contrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpf_contrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jpf_contrasenaActionPerformed

    private void jtf_tipo_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_tipo_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_tipo_usuarioActionPerformed

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
                new UsuarioGUI().setVisible(true);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable j_tabla1;
    private javax.swing.JButton jb_actualizar;
    private javax.swing.JButton jb_borrar;
    private javax.swing.JButton jb_consultar_uno;
    private javax.swing.JButton jb_insertar;
    private javax.swing.JButton jb_ordenar_id;
    private javax.swing.JButton jb_ordenar_nombre;
    private javax.swing.JLabel jl_apellido;
    private javax.swing.JLabel jl_contrasena;
    private javax.swing.JLabel jl_correo;
    private javax.swing.JLabel jl_direccion;
    private javax.swing.JLabel jl_fecha_nacimiento;
    private javax.swing.JLabel jl_identificacion;
    private javax.swing.JLabel jl_nombre;
    private javax.swing.JLabel jl_telefono;
    private javax.swing.JLabel jl_tipo_usuario;
    private javax.swing.JPasswordField jpf_contrasena;
    private javax.swing.JTextField jtf_apellido;
    private javax.swing.JTextField jtf_correo;
    private javax.swing.JTextField jtf_direccion;
    private javax.swing.JTextField jtf_fecha_nacimiento;
    private javax.swing.JTextField jtf_identificacion;
    private javax.swing.JTextField jtf_nombre;
    private javax.swing.JTextField jtf_telefono;
    private javax.swing.JTextField jtf_tipo_usuario;
    // End of variables declaration//GEN-END:variables
}
