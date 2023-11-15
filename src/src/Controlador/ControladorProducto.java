/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import static Controlador.ControladorProducto.arregloProductos;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import Modelo.Producto;

/**
 *
 * @author David Reyes y Maria Paula Atehortua
 */
public class ControladorProducto implements CRUD{
    public static ArrayList<Producto> arregloProductos = new ArrayList<>();
    public Scanner scan = new Scanner(System.in);
    
    @Override
    public boolean insertar(Object obj) {
        Producto pro = (Producto) obj;
        if(arregloProductos.isEmpty()){
            arregloProductos.add(pro);
            return true;
        }
        else{
            for(Producto p: arregloProductos){
                if(p.equals(pro))
                    return false;
            }
            arregloProductos.add(pro);
            return true;
        }
    }

    @Override
    public String consultar(int id) {
        ordenar();
        
        //busqueda binaria
        int i = 0, f=arregloProductos.size()-1, m;
        while(i <= f){
            m = (i+f)/2;
            if (id == arregloProductos.get(m).getSerial()){
                return arregloProductos.get(m).toString();
            } else if(id > arregloProductos.get(m).getSerial()){
                i = m+1;
            } else{
                f = m-1;
            }
        }
        return "No se encontro el Producto.";
    }

    @Override
    public void consultar() {
        for(Producto Pro : arregloProductos)
        {
            System.out.println(Pro.toString());
        }   
            
    }

    

    @Override
    public boolean borrar(int id) {
        for(Producto Pro : arregloProductos){
            if(id == Pro.getSerial()){
                return arregloProductos.remove(Pro);
            }
        }
        return false;
    }

    @Override
    public boolean actualizar(int id) {
        for(Producto Pro : arregloProductos){
            if(id == Pro.getSerial()){
                System.out.println("Ingrese la demanda nueva del material: ");
                Pro.setDemanda(scan.nextInt());
                System.out.println("Ingrese el costo de Produccion nuevo del material: ");
                Pro.setCosto_Produccion(scan.nextFloat());
                System.out.println("Ingrese el nuevo precio de venta del material: ");
                Pro.setPrecio_venta(scan.nextFloat());
                System.out.println("Ingrese el costo de almacenamiento nuevo del material: ");
                Pro.setCosto_almacenamiento(scan.nextFloat());
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void ordenar() {
        Collections.sort(arregloProductos);
    }
    
       public void ordenar(ArrayList<Producto> productos) {
        Collections.sort(productos);
    }

    
}
