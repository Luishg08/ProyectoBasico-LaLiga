/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Clases.Aficionado;
import Clases.Arbitro;
import Clases.Equipo;
import Clases.Estadio;
import Clases.Jornada;
import Clases.Jugador;
import Clases.Manager;
import Clases.Partido;
import Clases.Persona;
import Clases.Tecnico;
import Controlador.*;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luish
 */
public class Liga extends javax.swing.JFrame {

    ControladorPersona miControladorPersona;
    ControladorEquipo miControladorEquipo;
    ControladorJornada miControladorJornada;
    ControladorEstadio miControladorEstadio;
    ControladorPartido miControladorPartido;

    /**
     * Creates new form Liga
     */
    public Liga() {
        initComponents();
        this.miControladorPersona = new ControladorPersona();
        this.miControladorEquipo = new ControladorEquipo();
        this.miControladorJornada = new ControladorJornada();
        this.miControladorEstadio = new ControladorEstadio();
        this.miControladorPartido = new ControladorPartido();
        this.comboPersona.setSelectedIndex(0);
        this.txtRespuestaMasJoven.setEditable(false);
        this.txtRespuestaPromedioEdad.setEditable(false);
        this.txtRespuestaPartidosGoleada.setEditable(false);
        this.txtRespuestaJugadorMasGoles.setEditable(false);
        this.txtRespuestaNominaMasAlta.setEditable(false);
        this.txtRespuestaEquipoAficionados.setEditable(false);
        this.txtRespuestaArqueroGoles.setEditable(false);
        this.txtRespuestaEstadioGoles.setEditable(false);
        this.txtRespuestaPartidoGoles.setEditable(false);
        ActualizarTablaAficionados();
        ActualizarTablaArbitros();
        ActualizarTablaJugadores();
        ActualizarTablaManagers();
        ActualizarTablaTecnicos();
        ActualizarTablaEquipos();
        actualizarComboEquipos();
        actualizarComboManagers();
        ActualizarTablaJornadas();
        ActualizarTablaEstadios();
        actualizarComboEquipoLocal();
        actualizarComboEquipoVisitante();
        actualizarComboEstadio();
        actualizarComboArbitros();
        actualizarComboJornadaPartido();
        ActualizarTablaPartidos();
        actualizarComboJugadores();
        actualizarComboEquipoListar();
        actualizarComboEstadiosListar();
        actualizarComboJornadaListar();
        actualizarComboManagersListar();
        actualizarComboEquiposMetodo();
        ActualizarTablaPosicionesLiga();
        
        
        


        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                eventoCierre();
            }
        });
    }
    
   
    public String obtenerIdEstadioSeleccionado() {
    String seleccionado = (String) this.comboEstadioPartido.getSelectedItem();
        String[] partes = seleccionado.split("-");
        String idSeleccionado = partes[0];
        return idSeleccionado; 
        
    }
    public String obtenerIdEstadioListarSeleccionado() {
    String seleccionado = (String) this.comboEstadiosListar.getSelectedItem();
        String[] partes = seleccionado.split("-");
        String idSeleccionado = partes[0];
        return idSeleccionado;    
    }
    public String obtenerIdArbitroSeleccionado() {
    String seleccionado = (String) this.comboÁrbitroPartido.getSelectedItem();
        String[] partes = seleccionado.split("-");
        String idSeleccionado = partes[0];
        return idSeleccionado;    
    }
    public String obtenerIdSeleccionado() {
    String seleccionado = (String) this.comboEquiposPersona.getSelectedItem();
        String[] partes = seleccionado.split("-");
        String idSeleccionado = partes[0];
        return idSeleccionado;    
    }
    public String obtenerIdEquipoListarSeleccionado() {
    String seleccionado = (String) this.comboEquipoListar.getSelectedItem();
        String[] partes = seleccionado.split("-");
        String idSeleccionado = partes[0];
        return idSeleccionado;    
    }
    public String obtenerIdEquipoLocalSeleccionado() {
    String seleccionado = (String) this.comboEquipoLocal.getSelectedItem();
        String[] partes = seleccionado.split("-");
        String idSeleccionado = partes[0];
        return idSeleccionado;    
    }
    public String obtenerIdEquiposMetodo() {
    String seleccionado = (String) this.comboEquiposMetodo.getSelectedItem();
        String[] partes = seleccionado.split("-");
        String idSeleccionado = partes[0];
        return idSeleccionado;    
    }

    public String obtenerIdJugadorSeleccionado() {
    String seleccionado = (String) this.comboJugadorGoles.getSelectedItem();
        String[] partes = seleccionado.split("-");
        String idSeleccionado = partes[0];
        return idSeleccionado;    
    }
    public String obtenerIdEquipoVisitanteSeleccionado() {
    String seleccionado = (String) this.comboEquipoVisitante.getSelectedItem();
        String[] partes = seleccionado.split("-");
        String idSeleccionado = partes[0];
        return idSeleccionado;    
    }
    public String obtenerIdManagerseleccionado() {
    String seleccionado = (String) this.comboManagerJugador.getSelectedItem();
        String[] partes = seleccionado.split("-");
        String idSeleccionado = partes[0];
        return idSeleccionado;    
    }
    public String obtenerIdJornadaSeleccionada() {
    String seleccionado = (String) this.comboJornadaPartido.getSelectedItem();
        String[] partes = seleccionado.split("-");
        String idSeleccionado = partes[0];
        return idSeleccionado;    
    }
    public String obtenerIdJornadaListarSeleccionada() {
    String seleccionado = (String) this.comboJornadaListar.getSelectedItem();
        String[] partes = seleccionado.split("-");
        String idSeleccionado = partes[0];
        return idSeleccionado;    
    }
    public String obtenerIdManagersListarSeleccionado() {
    String seleccionado = (String) this.comboManagersListar.getSelectedItem();
        String[] partes = seleccionado.split("-");
        String idSeleccionado = partes[0];
        return idSeleccionado;    
    }
    public void actualizarComboEquipos(){
        this.comboEquiposPersona.removeAllItems();
        this.comboEquipoListar.removeAllItems();
        this.comboEquipoLocal.removeAllItems();
        this.comboEquipoVisitante.removeAllItems();
        this.comboEquiposMetodo.removeAllItems();
        LinkedList<Object> losEquipos = this.miControladorEquipo.index();
        for(Object actual:losEquipos){           
            this.comboEquiposPersona.addItem(((Equipo)actual).getId()+"-"+((Equipo)actual).getNombre());
            this.comboEquipoListar.addItem(((Equipo)actual).getId()+"-"+((Equipo)actual).getNombre());
            this.comboEquipoLocal.addItem(((Equipo)actual).getId()+"-"+((Equipo)actual).getNombre());
            this.comboEquipoVisitante.addItem(((Equipo)actual).getId()+"-"+((Equipo)actual).getNombre());
            this.comboEquiposMetodo.addItem(((Equipo)actual).getId()+"-"+((Equipo)actual).getNombre());            
            
        }
    }
    public void actualizarComboEquipoListar(){
        this.comboEquipoListar.removeAllItems();
        this.comboEquipoListar.addItem("Seleccione uno");
        LinkedList<Object> losEquipos = this.miControladorEquipo.index();
        for(Object actual:losEquipos){           
            this.comboEquipoListar.addItem(((Equipo)actual).getId()+"-"+((Equipo)actual).getNombre());
        }
    }
    public void actualizarComboEquipoLocal(){
        this.comboEquipoLocal.removeAllItems();
        this.comboEquipoLocal.addItem("Seleccione uno");
        LinkedList<Object> losEquipos = this.miControladorEquipo.index();
        for(Object actual:losEquipos){           
            this.comboEquipoLocal.addItem(((Equipo)actual).getId()+"-"+((Equipo)actual).getNombre());
        }
    }
    public void actualizarComboEstadiosListar(){
        this.comboEstadiosListar.removeAllItems();
        this.comboEstadiosListar.addItem("Seleccione uno");
        LinkedList<Object> losEstadios = this.miControladorEstadio.index();
        for(Object actual:losEstadios){           
            this.comboEstadiosListar.addItem(((Estadio)actual).getId()+"-"+((Estadio)actual).getNombre());
        }
        }
        public void actualizarComboEquipoVisitante(){
        this.comboEquipoVisitante.removeAllItems();
        this.comboEquipoVisitante.addItem("Seleccione uno");
        LinkedList<Object> losEquipos = this.miControladorEquipo.index();
        for(Object actual:losEquipos){           
            this.comboEquipoVisitante.addItem(((Equipo)actual).getId()+"-"+((Equipo)actual).getNombre());
        }
        }
         public void actualizarComboEquiposMetodo(){
        this.comboEquiposMetodo.removeAllItems();
        this.comboEquiposMetodo.addItem("Seleccione uno");
        LinkedList<Object> losEquipos = this.miControladorEquipo.index();
        for(Object actual:losEquipos){           
            this.comboEquiposMetodo.addItem(((Equipo)actual).getId()+"-"+((Equipo)actual).getNombre());
        }
        }
        public void actualizarComboJornadaPartido(){
        this.comboJornadaPartido.removeAllItems();
        this.comboJornadaPartido.addItem("Seleccione uno");
        LinkedList<Object> lasJornadas = this.miControladorJornada.index();
        for(Object actual:lasJornadas){           
            this.comboJornadaPartido.addItem(((Jornada)actual).getId()+"-"+"Jornada Número:"+((Jornada)actual).getNumeroJ());
        }
        }
        public void actualizarComboJornadaListar(){
        this.comboJornadaListar.removeAllItems();
        this.comboJornadaListar.addItem("Seleccione uno");
        LinkedList<Object> lasJornadas = this.miControladorJornada.index();
        for(Object actual:lasJornadas){           
            this.comboJornadaListar.addItem(((Jornada)actual).getId()+"-"+"Jornada Número:"+((Jornada)actual).getNumeroJ());
        }
        }

        
        public void actualizarComboEstadio(){
        this.comboEstadioPartido.removeAllItems();
        this.comboEstadioPartido.addItem("Seleccione uno");
        LinkedList<Object> losEstadios = this.miControladorEstadio.index();
        for(Object actual:losEstadios){           
            this.comboEstadioPartido.addItem(((Estadio)actual).getId()+"-"+((Estadio)actual).getNombre());
        }
        
    }
        public void actualizarComboJugadores(){
        this.comboJugadorGoles.removeAllItems();
        this.comboJugadorGoles.addItem("Seleccione uno");
        LinkedList<Object> losJugadores = this.miControladorPersona.index();
        for(Object actual:losJugadores){
            if(actual instanceof Jugador){
            this.comboJugadorGoles.addItem(((Jugador)actual).getCedula()+"-"+((Jugador)actual).getNombre());
            }
        }
        }
        public void actualizarComboArbitros(){
        this.comboÁrbitroPartido.removeAllItems();
        this.comboÁrbitroPartido.addItem("Seleccione uno");
        LinkedList<Object> losArbitros = this.miControladorPersona.index();
        for(Object actual:losArbitros){
            if(actual instanceof Arbitro){
            this.comboÁrbitroPartido.addItem(((Arbitro)actual).getCedula()+"-"+((Arbitro)actual).getNombre());
            }
        }
        
    }
        public void actualizarComboManagers(){
        this.comboManagerJugador.removeAllItems();
        LinkedList<Object> losManagers = this.miControladorPersona.index();
        for(Object actual:losManagers){
            if(actual instanceof Manager){
            this.comboManagerJugador.addItem(((Manager)actual).getCedula()+"-"+((Manager)actual).getNombre());
            }
        }
    }
    public void actualizarComboManagersListar(){
        this.comboManagersListar.removeAllItems();
        LinkedList<Object> losManagers = this.miControladorPersona.index();
        for(Object actual:losManagers){
            if(actual instanceof Manager){
            this.comboManagersListar.addItem(((Manager)actual).getCedula()+"-"+((Manager)actual).getNombre());
            }
        }
    }
    
    public void eventoCierre() {
        this.miControladorPersona.getMiAficionado().guardar();
        this.miControladorPersona.getMiArbitro().guardar();
        this.miControladorPersona.getMiJugador().guardar();
        this.miControladorPersona.getMiManager().guardar();
        this.miControladorPersona.getMiTecnico().guardar();
        this.miControladorEquipo.getMiModeloEquipo().guardar();
        this.miControladorJornada.getMiJornada().guardar();
        this.miControladorEstadio.getMiEstadio().guardar();
        this.miControladorPartido.getMiPartido().guardar();

        System.out.println("Cerrando");
        System.exit(0);
    }
    public void ActualizarTablaPartidos() {
        String nombreColumnas[] = {"identificador","Fecha","Enfrentamiento","Resultado","Estadio","Arbitro","Jornada"};
        DefaultTableModel miModelo = new DefaultTableModel(null, nombreColumnas);
        this.tablaPartidos.setModel(miModelo);
        LinkedList<Object> losPartidos = this.miControladorPartido.index();

        for (Object partidoActual : losPartidos) {
            if (partidoActual instanceof Partido) {
                String fila[] = new String[nombreColumnas.length];
                Partido aux = (Partido)partidoActual;
                fila[0] = aux.getId();
                fila[1] = aux.getFecha();
                fila[3] = aux.getGolesLocal()+"-"+aux.getGolesVisitante();
                fila[2] = ((Equipo)this.miControladorEquipo.get(aux.getEquipoLocal().getId())).getNombre()+"-"+((Equipo)this.miControladorEquipo.get(aux.getEquipoVisitante().getId())).getNombre();
                fila[4]=  ((Estadio)this.miControladorEstadio.get(aux.getMiEstadio().getId())).getNombre();
                fila[5]= ((Arbitro)this.miControladorPersona.get(aux.getMiArbitro().getCedula())).getNombre();
                fila[6]= ""+((Jornada)this.miControladorJornada.get(aux.getMiJornada().getId())).getNumeroJ();
                
                miModelo.addRow(fila);
            }
        }
    }
    public void ActualizarTablaPosicionesLiga() {
        String nombreColumnas[] = {"identificador","Nombre","Puntos","Goles a Favor","Goles en Contra","Diferencia de Gol"};
        DefaultTableModel miModelo = new DefaultTableModel(null, nombreColumnas);
        this.tablaPosicionesLiga.setModel(miModelo);
        LinkedList<Object> losEquipos = this.miControladorEquipo.index();
        
        List<Equipo> equiposOrdenados = new LinkedList<>();
        for (Object equipoActual : losEquipos) {
        equiposOrdenados.add((Equipo) equipoActual);
        Comparator<Equipo> comparador = Comparator.comparingInt(Equipo::getPuntos).thenComparing(((Equipo equipo) -> equipo.getGolesAFavor() - equipo.getGolesEnContra())).reversed();
        equiposOrdenados.sort(comparador);
        }
        

        for (Object equipoActual : equiposOrdenados) {
            if (equipoActual instanceof Equipo) {
                String fila[] = new String[nombreColumnas.length];
                fila[0] = ((Equipo)equipoActual).getId();
                fila[1] = ((Equipo)equipoActual).getNombre();
                fila[2] = ""+((Equipo)equipoActual).getPuntos();
                fila[3] = ""+((Equipo)equipoActual).getGolesAFavor();
                fila[4] = ""+((Equipo)equipoActual).getGolesEnContra();
                fila[5] = ""+(((Equipo)equipoActual).getGolesAFavor()-((Equipo)equipoActual).getGolesEnContra());
                
                miModelo.addRow(fila);
            }
        }
    }
    public void ActualizarTablaEstadios() {
        String nombreColumnas[] = {"identificador","Nombre","Ciudad","Capacidad"};
        DefaultTableModel miModelo = new DefaultTableModel(null, nombreColumnas);
        this.tablaEstadios.setModel(miModelo);
        LinkedList<Object> losEstadios = this.miControladorEstadio.index();

        for (Object estadioActual : losEstadios) {
            if (estadioActual instanceof Estadio) {
                String fila[] = new String[nombreColumnas.length];
                fila[0] = ((Estadio) estadioActual).getId();
                fila[1] = ((Estadio) estadioActual).getNombre();
                fila[2] = ((Estadio) estadioActual).getCiudad();
                fila[3] = ""+((Estadio)estadioActual).getCapacidad();
                
                miModelo.addRow(fila);
            }
        }
    }
    public void ActualizarTablaJornadas() {
        String nombreColumnas[] = {"identificador","Jornada N°","Eslogan FIFA"};
        DefaultTableModel miModelo = new DefaultTableModel(null, nombreColumnas);
        this.tablaJornadas.setModel(miModelo);
        LinkedList<Object> lasJornadas = this.miControladorJornada.index();

        for (Object jornadaActual : lasJornadas) {
            if (jornadaActual instanceof Jornada) {
                String fila[] = new String[nombreColumnas.length];
                fila[0] = ((Jornada) jornadaActual).getId();
                fila[1] = ""+((Jornada) jornadaActual).getNumeroJ();
                fila[2] = ((Jornada) jornadaActual).getEsloganFIFA();
                
                miModelo.addRow(fila);
            }
        }
    }
     public void ActualizarTablaEquipos() {
        String nombreColumnas[] = {"id", "Nombre", "Año de fundación", "Titulos nacionales", "Titulos internacionales", "puntos","Goles a favor","Goles en contra","Partidos"};
        DefaultTableModel miModelo = new DefaultTableModel(null, nombreColumnas);
        this.tablaEquipos.setModel(miModelo);
        LinkedList<Object> losEquipos = this.miControladorEquipo.index();

        for (Object EquipoActual : losEquipos) {
            if (EquipoActual instanceof Equipo) {
                String fila[] = new String[nombreColumnas.length];
                fila[0] = ((Equipo) EquipoActual).getId();
                fila[1] = ((Equipo) EquipoActual).getNombre();
                fila[2] = ""+((Equipo) EquipoActual).getAñoFundacion();
                fila[3] = ""+((Equipo) EquipoActual).getTitulosNacionales();
                fila[4] = ""+((Equipo) EquipoActual).getTitulosInternacionales();
                fila[5] = ""+((Equipo) EquipoActual).getPuntos();
                fila[6] = ""+((Equipo) EquipoActual).getGolesAFavor();
                fila[7] = ""+((Equipo) EquipoActual).getGolesEnContra();
                fila[8] = ""+((Equipo) EquipoActual).getPartidosJugados();
                
                miModelo.addRow(fila);
            }
        }
    }

    
    public void ActualizarTablaTecnicos(){
        String nombreColumnas[] = {"Cédula", "Nombre", "Apellido", "Edad", "Años de experiencia", "Salario"};
        DefaultTableModel miModelo = new DefaultTableModel(null, nombreColumnas);
        this.tablaTecnicos.setModel(miModelo);
        LinkedList<Object> losTecnicos = this.miControladorPersona.index();

        for (Object tecnicoActual : losTecnicos) {
            if (tecnicoActual instanceof Tecnico) {
                String fila[] = new String[nombreColumnas.length];
                fila[0] = ((Tecnico) tecnicoActual).getCedula();
                fila[1] = ((Tecnico) tecnicoActual).getNombre();
                fila[2] = ((Tecnico) tecnicoActual).getApellido();
                fila[3] = "" + ((Tecnico) tecnicoActual).getEdad();
                fila[4] = "" + ((Tecnico) tecnicoActual).getAñosExperiencia();
                fila[5] = "" + ((Tecnico) tecnicoActual).getSalario();
                miModelo.addRow(fila);
            }
        }
    }

    public void ActualizarTablaManagers() {
        String nombreColumnas[] = {"Cédula", "Nombre", "Apellido", "Edad", "Años de afiliación"};
        DefaultTableModel miModelo = new DefaultTableModel(null, nombreColumnas);
        this.tablaManagers.setModel(miModelo);
        LinkedList<Object> losManagers = this.miControladorPersona.index();

        for (Object managerActual : losManagers) {
            if (managerActual instanceof Manager) {
                String fila[] = new String[nombreColumnas.length];
                fila[0] = ((Manager) managerActual).getCedula();
                fila[1] = ((Manager) managerActual).getNombre();
                fila[2] = ((Manager) managerActual).getApellido();
                fila[3] = "" + ((Manager) managerActual).getEdad();
                fila[4] = "" + ((Manager) managerActual).getAñosAfiliacion();
                miModelo.addRow(fila);
            }
        }
    }

    public void ActualizarTablaJugadores() {
        String nombreColumnas[] = {"Cédula", "Nombre", "Apellido", "Edad", "Nacionalidad", "Posición", "Goles", "Salario"};
        DefaultTableModel miModelo = new DefaultTableModel(null, nombreColumnas);
        this.tablaJugadores.setModel(miModelo);
        LinkedList<Object> losJugadores = this.miControladorPersona.index();

        for (Object jugadorActual : losJugadores) {
            if (jugadorActual instanceof Jugador) {
                String fila[] = new String[nombreColumnas.length];
                fila[0] = ((Jugador) jugadorActual).getCedula();
                fila[1] = ((Jugador) jugadorActual).getNombre();
                fila[2] = ((Jugador) jugadorActual).getApellido();
                fila[3] = "" + ((Jugador) jugadorActual).getEdad();
                fila[4] = ((Jugador) jugadorActual).getNacionalidad();
                fila[5] = ((Jugador) jugadorActual).getPosicion();
                fila[6] = "" + ((Jugador) jugadorActual).getGolesMarcados();
                fila[7] = "" + ((Jugador) jugadorActual).getSalario();
                miModelo.addRow(fila);
            }
        }
    }

    public void ActualizarTablaArbitros() {
        String nombreColumnas[] = {"Cédula", "Nombre", "Apellido", "Edad", "¿FIFA?"};
        DefaultTableModel miModeloArbitros = new DefaultTableModel(null, nombreColumnas);
        this.tablaArbitros.setModel(miModeloArbitros);
        LinkedList<Object> losArbitros = this.miControladorPersona.index();

        for (Object arbitroActual : losArbitros) {
            if (arbitroActual instanceof Arbitro) {
                String fila[] = new String[nombreColumnas.length];
                fila[0] = ((Arbitro) arbitroActual).getCedula();
                fila[1] = ((Arbitro) arbitroActual).getNombre();
                fila[2] = ((Arbitro) arbitroActual).getApellido();
                fila[3] = "" + ((Arbitro) arbitroActual).getEdad();
                String FIFA = "";
                Arbitro actual = (Arbitro) arbitroActual;
                if (actual.isaFIFA() == true) {
                    FIFA = "SÍ";
                } else {
                    FIFA = "NO";
                }
                fila[4] = FIFA;
                miModeloArbitros.addRow(fila);
            }
        }
    }

    public void ActualizarTablaAficionados() {
        String nombreColumnas[] = {"Cédula", "Nombre", "Apellido", "Edad", "Años de fidelidad", "¿Abonado?"};
        DefaultTableModel miModelo = new DefaultTableModel(null, nombreColumnas);
        this.tablaAficionados.setModel(miModelo);
        LinkedList<Object> losAficionados = this.miControladorPersona.index();

        for (Object aficionadoActual : losAficionados) {
            if (aficionadoActual instanceof Aficionado) {
                String fila[] = new String[nombreColumnas.length];
                fila[0] = ((Aficionado) aficionadoActual).getCedula();
                fila[1] = ((Aficionado) aficionadoActual).getNombre();
                fila[2] = ((Aficionado) aficionadoActual).getApellido();
                fila[3] = "" + ((Aficionado) aficionadoActual).getEdad();
                fila[4] = "" + ((Aficionado) aficionadoActual).getAñosFidelidad();
                String abonado = "";
                Aficionado actual = (Aficionado) aficionadoActual;
                if (actual.isAbonado() == true) {
                    abonado = "SÍ";
                } else {
                    abonado = "NO";
                }
                fila[5] = abonado;
                miModelo.addRow(fila);
            }
        }
    }
    
    public void LimpiarCajasPartido(){
        this.txtidPartido.setText("");
        this.txtFechaPartido.setText("");
        this.comboEquipoLocal.setSelectedIndex(0);
        this.comboEquipoVisitante.setSelectedIndex(0);
        this.comboÁrbitroPartido.setSelectedIndex(0);
        this.comboEstadioPartido.setSelectedIndex(0);
        this.comboJornadaPartido.setSelectedIndex(0);
        this.txtGolesEquipoLocal.setText("");
        this.txtGolesEquipoVisitante.setText("");
        
    }
    
    public void LimpiarCajasEstadio(){
        this.txtIdEstadio.setText("");
        this.txtNombreEstadio.setText("");
        this.txtCiudadEstadio.setText("");
        this.txtCapacidadEstadio.setText("");
    }
    
    public void LimpiarCajasJornada(){
        this.txtidJornada.setText("");
        this.txtNumeroJornada.setText("");
        this.txtEsloganFIFAJornada.setText("");        
    }
    
    public void LimpiarCajasPersona() {
        this.txtApellidoPersona.setText("");
        this.txtNombrePersona.setText("");
        this.txtAñosAfiliacionManager.setText("");
        this.txtAñosExpTecnico.setText("");
        this.txtAñosFidelidadAficionado.setText("");
        this.txtCedulaPersona.setText("");
        this.txtEdadPersona.setText("");
        this.txtGolesJugador.setText("");
        this.txtNacionalidadJugador.setText("");
        this.txtPosicionJugador.setText("");
        this.txtSalarioTecnicoyJugador.setText("");
    }

    public void LimpiarCajasEquipos() {
        this.txtIdEquipo.setText("");
        this.txtNombreEquipo.setText("");
        this.txtAñoFundacionEquipo.setText("");
        this.txtTitulosNacionalesEquipo.setText("");
        this.txtTitulosInternacionalesEquipo.setText("");
        this.txtPuntosEquipo.setText("");
        this.txtGolesFavorEquipo.setText("");
        this.txtGolesContraEquipo.setText("");
        this.txtPartidosJugadosEquipo.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel34 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jTabbedPane8 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombrePersona = new javax.swing.JTextField();
        txtApellidoPersona = new javax.swing.JTextField();
        txtCedulaPersona = new javax.swing.JTextField();
        txtEdadPersona = new javax.swing.JTextField();
        comboPersona = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        comboFIFAarbitro = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtAñosExpTecnico = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtSalarioTecnicoyJugador = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtAñosFidelidadAficionado = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        comboAbonadoAficionado = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txtAñosAfiliacionManager = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtNacionalidadJugador = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtPosicionJugador = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtGolesJugador = new javax.swing.JTextField();
        btnCrearPersona = new javax.swing.JButton();
        btnBuscarPersona = new javax.swing.JButton();
        btnActualizarPersona = new javax.swing.JButton();
        btnEliminarPersona = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAficionados = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaArbitros = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaJugadores = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaManagers = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaTecnicos = new javax.swing.JTable();
        jLabel27 = new javax.swing.JLabel();
        comboEquiposPersona = new javax.swing.JComboBox<>();
        btnAgregarEquipoPersona = new javax.swing.JButton();
        eliminarEquipoPersona = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        comboManagerJugador = new javax.swing.JComboBox<>();
        btnAgregarManagerJugador = new javax.swing.JButton();
        btnEliminarManagerJugador = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtIdEquipo = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtNombreEquipo = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtAñoFundacionEquipo = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtTitulosNacionalesEquipo = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtTitulosInternacionalesEquipo = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtPuntosEquipo = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtGolesFavorEquipo = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtGolesContraEquipo = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtPartidosJugadosEquipo = new javax.swing.JTextField();
        btnCrearEquipo = new javax.swing.JButton();
        btnBuscarEquipo = new javax.swing.JButton();
        btnEliminarEquipo = new javax.swing.JButton();
        btnActualizarEquipo = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablaEquipos = new javax.swing.JTable();
        jLabel35 = new javax.swing.JLabel();
        labelJugadoresEquipo = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        comboEquipoListar = new javax.swing.JComboBox<>();
        btnListarRelacionesEquipo = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        tablaJugadoresEquipo = new javax.swing.JTable();
        jScrollPane11 = new javax.swing.JScrollPane();
        tablaAficionadosEquipo = new javax.swing.JTable();
        jScrollPane12 = new javax.swing.JScrollPane();
        tablaPartidosEquipo = new javax.swing.JTable();
        labelListarEquipo = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        txtIdEstadio = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtNombreEstadio = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        txtCiudadEstadio = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        txtCapacidadEstadio = new javax.swing.JTextField();
        btnCrearEstadio = new javax.swing.JButton();
        btnBuscarEstadio = new javax.swing.JButton();
        btnActualizarEstadio = new javax.swing.JButton();
        btnEliminarEstadio = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        tablaEstadios = new javax.swing.JTable();
        jLabel53 = new javax.swing.JLabel();
        comboEstadiosListar = new javax.swing.JComboBox<>();
        btnListarPartidosEstadio = new javax.swing.JButton();
        jScrollPane13 = new javax.swing.JScrollPane();
        tablaPartidosEstadio = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        txtidJornada = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtNumeroJornada = new javax.swing.JTextField();
        txtEsloganFIFAJornada = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        btnCrearJornada = new javax.swing.JButton();
        btnBuscarJornada = new javax.swing.JButton();
        btnActualizarJornada = new javax.swing.JButton();
        btnEliminarJornada = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tablaJornadas = new javax.swing.JTable();
        jLabel54 = new javax.swing.JLabel();
        comboJornadaListar = new javax.swing.JComboBox<>();
        btnListarRelacionesJornada = new javax.swing.JButton();
        jScrollPane14 = new javax.swing.JScrollPane();
        tablaPartidosJornada = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txtidPartido = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        txtFechaPartido = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        comboEquipoLocal = new javax.swing.JComboBox<>();
        jLabel39 = new javax.swing.JLabel();
        txtGolesEquipoLocal = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        comboEquipoVisitante = new javax.swing.JComboBox<>();
        jLabel41 = new javax.swing.JLabel();
        txtGolesEquipoVisitante = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        comboEstadioPartido = new javax.swing.JComboBox<>();
        jLabel43 = new javax.swing.JLabel();
        comboÁrbitroPartido = new javax.swing.JComboBox<>();
        jScrollPane8 = new javax.swing.JScrollPane();
        tablaPartidos = new javax.swing.JTable();
        btnCrearPartido = new javax.swing.JButton();
        btnBuscarPartido = new javax.swing.JButton();
        btnActualizarPartido = new javax.swing.JButton();
        btnEliminarPartido = new javax.swing.JButton();
        jLabel49 = new javax.swing.JLabel();
        comboJornadaPartido = new javax.swing.JComboBox<>();
        jLabel51 = new javax.swing.JLabel();
        comboJugadorGoles = new javax.swing.JComboBox<>();
        jLabel52 = new javax.swing.JLabel();
        spinGolesJugador = new javax.swing.JSpinner();
        btnAsignarGolesJugador = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        comboManagersListar = new javax.swing.JComboBox<>();
        btnListarRelacionesManager = new javax.swing.JButton();
        jScrollPane15 = new javax.swing.JScrollPane();
        tablaJugadoresManager = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        tablaPosicionesLiga = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        btnJugadorMasJoven = new javax.swing.JButton();
        txtRespuestaMasJoven = new javax.swing.JTextField();
        btnPromedioEdadEquipo = new javax.swing.JButton();
        jLabel56 = new javax.swing.JLabel();
        comboEquiposMetodo = new javax.swing.JComboBox<>();
        txtRespuestaPromedioEdad = new javax.swing.JTextField();
        btnCantidadPartidosGoleada = new javax.swing.JButton();
        txtRespuestaPartidosGoleada = new javax.swing.JTextField();
        btnObtenerJugadorMasGoles = new javax.swing.JButton();
        txtRespuestaJugadorMasGoles = new javax.swing.JTextField();
        btnObtenerEquipoNomina = new javax.swing.JButton();
        txtRespuestaNominaMasAlta = new javax.swing.JTextField();
        btnObtenerEquipoAficionados = new javax.swing.JButton();
        txtRespuestaEquipoAficionados = new javax.swing.JTextField();
        btnObtenerPartidoGoles = new javax.swing.JButton();
        txtRespuestaPartidoGoles = new javax.swing.JTextField();
        btnArqueroGoles = new javax.swing.JButton();
        txtRespuestaArqueroGoles = new javax.swing.JTextField();
        btnObtenerEstadioGoles = new javax.swing.JButton();
        txtRespuestaEstadioGoles = new javax.swing.JTextField();
        btnObtenerGolesEquipoMasPuntos = new javax.swing.JButton();
        txtRespuestaGolesEquipoMasPuntos = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();

        jLabel34.setFont(new java.awt.Font("Segoe UI Semibold", 3, 24)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(51, 51, 51));
        jLabel34.setText("Crear Jornada");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Nombre");

        jLabel3.setText("Apellido");

        jLabel4.setText("Cédula");

        jLabel5.setText("Edad");

        txtNombrePersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombrePersonaActionPerformed(evt);
            }
        });

        txtCedulaPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaPersonaActionPerformed(evt);
            }
        });

        comboPersona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione uno", "Aficionado", "Árbitro", "Jugador", "Manager", "Técnico" }));
        comboPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPersonaActionPerformed(evt);
            }
        });

        jLabel1.setText("Seleccione el tipo de persona");

        jLabel6.setText("FIFA");

        comboFIFAarbitro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SÍ", "NO" }));

        jLabel7.setText("Años de experiencia");

        jLabel8.setText("Salario");

        jLabel9.setText("Años de Fidelidad");

        jLabel10.setText("Abonado");

        comboAbonadoAficionado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SÍ", "NO" }));

        jLabel11.setText("Años de Afiliación");

        jLabel12.setText("Nacionalidad");

        jLabel13.setText("Posicion");

        jLabel14.setText("Goles Marcados");

        btnCrearPersona.setText("Crear");
        btnCrearPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearPersonaActionPerformed(evt);
            }
        });

        btnBuscarPersona.setText("Buscar");
        btnBuscarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPersonaActionPerformed(evt);
            }
        });

        btnActualizarPersona.setText("Actualizar");
        btnActualizarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarPersonaActionPerformed(evt);
            }
        });

        btnEliminarPersona.setText("Eliminar");
        btnEliminarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPersonaActionPerformed(evt);
            }
        });

        tablaAficionados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaAficionados);

        jTabbedPane2.addTab("Aficionados", jScrollPane1);

        tablaArbitros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tablaArbitros);

        jTabbedPane2.addTab("Arbitros", jScrollPane2);

        tablaJugadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tablaJugadores);

        jTabbedPane2.addTab("Jugadores", jScrollPane3);

        tablaManagers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tablaManagers);

        jTabbedPane2.addTab("Managers", jScrollPane4);

        tablaTecnicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(tablaTecnicos);

        jTabbedPane2.addTab("Tecnicos", jScrollPane5);

        jLabel27.setText("Equipo al que pertenece");

        comboEquiposPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboEquiposPersonaActionPerformed(evt);
            }
        });

        btnAgregarEquipoPersona.setText("Agregar");
        btnAgregarEquipoPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEquipoPersonaActionPerformed(evt);
            }
        });

        eliminarEquipoPersona.setText("Eliminar");
        eliminarEquipoPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarEquipoPersonaActionPerformed(evt);
            }
        });

        jLabel28.setText("Manager que lo gestiona");

        btnAgregarManagerJugador.setText("Agregar");
        btnAgregarManagerJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarManagerJugadorActionPerformed(evt);
            }
        });

        btnEliminarManagerJugador.setText("Eliminar");
        btnEliminarManagerJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarManagerJugadorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtPosicionJugador))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNacionalidadJugador))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtAñosAfiliacionManager))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel14)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtGolesJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel27)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(comboEquiposPersona, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel28)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(comboManagerJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtAñosFidelidadAficionado, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtCedulaPersona, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                                            .addComponent(txtApellidoPersona, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addComponent(txtEdadPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(comboPersona, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(comboAbonadoAficionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtNombrePersona, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(comboFIFAarbitro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtSalarioTecnicoyJugador))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtAñosExpTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAgregarEquipoPersona, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAgregarManagerJugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEliminarManagerJugador)
                            .addComponent(eliminarEquipoPersona))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btnCrearPersona)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarPersona)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActualizarPersona)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarPersona))
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(618, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCrearPersona)
                            .addComponent(btnBuscarPersona)
                            .addComponent(btnActualizarPersona)
                            .addComponent(btnEliminarPersona)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtNombrePersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtApellidoPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtCedulaPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtEdadPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboFIFAarbitro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAñosExpTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(txtSalarioTecnicoyJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtAñosFidelidadAficionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(comboAbonadoAficionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(comboManagerJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregarManagerJugador)
                            .addComponent(btnEliminarManagerJugador))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(comboEquiposPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregarEquipoPersona)
                            .addComponent(eliminarEquipoPersona))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtAñosAfiliacionManager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNacionalidadJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtPosicionJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtGolesJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(150, Short.MAX_VALUE))
        );

        jTabbedPane8.addTab("Personas", jPanel1);

        jLabel16.setText("Identificador:");

        txtIdEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdEquipoActionPerformed(evt);
            }
        });

        jLabel17.setText("Nombre:");

        jLabel18.setText("Año de fundación:");

        jLabel20.setText("Titulos nacionales (número):");

        jLabel21.setText("Titulos internacionales (número):");

        jLabel22.setText("Número de puntos");

        jLabel23.setText("Goles a favor:");

        jLabel24.setText("Goles en contra:");

        jLabel26.setText("Partidos jugados:");

        btnCrearEquipo.setText("Crear");
        btnCrearEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearEquipoActionPerformed(evt);
            }
        });

        btnBuscarEquipo.setText("Buscar");
        btnBuscarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEquipoActionPerformed(evt);
            }
        });

        btnEliminarEquipo.setText("Eliminar");
        btnEliminarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEquipoActionPerformed(evt);
            }
        });

        btnActualizarEquipo.setText("Actualizar");
        btnActualizarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarEquipoActionPerformed(evt);
            }
        });

        tablaEquipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(tablaEquipos);

        jLabel35.setFont(new java.awt.Font("Segoe UI Semibold", 3, 24)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(51, 51, 51));
        jLabel35.setText("Crear Equipo");

        labelJugadoresEquipo.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N

        jLabel50.setText("Seleccione un equipo");

        btnListarRelacionesEquipo.setText("Listar Relaciones");
        btnListarRelacionesEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarRelacionesEquipoActionPerformed(evt);
            }
        });

        tablaJugadoresEquipo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane10.setViewportView(tablaJugadoresEquipo);

        tablaAficionadosEquipo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane11.setViewportView(tablaAficionadosEquipo);

        tablaPartidosEquipo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane12.setViewportView(tablaPartidosEquipo);

        labelListarEquipo.setFont(new java.awt.Font("Tw Cen MT", 3, 36)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(labelJugadoresEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboEquipoListar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnListarRelacionesEquipo)))
                .addGap(0, 745, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelListarEquipo)
                .addContainerGap(905, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(151, 151, 151)
                                .addComponent(jLabel25))
                            .addComponent(jLabel19)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel16)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtIdEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel17)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtNombreEquipo))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel18)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtAñoFundacionEquipo))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel26)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtPartidosJugadosEquipo))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel20)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtTitulosNacionalesEquipo))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel21)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtTitulosInternacionalesEquipo))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel22)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtPuntosEquipo))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel23)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtGolesFavorEquipo))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel24)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtGolesContraEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnCrearEquipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarEquipo)
                        .addGap(12, 12, 12)
                        .addComponent(btnActualizarEquipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarEquipo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
                .addGap(829, 829, 829))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtIdEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txtNombreEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txtAñoFundacionEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(txtTitulosNacionalesEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(txtTitulosInternacionalesEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(txtPuntosEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(txtGolesFavorEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(txtGolesContraEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(txtPartidosJugadosEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCrearEquipo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnBuscarEquipo)
                                .addComponent(btnEliminarEquipo)
                                .addComponent(btnActualizarEquipo))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25)
                .addGap(18, 18, 18)
                .addComponent(labelJugadoresEquipo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(comboEquipoListar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnListarRelacionesEquipo))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(96, 96, 96)
                        .addComponent(jLabel19))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(labelListarEquipo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane8.addTab("Equipos", jPanel2);

        jLabel45.setFont(new java.awt.Font("Segoe UI Semibold", 3, 24)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(51, 51, 51));
        jLabel45.setText("Crear Estadio");

        jLabel46.setText("Identificador");

        txtIdEstadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdEstadioActionPerformed(evt);
            }
        });

        jLabel15.setText("Nombre");

        jLabel47.setText("Ciudad");

        jLabel48.setText("Capacidad");

        btnCrearEstadio.setText("Crear");
        btnCrearEstadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearEstadioActionPerformed(evt);
            }
        });

        btnBuscarEstadio.setText("Buscar");
        btnBuscarEstadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEstadioActionPerformed(evt);
            }
        });

        btnActualizarEstadio.setText("Actualizar");
        btnActualizarEstadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarEstadioActionPerformed(evt);
            }
        });

        btnEliminarEstadio.setText("Eliminar");
        btnEliminarEstadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEstadioActionPerformed(evt);
            }
        });

        tablaEstadios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane9.setViewportView(tablaEstadios);

        jLabel53.setText("Seleccione un estadio");

        btnListarPartidosEstadio.setText("Listar Relaciones");
        btnListarPartidosEstadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarPartidosEstadioActionPerformed(evt);
            }
        });

        tablaPartidosEstadio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane13.setViewportView(tablaPartidosEstadio);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(77, 77, 77)
                            .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel46)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtIdEstadio, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel15)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNombreEstadio))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel47)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtCiudadEstadio))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel48)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtCapacidadEstadio)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel53)
                                .addGap(10, 10, 10)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnListarPartidosEstadio)
                                    .addComponent(comboEstadiosListar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnCrearEstadio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarEstadio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnActualizarEstadio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminarEstadio))
                            .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 895, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(580, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel46)
                            .addComponent(txtIdEstadio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtNombreEstadio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel47)
                            .addComponent(txtCiudadEstadio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel48)
                            .addComponent(txtCapacidadEstadio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCrearEstadio)
                            .addComponent(btnBuscarEstadio)
                            .addComponent(btnActualizarEstadio)
                            .addComponent(btnEliminarEstadio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel53)
                            .addComponent(comboEstadiosListar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnListarPartidosEstadio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        jTabbedPane8.addTab("Estadios", jPanel4);

        jLabel29.setText("Identificador");

        jLabel33.setFont(new java.awt.Font("Segoe UI Semibold", 3, 24)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(51, 51, 51));
        jLabel33.setText("Crear Jornada");

        jLabel30.setText("Número de la jornada");

        txtNumeroJornada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroJornadaActionPerformed(evt);
            }
        });

        jLabel31.setText("Eslogan FIFA");

        btnCrearJornada.setText("Crear");
        btnCrearJornada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearJornadaActionPerformed(evt);
            }
        });

        btnBuscarJornada.setText("Buscar");
        btnBuscarJornada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarJornadaActionPerformed(evt);
            }
        });

        btnActualizarJornada.setText("Actualizar");
        btnActualizarJornada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarJornadaActionPerformed(evt);
            }
        });

        btnEliminarJornada.setText("Eliminar");
        btnEliminarJornada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarJornadaActionPerformed(evt);
            }
        });

        tablaJornadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane7.setViewportView(tablaJornadas);

        jLabel54.setText("Seleccione una jornada");

        btnListarRelacionesJornada.setText("Listar Relaciones");
        btnListarRelacionesJornada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarRelacionesJornadaActionPerformed(evt);
            }
        });

        tablaPartidosJornada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane14.setViewportView(tablaPartidosJornada);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnCrearJornada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarJornada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActualizarJornada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarJornada))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEsloganFIFAJornada, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumeroJornada, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtidJornada, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel54)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnListarRelacionesJornada)
                            .addComponent(comboJornadaListar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 1136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(342, 342, 342))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(txtidJornada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(txtNumeroJornada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(txtEsloganFIFAJornada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCrearJornada)
                            .addComponent(btnBuscarJornada)
                            .addComponent(btnActualizarJornada)
                            .addComponent(btnEliminarJornada))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel54)
                            .addComponent(comboJornadaListar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnListarRelacionesJornada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        jTabbedPane8.addTab("Jornadas", jPanel5);

        jLabel32.setFont(new java.awt.Font("Segoe UI Semibold", 3, 24)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(51, 51, 51));
        jLabel32.setText("Crear Partido");

        jLabel36.setText("identificador");

        jLabel37.setText("Fecha");

        jLabel38.setText("Equipo Local");

        comboEquipoLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboEquipoLocalActionPerformed(evt);
            }
        });

        jLabel39.setText("Goles");

        jLabel40.setText("Equipo Visitante");

        jLabel41.setText("Goles");

        txtGolesEquipoVisitante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGolesEquipoVisitanteActionPerformed(evt);
            }
        });

        jLabel42.setText("Estadio");

        jLabel43.setText("Árbitro");

        tablaPartidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaPartidos.setMaximumSize(new java.awt.Dimension(2147483647, 800));
        jScrollPane8.setViewportView(tablaPartidos);

        btnCrearPartido.setText("Crear");
        btnCrearPartido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearPartidoActionPerformed(evt);
            }
        });

        btnBuscarPartido.setText("Buscar");
        btnBuscarPartido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPartidoActionPerformed(evt);
            }
        });

        btnActualizarPartido.setText("Actualizar");
        btnActualizarPartido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarPartidoActionPerformed(evt);
            }
        });

        btnEliminarPartido.setText("Eliminar");
        btnEliminarPartido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPartidoActionPerformed(evt);
            }
        });

        jLabel49.setText("Jornada");

        jLabel51.setText("¿Quién metió gol?");

        jLabel52.setText("¿Cuántos?");

        btnAsignarGolesJugador.setText("Sumar-Restar");
        btnAsignarGolesJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarGolesJugadorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(78, 78, 78)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtidPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jLabel36)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel37)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtFechaPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel38)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(comboEquipoLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel39))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                                    .addComponent(jLabel43)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(comboÁrbitroPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                                    .addComponent(jLabel42)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(comboEstadioPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                    .addComponent(jLabel40)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(comboEquipoVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGap(12, 12, 12)
                                            .addComponent(jLabel41)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtGolesEquipoVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtGolesEquipoLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel49)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboJornadaPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(btnCrearPartido)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnBuscarPartido)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnActualizarPartido)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnEliminarPartido))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel51)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(comboJugadorGoles, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel52)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(spinGolesJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnAsignarGolesJugador))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 1015, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(466, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtidPartido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(txtFechaPartido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(comboEquipoLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39)
                    .addComponent(txtGolesEquipoLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(comboEquipoVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41)
                    .addComponent(txtGolesEquipoVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(comboEstadioPartido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(comboÁrbitroPartido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(comboJornadaPartido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrearPartido)
                    .addComponent(btnBuscarPartido)
                    .addComponent(btnActualizarPartido)
                    .addComponent(btnEliminarPartido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboJugadorGoles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel52)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(spinGolesJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAsignarGolesJugador)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(111, Short.MAX_VALUE))
        );

        jTabbedPane8.addTab("Partidos", jPanel3);

        jLabel55.setText("Seleccione un manager");

        btnListarRelacionesManager.setText("Listar Relaciones");
        btnListarRelacionesManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarRelacionesManagerActionPerformed(evt);
            }
        });

        tablaJugadoresManager.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane15.setViewportView(tablaJugadoresManager);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel55)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnListarRelacionesManager)
                            .addComponent(comboManagersListar, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(1307, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(comboManagersListar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnListarRelacionesManager)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(134, Short.MAX_VALUE))
        );

        jTabbedPane8.addTab("Listar Jugadores del Manager", jPanel6);

        jLabel57.setFont(new java.awt.Font("Segoe UI Semibold", 0, 36)); // NOI18N
        jLabel57.setText("POSICIONES LIGA");

        tablaPosicionesLiga.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane16.setViewportView(tablaPosicionesLiga);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(615, 615, 615)
                .addComponent(jLabel57)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 1402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 414, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel57)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(166, Short.MAX_VALUE))
        );

        jTabbedPane8.addTab("Posiciones Liga", jPanel8);

        btnJugadorMasJoven.setText("Obtener Jugador Más Joven De La Liga");
        btnJugadorMasJoven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugadorMasJovenActionPerformed(evt);
            }
        });

        btnPromedioEdadEquipo.setText("Obtener Promedio de Edad (Total) De Un Equipo");
        btnPromedioEdadEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromedioEdadEquipoActionPerformed(evt);
            }
        });

        jLabel56.setText("Seleccione un Equipo");

        btnCantidadPartidosGoleada.setText("Obtener Cantidad De Partidos En Los Que Un Equipo Ganó Por 4 O Más Goles De Diferencia");
        btnCantidadPartidosGoleada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCantidadPartidosGoleadaActionPerformed(evt);
            }
        });

        btnObtenerJugadorMasGoles.setText("Obtener Jugador Con Más Goles De La Liga");
        btnObtenerJugadorMasGoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObtenerJugadorMasGolesActionPerformed(evt);
            }
        });

        btnObtenerEquipoNomina.setText("Obtener Equipo Con Mayor Nómina");
        btnObtenerEquipoNomina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObtenerEquipoNominaActionPerformed(evt);
            }
        });

        btnObtenerEquipoAficionados.setText("Obtener Equipo Con Más Aficionados");
        btnObtenerEquipoAficionados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObtenerEquipoAficionadosActionPerformed(evt);
            }
        });

        btnObtenerPartidoGoles.setText("Obtener Partido Con Más Goles");
        btnObtenerPartidoGoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObtenerPartidoGolesActionPerformed(evt);
            }
        });

        btnArqueroGoles.setText("Obtener Arquero Con Menos Goles");
        btnArqueroGoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArqueroGolesActionPerformed(evt);
            }
        });

        btnObtenerEstadioGoles.setText("Obtener Estadio Con Más Goles");
        btnObtenerEstadioGoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObtenerEstadioGolesActionPerformed(evt);
            }
        });

        btnObtenerGolesEquipoMasPuntos.setText("Obtener Goles Equipo Con Más Puntos");
        btnObtenerGolesEquipoMasPuntos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObtenerGolesEquipoMasPuntosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(btnJugadorMasJoven)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRespuestaMasJoven, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnObtenerPartidoGoles, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnObtenerEquipoAficionados, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtRespuestaEquipoAficionados, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                                    .addComponent(txtRespuestaPartidoGoles))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(btnPromedioEdadEquipo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRespuestaPromedioEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel56)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboEquiposMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                    .addComponent(btnObtenerEquipoNomina, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtRespuestaNominaMasAlta))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(btnCantidadPartidosGoleada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnObtenerJugadorMasGoles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtRespuestaJugadorMasGoles, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtRespuestaPartidosGoleada, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnObtenerEstadioGoles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnArqueroGoles, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))
                            .addComponent(btnObtenerGolesEquipoMasPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtRespuestaArqueroGoles, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                            .addComponent(txtRespuestaEstadioGoles)
                            .addComponent(txtRespuestaGolesEquipoMasPuntos))
                        .addGap(556, 556, 556))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnJugadorMasJoven, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtRespuestaMasJoven, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel56)
                                    .addComponent(comboEquiposMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnPromedioEdadEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtRespuestaPromedioEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtRespuestaArqueroGoles)
                                    .addComponent(btnArqueroGoles, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnObtenerEstadioGoles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtRespuestaEstadioGoles, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnObtenerGolesEquipoMasPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnCantidadPartidosGoleada, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtRespuestaPartidosGoleada, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(txtRespuestaGolesEquipoMasPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtRespuestaJugadorMasGoles, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnObtenerJugadorMasGoles, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnObtenerEquipoNomina, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(txtRespuestaNominaMasAlta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnObtenerEquipoAficionados, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(txtRespuestaEquipoAficionados))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnObtenerPartidoGoles, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(txtRespuestaPartidoGoles))
                .addGap(214, 214, 214))
        );

        jTabbedPane8.addTab("Métodos", jPanel7);

        jLabel44.setFont(new java.awt.Font("Segoe UI Semibold", 3, 48)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(56, 0, 93));
        jLabel44.setText("LaLiga");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 1816, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(458, 458, 458)
                        .addComponent(jLabel44)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel44)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTabbedPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearPersonaActionPerformed
        int personaSeleccionada = this.comboPersona.getSelectedIndex();
        if (personaSeleccionada == 1) {
            String cedula = this.txtCedulaPersona.getText();
            String nombre = this.txtNombrePersona.getText();
            String apellido = this.txtApellidoPersona.getText();
            int edad = Integer.parseInt(this.txtEdadPersona.getText());
            int añosAficionado = Integer.parseInt(this.txtAñosFidelidadAficionado.getText());
            boolean abonado = false;
            if (this.comboAbonadoAficionado.getSelectedIndex() == 0) {
                abonado = true;
            }
            Aficionado aficionadoNuevo = new Aficionado(cedula, nombre, apellido, edad, añosAficionado, abonado);
            boolean exito = this.miControladorPersona.Create(aficionadoNuevo);
            if (exito) {
                JOptionPane.showMessageDialog(this, "Aficionado creado correctamente");
            } else {
                JOptionPane.showMessageDialog(this, "Aficionado no creado");
            }
            LimpiarCajasPersona();
        } else if (personaSeleccionada == 2) {
            String cedula = this.txtCedulaPersona.getText();
            String nombre = this.txtNombrePersona.getText();
            String apellido = this.txtApellidoPersona.getText();
            int edad = Integer.parseInt(this.txtEdadPersona.getText());
            boolean aFIFA = false;
            if (this.comboFIFAarbitro.getSelectedIndex() == 0) {
                aFIFA = true;
            }

            Arbitro arbitroNuevo = new Arbitro(cedula, nombre, apellido, edad, aFIFA);
            boolean exito = this.miControladorPersona.Create(arbitroNuevo);
            if (exito) {
                JOptionPane.showMessageDialog(this, "Arbitro creado exitosamente");
            } else {
                JOptionPane.showMessageDialog(this, "Arbitro no creado");
            }
            LimpiarCajasPersona();
        } else if (personaSeleccionada == 3) {
            String cedula = this.txtCedulaPersona.getText();
            String nombre = this.txtNombrePersona.getText();
            String apellido = this.txtApellidoPersona.getText();
            int edad = Integer.parseInt(this.txtEdadPersona.getText());
            String nacionalidad = this.txtNacionalidadJugador.getText();
            String posicion = this.txtPosicionJugador.getText();
            int golesMarcados = Integer.parseInt(this.txtGolesJugador.getText());
            double salario = Double.parseDouble(this.txtSalarioTecnicoyJugador.getText());
            Jugador jugadorNuevo = new Jugador(cedula, nombre, apellido, edad, nacionalidad, posicion, golesMarcados, salario);            
            boolean exito = this.miControladorPersona.Create(jugadorNuevo);
            if (exito) {
                JOptionPane.showMessageDialog(this, "Jugador creado exitosamente");
            } else {
                JOptionPane.showMessageDialog(this, "Jugador no creado");
            }
            LimpiarCajasPersona();
        } else if (personaSeleccionada == 4) {
            String cedula = this.txtCedulaPersona.getText();
            String nombre = this.txtNombrePersona.getText();
            String apellido = this.txtApellidoPersona.getText();
            int edad = Integer.parseInt(this.txtEdadPersona.getText());
            int añosAfiliacion = Integer.parseInt(this.txtAñosAfiliacionManager.getText());

            Manager managerNuevo = new Manager(cedula, nombre, apellido, edad, añosAfiliacion);
            boolean exito = this.miControladorPersona.Create(managerNuevo);
            if (exito) {
                JOptionPane.showMessageDialog(this, "Manager creado exitosamente");
            } else {
                JOptionPane.showMessageDialog(this, "Manager no creado");
            }
            LimpiarCajasPersona();
        } else if (personaSeleccionada == 5) {
            String cedula = this.txtCedulaPersona.getText();
            String nombre = this.txtNombrePersona.getText();
            String apellido = this.txtApellidoPersona.getText();
            int edad = Integer.parseInt(this.txtEdadPersona.getText());
            int añosExperiencia = Integer.parseInt(this.txtAñosExpTecnico.getText());
            double salario = Double.parseDouble(this.txtSalarioTecnicoyJugador.getText());
            Tecnico tecnicoNuevo = new Tecnico(cedula, nombre, apellido, edad, añosExperiencia, salario);
            boolean exito = this.miControladorPersona.Create(tecnicoNuevo);
            if (exito) {
                JOptionPane.showMessageDialog(this, "Tecnico creado exitosamente");
            } else {
                JOptionPane.showMessageDialog(this, "Tecnico no creado");
            }
            LimpiarCajasPersona();

        }
        ActualizarTablaAficionados();
        ActualizarTablaArbitros();
        ActualizarTablaJugadores();
        ActualizarTablaManagers();
        ActualizarTablaTecnicos();
        actualizarComboManagers();
        actualizarComboArbitros();
        actualizarComboJugadores();
        actualizarComboManagersListar();
    }//GEN-LAST:event_btnCrearPersonaActionPerformed

    private void comboPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPersonaActionPerformed
        int opcionSeleccionada = 0;
        opcionSeleccionada = this.comboPersona.getSelectedIndex();

        if (opcionSeleccionada == 0) {
            this.txtSalarioTecnicoyJugador.setEnabled(false);
            this.comboFIFAarbitro.setEnabled(false);
            this.txtAñosExpTecnico.setEnabled(false);
            this.txtAñosAfiliacionManager.setEnabled(false);
            this.txtNacionalidadJugador.setEnabled(false);
            this.txtPosicionJugador.setEnabled(false);
            this.txtGolesJugador.setEnabled(false);
            this.txtAñosFidelidadAficionado.setEnabled(false);
            this.comboAbonadoAficionado.setEnabled(false);
            this.comboEquiposPersona.setEnabled(false);
            this.btnAgregarEquipoPersona.setEnabled(false);
            this.eliminarEquipoPersona.setEnabled(false);
            this.btnEliminarPersona.setEnabled(false);
            this.btnActualizarPersona.setEnabled(false);
            this.btnBuscarPersona.setEnabled(true);
            this.btnCrearPersona.setEnabled(false);
            this.comboManagerJugador.setEnabled(false);
            this.btnAgregarManagerJugador.setEnabled(false);
            this.btnEliminarManagerJugador.setEnabled(false);
            this.txtNombrePersona.setEnabled(false);
            this.txtCedulaPersona.setEnabled(true);
            this.txtApellidoPersona.setEnabled(false);
            this.txtEdadPersona.setEnabled(false);
        } else if (opcionSeleccionada == 1) {
            this.txtSalarioTecnicoyJugador.setEnabled(false);
            this.comboFIFAarbitro.setEnabled(false);
            this.txtAñosExpTecnico.setEnabled(false);
            this.txtAñosAfiliacionManager.setEnabled(false);
            this.txtNacionalidadJugador.setEnabled(false);
            this.txtPosicionJugador.setEnabled(false);
            this.txtGolesJugador.setEnabled(false);
            this.txtAñosFidelidadAficionado.setEnabled(true);
            this.comboAbonadoAficionado.setEnabled(true);
            this.comboEquiposPersona.setEnabled(true);
            this.btnAgregarEquipoPersona.setEnabled(true);
            this.eliminarEquipoPersona.setEnabled(true);
            this.btnEliminarPersona.setEnabled(true);
            this.btnActualizarPersona.setEnabled(true);
            this.btnBuscarPersona.setEnabled(true);
            this.btnCrearPersona.setEnabled(true);
            this.txtNombrePersona.setEnabled(true);
            this.txtCedulaPersona.setEnabled(true);
            this.txtApellidoPersona.setEnabled(true);
            this.txtEdadPersona.setEnabled(true);
            this.comboManagerJugador.setEnabled(false);
            this.btnAgregarManagerJugador.setEnabled(false);
            this.btnEliminarManagerJugador.setEnabled(false);
        } else if (opcionSeleccionada == 2) {
            this.txtSalarioTecnicoyJugador.setEnabled(false);
            this.comboFIFAarbitro.setEnabled(true);
            this.txtAñosExpTecnico.setEnabled(false);
            this.txtAñosAfiliacionManager.setEnabled(false);
            this.txtNacionalidadJugador.setEnabled(false);
            this.txtPosicionJugador.setEnabled(false);
            this.txtGolesJugador.setEnabled(false);
            this.txtAñosFidelidadAficionado.setEnabled(false);
            this.comboAbonadoAficionado.setEnabled(false);
            this.comboEquiposPersona.setEnabled(false);
            this.btnAgregarEquipoPersona.setEnabled(false);
            this.eliminarEquipoPersona.setEnabled(false);
            this.btnEliminarPersona.setEnabled(true);
            this.btnActualizarPersona.setEnabled(true);
            this.btnBuscarPersona.setEnabled(true);
            this.btnCrearPersona.setEnabled(true);
            this.txtNombrePersona.setEnabled(true);
            this.txtCedulaPersona.setEnabled(true);
            this.txtApellidoPersona.setEnabled(true);
            this.txtEdadPersona.setEnabled(true);
            this.comboManagerJugador.setEnabled(false);
            this.btnAgregarManagerJugador.setEnabled(false);
            this.btnEliminarManagerJugador.setEnabled(false);
            
        } else if (opcionSeleccionada == 3) {
            this.txtSalarioTecnicoyJugador.setEnabled(true);
            this.comboFIFAarbitro.setEnabled(false);
            this.txtAñosExpTecnico.setEnabled(false);
            this.txtAñosAfiliacionManager.setEnabled(false);
            this.txtNacionalidadJugador.setEnabled(true);
            this.txtPosicionJugador.setEnabled(true);
            this.txtGolesJugador.setEnabled(true);
            this.txtAñosFidelidadAficionado.setEnabled(false);
            this.comboAbonadoAficionado.setEnabled(false);
            this.comboEquiposPersona.setEnabled(true);
            this.btnAgregarEquipoPersona.setEnabled(true);
            this.eliminarEquipoPersona.setEnabled(true);
            this.btnEliminarPersona.setEnabled(true);
            this.btnActualizarPersona.setEnabled(true);
            this.btnBuscarPersona.setEnabled(true);
            this.btnCrearPersona.setEnabled(true);
            this.txtNombrePersona.setEnabled(true);
            this.txtCedulaPersona.setEnabled(true);
            this.txtApellidoPersona.setEnabled(true);
            this.txtEdadPersona.setEnabled(true);
            this.comboManagerJugador.setEnabled(true);
            this.btnAgregarManagerJugador.setEnabled(true);
            this.btnEliminarManagerJugador.setEnabled(true);
        } else if (opcionSeleccionada == 4) {
            this.txtSalarioTecnicoyJugador.setEnabled(false);
            this.comboFIFAarbitro.setEnabled(false);
            this.txtAñosExpTecnico.setEnabled(false);
            this.txtAñosAfiliacionManager.setEnabled(true);
            this.txtNacionalidadJugador.setEnabled(false);
            this.txtPosicionJugador.setEnabled(false);
            this.txtGolesJugador.setEnabled(false);
            this.txtAñosFidelidadAficionado.setEnabled(false);
            this.comboAbonadoAficionado.setEnabled(false);
            this.comboEquiposPersona.setEnabled(true);
            this.btnAgregarEquipoPersona.setEnabled(true);
            this.eliminarEquipoPersona.setEnabled(true);
            this.btnEliminarPersona.setEnabled(true);
            this.btnActualizarPersona.setEnabled(true);
            this.btnBuscarPersona.setEnabled(true);
            this.btnCrearPersona.setEnabled(true);
            this.txtNombrePersona.setEnabled(true);
            this.txtCedulaPersona.setEnabled(true);
            this.txtApellidoPersona.setEnabled(true);
            this.txtEdadPersona.setEnabled(true);
            this.comboManagerJugador.setEnabled(false);
            this.btnAgregarManagerJugador.setEnabled(false);
            this.btnEliminarManagerJugador.setEnabled(false);
        } else if (opcionSeleccionada == 5) {
            this.txtSalarioTecnicoyJugador.setEnabled(true);
            this.comboFIFAarbitro.setEnabled(false);
            this.txtAñosExpTecnico.setEnabled(true);
            this.txtAñosAfiliacionManager.setEnabled(false);
            this.txtNacionalidadJugador.setEnabled(false);
            this.txtPosicionJugador.setEnabled(false);
            this.txtGolesJugador.setEnabled(false);
            this.txtAñosFidelidadAficionado.setEnabled(false);
            this.comboAbonadoAficionado.setEnabled(false);
            this.comboEquiposPersona.setEnabled(true);
            this.btnAgregarEquipoPersona.setEnabled(true);
            this.eliminarEquipoPersona.setEnabled(true);
            this.btnEliminarPersona.setEnabled(true);
            this.btnActualizarPersona.setEnabled(true);
            this.btnBuscarPersona.setEnabled(true);
            this.btnCrearPersona.setEnabled(true);
            this.txtNombrePersona.setEnabled(true);
            this.txtCedulaPersona.setEnabled(true);
            this.txtApellidoPersona.setEnabled(true);
            this.txtEdadPersona.setEnabled(true);
            this.comboManagerJugador.setEnabled(false);
            this.btnAgregarManagerJugador.setEnabled(false);
            this.btnEliminarManagerJugador.setEnabled(false);
        }
    }//GEN-LAST:event_comboPersonaActionPerformed

    private void txtCedulaPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaPersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaPersonaActionPerformed

    private void txtNombrePersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombrePersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombrePersonaActionPerformed

    private void btnBuscarPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPersonaActionPerformed
        String idBuscado = this.txtCedulaPersona.getText();
        Object objetoEncontrado = this.miControladorPersona.get(idBuscado);
        if (objetoEncontrado instanceof Aficionado) {
            this.comboPersona.setSelectedIndex(1);
            Aficionado encontrado = (Aficionado) objetoEncontrado;
            this.txtNombrePersona.setText(encontrado.getNombre());
            this.txtCedulaPersona.setText(encontrado.getCedula());
            this.txtApellidoPersona.setText(encontrado.getApellido());
            this.txtEdadPersona.setText("" + encontrado.getEdad());
            this.txtAñosFidelidadAficionado.setText("" + encontrado.getAñosFidelidad());
            if (encontrado.isAbonado() == true) {
                this.comboAbonadoAficionado.setSelectedIndex(0);
            } else {
                this.comboAbonadoAficionado.setSelectedIndex(1);
            }
        } else if (objetoEncontrado instanceof Arbitro) {
            this.comboPersona.setSelectedIndex(2);
            Arbitro encontrado = (Arbitro) objetoEncontrado;
            this.txtCedulaPersona.setText(encontrado.getCedula());
            this.txtNombrePersona.setText(encontrado.getNombre());
            this.txtApellidoPersona.setText(encontrado.getApellido());
            this.txtEdadPersona.setText("" + encontrado.getEdad());
            if (encontrado.isaFIFA()) {
                this.comboFIFAarbitro.setSelectedIndex(0);
            } else {
                this.comboFIFAarbitro.setSelectedIndex(1);
            }
        } else if (objetoEncontrado instanceof Jugador) {
            this.comboPersona.setSelectedIndex(3);
            Jugador encontrado = (Jugador) objetoEncontrado;
            this.txtCedulaPersona.setText(encontrado.getCedula());
            this.txtNombrePersona.setText(encontrado.getNombre());
            this.txtApellidoPersona.setText(encontrado.getApellido());
            this.txtEdadPersona.setText("" + encontrado.getEdad());
            this.txtGolesJugador.setText("" + encontrado.getGolesMarcados());
            this.txtNacionalidadJugador.setText(encontrado.getNacionalidad());
            this.txtPosicionJugador.setText(encontrado.getPosicion());
            this.txtSalarioTecnicoyJugador.setText("" + encontrado.getSalario());
        } else if (objetoEncontrado instanceof Manager) {
            this.comboPersona.setSelectedIndex(4);
            Manager encontrado = (Manager) objetoEncontrado;
            this.txtCedulaPersona.setText(encontrado.getCedula());
            this.txtNombrePersona.setText(encontrado.getNombre());
            this.txtApellidoPersona.setText(encontrado.getApellido());
            this.txtEdadPersona.setText("" + encontrado.getEdad());
            this.txtAñosAfiliacionManager.setText("" + encontrado.getAñosAfiliacion());
        } else if (objetoEncontrado instanceof Tecnico) {
            this.comboPersona.setSelectedIndex(5);
            Tecnico encontrado = (Tecnico) objetoEncontrado;
            this.txtCedulaPersona.setText(encontrado.getCedula());
            this.txtNombrePersona.setText(encontrado.getNombre());
            this.txtApellidoPersona.setText(encontrado.getApellido());
            this.txtEdadPersona.setText("" + encontrado.getEdad());
            this.txtSalarioTecnicoyJugador.setText("" + encontrado.getSalario());
            this.txtAñosExpTecnico.setText("" + encontrado.getAñosExperiencia());
        } else {
            JOptionPane.showMessageDialog(this, "La persona buscada no existe");
        }
    }//GEN-LAST:event_btnBuscarPersonaActionPerformed

    private void btnActualizarPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarPersonaActionPerformed
        int personaSeleccionada = this.comboPersona.getSelectedIndex();
        if (personaSeleccionada == 1) {
            String cedula = this.txtCedulaPersona.getText();
            String nombre = this.txtNombrePersona.getText();
            String apellido = this.txtApellidoPersona.getText();
            int edad = Integer.parseInt(this.txtEdadPersona.getText());
            int añosAficionado = Integer.parseInt(this.txtAñosFidelidadAficionado.getText());
            boolean abonado = false;
            if (this.comboAbonadoAficionado.getSelectedIndex() == 0) {
                abonado = true;
            }
            Aficionado aficionadoNuevo = new Aficionado(cedula, nombre, apellido, edad, añosAficionado, abonado);
            Object exito = this.miControladorPersona.Update(aficionadoNuevo);
            if (exito != null) {
                JOptionPane.showMessageDialog(this, "Aficionado actualizado correctamente");
            } else {
                JOptionPane.showMessageDialog(this, "Aficionado no actualizado");
            }
            LimpiarCajasPersona();
        } else if (personaSeleccionada == 2) {
            String cedula = this.txtCedulaPersona.getText();
            String nombre = this.txtNombrePersona.getText();
            String apellido = this.txtApellidoPersona.getText();
            int edad = Integer.parseInt(this.txtEdadPersona.getText());
            boolean aFIFA = false;
            if (this.comboFIFAarbitro.getSelectedIndex() == 0) {
                aFIFA = true;
            }

            Arbitro arbitroNuevo = new Arbitro(cedula, nombre, apellido, edad, aFIFA);
            Object exito = this.miControladorPersona.Update(arbitroNuevo);
            if (exito != null) {
                JOptionPane.showMessageDialog(this, "Arbitro actualizado exitosamente");
            } else {
                JOptionPane.showMessageDialog(this, "Arbitro no actualizado");
            }
            LimpiarCajasPersona();
        } else if (personaSeleccionada == 3) {
            String cedula = this.txtCedulaPersona.getText();
            String nombre = this.txtNombrePersona.getText();
            String apellido = this.txtApellidoPersona.getText();
            int edad = Integer.parseInt(this.txtEdadPersona.getText());
            String nacionalidad = this.txtNacionalidadJugador.getText();
            String posicion = this.txtPosicionJugador.getText();
            int golesMarcados = Integer.parseInt(this.txtGolesJugador.getText());
            double salario = Double.parseDouble(this.txtSalarioTecnicoyJugador.getText());
            Jugador jugadorNuevo = new Jugador(cedula, nombre, apellido, edad, nacionalidad, posicion, golesMarcados, salario);
            Object exito = this.miControladorPersona.Update(jugadorNuevo);
            if (exito != null) {
                JOptionPane.showMessageDialog(this, "Jugador actualizado exitosamente");
            } else {
                JOptionPane.showMessageDialog(this, "Jugador no actualizado");
            }
            LimpiarCajasPersona();
        } else if (personaSeleccionada == 4) {
            String cedula = this.txtCedulaPersona.getText();
            String nombre = this.txtNombrePersona.getText();
            String apellido = this.txtApellidoPersona.getText();
            int edad = Integer.parseInt(this.txtEdadPersona.getText());
            int añosAfiliacion = Integer.parseInt(this.txtAñosAfiliacionManager.getText());

            Manager managerNuevo = new Manager(cedula, nombre, apellido, edad, añosAfiliacion);
            Object exito = this.miControladorPersona.Update(managerNuevo);
            if (exito != null) {
                JOptionPane.showMessageDialog(this, "Manager actualizado exitosamente");
            } else {
                JOptionPane.showMessageDialog(this, "Manager no actualizado");
            }
            LimpiarCajasPersona();
        } else if (personaSeleccionada == 5) {
            String cedula = this.txtCedulaPersona.getText();
            String nombre = this.txtNombrePersona.getText();
            String apellido = this.txtApellidoPersona.getText();
            int edad = Integer.parseInt(this.txtEdadPersona.getText());
            int añosExperiencia = Integer.parseInt(this.txtAñosExpTecnico.getText());
            double salario = Double.parseDouble(this.txtSalarioTecnicoyJugador.getText());
            Tecnico tecnicoNuevo = new Tecnico(cedula, nombre, apellido, edad, añosExperiencia, salario);
            Object exito = this.miControladorPersona.Update(tecnicoNuevo);
            if (exito != null) {
                JOptionPane.showMessageDialog(this, "Tecnico actualizado exitosamente");
            } else {
                JOptionPane.showMessageDialog(this, "Tecnico no actualizado");
            }
            LimpiarCajasPersona();

        }
        ActualizarTablaAficionados();
        ActualizarTablaArbitros();
        ActualizarTablaJugadores();
        ActualizarTablaManagers();
        ActualizarTablaTecnicos();
        actualizarComboManagers();
        actualizarComboArbitros();
        actualizarComboJugadores();
        actualizarComboManagersListar();
    }//GEN-LAST:event_btnActualizarPersonaActionPerformed

    private void btnEliminarPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPersonaActionPerformed
        String idEliminar = this.txtCedulaPersona.getText();
        boolean exito = this.miControladorPersona.Delete(idEliminar);
        if (exito) {
            JOptionPane.showMessageDialog(this, "Persona eliminada exitosamente");
        } else {
            JOptionPane.showMessageDialog(this, "Persona no eliminada");
        }
        LimpiarCajasPersona();
        ActualizarTablaAficionados();
        ActualizarTablaArbitros();
        ActualizarTablaJugadores();
        ActualizarTablaManagers();
        ActualizarTablaTecnicos();
        actualizarComboManagers();
        actualizarComboArbitros();
        actualizarComboArbitros();
        actualizarComboJugadores();
        actualizarComboManagersListar();
    }//GEN-LAST:event_btnEliminarPersonaActionPerformed

    private void txtIdEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdEquipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdEquipoActionPerformed

    private void btnCrearEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearEquipoActionPerformed
        String id = this.txtIdEquipo.getText();
        String nombre = this.txtNombreEquipo.getText();
        int añoFundacion = Integer.parseInt(this.txtAñoFundacionEquipo.getText());
        int titulosNacionales = Integer.parseInt(this.txtTitulosNacionalesEquipo.getText());
        int titulosInternacionales = Integer.parseInt(this.txtTitulosInternacionalesEquipo.getText());
        int puntos = Integer.parseInt(this.txtPuntosEquipo.getText());
        int golesAFavor = Integer.parseInt(this.txtGolesFavorEquipo.getText());
        int golesEnContra = Integer.parseInt(this.txtGolesContraEquipo.getText());
        int partidosJugados = Integer.parseInt(this.txtPartidosJugadosEquipo.getText());
        Equipo equipoNuevo = new Equipo(id, nombre, añoFundacion, titulosNacionales, titulosInternacionales, puntos, golesAFavor, golesEnContra, partidosJugados);
        boolean exito = this.miControladorEquipo.Create(equipoNuevo);
        if (exito) {
            JOptionPane.showMessageDialog(this, "Equipo creado exitosamente");
        } else {
            JOptionPane.showMessageDialog(this, "Equipo no creado");
        }
        LimpiarCajasEquipos();
        ActualizarTablaEquipos();
        actualizarComboEquipos();
        actualizarComboEquipoLocal();
        actualizarComboEquipoVisitante();
        actualizarComboEquipoListar();
        actualizarComboEquiposMetodo();
        ActualizarTablaPosicionesLiga();

    }//GEN-LAST:event_btnCrearEquipoActionPerformed

    private void btnBuscarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEquipoActionPerformed
        String idBuscado = this.txtIdEquipo.getText();
        Object EquipoEncontrado = this.miControladorEquipo.get(idBuscado);
        Equipo encontrado = (Equipo) EquipoEncontrado;

        if (EquipoEncontrado != null) {
            this.txtNombreEquipo.setText(encontrado.getNombre());
            this.txtAñoFundacionEquipo.setText("" + encontrado.getAñoFundacion());
            this.txtTitulosNacionalesEquipo.setText("" + encontrado.getTitulosNacionales());
            this.txtTitulosInternacionalesEquipo.setText("" + encontrado.getTitulosInternacionales());
            this.txtPuntosEquipo.setText("" + encontrado.getPuntos());
            this.txtGolesFavorEquipo.setText("" + encontrado.getGolesAFavor());
            this.txtGolesContraEquipo.setText("" + encontrado.getGolesEnContra());
            this.txtPartidosJugadosEquipo.setText("" + encontrado.getPartidosJugados());
        } else {
            JOptionPane.showMessageDialog(this, "Equipo buscado no existe");
        }

        
                                                      

        
        
        
    }//GEN-LAST:event_btnBuscarEquipoActionPerformed

    private void btnActualizarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarEquipoActionPerformed
        String id = this.txtIdEquipo.getText();
        String nombre = this.txtNombreEquipo.getText();
        int añoFundacion = Integer.parseInt(this.txtAñoFundacionEquipo.getText());
        int titulosNacionales = Integer.parseInt(this.txtTitulosNacionalesEquipo.getText());
        int titulosInternacionales = Integer.parseInt(this.txtTitulosInternacionalesEquipo.getText());
        int puntos = Integer.parseInt(this.txtPuntosEquipo.getText());
        int golesAFavor = Integer.parseInt(this.txtGolesFavorEquipo.getText());
        int golesEnContra = Integer.parseInt(this.txtGolesContraEquipo.getText());
        int partidosJugados = Integer.parseInt(this.txtPartidosJugadosEquipo.getText());
        Equipo equipoNuevo = new Equipo(id, nombre, añoFundacion, titulosNacionales, titulosInternacionales, puntos, golesAFavor, golesEnContra, partidosJugados);
        Object exito = this.miControladorEquipo.Update(equipoNuevo);
        if (exito!=null) {
            JOptionPane.showMessageDialog(this, "Equipo actualizado exitosamente");
        } else {
            JOptionPane.showMessageDialog(this, "Equipo no actualizado");
        }
        LimpiarCajasEquipos();
        ActualizarTablaEquipos();
        actualizarComboEquipos();
        actualizarComboEquipoLocal();
        actualizarComboEquipoVisitante();
        actualizarComboEquipoListar();
        actualizarComboEquiposMetodo();
        ActualizarTablaPosicionesLiga();

    }//GEN-LAST:event_btnActualizarEquipoActionPerformed

    private void btnEliminarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEquipoActionPerformed
        String idEliminar = this.txtIdEquipo.getText();
        boolean exito = this.miControladorEquipo.Delete(idEliminar);
        if (exito) {
            JOptionPane.showMessageDialog(this, "Equipo eliminado exitosamente");
        } else {
            JOptionPane.showMessageDialog(this, "Equipo no eliminado");
        }
        LimpiarCajasEquipos();
        ActualizarTablaEquipos();
        actualizarComboEquipos();
        actualizarComboEquipoLocal();
        actualizarComboEquipoVisitante();
        actualizarComboEquipoListar();
        actualizarComboEquiposMetodo();
        ActualizarTablaPosicionesLiga();

    }//GEN-LAST:event_btnEliminarEquipoActionPerformed

    private void btnAgregarEquipoPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEquipoPersonaActionPerformed
        String idPersonaBuscada = this.txtCedulaPersona.getText();
        Object encontrada = this.miControladorPersona.get(idPersonaBuscada);
        String idEquipo = obtenerIdSeleccionado();
        boolean exito = false;
        boolean exito2= false;
        if(encontrada!=null){
        Equipo equipo = (Equipo)this.miControladorEquipo.get(idEquipo);
        exito2 = this.miControladorEquipo.setMiPersona(equipo, encontrada);
        if(exito2){
        exito = this.miControladorPersona.setEquipo(encontrada, idEquipo);
        }
        
        }
             
        if(exito&&exito2){

            JOptionPane.showMessageDialog(this, "Relación hecha correctamente");
            
            }
        else{
            JOptionPane.showMessageDialog(this, "No se pudo hacer la relacion");
                    
        }
        
    }//GEN-LAST:event_btnAgregarEquipoPersonaActionPerformed

    private void eliminarEquipoPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarEquipoPersonaActionPerformed

        String idEquipo = obtenerIdSeleccionado();
        System.out.println("ID seleccionado"+idEquipo);
        Equipo equipoActual = (Equipo)this.miControladorEquipo.get(idEquipo);
        String idPersonaBuscada = this.txtCedulaPersona.getText();
        Object encontrada = this.miControladorPersona.get(idPersonaBuscada);
        
        if(encontrada !=null){
         if(encontrada instanceof Aficionado){
            Aficionado aux = (Aficionado)encontrada;
            if(aux.getMiEquipo()!=null){
                if(aux.getMiEquipo().getId().equals(idEquipo)){
                    aux.setMiEquipo(null);
                    
                    JOptionPane.showMessageDialog(this, "Eliminación exitosa");
                }
                else{
                    JOptionPane.showMessageDialog(this, "La relación no existe");
                }
            }
            else{
                JOptionPane.showMessageDialog(this, "La relación no existe");
            }
        }
        else if(encontrada instanceof Jugador){
            Jugador aux = (Jugador)encontrada;            
            if(aux.getMiEquipo()!=null){
                if(aux.getMiEquipo().getId().equals(idEquipo)){
                    aux.setMiEquipo(null);
                    JOptionPane.showMessageDialog(this, "Eliminación exitosa");
                }
                else{
                    JOptionPane.showMessageDialog(this, "La relación no existe");
                }
            }
            else{
                JOptionPane.showMessageDialog(this, "La relación no existe");
            }
        }
        else if(encontrada instanceof Manager){
            Manager aux = (Manager)encontrada;
            if(aux.getMiEquipo()!=null){
                if(aux.getMiEquipo().getId().equals(idEquipo)){
                    aux.setMiEquipo(null);
                    equipoActual.setMiManager(null);
                    JOptionPane.showMessageDialog(this, "Eliminación exitosa");
                }
                else{
                    JOptionPane.showMessageDialog(this, "La relación no existe");
                }
            }
            else{
                JOptionPane.showMessageDialog(this, "La relación no existe");
            }
        }
        else if(encontrada instanceof Tecnico){
            Tecnico aux = (Tecnico)encontrada;
            System.out.println("Entre a tecnico");
            if(aux.getMiEquipo()!=null){
                System.out.println(aux.getMiEquipo().getId()+"Es mi equipo");
                if(aux.getMiEquipo().getId().equals(idEquipo)){
                    System.out.println("Estoy eliminando");
                    aux.setMiEquipo(null);
                    equipoActual.setMiTecnico(null);
                    JOptionPane.showMessageDialog(this, "Eliminación exitosa");
                }
                else{
                    JOptionPane.showMessageDialog(this, "La relación no existe");
                }
            }
            else{
                JOptionPane.showMessageDialog(this, "El Tecnico no tiene ninguna relación");
            }
        }
        }
            else{
                JOptionPane.showMessageDialog(this, "Ingrese una cédula válida");
            }
        
    }//GEN-LAST:event_eliminarEquipoPersonaActionPerformed

    private void btnAgregarManagerJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarManagerJugadorActionPerformed
        String idManager = obtenerIdManagerseleccionado();
        String idjugador = this.txtCedulaPersona.getText();
        Object jugador = this.miControladorPersona.get(idjugador);
        boolean exito = false;
        if(jugador!=null){
        if(jugador instanceof Jugador){
            exito = this.miControladorPersona.getMiJugador().setManager(jugador, idManager);
        }
        }
        
        if(exito){
            JOptionPane.showMessageDialog(this, "Relación hecha correctamente");
        }
        else{
            JOptionPane.showMessageDialog(this,"No se pudo hacer la relación");
        }
        
    }//GEN-LAST:event_btnAgregarManagerJugadorActionPerformed

    private void btnEliminarManagerJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarManagerJugadorActionPerformed
        Jugador jugador = (Jugador)this.miControladorPersona.get(this.txtCedulaPersona.getText());
        String idManager = obtenerIdManagerseleccionado();
        boolean exito = false;
        
        if(jugador!=null){
        if(jugador.getMiManager()!=null){
            if(jugador.getMiManager().getCedula().equals(idManager)){
            jugador.setMiManager(null);
            exito = true;
            }
        }
        }
        if(exito){
            JOptionPane.showMessageDialog(this, "Eliminación exitosa");
        }
        else{
            JOptionPane.showMessageDialog(this, "Ingrese una cédula válida");
        }
        
        
        
    }//GEN-LAST:event_btnEliminarManagerJugadorActionPerformed

    private void txtNumeroJornadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroJornadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroJornadaActionPerformed

    private void btnCrearJornadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearJornadaActionPerformed
        String id = this.txtidJornada.getText();
        int numero = Integer.parseInt(this.txtNumeroJornada.getText());
        String esloganFIFA = this.txtEsloganFIFAJornada.getText();
        
        Jornada jornadaNueva = new Jornada(id, numero, esloganFIFA);
        boolean exito = this.miControladorJornada.Create(jornadaNueva);
        
        if(exito){
            JOptionPane.showMessageDialog(this, "Jornada creada exitosamente");
        }
        else{
            JOptionPane.showMessageDialog(this, "Jornada no creada");
        }
        LimpiarCajasJornada();
        ActualizarTablaJornadas();
        actualizarComboJornadaPartido();
        actualizarComboJornadaListar();
    }//GEN-LAST:event_btnCrearJornadaActionPerformed

    private void btnBuscarJornadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarJornadaActionPerformed
        String idBuscar = this.txtidJornada.getText();
        Object exito = this.miControladorJornada.get(idBuscar);
        
        if(exito!=null){
            Jornada aux = (Jornada)exito;
            this.txtNumeroJornada.setText(""+aux.getNumeroJ());
            this.txtEsloganFIFAJornada.setText(aux.getEsloganFIFA());
        }
        else{
            JOptionPane.showMessageDialog(this, "Jornada buscada no existe");
        }
    }//GEN-LAST:event_btnBuscarJornadaActionPerformed

    private void btnActualizarJornadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarJornadaActionPerformed
        String id = this.txtidJornada.getText();
        int numeroJornada = Integer.parseInt(this.txtNumeroJornada.getText());
        String esloganFIFA = this.txtEsloganFIFAJornada.getText();        
        Jornada jornadaNueva = new Jornada(id, numeroJornada, esloganFIFA);
        Object actualizada = this.miControladorJornada.Update(jornadaNueva);
        
        if(actualizada != null){
            JOptionPane.showMessageDialog(this, "Jornada actualizada exitosamente");
        }
        else{
            JOptionPane.showMessageDialog(this, "Error al actualizar");
        }
        
        LimpiarCajasJornada();
        ActualizarTablaJornadas();
        actualizarComboJornadaPartido();
        actualizarComboJornadaListar();
        
    }//GEN-LAST:event_btnActualizarJornadaActionPerformed

    private void btnEliminarJornadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarJornadaActionPerformed
        String idEliminar = this.txtidJornada.getText();
        boolean exito = this.miControladorJornada.Delete(idEliminar);
        
        if(exito){
            JOptionPane.showMessageDialog(this, "Jornada eliminada con éxito");
        }
        else{
            JOptionPane.showMessageDialog(this, "Error al eliminar");
        }
        LimpiarCajasJornada();
        ActualizarTablaJornadas();
        actualizarComboJornadaPartido();
        actualizarComboJornadaListar();
    }//GEN-LAST:event_btnEliminarJornadaActionPerformed

    private void txtGolesEquipoVisitanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGolesEquipoVisitanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGolesEquipoVisitanteActionPerformed

    private void txtIdEstadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdEstadioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdEstadioActionPerformed

    private void btnCrearEstadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearEstadioActionPerformed
        String id = this.txtIdEstadio.getText();
        String nombre = this.txtNombreEstadio.getText();
        String ciudad = this.txtCiudadEstadio.getText();
        int capacidad = Integer.parseInt(this.txtCapacidadEstadio.getText());
        Estadio estadioNuevo = new Estadio(id, nombre, ciudad, capacidad);
        boolean exito = this.miControladorEstadio.Create(estadioNuevo);
        if(exito){
            JOptionPane.showMessageDialog(this, "Estadio creado exitosamente");
        }
        else{
            JOptionPane.showMessageDialog(this, "Estadio no creado");
        }
         ActualizarTablaEstadios();
         LimpiarCajasEstadio();
         actualizarComboEstadio();
         actualizarComboEstadiosListar();
        
    }//GEN-LAST:event_btnCrearEstadioActionPerformed

    private void btnBuscarEstadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEstadioActionPerformed
        String idBuscado = this.txtIdEstadio.getText();
        Object encontrado = this.miControladorEstadio.get(idBuscado);
        if(encontrado!=null){
            Estadio aux = (Estadio)encontrado;
            this.txtNombreEstadio.setText(aux.getNombre());
            this.txtCiudadEstadio.setText(aux.getCiudad());
            this.txtCapacidadEstadio.setText(""+aux.getCapacidad());
        }
        else{
            JOptionPane.showMessageDialog(this, "Estadio buscado no existe");
        }
        
    }//GEN-LAST:event_btnBuscarEstadioActionPerformed

    private void btnActualizarEstadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarEstadioActionPerformed
        String id = this.txtIdEstadio.getText();
        String nombre = this.txtNombreEstadio.getText();
        String ciudad = this.txtCiudadEstadio.getText();
        int capacidad = Integer.parseInt(this.txtCapacidadEstadio.getText());
        Estadio estadioNuevo = new Estadio(id, nombre, ciudad, capacidad);
        Object exito = this.miControladorEstadio.Update(estadioNuevo);
        if(exito!=null){
            JOptionPane.showMessageDialog(this, "Estadio actualizado exitosamente");
        }
        else{
            JOptionPane.showMessageDialog(this, "El estadio no existe");
        }
        ActualizarTablaEstadios();
         LimpiarCajasEstadio();
         actualizarComboEstadio();
         actualizarComboEstadiosListar();
    }//GEN-LAST:event_btnActualizarEstadioActionPerformed

    private void btnEliminarEstadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEstadioActionPerformed
        String idEliminar = this.txtIdEstadio.getText();
        boolean exito = this.miControladorEstadio.Delete(idEliminar);
        if(exito){
            JOptionPane.showMessageDialog(this, "Estadio eliminado exitosamente");
        }
        else{
            JOptionPane.showMessageDialog(this, "El estadio no existe");
        }
        ActualizarTablaEstadios();
        LimpiarCajasEstadio();
        actualizarComboEstadio();
        actualizarComboEstadiosListar();
        
    }//GEN-LAST:event_btnEliminarEstadioActionPerformed

    private void btnCrearPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearPartidoActionPerformed

        String id = this.txtidPartido.getText();
        String fecha = this.txtFechaPartido.getText();
        int golesLocal = Integer.parseInt(this.txtGolesEquipoLocal.getText());
        int golesVisitante = Integer.parseInt(this.txtGolesEquipoVisitante.getText());
        Partido partidoNuevo = new Partido(id, fecha, golesLocal, golesVisitante);
        boolean exito = this.miControladorPartido.Create(partidoNuevo);
        if(exito){
            Equipo equipoLocal = (Equipo)this.miControladorEquipo.get(obtenerIdEquipoLocalSeleccionado());
            Equipo equipoVisitante = (Equipo)this.miControladorEquipo.get(obtenerIdEquipoVisitanteSeleccionado());
            String idJornada = obtenerIdJornadaSeleccionada();
            String idArbitro = obtenerIdArbitroSeleccionado();
            String idEstadio = obtenerIdEstadioSeleccionado();
            boolean exito2=this.miControladorPartido.setEquipoLocalYVisitanteYGoles(id, equipoLocal, golesLocal, equipoVisitante, golesVisitante);
            boolean exito3 = this.miControladorPartido.setJornada(id, idJornada);
            boolean exito4 = this.miControladorPersona.getMiArbitro().setPartido(idArbitro, id) && this.miControladorPartido.setArbitro(idArbitro, id);
            boolean exito5 = this.miControladorPartido.setEstadio(idEstadio, id);
            if(exito2&&exito&&exito5&&exito4){
                LinkedList<Object> losEquipos = this.miControladorEquipo.index();
                for(Object equipoactual: losEquipos){
                  Equipo actual = (Equipo)equipoactual;
                if(actual==equipoLocal){
                    actual.setGolesAFavor(actual.getGolesAFavor()+golesLocal);
                    actual.setGolesEnContra(actual.getGolesEnContra()+golesVisitante);
                    actual.setPartidosJugados(actual.getPartidosJugados()+1);
                    if(golesLocal==golesVisitante){
                        actual.setPuntos(actual.getPuntos()+1);
                    }
                    else if(golesLocal>golesVisitante){
                        actual.setPuntos(actual.getPuntos()+3);
                    }
                }
                }
                for(Object equipoactual: losEquipos){
                    Equipo actual = (Equipo)equipoactual;
                if(actual==equipoVisitante){
                    actual.setGolesAFavor(actual.getGolesAFavor()+golesVisitante);
                    actual.setGolesEnContra(actual.getGolesEnContra()+golesLocal);
                    actual.setPartidosJugados(actual.getPartidosJugados()+1);
                    if(golesLocal==golesVisitante){
                        actual.setPuntos(actual.getPuntos()+1);
                    }
                    else if(golesLocal<golesVisitante){
                        actual.setPuntos(actual.getPuntos()+3);
                    }
                }
                
            } 
                
                
                
                
                JOptionPane.showMessageDialog(this, "Partido creado exitosamente");
            }
                
            
            
            else{
                JOptionPane.showMessageDialog(this, "Partido no creado por algún exito=false");
            }    
        }
        else{
            JOptionPane.showMessageDialog(this, "Partido no creado por exito=false");
        }
        ActualizarTablaEquipos();
        LimpiarCajasPartido();
        ActualizarTablaPartidos();
        ActualizarTablaPosicionesLiga();
    }//GEN-LAST:event_btnCrearPartidoActionPerformed

    private void comboEquipoLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEquipoLocalActionPerformed

    }//GEN-LAST:event_comboEquipoLocalActionPerformed

    private void comboEquiposPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEquiposPersonaActionPerformed

    }//GEN-LAST:event_comboEquiposPersonaActionPerformed

    private void btnBuscarPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPartidoActionPerformed
        String idBuscar = this.txtidPartido.getText();
        Object exito = this.miControladorPartido.get(idBuscar);
        
        if(exito!=null){
            Partido aux = (Partido)exito;
            this.txtidPartido.setText(aux.getId());
            this.txtFechaPartido.setText(aux.getFecha());
            this.txtGolesEquipoLocal.setText(""+aux.getGolesLocal());
            this.txtGolesEquipoVisitante.setText(""+aux.getGolesVisitante());
            Equipo local = (Equipo)this.miControladorEquipo.get(aux.getEquipoLocal().getId());
            Equipo visitante = (Equipo)this.miControladorEquipo.get(aux.getEquipoVisitante().getId());
            Estadio estadio = (Estadio)this.miControladorEstadio.get(aux.getMiEstadio().getId());
            Arbitro arbitro = (Arbitro)this.miControladorPersona.get(aux.getMiArbitro().getCedula());
            Jornada jornada = (Jornada)this.miControladorJornada.get(aux.getMiJornada().getId());
            if(local!=null && visitante!=null){
                String textoLocal = local.getId()+"-"+local.getNombre();
                String textoVisitante = visitante.getId()+"-"+visitante.getNombre();
                for (int i = 0; i < this.comboEquipoLocal.getItemCount(); i++){
                    System.out.println(this.comboEquipoLocal.getItemAt(i));
                    if(textoLocal.equals(this.comboEquipoLocal.getItemAt(i))){
                        this.comboEquipoLocal.setSelectedIndex(i);
                    }                            
                }
                for (int i = 0; i < this.comboEquipoVisitante.getItemCount(); i++){
                    if(textoVisitante.equals(this.comboEquipoVisitante.getItemAt(i))){
                        this.comboEquipoVisitante.setSelectedIndex(i);
                    }                            
                }
            
            if(estadio!=null){
                String textoEstadio = estadio.getId()+"-"+estadio.getNombre();
                for (int i = 0; i < this.comboEstadioPartido.getItemCount(); i++){
                    if(textoEstadio.equals(this.comboEstadioPartido.getItemAt(i))){
                        this.comboEstadioPartido.setSelectedIndex(i);
                    }                            
                }
                
        }
            if(arbitro!=null){
                String textoArbitro = arbitro.getCedula()+"-"+arbitro.getNombre();
                for (int i = 0; i < this.comboÁrbitroPartido.getItemCount(); i++){
                    if(textoArbitro.equals(this.comboÁrbitroPartido.getItemAt(i))){
                        this.comboÁrbitroPartido.setSelectedIndex(i);
                    }                            
                }
        }
            if(jornada!=null){
                String textoJornada = jornada.getId()+"-"+"Jornada Número:"+jornada.getNumeroJ();
                for (int i = 0; i < this.comboJornadaPartido.getItemCount(); i++){
                    if(textoJornada.equals(this.comboJornadaPartido.getItemAt(i))){
                        this.comboJornadaPartido.setSelectedIndex(i);
                    }                            
                }
        }
            
        else{
            JOptionPane.showMessageDialog(this, "Partido buscado no existe");
        }
            }   
        
        }
    }//GEN-LAST:event_btnBuscarPartidoActionPerformed

    private void btnActualizarPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarPartidoActionPerformed
        String id = this.txtidPartido.getText();        
        String fecha = this.txtFechaPartido.getText();
        int golesLocal = Integer.parseInt(this.txtGolesEquipoLocal.getText());
        int golesVisitante = Integer.parseInt(this.txtGolesEquipoVisitante.getText());
        Partido partidoNuevo = new Partido(id, fecha, golesLocal, golesVisitante);
        Partido partidoViejo = (Partido)this.miControladorPartido.get(id);
            if(partidoViejo!=null){
            LinkedList<Object> losEquiposviejo = this.miControladorEquipo.index();
            Equipo equipoLocalviejo = (Equipo)this.miControladorEquipo.get(partidoViejo.getEquipoLocal().getId());
            Equipo equipoVisitanteviejo = (Equipo)this.miControladorEquipo.get(partidoViejo.getEquipoVisitante().getId());
            int golesLocalviejo = partidoViejo.getGolesLocal();
            int golesVisitanteviejo = partidoViejo.getGolesVisitante();
                for(Object equipoactual: losEquiposviejo){
                  Equipo actual = (Equipo)equipoactual;
                if(actual==equipoLocalviejo){
                    System.out.println("Si está eliminando");
                    System.out.println(actual.getGolesAFavor());
                    actual.setGolesAFavor(actual.getGolesAFavor()-golesLocalviejo);
                    System.out.println(actual.getGolesAFavor());
                    actual.setGolesEnContra(actual.getGolesEnContra()-golesVisitanteviejo);
                    actual.setPartidosJugados(actual.getPartidosJugados()-1);
                    if(golesLocalviejo==golesVisitanteviejo){
                        actual.setPuntos(actual.getPuntos()-1);
                    }
                    else if(golesLocalviejo>golesVisitanteviejo){
                        actual.setPuntos(actual.getPuntos()-3);
                    }
                }
                }
                for(Object equipoactual: losEquiposviejo){
                    Equipo actual = (Equipo)equipoactual;
                    if(actual==equipoVisitanteviejo){
                    System.out.println("Si está eliminando");
                    System.out.println(actual.getGolesAFavor());
                    actual.setGolesAFavor(actual.getGolesAFavor()-golesVisitanteviejo);
                    System.out.println(actual.getGolesAFavor());
                    actual.setGolesEnContra(actual.getGolesEnContra()-golesLocalviejo);
                    actual.setPartidosJugados(actual.getPartidosJugados()-1);
                    if(golesLocalviejo==golesVisitanteviejo){
                        actual.setPuntos(actual.getPuntos()-1);
                    }
                    else if(golesLocalviejo<golesVisitanteviejo){
                        actual.setPuntos(actual.getPuntos()-3);
                    }
                }
            }
        Object exito = this.miControladorPartido.Update(partidoNuevo);
        if(exito!=null){                                  
            Equipo equipoLocal = (Equipo)this.miControladorEquipo.get(obtenerIdEquipoLocalSeleccionado());
            Equipo equipoVisitante = (Equipo)this.miControladorEquipo.get(obtenerIdEquipoVisitanteSeleccionado());
            String idJornada = obtenerIdJornadaSeleccionada();
            String idArbitro = obtenerIdArbitroSeleccionado();
            String idEstadio = obtenerIdEstadioSeleccionado();
            boolean exito2=this.miControladorPartido.setEquipoLocalYVisitanteYGoles(id, equipoLocal, golesLocal, equipoVisitante, golesVisitante);
            boolean exito3 = this.miControladorPartido.setJornada(id, idJornada);
            boolean exito4 = this.miControladorPersona.getMiArbitro().setPartido(idArbitro, id) && this.miControladorPartido.setArbitro(idArbitro, id);
            boolean exito5 = this.miControladorPartido.setEstadio(idEstadio, id);
            if(exito2&&exito3&&exito4&&exito5){
                LinkedList<Object> losEquipos = this.miControladorEquipo.index();
                for(Object equipoactual: losEquipos){
                  Equipo actual = (Equipo)equipoactual;
                if(actual==equipoLocal){
                    actual.setGolesAFavor(+golesLocal);
                    actual.setGolesEnContra(+golesVisitante);
                    actual.setPartidosJugados(+1);
                    if(golesLocal==golesVisitante){
                        actual.setPuntos(+1);
                    }
                    else if(golesLocal>golesVisitante){
                        actual.setPuntos(+3);
                    }
                }
                }
                for(Object equipoactual: losEquipos){
                    Equipo actual = (Equipo)equipoactual;
                if(actual==equipoVisitante){
                    actual.setGolesAFavor(+golesVisitante);
                    actual.setGolesEnContra(+golesLocal);
                    actual.setPartidosJugados(+1);
                    if(golesLocal==golesVisitante){
                        actual.setPuntos(+1);
                    }
                    else if(golesLocal<golesVisitante){
                        actual.setPuntos(+3);
                    }
                }
                
            } 
                JOptionPane.showMessageDialog(this, "Partido actualizado exitosamente");
            }
            else{
                JOptionPane.showMessageDialog(this, "Partido no actualizado");
            }    
        }
        else{
            JOptionPane.showMessageDialog(this, "Partido no existe");
        }
            }
        ActualizarTablaEquipos();
        LimpiarCajasPartido();
        ActualizarTablaPartidos();
        ActualizarTablaPosicionesLiga();
    }//GEN-LAST:event_btnActualizarPartidoActionPerformed

    private void btnEliminarPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPartidoActionPerformed
        String id = this.txtidPartido.getText();        
        Partido partidoViejo = (Partido)this.miControladorPartido.get(id);
            if(partidoViejo!=null){
            LinkedList<Object> losEquiposviejo = this.miControladorEquipo.index();
            Equipo equipoLocalviejo = (Equipo)this.miControladorEquipo.get(partidoViejo.getEquipoLocal().getId());
            Equipo equipoVisitanteviejo = (Equipo)this.miControladorEquipo.get(partidoViejo.getEquipoVisitante().getId());
            int golesLocalviejo = partidoViejo.getGolesLocal();
            int golesVisitanteviejo = partidoViejo.getGolesVisitante();
                for(Object equipoactual: losEquiposviejo){
                  Equipo actual = (Equipo)equipoactual;
                if(actual==equipoLocalviejo){
                    System.out.println("Si está eliminando");
                    System.out.println(actual.getGolesAFavor());
                    actual.setGolesAFavor(actual.getGolesAFavor()-golesLocalviejo);
                    System.out.println(actual.getGolesAFavor());
                    actual.setGolesEnContra(actual.getGolesEnContra()-golesVisitanteviejo);
                    actual.setPartidosJugados(actual.getPartidosJugados()-1);
                    if(golesLocalviejo==golesVisitanteviejo){
                        actual.setPuntos(actual.getPuntos()-1);
                    }
                    else if(golesLocalviejo>golesVisitanteviejo){
                        actual.setPuntos(actual.getPuntos()-3);
                    }
                }
                }
                for(Object equipoactual: losEquiposviejo){
                    Equipo actual = (Equipo)equipoactual;
                    if(actual==equipoVisitanteviejo){
                    System.out.println("Si está eliminando");
                    System.out.println(actual.getGolesAFavor());
                    actual.setGolesAFavor(actual.getGolesAFavor()-golesVisitanteviejo);
                    System.out.println(actual.getGolesAFavor());
                    actual.setGolesEnContra(actual.getGolesEnContra()-golesLocalviejo);
                    actual.setPartidosJugados(actual.getPartidosJugados()-1);
                    if(golesLocalviejo==golesVisitanteviejo){
                        actual.setPuntos(actual.getPuntos()-1);
                    }
                    else if(golesLocalviejo<golesVisitanteviejo){
                        actual.setPuntos(actual.getPuntos()-3);
                    }
                }
            }
            }
            boolean exito = this.miControladorPartido.Delete(id);
            if(exito){
                JOptionPane.showMessageDialog(this, "Partido eliminado exitosamente");
            }
            else{
                JOptionPane.showMessageDialog(this, "El partido no existe");
            }
            ActualizarTablaPartidos();
            LimpiarCajasPartido();
            ActualizarTablaEquipos();
            ActualizarTablaPosicionesLiga();
    }//GEN-LAST:event_btnEliminarPartidoActionPerformed
    
    private void LimpiarCajasGolesJugador(){
        this.comboJugadorGoles.setSelectedIndex(0);
        this.spinGolesJugador.setValue((Object)0);
    }
    
    private void btnAsignarGolesJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarGolesJugadorActionPerformed
        String idJugador = obtenerIdJugadorSeleccionado();
        int goles = (int)this.spinGolesJugador.getValue();
        boolean exito = this.miControladorPersona.getMiJugador().setGoles(idJugador, goles);
        if(exito){
            JOptionPane.showMessageDialog(this, "Goles asignados correctamente");
        }
        else{
            JOptionPane.showMessageDialog(this, "Goles no asignados");
        }
        
        ActualizarTablaJugadores();
        LimpiarCajasGolesJugador();
    }//GEN-LAST:event_btnAsignarGolesJugadorActionPerformed

    private void btnListarRelacionesEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarRelacionesEquipoActionPerformed
        Equipo encontrado = (Equipo)this.miControladorEquipo.get(obtenerIdEquipoListarSeleccionado());
        encontrado.setMisAficionados(this.miControladorPersona.getAficionadosEquipo(encontrado.getId()));
        encontrado.setMisJugadores(this.miControladorPersona.getJugadoresEquipo(encontrado.getId()));
        encontrado.setMisPartidos(this.miControladorPartido.getPartidosEquipo(encontrado.getId()));
        
        this.labelListarEquipo.setText("Relaciones de "+encontrado.getNombre());
        String nombreColumnas[] = {"Nombre Jugador","Cedula Jugador"};
        DefaultTableModel miModelo = new DefaultTableModel(null, nombreColumnas);
        this.tablaJugadoresEquipo.setModel(miModelo);
        LinkedList<Jugador> losJugadores = encontrado.getMisJugadores();

        for (Object jugadorActual : losJugadores) {
            if (jugadorActual instanceof Jugador) {
                String fila[] = new String[nombreColumnas.length];
                fila[1] = ((Jugador) jugadorActual).getCedula();
                fila[0] = ((Jugador) jugadorActual).getNombre();
                miModelo.addRow(fila);
            }
        }
        
        String nombreColumnas2[] = {"Nombre Aficionado","Cedula Aficionado"};
        DefaultTableModel miModelo2 = new DefaultTableModel(null, nombreColumnas2);
        this.tablaAficionadosEquipo.setModel(miModelo2);
        LinkedList<Aficionado> losAficionados = encontrado.getMisAficionados();

        for (Object aficionadoActual : losAficionados) {
            if (aficionadoActual instanceof Aficionado) {
                String fila[] = new String[nombreColumnas.length];
                fila[1] = ((Aficionado) aficionadoActual).getCedula();
                fila[0] = ((Aficionado) aficionadoActual).getNombre();
                miModelo2.addRow(fila);
            }
        }
        
        String nombreColumnas3[] = {"Enfrentamiento","Id Partido"};
        DefaultTableModel miModelo3 = new DefaultTableModel(null, nombreColumnas3);
        this.tablaPartidosEquipo.setModel(miModelo3);
        LinkedList<Partido> losPartidos = encontrado.getMisPartidos();

        for (Object partidoActual : losPartidos) {
            if (partidoActual instanceof Partido) {
                Partido aux = (Partido)partidoActual;
                String fila[] = new String[nombreColumnas.length];
                fila[0] = ((Equipo)this.miControladorEquipo.get(aux.getEquipoLocal().getId())).getNombre()+"-"+((Equipo)this.miControladorEquipo.get(aux.getEquipoVisitante().getId())).getNombre();
                fila[1] = ((Partido) partidoActual).getId();
                miModelo3.addRow(fila);
            }
        }
        
        
    }//GEN-LAST:event_btnListarRelacionesEquipoActionPerformed

    private void btnListarPartidosEstadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarPartidosEstadioActionPerformed
        Estadio encontrado = (Estadio)this.miControladorEstadio.get(obtenerIdEstadioListarSeleccionado());
        encontrado.setMisPartidos(this.miControladorPartido.getPartidoEstadio(encontrado.getId()));
        
        String nombreColumnas[] = {"Enfrentamiento","Identificador Partido"};
        DefaultTableModel miModelo = new DefaultTableModel(null, nombreColumnas);
        this.tablaPartidosEstadio.setModel(miModelo);
        LinkedList<Partido> losPartidos = encontrado.getMisPartidos();

        for (Object partidoActual : losPartidos) {
            if (partidoActual instanceof Partido) {
                Partido aux = (Partido)partidoActual;
                String fila[] = new String[nombreColumnas.length];
                fila[0] = ((Equipo)this.miControladorEquipo.get(aux.getEquipoLocal().getId())).getNombre()+"-"+((Equipo)this.miControladorEquipo.get(aux.getEquipoVisitante().getId())).getNombre();
                fila[1] = ((Partido) partidoActual).getId();
                miModelo.addRow(fila);
            }
        }
    }//GEN-LAST:event_btnListarPartidosEstadioActionPerformed

    private void btnListarRelacionesJornadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarRelacionesJornadaActionPerformed
        Jornada encontrado = (Jornada)this.miControladorJornada.get(obtenerIdJornadaListarSeleccionada());
        encontrado.setMisPartidos(this.miControladorPartido.getPartidosJornada(encontrado.getId()));
        
        String nombreColumnas[] = {"Enfrentamiento","Identificador Partido"};
        DefaultTableModel miModelo = new DefaultTableModel(null, nombreColumnas);
        this.tablaPartidosJornada.setModel(miModelo);
        LinkedList<Partido> losPartidos = encontrado.getMisPartidos();

        for (Object partidoActual : losPartidos) {
            if (partidoActual instanceof Partido) {
                Partido aux = (Partido)partidoActual;
                String fila[] = new String[nombreColumnas.length];
                fila[0] = ((Equipo)this.miControladorEquipo.get(aux.getEquipoLocal().getId())).getNombre()+"-"+((Equipo)this.miControladorEquipo.get(aux.getEquipoVisitante().getId())).getNombre();
                fila[1] = ((Partido) partidoActual).getId();
                miModelo.addRow(fila);
            }
        }
    }//GEN-LAST:event_btnListarRelacionesJornadaActionPerformed

    private void btnListarRelacionesManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarRelacionesManagerActionPerformed
        Manager encontrado = (Manager)this.miControladorPersona.get(obtenerIdManagersListarSeleccionado());
        encontrado.setMiJugadores(this.miControladorPersona.getJugadoresManager(encontrado.getCedula()));
        
        String nombreColumnas[] = {"Nombre Jugador","Cedula Jugador"};
        DefaultTableModel miModelo = new DefaultTableModel(null, nombreColumnas);
        this.tablaJugadoresManager.setModel(miModelo);
        LinkedList<Jugador> losJugadores = encontrado.getMiJugadores();

        for (Object jugadorActual : losJugadores) {
            if (jugadorActual instanceof Jugador) {
                String fila[] = new String[nombreColumnas.length];
                fila[1] = ((Jugador) jugadorActual).getCedula();
                fila[0] = ((Jugador) jugadorActual).getNombre();
                miModelo.addRow(fila);
            }
        }
    }//GEN-LAST:event_btnListarRelacionesManagerActionPerformed

    private void btnJugadorMasJovenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugadorMasJovenActionPerformed
        LinkedList<Object> recorrido = this.miControladorEquipo.index();
        int menor = Integer.MAX_VALUE;
        String respuesta = "";
        for(Object actual:recorrido){
            Equipo equipoActual = (Equipo)actual;
            equipoActual.setMisJugadores(this.miControladorPersona.getJugadoresEquipo(equipoActual.getId()));
            String idActual = equipoActual.getId();
            Jugador joven = this.miControladorEquipo.jugadorMasJoven(idActual);
            if(joven.getEdad()<menor){
                respuesta = joven.getNombre()+" "+joven.getApellido()+"-"+joven.getCedula();
                menor = joven.getEdad();
            }            
        }
        this.txtRespuestaMasJoven.setText(respuesta);
        
    }//GEN-LAST:event_btnJugadorMasJovenActionPerformed

    private void btnPromedioEdadEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromedioEdadEquipoActionPerformed
        double respuesta = 0;
        LinkedList<Object> losEquipos = this.miControladorEquipo.index();
        for(Object actual:losEquipos){
            Equipo equipoActual = (Equipo)actual;
            String idEquipoActual = equipoActual.getId();
            if(idEquipoActual.equals(obtenerIdEquiposMetodo())){
                respuesta = this.miControladorEquipo.promedioEdad(idEquipoActual);
                this.txtRespuestaPromedioEdad.setText(""+respuesta);                
            }
        }
    }//GEN-LAST:event_btnPromedioEdadEquipoActionPerformed

    private void btnCantidadPartidosGoleadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCantidadPartidosGoleadaActionPerformed
        int respuesta = 0;
        LinkedList<Object> lasJornadas = this.miControladorJornada.index();
        
        for(Object actual: lasJornadas){
            Jornada jornadaActual = (Jornada)actual;
            String idJornada = jornadaActual.getId();
            respuesta += this.miControladorJornada.partidosGoleada(idJornada);
        }
        this.txtRespuestaPartidosGoleada.setText(""+respuesta);
    }//GEN-LAST:event_btnCantidadPartidosGoleadaActionPerformed

    private void btnObtenerJugadorMasGolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObtenerJugadorMasGolesActionPerformed
       LinkedList<Object> recorrido = this.miControladorEquipo.index();
        int mayor = Integer.MIN_VALUE;
        String respuesta = "";
        for(Object actual:recorrido){
            Equipo equipoActual = (Equipo)actual;
            String idActual = equipoActual.getId();
            Jugador masGoles = this.miControladorEquipo.jugadorMasGoles(idActual);
            if(masGoles.getGolesMarcados()>mayor){
                respuesta = masGoles.getNombre()+" "+masGoles.getApellido()+"-"+masGoles.getCedula();
                mayor = masGoles.getGolesMarcados();
            }            
        }
        this.txtRespuestaJugadorMasGoles.setText(respuesta);
    }//GEN-LAST:event_btnObtenerJugadorMasGolesActionPerformed

    private void btnObtenerEquipoNominaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObtenerEquipoNominaActionPerformed
        LinkedList<Object> recorrido = this.miControladorEquipo.index();
        double mayor = Integer.MIN_VALUE;
        String respuesta = "";
        for(Object actual:recorrido){
            Equipo equipoActual = (Equipo)actual;
            String idActual = equipoActual.getId();
            double nominaActual = this.miControladorEquipo.getNomina(idActual);
            if(nominaActual>mayor){
                respuesta = equipoActual.getId()+"-"+equipoActual.getNombre();
                mayor = nominaActual;
            }            
        }
        this.txtRespuestaNominaMasAlta.setText(respuesta);
    }//GEN-LAST:event_btnObtenerEquipoNominaActionPerformed

    private void btnObtenerEquipoAficionadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObtenerEquipoAficionadosActionPerformed
        LinkedList<Object> recorrido = this.miControladorEquipo.index();
        int mayor = Integer.MIN_VALUE;
        String respuesta = "";
        for(Object actual:recorrido){
            Equipo equipoActual = (Equipo)actual;
            String idActual = equipoActual.getId();
            int numeroAficionados = this.miControladorEquipo.getNumeroAficionados(idActual);
            if(numeroAficionados>mayor){
                respuesta = equipoActual.getId()+"-"+equipoActual.getNombre();
                mayor = numeroAficionados;
            }            
        }
        this.txtRespuestaEquipoAficionados.setText(respuesta);
    }//GEN-LAST:event_btnObtenerEquipoAficionadosActionPerformed

    private void btnObtenerPartidoGolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObtenerPartidoGolesActionPerformed
        LinkedList<Object> recorrido = this.miControladorPartido.index();
        int mayor = Integer.MIN_VALUE;
        String respuesta = "";
        for(Object actual:recorrido){
            Partido partidoActual = (Partido)actual;
            String idActual = partidoActual.getId();
            int goles = this.miControladorPartido.getGoles(idActual);
            if(goles>mayor){
                respuesta = idActual+"-"+((Equipo)this.miControladorEquipo.get(partidoActual.getEquipoLocal().getId())).getNombre()+"-"+((Equipo)this.miControladorEquipo.get(partidoActual.getEquipoVisitante().getId())).getNombre();
                mayor = goles;
            }            
        }
        this.txtRespuestaPartidoGoles.setText(respuesta);
    }//GEN-LAST:event_btnObtenerPartidoGolesActionPerformed

    private void btnArqueroGolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArqueroGolesActionPerformed
        LinkedList<Object> recorrido = this.miControladorEquipo.index();
        int menor = Integer.MAX_VALUE;
        String respuesta = "";
        for(Object actual:recorrido){
            Equipo equipoActual = (Equipo)actual;
            String idActual = equipoActual.getId();
            Jugador arquero = this.miControladorEquipo.getArquero(idActual);
            if(equipoActual.getGolesEnContra()<menor){
                respuesta = arquero.getNombre()+" "+arquero.getApellido()+"-"+arquero.getCedula();
                menor = equipoActual.getGolesEnContra();
            }            
        }
        this.txtRespuestaArqueroGoles.setText(respuesta);
    }//GEN-LAST:event_btnArqueroGolesActionPerformed
