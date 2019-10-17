/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import java.time.LocalTime;
import java.time.LocalDate;

/**
 *
 * @author saul
 */
public class Sesion {
    
    private Pelicula pelicula;
    private Sala sala;
    private LocalTime horaDeInicio;
    private int precioBase;
    private LocalDate fechaSesion;

    public Sesion(Pelicula pelicula, Sala sala, LocalTime horaDeInicio, int precioBase, LocalDate fechaSesion) {
        this.pelicula = pelicula;
        this.sala = sala;
        this.horaDeInicio = horaDeInicio;
        this.precioBase = precioBase;
        this.fechaSesion = fechaSesion;
    }

    public LocalDate getFechaSesion() {
        return fechaSesion;
    }

    public void setFechaSesion(LocalDate fechaSesion) {
        this.fechaSesion = fechaSesion;
    }
    

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public LocalTime getHoraDeInicio() {
        return horaDeInicio;
    }

    public void setHoraDeInicio(LocalTime horaDeInicio) {
        this.horaDeInicio = horaDeInicio;
    }

    public int getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(int precioBase) {
        this.precioBase = precioBase;
    }
    
}
