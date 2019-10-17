
package bbdd;

import data.Comentario;
import data.Pelicula;
import data.Usuario;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.imageio.ImageIO;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;

/**
 *
 * @author saul
 */
public class peliculasDB {
    
    public static int insert(Pelicula peli) throws FileNotFoundException, IOException {
    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    PreparedStatement ps = null;

    String query = "INSERT INTO PELICULAS (titulo,sinopsis,genero, duracion,fichimagen,fechaestreno,reparto, director) VALUES (?, ?, ?, ?, ?, ? ,?, ?)";
    try {
        ps = connection.prepareStatement(query,
        Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, peli.getTitulo());
        byte[] b = peli.getSinopsis().getBytes("UTF-8");
        peli.setSinopsis(new String(b, "UTF-8"));

        ps.setString(2, peli.getSinopsis());
        ps.setString(3, peli.getGenero());
        ps.setDouble(4, peli.getDuracion());
        ps.setBlob(5, peli.getFichImagen().getInputStream());
        java.sql.Date fecha = new java.sql.Date(peli.getFechaEstreno().getYear(),peli.getFechaEstreno().getMonth(),peli.getFechaEstreno().getDay());
        ps.setDate(6,fecha);
        ps.setString(7, peli.getReparto());
        ps.setString(8, peli.getDirector());
        
        int res = 0;
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
        res = rs.getInt(1);
        } 
        rs.close();
        ps.close();
        pool.freeConnection(connection);
        return res;
    } 
    catch (SQLException e) {
        e.printStackTrace();
        return 0;
        }
    }
    
    public static boolean peliExists(String name) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT titulo FROM peliculas "
        + "WHERE titulo = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, name);
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
    
    public static Pelicula getPelicula(int id) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        System.out.println(id);
        String query = "SELECT * FROM peliculas WHERE IDPELICULA = " + id;
        System.out.println(query);
        try {
        ps = connection.prepareStatement(query,
        Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            String tit = (rs.getString("TITULO"));
            int duracion = (rs.getInt("DURACION"));
            String gen = (rs.getString("GENERO"));
            Date fecha = rs.getDate("fechaestreno");
            String sinopsis = (rs.getString("SINOPSIS"));
            int cartelera = (rs.getInt("cartelera"));   
            String reparto = (rs.getString("reparto"));
            String director = (rs.getString("director"));
            Pelicula peli = new Pelicula(id,tit,duracion,fecha,sinopsis,gen,cartelera,director,reparto);
            rs.close();
            return peli;
        }
        
        
        ps.close();
        pool.freeConnection(connection);
    } 
    catch (SQLException e) {
        e.printStackTrace();
        }
        return null;
    }
    
    public static ArrayList getDatos() {
    ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();

    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    PreparedStatement ps = null;
    String query ="SELECT * FROM peliculas";
    try {
        ps = connection.prepareStatement(query,
        Statement.RETURN_GENERATED_KEYS);
        int res = 0;
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
        res = rs.getInt(1);
        int idpeli = (rs.getInt("IDPELICULA"));
        String tit = (rs.getString("TITULO"));
        int duracion = (rs.getInt("DURACION"));
        String gen = (rs.getString("GENERO"));
        Date fecha = rs.getDate("fechaestreno");
        String sinopsis = (rs.getString("SINOPSIS"));
        int cartelera = (rs.getInt("cartelera"));   
        String reparto = (rs.getString("reparto"));
        String director = (rs.getString("director"));
        Pelicula peli = new Pelicula(idpeli,tit,duracion,fecha,sinopsis,gen,cartelera,director,reparto);
        peliculas.add(peli);
        } 
        ps.close();
        rs.close();
        pool.freeConnection(connection);
        return peliculas;
    } 
    catch (SQLException e) {
        e.printStackTrace();
        }
    return null;
    }
    
    
    public static ArrayList getDatosEstrenos() {
    ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();

    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    PreparedStatement ps = null;
    String query ="SELECT * FROM peliculas ORDER BY fechaestreno DESC FETCH FIRST 4 ROWS ONLY";
    try {
        ps = connection.prepareStatement(query,
        Statement.RETURN_GENERATED_KEYS);
        int res = 0;
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
        res = rs.getInt(1);
        int idpeli = (rs.getInt("IDPELICULA"));
        String tit = (rs.getString("TITULO"));
        int duracion = (rs.getInt("DURACION"));
        String gen = (rs.getString("GENERO"));
        Date fecha = rs.getDate("fechaestreno");
        String sinopsis = (rs.getString("SINOPSIS"));
        int cartelera = (rs.getInt("cartelera"));   
        String reparto = (rs.getString("reparto"));
        String director = (rs.getString("director"));
        Pelicula peli = new Pelicula(idpeli,tit,duracion,fecha,sinopsis,gen,cartelera,director,reparto);
        peliculas.add(peli);
        } 
        ps.close();
        rs.close();
        pool.freeConnection(connection);
        return peliculas;
    } 
    catch (SQLException e) {
        e.printStackTrace();
        }
    return null;
    }
    
    
    
    public static ArrayList getPeliculas() {
    ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();

    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    PreparedStatement ps = null;
    String query ="SELECT * FROM peliculas";
    try {
        ps = connection.prepareStatement(query,
        Statement.RETURN_GENERATED_KEYS);
        int res = 0;
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
        res = rs.getInt(1);
        int idpeli = (rs.getInt("IDPELICULA"));
        String tit = (rs.getString("TITULO"));
        int duracion = (rs.getInt("DURACION"));
        String gen = (rs.getString("GENERO"));
        Date fecha = rs.getDate("fechaestreno");
        String sinopsis = (rs.getString("SINOPSIS"));
        int cartelera = (rs.getInt("cartelera"));   
        String reparto = (rs.getString("reparto"));
        String director = (rs.getString("director"));
        Pelicula peli = new Pelicula(idpeli,tit,duracion,fecha,sinopsis,gen,cartelera,director,reparto);
        peliculas.add(peli);
        } 
        ps.close();
        rs.close();
        pool.freeConnection(connection);
        return peliculas;
    } 
    catch (SQLException e) {
        e.printStackTrace();
        }
    return null;
    }
    
     public static ArrayList getPeliculasCartelera() {
    ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();

    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    PreparedStatement ps = null;
    String query ="SELECT * FROM peliculas where cartelera=1";
    try {
        ps = connection.prepareStatement(query,
        Statement.RETURN_GENERATED_KEYS);
        int res = 0;
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
        res = rs.getInt(1);
        int idpeli = (rs.getInt("IDPELICULA"));
        String tit = (rs.getString("TITULO"));
        int duracion = (rs.getInt("DURACION"));
        String gen = (rs.getString("GENERO"));
        Date fecha = rs.getDate("fechaestreno");
        String sinopsis = (rs.getString("SINOPSIS"));
        int cartelera = (rs.getInt("cartelera"));   
        String reparto = (rs.getString("reparto"));
        String director = (rs.getString("director"));
        Pelicula peli = new Pelicula(idpeli,tit,duracion,fecha,sinopsis,gen,cartelera,director,reparto);
        peliculas.add(peli);
        } 
        ps.close();
        rs.close();
        pool.freeConnection(connection);
        return peliculas;
    } 
    catch (SQLException e) {
        e.printStackTrace();
        }
    return null;
    }
    
    public static ArrayList getComentarios(int idPeli) {
    ArrayList<Comentario> comentarios = new ArrayList<Comentario>();

    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    PreparedStatement ps = null;
    String query ="SELECT * FROM comentarios WHERE idpelicula = ? FETCH FIRST 5 ROWS ONLY";
            System.out.println("EJJEJEJEJE");

    try {
        ps = connection.prepareStatement(query,
        Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, idPeli);

        int res = 0;
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
        res = rs.getInt(1);
        
        int idUsuario = (rs.getInt("idusuario"));
        int idPelicula = (rs.getInt("idpelicula"));
        String comentario = (rs.getString("comentario"));
        
        Comentario c = new Comentario(idUsuario,idPelicula,comentario);
        System.out.println(c.getComentario());
        comentarios.add(c);
        } 
        ps.close();
        rs.close();
        pool.freeConnection(connection);
        return comentarios;
    } 
    catch (SQLException e) {

        e.printStackTrace();
        }
    return null;
    }
    
    
    
    
    public static boolean update(Pelicula p, Pelicula peli) throws IOException {
    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    System.out.println("HOLA updatePeli");
    PreparedStatement ps = null;
    String query = "";
    
    System.out.println(peli.getTitulo());
    System.out.println(peli.getSinopsis());
    System.out.println(peli.getGenero());
    System.out.println(peli.getDuracion());
    System.out.println(p.getId());
    
    int setimg = 0;
    if (peli.getFichImagen()!= null) {
        setimg = 1;
        query = "UPDATE PELICULAS SET titulo = ? , sinopsis = ? , genero = ? , duracion = ?, director = ?, reparto = ?, fichimagen = ?  WHERE idpelicula= ?";
    }
    else{
        query = "UPDATE PELICULAS SET titulo = ? , sinopsis = ? , genero = ? , duracion = ?, director = ?, reparto = ?  WHERE idpelicula= ?";
    }
    try {
        
        ps = connection.prepareStatement(query,
        Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, peli.getTitulo());
        ps.setString(2, peli.getSinopsis());
        ps.setString(3, peli.getGenero());
        ps.setDouble(4, peli.getDuracion());
        ps.setString(5, peli.getDirector());
        ps.setString(6, peli.getReparto());
        if (setimg != 1){
            
            ps.setInt(7, p.getId());
        }
        else{
            ps.setBlob(7, peli.getFichImagen().getInputStream());
            ps.setInt(8, p.getId());
        }
        if (peli.getTitulo() != null) 
            p.setTitulo(peli.getTitulo());
        
        if (peli.getSinopsis() != null) 
            p.setSinopsis(peli.getSinopsis());
        
        if (peli.getGenero() != null) 
            p.setGenero(peli.getGenero());
        
        if (peli.getDuracion()!= 0) 
             p.setDuracion(peli.getDuracion());
        
        if (peli.getReparto()!= null) 
            p.setReparto(peli.getReparto());
        
        if (peli.getDirector()!= null) 
            p.setDirector(peli.getDirector());
        
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
    
    public static void getImagen(String idpeli, OutputStream respuesta, String path) {
        try {
            ConnectionPool pool = ConnectionPool.getInstance();
            Connection connection = pool.getConnection();
            PreparedStatement statement = null;
            statement = connection.prepareStatement("SELECT FICHIMAGEN FROM PELICULAS WHERE IDPELICULA=? ");
            statement.setString(1, idpeli);
            System.out.println(idpeli);
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
                    String pathToImageSortBy = path + File.separator+ "peli.jpg";
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

    public static void updateCartelera(int idI, int carteleraI) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        System.out.println("HOLA updatePeli");
        PreparedStatement ps = null;
    
    
        
        
        String query = "UPDATE PELICULAS SET cartelera = ? WHERE idpelicula= ?";
        
        try {
            ps = connection.prepareStatement(query,
        Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, String.valueOf(carteleraI));
        ps.setString(2, String.valueOf(idI));
        
        ps.executeUpdate();
        
        ps.close();
        pool.freeConnection(connection);
        } catch (SQLException e) {
        e.printStackTrace();
        }

    
    
    }
    
    public static void clearCartelera() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
    
        
        String query = "UPDATE PELICULAS SET cartelera = 0";
        
        try {
            ps = connection.prepareStatement(query,
        Statement.RETURN_GENERATED_KEYS);
        
        ps.executeUpdate();
        
        ps.close();
        pool.freeConnection(connection);
        } catch (SQLException e) {
        e.printStackTrace();
        }

    
    
    }
    
    
   
}
