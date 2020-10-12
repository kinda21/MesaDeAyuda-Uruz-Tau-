package Main;

import Entidades.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author FLIA HUDSON
 */
public class ExpertoABMTipoTarea {
    public ExpertoABMTipoTarea() {
    //    PRUEBAS DE LOS MÉTODOS.
    //    FachadaPersistencia.getInstance().iniciarTransaccion();
    //    DTOSector prueba = new DTOSector();
    //    prueba.setCodSector(333);
    //    prueba.setDescripcionSector("probando ABM");
    //    prueba.setFechaHoraFinVigenciaSector(null);
    //    prueba.setNombreSector("prueba sin pantalla");
    //    daraltaSector(prueba);
    //    darbajaSector(333);
    //    modificarSector(333,"prueba superada","ya lo probe");
    }
    public List<DTOTipoTarea> buscarTiposTarea(String filNombreTT, String filCodTT){
        FachadaPersistencia.getInstance().iniciarTransaccion();
        List<DTOCriterio> criterioList = new ArrayList<>();
        List<DTOTipoTarea> listaTipoTareas = new ArrayList<>();
        //si vienen vacios busco todos los tipos tarea
        if ("".equals(filNombreTT) && "".equals(filCodTT)) {
            List objetoList = FachadaPersistencia.getInstance().buscar("TipoTarea", null);
            for (Object x : objetoList) {
            TipoTarea tipoTarealeido = (TipoTarea) x;
            DTOTipoTarea tipoTarea = new DTOTipoTarea();
            tipoTarea.setCodTipoTarea(tipoTarealeido.getCodTipoTarea());
            tipoTarea.setDescripcionTipoTarea(tipoTarealeido.getDescripcionTipoTarea());
            tipoTarea.setFechaFinVigenciaTipoTarea(tipoTarealeido.getFechaFinVigenciaTipoTarea());
            tipoTarea.setNombreTipoTarea(tipoTarealeido.getNombreTipoTarea());
            listaTipoTareas.add(tipoTarea);
            }
        }
        //si filNombreTT viene vacío y filNombreTT no, busco TipoTarea por nombre
        if ("".equals(filCodTT) && !"".equals(filNombreTT)){
            DTOCriterio dto = new DTOCriterio();
            dto.setAtributo("nombreTipoTarea");
            dto.setOperacion("like");
            dto.setValor(filNombreTT);
            criterioList.add(dto);
            List objetoList = FachadaPersistencia.getInstance().buscar("TipoTarea", criterioList);
            for (Object x : objetoList) {
                TipoTarea tipoTarealeido = (TipoTarea) x;
                DTOTipoTarea tipoTarea = new DTOTipoTarea();
                tipoTarea.setCodTipoTarea(tipoTarealeido.getCodTipoTarea());
                tipoTarea.setDescripcionTipoTarea(tipoTarealeido.getDescripcionTipoTarea());
                tipoTarea.setFechaFinVigenciaTipoTarea(tipoTarealeido.getFechaFinVigenciaTipoTarea());
                tipoTarea.setNombreTipoTarea(tipoTarealeido.getNombreTipoTarea());
                listaTipoTareas.add(tipoTarea);
            }
        }
        //si filcodTT no viene vacío y filNombreTT viene vacío busco por codigo TipoTarea
        if (!"".equals(filCodTT) && "".equals(filNombreTT)){
            DTOCriterio dto = new DTOCriterio();
            dto.setAtributo("codTipoTarea");
            dto.setOperacion("=");
            dto.setValor(Integer.parseInt(filCodTT));
            criterioList.add(dto);
            List objetoList = FachadaPersistencia.getInstance().buscar("TipoTarea", criterioList);
            for (Object x : objetoList) {
                TipoTarea tipoTarealeido = (TipoTarea) x;
                DTOTipoTarea tipoTarea = new DTOTipoTarea();
                tipoTarea.setCodTipoTarea(tipoTarealeido.getCodTipoTarea());
                tipoTarea.setDescripcionTipoTarea(tipoTarealeido.getDescripcionTipoTarea());
                tipoTarea.setFechaFinVigenciaTipoTarea(tipoTarealeido.getFechaFinVigenciaTipoTarea());
                tipoTarea.setNombreTipoTarea(tipoTarealeido.getNombreTipoTarea());
                listaTipoTareas.add(tipoTarea);
            }
        }
        //si ninguno viene vacío, busco todos los que tengan el nombre y sean mayores? al codigo enviado
        if (!"".equals(filCodTT) && !"".equals(filNombreTT)) {
            DTOCriterio dto = new DTOCriterio();
            dto.setAtributo("nombreTipoTarea");
            dto.setOperacion("like");
            dto.setValor(filNombreTT);
            criterioList.add(dto);
            DTOCriterio dto2 = new DTOCriterio();
            dto2.setAtributo("codTipoTarea");
            dto2.setOperacion(">=");
            dto2.setValor(Integer.parseInt(filCodTT));      
            criterioList.add(dto2);
            // List objetoList = FachadaPersistencia.getInstance().buscar("TipoTarea", criterioList);
            List objetoList = FachadaPersistencia.getInstance().buscar("TipoTarea", criterioList);
            for (Object x : objetoList) {
                TipoTarea tipoTarealeido = (TipoTarea) x;
                DTOTipoTarea tipoTarea = new DTOTipoTarea();
                tipoTarea.setCodTipoTarea(tipoTarealeido.getCodTipoTarea());
                tipoTarea.setDescripcionTipoTarea(tipoTarealeido.getDescripcionTipoTarea());
                tipoTarea.setFechaFinVigenciaTipoTarea(tipoTarealeido.getFechaFinVigenciaTipoTarea());
                tipoTarea.setNombreTipoTarea(tipoTarealeido.getNombreTipoTarea());
                listaTipoTareas.add(tipoTarea);
            }
        }   
        return listaTipoTareas; 
    }    
    
