<%-- 
    Document   : compra
    Created on : 10-abr-2019, 12:37:41
    Author     : krs_g
--%>

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
                                <% Pelicula p = (Pelicula) request.getAttribute("pelicula"); %>
                                <% String fecha = (String) request.getAttribute("fech"); %>
                                <% String hora= (String) request.getAttribute("hora"); %>
                                <%int sala = (int) request.getAttribute("sala"); %>
                                <%int filas = (int) request.getAttribute("filas"); %>
                                <%int columnas = (int) request.getAttribute("columnas"); %>
                               
                               
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

                                
                                <div class="menucompra" id="div_2">
 
                                    <div> Seleccione su posicion </div>
                                    
                                <c:forEach items="${ocupacion}" var="item">
                                   <c:choose>
                                        <c:when test="${not empty user}">                 
                                             
                                          
                                        </c:when>
                                         <c:otherwise>
                                            
                                        </c:otherwise>
                                    </c:choose>
                                    
                                </c:forEach>
                                    <form action="ProcesaPago" method="post">
                                    Fila 
                                    <select name="fil">
                                      
                                        <c:forEach var = "i" begin = "1" end = "${filas}">
                                            
                                             <option value="${i}" ${fil == i ? 'selected' : ''}>
                                                        ${i} 
                                            </option>
     
                                        </c:forEach>
                                      
                                    </select>
                                    
                                    Columna
                                    <select name="col">
                                      
                                        <c:forEach var = "i" begin = "1" end = "${columnas}">
                                            
                                             <option value="${i}" ${col == i ? 'selected' : ''}>
                                                        ${i} 
                                            </option>
     
                                        </c:forEach>
                                      
                                    </select>
                                    
                                   <input type="hidden" name="idp" value="<%=p.getId()%>">
                                    <input class="button" type="submit" value="Finalizar" >
                                    <input type="hidden" value="<%=fecha%>" name="fecha">
                                    <input type="hidden" value="<%=hora%>" name="hora">
                                    <input type="hidden" value="<%=sala%>" name="sala">
                                    <input  type="hidden" value="<%=filas%>" name="filas">
                                    <input type="hidden" value="<%=columnas%>" name="columnas">
                                    
                                    </form>
                                  
                             
                                </div>
                                    

                        </body>
		</html>


