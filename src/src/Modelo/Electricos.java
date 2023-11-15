/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author David Reyes y Maria Paula Atehortua
 */
public class Electricos extends Producto{
    private int capacidad_carga;
    private int calibre;

    public Electricos(int capacidad_carga, int calibre, String nombre, int serial, String color, String imagen, String marca, String material, int demanda, float costo_Produccion, float precio_venta, float costo_almacenamiento, int Id_bodega) {
        super(nombre, serial, color, imagen, marca, material, demanda, costo_Produccion, precio_venta, costo_almacenamiento, Id_bodega);
        this.capacidad_carga = capacidad_carga;
        this.calibre = calibre;
    }

    public Electricos() {
    }

    public int getCapacidad_carga() {
        return capacidad_carga;
    }

    public void setCapacidad_carga(int capacidad_carga) {
        this.capacidad_carga = capacidad_carga;
    }

    public int getCalibre() {
        return calibre;
    }

    public void setCalibre(int calibre) {
        this.calibre = calibre;
    }

    @Override
    public String toString() {
        return super.toString() + " Electricos{" + "capacidad_carga=" + capacidad_carga + ", calibre=" + calibre + '}';
    }
    
    
}
