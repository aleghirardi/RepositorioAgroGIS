/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores_Clases;

import Clases_Modulo_Transporte.Departamento;
import Hibernate.GestorHibernate;
import Clases_Modulo_Transporte.Localidad;
import Clases_Modulo_Transporte.Provincia;
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
public class gestorLocalidad extends GestorHibernate {
    
    public DefaultComboBoxModel getComboModelLocalidad(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        Iterator iterador= this.listarClase(Localidad.class).iterator();
        while(iterador.hasNext()){
            Localidad c= (Localidad) iterador.next();
            modelo.addElement(c);
        }
        return modelo;
    }
    
    public void guardarLocalidad(JTable tabla){
     DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();      
        Iterator iterator = this.listarClase(Localidad.class).iterator();
        if(iterator.hasNext()==false){
            Localidad loc = new Localidad();
            loc.setNombreLocalidad((String)modeloTabla.getValueAt(0,0));
            loc.setCodigoPostal((String)modeloTabla.getValueAt(0,1));
            loc.setDepartamento((Departamento)modeloTabla.getValueAt(0,2));
            this.guardarObjeto(loc);
            }
        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
                int bandera=0;
                Localidad loc = new Localidad();
                Iterator ite = this.listarClase(Localidad.class).iterator();
                while(ite.hasNext()){
                    Localidad l = (Localidad) ite.next();
                    if(l.getNombreLocalidad()==((String)modeloTabla.getValueAt(i,0))){
                         bandera=1;               
                    }
                }
                if(bandera==0){
                loc.setNombreLocalidad((String) modeloTabla.getValueAt(i, 0));
                loc.setCodigoPostal((String)modeloTabla.getValueAt(i,1));
                loc.setDepartamento((Departamento)modeloTabla.getValueAt(i,2));
                this.guardarObjeto(loc);
                }
                }
     
     }
     
     public void actualizarLocalidad(long idLocalidad, JTextField txtCodigoPostal, JTextField txtLocalidad, JComboBox cmbDepto){
     Iterator ite = this.listarClase(Localidad.class).iterator();
     while(ite.hasNext()){
       Localidad loc = (Localidad) ite.next();
       if(loc.getIdLocalidad() == idLocalidad){
           loc.setNombreLocalidad(txtLocalidad.getText());
           loc.setCodigoPostal(txtCodigoPostal.getText());
           loc.setDepartamento((Departamento)cmbDepto.getSelectedItem());
           this.actualizarObjeto(loc);
       }
   }
     
     }
}
