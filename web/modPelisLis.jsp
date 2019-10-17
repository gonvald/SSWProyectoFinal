
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
                             <%@page import="java.util.ArrayList"%>
                            <% Usuario user = (Usuario) session.getAttribute("user"); %>
                             <% ArrayList<Pelicula> lista = (ArrayList<Pelicula>) request.getAttribute("lista"); %>
                            
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
                                
                              
                                 
                                
                                <div class="contacto2" style="width:30% ; margin-left: 32% ; margin-top: 3% ; overflow: auto; ">
                                    
                                    <div class="tit" style="margin-bottom:20px">
                                        Pelicula a editar
                                    </div>
                                   
                                <c:forEach items="${lista}" var="item">
                                    <div style="margin-left:20% ; margin-top:15px ; overflow: auto">
                                        <a href="ListaPelis?id=${item.getId()} " class="button" >
                                                ${item.getTitulo()} </a>
                                    </div>
                                </c:forEach>
                                </div>
                                
                                

                          
                          
		</html>
