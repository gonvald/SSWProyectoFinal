/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import bbdd.peliculasDB;
import data.Pelicula;
import data.Usuario;
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
public class ModCartelera extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     @Override
    protected void doGet(HttpServletRequest request,
    HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
         String url = "";
         ArrayList<Pelicula> datos = peliculasDB.getPeliculas();
        
         if (datos == null) {
        
        url = "/index.html";
        } else {
        url = "/modCartelera.jsp";
        // store the user in the session
        HttpSession session = request.getSession();
        Usuario user = (Usuario) session.getAttribute("user");
        request.setAttribute("lista", datos);
        session.setAttribute("user", user);
    }
    // forward the request and response to the view
    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
    dispatcher.forward(request, response);

    }
}
