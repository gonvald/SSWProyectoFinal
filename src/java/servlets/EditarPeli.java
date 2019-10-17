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
import bbdd.peliculasDB;
import data.Pelicula;
import java.util.ArrayList;
import javax.servlet.annotation.MultipartConfig;
@MultipartConfig
public class EditarPeli extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,
    HttpServletResponse response)
    throws ServletException, IOException {
    // get parameters from the requestç
    String encoding = request.getCharacterEncoding();
    if (encoding==null) {
    request.setCharacterEncoding("UTF-8");
    } 
   // response.setContentType("text/html;charset=UTF-8");
    System.out.println("HIEOHEIHIE");
    String titulo = request.getParameter("titulo");
    String sinopsis = request.getParameter("sinopsis");
    String genero = request.getParameter("genero");
    String duracion = request.getParameter("duracion");
    String director = request.getParameter("director");
    String reparto = request.getParameter("reparto");
    String id =  request.getParameter("peli");
    Part foto = request.getPart("imagenperfil");
    //Part foto = request.getPart("imagenperfil");
    Pelicula peli = new Pelicula();
    
    peli.setTitulo(titulo);
    peli.setSinopsis(sinopsis);
    peli.setGenero(genero);
    if (foto != null && foto.getSize()!=0) peli.setFichImagen(foto);
    
    
    peli.setDuracion(Double.parseDouble(duracion));
    peli.setReparto(reparto);
    peli.setDirector(director);
    
   Pelicula p = (Pelicula) peliculasDB.getPelicula(Integer.parseInt(id));
    
    System.out.println("cheeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
         
         
    // store the User object in the request object
    String url = "";
    if (peliculasDB.update(p,peli)) {
        //user.setFichImagen(request.getPart("file"));
        System.out.println("HE ENTRADO");
        peliculasDB.getPelicula(p.getId());
        //System.out.println(user.getEmail());
        url = "/modPelisLis.jsp";
        // store the user in the session
        request.setAttribute("pelicula", p);
    }
    /*else{
        url = "/error.html";
        request.setAttribute("pelicula", p);
    }*/
    
    ArrayList<Pelicula> datos = peliculasDB.getPeliculas();
    request.setAttribute("lista", datos);
    // forward the request and response to the view
    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
    dispatcher.forward(request, response);
    }
    
    protected void processRequest(HttpServletRequest request,
    HttpServletResponse response)
            
    throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");
        String encoding = request.getCharacterEncoding();
        if (encoding == null) {
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

