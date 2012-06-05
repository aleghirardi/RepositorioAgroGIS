/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores_Clases;

import Hibernate.GestorHibernate;
import Clases_Modulo_Transporte.Barrio;
import Clases_Modulo_Transporte.Departamento;
import Clases_Modulo_Transporte.Localidad;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Charito
 */
public class gestorBarrio extends GestorHibernate{
    
      public DefaultComboBoxModel getComboModelBarrio(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        Iterator iterador= this.listarClase(Barrio.class).iterator();
        while(iterador.hasNext()){
            Barrio c= (Barrio) iterador.next();
            modelo.addElement(c);
        }
        return modelo;
    }
      
       public void guardarBarrio(JTable tabla){
     DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();      
        Iterator iterator = this.listarClase(Barrio.class).iterator();
        if(iterator.hasNext()==false){
            Barrio barrio = new Barrio();
            barrio.setNombreBarrio((String)modeloTabla.getValueAt(0,1));
            barrio.setLocalidad((Localidad)modeloTabla.getValueAt(0,0));
            this.guardarObjeto(barrio);
            }
        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
                int bandera=0;
                Barrio barrio = new Barrio();
                Iterator ite = this.listarClase(Barrio.class).iterator();
                while(ite.hasNext()){
                    Barrio b = (Barrio) ite.next();
                    if((b.getNombreBarrio()==((String)modeloTabla.getValueAt(i,1)))&& (b.getLocalidad().getNombreLocalidad()==((String)modeloTabla.getValueAt(i, 0)))){
                         bandera=1;               
                    }
                }
                if(bandera==0){
                barrio.setNombreBarrio((String) modeloTabla.getValueAt(i, 1));
                barrio.setLocalidad((Localidad)modeloTabla.getValueAt(i,0));
                this.guardarObjeto(barrio);
                }
                }
     
     }
     
     public void actualizarBarrio(long idBarrio, JTextField txtBarrio, JComboBox cmbLocalidad){
     Iterator ite = this.listarClase(Barrio.class).iterator();
     while(ite.hasNext()){
       Barrio barrio = (Barrio) ite.next();
       if(barrio.getIdBarrio() == idBarrio){
           barrio.setNombreBarrio(txtBarrio.getText());
           barrio.setLocalidad((Localidad)cmbLocalidad.getSelectedItem());
           this.actualizarObjeto(barrio);
       }
   }
     
     }
}
