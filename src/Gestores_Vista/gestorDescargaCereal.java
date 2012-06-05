/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Gestores_Vista;

import Clases_Modulo_Carga.Establecimiento;
import Clases_Modulo_Carga.Productor;
import Hibernate.GestorHibernate;
import java.util.Iterator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alejandra
 */
public class gestorDescargaCereal extends GestorHibernate {

    public JTable rellenaTablaProductor(JTable tabla){
       DefaultTableModel modeloT = (DefaultTableModel) tabla.getModel();
       Iterator ite = this.listarClase(Establecimiento.class).iterator();
       while(ite.hasNext()){
           Establecimiento establecimiento = (Establecimiento) ite.next();
           Object fila[]= {establecimiento.getNombreEstablecimiento(), establecimiento.getProductor()};
           modeloT.addRow(fila);
       }
       tabla.setModel(modeloT);
       return tabla;
   }
}
