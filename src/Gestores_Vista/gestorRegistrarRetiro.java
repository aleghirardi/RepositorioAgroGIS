/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores_Vista;

import Clases_Modulo_Transporte.Vehiculo;
import Hibernate.GestorHibernate;
import java.util.Iterator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Charito
 */
public class gestorRegistrarRetiro extends GestorHibernate {
    
       public JTable rellenaTablaProductor(JTable tabla){
       DefaultTableModel modeloT = (DefaultTableModel) tabla.getModel();
       Iterator ite = this.listarClase(Vehiculo.class).iterator();
       while(ite.hasNext()){
           Vehiculo vehiculo = (Vehiculo) ite.next();
           if(vehiculo.getEstado().equals("Pendiente")){
           Object fila[]= {vehiculo.getDominio(), vehiculo.getCarga(), vehiculo.getTransportista()};
           modeloT.addRow(fila);
           }
          
       }
       tabla.setModel(modeloT);
       return tabla;
   }
}
