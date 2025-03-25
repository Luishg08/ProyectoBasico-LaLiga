/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import Clases.Aficionado;
import Clases.Equipo;
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
public class ModeloAficionado implements Interfaces.CRUD, Interfaces.Persistencia{
    List<Aficionado> losAficionados;

    public ModeloAficionado() {
        this.losAficionados = new LinkedList<>();
        cargar();
    }

    @Override
    public boolean Create(Object elObjeto) {
        Aficionado aficionadoNuevo = (Aficionado)elObjeto;
        return this.losAficionados.add(aficionadoNuevo);

    }

    @Override
    public Object get(String id) {
        Aficionado encontrado = null;
        int i=0;
        while(i<this.losAficionados.size() && encontrado==null){
            if(this.losAficionados.get(i).getCedula().equals(id)){
                encontrado = this.losAficionados.get(i);
            }
            i++;
        }
        return encontrado;
    }

    @Override
    public LinkedList<Object> index() {
        LinkedList<Object> respuesta = new LinkedList<>();
        for(Aficionado aficionadoActual:this.losAficionados){
            respuesta.add((Object)aficionadoActual);
        }
        return respuesta;
    }

    @Override
    public Object Update(Object elObjeto) {
        Aficionado aficionadoNuevo = (Aficionado)elObjeto;
        Aficionado aficionadoViejo = (Aficionado)get(aficionadoNuevo.getCedula());
        if(aficionadoViejo != null){
            int indiceActual = this.losAficionados.indexOf(aficionadoViejo);
            this.losAficionados.set(indiceActual, aficionadoNuevo);
        }
        return aficionadoViejo;
        
    }

    @Override
    public boolean Delete(String id) {
        boolean exito = false;
        Aficionado encontrado = (Aficionado)get(id);
        if(encontrado!=null){
            exito = this.losAficionados.remove(encontrado);
        }
        else{
           exito = false;
        }
        return exito;
    }

    @Override
    public void guardar() {
        Gson gson = new Gson();
        try (Writer writer = new FileWriter("Aficionados.json")) {
            gson.toJson(this.losAficionados, writer);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    @Override
    public void cargar() {
       Gson gson = new Gson();
        try (Reader reader = new FileReader("Aficionados.json")) {
            Type type = new TypeToken<List<Aficionado>>() {
            }.getType();
            this.losAficionados= gson.fromJson(reader, type);

        } catch (Exception e) {

        }
    }
    
    public boolean setEquipo(Object persona,String idEquipo){
        Aficionado aficionadoActual = (Aficionado)persona;
        if(aficionadoActual.getMiEquipo()==null){
        aficionadoActual.setMiEquipo(new Equipo(idEquipo, "", 0, 0, 0, 0, 0, 0, 0));
        return true;              
        }
        else{
            return false;
        }
    }
}
