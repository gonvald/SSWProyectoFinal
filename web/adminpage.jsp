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
				<div class="topright">
                    <a href="./perfil.jsp"><%= user.getNombreUsuario()%></a>
                   
                    <a href="Logout">Logout</a>   

                </div>

       

        <div class="topnav">
            <a  href="Index">Cartelera</a>
            <a href="Estrenos">Estrenos</a>
            <a href="Pelicula">Peliculas</a>
            <a href="./descuentos.jsp">Descuentos</a>
            <a href="./contacto.jsp">Sobre nosotros</a>
            <input type="text" placeholder="Buscador..">
        </div>
        
       
       <div class="contacto" style="width: 50%">
           
           <div class="tit" style="width: 60% ; margin: 15px auto 0 auto ; padding-top: 35px">
               Gestiona la informacion
           </div>
           
           <div class="contacto2" style="width:60% ; margin-left: 20% ; margin-top: 3%">
               
               <div class="admt">
               <button  class="button" style="width: 70%" type="button" onclick="location.href='modPelis'">Modificar peliculas</button>
               </div>
               <div class="admt">
               <button  class="button" style="width:70%" type="button" onclick="location.href='ModCartelera'">Modificar cartelera</button>
               </div>
               <div class="admt">
               <button  class="button" style="width:70%" type="button" onclick="location.href='#'">Modificar descuentos</button>
               </div>
               <div class="admt">
               <button  class="button" style="width:70%" type="button" onclick="location.href='ListaPelis?id=-1'">Añadir peliculas</button>
               </div>
               
               
               
           </div>
           
       </div>
       
    </body>
</html>