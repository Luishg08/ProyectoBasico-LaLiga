/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.LinkedList;

/**
 *
 * @author usuario
 */
public class Equipo {
    private String id;
    private String nombre;
    private int añoFundacion;
    private int titulosNacionales;
    private int titulosInternacionales;
    private int puntos;
    private int golesAFavor;
    private int golesEnContra;
    private int partidosJugados; 
    private Liga miLiga;
    private Tecnico miTecnico;
    private Manager miManager;
    private LinkedList<Aficionado> misAficionados;
    private LinkedList<Jugador>misJugadores;
    private LinkedList<Partido> misPartidos;

    public Equipo(String id, String nombre, int añoFundacion, int titulosNacionales, int titulosInternacionales, int puntos, int golesAFavor, int golesEnContra, int partidosJugados) {
        this.id = id;
        this.nombre = nombre;
        this.añoFundacion = añoFundacion;
        this.titulosNacionales = titulosNacionales;
        this.titulosInternacionales = titulosInternacionales;
        this.puntos = puntos;
        this.golesAFavor = golesAFavor;
        this.golesEnContra = golesEnContra;
        this.partidosJugados = partidosJugados;
        this.misAficionados= new LinkedList<>();
        this.misJugadores= new LinkedList<>();
        this.misPartidos=new LinkedList<>();
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the añoFundacion
     */
    public int getAñoFundacion() {
        return añoFundacion;
    }

    /**
     * @param añoFundacion the añoFundacion to set
     */
    public void setAñoFundacion(int añoFundacion) {
        this.añoFundacion = añoFundacion;
    }

    /**
     * @return the titulosNacionales
     */
    public int getTitulosNacionales() {
        return titulosNacionales;
    }

    /**
     * @param titulosNacionales the titulosNacionales to set
     */
    public void setTitulosNacionales(int titulosNacionales) {
        this.titulosNacionales = titulosNacionales;
    }

    /**
     * @return the titulosInternacionales
     */
    public int getTitulosInternacionales() {
        return titulosInternacionales;
    }

    /**
     * @param titulosInternacionales the titulosInternacionales to set
     */
    public void setTitulosInternacionales(int titulosInternacionales) {
        this.titulosInternacionales = titulosInternacionales;
    }

    /**
     * @return the puntos
     */
    public int getPuntos() {
        return puntos;
    }

    /**
     * @param puntos the puntos to set
     */
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    /**
     * @return the golesAFavor
     */
    public int getGolesAFavor() {
        return golesAFavor;
    }

    /**
     * @param golesAFavor the golesAFavor to set
     */
    public void setGolesAFavor(int golesAFavor) {
        this.golesAFavor = golesAFavor;
    }

    /**
     * @return the golesEnContra
     */
    public int getGolesEnContra() {
        return golesEnContra;
    }

    /**
     * @param golesEnContra the golesEnContra to set
     */
    public void setGolesEnContra(int golesEnContra) {
        this.golesEnContra = golesEnContra;
    }

    /**
     * @return the partidosJugados
     */
    public int getPartidosJugados() {
        return partidosJugados;
    }

    /**
     * @param partidosJugados the partidosJugados to set
     */
    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    /**
     * @return the miLiga
     */
    public Liga getMiLiga() {
        return miLiga;
    }

    /**
     * @param miLiga the miLiga to set
     */
    public void setMiLiga(Liga miLiga) {
        this.miLiga = miLiga;
    }

    /**
     * @return the miTecnico
     */
    public Tecnico getMiTecnico() {
        return miTecnico;
    }

    /**
     * @param miTecnico the miTecnico to set
     */
    public void setMiTecnico(Tecnico miTecnico) {
        this.miTecnico = miTecnico;
    }

    /**
     * @return the miManager
     */
    public Manager getMiManager() {
        return miManager;
    }

    /**
     * @param miManager the miManager to set
     */
    public void setMiManager(Manager miManager) {
        this.miManager = miManager;
    }

    /**
     * @return the misAficionados
     */
    public LinkedList<Aficionado> getMisAficionados() {
        return misAficionados;
    }

    /**
     * @param misAficionados the misAficionados to set
     */
    public void setMisAficionados(LinkedList<Aficionado> misAficionados) {
        this.misAficionados = misAficionados;
    }

    /**
     * @return the misJugadores
     */
    public LinkedList<Jugador> getMisJugadores() {
        return misJugadores;
    }

    /**
     * @param misJugadores the misJugadores to set
     */
    public void setMisJugadores(LinkedList<Jugador> misJugadores) {
        this.misJugadores = misJugadores;
    }

    /**
     * @return the misPartidos
     */
    public LinkedList<Partido> getMisPartidos() {
        return misPartidos;
    }

    /**
     * @param misPartidos the misPartidos to set
     */
    public void setMisPartidos(LinkedList<Partido> misPartidos) {
        this.misPartidos = misPartidos;
    }
    
    
}
