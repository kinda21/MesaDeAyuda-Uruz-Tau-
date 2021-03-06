package Main.ABMSector;

import Entidades.*;
import Main.DTOCriterio;
import Main.DTOSector;
import Main.FachadaPersistencia;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author FLIA HUDSON
 */
public class ExpertoABMSector {
    public ExpertoABMSector() {
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
     public List<DTOSector> buscarSectores(String filNombreSector, String filCodSector){
        FachadaPersistencia.getInstance().iniciarTransaccion();
        List<DTOCriterio> criterioList = new ArrayList<>();
        List<DTOSector> listaSectores = new ArrayList<>();
        //si vienen vacios busco todos los sectores
        if ("".equals(filNombreSector) && "".equals(filCodSector)) {
            List objetoList = FachadaPersistencia.getInstance().buscar("Sector", null);
            for (Object x : objetoList) {
            Sector sectorleido = (Sector) x;
            DTOSector sector = new DTOSector();
            sector.setCodSector(sectorleido.getCodSector());
            sector.setDescripcionSector(sectorleido.getDescripcionSector());
            sector.setFechaHoraFinVigenciaSector(sectorleido.getFechaHoraFinVigenciaSector());
            sector.setNombreSector(sectorleido.getNombreSector());
            listaSectores.add(sector);
            }
        }
        //si filCodSector viene vacío y filNombreSector no, busco sector por nombre
        if ("".equals(filCodSector) && !"".equals(filNombreSector)){
            DTOCriterio dto = new DTOCriterio();
            dto.setAtributo("nombreSector");
            dto.setOperacion("like");
            dto.setValor(filNombreSector);
            criterioList.add(dto);
            List objetoList = FachadaPersistencia.getInstance().buscar("Sector", criterioList);
            for (Object x : objetoList) {
                Sector sectorleido = (Sector) x;
                DTOSector sector = new DTOSector();
                sector.setCodSector(sectorleido.getCodSector());
                sector.setDescripcionSector(sectorleido.getDescripcionSector());
                sector.setFechaHoraFinVigenciaSector(sectorleido.getFechaHoraFinVigenciaSector());
                sector.setNombreSector(sectorleido.getNombreSector());
                listaSectores.add(sector);
            }
        }
        //si filCodSector no viene vacío y filNomSector viene vacío busco por codigo sector
        if (!"".equals(filCodSector) && "".equals(filNombreSector)){
            DTOCriterio dto = new DTOCriterio();
            dto.setAtributo("codSector");
            dto.setOperacion("=");
            dto.setValor(Integer.parseInt(filCodSector));
            criterioList.add(dto);
            List objetoList = FachadaPersistencia.getInstance().buscar("Sector", criterioList);
            for (Object x : objetoList) {
                Sector sectorleido = (Sector) x;
                DTOSector sector = new DTOSector();
                sector.setCodSector(sectorleido.getCodSector());
                sector.setDescripcionSector(sectorleido.getDescripcionSector());
                sector.setFechaHoraFinVigenciaSector(sectorleido.getFechaHoraFinVigenciaSector());
                sector.setNombreSector(sectorleido.getNombreSector());
            listaSectores.add(sector);
            }
        }
        //si ninguno viene vacío, busco todos los que tengan el nombre y tengan el codigo enviado
        if (!"".equals(filCodSector) && !"".equals(filNombreSector)) {
            DTOCriterio dto = new DTOCriterio();
            dto.setAtributo("nombreSector");
            dto.setOperacion("like");
            dto.setValor(filNombreSector);
            criterioList.add(dto);
            DTOCriterio dto2 = new DTOCriterio();
            dto2.setAtributo("codSector");
            dto2.setOperacion("=");
            dto2.setValor(Integer.parseInt(filCodSector));      
            criterioList.add(dto2);
            List objetoList = FachadaPersistencia.getInstance().buscar("Sector", criterioList);
            for (Object x : objetoList) {
                Sector sectorleido = (Sector) x;
                //if (sectorleido.getCodSector()>=Integer.parseInt(filCodSector)) {
                    DTOSector sector = new DTOSector();
                    sector.setCodSector(sectorleido.getCodSector());
                    sector.setDescripcionSector(sectorleido.getDescripcionSector());
                    sector.setFechaHoraFinVigenciaSector(sectorleido.getFechaHoraFinVigenciaSector());
                    sector.setNombreSector(sectorleido.getNombreSector());
                    listaSectores.add(sector);
                //} 
            }
        }
        FachadaPersistencia.getInstance().finalizarTransaccion();
        return listaSectores; 
    }    
    public List<DTOSector> buscarSectores(){  
        FachadaPersistencia.getInstance().iniciarTransaccion();
        List objetoList = FachadaPersistencia.getInstance().buscar("Sector", null);
        List<DTOSector> listaSectores = new ArrayList<>();
        for (Object x : objetoList) {
            Sector sectorleido = (Sector) x;
            DTOSector sector = new DTOSector();
            sector.setCodSector(sectorleido.getCodSector());
            sector.setDescripcionSector(sectorleido.getDescripcionSector());
            sector.setFechaHoraFinVigenciaSector(sectorleido.getFechaHoraFinVigenciaSector());
            sector.setNombreSector(sectorleido.getNombreSector());
            //System.out.println(sector.getCodSector());
            //System.out.println(sector.getDescripcionSector());
            //System.out.println(sector.getFechaHoraFinVigenciaSector());
            //System.out.println(sector.getNombreSector());
            listaSectores.add(sector);
        }
        FachadaPersistencia.getInstance().finalizarTransaccion();
        return listaSectores;
    }
    public List<DTOSector> buscarSectoresVigentes(){  
        FachadaPersistencia.getInstance().iniciarTransaccion();
        List<DTOCriterio> criterioList = new ArrayList<>();
        List<DTOSector> listaSectores = new ArrayList<>();
        DTOCriterio dto = new DTOCriterio();
        dto.setAtributo("fechaHoraFinVigenciaSector");
        dto.setOperacion("=");
        dto.setValor(null);
        criterioList.add(dto);
        List objetoList = FachadaPersistencia.getInstance().buscar("Sector", criterioList);
        for (Object x : objetoList) {
            Sector sectorleido = (Sector) x;
            DTOSector sector = new DTOSector();
            sector.setCodSector(sectorleido.getCodSector());
            sector.setDescripcionSector(sectorleido.getDescripcionSector());
            sector.setFechaHoraFinVigenciaSector(sectorleido.getFechaHoraFinVigenciaSector());
            sector.setNombreSector(sectorleido.getNombreSector());
            //System.out.println(sector.getCodSector());
            //System.out.println(sector.getDescripcionSector());
            //System.out.println(sector.getFechaHoraFinVigenciaSector());
            //System.out.println(sector.getNombreSector());
            listaSectores.add(sector);
            }
        FachadaPersistencia.getInstance().finalizarTransaccion();
        return listaSectores;
        }
    public List<DTOSector> buscarSectores(String filNombreSector){
        FachadaPersistencia.getInstance().iniciarTransaccion();
        List<DTOCriterio> criterioList = new ArrayList<>();
        List<DTOSector> listaSectores = new ArrayList<>();
        DTOCriterio dto = new DTOCriterio();
        dto.setAtributo("nombreSector");
        dto.setOperacion("like");
        dto.setValor(filNombreSector);
        criterioList.add(dto);
        List objetoList = FachadaPersistencia.getInstance().buscar("Sector", criterioList);
        for (Object x : objetoList) {
            Sector sectorleido = (Sector) x;
            DTOSector sector = new DTOSector();
            sector.setCodSector(sectorleido.getCodSector());
            sector.setDescripcionSector(sectorleido.getDescripcionSector());
            sector.setFechaHoraFinVigenciaSector(sectorleido.getFechaHoraFinVigenciaSector());
            sector.setNombreSector(sectorleido.getNombreSector());
            listaSectores.add(sector);
            }
        FachadaPersistencia.getInstance().finalizarTransaccion();
        return listaSectores;
    }
   
    public List<DTOSector> buscarSectores(int filcodSector){
        FachadaPersistencia.getInstance().iniciarTransaccion();
        List<DTOCriterio> criterioList = new ArrayList<>();
        List<DTOSector> listaSectores = new ArrayList<>();
        DTOCriterio dto = new DTOCriterio();
        dto.setAtributo("codSector");
        dto.setOperacion("=");
        dto.setValor(filcodSector);
        criterioList.add(dto);
        List objetoList = FachadaPersistencia.getInstance().buscar("Sector", criterioList);
        for (Object x : objetoList) {
            Sector sectorleido = (Sector) x;
            DTOSector sector = new DTOSector();
            sector.setCodSector(sectorleido.getCodSector());
            sector.setDescripcionSector(sectorleido.getDescripcionSector());
            sector.setFechaHoraFinVigenciaSector(sectorleido.getFechaHoraFinVigenciaSector());
            sector.setNombreSector(sectorleido.getNombreSector());
            listaSectores.add(sector);
            }
        FachadaPersistencia.getInstance().finalizarTransaccion();
        return listaSectores;
    }
    public boolean daraltaSector(int codSector, String nomSector, String descSector) {
        FachadaPersistencia.getInstance().iniciarTransaccion();
        Sector nuevoSector = new Sector();
        try {
        nuevoSector.setCodSector(codSector);
        nuevoSector.setDescripcionSector(descSector);
        nuevoSector.setFechaHoraFinVigenciaSector(null);
        nuevoSector.setNombreSector(nomSector);
        List objetoList = FachadaPersistencia.getInstance().buscar("Sector", null);
        if(nuevoSector.getDescripcionSector().equals("")){
            JOptionPane.showMessageDialog(null, "La descripción ingresada es incorrecta, valor nulo no aceptado.");
            return false;
        }else if(nuevoSector.getNombreSector().equals("")){
            JOptionPane.showMessageDialog(null, "El nombre ingresado es incorrecto, valor nulo no aceptado.");
            return false;
        }else if(nuevoSector.getCodSector()== 0){
            JOptionPane.showMessageDialog(null, "El codigo ingresado es incorrecto, valor nulo no aceptado.");
                    return false;
        }else if(nuevoSector.getCodSector()< 0){
                JOptionPane.showMessageDialog(null, "El codigo ingresado es incorrecto, valor negativo no aceptado.");
                return false;
        }else
            for (Object x : objetoList) {
                Sector sectoraverificar = (Sector) x;
                if(nuevoSector.getCodSector() == sectoraverificar.getCodSector()){
                    JOptionPane.showMessageDialog(null, "El codigo ingresado no es valido, ya existe un Sector con ese código.");
                    return false;
                }  
            }
        }
        catch(Exception e){
            
            JOptionPane.showMessageDialog(null, "Error al crear el Sector");
            return false;
            }
        FachadaPersistencia.getInstance().guardar(nuevoSector);
        FachadaPersistencia.getInstance().finalizarTransaccion();
        return true;
        }
    public boolean darbajaSector(int codSector) {
        FachadaPersistencia.getInstance().iniciarTransaccion();
        List<DTOCriterio> criterioList = new ArrayList<>();
        DTOCriterio dto = new DTOCriterio();
        dto.setAtributo("codSector");
        dto.setOperacion("=");
        dto.setValor(codSector);
        criterioList.add(dto);
        List objetoList = FachadaPersistencia.getInstance().buscar("Sector", criterioList);
        Sector sectordebaja = (Sector)objetoList.get(0);
        if (sectordebaja.getFechaHoraFinVigenciaSector() != null){
            JOptionPane.showMessageDialog(null, "El Sector elegido ya se encuentra dado de baja");
            return false;
        }
        Date fechadehoy = new Date();
        sectordebaja.setFechaHoraFinVigenciaSector(fechadehoy);
        FachadaPersistencia.getInstance().guardar(sectordebaja);
        FachadaPersistencia.getInstance().finalizarTransaccion();
        return true;
        }
    public boolean modificarSector (int codSector, String nomSector, String descSector){
        FachadaPersistencia.getInstance().iniciarTransaccion();
        List<DTOCriterio> criterioList = new ArrayList<>();
        DTOCriterio dto = new DTOCriterio();
        dto.setAtributo("codSector");
        dto.setOperacion("=");
        dto.setValor(codSector);
        criterioList.add(dto);
        List objetoList = FachadaPersistencia.getInstance().buscar("Sector", criterioList);
        Sector sectoramodif = (Sector)objetoList.get(0);
        sectoramodif.setNombreSector(nomSector);
        sectoramodif.setDescripcionSector(descSector);
        if(sectoramodif.getDescripcionSector().equals("")){
            JOptionPane.showMessageDialog(null, "La descripción ingresada es incorrecta, valor nulo no aceptado.");
            return false;
        }else if(sectoramodif.getNombreSector().equals("")){
            JOptionPane.showMessageDialog(null, "El nombre ingresado es incorrecto, valor nulo no aceptado.");
            return false;
        }else if (sectoramodif.getFechaHoraFinVigenciaSector() != null){
            JOptionPane.showMessageDialog(null,"No se puede modificar un Sector dado de baja" );
            return false;
        }
        FachadaPersistencia.getInstance().guardar(sectoramodif);
        FachadaPersistencia.getInstance().finalizarTransaccion();
        return true;
        }
    }
    


    

