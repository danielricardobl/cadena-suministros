/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import Modelo.Trabajador;

/**
 *
 * @author David Reyes y Maria Paula Atehortua
 */
public class ControladorTrabajador implements CRUD{
    public static ArrayList<Trabajador> arregloTrabajador = new ArrayList<>();
    public Scanner scan = new Scanner(System.in);
    
    @Override
    public boolean insertar(Object obj) {
        Trabajador user = (Trabajador) obj;
        if(arregloTrabajador.isEmpty()){
            arregloTrabajador.add(user);
            return true;
        }
        else{
            for(Trabajador t: arregloTrabajador){
                if(t.equals(user))
                    return false;
            }
            arregloTrabajador.add(user);
            return true;
        }
    }

    @Override
    public String consultar(int id) {
        ordenar();
        int i = 0, f=arregloTrabajador.size()-1, m;
        while(i <= f){
            m = (i+f)/2;
            if (id == arregloTrabajador.get(m).getId()){
                return arregloTrabajador.get(m).toString();
            } else if(id > arregloTrabajador.get(m).getId()){
                i = m+1;
                
            } else{
                f = m-1;
            }
        }
        return "No se encontro el Usuario.";
    }

    @Override
    public void consultar() {
        for(Trabajador user : arregloTrabajador){
            System.out.println(user.toString());
        }   
            
    }

    

    @Override
    public boolean borrar(int id) {
        for(Trabajador user : arregloTrabajador){
            if(id == user.getId()){
                return arregloTrabajador.remove(user);
            }
        }
        return false;
    }
    
    @Override
    public boolean actualizar(int id){
        for(Trabajador user : arregloTrabajador){
            if(id == user.getId()){
                System.out.println("Ingrese el nuevo telefono de "+user.getNombre()+": ");
                user.setTelefono(scan.next());
                System.out.println("Ingrese la nueva direccion de "+user.getNombre()+": ");
                user.setDireccion(scan.next());
                System.out.println("Ingrese el nuevo correo electronico de "+user.getNombre()+": ");
                user.setCorreo(scan.next());
                System.out.println("Ingrese el nuevo sueldo de "+user.getNombre()+": ");
                user.setSueldo(scan.next());
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void ordenar() {
        Collections.sort(arregloTrabajador);
    }

}
