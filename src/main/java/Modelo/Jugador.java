/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;

 /**
 *
 * @author Pato

*/



public class Jugador {
    
    private String nombre;
    private int puntuacion;
    private Date fecha;

    //Este es el constructor basico que se utiliza en el codigo
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntuacion = 500;
        this.fecha = new Date();
    }

    //Este constructor con sobrecarga es para poder extraer los datos de la BBDD
    public Jugador(String nombre, int puntuacion, Date fecha) {
        this.nombre = nombre;
        this.puntuacion = puntuacion;
        this.fecha = fecha;
    }
    
    

    @Override
    public String toString() {
        return "Jugador{" + "nombre =" + nombre + ", puntuacion=" + puntuacion + ", fecha=" + fecha + '}';
    }
    

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the puntuacion
     */
    public int getPuntuacion() {
        return puntuacion;
    }

    /**
     * @param puntuacion the puntuacion to set
     */
    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
     
    
    
}
