<%@page import="java.time.LocalTime"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bbdd.sesionBD"%>
<%@page import="data.Pelicula"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>AntoroCines</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel ="stylesheet" href="cssprueba.css">
    </head>

    <body>
               
                                <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                                <%@ taglib prefix = "fn"    uri = "http://java.sun.com/jsp/jstl/functions" %>
                                <%@ page import="data.Usuario" %>
                                <%@ page import="data.Pelicula" %>
                                <%@ page import="data.Comentario" %>
                                <%@ page import="bbdd.UsuarioDB" %>
                                <%@ page import="bbdd.ValoracionesDB" %>
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
                                
                                <div class="contacto2" style="margin-top: 50px ; margin-left:500px ; padding-left:20px; height: 10%"> Gracias por su compra , recibirá un email con las entradas </div>
                                        
				
                                    

                        </body>
		</html>


