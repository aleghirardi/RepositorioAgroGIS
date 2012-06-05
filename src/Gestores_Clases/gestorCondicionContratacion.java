/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores_Clases;
import Hibernate.GestorHibernate;
import Clases_Modulo_Transporte.CondicionContratacion;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Charito
 */
public class gestorCondicionContratacion extends GestorHibernate{
    
    public DefaultComboBoxModel getComboModelCondicionContratacion(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        Iterator iterador= this.listarClase(CondicionContratacion.class).iterator();
        while(iterador.hasNext()){
            CondicionContratacion c= (CondicionContratacion) iterador.next();
            modelo.addElement(c);
        }
        return modelo;
    }
    
    
}
