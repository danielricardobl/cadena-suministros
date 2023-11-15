/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import Modelo.Otros;

/**
 *
 * @author David Reyes y Maria Paula Atehortua
 */
public class ControladorOtros implements CRUD{
    public static ArrayList<Otros> arregloOtros = new ArrayList<>();
    public Scanner scan = new Scanner(System.in);
    
    @Override
    public boolean insertar(Object obj) {
        Otros otro = (Otros) obj;
        if(arregloOtros.isEmpty()){
            arregloOtros.add(otro);
            return true;
        }
        else{
            for(Otros o: arregloOtros){
                if(o.equals(otro))
                    return false;
            }
            arregloOtros.add(otro);
            return true;
        }
    }

    @Override
    public String consultar(int id) {
        ordenar();
        
        //busqueda binaria
        int i = 0, f=arregloOtros.size()-1, m;
        while(i <= f){
            m = (i+f)/2;
            if (id == arregloOtros.get(m).getSerial()){
                return arregloOtros.get(m).toString();
            } else if(id > arregloOtros.get(m).getSerial()){
                i = m+1;
            } else{
                f = m-1;
            }
        }
        return "No se encontro el producto.";
    }

    @Override
    public void consultar() {
        for(Otros Pro : arregloOtros)
        {
            System.out.println(Pro.toString());
        }   
            
    }

    

    @Override
    public boolean borrar(int id) {
        for(Otros Pro : arregloOtros){
            if(id == Pro.getSerial()){
                return arregloOtros.remove(Pro);
            }
        }
        return false;
    }

    @Override
    public boolean actualizar(int id) {
        for(Otros Pro : arregloOtros){
            if(id == Pro.getSerial()){
                System.out.println("Ingrese la demanda nueva del material: ");
                Pro.setDemanda(scan.nextInt());
                System.out.println("Ingrese el costo de Produccion nuevo del material: ");
                Pro.setCosto_Produccion(scan.nextFloat());
                System.out.println("Ingrese el nuevo precio de venta del material: ");
                Pro.setPrecio_venta(scan.nextFloat());
                System.out.println("Ingrese el costo de almacenamiento nuevo del material: ");
                Pro.setCosto_almacenamiento(scan.nextFloat());
                System.out.println("Ingrese una nueva descirpcion del material: ");
                Pro.setDescripcion(scan.next());
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void ordenar() {
        Collections.sort(arregloOtros);
    }
    
}
