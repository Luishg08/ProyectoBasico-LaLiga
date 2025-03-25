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
public class Manager extends Persona{
    private int añosAfiliacion;
    private Equipo miEquipo;
    private LinkedList<Jugador> miJugadores;

    public Manager(String cedula, String nombre, String apellido, int edad, int añosAfiliacion) {
        super(cedula, nombre, apellido, edad);
        this.añosAfiliacion = añosAfiliacion;
        this.miJugadores= new LinkedList<>();
    }
    
    /**
     * @return the añosAfiliacion
     */
    public int getAñosAfiliacion() {
        return añosAfiliacion;
    }

    /**
     * @param añosAfiliacion the añosAfiliacion to set
     */
    public void setAñosAfiliacion(int añosAfiliacion) {
        this.añosAfiliacion = añosAfiliacion;
    }

    /**
     * @return the miEquipo
     */
    public Equipo getMiEquipo() {
        return miEquipo;
    }

    /**
     * @param miEquipo the miEquipo to set
     */
    public void setMiEquipo(Equipo miEquipo) {
        this.miEquipo = miEquipo;
    }

    /**
     * @return the miJugadores
     */
    public LinkedList<Jugador> getMiJugadores() {
        return miJugadores;
    }

    /**
     * @param miJugadores the miJugadores to set
     */
    public void setMiJugadores(LinkedList<Jugador> miJugadores) {
        this.miJugadores = miJugadores;
    }
    
}
