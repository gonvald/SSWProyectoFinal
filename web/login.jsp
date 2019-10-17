<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
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
        <div class="topright">
            <button  class="button" type="button" onclick="location.href='./login.jsp'">Iniciar sesion</button>
            <button  class="button" type="button" onclick="location.href='./register.html'">Registrarse</button>
        </div>
        <c:if test = "${not empty user && !UsuarioDB.loginCorrecto(user.getNombreUsuario(), user.getContrasena())}">
            <script>alert("Error en login");</script>
        </c:if>
        <div class="topnav">
            <a href="Index">Cartelera</a>
            <a href="Estrenos">Estrenos</a>
            <a href="Pelicula">Peliculas</a>
            <a href="./descuentos.jsp">Descuentos</a>
            <a href="./contacto.jsp">Sobre nosotros</a>
            <input type="text" placeholder="Buscador..">
        </div>
        
        <div>
             <img class="c1" src="./Imagenes/c1.png" alt="c1.png">
            <img class="c2"  src="./Imagenes/c2.png" alt="c2.png">
        </div>
        <div>
            <img class="c1" style=" clear: both; margin-top: 6%" src="./Imagenes/c3.png" alt="c3.png">
            <img class="c2" style=" clear: both ; margin-top: -19% ; margin-right: 9%" src="./Imagenes/c4.jpg" alt="c4.png">
            
        </div>
   
        
      
        <div  class="contenedorlog" >
  
            <div>
                <h2 style="text-align: center">Iniciar Sesi�n</h2>
                 <form action="login" method="post">
                    <input class="lg" type="text" placeholder="Usuario" name="usuario" required>
                    <input class="lg" type="password" placeholder="Contrase�a" name="contrasena" required>
                    <input id="recordar" type="checkbox" value="recordar" /> <label>Recordar contrase�a</label> 
                    <input  id="acceder" type="submit" value="Acceder" >

             
                </form>
            </div>
            
            <div class="tc">
                <a href="./olvidadopass.html" >�Contrase�a olvidada?</a>
            </div>
            
            <div class="tc">
                <p>�A�n no tienes cuenta? </p> 
                <a href="./register.html" class="button" style="margin-top:15px" >Reg�strate</a>
            </div>
            

            
        </div>
        
    </body>
</html>
