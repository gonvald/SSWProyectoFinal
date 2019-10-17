<!DOCTYPE html>
<html>
	<head>
        <title>AntoroCines</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel ="stylesheet" href="cssprueba.css">
        <link rel="stylesheet" href="cssprueba.css" type="text/css"/>
        <link rel="stylesheet" href="cssprueba.css" type="text/css">
        

    </head>
                <body>
                    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                    <%@ taglib prefix = "fn"    uri = "http://java.sun.com/jsp/jstl/functions" %>
                    <%@ page import="data.Usuario" %>
                    <% Usuario user = (Usuario) session.getAttribute("user"); %>
                    <div style="background-color: #e9e9e9"> <img src="./Imagenes/titulo.png"  alt="titulo"> </div>
                    <div class="topright">
                    <a href="./perfil.jsp"><%= user.getNombreUsuario()%></a>
                 
                    <a href="Logout">Logout</a>   

                </div>
                
				<div class="topnav">
					<a href="Index">Cartelera</a>
					<a href="Estrenos">Estrenos</a>
					<a href="Pelicula">Peliculas</a>
					<a href="./descuentos.jsp">Descuentos</a>
					<a href="./contacto.jsp">Sobre nosotros</a>
					<input type="text" placeholder="Buscador..">
                </div>
                
                <div class="leftTitle">
                    <img class="elemPerfil" src="Imagen?username=<%= user.getNombreUsuario()%>"  width="90" height="90" alt="Profile Pic">
                     <a><%= user.getNombreUsuario()%></a>
                    
                </div>
                <div class="rigtT">
                <a  class="button" href="Historial" type="button"  >Historial de compra</a>
                <button  class="button" onclick="location.href='./editarPerfil.jsp'" type="button" action="editarPerfil" method="post" >Editar perfil</button>
                <c:if test="${user.getAdmin() == 1}">
                    <button class="button" type="button" onclick="location.href='./adminpage.jsp'">Panel de Admin</button>                                               
                </c:if>
                </div>
                                
                
                <div class="perfil">
                    
                                        <div class="row">
                                            <div class="col2">
                                                <label>Nombre de usuario</label>
                                            </div>
                                            <div class="col2">
                                                <p><%= user.getNombreUsuario()%></p>
                                            </div>
                                        </div>
                    
 
                                        <div class="row">
                                            <div class="col2">
                                                <label>Nombre</label>
                                            </div>
                                            <div class="col2">
                                                <p><%= user.getNombre()%></p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col2">
                                                <label>Email</label>
                                            </div>
                                            <div class="col2">
                                                <p><%= user.getEmail()%></p>
                                            </div>
                                        </div>
                                        <c:if test = "${user.getTelefono() gt 2}">
                                            <div class="row">
                                            <div class="col2">
                                                <label>Telefono</label>
                                            </div>
                                            <div class="col2">
                                                <p><%= user.getTelefono()%></p>
                                             </div>
                                            </div>
                                        </c:if>

                                                
                                            
                                        
                            </div>
                      
                                
                                                                
 
                        
                        </body>
		</html>