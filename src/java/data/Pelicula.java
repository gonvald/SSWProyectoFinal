/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import java.util.*;
import javax.servlet.http.Part;
import bbdd.peliculasDB;

/**
 *
 * @author saul
 */
public class Pelicula {

    
    
    private int id;
    private String titulo;
    private double duracion;
    private Date fechaEstreno;
    private String sinopsis;
    private Part fichimagen;
    private String genero;
    private int cartelera;
    private String director;
    private String reparto;
    
    
    

    public Pelicula(int id, String titulo, double duracion, Date fechaEstreno, String sinopsis, String genero, int cartelera, String director, String reparto) {
        this.id = id;
        this.titulo = titulo;
        this.duracion = duracion;
        this.fechaEstreno = fechaEstreno;
        this.sinopsis = sinopsis;
        this.fichimagen = null;
        this.reparto = reparto;
        this.director = director;
        this.genero = genero;
        this.cartelera = cartelera;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getReparto() {
        return reparto;
    }

    public void setReparto(String reparto) {
        this.reparto = reparto;
    }

    public Pelicula(int id, String titulo, double duracion, Date fechaEstreno) {
        this.id = id;
        this.titulo = titulo;
        this.duracion = duracion;
        this.fechaEstreno = fechaEstreno;
        this.cartelera = 0;
    }
    public Pelicula(){
        id = id;
        titulo = "";
        duracion = 0;
        fechaEstreno = new Date(0,0,0);
        sinopsis = "";
        fichimagen = null;
        genero="";
        
    }
    
    //QUITAR (TODO)
    public static ArrayList getPeliculas() {
        return bbdd.peliculasDB.getPeliculas();   
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public Date getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(Date fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public Part getFichImagen() {
        return fichimagen;
    }

    public void setFichImagen(Part fichimagen) {
        this.fichimagen = fichimagen;
    }

  
    
    public int getCartelera() {
        return cartelera;
    }

    public void setCartelera(int cartelera) {
        this.cartelera = cartelera;
    }

   
    
}
