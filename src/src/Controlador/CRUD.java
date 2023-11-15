/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controlador;

/**
 *
 * @author David Reyes y Maria Paula Atehortua
 */
public interface CRUD {
    public boolean insertar(Object obj); //Create
    public String consultar(int id);//Read
    public void consultar();
    public boolean actualizar(int id); //Update
    public boolean borrar(int id);  //Delete
    public void ordenar();  //Delete

}
