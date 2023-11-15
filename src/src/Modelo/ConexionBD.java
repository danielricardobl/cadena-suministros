/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
    
/**
 *
 * @author David Reyes
 */
public class ConexionBD {
    public Connection mySqlConnection(){
        Connection con = null;
        try{
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost/ferreteria";
            Class.forName(driver);
            con = DriverManager.getConnection(url, "root", "admin");
        } catch (ClassNotFoundException ex){
            System.out.println("Driver no cargado");
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex){
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
