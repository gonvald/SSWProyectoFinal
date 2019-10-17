/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbdd;
import static com.sun.javafx.scene.CameraHelper.project;
import java.sql.*;
import data.Usuario;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.imageio.ImageIO;
import javax.servlet.http.Part;
import javax.swing.ImageIcon;
import javax.tools.FileObject;
import org.apache.derby.iapi.services.io.FileUtil;
import org.apache.tomcat.util.http.fileupload.IOUtils;

/**
 *
 * @author antooro
 */
public class UsuarioDB {
    public static int insert(Usuario user,String path) throws FileNotFoundException, IOException {
    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    PreparedStatement ps = null;
    //String pathToImageSortBy = "nameOfProject/resources/testDataIcons/filling.png";
   
    

    
    //String pathToImageSortBy = "nameOfProject/resources/testDataIcons/filling.png";
    //String pathToImageSortBy = "C:\\Users\\antooro\\Documents\\NetBeansProjects\\proyectossw\\ProyectoSSW\\Imagenes\\user.png";
    String pathToImageSortBy = path + File.separator+ "user.png";
    File imgfile = new File(pathToImageSortBy);
    FileInputStream fin = new FileInputStream(imgfile);
    String query = "INSERT INTO USUARIOS (nombre,nombreUsuario,contrasena, eMail,fichimagen) VALUES (?, ?, ?, ?, ?)";
    try {
        ps = connection.prepareStatement(query,
        Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, user.getNombre());
        ps.setString(2, user.getNombreUsuario());
        ps.setString(3, user.getContrasena());
        ps.setString(4, user.getEmail());
        ps.setBinaryStream(5, fin,(int) imgfile.length());
        
        int res = 0;
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
        res = rs.getInt(2);
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
    
    
    public static boolean emailExists(String emailAddress) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT eMail FROM usuarios "
        + "WHERE eMail = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, emailAddress);
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
    public static boolean loginCorrecto(String nombreUsuario, String password) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM usuarios WHERE nombreUsuario = ? and contrasena=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, nombreUsuario);
            ps.setString(2, password);
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
    public static boolean usernameExists(String username) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT nombreUsuario FROM usuarios "
        + "WHERE nombreUsuario = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
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
    
    public static void getDatos(Usuario user) {
    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    PreparedStatement ps = null;
    String query ="SELECT * FROM usuarios "
        + "WHERE nombreUsuario = ?";
    try {
        ps = connection.prepareStatement(query,
        Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, user.getNombreUsuario());
        int res = 0;
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
        res = rs.getInt(1);
        user.setEmail(rs.getString("EMAIL"));
        user.setNombre(rs.getString("NOMBRE"));
        user.setTelefono(rs.getInt("TELEFONO"));
        user.setAdmin(rs.getInt("TIPOUSUARIO"));
        user.setIdUsuario(Integer.parseInt(rs.getString("IDUSUARIO")));
        } 
        
        rs.close();
        ps.close();
        pool.freeConnection(connection);
        
    } 
    catch (SQLException e) {
        e.printStackTrace();
        }
    }
    
    public static boolean update(Usuario user, Usuario user2) throws IOException {
    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    PreparedStatement ps = null;
    String query = "";
    int setimg = 0;
    if (user2.getFichImagen()!= null) {
        setimg = 1;
        query = "UPDATE USUARIOS SET nombre = ? , nombreUsuario = ? , eMail = ? , telefono = ?,fichimagen=? WHERE idusuario = ?";
    }
    else{
        query = "UPDATE USUARIOS SET nombre = ? , nombreUsuario = ? , eMail = ? , telefono = ? WHERE idusuario = ?";
    }
    try {
        
        ps = connection.prepareStatement(query,
        Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, user2.getNombre());
        ps.setString(2, user2.getNombreUsuario());
        ps.setString(3, user2.getEmail());
        ps.setString(4, Integer.toString(user2.getTelefono()));
        if (setimg==1){
        ps.setBlob(5, user2.getFichImagen().getInputStream());
        ps.setString(6, Integer.toString(user.getIdUsuario()));
        }
        else{
        ps.setString(5, Integer.toString(user.getIdUsuario()));
        }
        if (user2.getEmail() != null) 
            user.setEmail(user2.getEmail());
        
        if (user2.getNombre() != null) 
            user.setNombre(user2.getNombre());
        
        if (user2.getNombreUsuario() != null) 
            user.setNombreUsuario(user2.getNombreUsuario());
        
        if (user2.getTelefono()!= 0) 
            user.setTelefono(user2.getTelefono());
        

        ps.executeUpdate();
        
        ps.close();
        pool.freeConnection(connection);
        return true;
        
    } 
    catch (SQLException e) {
        e.printStackTrace();
        return false;
        }
    }
    
    
    public static void getImagen(String username, OutputStream respuesta, String path) {
        try {
            ConnectionPool pool = ConnectionPool.getInstance();
            Connection connection = pool.getConnection();
            PreparedStatement statement = null;
            statement = connection.prepareStatement("SELECT FICHIMAGEN FROM USUARIOS WHERE NOMBREUSUARIO=? ");
            statement.setString(1, username);
            System.out.println(username);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                Blob blob = result.getBlob("fichimagen");
                if (!result.wasNull() && blob.length() > 1) {
                    InputStream imagen = blob.getBinaryStream();
                    byte[] buffer = new byte[1000];
                    int len = imagen.read(buffer);
                    while (len != -1) {
                        respuesta.write(buffer, 0, len);
                        len = imagen.read(buffer);
                    }
                    imagen.close();
                }
                 else{
                    
                    String pathToImageSortBy = path + File.separator+ "user.png";
                    File imgfile = new File(pathToImageSortBy);
                    FileInputStream ip = new FileInputStream(imgfile);
                    IOUtils.copy(ip,respuesta);

                    //bArray = FileUtils.readFileToByteArray(imgfile);
                    
                }
                
           }
            result.close();
            statement.close();
            pool.freeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public static String getUsername(int iduser) {
    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    PreparedStatement ps = null;
    String nuser = "";
    String query ="SELECT nombreusuario FROM usuarios WHERE idusuario = ?";
    try {
        ps = connection.prepareStatement(query,
        Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, iduser);
        int res = 0;
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
        nuser =  (rs.getString("nombreusuario"));
        } 
        rs.close();
        ps.close();
        pool.freeConnection(connection);
        return nuser;
    } 
    catch (SQLException e) {
        e.printStackTrace();
        }
    return null;
    }
    
    
    
}
