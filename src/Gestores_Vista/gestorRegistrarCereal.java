/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores_Vista;

import Clases_Modulo_Carga.Mes;
import Clases_Modulo_Carga.TipoTemporada;
import Clases_Modulo_Transporte.Localidad;
import Hibernate.GestorHibernate;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;


public class gestorRegistrarCereal extends GestorHibernate {

    public DefaultComboBoxModel rellenaComboMes(){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(Mes.class).iterator();
       while(ite.hasNext()){
           Mes mes =(Mes) ite.next();
           modelo.addElement(mes);
       }
       return modelo;
   }    
}
