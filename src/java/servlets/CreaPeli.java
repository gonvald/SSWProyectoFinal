/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import data.Pelicula;
import bbdd.peliculasDB;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.MultipartConfig;
@MultipartConfig
public class CreaPeli extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,
    HttpServletResponse response)
    throws ServletException, IOException {
    // get parameters from the request
    
    String encoding = request.getCharacterEncoding();
    if (encoding==null) {
    request.setCharacterEncoding("UTF-8");
    }

        
    String titulo = request.getParameter("titulo");
    String sinopsis = request.getParameter("sinopsis");
    String genero = request.getParameter("genero");
    String duracion = request.getParameter("duracion");
    String fechaestreno = request.getParameter("fechaestreno");
    String director = request.getParameter("director");
    String reparto = request.getParameter("reparto");
    Part foto = request.getPart("imagenperfil");        
    // use regular Java classes
    //Usuario user = new Usuario(usuario, contrasena, email);
    

    
    Pelicula p = new Pelicula();
    p.setTitulo(titulo);
    p.setSinopsis(sinopsis);
    p.setGenero(genero);

    p.setDuracion(Double.parseDouble(duracion));
    p.setFichImagen(foto);
    p.setReparto(reparto);
    p.setDirector(director);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    java.util.Date date;
    date = null;
        try {
            date = sdf.parse(fechaestreno);
        } catch (ParseException ex) {
            Logger.getLogger(CreaPeli.class.getName()).log(Level.SEVERE, null, ex);
        }
    System.out.print(date.toString());
    p.setFechaEstreno(date);
    
   
    
    
    // store the User object in the request object
    String url = "";
    if (peliculasDB.peliExists(p.getTitulo())) {
        url = "/adminpage.jsp";
    } else {
        System.out.println("pito pito pito con canela");
        int id = peliculasDB.insert(p);
        p.setId(id);
         System.out.println("pito pito pito con asuucarr ");
        url = "/perfil.jsp";
        // store the user in the session
        request.setAttribute("pelicula", p);
    }
    // forward the request and response to the view
    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
    dispatcher.forward(request, response);
    }
}
