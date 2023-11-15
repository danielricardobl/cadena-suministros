/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Controlador.ControladorUsuario;
import java.util.Scanner;
import Modelo.Usuario;

/**
 *
 * @author David Reyes y Maria Paula Atehortua
 */
public class VistaUsuario {
    Scanner scan;
    ControladorUsuario cu;

    public VistaUsuario() {
        scan = new Scanner(System.in);
        cu = new ControladorUsuario();
        insertarUsuariosDefault();
        
        
    }
  
    private void insertarUsuariosDefault() {
        
        Usuario user = new Usuario("David", "Reyes", 10596, "3217947022", "Clle 10 #09-50",
                                    "davidreyes@gmail.com", "15/08/2005", "Administrador");
        cu.insertar(user);
        
        user = new Usuario("Santiago", "Pineda", 10984, "3093485739", "Cra 10 #10-06",
                                    "santiagopinedadr@gmail.com", "13/12/2002", "Bodeguero");
        cu.insertar(user);
        
        user = new Usuario("Susanita", "Perez", 16698, "3758395643", "Av 10 #01-78",
                                    "susanitaperezdr@gmail.com", "18/10/1998", "Vendedor");
        cu.insertar(user);
        
        user = new Usuario("Pepe", "Murica", 19456, "3647599387", "Av 34",
                                    "pepemurcia@gmail.com", "12/05/1990", "Cliente");
        cu.insertar(user);
        
    }
    private void insertarUsuario(){
        Usuario user = new Usuario();
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
        
        if(cu.insertar(user)){
            System.out.println("Usuario insertado");
        }        
        else{
            System.out.println("Usuario no insertado Id del Usuario duplicado");
        }
    }
    
    private void consultarUsuario(){
        System.out.println("Ingrese el serial del Usuario a consultar: ");
        int serial = scan.nextInt();
        String Usuario = cu.consultar(serial);
        System.out.println(Usuario);
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
            System.out.println("Menu Usuarios");
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
