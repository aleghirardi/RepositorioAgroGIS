/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores_Clases;
import Hibernate.GestorHibernate;
import Clases_Modulo_Transporte.TipoTelefono;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
/**
 *
 * @author Charito
 */
public class gestorTipoTelefono extends GestorHibernate{
    
      public DefaultComboBoxModel getComboModelTipoTelefono(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        Iterator iterador= this.listarClase(TipoTelefono.class).iterator();
        while(iterador.hasNext()){
            TipoTelefono c= (TipoTelefono) iterador.next();
            modelo.addElement(c);
        }
        return modelo;
    }
}
