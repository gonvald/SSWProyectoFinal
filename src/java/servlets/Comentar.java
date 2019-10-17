/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;
import bbdd.ComentariosDB;
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
import java.util.ArrayList;

public class Comentar extends HttpServlet {
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
    Usuario user = (Usuario) session.getAttribute("user");
    String d = request.getParameter("idpeli");
    int id = Integer.parseInt(d);
    System.out.println(user.getNombreUsuario());
    System.out.println("COMO PUEDE SER");
    Pelicula pel = (Pelicula) peliculasDB.getPelicula(id);
    int valor = ValoracionesDB.getVoto(pel.getId(),user.getIdUsuario());
    double nota = ValoracionesDB.getNotaMedia(pel.getId());
    request.setAttribute("nota", nota);
    ArrayList fechas = sesionBD.getFechas(Integer.parseInt(d));
    request.setAttribute("fechas", fechas);
    
    
    String comment = request.getParameter("comment");
    // use regular Java classes
    //Usuario user = new Usuario(usuario, contrasena, email);
    
    // store the User object in the request object
    String url = "";
    if (user!=null && UsuarioDB.loginCorrecto(user.getNombreUsuario(), user.getContrasena())) {
        if(ComentariosDB.commentExists(pel.getId(), user.getIdUsuario())) {
            ComentariosDB.update(user, pel, comment);
        } else {
            ComentariosDB.insert(user, pel, comment);
        }
        
        //INSERTAR LA VALORACION EN LA DDBB
        ArrayList comentario = peliculasDB.getComentarios(pel.getId());
        ArrayList nombresC = new ArrayList<String>();
    
        for (int i = 0; i < comentario.size(); i++) {
            Comentario c = (Comentario) comentario.get(i);
            String nombreU = UsuarioDB.getUsername(c.getIdUsuario());
            nombresC.add(nombreU);
        }
        url = "/pelicula_1.jsp";
        // store the user in the session
       request.setAttribute("comentarios", comentario);
       session.setAttribute("user", user);
       request.setAttribute("valor", valor);
       request.setAttribute("pelicula",pel);
       request.setAttribute("nombresC",nombresC);
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
