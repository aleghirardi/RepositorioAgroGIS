/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Transporte;

import javax.persistence.*;

@Entity
@Table(name="CondicionContratacion")

public class CondicionContratacion {

@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idCondicion;
    
    private String nombreCondicion;

    /**
     * @return the nombreCondicion
     */
    public String getNombreCondicion() {
        return nombreCondicion;
    }

    /**
     * @param nombreCondicion the nombreCondicion to set
     */
    public void setNombreCondicion(String nombreCondicion) {
        this.nombreCondicion = nombreCondicion;
    }
    
    public String toString(){
        return getNombreCondicion();
    }
}
