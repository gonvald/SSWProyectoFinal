/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author saul
 */
public class Entrada {

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }
    private int idcine;
    private int numeroDeFila;
    private int numeroDeColumna;
    private double precio;
    private int idpelicula;
    private int idusuario;
    private int numsala;
    private Date fecha;
    private Time hora;
    
    public Entrada(int idcine, int numeroDeFila, int numeroDeColumna, double precio, int idpelicula, int idusuario, int numsala,Date fecha, Time hora) {
        this.idcine = idcine;
        this.numeroDeFila = numeroDeFila;
        this.numeroDeColumna = numeroDeColumna;
        this.precio = precio;
        this.idpelicula = idpelicula;
        this.idusuario = idusuario;
        this.numsala = numsala;
        this.fecha = fecha;
        this.hora = hora;
    }
    public int getIdcine() {
        return idcine;
    }

    public void setIdcine(int idcine) {
        this.idcine = idcine;
    }

    public int getNumeroDeFila() {
        return numeroDeFila;
    }

    public void setNumeroDeFila(int numeroDeFila) {
        this.numeroDeFila = numeroDeFila;
    }

    public int getNumeroDeColumna() {
        return numeroDeColumna;
    }

    public void setNumeroDeColumna(int numeroDeColumna) {
        this.numeroDeColumna = numeroDeColumna;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getIdpelicula() {
        return idpelicula;
    }

    public void setIdpelicula(int idpelicula) {
        this.idpelicula = idpelicula;
    }


    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getNumsala() {
        return numsala;
    }

    public void setNumsala(int numsala) {
        this.numsala = numsala;
    }
    
    
}
