/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Gestores_Vista;

import Hibernate.GestorHibernate;
//import clases.localidad;
//import clases.persona;



public class gestorFecha {

    public boolean ValidarFecha(int dia, int mes, int anio){
    boolean validar= true;
    
    if( dia<0 || dia>31 || mes<0 || mes> 12){
    validar = false;
    }
    else
        if((mes==4 || mes==6 || mes==9 || mes==11)&& (dia>30)){
        validar = false;
        }
    else
        if(mes==2 && dia>28){
        validar=false;
        }

    return validar;
    }

    public String ObtenerDia(String fecha){
    String dia = fecha.substring(0,2);
    return dia;
    }

    public String ObtenerMes(String fecha){
    String mes = fecha.substring(3,5);
    return mes;
    }

    public String ObtenerAnio(String fecha){
    String anio = fecha.substring(6,10);
    return anio;
    }

//    public void GuardarPersona(String nombrePersona, String numeroDocumento, String fechaNacimiento, int telefono, String email, localidad loc){
//    GestorHibernate gestorH = new GestorHibernate();
//    persona pers = new persona();
//    pers.setEmail(email);
//    pers.setFechaNacimiento(fechaNacimiento);
//    pers.setNombrePersona(nombrePersona);
//    pers.setNumeroDocumento(numeroDocumento);
//    pers.setTelefono(telefono);
//    pers.setLocalidad(loc);
//    gestorH.guardarObjeto(pers);
//    }
}
