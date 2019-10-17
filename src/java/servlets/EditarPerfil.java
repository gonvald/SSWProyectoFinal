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
import javax.servlet.annotation.MultipartConfig;
@MultipartConfig
public class EditarPerfil extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,
    HttpServletResponse response)
    throws ServletException, IOException {
    // get parameters from the requestç
    

    String username = request.getParameter("username");
    String email = request.getParameter("email");
    String telefono = request.getParameter("telefono");
    String nombre = request.getParameter("nombre");
    Part foto = request.getPart("imagenperfil");
    
    String encoding = request.getCharacterEncoding();
        if (encoding==null) {
        request.setCharacterEncoding("UTF-8");
    }
    
    Usuario user2 = new Usuario();
    user2.setNombreUsuario(username);
    user2.setEmail(email);
    if (foto != null && foto.getSize()!=0) user2.setFichImagen(foto);
    user2.setTelefono(Integer.parseInt(telefono));
    user2.setNombre(nombre);
    
    HttpSession session = request.getSession();
    Usuario user = (Usuario) session.getAttribute("user");
    
    UsuarioDB.getDatos(user);
    System.out.println(user2.getTelefono());
  
    
    // store the User object in the request object
    String url = "";
    if (UsuarioDB.update(user,user2)) {
        //user.setFichImagen(request.getPart("file"));
        UsuarioDB.getDatos(user);
        System.out.println(user.getEmail());
        url = "/perfil.jsp";
        // store the user in the session
        session.setAttribute("user", user);
    }
    else{
        url = "/error.html";
        session.setAttribute("user", user);
    }
    // forward the request and response to the view
    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
    dispatcher.forward(request, response);
    }
    
    protected void processRequest(HttpServletRequest request,
    HttpServletResponse response)
            
    throws ServletException, IOException {
                String encoding = request.getCharacterEncoding();
    if (encoding==null) {
    request.setCharacterEncoding("UTF-8");
    }
        //String path = "C:\\Users\\Pepe\\Documents\\sswRepository";
        String path = getServletContext().getRealPath("/Imagenes");
        try (PrintWriter out = response.getWriter()) {
        Part filePart = request.getPart("file");
        String fileName = getFileName(filePart);
        InputStream fileContent = filePart.getInputStream();
        OutputStream outFile = null;
        out.println("<!DOCTYPE html>");
        out.println("<html><head>");
        out.println("<title>Servlet Upload</title></head>");
        out.println("<body>");
        try {
            outFile = new FileOutputStream(new File(path + File.separator
            + fileName));
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = fileContent.read(bytes)) != -1) {
            outFile.write(bytes, 0, read);
            }
            out.println("Fichero " + fileName + " creado");
            out.println("<img src=\"images/" + fileName + "\">");
        } catch (FileNotFoundException fne) {
            out.println("Error al subir el fichero:");
            out.println("<br/>" + fne.getMessage());
            } finally {
            if (outFile != null) {
                outFile.close();
            }
            if (fileContent != null) {
                fileContent.close();
            }
            if (out != null) {
                out.println("</body></html>");
                out.close();
                } 
            } 
        }
    }
    
    
    private static String getFileName(Part part) {
    for (String cd : part.getHeader("content-disposition").split(";")) {
    if (cd.trim().startsWith("filename")) {
        String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"",
        "");
        return fileName.substring(fileName.lastIndexOf('/') +
        1).substring(fileName.lastIndexOf('\\') + 1);
            }
        }
    return null;
    }
    
}
