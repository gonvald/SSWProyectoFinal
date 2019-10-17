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
public class ValoracionesDB {
    
    public static int getVoto(int idpeli, int iduser) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM votos WHERE idpelicula = ? and idusuario = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, idpeli);
            ps.setInt(2, iduser);
            rs = ps.executeQuery();
            boolean res = rs.next();
            int n = rs.getInt("NOTA");
            rs.close();
            ps.close();
            pool.freeConnection(connection);
            return n;
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
    
    public static double getNotaMedia(int idpeli) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM votos WHERE idpelicula = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, idpeli);
            rs = ps.executeQuery();
            double res = 0;
            int contador = 0;
            while (rs.next()) {
                res = res + (rs.getInt("NOTA"));
                contador++;
            }
            if(contador!=0) res = res/contador;
            
            
            rs.close();
            ps.close();
            pool.freeConnection(connection);
            return res;
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
    
    
    public static boolean votoExists(int idpeli, int iduser) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM votos WHERE idpelicula = ? and idusuario = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, idpeli);
            ps.setInt(2, iduser);
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
    
    
    public static int insert(Usuario user, Pelicula p, Valoracion v) {
    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    PreparedStatement ps = null;
    PreparedStatement ps1 = null;
    //String query = "MERGE INTO votos AS v USING (SELECT (idusuario, idpelicula, nota) FROM TABLE  VALUES (?, ?, ?, ?) ) AS vt(id, val) ON (mt.id = vt.id) WHEN MATCHED THEN UPDATE SET val = vt.val WHEN NOT MATCHED THEN INSERT (id, val) VALUES (vt.id, vt.val)";
    String query = "INSERT INTO VOTOS (idusuario, idpelicula, nota) VALUES (?, ?, ?)";
    //String query = "INSERT INTO VOTOS (idusuario, idpelicula, nota) VALUES (" + user.getIdUsuario() + "," + p.getId() + "," + v.getNota() + ") ON DUPLICATE KEY UPDATE";
    //String query = "INSERT INTO USUARIOS (nombre,nombreUsuario,contrasena, eMail) VALUES (?, ?, ?, ?)";
    String query1 = "SELECT * FROM VOTOS WHERE IDUSUARIO=? AND IDPELICULA=?";
    
    try {
        /*ps1 = connection.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
        ps1.setString(1, Integer.toString(user.getIdUsuario()));
        ps1.setString(2, Integer.toString(p.getId()));
        ps1.executeUpdate();
        ResultSet rs1 = ps1.getGeneratedKeys();
        if (!rs1.next()) {
            String query = "INSERT INTO VOTOS (idusuario, idpelicula, nota) VALUES (?, ?, ?)";
            ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, Integer.toString(user.getIdUsuario()));
            ps.setString(2, Integer.toString(p.getId()));
            ps.setString(3, Integer.toString(v.getNota()));
            System.out.println(query1);

        } else {
            String query = "\"UPDATE VOTOS SET nota = ?";
            ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, Integer.toString(v.getNota()));
            System.out.println(query1);
        }*/
        
        ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, Integer.toString(user.getIdUsuario()));
        ps.setString(2, Integer.toString(p.getId()));
        ps.setString(3, Integer.toString(v.getNota()));
        
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
    
    public static int update(Usuario user, Pelicula p, Valoracion v) {
    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    PreparedStatement ps = null;
    String query = "UPDATE VOTOS SET nota = ? WHERE idusuario = ? AND idpelicula = ?";
    try {
        ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ps.setString(2, Integer.toString(user.getIdUsuario()));
        ps.setString(3, Integer.toString(p.getId()));
        ps.setString(1, Integer.toString(v.getNota()));
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
