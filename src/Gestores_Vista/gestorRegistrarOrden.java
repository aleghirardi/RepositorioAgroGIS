/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Gestores_Vista;

import Clases_Modulo_Carga.Establecimiento;
import Clases_Modulo_Transporte.*;
import Hibernate.GestorHibernate;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alejandra
 */
public class gestorRegistrarOrden extends GestorHibernate{

      public JTable rellenaTablaVehiculo(JTable tabla){
       DefaultTableModel modeloT = (DefaultTableModel) tabla.getModel();
       Iterator ite = this.listarClase(Vehiculo.class).iterator();
       while(ite.hasNext()){
           Vehiculo vehiculo =(Vehiculo) ite.next();
           Transportista transportista = vehiculo.getTransportista();
           Object fila[]= {vehiculo.getDominio(), vehiculo.getTransportista()};
           modeloT.addRow(fila);
       }
       tabla.setModel(modeloT);
       return tabla;
   }

      public String rellenaTxtProveedor(String seleccion){
       String texto = null;
       Iterator ite = this.listarClase(EstacionDeServicio.class).iterator();
       while(ite.hasNext()){
           EstacionDeServicio estacion =(EstacionDeServicio) ite.next();
           ProveedorCombustible proveedor = estacion.getProveedor();
           if (estacion.getRazonSocial().equals(seleccion)){
              texto = proveedor.getNombreProveedor();
           }
       }
       return texto;
   }

      public String rellenaTxtDomicilio(String seleccion){
       String texto = null;
       Iterator ite = this.listarClase(EstacionDeServicio.class).iterator();
       while(ite.hasNext()){
           EstacionDeServicio estacion =(EstacionDeServicio) ite.next();
           Domicilio domicilio = estacion.getDomicilio();
           if (estacion.getRazonSocial().equals(seleccion)){
              texto= domicilio.getBarrio().toString();
           }
       }
       return texto;
   }
      public String rellenaTxtLocalidad(String seleccion){
       String texto = null;
       Iterator ite = this.listarClase(EstacionDeServicio.class).iterator();
       while(ite.hasNext()){
           EstacionDeServicio estacion =(EstacionDeServicio) ite.next();
           Domicilio domicilio = estacion.getDomicilio();
           Barrio barrio = domicilio.getBarrio();
           Localidad localidad = barrio.getLocalidad();
           if (estacion.getRazonSocial().equals(seleccion)){
              texto = localidad.getNombreLocalidad();
           }
       }
       return texto;
   }

     public String rellenaTxtDepartamento(String seleccion){
       String texto = null;
       Iterator ite = this.listarClase(EstacionDeServicio.class).iterator();
       while(ite.hasNext()){
           EstacionDeServicio estacion =(EstacionDeServicio) ite.next();
           Domicilio domicilio = estacion.getDomicilio();
           Barrio barrio = domicilio.getBarrio();
           Localidad localidad = barrio.getLocalidad();
           Departamento departamento = localidad.getDepartamento();
           if (estacion.getRazonSocial().equals(seleccion)){
              texto= departamento.getNombreDepartamento();
           }
       }
       return texto;
   }
     public String rellenaTxtProvincia(String seleccion){
       String texto = null;
       Iterator ite = this.listarClase(EstacionDeServicio.class).iterator();
       while(ite.hasNext()){
           EstacionDeServicio estacion =(EstacionDeServicio) ite.next();
           Domicilio domicilio = estacion.getDomicilio();
           Barrio barrio = domicilio.getBarrio();
           Localidad localidad = barrio.getLocalidad();
           Departamento departamento = localidad.getDepartamento();
           Provincia provincia = departamento.getProvincia();
           if (estacion.getRazonSocial().equals(seleccion)){
              texto= provincia.getNombreProvincia();
           }
       }
       return texto;
   }
     
  public DefaultComboBoxModel rellenaComboEstacion(){
    DefaultComboBoxModel modelo = new DefaultComboBoxModel();
    Iterator ite = this.listarClase(EstacionDeServicio.class).iterator();
       while(ite.hasNext()){
           EstacionDeServicio estacion =(EstacionDeServicio) ite.next();  
           modelo.addElement(estacion);
           }
        return modelo;
   }
 
 public DefaultComboBoxModel rellenaComboTipoServicio(){
    DefaultComboBoxModel modelo = new DefaultComboBoxModel();
    Iterator ite = this.listarClase(TipoServicio.class).iterator();
       while(ite.hasNext()){
           TipoServicio tipo =(TipoServicio) ite.next();  
           modelo.addElement(tipo);
           }
        return modelo;
   }




}
