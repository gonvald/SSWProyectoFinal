/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import data.Usuario;
import bbdd.UsuarioDB;
import bbdd.peliculasDB;
import data.Pelicula;
import java.util.ArrayList;

public class Peliculas extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
    HttpServletResponse response)
    throws ServletException, IOException {
    String encoding = request.getCharacterEncoding();
    if (encoding==null) {
    request.setCharacterEncoding("UTF-8");
    }
    // get parameters from the request
    // use regular Java classes
    
    // store the User object in the request object
    String url = "";
    ArrayList<Pelicula> datos = peliculasDB.getDatos();

    HttpSession session = request.getSession();
    Usuario user = (Usuario) session.getAttribute("user");
    if (datos == null) {
        
        url = "/index.html";
    } else {
        url = "/estrenos.jsp";
        // store the user in the session
        session.setAttribute("peliculas", datos);
        session.setAttribute("user", user);
    }
    // forward the request and response to the view
    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
    dispatcher.forward(request, response);
    
    }
}
