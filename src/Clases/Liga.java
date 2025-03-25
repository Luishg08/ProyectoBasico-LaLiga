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
public class Liga {
    private String id;
    private String nombre; 
    private LinkedList<Equipo> misEquipos;
    private LinkedList<Jornada> misJornadas;
    private LinkedList<Persona> misPersonas;
    private LinkedList<Estadio> misEstadios;
    
    public Liga(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.misEquipos=new LinkedList<>();
        this.misJornadas= new LinkedList<>();
        this.misPersonas= new LinkedList<>();
        this.misEstadios= new LinkedList<>();
    }

    
    
    public Jugador masJoven(){
        Jugador respuesta = null;
        int menor = Integer.MAX_VALUE;
        for(Persona personaActual:this.misPersonas){
            if(personaActual instanceof Jugador){
                Jugador aux = (Jugador)personaActual;
                if(aux.getEdad()<menor){
                    menor = aux.getEdad();
                    respuesta = aux;
                }
            }
        }
        return respuesta;
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
     * @return the misEquipos
     */
    public LinkedList<Equipo> getMisEquipos() {
        return misEquipos;
    }

    /**
     * @param misEquipos the misEquipos to set
     */
    public void setMisEquipos(LinkedList<Equipo> misEquipos) {
        this.misEquipos = misEquipos;
    }

    /**
     * @return the misJornadas
     */
    public LinkedList<Jornada> getMisJornadas() {
        return misJornadas;
    }

    /**
     * @param misJornadas the misJornadas to set
     */
    public void setMisJornadas(LinkedList<Jornada> misJornadas) {
        this.misJornadas = misJornadas;
    }

    /**
     * @return the misPersonas
     */
    public LinkedList<Persona> getMisPersonas() {
        return misPersonas;
    }

    /**
     * @param misPersonas the misPersonas to set
     */
    public void setMisPersonas(LinkedList<Persona> misPersonas) {
        this.misPersonas = misPersonas;
    }

    /**
     * @return the misEstadios
     */
    public LinkedList<Estadio> getMisEstadios() {
        return misEstadios;
    }

    /**
     * @param misEstadios the misEstadios to set
     */
    public void setMisEstadios(LinkedList<Estadio> misEstadios) {
        this.misEstadios = misEstadios;
    }
    
}
