/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import GUI.InicioGUI;
import java.util.Scanner;

/**
 *
 * @author David Reyes y Maria Paula Atehortua
 */
public class Principal {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        VistaProducto vp = new VistaProducto();
        VistaUsuario vu = new VistaUsuario();
        VistaElectricos ve = new VistaElectricos();
        VistaHerrajes vh = new VistaHerrajes();
        VistaTrabajador vt = new VistaTrabajador();
        VistaOtros vo = new VistaOtros();
        
        boolean programa = true;
        while(programa){
            System.out.println("Elija una opcion:");
            System.out.println("1. Usuarios.");
            System.out.println("2. Productos.");
            System.out.println("3. Electricos.");
            System.out.println("4. Herrajes");
            System.out.println("5. Trabajador");
            System.out.println("6. Productos (otros)");
            System.out.println("7. Salir");
            int opt = scan.nextInt();
            switch (opt) {
                case 1 -> vu.menu();
                case 2 -> vp.menu();
                case 3 -> ve.menu();
                case 4 -> vh.menu();
                case 5 -> vt.menu();
                case 6 -> vo.menu();
                default -> programa = false;
            }
            
        }
        
        
    }
    
}


