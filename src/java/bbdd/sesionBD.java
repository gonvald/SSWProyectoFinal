/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbdd;

import data.Pelicula;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author saul
 */
public class sesionBD {
    
      
    
    public static ArrayList getFechas(int id) {
         ArrayList<LocalDate> fechas = new ArrayList<LocalDate>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "SELECT * FROM sesiones WHERE IDPELICULA = " + id;
        System.out.println(query);
        try {
        ps = connection.prepareStatement(query,
        Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            
            LocalDate fecha = rs.getDate("FECHAHORA").toLocalDate();
            System.out.println(fecha);
            if (!fechas.contains(fecha)){
                fechas.add(fecha);
            }
            
        }

        ps.close();
        rs.close();
        pool.freeConnection(connection);
        return fechas;
    } 
    catch (SQLException e) {
        System.out.println("pesicoli");
        e.printStackTrace();
        }
        return null;
    }
    
    public static ArrayList getHorario(String fecha , int id) throws ParseException {
        ArrayList<LocalTime> horas = new ArrayList<LocalTime>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
        System.out.println("holiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
        PreparedStatement ps = null;
        System.out.println("fechafirst "+fecha);
       // SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");
     
        String query = "SELECT * FROM sesiones WHERE FECHAHORA = ? and IDPELICULA = ?";
       
        System.out.println(query);
        
         SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parsed = format.parse(fecha);
        java.sql.Date sql = new java.sql.Date(parsed.getTime());
        
    

        try {
        ps = connection.prepareStatement(query,
        Statement.RETURN_GENERATED_KEYS);

       // ps.setDate(6,fecha);
        
        //Date date = java.sql.Date.valueOf(ld);
       // ps.setString(1,fecha);
       
       
        ps.setDate(1,java.sql.Date.valueOf(fecha));
        ps.setInt(2, id);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            LocalTime hora = rs.getTime("HORASESION").toLocalTime();
            if (!horas.contains(hora)){
              horas.add(hora);
            }
         
        }

        ps.close();
        rs.close();
        pool.freeConnection(connection);
        return horas;
    } 
    catch (SQLException e) {
        System.out.println("pesicoli");
        e.printStackTrace();
        }
        return null;
    }
    
    public static int getNumeroDeSala(String fecha , int id , String hora) throws ParseException{
        
  
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
  
        PreparedStatement ps = null;

     
        String query = "SELECT * FROM sesiones WHERE FECHAHORA = ? and IDPELICULA = ? and HORASESION = ?";
       
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parsed = format.parse(fecha);
        java.sql.Date sql = new java.sql.Date(parsed.getTime());
        
   
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        //long ms = sdf.parse(hora).getTime();
       // Time t = new Time(ms);
       hora=hora+":00";
       
        System.out.println("BAILA MORENA"+hora);
        System.out.println("BAILA BAILA BAILA"+java.sql.Time.valueOf(hora));
        
       // System.out.println("HORA ES "+t.toString());
    

        try {
        ps = connection.prepareStatement(query,
        Statement.RETURN_GENERATED_KEYS);

    
       int sala = 0;
       
        ps.setDate(1,java.sql.Date.valueOf(fecha));
        ps.setInt(2, id);
        ps.setTime(3, java.sql.Time.valueOf(hora));
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
           sala = rs.getInt("NUMSALA");
        }

        ps.close();
        rs.close();
        pool.freeConnection(connection);
        return sala;
    } 
    catch (SQLException e) {
        System.out.println("pesicoli");
        e.printStackTrace();
        }
        return 0;
    }
    
    
}
