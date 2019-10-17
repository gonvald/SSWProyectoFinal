/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbdd;
import java.sql.*;
import data.*;
import java.io.IOException;
import javax.servlet.http.Part;

/**
 *
 * @author antooro
 */
public class ComentariosDB {
   
    
    public static boolean commentExists(int idpeli, int iduser) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM comentarios WHERE idpelicula = ? and idusuario = ?";
        try {
            ps = connection.prepareStatement(query,
            Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idpeli);
            ps.setInt(2, iduser);
            System.out.println(query);
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
    
    
    public static int insert(Usuario user, Pelicula p, String v) {
    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    PreparedStatement ps = null;
    PreparedStatement ps1 = null;
    
    //String query = "MERGE INTO votos AS v USING (SELECT (idusuario, idpelicula, nota) FROM TABLE  VALUES (?, ?, ?, ?) ) AS vt(id, val) ON (mt.id = vt.id) WHEN MATCHED THEN UPDATE SET val = vt.val WHEN NOT MATCHED THEN INSERT (id, val) VALUES (vt.id, vt.val)";
    String query = "INSERT INTO comentarios (idusuario, idpelicula, comentario) VALUES (?, ?, ?)";
    
    try {
       
        
        ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, Integer.toString(user.getIdUsuario()));
        ps.setString(2, Integer.toString(p.getId()));
        ps.setString(3, (v));
        
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
    
    public static int update(Usuario user, Pelicula p, String v) {
    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    PreparedStatement ps = null;
    String query = "UPDATE comentarios SET comentario = ? WHERE idusuario = ? AND idpelicula = ?";
    try {
        ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ps.setString(2, Integer.toString(user.getIdUsuario()));
        ps.setString(3, Integer.toString(p.getId()));
        ps.setString(1,v);
        ps.executeUpdate();
        //int res = 0;
        //ResultSet rs = ps.getGeneratedKeys();
        //if (rs.next()) {
        //res = rs.getInt(1);
        //} 
        ps.close();
        pool.freeConnection(connection);
        return 1;
    } 
    catch (SQLException e) {
        e.printStackTrace();
        return 0;
        }
    }
    
    
    
}
