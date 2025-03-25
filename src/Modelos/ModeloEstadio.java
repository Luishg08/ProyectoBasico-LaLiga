/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import Clases.Equipo;
import Clases.Estadio;
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
public class ModeloEstadio implements Interfaces.CRUD, Interfaces.Persistencia {
    private List<Estadio> losEstadios;
    
    public ModeloEstadio() {
        this.losEstadios = new LinkedList<>();
        cargar();
    }
    
    
    @Override
    public boolean Create(Object elObjeto) {
        boolean exito = false;
        Estadio nuevo = (Estadio)elObjeto;
        exito = this.getLosEstadios().add(nuevo);
        return exito;
    }

    @Override
    public Object get(String id) {
        Estadio encontrado = null;
        int i=0;
        while(i<this.getLosEstadios().size() && encontrado==null){
            if(this.getLosEstadios().get(i).getId().equals(id)){
                encontrado = this.getLosEstadios().get(i);
            }
            i++;
        }
        return encontrado;
    }

    @Override
    public LinkedList<Object> index() {
        LinkedList<Object> respuesta = new LinkedList<>();
        for(Estadio estadioActual:this.losEstadios){
            respuesta.add((Object)estadioActual);
        }
        return respuesta;
    }

    @Override
    public Object Update(Object elObjeto) {
        Estadio estadioNuevo = (Estadio)elObjeto;
        Estadio estadioViejo = (Estadio)get(estadioNuevo.getId());
        
        if(estadioViejo!=null){
            int indiceActual = this.getLosEstadios().indexOf(estadioViejo);
            this.getLosEstadios().set(indiceActual, estadioNuevo);
        }
        return estadioNuevo;
    }

    @Override
    public boolean Delete(String id) {
        boolean exito = false;
        Estadio encontrado = (Estadio)get(id);
        if(encontrado!=null){
            exito = this.getLosEstadios().remove(encontrado);
        }
        else{
           exito = false;
        }
        return exito;
    }

@Override
    public void guardar() {
        Gson gson = new Gson();
        try (Writer writer = new FileWriter("Estadios.json")) {
            gson.toJson(this.getLosEstadios(), writer);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    @Override
    public void cargar() {
       Gson gson = new Gson();
        try (Reader reader = new FileReader("Estadios.json")) {
            Type type = new TypeToken<List<Estadio>>() {
            }.getType();
            this.setLosEstadios(gson.fromJson(reader, type));

        } catch (Exception e) {

        }
    }

    /**
     * @return the losEstadios
     */
    public List<Estadio> getLosEstadios() {
        return losEstadios;
    }

    /**
     * @param losEstadios the losEstadios to set
     */
    public void setLosEstadios(List<Estadio> losEstadios) {
        this.losEstadios = losEstadios;
    }
    
}
