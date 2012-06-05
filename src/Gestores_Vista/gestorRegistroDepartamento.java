/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores_Vista;

import Clases_Modulo_Transporte.Pais;
import Clases_Modulo_Transporte.Provincia;
import Hibernate.GestorHibernate;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Charito
 */
public class gestorRegistroDepartamento extends GestorHibernate{
    
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
}
