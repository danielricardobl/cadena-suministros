/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Controlador.ControladorHerrajes;
import java.util.Scanner;
import Modelo.Herrajes;

/**
 *
 * @author David Reyes y Maria Paula Atehortua
 */
public class VistaHerrajes {
    Scanner scan;
    ControladorHerrajes cp;

    public VistaHerrajes() {
        scan = new Scanner(System.in);
        cp = new ControladorHerrajes();
        insertarProductosDefault();
    }
  
    private void insertarProductosDefault(){
    }
    
    private void insertarProducto(){
       
        Herrajes oh = new Herrajes();
        System.out.println("Nombre del Producto: ");
        oh.setNombre(scan.next());
        System.out.println("Serial del Producto: ");
        oh.setSerial(scan.nextInt());
        System.out.println("Color del producto: ");
        oh.setColor(scan.next());
        System.out.println("Marca del producto: ");
        oh.setMarca(scan.next());
        System.out.println("Material del producto: ");
        oh.setMaterial(scan.next());
        System.out.println("Demanda del producto: ");
        oh.setDemanda(scan.nextInt());
        System.out.println("Costo de produccion: ");
        oh.setCosto_Produccion(scan.nextFloat());
        System.out.println("Precio de venta: ");
        oh.setPrecio_venta(scan.nextFloat());
        System.out.println("Costo de almacenamiento: ");
        oh.setCosto_almacenamiento(scan.nextFloat());
        System.out.println("Id de bodega: ");
        oh.setId_bodega(scan.nextInt());
        System.out.println("tipo de elemento: ");
        oh.setTipo_elemento(scan.next());
        
        if(cp.insertar(oh)){
            System.out.println("Producto insertado");
        }        
        else{
            System.out.println("Producto no insertado codigo del Producto duplicado");
        }
    }
    
    private void consultarProducto(){
        System.out.println("Ingrese el serial del Producto a consultar: ");
        int serial = scan.nextInt();
        String Herrajes = cp.consultar(serial);
        System.out.println(Herrajes);
    }
    
    private void borrarProducto(){
        System.out.println("Ingrese la serial del Producto a borrar: ");
        int serial = scan.nextInt();
        
        boolean borrado = cp.borrar(serial);
        
        if(borrado){
            System.out.println("Producto borrado satisfactoriamente.");
        } else{
            System.out.println("No se encontro un Producto para borrar.");
        }
    }
    
    private void actualizarProducto(){
        System.out.println("Ingrese el serial del Producto a actualizar: ");
        int serial = scan.nextInt();
        
        boolean actualizado = cp.actualizar(serial);
        
        if(actualizado){
            System.out.println("Producto actualizado satisfactoriamente.");
        } else{
            System.out.println("No se encontro el Producto a actualizar.");
        }
    }
    
    public void menu(){
        boolean exit = false;
            while(exit == false){
            System.out.println("Menu Productos Herrajes");
            System.out.println("1. Insertar Producto");
            System.out.println("2. Buscar Producto");
            System.out.println("3. Ver todos los Producto");
            System.out.println("4. Eliminar un Producto");
            System.out.println("5. Actualizar un Producto");
            System.out.println("6. Ordenar Lista.");
            System.out.println("7. Salir.");

            int opcion = scan.nextInt();
            if(opcion > 0 && opcion < 8){
                switch (opcion) {
                    case 1 -> insertarProducto();
                    case 2 -> consultarProducto();
                    case 3 -> cp.consultar();
                    case 4 -> borrarProducto();
                    case 5 -> actualizarProducto();
                    case 6 -> cp.ordenar();
                    default -> exit = true;
                }
            }
            
        }
    }
}
