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
import data.Entrada;
import java.util.ArrayList;

public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,
    HttpServletResponse response)
    throws ServletException, IOException {
                String encoding = request.getCharacterEncoding();
    if (encoding==null) {
    request.setCharacterEncoding("UTF-8");
    }
    // get parameters from the request
    
    String path = getServletContext().getRealPath("/Imagenes");
    
    
    String usuario = request.getParameter("usuario");
    String contrasena = request.getParameter("contrasena");
    // use regular Java classes
    System.out.println(usuario);
    //Usuario user = new Usuario(usuario, contrasena, email);
    Usuario user = new Usuario();
    user.setNombreUsuario(usuario);
    user.setContrasena(contrasena);
    
    // store the User object in the request object
    String url = "";
    System.out.println(user.getNombreUsuario());
    if (UsuarioDB.loginCorrecto(user.getNombreUsuario(), user.getContrasena())) {
        UsuarioDB.getDatos(user);
        
        System.out.println(user.getEmail());
        url = "/perfil.jsp";
        // store the user in the session
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
       
    }
    else{
        url = "/login.jsp";
        HttpSession session = request.getSession();
    
    }
    // forward the request and response to the view
    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
    dispatcher.forward(request, response);
    }
}
