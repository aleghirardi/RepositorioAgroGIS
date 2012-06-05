/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Gestores_Vista;

import Clases_Modulo_Transporte.*;
import Hibernate.GestorHibernate;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Alejandra
 */
public class gestorRegistrarEstacionServicio extends GestorHibernate{

     public DefaultComboBoxModel rellenaCombo(){
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
    
    public DefaultComboBoxModel rellenaComboTipoTel(){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(TipoTelefono.class).iterator();
       while(ite.hasNext()){
           TipoTelefono tipoTel =(TipoTelefono) ite.next();
           modelo.addElement(tipoTel);
           }
       
      return modelo;
   }
    
    public DefaultComboBoxModel rellenaComboProveedor(){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(ProveedorCombustible.class).iterator();
       while(ite.hasNext()){
           ProveedorCombustible proveedor =(ProveedorCombustible) ite.next();
           modelo.addElement(proveedor);
           }
       
      return modelo;
   }
    
    public DefaultComboBoxModel rellenaComboCondicionIva(){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(CondicionIva.class).iterator();
       while(ite.hasNext()){
           CondicionIva condicion =(CondicionIva) ite.next();
           modelo.addElement(condicion);
           }
       
      return modelo;
   }
    
}
