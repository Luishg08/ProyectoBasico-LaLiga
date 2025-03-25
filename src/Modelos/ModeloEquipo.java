/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import Clases.Aficionado;
import Clases.Equipo;
import Clases.Jugador;
import Clases.Manager;
import Clases.Partido;
import Clases.Tecnico;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author usuario
 */
public class ModeloEquipo implements Interfaces.CRUD,Interfaces.Persistencia{
    private List<Equipo> losEquipos;
    private List<Jugador> misJugadores;
    
    
    public ModeloEquipo() {
        this.losEquipos = new LinkedList<>();
        this.misJugadores = new LinkedList<>();
        cargar();
    }

    @Override
    public boolean Create(Object elObjeto) {
        return this.getLosEquipos().add((Equipo)elObjeto);
    }

    @Override
    public Object get(String id) {
        Equipo encontrado = null;
        int i=0;
        while(i<this.getLosEquipos().size() && encontrado==null){
            if(this.getLosEquipos().get(i).getId().equals(id)){
                encontrado = this.getLosEquipos().get(i);
            }
            i++;
        }
        return encontrado;
        
    }

    @Override
    public LinkedList<Object> index() {
        LinkedList<Object> respuesta = new LinkedList<>();
        for(Equipo equipoActual:this.getLosEquipos()){
            respuesta.add((Object)equipoActual);
        }
        return respuesta;
    }

    @Override
    public Object Update(Object elObjeto) {
        Equipo equipoNuevo = (Equipo)elObjeto;
        Equipo equipoViejo = (Equipo)get(equipoNuevo.getId());
        
        if(equipoViejo!=null){
            int indiceActual = this.getLosEquipos().indexOf(equipoViejo);
            this.getLosEquipos().set(indiceActual, equipoNuevo);
        }
        return equipoNuevo;
    }

    @Override
    public boolean Delete(String id) {
        boolean exito = false;
        Equipo encontrado = (Equipo)get(id);
        if(encontrado!=null){
            exito = this.getLosEquipos().remove(encontrado);
        }
        else{
           exito = false;
        }
        return exito;
    }

@Override
    public void guardar() {
        Gson gson = new Gson();
        try (Writer writer = new FileWriter("Equipos.json")) {
            gson.toJson(this.getLosEquipos(), writer);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    @Override
    public void cargar() {
       Gson gson = new Gson();
        try (Reader reader = new FileReader("Equipos.json")) {
            Type type = new TypeToken<List<Equipo>>() {
            }.getType();
            this.setLosEquipos(gson.fromJson(reader, type));

        } catch (Exception e) {

        }
    }

    /**
     * @return the losEquipos
     */
    public List<Equipo> getLosEquipos() {
        return losEquipos;
    }

    /**
     * @param losEquipos the losEquipos to set
     */
    public void setLosEquipos(List<Equipo> losEquipos) {
        this.losEquipos = losEquipos;
    }
    
    public boolean setMiPersona(Object equipo,Object Persona){
        boolean exito = false;
        for(Equipo actual:this.losEquipos){
            if(equipo==actual){
                if(Persona instanceof Manager){
                    if(actual.getMiManager()==null){
                    Manager aux = (Manager)Persona;
                    actual.setMiManager(new Manager(aux.getCedula(),"" ,"", 0, 0));
                    exito = true;
                    }
                }
                else if(Persona instanceof Tecnico){
                    if(actual.getMiTecnico()==null){
                    Tecnico aux = (Tecnico)Persona;
                    actual.setMiTecnico(new Tecnico(aux.getCedula(), "", "", 0, 0, 0));
                    exito = true;
                    }
                }
                else if(Persona instanceof Jugador){
                    exito = true;
                    
                }
                else if(Persona instanceof Aficionado){
                    exito = true;
                }
            }
        }
        return exito;                   
    }
    
    
}
    
