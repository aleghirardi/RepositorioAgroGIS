/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores_Clases;

import Hibernate.GestorHibernate;
import Clases_Modulo_Transporte.Localidad;
import Clases_Modulo_Transporte.Pais;
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
public class gestorProvincia extends GestorHibernate {
     public DefaultComboBoxModel getComboModelProvincia(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        Iterator iterador= this.listarClase(Provincia.class).iterator();
        while(iterador.hasNext()){
            Provincia c= (Provincia) iterador.next();
            modelo.addElement(c);
        }
        return modelo;
    }
     
     public void guardarProvincia(JTable tabla){
     DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();      
        Iterator iterator = this.listarClase(Provincia.class).iterator();
        if(iterator.hasNext()==false){
            Provincia prov = new Provincia();
            prov.setNombreProvincia((String)modeloTabla.getValueAt(0,1));
            prov.setPais((Pais)modeloTabla.getValueAt(0,0));
            this.guardarObjeto(prov);
            System.out.println("12345");
            }
        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
                int bandera=0;
                Provincia provincia = new Provincia();
                Iterator ite = this.listarClase(Provincia.class).iterator();
                while(ite.hasNext()){
                    Provincia p = (Provincia) ite.next();
                    if(p.getNombreProvincia()==((String)modeloTabla.getValueAt(i,1))){
                         bandera=1;               
                    }
                }
                if(bandera==0){
                provincia.setNombreProvincia((String) modeloTabla.getValueAt(i, 1));
                provincia.setPais((Pais)modeloTabla.getValueAt(i,0));
                this.guardarObjeto(provincia);
                System.out.println("22222");
                }
                }
     
     }
     
     public void actualizarProvincia(long idProvincia, JTextField txtProvincia, JComboBox cmbPais){
     Iterator ite = this.listarClase(Provincia.class).iterator();
     while(ite.hasNext()){
       Provincia p = (Provincia) ite.next();
       if(p.getIdProvincia() == idProvincia){
           p.setNombreProvincia(txtProvincia.getText());
           p.setPais((Pais)cmbPais.getSelectedItem());
           this.actualizarObjeto(p);
       }
   }
     
     }
}
