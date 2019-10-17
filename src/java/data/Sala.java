/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author saul
 */
public class Sala {
    
    private int numeroDeSala;
    private int numeroDeFilas;
    private int numeroDeColumnas;
    
    public Sala(int numeroDeSala , int numeroDeFilas ,int numeroDeColumnas){
        this.numeroDeColumnas = numeroDeColumnas;
        this.numeroDeFilas = numeroDeFilas;
        this.numeroDeSala=numeroDeSala;
        
    }
    public void setNumeroDeSala(int numeroDeSala){
        this.numeroDeSala=numeroDeSala;
    }
    public void setNumeroDeFila(int numeroDeFilas){
        this.numeroDeFilas = numeroDeFilas;
    }
    public void setNumeroDeColumna(int numeroDeColumnas){
        this.numeroDeColumnas = numeroDeColumnas;
    }
    public int getnumeroDeSala(){
        return numeroDeSala;
    }
     public int getNumeroDeFila(){
        return numeroDeFilas;
    }
     public int getNumeroDeColumana(){
        return numeroDeColumnas;
    }
    
}
