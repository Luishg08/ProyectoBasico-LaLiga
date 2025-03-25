/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import Clases.Aficionado;
import Clases.Equipo;
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
public class ModeloTecnico implements Interfaces.CRUD,Interfaces.Persistencia{
    List<Tecnico> losTecnicos;
    public ModeloTecnico() {
        this.losTecnicos = new LinkedList<>();
        cargar();
    }
   

    @Override
    public boolean Create(Object elObjeto) {
        Tecnico tecnicoNuevo = (Tecnico)elObjeto;
        return this.losTecnicos.add(tecnicoNuevo);
    }

    @Override
    public Object get(String id) {
        Tecnico encontrado = null;
        int i=0;
        while(i<this.losTecnicos.size() && encontrado==null){
            if(this.losTecnicos.get(i).getCedula().equals(id)){
                encontrado = this.losTecnicos.get(i);
            }
            i++;
        }
        return encontrado;
    }

    @Override
    public LinkedList<Object> index() {
        LinkedList<Object> respuesta = new LinkedList<>();
        for(Tecnico tecnicoActual:this.losTecnicos){
            respuesta.add((Object)tecnicoActual);
        }
        return respuesta;
    }

    @Override
    public Object Update(Object elObjeto) {
        Tecnico tecnicoNuevo = (Tecnico)elObjeto;
        Tecnico tecnicoViejo = (Tecnico)get(tecnicoNuevo.getCedula());
        
        if(tecnicoViejo!=null){
            int indiceActual = this.losTecnicos.indexOf(tecnicoViejo);
            this.losTecnicos.set(indiceActual, tecnicoNuevo);
        }
        return tecnicoNuevo;
    }

    @Override
    public boolean Delete(String id) {
        boolean exito = false;
        Tecnico encontrado = (Tecnico)get(id);
        if(encontrado!=null){
            exito = this.losTecnicos.remove(encontrado);
        }
        else{
           exito = false;
        }
        return exito;
    }
    @Override
    public void guardar() {
        Gson gson = new Gson();
        try (Writer writer = new FileWriter("Tecnicos.json")) {
            gson.toJson(this.losTecnicos, writer);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    @Override
    public void cargar() {
       Gson gson = new Gson();
        try (Reader reader = new FileReader("Tecnicos.json")) {
            Type type = new TypeToken<List<Tecnico>>() {
            }.getType();
            this.losTecnicos= gson.fromJson(reader, type);

        } catch (Exception e) {

        }
    }
    
    public boolean setEquipo(Object persona,String idEquipo){
        Tecnico tecnicoActual = (Tecnico)persona;
        if(tecnicoActual.getMiEquipo()==null){
        tecnicoActual.setMiEquipo(new Equipo(idEquipo, "", 0, 0, 0, 0, 0, 0, 0));
        return true;              
        }
        else{
            return false;
        }
    }
}
