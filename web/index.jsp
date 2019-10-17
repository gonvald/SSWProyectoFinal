<%-- 
    Document   : index
    Created on : 10-abr-2019, 10:42:26
    Author     : krs_g
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
	<head>
        <title>AntoroCines</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel ="stylesheet" href="cssprueba.css">
    </head>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                            <%@ taglib prefix = "fn"    uri = "http://java.sun.com/jsp/jstl/functions" %>
                            <%@ page import="data.Usuario" %>
                             <%@ page import="data.Pelicula" %>
                            <% Usuario user = (Usuario) session.getAttribute("user"); %>
                            <% ArrayList<Pelicula> peliculas = (ArrayList) request.getAttribute("peliculas"); %>
			<body>
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
					<a class="active" href="Index">Cartelera</a>
					<a href="Estrenos">Estrenos</a>
					<a href="Pelicula">Peliculas</a>
					<a href="./descuentos.jsp">Descuentos</a>
					<a href="./contacto.jsp">Sobre nosotros</a>
					<input type="text" placeholder="Buscador..">
                </div>
                                        
                                <c:forEach items="${peliculas}" var="item">
                                    <div class="gallery">
                                        <a href="InfoPeli?id=${item.getId()} " >
                                                <img src="ImagenPeli?username=${item.getId()}" alt="Cinque Terre"  id="imgcartelera">
                                                </a>
                                    <div class="desc">${item.getTitulo()}<br><br> ${item.getFechaEstreno()}</div>
                                    </div>
                                </c:forEach>
                                                </body>
							</html>

