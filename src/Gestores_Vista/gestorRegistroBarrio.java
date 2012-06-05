/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores_Vista;

import Clases_Modulo_Transporte.Departamento;
import Clases_Modulo_Transporte.Localidad;
import Clases_Modulo_Transporte.Pais;
import Clases_Modulo_Transporte.Provincia;
import Hibernate.GestorHibernate;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Charito
 */
public class gestorRegistroBarrio extends GestorHibernate {
    public DefaultComboBoxModel rellenaComboProvincia(String seleccion){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(Provincia.class).iterator();
       while(ite.hasNext()){
           Provincia provincia =(Provincia) ite.next();
           Pais pais = provincia.getPais();
           if (pais.getNombrePais().equals(seleccion)){
               modelo.addElement(provincia);
           }
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
}
