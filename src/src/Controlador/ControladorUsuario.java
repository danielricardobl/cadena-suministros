/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import Modelo.Usuario;

/**
 *
 * @author David Reyes
 */
public class ControladorUsuario implements CRUD{
    public static ArrayList<Usuario> arregloUsuarios = new ArrayList<>();
    public Scanner scan = new Scanner(System.in);
    
    @Override
    public boolean insertar(Object obj) { 
        Usuario user = (Usuario) obj;
        if(arregloUsuarios.isEmpty()){
            arregloUsuarios.add(user);
            return true;
        }
        else{
            for(Usuario u: arregloUsuarios){
                if(u.equals(user))
                    return false;
            }
            arregloUsuarios.add(user);
            return true;
        }
    }

    @Override
    public String consultar(int id) {
        ordenar();
        int i = 0, f=arregloUsuarios.size()-1, m;
        while(i <= f){
            m = (i+f)/2;
            if (id == arregloUsuarios.get(m).getId()){
                return arregloUsuarios.get(m).toString();
            } else if(id > arregloUsuarios.get(m).getId()){
                i = m+1;
            } else{
                f = m-1;
            }
        }
        return "No se encontro el Usuario.";
    }
    
    public Usuario retornarUsuario(int id) {
        ordenar();
        int i = 0, f=arregloUsuarios.size()-1, m;
        while(i <= f){
            m = (i+f)/2;
            if (id == arregloUsuarios.get(m).getId()){
                return arregloUsuarios.get(m);
            } else if(id > arregloUsuarios.get(m).getId()){
                i = m+1;
            } else{
                f = m-1;
            }
        }
        return null;
    }

    @Override
    public void consultar() {
        for(Usuario user : arregloUsuarios){
            System.out.println(user.toString());
        }   
            
    }

    @Override
    public boolean borrar(int id) {
        for(Usuario user : arregloUsuarios){
            if(id == user.getId()){
                return arregloUsuarios.remove(user);
            }
        }
        return false;
    }
    
    @Override
    public boolean actualizar(int id){
        for(Usuario user : arregloUsuarios){
            if(id == user.getId()){
                System.out.println("Ingrese el nuevo telefono de "+user.getNombre()+": ");
                user.setTelefono(scan.next());
                System.out.println("Ingrese la nueva direccion de "+user.getNombre()+": ");
                user.setDireccion(scan.next());
                System.out.println("Ingrese el nuevo correo electronico de "+user.getNombre()+": ");
                user.setCorreo(scan.next());
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void ordenar() {
        Collections.sort(arregloUsuarios);
    }

}
