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
import bbdd.ValoracionesDB;
import bbdd.peliculasDB;
import bbdd.sesionBD;
import data.Comentario;
import data.Pelicula;
import data.Valoracion;
import java.util.ArrayList;

public class Valorar extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,
    HttpServletResponse response)
    throws ServletException, IOException {
                String encoding = request.getCharacterEncoding();
    if (encoding==null) {
    request.setCharacterEncoding("UTF-8");
    }
    // get parameters from the request
    HttpSession session = request.getSession();
    //Pelicula pel = (Pelicula) request.getAttribute("pelicula");
    Usuario user = (Usuario) session.getAttribute("user");
     String d = request.getParameter("idpeli");
     int id = Integer.parseInt(d);
     Pelicula pel = (Pelicula) peliculasDB.getPelicula(id);
     request.setAttribute("pelicula", pel);
     
    String rate = request.getParameter("rate");
    
     System.out.println("Valorando peli");
    
    // use regular Java classes
    //Usuario user = new Usuario(usuario, contrasena, email);
    
    // store the User object in the request object
    String url = "";
    if (user!=null && UsuarioDB.loginCorrecto(user.getNombreUsuario(), user.getContrasena())) {
        Valoracion v = new Valoracion(user.getIdUsuario(),pel.getId(),Integer.parseInt(rate));
        System.out.println(rate);
        //System.out.println(pel.getId());
        //System.out.println(user.getIdUsuario());
        
        //INSERTAR LA VALORACION EN LA DDBB
        if(ValoracionesDB.votoExists(pel.getId(), user.getIdUsuario())) {
            System.out.println("Valorando peli: actualizando BD");
            ValoracionesDB.update(user, pel, v);
        } else {
            ValoracionesDB.insert(user, pel, v);
        }
        
       request.setAttribute("valor", Integer.parseInt(rate));
        url = "/pelicula_1.jsp";
        // store the user in the session
        session.setAttribute("user", user);
        
        request.setAttribute("pelicula", pel);
        ArrayList comentario = peliculasDB.getComentarios(Integer.parseInt( d ));
        request.setAttribute("comentarios", comentario);
        
        ArrayList nombresC = new ArrayList<String>();
        for (int i = 0; i < comentario.size(); i++) {
            Comentario c = (Comentario) comentario.get(i);
            String nombreU = UsuarioDB.getUsername(c.getIdUsuario());
            nombresC.add(nombreU);
        }
        request.setAttribute("nombresC",nombresC);
        
        double nota = ValoracionesDB.getNotaMedia(pel.getId());
        request.setAttribute("nota", nota);
        ArrayList fechas = sesionBD.getFechas(Integer.parseInt(d));
        request.setAttribute("fechas", fechas);
    }
    else{
        url = "/login.html";
        session.setAttribute("user", user);
    }
    // forward the request and response to the view
    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
    dispatcher.forward(request, response);
    }
}
