/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author David Reyes y Maria Paula Atehortua
 */
public class Herrajes extends Producto{
    private String tipo_elemento;

    public Herrajes(String tipo_elemento, String nombre, int serial, String color, String imagen, String marca, String material, int demanda, float costo_Produccion, float precio_venta, float costo_almacenamiento, int Id_bodega) {
        super(nombre, serial, color, imagen, marca, material, demanda, costo_Produccion, precio_venta, costo_almacenamiento, Id_bodega);
        this.tipo_elemento = tipo_elemento;
    }

    public Herrajes() {
    }

    public String getTipo_elemento() {
        return tipo_elemento;
    }

    public void setTipo_elemento(String tipo_elemento) {
        this.tipo_elemento = tipo_elemento;
    }

    @Override
    public String toString() {
        return super.toString() + " Herrajes{" + "tipo_elemento=" + tipo_elemento + '}';
    }
    
    
    
}
