/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author David Reyes y Maria Paula Atehortua
 */
public class Producto implements Comparable<Producto>{
    private String nombre; 
    private int serial;
    private String color; 
    private String imagen; 
    private String marca;
    private String material; 
    private int demanda; 
    private float costo_Produccion; 
    private float precio_venta; 
    private float costo_almacenamiento; 
    private int Id_bodega ;

    //Constructores
    public Producto(String nombre, int serial, String color, String imagen, String marca, String material, int demanda, float costo_Produccion, float precio_venta, float costo_almacenamiento, int Id_bodega) {
        this.nombre = nombre;
        this.serial = serial;
        this.color = color;
        this.imagen = imagen;
        this.marca = marca;
        this.material = material;
        this.demanda = demanda;
        this.costo_Produccion = costo_Produccion;
        this.precio_venta = precio_venta;
        this.costo_almacenamiento = costo_almacenamiento;
        this.Id_bodega = Id_bodega;
    }

    public Producto() {
    }
    
    //Metodos Getter y Setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getDemanda() {
        return demanda;
    }

    public void setDemanda(int demanda) {
        this.demanda = demanda;
    }

    public float getCosto_Produccion() {
        return costo_Produccion;
    }

    public void setCosto_Produccion(float costo_Produccion) {
        this.costo_Produccion = costo_Produccion;
    }

    public float getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(float precio_venta) {
        this.precio_venta = precio_venta;
    }

    public float getCosto_almacenamiento() {
        return costo_almacenamiento;
    }

    public void setCosto_almacenamiento(float costo_almacenamiento) {
        this.costo_almacenamiento = costo_almacenamiento;
    }

    public int getId_bodega() {
        return Id_bodega;
    }

    public void setId_bodega(int Id_bodega) {
        this.Id_bodega = Id_bodega;
    }
    

    @Override
    public String toString() {
        return "Producto{" + "nombre=" + nombre + ", serial=" + serial + ", color=" + color + ", imagen=" + imagen + ", marca=" + marca + ", material=" + material + ", demanda=" + demanda + ", costo_Produccion=" + costo_Produccion + ", precio_venta=" + precio_venta + ", costo_almacenamiento=" + costo_almacenamiento + ", Id_bodega=" + Id_bodega + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        return this.serial == other.serial;
    }
    
    @Override
    public int compareTo(Producto o) {
        if(this.serial == o.serial )
            return 0;
        else if(this.serial > o.serial)
            return 1;
        else return -1;
    }
}
