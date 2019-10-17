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

public class Registro extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,
    HttpServletResponse response)
    throws ServletException, IOException {
                String encoding = request.getCharacterEncoding();
    if (encoding==null) {
    request.setCharacterEncoding("UTF-8");
    }
    // get parameters from the request
    String usuario = request.getParameter("usuario");
    String contrasena = request.getParameter("contrasena");
    String email = request.getParameter("email");
    String nombre = request.getParameter("nombre");
    // use regular Java classes
    System.out.println(usuario);
    //Usuario user = new Usuario(usuario, contrasena, email);
    Usuario user = new Usuario();
    user.setNombreUsuario(usuario);
    user.setContrasena(contrasena);
    user.setEmail(email);
    user.setNombre(nombre);
    
    System.out.println(UsuarioDB.emailExists(user.getEmail()));
    // store the User object in the request object
    String url = "";
    if (UsuarioDB.emailExists(user.getEmail()) || UsuarioDB.usernameExists(user.getNombreUsuario())) {
        url = "/login.html";
    } else {
       String path = getServletContext().getRealPath("/Imagenes");

        
        int id = UsuarioDB.insert(user,path);
        user.setIdUsuario(id);
        url = "/perfil.jsp";
        // store the user in the session
        UsuarioDB.getDatos(user);
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
    }
    // forward the request and response to the view
    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
    dispatcher.forward(request, response);
    }
}
