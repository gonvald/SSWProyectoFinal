package servlets;

import bbdd.peliculasDB;
import java.io.IOException;  
import java.io.PrintWriter;  
import data.Usuario;
import java.util.ArrayList;

import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  

public class Logout extends HttpServlet {  
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                                throws ServletException, IOException {  
                    String encoding = request.getCharacterEncoding();
                 if (encoding==null) {
                    request.setCharacterEncoding("UTF-8");
                }  
            PrintWriter out=response.getWriter();  
            HttpSession session=request.getSession();  
            Usuario user = (Usuario) session.getAttribute("user");
            String usuario = user.getNombreUsuario();
            session.invalidate();    
            
            ArrayList<data.Pelicula> pelis = peliculasDB.getPeliculasCartelera();
            request.setAttribute("peliculas", pelis);
            request.getRequestDispatcher("index.jsp").include(request, response);  
             
            
            
              
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Hasta Pronto "+usuario+"');");
            out.println("</script>");
              
            out.close();  
    }  
}  