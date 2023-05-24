/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.TimeZone;

/**
 *
 * @author usuario
 */
public class ConexionMySQL {
       private String BD;
    private String usuario;
    private String pass;
    private Connection connection;
    private String host;
    private TimeZone zonaHoraria;

    public ConexionMySQL( String usuario, String pass,String BD) {
        this.BD = BD;
        this.usuario = usuario;
        this.pass = pass;
       host="localhost";
       connection=null;
    }
       public void conectar() throws SQLException,ClassNotFoundException{
        if(connection==null||connection.isClosed()){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Calendar now = Calendar.getInstance();
                zonaHoraria=now.getTimeZone();
                connection = (Connection)DriverManager.getConnection("jdbc:mysql://"+host+"/"+BD+"?user="+usuario+"&password="+pass+"&userLegacyDateTimeCode=false&serverTimeZone="+zonaHoraria.getID());
                System.out.println("conectado a la clase");
            }catch(ClassNotFoundException e){
                System.out.println("No se encuentra la clase");
            }
        }
    }
       public void desconectar() throws SQLException{
    if(connection!=null && !connection.isClosed()){
        connection.close();
        System.out.println("Estas desconectado de la base de datos");
    }
}
       public ResultSet ejecutarSelect(String consulta) throws SQLException{
           Statement stmt=connection.createStatement();
           ResultSet rset=stmt.executeQuery(consulta);
           return rset;
       }
    public int ejecutarInsertDeleteUpdate(String consulta) throws SQLException{
        Statement stmt=connection.createStatement();
        int fila=stmt.executeUpdate(consulta);
        return fila;
    }
}
