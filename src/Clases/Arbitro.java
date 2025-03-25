/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author usuario
 */
public class Arbitro extends Persona{
    private boolean aFIFA;
    private Partido miPartido;

    public Arbitro(String cedula, String nombre, String apellido, int edad, boolean aFIFA) {
        super(cedula, nombre, apellido, edad);
        this.aFIFA = aFIFA;
    }
    
    /**
     * @return the aFIFA
     */
    public boolean isaFIFA() {
        return aFIFA;
    }

    /**
     * @param aFIFA the aFIFA to set
     */
    public void setaFIFA(boolean aFIFA) {
        this.aFIFA = aFIFA;
    }

    /**
     * @return the miPartido
     */
    public Partido getMiPartido() {
        return miPartido;
    }

    /**
     * @param miPartido the miPartido to set
     */
    public void setMiPartido(Partido miPartido) {
        this.miPartido = miPartido;
    }
    
}
