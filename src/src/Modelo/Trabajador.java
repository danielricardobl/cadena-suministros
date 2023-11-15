/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author David Reyes y Maria Paula Atehortua
 */
public class Trabajador extends Usuario{
    private String fecha_ingreso;
    private String sueldo;

    public Trabajador(String fecha_ingreso, String sueldo, String nombre, String apellido, int id, String telefono, String direccion, String correo, String fecha_nacimiento, String tipo_usuario) {
        super(nombre, apellido, id, telefono, direccion, correo, fecha_nacimiento, tipo_usuario);
        this.fecha_ingreso = fecha_ingreso;
        this.sueldo = sueldo;
    }

    public Trabajador(String fecha_ingreso, String sueldo) {
        this.fecha_ingreso = fecha_ingreso;
        this.sueldo = sueldo;
    }

    public Trabajador() {
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getSueldo() {
        return sueldo;
    }

    public void setSueldo(String sueldo) {
        this.sueldo = sueldo;
    }
    
    @Override
    public String toString() {
        return super.toString() + "Trabajador{" + "fecha_ingreso=" + fecha_ingreso + ", sueldo=" + sueldo + '}';
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
        final Trabajador other = (Trabajador) obj;
        return this.getId() == other.getId();
    }

}
