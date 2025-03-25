/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Clases.Partido;
import Interfaces.CRUD;
import Modelos.ModeloEstadio;
import java.util.LinkedList;

/**
 *
 * @author usuario
 */
public class ControladorEstadio implements CRUD{
    private ModeloEstadio miEstadio;
    private ControladorPartido miControladorPartido;

    public ControladorEstadio() {
        this.miEstadio = new ModeloEstadio();
        this.miControladorPartido = new ControladorPartido();
    }
    

    @Override
    public boolean Create(Object elObjeto) {
        return this.miEstadio.Create(elObjeto);
    }

    @Override
    public Object get(String id) {
        return this.miEstadio.get(id);
    }

    @Override
    public LinkedList<Object> index() {
        return this.miEstadio.index();
    }

    @Override
    public Object Update(Object elObjeto) {
        return this.miEstadio.Update(elObjeto);
    }

    @Override
    public boolean Delete(String id) {
        return this.miEstadio.Delete(id);
    }

    /**
     * @return the miEstadio
     */
    public ModeloEstadio getMiEstadio() {
        return miEstadio;
    }

    /**
     * @param miEstadio the miEstadio to set
     */
    public void setMiEstadio(ModeloEstadio miEstadio) {
        this.miEstadio = miEstadio;
    }
    
    public int getGolesTotales(String id){
        LinkedList<Partido> misPartidos = this.miControladorPartido.getPartidoEstadio(id);
        int total = 0;
        
        for(Partido actual:misPartidos){
            String idPartido = actual.getId();
            total += this.miControladorPartido.getGoles(idPartido);
        }
        return total;
    }
    
}
