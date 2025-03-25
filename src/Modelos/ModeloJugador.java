/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import Clases.Aficionado;
import Clases.Equipo;
import Clases.Jugador;
import Clases.Manager;
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
public class ModeloJugador implements Interfaces.CRUD,Interfaces.Persistencia {
    List<Jugador> losJugadores;
    public ModeloJugador() {
        this.losJugadores = new LinkedList<>();
        cargar();
    }
    

    @Override
    public boolean Create(Object elObjeto) {
        Jugador jugadorNuevo = (Jugador)elObjeto;
        return this.losJugadores.add(jugadorNuevo);
    }

    @Override
    public Object get(String id) {
        Jugador encontrado = null;
        int i=0;
        while(i<this.losJugadores.size() && encontrado==null){
            if(this.losJugadores.get(i).getCedula().equals(id)){
                encontrado = this.losJugadores.get(i);
            }
            i++;
        }
        return encontrado;
    }

    @Override
    public LinkedList<Object> index() {
        LinkedList<Object> respuesta = new LinkedList<>();
        for(Jugador jugadorActual:this.losJugadores){
            respuesta.add((Object)jugadorActual);
        }
        return respuesta;
    }

    @Override
    public Object Update(Object elObjeto) {
        Jugador jugadorNuevo = (Jugador)elObjeto;
        Jugador jugadorViejo = (Jugador)get(jugadorNuevo.getCedula());
        if(jugadorViejo!=null){
            int indiceActual = this.losJugadores.indexOf(jugadorViejo);
            this.losJugadores.set(indiceActual, jugadorNuevo);
        }
        return jugadorViejo;
    }

    @Override
    public boolean Delete(String id) {
        boolean exito = false;
        Jugador encontrado = (Jugador)get(id);
        if(encontrado!=null){
            exito = this.losJugadores.remove(encontrado);
        }
        else{
           exito = false;
        }
        return exito;
    }
    @Override
    public void guardar() {
        Gson gson = new Gson();
        try (Writer writer = new FileWriter("Jugadores.json")) {
            gson.toJson(this.losJugadores, writer);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    @Override
    public void cargar() {
       Gson gson = new Gson();
        try (Reader reader = new FileReader("Jugadores.json")) {
            Type type = new TypeToken<List<Jugador>>() {
            }.getType();
            this.losJugadores= gson.fromJson(reader, type);

        } catch (Exception e) {
            System.out.println("Error al cargar");
        }
    }
    
    public boolean setEquipo(Object persona,String idEquipo){
        Jugador jugadorActual = (Jugador)persona;
        if(jugadorActual.getMiEquipo()==null){
        jugadorActual.setMiEquipo(new Equipo(idEquipo, "", 0, 0, 0, 0, 0, 0, 0));
        return true;              
        }
        else{
            return false;
        }
    }

    public boolean setManager(Object jugador,String idManager){
        boolean exito = false;
        Jugador encontrado = (Jugador)jugador;
        for(Jugador actual:this.losJugadores){
            if(actual==encontrado){
                if((actual.getMiManager()==null)){
                actual.setMiManager(new Manager(idManager,"", "", 0, 0));
                exito = true;
                }
            }
        }
        return exito;
    }
    
    public boolean setGoles(String idJugador,int goles){
        boolean exito = false;
        Jugador encontrado = (Jugador)get(idJugador);
        if(encontrado !=null){
            encontrado.setGolesMarcados(encontrado.getGolesMarcados()+goles);
            exito = true;
        }
        return exito;
    }
    
}
