/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author usuario
 */
public class Aficionado extends Persona{
    private int añosFidelidad;
    private boolean abonado;
    private Equipo miEquipo;

    public Aficionado(String cedula, String nombre, String apellido, int edad, int añosFidelidad, boolean abonado) {
        super(cedula, nombre, apellido, edad);
        this.añosFidelidad = añosFidelidad;
        this.abonado = abonado;
    }
    
    /**
     * @return the añosFidelidad
     */
    public int getAñosFidelidad() {
        return añosFidelidad;
    }

    /**
     * @param añosFidelidad the añosFidelidad to set
     */
    public void setAñosFidelidad(int añosFidelidad) {
        this.añosFidelidad = añosFidelidad;
    }

    /**
     * @return the abonado
     */
    public boolean isAbonado() {
        return abonado;
    }

    /**
     * @param abonado the abonado to set
     */
    public void setAbonado(boolean abonado) {
        this.abonado = abonado;
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
    
}
