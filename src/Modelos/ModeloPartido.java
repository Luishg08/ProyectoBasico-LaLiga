/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import Clases.Arbitro;
import Clases.Equipo;
import Clases.Estadio;
import Clases.Jornada;
import Clases.Manager;
import Clases.Partido;
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
public class ModeloPartido implements Interfaces.CRUD, Interfaces.Persistencia{
    List<Partido> losPartidos;
    ModeloEquipo miEquipo;
    public ModeloPartido() {
        this.losPartidos = new LinkedList<>();
        this.miEquipo = new ModeloEquipo();
        cargar();
        this.miEquipo.cargar();
    }

    
    @Override
    public boolean Create(Object elObjeto) {
        Partido nuevo = (Partido)elObjeto;
        return this.losPartidos.add(nuevo);
    }

    @Override
    public Object get(String id) {
        Partido encontrado = null;
        int i=0;
        while(i<this.losPartidos.size() && encontrado==null){
            if(this.losPartidos.get(i).getId().equals(id)){
                encontrado = this.losPartidos.get(i);
            }
            i++;
        }
        return encontrado;
    }

    @Override
    public LinkedList<Object> index() {
        LinkedList<Object> respuesta = new LinkedList<>();
        for(Partido partidoActual:this.losPartidos){
            respuesta.add((Object)partidoActual);
        }
        return respuesta;
    }

    @Override
    public Object Update(Object elObjeto) {
        Partido partidoNuevo = (Partido)elObjeto;
        Partido partidoViejo = (Partido)get(partidoNuevo.getId());
        if(partidoViejo!=null){
            int indiceActual = this.losPartidos.indexOf(partidoViejo);
            this.losPartidos.set(indiceActual, partidoNuevo);
            
        }
        return partidoViejo;
    }

    @Override
    public boolean Delete(String id) {
        boolean exito = false;
        Partido encontrado = (Partido)get(id);
        if(encontrado!=null){
            exito = this.losPartidos.remove(encontrado);
        }
        else{
           exito = false;
        }
        return exito;
    }
    
    public boolean setEquipoLocalYVisitanteYGoles(String idPartido,Equipo local,int golesLocal,Equipo visitante, int golesVisitante){
        boolean exito = false;
        Equipo equipoLocal = (Equipo)miEquipo.get(local.getId());
        Equipo equipoVisitante = (Equipo)miEquipo.get(visitante.getId());
        
        if(equipoLocal !=null && equipoVisitante!=null){
            Partido partidoActual = (Partido)get(idPartido);
            partidoActual.setEquipoVisitante(new Equipo(equipoVisitante.getId(), "", 0, 0, 0, 0, 0, 0, 0));
            partidoActual.setEquipoLocal(new Equipo(equipoLocal.getId(), "", 0, 0, 0, 0, 0, 0, 0));
            partidoActual.setGolesLocal(golesLocal);
            partidoActual.setGolesVisitante(golesVisitante);
            

            exito = true;
        }
        
        return exito;
    }
    
    public boolean setJornada(String idPartido, String idJornada){
        boolean exito = false;
        Partido partidoActual = (Partido)get(idPartido);
        
        if(partidoActual!=null){
            partidoActual.setMiJornada(new Jornada(idJornada, 0, ""));
            exito = true;
        }
                
        return exito;
    }
    
    public boolean setArbitro(String idArbitro, String idPartido){
        boolean exito = false;
        Partido partidoActual = (Partido)get(idPartido);
        
        if(partidoActual!=null){
            partidoActual.setMiArbitro(new Arbitro(idArbitro, "", "", 0, false));
            exito = true;
        }
        return exito;
    }
    
    public boolean setEstadio(String idEstadio,String idPartido){
        boolean exito = false;
        Partido partidoActual = (Partido)get(idPartido);
        if(partidoActual!=null){
            partidoActual.setMiEstadio(new Estadio(idEstadio, "", "", 0));
            exito = true;
        }
        return exito;
    }

    @Override
    public void guardar() {
        Gson gson = new Gson();
        try (Writer writer = new FileWriter("Partidos.json")) {
            gson.toJson(this.losPartidos, writer);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    @Override
    public void cargar() {
       Gson gson = new Gson();
        try (Reader reader = new FileReader("Partidos.json")) {
            Type type = new TypeToken<List<Partido>>() {
            }.getType();
            this.losPartidos= gson.fromJson(reader, type);

        } catch (Exception e) {

        }
    }
    
   
}
