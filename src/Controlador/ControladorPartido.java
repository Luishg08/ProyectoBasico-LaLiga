/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Clases.Arbitro;
import Clases.Equipo;
import Clases.Partido;
import Interfaces.CRUD;
import Modelos.ModeloPartido;
import java.util.LinkedList;

/**
 *
 * @author usuario
 */
public class ControladorPartido implements CRUD {
    private ModeloPartido miPartido;
            

    public ControladorPartido() {
        this.miPartido = new ModeloPartido();
    }

    @Override
    public boolean Create(Object elObjeto) {
        return this.getMiPartido().Create(elObjeto);
    }

    @Override
    public Object get(String id) {
        return this.getMiPartido().get(id);
    }

    @Override
    public LinkedList<Object> index() {
        return this.miPartido.index();
    }

    @Override
    public Object Update(Object elObjeto) {
        return this.miPartido.Update(elObjeto);
    }

    @Override
    public boolean Delete(String id) {
        return this.miPartido.Delete(id);
    }
    
    
    public boolean setEquipoLocalYVisitanteYGoles(String idPartido,Equipo local,int golesLocal,Equipo visitante, int golesVisitante){
        return this.getMiPartido().setEquipoLocalYVisitanteYGoles(idPartido, local, golesLocal, visitante, golesVisitante);
    }
    
    public boolean setJornada(String idPartido, String idJornada){
        return this.getMiPartido().setJornada(idPartido, idJornada);
    }
    public boolean setArbitro(String idArbitro, String idPartido){
        return this.getMiPartido().setArbitro(idArbitro, idPartido);
    }
    public boolean setEstadio(String idEstadio,String idPartido){
        return this.getMiPartido().setEstadio(idEstadio, idPartido);
    }

    /**
     * @return the miPartido
     */
    public ModeloPartido getMiPartido() {
        return miPartido;
    }

    /**
     * @param miPartido the miPartido to set
     */
    public void setMiPartido(ModeloPartido miPartido) {
        this.miPartido = miPartido;
    }
    public LinkedList<Partido> getPartidosEquipo(String id){
        LinkedList<Object> partidos = this.miPartido.index();
        LinkedList<Partido> respuesta = new LinkedList<>();
        for(Object actual: partidos){
            if(actual instanceof Partido){
                if(((Partido)actual).getEquipoLocal().getId().equals(id)){
                    respuesta.add((Partido)actual);
                }
                else if(((Partido)actual).getEquipoVisitante().getId().equals(id)){
                    respuesta.add((Partido)actual);
                }
            }
        }
        return respuesta;
    }
    
    public LinkedList<Partido> getPartidosJornada(String id){
        LinkedList<Object> partidos = this.miPartido.index();
        LinkedList<Partido> respuesta = new LinkedList<>();
        for(Object actual: partidos){
            if(actual instanceof Partido){
                if(((Partido)actual).getMiJornada().getId().equals(id)){
                    respuesta.add((Partido)actual);
                }
              
            }
        }
        return respuesta;
    }
    public LinkedList<Partido> getPartidoEstadio(String id){
        LinkedList<Object> partidos = this.miPartido.index();
        LinkedList<Partido> respuesta = new LinkedList<>();
        for(Object actual: partidos){
            if(actual instanceof Partido){
                if(((Partido)actual).getMiEstadio().getId().equals(id)){
                    respuesta.add((Partido)actual);
                }
              
            }
        }
        return respuesta;
    }
    
     public int getGoles(String id){
        Partido partido = (Partido)get(id);
        return partido.getGolesLocal()+partido.getGolesVisitante();
    }
}
