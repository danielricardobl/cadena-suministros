/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import Modelo.Electricos;


/**
 *
 * @author David Reyes y Maria Paula Atehortua
 */
public class ControladorElectricos implements CRUD {
    public static ArrayList<Electricos> arregloElectricos = new ArrayList<>();
    public Scanner scan = new Scanner(System.in);
    
    @Override
    public boolean insertar(Object obj) {
        Electricos user = (Electricos) obj;
        if(arregloElectricos.isEmpty()){
            arregloElectricos.add(user);
            return true;
        }
        else{
            for(Electricos u: arregloElectricos){
                if(u.equals(user))
                    return false;
            }
            arregloElectricos.add(user);
            return true;
        }
    }

    @Override
    public String consultar(int id) {
        ordenar();
        
        //busqueda binaria
        int i = 0, f=arregloElectricos.size()-1, m;
        while(i <= f){
            m = (i+f)/2;
            if (id == arregloElectricos.get(m).getSerial()){
                return arregloElectricos.get(m).toString();
            } else if(id > arregloElectricos.get(m).getSerial()){
                i = m+1;
            } else{
                f = m-1;
            }
        }
        return "No se encontro el producto.";
    }

    @Override
    public void consultar() {
        for(Electricos elec : arregloElectricos){
            System.out.println(elec.toString());
        }   
            
    }

    @Override
    public boolean borrar(int id) {
        for(Electricos elec : arregloElectricos){
            if(id == elec.getSerial()){
                return arregloElectricos.remove(elec);
            }
        }
        return false;
    }

    @Override
    public boolean actualizar(int id) {
        for(Electricos elec : arregloElectricos){
            if(id == elec.getSerial()){
                System.out.println("Ingrese la demanda nueva del material: ");
                elec.setDemanda(scan.nextInt());
                System.out.println("Ingrese el costo de produccion nuevo del material: ");
                elec.setCosto_Produccion(scan.nextFloat());
                System.out.println("Ingrese el nuevo precio de venta del material: ");
                elec.setPrecio_venta(scan.nextFloat());
                System.out.println("Ingrese el costo de almacenamiento nuevo del material: ");
                elec.setCosto_almacenamiento(scan.nextFloat());
                System.out.println("Ingrese la capacidad de carga del material: ");
                elec.setCapacidad_carga(scan.nextInt());
                System.out.println("Ingrese el calibre del material: ");
                elec.setCalibre(scan.nextInt());
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void ordenar() {
        Collections.sort(arregloElectricos);
    }
    
    
}
