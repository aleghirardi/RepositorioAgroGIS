/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores_Vista;

import Clases_Modulo_Transporte.Pais;
import Clases_Modulo_Transporte.Provincia;
import Hibernate.GestorHibernate;

/**
 *
 * @author Charito
 */
public class gestorRegistroProvincia extends GestorHibernate{
    
    public void GuardarProvincia(String nombreProvincia, Pais pais){
    GestorHibernate gestorH = new GestorHibernate();
    Provincia provincia = new Provincia();
    provincia.setNombreProvincia(nombreProvincia);
    provincia.setPais(pais);
//    gestorH.guardarObjeto(provincia);
    }
}
