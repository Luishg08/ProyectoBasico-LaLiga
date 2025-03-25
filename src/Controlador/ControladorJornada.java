/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Clases.Partido;
import Interfaces.CRUD;
import Modelos.ModeloJornada;
import java.util.LinkedList;

/**
 *
 * @author usuario
 */
public class ControladorJornada implements CRUD {
    private ModeloJornada miJornada;
    private ControladorPartido miControladorPartido;
    
    public ControladorJornada() {
        this.miJornada = new ModeloJornada();
        this.miControladorPartido = new ControladorPartido();
    }

    @Override
    public boolean Create(Object elObjeto) {
        return this.getMiJornada().Create(elObjeto);
    }

    @Override
    public Object get(String id) {
        return this.getMiJornada().get(id);
    }

    @Override
    public LinkedList<Object> index() {
        return this.getMiJornada().index();
    }

    @Override
    public Object Update(Object elObjeto) {
        return this.getMiJornada().Update(elObjeto);
    }

    @Override
    public boolean Delete(String id) {
        return this.getMiJornada().Delete(id);
    }

    /**
     * @return the miJornada
     */
    public ModeloJornada getMiJornada() {
        return miJornada;
    }

    /**
     * @param miJornada the miJornada to set
     */
    public void setMiJornada(ModeloJornada miJornada) {
        this.miJornada = miJornada;
    }
    public int partidosGoleada(String id){
        LinkedList<Partido> misPartidos = this.miControladorPartido.getPartidosJornada(id);
        int contador = 0;
        for(Partido partido: misPartidos){
            String idPartido = partido.getId();
            Partido partidoActual = (Partido)this.miControladorPartido.get(idPartido);
            
            if(partidoActual.getGolesLocal()>= partidoActual.getGolesVisitante()+4){
                contador++;
            }
            else if(partidoActual.getGolesVisitante()>=partidoActual.getGolesLocal()+4){
                contador++;
            }            
        }
        
        return contador;
    }
}