//Cantidad de goles que marcó el equipo con más puntos
    private void btnObtenerEstadioGolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObtenerEstadioGolesActionPerformed
        int mayor = Integer.MIN_VALUE;
        String respuesta = "";
        LinkedList<Object> recorrido = this.miControladorEstadio.index();
        
        for(Object estadio: recorrido){
            Estadio estadioActual = (Estadio)estadio;
            String idEstadio = estadioActual.getId();
            int goles = this.miControladorEstadio.getGolesTotales(idEstadio);
            if(goles>mayor){
                respuesta = estadioActual.getId()+"-"+estadioActual.getNombre();
                mayor = goles;
            }
        }
        this.txtRespuestaEstadioGoles.setText(respuesta);
    }//GEN-LAST:event_btnObtenerEstadioGolesActionPerformed

    private void btnObtenerGolesEquipoMasPuntosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObtenerGolesEquipoMasPuntosActionPerformed
        int respuesta = this.miControladorEquipo.GolesEquipoMasPuntos();
        this.txtRespuestaGolesEquipoMasPuntos.setText(""+respuesta);
    }//GEN-LAST:event_btnObtenerGolesEquipoMasPuntosActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Liga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Liga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Liga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Liga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Liga().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarEquipo;
    private javax.swing.JButton btnActualizarEstadio;
    private javax.swing.JButton btnActualizarJornada;
    private javax.swing.JButton btnActualizarPartido;
    private javax.swing.JButton btnActualizarPersona;
    private javax.swing.JButton btnAgregarEquipoPersona;
    private javax.swing.JButton btnAgregarManagerJugador;
    private javax.swing.JButton btnArqueroGoles;
    private javax.swing.JButton btnAsignarGolesJugador;
    private javax.swing.JButton btnBuscarEquipo;
    private javax.swing.JButton btnBuscarEstadio;
    private javax.swing.JButton btnBuscarJornada;
    private javax.swing.JButton btnBuscarPartido;
    private javax.swing.JButton btnBuscarPersona;
    private javax.swing.JButton btnCantidadPartidosGoleada;
    private javax.swing.JButton btnCrearEquipo;
    private javax.swing.JButton btnCrearEstadio;
    private javax.swing.JButton btnCrearJornada;
    private javax.swing.JButton btnCrearPartido;
    private javax.swing.JButton btnCrearPersona;
    private javax.swing.JButton btnEliminarEquipo;
    private javax.swing.JButton btnEliminarEstadio;
    private javax.swing.JButton btnEliminarJornada;
    private javax.swing.JButton btnEliminarManagerJugador;
    private javax.swing.JButton btnEliminarPartido;
    private javax.swing.JButton btnEliminarPersona;
    private javax.swing.JButton btnJugadorMasJoven;
    private javax.swing.JButton btnListarPartidosEstadio;
    private javax.swing.JButton btnListarRelacionesEquipo;
    private javax.swing.JButton btnListarRelacionesJornada;
    private javax.swing.JButton btnListarRelacionesManager;
    private javax.swing.JButton btnObtenerEquipoAficionados;
    private javax.swing.JButton btnObtenerEquipoNomina;
    private javax.swing.JButton btnObtenerEstadioGoles;
    private javax.swing.JButton btnObtenerGolesEquipoMasPuntos;
    private javax.swing.JButton btnObtenerJugadorMasGoles;
    private javax.swing.JButton btnObtenerPartidoGoles;
    private javax.swing.JButton btnPromedioEdadEquipo;
    private javax.swing.JComboBox<String> comboAbonadoAficionado;
    private javax.swing.JComboBox<String> comboEquipoListar;
    private javax.swing.JComboBox<String> comboEquipoLocal;
    private javax.swing.JComboBox<String> comboEquipoVisitante;
    private javax.swing.JComboBox<String> comboEquiposMetodo;
    private javax.swing.JComboBox<String> comboEquiposPersona;
    private javax.swing.JComboBox<String> comboEstadioPartido;
    private javax.swing.JComboBox<String> comboEstadiosListar;
    private javax.swing.JComboBox<String> comboFIFAarbitro;
    private javax.swing.JComboBox<String> comboJornadaListar;
    private javax.swing.JComboBox<String> comboJornadaPartido;
    private javax.swing.JComboBox<String> comboJugadorGoles;
    private javax.swing.JComboBox<String> comboManagerJugador;
    private javax.swing.JComboBox<String> comboManagersListar;
    private javax.swing.JComboBox<String> comboPersona;
    private javax.swing.JComboBox<String> comboÁrbitroPartido;
    private javax.swing.JButton eliminarEquipoPersona;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane8;
    private javax.swing.JLabel labelJugadoresEquipo;
    private javax.swing.JLabel labelListarEquipo;
    private javax.swing.JSpinner spinGolesJugador;
    private javax.swing.JTable tablaAficionados;
    private javax.swing.JTable tablaAficionadosEquipo;
    private javax.swing.JTable tablaArbitros;
    private javax.swing.JTable tablaEquipos;
    private javax.swing.JTable tablaEstadios;
    private javax.swing.JTable tablaJornadas;
    private javax.swing.JTable tablaJugadores;
    private javax.swing.JTable tablaJugadoresEquipo;
    private javax.swing.JTable tablaJugadoresManager;
    private javax.swing.JTable tablaManagers;
    private javax.swing.JTable tablaPartidos;
    private javax.swing.JTable tablaPartidosEquipo;
    private javax.swing.JTable tablaPartidosEstadio;
    private javax.swing.JTable tablaPartidosJornada;
    private javax.swing.JTable tablaPosicionesLiga;
    private javax.swing.JTable tablaTecnicos;
    private javax.swing.JTextField txtApellidoPersona;
    private javax.swing.JTextField txtAñoFundacionEquipo;
    private javax.swing.JTextField txtAñosAfiliacionManager;
    private javax.swing.JTextField txtAñosExpTecnico;
    private javax.swing.JTextField txtAñosFidelidadAficionado;
    private javax.swing.JTextField txtCapacidadEstadio;
    private javax.swing.JTextField txtCedulaPersona;
    private javax.swing.JTextField txtCiudadEstadio;
    private javax.swing.JTextField txtEdadPersona;
    private javax.swing.JTextField txtEsloganFIFAJornada;
    private javax.swing.JTextField txtFechaPartido;
    private javax.swing.JTextField txtGolesContraEquipo;
    private javax.swing.JTextField txtGolesEquipoLocal;
    private javax.swing.JTextField txtGolesEquipoVisitante;
    private javax.swing.JTextField txtGolesFavorEquipo;
    private javax.swing.JTextField txtGolesJugador;
    private javax.swing.JTextField txtIdEquipo;
    private javax.swing.JTextField txtIdEstadio;
    private javax.swing.JTextField txtNacionalidadJugador;
    private javax.swing.JTextField txtNombreEquipo;
    private javax.swing.JTextField txtNombreEstadio;
    private javax.swing.JTextField txtNombrePersona;
    private javax.swing.JTextField txtNumeroJornada;
    private javax.swing.JTextField txtPartidosJugadosEquipo;
    private javax.swing.JTextField txtPosicionJugador;
    private javax.swing.JTextField txtPuntosEquipo;
    private javax.swing.JTextField txtRespuestaArqueroGoles;
    private javax.swing.JTextField txtRespuestaEquipoAficionados;
    private javax.swing.JTextField txtRespuestaEstadioGoles;
    private javax.swing.JTextField txtRespuestaGolesEquipoMasPuntos;
    private javax.swing.JTextField txtRespuestaJugadorMasGoles;
    private javax.swing.JTextField txtRespuestaMasJoven;
    private javax.swing.JTextField txtRespuestaNominaMasAlta;
    private javax.swing.JTextField txtRespuestaPartidoGoles;
    private javax.swing.JTextField txtRespuestaPartidosGoleada;
    private javax.swing.JTextField txtRespuestaPromedioEdad;
    private javax.swing.JTextField txtSalarioTecnicoyJugador;
    private javax.swing.JTextField txtTitulosInternacionalesEquipo;
    private javax.swing.JTextField txtTitulosNacionalesEquipo;
    private javax.swing.JTextField txtidJornada;
    private javax.swing.JTextField txtidPartido;
    // End of variables declaration//GEN-END:variables
}
