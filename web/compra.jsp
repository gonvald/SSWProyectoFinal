<%-- 
    Document   : compra
    Created on : 10-abr-2019, 12:37:41
    Author     : krs_g
--%>

<%@page import="java.time.LocalTime"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.ArrayList"%>
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
                                <% Pelicula p = (Pelicula) request.getAttribute("pelicula"); %>
                                <% String fecha = (String) request.getAttribute("fech"); %>
                                <% ArrayList <LocalTime> horas = (ArrayList <LocalTime>) request.getAttribute("fechas") ;%>
                               
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
					<a  href="Index">Cartelera</a>
					<a href="Estrenos">Estrenos</a>
					<a href="./Pelicula">Peliculas</a>
					<a href="./descuentos.jsp">Descuentos</a>
					<a href="./contacto.jsp">Sobre nosotros</a>
					<input type="text" placeholder="Buscador..">
                </div>
                                
                                
                              
                                <div class="gallery" id="nohover">  
                                        <a target="_blank" >
                                                <img style="width:275px;height:400px;" src="ImagenPeli?username=<%=p.getId()%>"  alt="Cinque Terre">
                                        </a>
                                </div>        

                                <div class="descripcion" id="div_1">
                                    <div class="titulo"><%= p.getTitulo()%></div>
                                    <div class="fecha">Fecha de estreno: <%= p.getFechaEstreno()%></div><br>
                                    <div class="sesiones">17:00 - 19:00 - 22:30</div><br>
                                    <div class="sinopsis"><%= p.getSinopsis()%></div><br>
                                    <div class="genero"><%= p.getGenero()%></div><br>
                                    <div class="duracion">Duracion : <%= (int)p.getDuracion()%> minutos</div><br>
                                    <div class="director">Director : <%= p.getDirector()%></div><br>
                                    <div class="reparto">Reparto : <%= p.getReparto()%></div><br>
                                    
                                </div>
                                <div class="menucompra" id="div_2">
                                    <form action="SelecAsiento" method="post"> 
                                    <div class="button"> Seleccione una fecha</div> 
                                    <br>
                                <c:forEach items="${horas}" var="item">
                                    <input  class="button" type="submit" value = "${item.toString()}" name="hora">
                                </c:forEach>
                                    <input type="hidden" value="<%=p.getId()%>" name="idp">
                                    <input type="hidden" value="<%=fecha%>" name="fecha">
                                </form>
                                </div>
                                    
                                
                                
                                   

                                

                                
                        
                        </body>
		</html>

