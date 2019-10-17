/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import bbdd.peliculasDB;
import bbdd.salaDB;
import bbdd.sesionBD;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class SelecAsiento extends HttpServlet {

    

 @Override
    protected void doPost(HttpServletRequest request,
    HttpServletResponse response)
    throws ServletException, IOException {
                String encoding = request.getCharacterEncoding();
    if (encoding==null) {
    request.setCharacterEncoding("UTF-8");
    }
    
     String d = request.getParameter("idp");
     int id = Integer.parseInt(d);
     data.Pelicula pel = (data.Pelicula) peliculasDB.getPelicula(id);
     request.setAttribute("pelicula", pel);
     String fecha = request.getParameter("fecha");
     String hora = request.getParameter("hora");
     int sala= 0;
     try{
        sala = sesionBD.getNumeroDeSala(fecha, id, hora);
        System.out.println("LA SALA ES" + sala);
     } catch (ParseException ex) {
            Logger.getLogger(sesionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     int columnas = salaDB.getColumas(sala);
     int filas = salaDB.getFilas(sala);
     
     String url ="";
     
      if (pel == null) {
        System.out.println("NULO");
        url = "/index.jsp";
    } else {
        
        url = "/seleccionarAsiento.jsp";
        
        // store the user in the session
       
        HttpSession session = request.getSession();
        request.setAttribute("pelicula", pel);
        request.setAttribute("fech", fecha);
        request.setAttribute("hora", hora);
        request.setAttribute("sala", sala);
        request.setAttribute("filas", filas);
        request.setAttribute("columnas",columnas);
    }
    
    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
    dispatcher.forward(request, response);
    }
    
    
    

}
