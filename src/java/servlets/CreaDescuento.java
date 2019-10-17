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
public class CreaDescuento extends HttpServlet {
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
         
    // use regular Java classes
    //Usuario user = new Usuario(usuario, contrasena, email);
    /*Descuento d = new Descuento();
    p.setTitulo(titulo);
    p.setSinopsis(sinopsis);
    p.setGenero(genero);
        System.out.println(titulo);
    p.setDuracion(Double.parseDouble(duracion));
    p.setFichImagen(foto);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    java.util.Date date;
    date = null;
        try {
            date = sdf.parse(fechaestreno);
        } catch (ParseException ex) {
            Logger.getLogger(CreaPeli.class.getName()).log(Level.SEVERE, null, ex);
        }
    p.setFechaEstreno(date);
    p.setValoracion(Double.parseDouble(nota));
    
    
    // store the User object in the request object
    String url = "";
    if (peliculasDB.peliExists(p.getTitulo())) {
        url = "/adminpage.jsp";
    } else {
       

        
        int id = peliculasDB.insert(p);
        p.setId(id);
        url = "/perfil.jsp";
        // store the user in the session
        HttpSession session = request.getSession();
        session.setAttribute("pelicula", p);
    }
    // forward the request and response to the view
    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
    dispatcher.forward(request, response);*/
    }
}
