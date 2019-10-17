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
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "ListaPelis", urlPatterns = {"/ListaPelis"})
public class ListaPelis extends HttpServlet {
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
    String idpeli = request.getParameter("id");
    System.out.println("el cristo de los gitanooooooooooooooooooooooooooos");
    // store the User object in the request object
    String url = "";
   //System.out.println(!idpeli.equals("-1"));
    if (!idpeli.equals("-1")){
    Pelicula p= peliculasDB.getPelicula(Integer.parseInt(idpeli));
   // System.out.println(p==null);
    //System.out.println(p.getTitulo());
         if (p == null) {
             //System.out.println("NULO");
            url = "/index.html";
         } else {
            url = "/editPeli.jsp";
            // store the user in the session
            ArrayList<Pelicula> datos = peliculasDB.getPeliculas();
            request.setAttribute("lista", datos);
            HttpSession session = request.getSession();
            request.setAttribute("pelicula", p);
            //System.out.println(p.getTitulo());
            }
    // forward the request and response to the view
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
        }
    else{
       Pelicula p= peliculasDB.getPelicula(Integer.parseInt(idpeli));
         System.out.println(p==null);
    //System.out.println(p.getTitulo());
        if (p == null) {
           // System.out.println("NULO");
            url = "/creaPeli.jsp";
        } else {
            url = "/creaPeli.jsp";
            // store the user in the session
            HttpSession session = request.getSession();
            request.setAttribute("pelicula", p);
           // System.out.println(p.getTitulo());
        }
    // forward the request and response to the view
    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
    dispatcher.forward(request, response);
        
    }
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // get parameters from the request
    // use regular Java classes
            String encoding = request.getCharacterEncoding();
    if (encoding==null) {
    request.setCharacterEncoding("UTF-8");
    }
    String idpeli = request.getParameter("id");
    // store the User object in the request object
    String url = "";
    Pelicula p= peliculasDB.getPelicula(Integer.parseInt(idpeli));
     System.out.println(p==null);
    if (p == null) {
        url = "/index.html";
    } else {
        url = "/editPeli.jsp";
        // store the user in the session
        HttpSession session = request.getSession();
        session.setAttribute("pelicula", p);
    }
    // forward the request and response to the view
    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
    dispatcher.forward(request, response);
    }
}