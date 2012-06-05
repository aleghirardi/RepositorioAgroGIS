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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Charito
 */
public class gestorPais extends GestorHibernate {
    
    public DefaultComboBoxModel getComboModelPais(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        Iterator iterador= this.listarClase(Pais.class).iterator();
        while(iterador.hasNext()){
            Pais c= (Pais) iterador.next();
            modelo.addElement(c);
        }
        return modelo;
    }
    
     public void guardarPais(JTable tabla){
     DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();      
        Iterator iterator = this.listarClase(Pais.class).iterator();
        if(iterator.hasNext()==false){
            Pais pais = new Pais();
            pais.setNombrePais((String)modeloTabla.getValueAt(0,0));
            this.guardarObjeto(pais);
            }
        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
                int bandera=0;
                Pais pais = new Pais();
                Iterator ite = this.listarClase(Pais.class).iterator();
                while(ite.hasNext()){
                    Pais p = (Pais) ite.next();
                    if(p.getNombrePais()==((String)modeloTabla.getValueAt(i,0))){
                         bandera=1;               
                    }
                }
                if(bandera==0){
                pais.setNombrePais((String) modeloTabla.getValueAt(i, 0));
                this.guardarObjeto(pais);
                }
                }
     
     }
     
     public void actualizarPais(long idPais, JTextField txtPais){
     Iterator ite = this.listarClase(Pais.class).iterator();
     while(ite.hasNext()){
       Pais p = (Pais) ite.next();
       if(p.getIdPais() == idPais){
           p.setNombrePais(txtPais.getText());
           this.actualizarObjeto(p);
       }
   }
     
     }
    
}
