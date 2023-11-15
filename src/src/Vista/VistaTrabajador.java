/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Controlador.ControladorTrabajador;
import java.util.Scanner;
import Modelo.Trabajador;
/**
 *
 * @author David Reyes y Maria Paula Atehortua
 */
public class VistaTrabajador {
    Scanner scan;
    ControladorTrabajador cu;

    public VistaTrabajador(){
        scan = new Scanner(System.in);
        cu = new ControladorTrabajador();
        insertarUsuariosDefault();
        
        
    }
  
    private void insertarUsuariosDefault() {
        
        Trabajador user = new Trabajador();
        cu.insertar(user);
        
        user = new Trabajador();
        cu.insertar(user);
        
        user = new Trabajador();
        cu.insertar(user);
        
        user = new Trabajador();
        cu.insertar(user);
        
    }
    private void insertarUsuario(){
        Trabajador user = new Trabajador();
        System.out.println("Nombre: ");
        user.setNombre(scan.next());
        System.out.println("Apellido: ");
        user.setApellido(scan.next());
        System.out.println("Id: ");
        user.setId(scan.nextInt());
        System.out.println("Telefono: ");
        user.setTelefono(scan.next());
        System.out.println("Direccion: ");
        user.setDireccion(scan.next());
        System.out.println("Correo electronico: ");
        user.setCorreo(scan.next());
        System.out.println("Fecha de nacimiento: ");
        user.setFecha_nacimiento(scan.next());
        System.out.println("fecha de ingreso: ");
        user.setFecha_ingreso(scan.next());
        System.out.println("Sueldo: ");
        user.setSueldo(scan.next());
        
        if(cu.insertar(user)){
            System.out.println("Usuario insertado");
        }        
        else{
            System.out.println("Usuario no insertado Id del Usuario duplicado.");
        }
    }
    
    private void consultarUsuario(){
        System.out.println("Ingrese el serial del Usuario a consultar: ");
        int serial = scan.nextInt();
        String Trabajador = cu.consultar(serial);
        System.out.println(Trabajador);
    }
    
    private void borrarUsuario(){
        System.out.println("Ingrese la serial del Usuario a borrar: ");
        int serial = scan.nextInt();
        
        boolean borrado = cu.borrar(serial);
        
        if(borrado){
            System.out.println("Usuario borrado satisfactoriamente.");
        } else{
            System.out.println("No se encontro un Usuario para borrar.");
        }
    }
    
    private void actualizarUsuario(){
        System.out.println("Ingrese el serial del Usuario a actualizar: ");
        int serial = scan.nextInt();
        
        boolean actualizado = cu.actualizar(serial);
        
        if(actualizado){
            System.out.println("Usuario actualizado satisfactoriamente.");
        } else{
            System.out.println("No se encontro el Usuario a actualizar.");
        }
    }
    
    public void menu(){
        boolean exit = false;
        while(exit == false){
            System.out.println("Menu Usuarios Trabajadores");
            System.out.println("1. Insertar Usuario");
            System.out.println("2. Buscar Usuario");
            System.out.println("3. Ver todos los Usuario");
            System.out.println("4. Eliminar un Usuario");
            System.out.println("5. Actualizar un Usuario");
            System.out.println("6. Ordenar Lista de Usuarios");
            System.out.println("7.salir");

            int opcion = scan.nextInt();
            if(opcion > 0 && opcion < 8){
                switch (opcion) {
                    case 1 -> insertarUsuario();
                    case 2 -> consultarUsuario();
                    case 3 -> cu.consultar();
                    case 4 -> borrarUsuario();
                    case 5 -> actualizarUsuario();
                    case 6 -> cu.ordenar();
                    default -> exit = true;
                }
            }
        }
    }
}//Fin clase
