

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
        <div class="topright">
            <a href="./perfil.jspl"><%= user.getNombreUsuario()%></a>
           
            <a href="Logout">Logout</a>   

        </div>

        <div class="topnav">
            <a class="active" href="Index">Cartelera</a>
	<a href="Estrenos">Estrenos</a>
            <a href="Pelicula">Peliculas</a>
            <a href="./descuentos.html">Descuentos</a>
            <a href="./contacto.html">Sobre nosotros</a>
            <input type="text" placeholder="Buscador..">
        </div>
        <div class="perfil">
            <form action="EditarPeli" method="post"  enctype="multipart/form-data">
                <p>Titulo: </p>
                <input class="lg" type="text" name="titulo" value="<%= p.getTitulo()%>" >
                <p>Sinopsis: </p>
                <input class="lg" type="text" name="sinopsis"  value="<%= p.getSinopsis()%>" >
                <p>Género: </p>
                <input class="lg" type="text" name="genero" value="<%= p.getGenero()%>" >
                <p>Duración (min.): </p>
                <input class="lg" type="text" value="<%= (int) p.getDuracion()%>" name="duracion" >
                <p>Fecha de estreno: </p>
                <input class="lg" type="date" name="fechaestreno" value="<%= p.getFechaEstreno()%>">
                <p>Director : </p>
                <input class="lg" type="text" name="director" value="<%= p.getDirector()%>" >
                <p>Reparto : </p>
                <input class="lg" type="text" name="reparto" value="<%= p.getReparto()%>" >
                <p>Carátula: </p>
                <input class="lg" type="file" name="imagenperfil" />
                <input type="hidden" name="peli" value="<%= p.getId() %>">          
                <input class="button" type="submit" value="Guardar cambios" >  
                 

            </form>
        </div>

    </body>
</html>
