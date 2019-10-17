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
public class Valoracion {
    private int idUsuario;
    private int idPelicula;
    private int nota;
    
    
    
    public Valoracion(int idUsuario, int idPelicula, int nota){
        this.idUsuario= idUsuario;
        this.idPelicula = idPelicula;
        this.nota = nota;
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

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
}
