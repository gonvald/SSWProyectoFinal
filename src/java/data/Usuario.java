/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import javax.servlet.http.Part;

/**
 *
 * @author antooro
 */


public class Usuario {
    private int idUsuario;
    private String nombre;
    private String nombreUsuario;
    private String contrasena;
    private String email;
    private int telefono;
    private int esAdmin;
    private Part fichImagen;
    public Usuario(){
        this.idUsuario = -1;
        this.nombre = contrasena;
        this.nombreUsuario = email;
        this.contrasena = "";
        this.email = "";
        this.telefono = -1;
        this.fichImagen = null;
        this.esAdmin = 0;
    }
    public Usuario(String nombreUsuario, String contrasena, String email){
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.email = email;
    }
    public Usuario(int idUsuario,String nombre,String nombreUsuario, String contrasena, String email,int telefono,  Part fichImagen, int esAdmin){
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.email = email;
        this.telefono = telefono;
        this.fichImagen = fichImagen;
        this.esAdmin = esAdmin;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Part getFichImagen() {
        return fichImagen;
    }

    public void setFichImagen(Part fichImagen) {
        this.fichImagen = fichImagen;
    }
    
    public void setAdmin(int esAdmin){
        this.esAdmin = esAdmin;
    }
    
    public int getAdmin(){
        return esAdmin;
    }
}
