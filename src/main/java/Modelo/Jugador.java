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

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntuacion = 0;
        this.fecha = new Date();
    }

    public Jugador(String nombre, int puntuacion, Date fecha) {
        this.nombre = nombre;
        this.puntuacion = puntuacion;
        this.fecha = fecha;
    }
    
    

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", puntuacion=" + puntuacion + ", fecha=" + fecha + '}';
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
