package Interfaces;

import java.util.LinkedList;

public interface CRUD {
    public boolean Create(Object elObjeto);
    public Object get(String id);
    public LinkedList<Object> index();
    public Object Update(Object elObjeto);
    public boolean Delete(String id);
}
