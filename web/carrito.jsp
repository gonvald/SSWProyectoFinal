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
                                <% Usuario user = (Usuario) session.getAttribute("user"); %>
				<div style="background-color: #e9e9e9"> <img src="./Imagenes/titulo.png"  alt="titulo"> </div>
				<c:choose>
                                        <c:when test="${not empty user}">                 
                                            <div class="topright">
                                                <a href="./perfil.jsp"><%= user.getNombreUsuario()%></a>
                                              
                                            </div>
                                        </c:when>
                                         <c:otherwise>
                                            <div class="topright">
                                                <button  class="button" type="button" onclick="location.href='./login.html'">Iniciar sesion</button>
                                                <button  class="button" type="button" onclick="location.href='./register.html'">Registrarse</button>
                                            </div>
                                        </c:otherwise>
                                    </c:choose>
				
                
				<div class="topnav">
					<a  href=".Index">Cartelera</a>
                                        <a href="Estrenos">Estrenos</a>
					<a href="Pelicula">Peliculas</a>
					<a href="./descuentos.jsp">Descuentos</a>
					<a href="./contacto.jsp">Sobre nosotros</a>
					<input type="text" placeholder="Buscador..">
                </div>
                
 <div class="carrito">


                <div class="product">

                    <div class="product-details">
                        <img class="product-image" src="https://image.tmdb.org/t/p/w600_and_h900_bestv2/oiDqndbFTrlmWHjvE14YYry13Dk.jpg" width="90" height="90" alt="caratula">
                        <div class="product-title">Entrada Adulto: El corral</div>
                        <p>Entrada Adulto. 20/04/2019 22:00h. Cine: Calle Matadero. Sala 2. </p>
                    </div>
                    <div class="product-price">5.99</div>
                    <div class="product-quantity">
                      <input type="number" value="2" min="1">
                    </div>
                    <div class="product-removal">
                      <button>
                        Eliminar
                      </button>
                    </div>
                    <div class="product-line-price">11.98</div>
                </div>
                                
                            
     <div class="pagar">
                           <button class="button">Pagar</button>

     </div>
                
                
                      
                                

                                
 </div>
</body>
		</html>