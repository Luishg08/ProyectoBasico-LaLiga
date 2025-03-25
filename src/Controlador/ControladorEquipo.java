/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Clases.Aficionado;
import Clases.Equipo;
import Clases.Jugador;
import Clases.Manager;
import Clases.Tecnico;
import Modelos.ModeloEquipo;
import java.util.LinkedList;

/**
 *
 * @author usuario
 */
public class ControladorEquipo implements Interfaces.CRUD {
    private ControladorPersona miControladorPersona;
    private ModeloEquipo miModeloEquipo;
    
    public ControladorEquipo() {
        this.miModeloEquipo = new ModeloEquipo();
        this.miControladorPersona = new ControladorPersona();
    }
    
    
    @Override
    public boolean Create(Object elObjeto) {
        return this.miModeloEquipo.Create(elObjeto);
    }

    @Override
    public Object get(String id) {
        Object respuesta = this.miModeloEquipo.get(id);
        return respuesta;
    }

    @Override
    public LinkedList<Object> index() {
        return this.miModeloEquipo.index();
    }

    @Override
    public Object Update(Object elObjeto) {
        return this.miModeloEquipo.Update(elObjeto);
    }

    @Override
    public boolean Delete(String id) {
        return this.miModeloEquipo.Delete(id);
    }

    /**
     * @return the miEquipo
     */
    public ModeloEquipo getMiModeloEquipo() {
        return miModeloEquipo;
    }

    /**
     * @param miModeloEquipo the miEquipo to set
     */
    public void setMiModeloEquipo(ModeloEquipo miModeloEquipo) {
        this.miModeloEquipo = miModeloEquipo;
    }
    
    public boolean setMiPersona(Object equipo,Object Persona){        
        return this.miModeloEquipo.setMiPersona(equipo, Persona);
    }
    
    public Jugador jugadorMasJoven(String idEquipo){
        LinkedList<Jugador> misJugadores = this.miControladorPersona.getJugadoresEquipo(idEquipo);
        int menor = Integer.MAX_VALUE;
        Jugador respuesta = null;
        for(Jugador actual: misJugadores){
            if(actual.getEdad()<menor){
                respuesta = actual;
                menor = actual.getEdad();
            }
        }
        return respuesta;
    }
    
    public double promedioEdad(String idEquipo){
        LinkedList<Jugador> misJugadores = this.miControladorPersona.getJugadoresEquipo(idEquipo);
        int contador = 0;
        double promedio = 0.0;
        for(Jugador actual:misJugadores){
            promedio = promedio+actual.getEdad();
            contador++;
        }
        Equipo equipoActual = (Equipo)get(idEquipo);
        
        LinkedList<Aficionado> misAficionados = this.miControladorPersona.getAficionadosEquipo(idEquipo);
        for(Aficionado actual:misAficionados){
            promedio = promedio+actual.getEdad();
            contador++;
        }
        
        if(equipoActual.getMiManager()!=null && equipoActual.getMiTecnico()!=null){
        Manager managerEquipo = (Manager)this.miControladorPersona.get(equipoActual.getMiManager().getCedula());
        promedio = promedio+managerEquipo.getEdad();
        contador+=1;
        Tecnico tecnicoEquipo = (Tecnico)this.miControladorPersona.get(equipoActual.getMiTecnico().getCedula());
        promedio = promedio+tecnicoEquipo.getEdad();
        contador+=1;
        }
        
        promedio = promedio/contador;
        return promedio;
        
    }
    
    public Jugador jugadorMasGoles(String idEquipo){
        LinkedList<Jugador> misJugadores = this.miControladorPersona.getJugadoresEquipo(idEquipo);
        int mayor = Integer.MIN_VALUE;
        Jugador respuesta = null;
        for(Jugador actual: misJugadores){
            if(actual.getGolesMarcados()>mayor){
                respuesta = actual;
                mayor = actual.getEdad();
            }
        }
        return respuesta;
    }
    
    public double getNomina(String idEquipo){
        LinkedList<Jugador> misJugadores = this.miControladorPersona.getJugadoresEquipo(idEquipo);
        Equipo equipoActual = (Equipo)get(idEquipo);
        double respuesta =0;
        for(Jugador actual: misJugadores){
            respuesta +=actual.getSalario();
        }
        if(equipoActual.getMiTecnico()!=null){
        Tecnico tecnico = (Tecnico)this.miControladorPersona.get(equipoActual.getMiTecnico().getCedula());
        respuesta += tecnico.getSalario();
    }
       
        return respuesta;
    }
    
    public int getNumeroAficionados(String idEquipo){
        LinkedList<Aficionado> misAficionados = this.miControladorPersona.getAficionadosEquipo(idEquipo);
        return misAficionados.size();                
    }
    
    public Jugador getArquero(String id){
        LinkedList<Jugador> misJugadores = this.miControladorPersona.getJugadoresEquipo(id);
        Jugador respuesta = null;
        
        for(Jugador actual:misJugadores){
            if(actual.getPosicion().equals("Guardameta")){
                respuesta = actual;
            }
        }
        return respuesta;
    }
    
    public int GolesEquipoMasPuntos(){
        LinkedList<Object> losEquipos = this.miModeloEquipo.index();
        int masPuntos = Integer.MIN_VALUE;
        int respuesta = 0;
        for(Object equipo: losEquipos){
            Equipo equipoActual = (Equipo)equipo;
            if(equipoActual.getPuntos()>masPuntos){
                masPuntos = equipoActual.getPuntos();
                respuesta = equipoActual.getGolesAFavor();
            }            
        }
        return respuesta;
    }
}
