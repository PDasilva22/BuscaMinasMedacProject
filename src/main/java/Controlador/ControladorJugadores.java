/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Jugador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class ControladorJugadores {

    private ConexionMySQL conexion;

    public ControladorJugadores(ConexionMySQL conexion) {
        this.conexion = conexion;
    }

    public ArrayList<Jugador> ObtenerTodasPersonas() throws SQLException { // Va a devolver un ArrayList de Jugadores
        ArrayList<Jugador> lista = new ArrayList<>();
        String consulta = "SELECT * FROM jugadores";
        ResultSet rset = conexion.ejecutarSelect(consulta);
        while (rset.next()) {
            String nombre = rset.getString("Nombre");
            int puntuacion = rset.getInt("Puntuacion");
            Date fecha = rset.getDate("Fecha");
            Jugador p = new Jugador(nombre, puntuacion, fecha);
            lista.add(p);
        }
        return lista;
    }

    /*Inserta jugador en la bbdd
            @param recibe al jugador por parametro*/
    public void insertarJugador(Jugador jActual) {

        //al insertar un jugador la fecha debe tener formato sql no formato java
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(jActual.getFecha());
        
        String consulta = "INSERT INTO jugadores (nombre, puntuacion, fecha) VALUES ('"
                + jActual.getNombre() + "', " + jActual.getPuntuacion() + ", '" + formattedDate + "')";

        try {
            this.conexion.ejecutarInsertDeleteUpdate(consulta);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorJugadores.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
