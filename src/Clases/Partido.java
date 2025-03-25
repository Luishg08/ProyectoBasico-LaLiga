/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author usuario
 */
public class Partido {
    private String id;
    private String fecha;
    private int golesLocal;
    private int golesVisitante; 
    private Estadio miEstadio;
    private Arbitro miArbitro;
    private Jornada miJornada;
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
           

    public Partido(String id, String fecha, int golesLocal, int golesVisitante) {
        this.id = id;
        this.fecha = fecha;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
        
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
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the golesLocal
     */
    public int getGolesLocal() {
        return golesLocal;
    }

    /**
     * @param golesLocal the golesLocal to set
     */
    public void setGolesLocal(int golesLocal) {
        this.golesLocal = golesLocal;
    }

    /**
     * @return the golesVisitante
     */
    public int getGolesVisitante() {
        return golesVisitante;
    }

    /**
     * @param golesVisitante the golesVisitante to set
     */
    public void setGolesVisitante(int golesVisitante) {
        this.golesVisitante = golesVisitante;
    }

    /**
     * @return the miEstadio
     */
    public Estadio getMiEstadio() {
        return miEstadio;
    }

    /**
     * @param miEstadio the miEstadio to set
     */
    public void setMiEstadio(Estadio miEstadio) {
        this.miEstadio = miEstadio;
    }

    /**
     * @return the miArbitro
     */
    public Arbitro getMiArbitro() {
        return miArbitro;
    }

    /**
     * @param miArbitro the miArbitro to set
     */
    public void setMiArbitro(Arbitro miArbitro) {
        this.miArbitro = miArbitro;
    }

    /**
     * @return the miJornada
     */
    public Jornada getMiJornada() {
        return miJornada;
    }

    /**
     * @param miJornada the miJornada to set
     */
    public void setMiJornada(Jornada miJornada) {
        this.miJornada = miJornada;
    }

    /**
     * @return the miEquipo
     */

    /**
     * @return the equipoLocal
     */
    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    /**
     * @param equipoLocal the equipoLocal to set
     */
    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    /**
     * @return the equipoVisitante
     */
    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    /**
     * @param equipoVisitante the equipoVisitante to set
     */
    public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }
    
    
}
