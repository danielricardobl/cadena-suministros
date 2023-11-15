/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Controlador.ControladorOtros;
import java.util.Scanner;
import Modelo.Otros;

/**
 *
 * @author David Reyes y Maria Paula Atehortua
 */
public class VistaOtros {
    Scanner scan;
    ControladorOtros cp;

    public VistaOtros() {
        scan = new Scanner(System.in);
        cp = new ControladorOtros();
        insertarOtrossDefault();
        
        
    }
  
    private void insertarOtrossDefault(){
        Otros otro = new Otros("Producto para limpiar", "Hidrolavadora", 836, "Amarilla", "", "NN",
                "Plastico", 10, 30000, 50000, 3000, 9);
        cp.insertar(otro);
    }
    
    private void insertarOtros()
    {
       
        Otros objpp1 = new Otros();
        System.out.println("Nombre del producto: ");
        objpp1.setNombre(scan.next());
        System.out.println("Serial del producto: ");
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
        System.out.println("Descripcion: ");
        objpp1.setDescripcion(scan.next());
        
        if(cp.insertar(objpp1))
        {
            System.out.println("producto insertado");
        }        
        else
        {
            System.out.println("producto no insertado, codigo del producto duplicado");
        }
    }
    
    private void consultarOtros(){
        System.out.println("Ingrese el serial del producto a consultar: ");
        int serial = scan.nextInt();
        String Otros = cp.consultar(serial);
        System.out.println(Otros);
    }
    
    private void borrarOtros(){
        System.out.println("Ingrese la serial del producto a borrar: ");
        int serial = scan.nextInt();
        
        boolean borrado = cp.borrar(serial);
        
        if(borrado){
            System.out.println("producto borrado satisfactoriamente.");
        } else{
            System.out.println("No se encontro un producto para borrar.");
        }
    }
    
    private void actualizarOtros(){
        System.out.println("Ingrese el serial del producto a actualizar: ");
        int serial = scan.nextInt();
        
        boolean actualizado = cp.actualizar(serial);
        
        if(actualizado){
            System.out.println("Otros actualizado satisfactoriamente.");
        } else{
            System.out.println("No se encontro el producto a actualizar.");
        }
    }
    
    public void menu(){
        boolean exit = false;
        while(exit == false){ 
            System.out.println("Menu productos (Otros)");
            System.out.println("1. Insertar producto");
            System.out.println("2. Buscar producto");
            System.out.println("3. Ver todos los productos");
            System.out.println("4. Eliminar un producto");
            System.out.println("5. Actualizar un producto");
            System.out.println("6. Ordenar Lista.");
            System.out.println("7. Salir.");

            int opcion = scan.nextInt();
            if(opcion > 0 && opcion < 8){
                switch (opcion) {
                    case 1 -> insertarOtros();
                    case 2 -> consultarOtros();
                    case 3 -> cp.consultar();
                    case 4 -> borrarOtros();
                    case 5 -> actualizarOtros();
                    case 6 -> cp.ordenar();
                    default -> exit = true;
                }
            }
        }
    }
}//Fin clase
