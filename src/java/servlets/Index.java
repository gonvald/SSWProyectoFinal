/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import bbdd.peliculasDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author saul
 */
public class Index extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
    HttpServletResponse response)
    throws ServletException, IOException {
                String encoding = request.getCharacterEncoding();
    if (encoding==null) {
    request.setCharacterEncoding("UTF-8");
    }
    
    String idpeli = request.getParameter("id");
    System.out.println(idpeli);
    // store the User object in the request object
    String url = "";
   ArrayList<data.Pelicula> pelis = peliculasDB.getPeliculasCartelera();
    
    if (pelis == null) {
        System.out.println("NULO");
        url = "/index.jsp";
    } else {
        
        url = "/index.jsp";
        
        // store the user in the session
       
        HttpSession session = request.getSession();
        request.setAttribute("peliculas", pelis);
  
    }
    
    
    // forward the request and response to the view
    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
    dispatcher.forward(request, response);
    }

}
