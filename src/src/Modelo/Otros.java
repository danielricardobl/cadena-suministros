/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author David Reyes y Maria Paula Atehortua
 */
public class Otros extends Producto{
    private String descripcion;

    public Otros(String descripcion, String nombre, int serial, String color, String imagen, String marca, String material, int demanda, float costo_Produccion, float precio_venta, float costo_almacenamiento, int Id_bodega) {
        super(nombre, serial, color, imagen, marca, material, demanda, costo_Produccion, precio_venta, costo_almacenamiento, Id_bodega);
        this.descripcion = descripcion;
    }

    public Otros() {
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return super.toString() + " Otros{" + "descripcion=" + descripcion + '}';
    }
    
}
