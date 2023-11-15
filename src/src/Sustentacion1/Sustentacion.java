/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Sustentacion1;

import Modelo.Herrajes;
import Controlador.ControladorHerrajes;

/**
 *
 * @author David Reyes
 */
public class Sustentacion {
    public static void main(String[] args) {
        ControladorHerrajes ch = new ControladorHerrajes();
        
        //Guardando los productos
        Herrajes herr = new Herrajes("Puerta", "Cerradura", 409, "Plateado", "", "Revend", "Hierro",
                                          150, 1500, 5000, 500, 4);
        ch.insertar(herr);
        herr = new Herrajes("Puerta", "Candado", 225, "Dorado", "", "Alphat", "Acero",
                                          80, 5000, 10000, 500, 4);
        ch.insertar(herr);
        herr = new Herrajes("Mesa", "Tuercas", 756, "Plateado", "", "Fugaz", "Acero",
                                          150, 2000, 4000, 300, 4);
        ch.insertar(herr);
        herr = new Herrajes("Pared", "Chazos", 123, "Blanco", "", "Picpo", "Plastico",
                                          500, 500, 2000, 100, 4);
        ch.insertar(herr);
        
        //Ordenando los productos por id
        ch.ordenar();
        
        //Consultando un producto
        System.out.println("El producto consultado por id es:");
        System.out.println(ch.consultar(225));
        
        //Mostrar todos los productos por pantalla
        System.out.println("\nTodos los productos son:");
        ch.consultar();
    }
    
}