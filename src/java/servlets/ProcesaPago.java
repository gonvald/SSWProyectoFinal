/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import bbdd.entradasDB;
import bbdd.peliculasDB;
import bbdd.salaDB;
import bbdd.sesionBD;
import data.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
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
public class ProcesaPago extends HttpServlet {

    
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
     String fil = request.getParameter("fil");
     String col = request.getParameter("col");
     String sala = request.getParameter("sala");
   
     int fila =Integer.parseInt(fil);
     int columna = Integer.parseInt(col);
     int sal = Integer.parseInt(sala);
     HttpSession session = request.getSession();
     Usuario user = (Usuario) session.getAttribute("user");
   
   
     
     String url ="";
     
     Boolean rabadan = false;
     
     try{
        rabadan = entradasDB.entradaExists(pel, fecha, hora, fila, columna, sal);
     } catch (ParseException ex) {
            Logger.getLogger(sesionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     if (rabadan ==true){
         
        String i = request.getParameter("filas");
        String j = request.getParameter("columnas");
        
        int filas = Integer.parseInt(i);
        int columnas = Integer.parseInt(j);
         
        request.setAttribute("pelicula", pel);
        request.setAttribute("fech", fecha);
        request.setAttribute("hora", hora);
        request.setAttribute("sala", sal);
        request.setAttribute("filas", filas);
        request.setAttribute("columnas",columnas);
        url = "/seleccionarAsiento.jsp";
         
     }else{
        entradasDB.insert(user, pel, fecha, hora, fila, columna, sal);
        url = "/finPago.jsp";
     }
    

    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
    dispatcher.forward(request, response);
    }
    
    
    

}
