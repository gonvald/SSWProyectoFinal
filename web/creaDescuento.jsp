

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
                                                <button  class="button" type="button" onclick="location.href='./register.jsp'">Registrarse</button>
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
                <input class="lg" type="text" name="titulo"  required>
                <input class="lg" type="text" name="sinopsis"  required>
                <input class="lg" type="text" name="genero" required>
                <input class="lg" type="number" name="duracion"  required>
                <input class="lg" type="date" name="fechaestreno" required>
                <input class="lg" type="number" step="any" name="nota" required >
                <input class="lg" type="file" name="imagenperfil" />
                <input id="acceder" type="submit" value="Guardar cambios" >  
            </form>
            
            
            
        </div>

    </body>
</html>
