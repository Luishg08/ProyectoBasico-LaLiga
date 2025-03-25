/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import Clases.Aficionado;
import Clases.Arbitro;
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
public class ModeloArbitro implements Interfaces.CRUD,Interfaces.Persistencia {
    List<Arbitro> losArbitros;

    public ModeloArbitro() {
        this.losArbitros = new LinkedList<>();
        cargar();
    }
    
    @Override
    public boolean Create(Object elObjeto) {
        Arbitro arbitroNuevo = (Arbitro)elObjeto;
        return this.losArbitros.add(arbitroNuevo);
    }

    @Override
    public Object get(String id) {
        Arbitro encontrado = null;
        int i=0;
        while(i<this.losArbitros.size() && encontrado==null){
            if(this.losArbitros.get(i).getCedula().equals(id)){
                encontrado = this.losArbitros.get(i);
            }
            i++;
        }
        return encontrado;
    }

    @Override
    public LinkedList<Object> index() {
        LinkedList<Object> respuesta = new LinkedList<>();
        for(Arbitro arbitroActual:this.losArbitros){
            respuesta.add((Object)arbitroActual);
        }
        return respuesta;
    }

    @Override
    public Object Update(Object elObjeto) {
        Arbitro arbitroNuevo = (Arbitro)elObjeto;
        Arbitro arbitroViejo = (Arbitro)get(arbitroNuevo.getCedula());
        if(arbitroViejo!=null){
            int indiceActual = this.losArbitros.indexOf(arbitroViejo);
            this.losArbitros.set(indiceActual, arbitroNuevo);
        }
        return arbitroViejo;
    }

    @Override
    public boolean Delete(String id) {
        boolean exito = false;
        Arbitro encontrado = (Arbitro)get(id);
        if(encontrado!=null){
            exito = this.losArbitros.remove(encontrado);
        }
        else{
           exito = false;
        }
        return exito;
    }
    
    @Override
    public void guardar() {
        Gson gson = new Gson();
        try (Writer writer = new FileWriter("Arbitros.json")) {
            gson.toJson(this.losArbitros, writer);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    @Override
    public void cargar() {
       Gson gson = new Gson();
        try (Reader reader = new FileReader("Arbitros.json")) {
            Type type = new TypeToken<List<Arbitro>>() {
            }.getType();
            this.losArbitros= gson.fromJson(reader, type);

        } catch (Exception e) {
            System.out.println("Error al cargar");
        }
    }
    public boolean setPartido(String idArbitro, String idPartido){
        boolean exito = false;
        Arbitro arbitroActual = (Arbitro)get(idArbitro);
        if(arbitroActual!=null){
            arbitroActual.setMiPartido(new Partido(idPartido, "", 0, 0));
            exito = true;
            
        }
        return exito;
    }
}
