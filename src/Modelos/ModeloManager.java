/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import Clases.Aficionado;
import Clases.Equipo;
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
public class ModeloManager implements Interfaces.CRUD,Interfaces.Persistencia{
    List<Manager> losManagers;
    public ModeloManager() {
        this.losManagers = new LinkedList<>();
        cargar();
    }
    

    @Override
    public boolean Create(Object elObjeto) {
        Manager managerNuevo = (Manager)elObjeto;
        return this.losManagers.add(managerNuevo);
    }

    @Override
    public Object get(String id) {
        Manager encontrado = null;
        int i=0;
        while(i<this.losManagers.size() && encontrado==null){
            if(this.losManagers.get(i).getCedula().equals(id)){
                encontrado = this.losManagers.get(i);
            }
            i++;
        }
        return encontrado;
    }

    @Override
    public LinkedList<Object> index() {
        LinkedList<Object> respuesta = new LinkedList<>();
        for(Manager managerActual:this.losManagers){
            respuesta.add((Object)managerActual);
        }
        return respuesta;
    }

    @Override
    public Object Update(Object elObjeto) {
        Manager managerNuevo = (Manager)elObjeto;
        Manager managerViejo = (Manager)get(managerNuevo.getCedula());
        if(managerViejo!=null){
            int indiceActual = this.losManagers.indexOf(managerViejo);
            this.losManagers.set(indiceActual, managerNuevo);
            
        }
        return managerViejo;
    }

    @Override
    public boolean Delete(String id) {
        boolean exito = false;
        Manager encontrado = (Manager)get(id);
        if(encontrado!=null){
            exito = this.losManagers.remove(encontrado);
        }
        else{
           exito = false;
        }
        return exito;
    }
    @Override
    public void guardar() {
        Gson gson = new Gson();
        try (Writer writer = new FileWriter("Managers.json")) {
            gson.toJson(this.losManagers, writer);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    @Override
    public void cargar() {
       Gson gson = new Gson();
        try (Reader reader = new FileReader("Managers.json")) {
            Type type = new TypeToken<List<Manager>>() {
            }.getType();
            this.losManagers= gson.fromJson(reader, type);

        } catch (Exception e) {

        }
    }
    
    public boolean setEquipo(Object persona,String idEquipo){
        Manager managerActual = (Manager)persona;
        if(managerActual.getMiEquipo()==null){
        managerActual.setMiEquipo(new Equipo(idEquipo, "", 0, 0, 0, 0, 0, 0, 0));
        return true;              
        }
        else{
            return false;
        }
    }
}
