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
                    <%@ page import="data.Entrada" %>
                    <%@page import="java.util.ArrayList"%>
                    <% Usuario user = (Usuario) session.getAttribute("user"); %>
                    <% ArrayList<Entrada> entradas = (ArrayList<Entrada>) request.getAttribute("entradas"); %>
                    <% ArrayList<String> nombresC = (ArrayList) request.getAttribute("nombresC"); %>
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
                
                <div class="leftTitle" style="margin-left:285px;margin-top:100px">
                    <img class="elemPerfil" src="Imagen?username=<%= user.getNombreUsuario()%>"  width="90" height="90" alt="Profile Pic">
                     <a><%= user.getNombreUsuario()%></a>
                    
                </div>
                <div class="rigtT" style="margin-top:230px ; margin-right:180px;">
                <button  class="button" href="#tabs-1" type="button" onclick="location.href='./perfil.jsp'">Volver al perfil</button>
                <button  class="button" onclick="location.href='./editarPerfil.jsp'" type="button" action="editarPerfil" method="post" >Editar perfil</button>
                <c:if test="${user.getAdmin() == 1}">
                    <button class="button" type="button" onclick="location.href='./adminpage.jsp'">Panel de Admin</button>                                               
                </c:if>
                </div>
                                <div class="contacto" style="margin-top: 20% ; width:70% ; margin-left: 20%">
                                    
                                    <div class="tit" style="border-radius: 0px ; margin-top: 0px">
                                         <br>Historial de compra</div>
                                    
                                    <div class="hbdy">
                                        
                                        <ul class="listaul">
                                            <li class="listali" style="margin-right: 120px"> Pelicula</li>  
                                            <li class="listali" style="margin-left: 30px"> Horario de la Pelicula</li> 
                                            <li class="listali" style="margin-left: 60px"> Horario</li> 
                                            <li class="listali" style="margin-left: 60px"> N Fila</li> 
                                            <li class="listali"> N Columna</li> 
                                        </ul>
                                        <br>
                                 <table  width="80%" cellspacing="5" cellpadding="15" style="border-spacing: 40px;">   
                                <c:forEach items="${entradas}" var="item" varStatus="status">
                                    
                                    <tr>
                                     <td>${nombresC[status.index]}</td>
                                     <td>${item.getHora()}</td>
                                     <td>${item.getFecha()}</td>
                                  <td>${item.getNumeroDeFila()}</td>
                                     <td>${item.getNumeroDeColumna()}</td>
                                   
                                   </tr>
                                </c:forEach>
                                   </table>
                                                                      

                                    </div>
                                    
                                </div>
                                
                                
                                
                        
                        </body>
		</html>