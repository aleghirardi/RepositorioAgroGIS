/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Transporte;

import javax.persistence.*;

@Entity
@Table(name="ArregloEfectuado")

public class ArregloEfectuado {

@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idArreglo;    
    
   private String descripcion;
   private String nombreArreglo;

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the nombreArreglo
     */
    public String getNombreArreglo() {
        return nombreArreglo;
    }

    /**
     * @param nombreArreglo the nombreArreglo to set
     */
    public void setNombreArreglo(String nombreArreglo) {
        this.nombreArreglo = nombreArreglo;
    }
}
