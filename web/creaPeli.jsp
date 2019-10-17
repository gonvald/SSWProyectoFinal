

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>AntoroCines</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel ="stylesheet" href="cssprueba.css">
        <link rel="stylesheet" href="cssprueba.css" type="text/css"/>
        <link rel="stylesheet" href="cssprueba.css" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>

        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix = "fn"    uri = "http://java.sun.com/jsp/jstl/functions" %>
        <%@ page import="data.Usuario" %>
        <%@ page import="data.Pelicula" %>
        <%@ page import="data.Comentario" %>
        <% Usuario user = (Usuario) session.getAttribute("user"); %>
        <% Pelicula p = (Pelicula) request.getAttribute("pelicula");%> 
        <div style="background-color: #e9e9e9"> <img src="./Imagenes/titulo.png"  alt="titulo"> </div>
        <c:choose>
                                        <c:when test="${not empty user}">                 
                                            <div class="topright">
                                                <a href="./perfil.jsp"><%= user.getNombreUsuario()%></a>
                                           
                                                <a href="Logout">Logout</a>   
                                            </div>
                                        </c:when>
                                         <c:otherwise>
                                            <div class="topright">
                                                <button  class="button" type="button" onclick="location.href='./login.jsp'">Iniciar sesion</button>
                                                <button  class="button" type="button" onclick="location.href='./register.html'">Registrarse</button>
                                            </div>
                                        </c:otherwise>
        </c:choose>

        <div class="topnav">
            <a href="Index">Cartelera</a>
            <a href="Estrenos">Estrenos</a>
            <a href="Pelicula">Peliculas</a>
            <a href="./descuentos.jsp">Descuentos</a>
            <a href="./contacto.jsp">Sobre nosotros</a>
            <input type="text" placeholder="Buscador..">
        </div>
        <div class="perfil">
            <form action="CreaPeli" method="post" enctype="multipart/form-data">
                <p>Titulo: </p>
                <input class="lg" type="text" name="titulo"  required>
                <p>Sinopsis: </p>
                <input class="lg" type="text" name="sinopsis"  required>
                <p>Género: </p>
                <input class="lg" type="text" name="genero" required>
                <p>Duracion (min.): </p>
                <input class="lg" type="number" name="duracion"  required>
                <p>Fecha de estreno: </p>
                <input class="lg" type="date" name="fechaestreno" required>
                <p>Director : </p>
                <input class="lg" type="text" name="director"  >
                <p>Reparto : </p>
                <input class="lg" type="text" name="reparto"  >
                <p>Caratula (opcional): </p>
                <input class="lg" type="file" name="imagenperfil" />
                <input id="acceder" type="submit" value="Guardar cambios" >  
            </form>
            
            
            
        </div>

    </body>
</html>
