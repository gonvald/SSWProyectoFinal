/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author saul
 */
public class salaDB {
    
    
    public static int getFilas(int idsala){
        
        String query = "SELECT * FROM salas WHERE NUMSALA = ? and IDCINE = ?";
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
  
        PreparedStatement ps = null;
       
        try {
        ps = connection.prepareStatement(query,
        Statement.RETURN_GENERATED_KEYS);

    
       int filas = 0;
       
        ps.setInt(1,idsala);
        ps.setInt(2, 1);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
           filas = rs.getInt("NUMFILAS");
        }

        ps.close();
        rs.close();
        pool.freeConnection(connection);
        return filas;
    } 
    catch (SQLException e) {
        System.out.println("pesicoli");
        e.printStackTrace();
        }
        return 0;
    }
    
    
    public static int getColumas(int idsala){
        
        String query = "SELECT * FROM salas WHERE NUMSALA = ? and IDCINE = ?";
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
  
        PreparedStatement ps = null;
       
        try {
        ps = connection.prepareStatement(query,
        Statement.RETURN_GENERATED_KEYS);

    
       int columnas = 0;
       
        ps.setInt(1,idsala);
        ps.setInt(2, 1);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            columnas = rs.getInt("NUMCOLUMNAS");
        }

        ps.close();
        rs.close();
        pool.freeConnection(connection);
        return columnas;
    } 
    catch (SQLException e) {
        System.out.println("pesicoli");
        e.printStackTrace();
        }
        return 0;
    }
    
}
