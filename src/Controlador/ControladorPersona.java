/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Clases.*;
import Modelos.ModeloAficionado;
import Modelos.ModeloArbitro;
import Modelos.ModeloJugador;
import Modelos.ModeloManager;
import Modelos.ModeloTecnico;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author usuario
 */
public class ControladorPersona implements Interfaces.CRUD{
    private ModeloAficionado miAficionado;
    private ModeloArbitro miArbitro;
    private ModeloJugador miJugador;
    private ModeloManager miManager;
    private ModeloTecnico miTecnico;

    public ControladorPersona() {
        this.miAficionado = new ModeloAficionado();
        this.miArbitro = new ModeloArbitro();
        this.miJugador = new ModeloJugador();
        this.miManager = new ModeloManager();
        this.miTecnico = new ModeloTecnico();
    }
    

    @Override
    public boolean Create(Object elObjeto) {
        boolean exito = false;
        
        if(elObjeto instanceof Aficionado){
            exito = this.getMiAficionado().Create(elObjeto);
        }
        else if(elObjeto instanceof Arbitro){
            exito = this.getMiArbitro().Create(elObjeto);
        }
        else if(elObjeto instanceof Jugador){
            exito = this.getMiJugador().Create(elObjeto);            
        }
        else if(elObjeto instanceof Manager){
            exito = this.getMiManager().Create(elObjeto);
        }
        else{
            exito = this.getMiTecnico().Create(elObjeto);
        }
        return exito;
    }

    @Override
    public Object get(String id) {
        Aficionado aficionadoEncontrado = (Aficionado)this.getMiAficionado().get(id);
        Arbitro arbitroEncontrado = (Arbitro)this.getMiArbitro().get(id);
        Jugador jugadorEncontrado = (Jugador)this.getMiJugador().get(id);
        Manager managerEncontrado = (Manager)this.getMiManager().get(id);
        Tecnico tecnicoEncontrado = (Tecnico)this.getMiTecnico().get(id);
        
        if(aficionadoEncontrado!=null){
            return aficionadoEncontrado;
        }
        else if(arbitroEncontrado!=null){
            return arbitroEncontrado;
        }
        else if(jugadorEncontrado!=null){
            return jugadorEncontrado;
        }
        else if(managerEncontrado!=null){
            return managerEncontrado;
        }
        else if(tecnicoEncontrado!=null){
            return tecnicoEncontrado;
        }
        else{
            return null;
        }

    }

    @Override
    public LinkedList<Object> index() {
        LinkedList<Object> personas = new LinkedList<>();
        personas.addAll(this.getMiAficionado().index());
        personas.addAll(this.getMiArbitro().index());
        personas.addAll(this.getMiJugador().index());
        personas.addAll(this.getMiManager().index());
        personas.addAll(this.getMiTecnico().index());
        
        return personas;
        
                
        
    }

    @Override
    public Object Update(Object elObjeto) {
        Object exito = null;
        
        if(elObjeto instanceof Aficionado){
            exito = this.getMiAficionado().Update(elObjeto);
        }
        else if(elObjeto instanceof Arbitro){
            exito = this.getMiArbitro().Update(elObjeto);
        }
        else if(elObjeto instanceof Jugador){
            exito = this.getMiJugador().Update(elObjeto);            
        }
        else if(elObjeto instanceof Manager){
            exito = this.getMiManager().Update(elObjeto);
        }
        else{
            exito = this.getMiTecnico().Update(elObjeto);
        }
        return exito;
    }

    @Override
    public boolean Delete(String id) {
        boolean exitoAficionado = false;
        exitoAficionado = this.getMiAficionado().Delete(id);
        boolean exitoArbitro = false;
        exitoArbitro = this.getMiArbitro().Delete(id);
        boolean exitoJugador = false;
        exitoJugador = this.getMiJugador().Delete(id);
        boolean exitoManager = false;
        exitoManager = this.getMiManager().Delete(id);         
        boolean exitoTecnico = false;
        exitoTecnico = this.getMiTecnico().Delete(id);
        
        return exitoManager||exitoAficionado || exitoArbitro || exitoJugador||exitoTecnico||exitoManager;
    
}

    /**
     * @return the miAficionado
     */
    public ModeloAficionado getMiAficionado() {
        return miAficionado;
    }

    /**
     * @param miAficionado the miAficionado to set
     */
    public void setMiAficionado(ModeloAficionado miAficionado) {
        this.miAficionado = miAficionado;
    }

    /**
     * @return the miArbitro
     */
    public ModeloArbitro getMiArbitro() {
        return miArbitro;
    }

    /**
     * @param miArbitro the miArbitro to set
     */
    public void setMiArbitro(ModeloArbitro miArbitro) {
        this.miArbitro = miArbitro;
    }

    /**
     * @return the miJugador
     */
    public ModeloJugador getMiJugador() {
        return miJugador;
    }

    /**
     * @param miJugador the miJugador to set
     */
    public void setMiJugador(ModeloJugador miJugador) {
        this.miJugador = miJugador;
    }

    /**
     * @return the miManager
     */
    public ModeloManager getMiManager() {
        return miManager;
    }

    /**
     * @param miManager the miManager to set
     */
    public void setMiManager(ModeloManager miManager) {
        this.miManager = miManager;
    }

    /**
     * @return the miTecnico
     */
    public ModeloTecnico getMiTecnico() {
        return miTecnico;
    }

    /**
     * @param miTecnico the miTecnico to set
     */
    public void setMiTecnico(ModeloTecnico miTecnico) {
        this.miTecnico = miTecnico;
    }
        
    public boolean setEquipo(Object persona,String idEquipo){
        boolean exito = false;
        if(persona instanceof Aficionado){
            exito = this.getMiAficionado().setEquipo(persona, idEquipo);
        }
        else if(persona instanceof Jugador){
            exito = this.getMiJugador().setEquipo(persona, idEquipo);            
        }
        else if(persona instanceof Manager){
            exito = this.getMiManager().setEquipo(persona, idEquipo);
        }
        else{
            exito = this.getMiTecnico().setEquipo(persona, idEquipo);
        }
        
        return exito;
    }
    
    public LinkedList<Jugador> getJugadoresEquipo(String id){
        LinkedList<Object> jugadores = this.miJugador.index();
        LinkedList<Jugador> respuesta = new LinkedList<>();
        for(Object actual: jugadores){
            if(actual instanceof Jugador){
                if(((Jugador)actual).getMiEquipo()!=null){
                    if(((Jugador)actual).getMiEquipo().getId().equals(id)){
                    respuesta.add((Jugador)actual);
                }
                }
            }
        }
        return respuesta;
    }
    
    public LinkedList<Aficionado> getAficionadosEquipo(String id){
        LinkedList<Object> jugadores = this.miAficionado.index();
        LinkedList<Aficionado> respuesta = new LinkedList<>();
        for(Object actual: jugadores){
            if(actual instanceof Aficionado){
                if(((Aficionado)actual).getMiEquipo().getId().equals(id)){
                    respuesta.add((Aficionado)actual);
                }
            }
        }
        return respuesta;
    }
    public LinkedList<Jugador> getJugadoresManager(String id){
        LinkedList<Object> jugadores = this.miJugador.index();
        LinkedList<Jugador> respuesta = new LinkedList<>();
        for(Object actual: jugadores){
            if(actual instanceof Jugador){
                if(((Jugador) actual).getMiManager()!=null){
                if(((Jugador)actual).getMiManager().getCedula().equals(id)){
                    respuesta.add((Jugador)actual);
                }
                }
            }
        }
        return respuesta;
    }
    
    }
