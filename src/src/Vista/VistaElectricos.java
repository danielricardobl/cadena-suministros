/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Controlador.ControladorElectricos;
import java.util.Scanner;
import Modelo.Electricos;
        
/**
 *
 * @author David Reyes y Maria Paula Atehortua
 */
public class VistaElectricos {
    Scanner scan;
    ControladorElectricos cp;

    public VistaElectricos() {
        scan = new Scanner(System.in);
        cp = new ControladorElectricos();
        insertarProductosDefault();
    }
  
    private void insertarProductosDefault(){
        Electricos elec = new Electricos(12, 10, "Cable 10", 836, "Negro", "", "NN",
                "Cobre", 100, 10000, 15000, 500, 6);
        cp.insertar(elec);
    }
    
    private void insertarProducto()
    {
       
        Electricos objpp1 = new Electricos();
        System.out.println("Nombre del Producto: ");
        objpp1.setNombre(scan.next());
        System.out.println("Serial del Producto: ");
        objpp1.setSerial(scan.nextInt());
        System.out.println("Color del producto: ");
        objpp1.setColor(scan.next());
        System.out.println("Marca del producto: ");
        objpp1.setMarca(scan.next());
        System.out.println("Material del producto: ");
        objpp1.setMaterial(scan.next());
        System.out.println("Demanda del producto: ");
        objpp1.setDemanda(scan.nextInt());
        System.out.println("Costo de produccion: ");
        objpp1.setCosto_Produccion(scan.nextFloat());
        System.out.println("Precio de venta: ");
        objpp1.setPrecio_venta(scan.nextFloat());
        System.out.println("Costo de almacenamiento: ");
        objpp1.setCosto_almacenamiento(scan.nextFloat());
        System.out.println("Id de bodega: ");
        objpp1.setId_bodega(scan.nextInt());
        System.out.println("Capacidad de carga del producto: ");
        objpp1.setCapacidad_carga(scan.nextInt());
        System.out.println("Calibre del producto: ");
        objpp1.setCalibre(scan.nextInt());
        
        if(cp.insertar(objpp1))
        {
            System.out.println("Producto insertado");
        }        
        else
        {
            System.out.println("Producto no insertado codigo del Producto duplicado");
        }
    }
    
    private void consultarProducto(){
        System.out.println("Ingrese el serial del Producto a consultar: ");
        int serial = scan.nextInt();
        String Electricos = cp.consultar(serial);
        System.out.println(Electricos);
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
            System.out.println("Menu Productos Electricos");
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
