/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores_Vista;

import Clases_Modulo_Transporte.Barrio;
import Clases_Modulo_Transporte.Departamento;
import Clases_Modulo_Transporte.Especialidad;
import Clases_Modulo_Transporte.Localidad;
import Clases_Modulo_Transporte.Provincia;
import Clases_Modulo_Transporte.TipoTelefono;
import Hibernate.GestorHibernate;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;

public class gestorRegistroLaboratorio extends GestorHibernate {
   
    public DefaultComboBoxModel rellenaComboTipoProvincia(){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(Provincia.class).iterator();
       while(ite.hasNext()){
           Provincia provincia =(Provincia) ite.next();
           modelo.addElement(provincia);
           }

       return modelo;
   } 
    
   public DefaultComboBoxModel rellenaComboDepartamento(String seleccion){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(Departamento.class).iterator();
       while(ite.hasNext()){
           Departamento departamento =(Departamento) ite.next();
           Provincia provincia = departamento.getProvincia();
           if (provincia.getNombreProvincia().equals(seleccion)){
               modelo.addElement(departamento);
           }
       }

       return modelo;
   }
   
   public DefaultComboBoxModel rellenaComboLocalidad(String seleccion){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(Localidad.class).iterator();
       while(ite.hasNext()){
           Localidad localidad =(Localidad) ite.next();
           Departamento departamento = localidad.getDepartamento();
           if (departamento.getNombreDepartamento().equals(seleccion)){
               modelo.addElement(localidad);
           }
       }

       return modelo;
   }
   
   public DefaultComboBoxModel rellenaComboBarrio(String seleccion){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(Barrio.class).iterator();
       while(ite.hasNext()){
           Barrio barrio =(Barrio) ite.next();
           Localidad localidad = barrio.getLocalidad();
           if (localidad.getNombreLocalidad().equals(seleccion)){
               modelo.addElement(barrio);
           }
       }

       return modelo;
   }
   
   public DefaultComboBoxModel rellenaComboEspecialidad(){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(Especialidad.class).iterator();
       while(ite.hasNext()){
           Especialidad especialidad =(Especialidad) ite.next();
           modelo.addElement(especialidad);
       }
       return modelo;
   }
   
    public DefaultComboBoxModel rellenaComboTipoTelefono(){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(TipoTelefono.class).iterator();
       while(ite.hasNext()){
           TipoTelefono tipoTel =(TipoTelefono) ite.next();
               modelo.addElement(tipoTel);
           }

       return modelo;
   }
   
   
   
   
}
