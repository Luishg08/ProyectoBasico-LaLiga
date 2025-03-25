/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import Clases.Jornada;
import Clases.Jugador;
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
public class ModeloJornada implements Interfaces.CRUD,Interfaces.Persistencia{
    List<Jornada> lasJornadas;
    
    public ModeloJornada() {
        this.lasJornadas = new LinkedList<>();
        cargar();
    }
    
    
    
    @Override
    public boolean Create(Object elObjeto) {
        return this.lasJornadas.add((Jornada)elObjeto);
    }

    @Override
    public Object get(String id) {
        Jornada encontrada = null;
        int i=0;
        while(i<this.lasJornadas.size() && encontrada==null){
            if(this.lasJornadas.get(i).getId().equals(id)){
                encontrada = this.lasJornadas.get(i);
            }
            i++;
        }
        return encontrada;
    }

    @Override
    public LinkedList<Object> index() {
        LinkedList<Object> respuesta = new LinkedList<>();
        for(Jornada jornadaActual:this.lasJornadas){
            respuesta.add((Object)jornadaActual);
        }
        return respuesta;
        
    }

    @Override
    public Object Update(Object elObjeto) {
        Jornada jornadaNueva = (Jornada)elObjeto;
        Jornada jornadaVieja = (Jornada)get(jornadaNueva.getId());
        
        if(jornadaVieja!=null){
            int indiceActual = this.lasJornadas.indexOf(jornadaVieja);
            this.lasJornadas.set(indiceActual, jornadaNueva);
        }
        return jornadaVieja;
    }

    @Override
    public boolean Delete(String id) {
        boolean exito = false;
        Jornada encontrada = (Jornada)get(id);
        if(encontrada!=null){
            exito = this.lasJornadas.remove(encontrada);
        }
        else{
           exito = false;
        }
        return exito;
        
    }

@Override
    public void guardar() {
        Gson gson = new Gson();
        try (Writer writer = new FileWriter("Jornadas.json")) {
            gson.toJson(this.lasJornadas, writer);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    @Override
    public void cargar() {
       Gson gson = new Gson();
        try (Reader reader = new FileReader("Jornadas.json")) {
            Type type = new TypeToken<List<Jornada>>() {
            }.getType();
            this.lasJornadas= gson.fromJson(reader, type);

        } catch (Exception e) {
            System.out.println("Error al cargar");
        }
    }
    
    
    
    
}
