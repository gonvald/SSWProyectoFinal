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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.MultipartConfig;
@MultipartConfig
public class AnadeCartelera extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,
    HttpServletResponse response)
    throws ServletException, IOException {
    String encoding = request.getCharacterEncoding();
    if (encoding==null) {
    request.setCharacterEncoding("UTF-8");
    }
        
    // get parameters from the request
    
    String[] cartelera = request.getParameterValues("cartelera");
    
    List list = Arrays.asList(cartelera);
    
    //LOS DE ESTA LISTA ESTAN ACTIVADOS, LOS DEMAS NO
    peliculasDB.clearCartelera();
    for (Object d : list) {
        System.out.println(d +"SIUUUUU?");
        peliculasDB.updateCartelera(Integer.parseInt(d.toString()), 1);
   }
    
    
    //String cartelera = request.getParameter("cartelera");
    String id = request.getParameter("id");
    // use regular Java classes
    //Usuario user = new Usuario(usuario, contrasena, email);




   
    /*int carteleraI;
    if("on".equals(cartelera)) {
        carteleraI = 1;
    } else {
        carteleraI = 0;
    }
    int idI = Integer.parseInt(id);
            System.out.println(carteleraI);*/

    
    //Modificar BD (Update) para cambiar cartelera
   // peliculasDB.updateCartelera(idI, carteleraI);
    
    String url = "/modCartelera.jsp";
    ArrayList<Pelicula> datos = peliculasDB.getPeliculas();
    request.setAttribute("lista", datos);
    //String url = "/index.jsp";
    // forward the request and response to the view
    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
    dispatcher.forward(request, response);
    }
}
