/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Carga;

import Clases_Modulo_Transporte.Localidad;

import javax.persistence.*;

@Entity
@Table(name="Puerto")

public class Puerto {

@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idPuerto;  

    private String nombrePuerto;
@ManyToOne(targetEntity = Localidad.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
    private Localidad localidad;

    /**
     * @return the nombrePuerto
     */
    public String getNombrePuerto() {
        return nombrePuerto;
    }

    /**
     * @param nombrePuerto the nombrePuerto to set
     */
    public void setNombrePuerto(String nombrePuerto) {
        this.nombrePuerto = nombrePuerto;
    }

    /**
     * @return the localidad
     */
    public Localidad getLocalidad() {
        return localidad;
    }

    /**
     * @param localidad the localidad to set
     */
    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }
}
