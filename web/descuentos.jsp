<%-- 
    Document   : descuentos
    Created on : 10-abr-2019, 11:57:49
    Author     : krs_g
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Descuentos</title>
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
            <a class="active" href="./descuentos.jsp">Descuentos</a>
            <a href="./contacto.jsp">Sobre nosotros</a>
            <input type="text" placeholder="Buscador..">
        </div>
        <img class="c1" style="margin-top: 17% ; margin-left: 2%" src="./Imagenes/c1.png" alt="c1.png">
        <img class="c2"  style="margin-top: 17%" src="./Imagenes/c2.png" alt="c2.png">
        <div class="descuentos">
        <div>
            <a class="tarjetaDescuento"  href="'#'"><h2 style="text-align: center;color: #337BF4">Dia del espectador</h2> <br> Cada miercoles consigue tu entrada por solo 4.90€</a>
            <a class="tarjetaDescuento"  href='#'><h3 style="text-align: center;color: #337BF4">De Domingo a Jueves (excpeto Miércoles)</h3><br>2x1 en sesiones nocturnas, a partir de las 21:30</a>
        </div>    
            
        <div>    
            <a class="tarjetaDescuento"  href="#"><h3 style="text-align: center;color: #337BF4">De Lunes a Viernes (excepto Miércoles) </h3><p>Consigue tu entrada para la pelicla de la semana, por solo 4€.</p> <p style="font-size:7pt"> (Consulte la película de cada semana en nuestra web)</p> </a>   
            <a class="tarjetaDescuento"  href="'#'"><h3 style="text-align: center;color: #337BF4">Viernes, Sabados y Domingos</h3> Palomitas grandes y refresco de un litro gratis por la compra de 2 entradas</a>
        </div> 
        </div>
    </body>
</html>
