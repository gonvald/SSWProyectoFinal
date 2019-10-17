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
                                
                
                <div class="perfil" style="height: 450px ; margin-bottom: 10px">
                                        <form action="EditarPerfil" method="post"  enctype="multipart/form-data">
                                            

                                        <p>Nombre de usuario: </p><input class="lg" type="text" name="username" value="<%= user.getNombreUsuario()%>" >
                                        <p>Nombre: </p><input class="lg" type="text" name="nombre"  value="<%= user.getNombre()%>" >
                                        <p>Correo electrónico: </p><input class="lg" type="email" name="email" value="<%= user.getEmail()%>" >
                                        <c:choose>
                                        <c:when test="${user.getTelefono()>0}">                 
                                        <p>Número de teléfono: </p><input class="lg" type="text" value="<%= user.getTelefono()%>" name="telefono" >
                                        </c:when>
                                         <c:otherwise>
                                         <p>Número de teléfono: </p><input class="lg" type="text" placeholder="Escriba su número de telefono" name="telefono" >
                                        </c:otherwise>
                                    </c:choose>
                                        
                                        <p>Imagen de perfil: </p><input class="lg" type="file" name="imagenperfil" />
                                        <input  id="acceder" type="submit" value="Guardar" class="button">  

                                        </form>
                                            
                     
                                        
                            </div>
                      
                                

                                
                        
                        </body>
		</html>