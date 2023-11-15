/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import Modelo.Herrajes;

/**
 *
 * @author David Reyes y Maria Paula Atehortua
 */
public class ControladorHerrajes implements CRUD{
    public static ArrayList<Herrajes> arregloHerrajes = new ArrayList<>();
    public Scanner scan = new Scanner(System.in);
    
    @Override
    public boolean insertar(Object obj) {
        Herrajes herr = (Herrajes) obj;
        if(arregloHerrajes.isEmpty()){
            arregloHerrajes.add(herr);
            return true;
        }
        else{
            for(Herrajes h: arregloHerrajes){
                if(h.equals(herr))
                    return false;
            }
            arregloHerrajes.add(herr);
            return true;
        }
    }

    @Override
    public String consultar(int id) {
        ordenar();
        
        //busqueda binaria
        int i = 0, f=arregloHerrajes.size()-1, m;
        while(i <= f){
            m = (i+f)/2;
            if (id == arregloHerrajes.get(m).getSerial()){
                return arregloHerrajes.get(m).toString();
            } else if(id > arregloHerrajes.get(m).getSerial()){
                i = m+1;
            } else{
                f = m-1;
            }
        }
        return "No se encontro el Producto.";
    }

    @Override
    public void consultar(){
        for(Herrajes Pro : arregloHerrajes){
            System.out.println(Pro.toString());
        }   
            
    }

    

    @Override
    public boolean borrar(int id) {
        for(Herrajes Pro : arregloHerrajes){
            if(id == Pro.getSerial()){
                return arregloHerrajes.remove(Pro);
            }
        }
        return false;
    }

    @Override
    public boolean actualizar(int id) {
        for(Herrajes Pro : arregloHerrajes){
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
        Collections.sort(arregloHerrajes);
    }
    
}
