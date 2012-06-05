/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores_Clases;

import Hibernate.GestorHibernate;
import Clases_Modulo_Transporte.Departamento;
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
public class gestorDepartamento extends GestorHibernate{
    
    public DefaultComboBoxModel getComboModelDepartamento(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        Iterator iterador= this.listarClase(Departamento.class).iterator();
        while(iterador.hasNext()){
            Departamento c= (Departamento) iterador.next();
            modelo.addElement(c);
        }
        return modelo;
    }
    
     public void guardarDepartamento(JTable tabla){
     DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();      
        Iterator iterator = this.listarClase(Departamento.class).iterator();
        if(iterator.hasNext()==false){
            Departamento depto = new Departamento();
            depto.setNombreDepartamento((String)modeloTabla.getValueAt(0,1));
            depto.setProvincia((Provincia)modeloTabla.getValueAt(0,0));
            this.guardarObjeto(depto);
            }
        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
                int bandera=0;
                Departamento depto = new Departamento();
                Iterator ite = this.listarClase(Departamento.class).iterator();
                while(ite.hasNext()){
                    Departamento dep = (Departamento) ite.next();
                    if(dep.getNombreDepartamento()==((String)modeloTabla.getValueAt(i,1))){
                         bandera=1;               
                    }
                }
                if(bandera==0){
                depto.setNombreDepartamento((String) modeloTabla.getValueAt(i, 1));
                depto.setProvincia((Provincia)modeloTabla.getValueAt(i,0));
                this.guardarObjeto(depto);
                }
                }
     
     }
     
     public void actualizarDepartamento(long idDepto, JTextField txtDepto, JComboBox cmbProvincia){
     Iterator ite = this.listarClase(Departamento.class).iterator();
     while(ite.hasNext()){
       Departamento depto = (Departamento) ite.next();
       if(depto.getIdDepartamento() == idDepto){
           depto.setProvincia((Provincia)cmbProvincia.getSelectedItem());
           depto.setNombreDepartamento(txtDepto.getText());
           this.actualizarObjeto(depto);
       }
   }
     
     }
}