    public List<DTOTipoTarea> buscarTiposTarea(){ 
        FachadaPersistencia.getInstance().iniciarTransaccion();
        List objetoList = FachadaPersistencia.getInstance().buscar("TipoTarea", null);
        List<DTOTipoTarea> listaTiposTarea = new ArrayList<>();
        for (Object x : objetoList) {
            TipoTarea tipotarealeida = (TipoTarea) x;
            DTOTipoTarea tipotarea = new DTOTipoTarea();
            tipotarea.setCodTipoTarea(tipotarealeida.getCodTipoTarea());
            tipotarea.setDescripcionTipoTarea(tipotarealeida.getDescripcionTipoTarea());
            tipotarea.setFechaFinVigenciaTipoTarea(tipotarealeida.getFechaFinVigenciaTipoTarea());
            tipotarea.setNombreTipoTarea(tipotarealeida.getNombreTipoTarea());
            //System.out.println(sector.getCodSector());
            //System.out.println(sector.getDescripcionSector());
            //System.out.println(sector.getFechaHoraFinVigenciaSector());
            //System.out.println(sector.getNombreSector());
            listaTiposTarea.add(tipotarea);
            }
        return listaTiposTarea;
        }
    public List<DTOTipoTarea> buscarTiposTareasVigentes(){  
        FachadaPersistencia.getInstance().iniciarTransaccion();
        List<DTOCriterio> criterioList = new ArrayList<>();
        List<DTOTipoTarea> listaTiposTarea = new ArrayList<>();
        DTOCriterio dto = new DTOCriterio();
        dto.setAtributo("fechaFinVigenciaTipoTarea");
        dto.setOperacion("=");
        dto.setValor(null);
        criterioList.add(dto);
        List objetoList = FachadaPersistencia.getInstance().buscar("TipoTarea", criterioList);
        for (Object x : objetoList) {
            TipoTarea tipotarealeida = (TipoTarea) x;
            DTOTipoTarea tipotarea = new DTOTipoTarea();
            tipotarea.setCodTipoTarea(tipotarealeida.getCodTipoTarea());
            tipotarea.setDescripcionTipoTarea(tipotarealeida.getDescripcionTipoTarea());
            tipotarea.setFechaFinVigenciaTipoTarea(tipotarealeida.getFechaFinVigenciaTipoTarea());
            tipotarea.setNombreTipoTarea(tipotarealeida.getNombreTipoTarea());
            listaTiposTarea.add(tipotarea);
            }
        //FachadaPersistencia.getInstance().finalizarTransaccion();
        return listaTiposTarea;
        }   
    
