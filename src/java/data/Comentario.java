/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author antooro
 */
public class Comentario {
    private int idUsuario;
    private int idPelicula;
    private String comentario;
    
    
    
    public Comentario(int idUsuario, int idPelicula, String comentario){
        this.idUsuario= idUsuario;
        this.idPelicula = idPelicula;
        this.comentario = comentario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getComentario() {
        return comentario;
    }

    public void getComentario(int nota) {
        this.comentario = comentario;
    }
}
