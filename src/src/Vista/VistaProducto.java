/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Controlador.ControladorProducto;
import java.util.Scanner;
import Modelo.Producto;

/**
 *
 * @author David Reyes y Maria Paula Atehortua
 */
public class VistaProducto {
    Scanner scan;
    ControladorProducto cp;

    public VistaProducto() {
        scan = new Scanner(System.in);
        cp = new ControladorProducto();
        //insertarProductosDefault();
    }
  
    private void insertarProductosDefault()
    {
        Producto pro = new Producto("Pala", 323, "Plateado", "", 
                                    "Riduco", "Acero", 10, 15000, 30000, 1000, 1);
        cp.insertar(pro);
        pro = new Producto("Machete", 413, "Negro", "", 
                           "Riduco", "Acero", 10, 7000, 12000, 700, 1);
        cp.insertar(pro);
        pro = new Producto("Martillo", 765, "Plateado", "", 
                           "Riduco", "Acero", 10, 10000, 25000, 500, 1);
        cp.insertar(pro);
        pro = new Producto("Cemento", 653, "Gris", "", 
                           "Argos", "Arcilla", 30, 15000, 28000,1000, 2);
        cp.insertar(pro);
        pro = new Producto("Pintura", 587, "Amarillo", "", 
                           "Pintuco", "Resina", 30, 12000, 20000,1000, 2);
        cp.insertar(pro);
        pro = new Producto("Pulidora", 784, "Naranja", "", 
                           "Black+Decker", "Plastico y Hierro", 5, 22000, 40000,1500, 4);
        cp.insertar(pro);
        pro = new Producto("Taladro", 442, "Amarillo", "", 
                           "Stanley", "Plastico y Hierro", 5, 17000, 32000,1200, 4);
        cp.insertar(pro);
        pro = new Producto("Lamina", 901, "Plateado", "", 
                           "Inoxcenter", "Aluminio", 25, 2000, 7000,1000, 3);
        cp.insertar(pro);
        pro = new Producto("Pisos", 890, "Cafe", "", 
                           "Corona", "Ceramica", 20, 5000, 12000,500, 3);
        cp.insertar(pro);
        pro = new Producto("Flexometro", 386, "Amarillo", "", 
                           "Stanley", "Plastico", 20, 5000, 10000,700, 1);
        cp.insertar(pro);
        
        
        
    }
    private void insertarProducto()
    {
       
        Producto objpp1 = new Producto();
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
        String Producto = cp.consultar(serial);
        System.out.println(Producto);
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
            System.out.println("Menu Productos");
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
}//Fin clase