    public List<DTOTipoTarea> buscarTiposTarea(int filcodTipoTarea){
        FachadaPersistencia.getInstance().iniciarTransaccion();
        List<DTOCriterio> criterioList = new ArrayList<>();
        List<DTOTipoTarea> listaTipoTarea = new ArrayList<>();
        DTOCriterio dto = new DTOCriterio();
        dto.setAtributo("codTipoTarea");
        dto.setOperacion("=");
        dto.setValor(filcodTipoTarea);
        criterioList.add(dto);
        List objetoList = FachadaPersistencia.getInstance().buscar("TipoTarea", criterioList);
        for (Object x : objetoList) {
            TipoTarea TipoTarealeido = (TipoTarea) x;
            DTOTipoTarea unTipoTarea = new DTOTipoTarea();
            unTipoTarea.setCodTipoTarea(TipoTarealeido.getCodTipoTarea());
            unTipoTarea.setDescripcionTipoTarea(TipoTarealeido.getDescripcionTipoTarea());
            unTipoTarea.setFechaFinVigenciaTipoTarea(TipoTarealeido.getFechaFinVigenciaTipoTarea());
            unTipoTarea.setNombreTipoTarea(TipoTarealeido.getNombreTipoTarea());
            listaTipoTarea.add(unTipoTarea);
            }
        //FachadaPersistencia.getInstance().finalizarTransaccion();
        return listaTipoTarea;
    }
    public List<DTOTipoTarea> buscarTiposTarea(String filNombreTipoTarea){
        FachadaPersistencia.getInstance().iniciarTransaccion();
        List<DTOCriterio> criterioList = new ArrayList<>();
        List<DTOTipoTarea> listaTipoTarea = new ArrayList<>();
        DTOCriterio dto = new DTOCriterio();
        dto.setAtributo("nombreTipoTarea");
        dto.setOperacion("like");
        dto.setValor(filNombreTipoTarea);
        criterioList.add(dto);
        List objetoList = FachadaPersistencia.getInstance().buscar("TipoTarea", criterioList);
        for (Object x : objetoList) {
            TipoTarea tipotarealeido = (TipoTarea) x;
            DTOTipoTarea tipotarea = new DTOTipoTarea();
            tipotarea.setCodTipoTarea(tipotarealeido.getCodTipoTarea());
            tipotarea.setDescripcionTipoTarea(tipotarealeido.getDescripcionTipoTarea());
            tipotarea.setFechaFinVigenciaTipoTarea(tipotarealeido.getFechaFinVigenciaTipoTarea());
            tipotarea.setNombreTipoTarea(tipotarealeido.getNombreTipoTarea());
            listaTipoTarea.add(tipotarea);
            }
        //FachadaPersistencia.getInstance().finalizarTransaccion();
        return listaTipoTarea;
    }
    public boolean daraltaTipoTarea(DTOTipoTarea altaTipoTarea) {
        FachadaPersistencia.getInstance().iniciarTransaccion();
        TipoTarea nuevoTipoTarea = new TipoTarea();
        try {
        nuevoTipoTarea.setCodTipoTarea(altaTipoTarea.getCodTipoTarea());
        nuevoTipoTarea.setDescripcionTipoTarea(altaTipoTarea.getDescripcionTipoTarea());
        nuevoTipoTarea.setFechaFinVigenciaTipoTarea(null);
        nuevoTipoTarea.setNombreTipoTarea(altaTipoTarea.getNombreTipoTarea());
        List objetoList = FachadaPersistencia.getInstance().buscar("TipoTarea", null);
        List<DTOTipoTarea> listaTipoTarea = new ArrayList<>();
        if(nuevoTipoTarea.getCodTipoTarea()== 0){
            JOptionPane.showMessageDialog(null, "El codigo ingresado es incorrecto, valor nulo no aceptado.");
            return false;
        }else if(nuevoTipoTarea.getCodTipoTarea()< 0){
                JOptionPane.showMessageDialog(null, "El codigo ingresado es incorrecto, valor negativo no aceptado.");
                return false;
        }else
            for (Object x : objetoList) {
                TipoTarea TipoTareaaverificar = (TipoTarea) x;
                if(nuevoTipoTarea.getCodTipoTarea() == TipoTareaaverificar.getCodTipoTarea()){
                    JOptionPane.showMessageDialog(null, "El codigo ingresado no es valido, valor repetido.");
                    return false;
            }
        }
        }
        catch(Exception e){
            
            JOptionPane.showMessageDialog(null, "Error al crear el TipoTarea");
             }
        FachadaPersistencia.getInstance().guardar(nuevoTipoTarea);
        return true;
        //FachadaPersistencia.getInstance().finalizarTransaccion();
        }
    public boolean darbajaTipoTarea(int codTipoTarea) {
        FachadaPersistencia.getInstance().iniciarTransaccion();
        List<DTOCriterio> criterioList = new ArrayList<>();
        DTOCriterio dto = new DTOCriterio();
        dto.setAtributo("codTipoTarea");
        dto.setOperacion("=");
        dto.setValor(codTipoTarea);
        criterioList.add(dto);
        List objetoList = FachadaPersistencia.getInstance().buscar("TipoTarea", criterioList);
        TipoTarea TipoTareadebaja = (TipoTarea)objetoList.get(0);
        if (TipoTareadebaja.getFechaFinVigenciaTipoTarea() != null){
            JOptionPane.showMessageDialog(null, "El Sector elegido ya se encuentra dado de baja");
            return false;
        }
        Date fechadehoy = new Date();
        TipoTareadebaja.setFechaFinVigenciaTipoTarea(fechadehoy);
        FachadaPersistencia.getInstance().guardar(TipoTareadebaja);
        return true;
        //FachadaPersistencia.getInstance().finalizarTransaccion();
        }
    public boolean modificarTipoTarea (int codTipoTarea, String nomTipoTarea, String descTipoTarea) {
        FachadaPersistencia.getInstance().iniciarTransaccion();
        List<DTOCriterio> criterioList = new ArrayList<>();
        DTOCriterio dto = new DTOCriterio();
        dto.setAtributo("codTipoTarea");
        dto.setOperacion("=");
        dto.setValor(codTipoTarea);
        criterioList.add(dto);
        List objetoList = FachadaPersistencia.getInstance().buscar("TipoTarea", criterioList);
        TipoTarea TipoTareaamodif = (TipoTarea)objetoList.get(0);
        if (TipoTareaamodif.getFechaFinVigenciaTipoTarea() != null){
            JOptionPane.showMessageDialog(null,"No se puede modificar un TipoTarea dado de baja" );
            return false;                       
        }
        TipoTareaamodif.setNombreTipoTarea(nomTipoTarea);
        TipoTareaamodif.setDescripcionTipoTarea(descTipoTarea);
        FachadaPersistencia.getInstance().guardar(TipoTareaamodif);
        return true;
        //FachadaPersistencia.getInstance().finalizarTransaccion();
        }
    }
    


    

