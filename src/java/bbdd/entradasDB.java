/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbdd;

import data.Entrada;
import data.Pelicula;
import data.Usuario;
import data.Valoracion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author saul
 */
public class entradasDB {
    
public static int insert(Usuario user, Pelicula p,String fecha,String hora,int fila , int columna,int numSala) {
    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    PreparedStatement ps = null;
    PreparedStatement ps1 = null;
 
    String query = "INSERT INTO ENTRADAS(idcine, fila, columna,precio,idpelicula,fechahora,horaSesion,idusuario,numsala) VALUES (?,?,?,?,?,?,?,?,?)";

    try {
       
        
        ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ps.setString(8, Integer.toString(user.getIdUsuario()));
        ps.setString(5, Integer.toString(p.getId()));
        ps.setString(1,"1");
        ps.setString(2,Integer.toString(fila));
        ps.setString(3,Integer.toString(columna));
        ps.setString(4,Integer.toString(5));
        ps.setString(9, Integer.toString(numSala));
        ps.setString(6,fecha);
        ps.setString(7, hora);
        
        ps.executeUpdate();
        int res = 0;
        
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
        res = rs.getInt(1);
        } 
        ps.close();
        pool.freeConnection(connection);
        return res;
    } 
    catch (SQLException e) {
        e.printStackTrace();
        return 0;
        }
    }

   public static boolean entradaExists(Pelicula p,String fecha,String hora,int fila , int columna,int numSala) throws ParseException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM entradas WHERE idcine = ? and fila = ? and columna = ?  and  idpelicula = ? and fechahora = ? and horaSesion = ? and numsala = ? " ;
        try {
            ps = connection.prepareStatement(query);
            
            System.out.println("----------------------------------------------------------------------------");
            System.out.println(fila);
             System.out.println(p.getId());
              System.out.println(columna);
              System.out.println(numSala);
              System.out.println(fecha);
                  System.out.println(hora);
              System.out.println(java.sql.Date.valueOf(fecha));
              hora = hora+":00";
                  System.out.println(java.sql.Time.valueOf(hora));
              System.out.println("----------------------------------------------------------------------------");
            
            ps.setInt(4, p.getId());
            ps.setInt(1,1);
            ps.setInt(2,fila);
            ps.setInt(3,columna);
            ps.setInt(7, numSala);
            ps.setDate(5,java.sql.Date.valueOf(fecha));
            ps.setTime(6, java.sql.Time.valueOf(hora));
            
            rs = ps.executeQuery();
            
           
            boolean res = rs.next();
            rs.close();
            ps.close();
            pool.freeConnection(connection);
            return res;
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
   
    public static ArrayList getEntradas(int id) {
        ArrayList<Entrada> entradas = new ArrayList<Entrada>();
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        System.out.println(id);
        String query = "SELECT * FROM entradas WHERE idusuario = " + id;
        System.out.println(query);
        try {
        ps = connection.prepareStatement(query,
        Statement.RETURN_GENERATED_KEYS);
        int res = 0;
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
        res = rs.getInt(1);
        int idcine = (rs.getInt("idcine"));
            int idpelicula = (rs.getInt("idpelicula"));
            int fila = (rs.getInt("fila"));
            int columna = (rs.getInt("columna"));
            Date fecha = rs.getDate("fechahora");
            Time hora = (rs.getTime("horasesion"));
            double precio = rs.getDouble("precio");
            int numsala = (rs.getInt("numsala"));  
            Entrada entrada = new Entrada(idcine,  fila,  columna,  precio,  idpelicula,  id ,  numsala, fecha, hora);
            entradas.add(entrada);
        } 
        ps.close();
        rs.close();
        pool.freeConnection(connection);
        return entradas;
    } 
    catch (SQLException e) {
        e.printStackTrace();
        }
        return null;
    }
   
}
    
    