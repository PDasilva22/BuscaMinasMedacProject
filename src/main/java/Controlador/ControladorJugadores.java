/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Jugador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author usuario
 */
public class ControladorJugadores {
    
        private ConexionMySQL conexion=new ConexionMySQL("root","","buscaminas");

    public ControladorJugadores(ConexionMySQL conexion) {
        this.conexion = conexion;
    }
        
            public ArrayList<Jugador> ObtenerTodasPersonas() throws SQLException { // Va a devolver un ArrayList de Artículos
        ArrayList<Jugador> lista = new ArrayList<>();
        String consulta = "SELECT * FROM jugadores";
        ResultSet rset = conexion.ejecutarSelect(consulta);
        while (rset.next()) {
            String nombre = rset.getString("Nombre");
            int puntuacion = rset.getInt("Puntuacion");
            Date fecha = rset.getDate("Fecha");
            Jugador p = new Jugador(nombre);
            lista.add(p);
        }
                System.out.println(lista.toString());
        return lista;
    }
}
