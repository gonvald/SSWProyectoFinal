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
import data.Pelicula;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import bbdd.peliculasDB;
import bbdd.sesionBD;
import data.Comentario;

@WebServlet(name = "InfoPeli", urlPatterns = {"/InfoPeli"})
public class InfoPeli extends HttpServlet {
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
    System.out.println(idpeli);
    // store the User object in the request object
    String url = "";
    Pelicula p= peliculasDB.getPelicula(Integer.parseInt(idpeli));
    ArrayList comentario = new ArrayList<Comentario>();
    ArrayList nombresC = new ArrayList<String>();
    comentario = peliculasDB.getComentarios(Integer.parseInt(idpeli));
    for (int i = 0; i < comentario.size(); i++) {
        Comentario c = (Comentario) comentario.get(i);
        String nombreU = UsuarioDB.getUsername(c.getIdUsuario());
        nombresC.add(nombreU);
    }
    HttpSession session = request.getSession();
    int valor;
    Usuario user = (Usuario) session.getAttribute("user");
    if(user != null){
    valor = ValoracionesDB.getVoto(p.getId(),user.getIdUsuario());
    }else{
    valor = 0;
    }
    
    double nota;
    nota = ValoracionesDB.getNotaMedia(p.getId());
    ArrayList fechas = sesionBD.getFechas(Integer.parseInt(idpeli));
    
    System.out.println(p.getTitulo());
    

    System.out.println(p==null);
    //System.out.println(p.getTitulo());
    if (p == null) {
        System.out.println("NULO");
        url = "/index.jsp";
    } else {
        
        url = "/pelicula_1.jsp";
        
        // store the user in the session
        System.out.println(request.getSession()==null);
        
        
        request.setAttribute("pelicula", p);
        request.setAttribute("comentarios", comentario);
        request.setAttribute("nombresC",nombresC);
        request.setAttribute("valor", valor);
        request.setAttribute("nota", nota);
        request.setAttribute("fechas", fechas);
        System.out.println( nombresC);
    }
    // forward the request and response to the view
        System.out.println(request.getRequestDispatcher(url));
    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
    dispatcher.forward(request, response);
    
    
    }
    
    
}
