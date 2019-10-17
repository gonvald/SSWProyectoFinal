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
import bbdd.entradasDB;
import bbdd.peliculasDB;
import data.Comentario;
import data.Entrada;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "Historial", urlPatterns = {"/Historial"})
public class Historial extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
    HttpServletResponse response)
    throws ServletException, IOException {
                String encoding = request.getCharacterEncoding();
    if (encoding==null) {
    request.setCharacterEncoding("UTF-8");
    }
    // get parameters from the request
    HttpSession session = request.getSession();
    Usuario user = (Usuario) session.getAttribute("user");

    ArrayList<Entrada> entradas = entradasDB.getEntradas(user.getIdUsuario());
    request.setAttribute("entradas", entradas);
    ArrayList nombresC = new ArrayList<String>();
        for (int i = 0; i < entradas.size(); i++) {
            Entrada e = (Entrada) entradas.get(i);
            data.Pelicula p = peliculasDB.getPelicula(e.getIdpelicula());
            
            nombresC.add(p.getTitulo());
        }
        request.setAttribute("nombresC",nombresC);
    System.out.println("MOÑECOOOOOOOOOo");
    // store the User object in the request object
    
    String url = "/historial.jsp";
    session.setAttribute("user", user);
       
    
    // forward the request and response to the view
    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
    dispatcher.forward(request, response);
    }
}
