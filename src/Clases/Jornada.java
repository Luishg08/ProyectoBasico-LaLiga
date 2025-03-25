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
public class Jornada {
    private String id;
    private int numeroJ;
    private String esloganFIFA;
    private Liga miLiga;
    private LinkedList<Partido> misPartidos;

    public Jornada(String id, int numeroJ, String esloganFIFA) {
        this.id = id;
        this.numeroJ = numeroJ;
        this.esloganFIFA = esloganFIFA;
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
     * @return the numeroJ
     */
    public int getNumeroJ() {
        return numeroJ;
    }

    /**
     * @param numeroJ the numeroJ to set
     */
    public void setNumeroJ(int numeroJ) {
        this.numeroJ = numeroJ;
    }

    /**
     * @return the esloganFIFA
     */
    public String getEsloganFIFA() {
        return esloganFIFA;
    }

    /**
     * @param esloganFIFA the esloganFIFA to set
     */
    public void setEsloganFIFA(String esloganFIFA) {
        this.esloganFIFA = esloganFIFA;
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
