<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <title>Murach's Java Servlets and JSP</title>
   </head>
   <body>
      <h1>REGISTRADO NUEVO</h1>
      <p>Here is the information that you entered:</p>
      <%@ page import="data.Usuario" %>
      <% Usuario user = (Usuario) session.getAttribute("user"); %>
      <table cellspacing="5" cellpadding="5" border="1">
         <tr>
            <td align="right">First name:</td>
            <td><%= user.getNombreUsuario()%></td>
         </tr>
         <tr>
            <td align="right">Last name:</td>
            <td><%= user.getContrasena()%></td>
         </tr>
         <tr>
            <td align="right">Email address:</td>
            <td><%= user.getEmail()%></td>
         </tr>
      </table>
   </body>
</html>