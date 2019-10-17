<%@page import="java.time.LocalDate"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
	<head>
        <title>AntoroCines</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel ="stylesheet" href="cssprueba.css">
    </head>
			<body>
                                <%@ page pageEncoding="ISO-8859-1" contentType="text/html;charset=UTF-8" %>
                                <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                                <%@ taglib prefix = "fn"    uri = "http://java.sun.com/jsp/jstl/functions" %>
                                <%@ page import="data.Usuario" %>
                                <%@ page import="data.Pelicula" %>
                                <%@ page import="data.Comentario" %>
                                <% Usuario user = (Usuario) session.getAttribute("user"); %>
                                <% Pelicula p = (Pelicula) request.getAttribute("pelicula"); %>
                                <% int valor = (int) request.getAttribute("valor"); %>
                                <% double nota = (double) request.getAttribute("nota"); %>
                                <% ArrayList<Comentario> comentarios = (ArrayList) request.getAttribute("comentarios"); %>
                                <% ArrayList<String> nombresC = (ArrayList) request.getAttribute("nombresC"); %>
                                <% ArrayList <LocalDate> fechas = (ArrayList <LocalDate>) request.getAttribute("fechas") ;%>
                         
                               
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
                                
                                 
                                
                                <form action="Valorar" method="post">
                                <div class="gallery" id="nohover">  
                                        <a target="_blank" >
                                                <img style="width:275px;height:400px;" src="ImagenPeli?username=<%=p.getId()%>"  alt="Cinque Terre">
                                        </a>
                                                
                                    
                                    <div class="rate">
                                        
                                        
                                        <input type="radio" id="star5" name="rate" value="5"/>
                                        <label for="star5" title="text">5 stars</label>
                                        <input type="radio" id="star4" name="rate" value="4"/>
                                        <label for="star4" title="text">4 stars</label>
                                        <input type="radio" id="star3" name="rate" value="3"/>
                                        <label for="star3" title="text">3 stars</label>
                                        <input type="radio" id="star2" name="rate" value="2"/>
                                        <label for="star2" title="text">2 stars</label>
                                        <input type="radio" id="star1" name="rate" value="1"/>
                                        <label for="star1" title="text">1 star</label>
                                        
                                        

                                    </div>  
                                        <div style="margin-top:40px ; margin-bottom: 20px; margin-left:120px ; clear:both">
                                          <input type="hidden" name="idpeli" value="<%=p.getId()%>">
                                          <c:if test = "${not empty user}">
                                          <input type="submit" value="Valorar" >
                                          </c:if>
                                        </div>
                                </div>
                              

                                </form>
                                
                                        <c:if test = "${not empty user}">
                                        <script>
                                            document.getElementById("star"+<%= valor %>).checked = true;                                                                                        
                                        </script>
                                     </c:if>
                                
                                
                                
                                <div class="descripcion" id="div_1">
                                    <div class="titulo"><%= p.getTitulo()%></div>
                                    <div class="fecha">Fecha de estreno: <%= p.getFechaEstreno()%></div><br>
                                    <div class="sesiones">Sesiones: 17:00 - 19:00 - 22:00</div><br>
                                    <div class="sinopsis"><%= p.getSinopsis()%></div><br>
                                    <div class="genero">Genero: <%= p.getGenero()%></div><br>
                                    <div class="valoracion">Valoracion : <%= String.format("%.1f", nota) %> / 5</div><br>
                                    <div class="duracion">Duracion : <%= (int)p.getDuracion()%> minutos</div><br>
                                    <div class="director">Director : <%= p.getDirector()%></div><br>
                                    <div class="reparto">Reparto : <%= p.getReparto()%></div><br>
                                </div>
                                
                                
                                <%--
                                <script>
                                        function val() {
                                            var fechis = document.getElementById("fech").value;
                                            }
                                </script>
                                

                                <div class="menucompra" id="div_2">
                                    <div>
                                        <select onchange="val()" id="fech">
                                       
                                            <c:forEach items="${fechas}" var="item">
                                                        <option value="${item.toString()}">
                                                        ${item.toString()} 
                                                        </option>
                                            </c:forEach> 
                                        </select>
                                    </div>
                                    <div>
                                        <button  class="button" type="button" onclick="location.href='CompraS?id=<%=p.getId()%>&f=<%=fechis%>' ">Comprar entradas</button>
                                    </div>
                                </div>
                                   ---%>
                                <c:if test="${not empty user and not empty fechas}">
                                <div class="menucompra" id="div_2">
                                    
                                    <form action="CompraS" method="post">
                                    
                                    <select name="fech">
                                       
                                            <c:forEach items="${fechas}" var="item">
                                                        <option value="${item.toString()}" ${fech == item.toString() ? 'selected' : ''}>
                                                        ${item.toString()} 
                                                        </option>
                                            </c:forEach> 
                                                        
                                     </select>
       
                                    <input type="hidden" name="idp" value="<%=p.getId()%>">
                                    <input class="button" type="submit" value="Comprar entradas" >  
                                 
                                        
                                    </form>   
                                    
                                </div>
                                </c:if>
                                 

                                <div class="menucompra" id="div_2">
                                    <div class="mensaje">Criticas de los usuarios</div><br>
                                        <c:forEach var="element" items="${comentarios}" varStatus="status">
                                        <p>
                                       <b>  ${nombresC[status.index]} </b>:
                                         ${element.getComentario()}

                                        </p>
                                       </c:forEach>
                                    <br>
                                      
                                    <c:if test="${not empty user}">
                                      <form action="Comentar" method="post">
                                      <textarea rows="4" cols="35" name="comment" placeholder="Escribe aqui tu comentario">
                                      </textarea>
                                      <input type="hidden" name="idpeli" value="<%=p.getId()%>">
                                      <input type="submit" value="Comentar">
                                      </form>
                                </div>
                                    </c:if>

                                
                        
                        </body>
		</html>
