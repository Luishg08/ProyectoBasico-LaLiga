/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author usuario
 */
public class Jugador extends Persona{
    private String nacionalidad;
    private String posicion;
    private int golesMarcados;
    private double salario;
    private Manager miManager;
    private Equipo miEquipo;

    public Jugador(String cedula, String nombre, String apellido, int edad, String nacionaliddad, String posicion, int golesMarcados, double salario) {
        super(cedula, nombre, apellido, edad);
        this.nacionalidad = nacionaliddad;
        this.posicion = posicion;
        this.golesMarcados = golesMarcados;
        this.salario = salario;
    }
    
    /**
     * @return the nacionaliddad
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * @param nacionalidad the nacionaliddad to set
     */
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    /**
     * @return the posicion
     */
    public String getPosicion() {
        return posicion;
    }

    /**
     * @param posicion the posicion to set
     */
    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    /**
     * @return the golesMarcados
     */
    public int getGolesMarcados() {
        return golesMarcados;
    }

    /**
     * @param golesMarcados the golesMarcados to set
     */
    public void setGolesMarcados(int golesMarcados) {
        this.golesMarcados = golesMarcados;
    }

    /**
     * @return the salario
     */
    public double getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(double salario) {
        this.salario = salario;
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
