/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Transporte;

import javax.persistence.*;

@Entity
@Table(name="Motivo")

public class Motivo {

@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idMotivo;

    private String descripcion;
    private String nombreMotivo;

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
     * @return the nombreMotivo
     */
    public String getNombreMotivo() {
        return nombreMotivo;
    }

    /**
     * @param nombreMotivo the nombreMotivo to set
     */
    public void setNombreMotivo(String nombreMotivo) {
        this.nombreMotivo = nombreMotivo;
    }
}
