/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores_Clases;

import javax.swing.DefaultComboBoxModel;
import Hibernate.GestorHibernate;
import Clases_Modulo_Transporte.TipoDocumento;
import java.util.Iterator;

/**
 *
 * @author Charito
 */
public class gestorTipoDocumento extends GestorHibernate{
     public DefaultComboBoxModel getComboModelTipodocumento(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        Iterator iterador= this.listarClase(TipoDocumento.class).iterator();
        while(iterador.hasNext()){
            TipoDocumento c= (TipoDocumento) iterador.next();
            modelo.addElement(c);
        }
        return modelo;
    }
}
