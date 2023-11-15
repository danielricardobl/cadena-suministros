/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Controlador.ControladorUsuario;
import Modelo.ConexionBD;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author David Reyes
 */
public class InicioGUI extends javax.swing.JFrame {
    //Base de datos
    Connection con;
    ConexionBD mysqlcon;
    Statement st;
    ResultSet rs;
    int rsi;
    
    //Usuarios y controlador
    private Usuario usu;
    private ControladorUsuario con_usu;
    
    public InicioGUI() {
        //base de datos 
        mysqlcon = new ConexionBD();
        con = mysqlcon.mySqlConnection();
        con_usu = new ControladorUsuario();
        
        usuariosPorDefecto();
        initComponents();
    }
    
    private void usuariosPorDefecto(){
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
                
                con_usu.arregloUsuarios.add(usu);
            }
        } catch(SQLException ex){
            Logger.getLogger(ProductoGUI.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "Error en la base de datos.");
        }
    }
    
    public String consultarRole(String tipo){
        return tipo;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jl_inicio_sesion = new javax.swing.JLabel();
        jl_id = new javax.swing.JLabel();
        jl_contrasena = new javax.swing.JLabel();
        jl_tipo_usuario = new javax.swing.JLabel();
        jtf_id = new javax.swing.JTextField();
        jpf_contrasena = new javax.swing.JPasswordField();
        jb_ingresar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jcb_usuario = new javax.swing.JComboBox<>();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl_inicio_sesion.setFont(new java.awt.Font("Eras Bold ITC", 0, 36)); // NOI18N
        jl_inicio_sesion.setForeground(new java.awt.Color(60, 0, 150));
        jl_inicio_sesion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_inicio_sesion.setText("Iniciar Sesión");
        jl_inicio_sesion.setToolTipText("");
        jl_inicio_sesion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jl_inicio_sesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 708, 83));

        jl_id.setFont(new java.awt.Font("Eras Demi ITC", 0, 18)); // NOI18N
        jl_id.setForeground(new java.awt.Color(0, 51, 153));
        jl_id.setText("Identificación: ");
        getContentPane().add(jl_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 206, -1, 40));

        jl_contrasena.setFont(new java.awt.Font("Eras Demi ITC", 0, 18)); // NOI18N
        jl_contrasena.setForeground(new java.awt.Color(0, 51, 153));
        jl_contrasena.setText("Contraseña:");
        getContentPane().add(jl_contrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, -1, 40));

        jl_tipo_usuario.setFont(new java.awt.Font("Eras Demi ITC", 0, 18)); // NOI18N
        jl_tipo_usuario.setForeground(new java.awt.Color(0, 51, 153));
        jl_tipo_usuario.setText("Tipo de Usuario:");
        getContentPane().add(jl_tipo_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 147, -1, 40));

        jtf_id.setBackground(new java.awt.Color(100, 100, 255));
        jtf_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_idActionPerformed(evt);
            }
        });
        getContentPane().add(jtf_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 207, 238, 40));
        jtf_id.getAccessibleContext().setAccessibleName("");

        jpf_contrasena.setBackground(new java.awt.Color(100, 100, 255));
        jpf_contrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpf_contrasenaActionPerformed(evt);
            }
        });
        getContentPane().add(jpf_contrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, 260, 40));

        jb_ingresar.setBackground(new java.awt.Color(100, 100, 255));
        jb_ingresar.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jb_ingresar.setForeground(new java.awt.Color(0, 0, 204));
        jb_ingresar.setText("Ingresar");
        jb_ingresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jb_ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_ingresarActionPerformed(evt);
            }
        });
        getContentPane().add(jb_ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 323, 108, 35));

        jPanel1.setBackground(new java.awt.Color(102, 80, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 708, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 52, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 708, -1));

        jPanel2.setBackground(new java.awt.Color(102, 80, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 708, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 375, 708, 60));

        jPanel3.setBackground(new java.awt.Color(102, 51, 255));

        jcb_usuario.setBackground(new java.awt.Color(100, 100, 255));
        jcb_usuario.setFont(new java.awt.Font("Eras Medium ITC", 0, 14)); // NOI18N
        jcb_usuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Vendedor", "Bodeguero", "Cliente" }));
        jcb_usuario.setToolTipText("");
        jcb_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_usuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(347, Short.MAX_VALUE)
                .addComponent(jcb_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(213, 213, 213))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jcb_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(196, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 710, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb_ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_ingresarActionPerformed
        //Lista con los tipo de usuario.
        String[] lista_tipo_usuarios = {"A", "V", "B", "C"};
        
        //Obtener contraseña, id y tipo de usuario ingresados
        int id = Integer.parseInt(jtf_id.getText());
        String contrasena = new String(jpf_contrasena.getPassword());
        int index_tipo_usuario = jcb_usuario.getSelectedIndex();
        String tipo_usuario = lista_tipo_usuarios[index_tipo_usuario];
        
        //Buscar un usuario con el mismo id.
        usu = new Usuario();
        usu = (Usuario)con_usu.retornarUsuario(id);
        
        //verificar que el Usuario exista.
        if(usu == null){
            JOptionPane.showMessageDialog(rootPane, "Usuario no encontrado.");
        } else{
            boolean user = false;
            try{
                String query = "select * from usuario";
                st = con.createStatement();
                rs = st.executeQuery(query);
                
                //verificar que el id y la contraseña son correctas.
                while(rs.next()){
                    System.out.println(rs.getString("id"));
                    System.out.println(id);
                    System.out.println(rs.getString("contrasena"));
                    System.out.println(contrasena);
                    if((Integer.parseInt(rs.getString("id")) == id) && (rs.getString("contrasena").equals(contrasena)) && (rs.getString("tipo").equals(tipo_usuario))){
                        user = true;
                        break;
                    } else{
                        System.out.println("falso");
                        if(rs.getString("tipo").equals(tipo_usuario)){
                            System.out.println("verdadero");
                        }
                        user = false;
                    }
                }
            } catch(SQLException ex){
                Logger.getLogger(ProductoGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //Ejecutar menu en caso de que el id y contraseñas sean correctas
            if(user == true){
                switch (tipo_usuario) {
                    case "A":
                        java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            new MenuGUI().setVisible(true);
                            }
                        });
                        break;
                    case "V":
                        java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            MenuGUI mgui = new MenuGUI("V");
                            mgui.setVisible(true);
                            mgui.getJmi_registrar().setEnabled(false);
                            }
                        });
                        break;
                    case "B":
                        java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            MenuGUI mgui = new MenuGUI("B");
                            mgui.setVisible(true);
                            mgui.getJmi_registrar().setEnabled(false);
                            }
                        });
                        break;
                    case "C":
                        java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            MenuGUI mgui = new MenuGUI("C");
                            mgui.setVisible(true);
                            mgui.getJmi_registrar().setEnabled(false);
                            }
                        });
                        break;
                    default:
                        throw new AssertionError();
                }
            } else{
                JOptionPane.showMessageDialog(rootPane, "Id, contraseña o tipo de usuario incorrecto.");
            }
        }
    }//GEN-LAST:event_jb_ingresarActionPerformed
       
    private void jtf_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_idActionPerformed

    private void jpf_contrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpf_contrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jpf_contrasenaActionPerformed

    private void jcb_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_usuarioActionPerformed

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
            java.util.logging.Logger.getLogger(InicioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicioGUI().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JButton jb_ingresar;
    private javax.swing.JComboBox<String> jcb_usuario;
    private javax.swing.JLabel jl_contrasena;
    private javax.swing.JLabel jl_id;
    private javax.swing.JLabel jl_inicio_sesion;
    private javax.swing.JLabel jl_tipo_usuario;
    private javax.swing.JPasswordField jpf_contrasena;
    private javax.swing.JTextField jtf_id;
    // End of variables declaration//GEN-END:variables
}
