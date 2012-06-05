/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Transporte;

import javax.persistence.*;

@Entity
@Table(name="TipoVehiculo")

public class TipoVehiculo {

@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idTipoVehiculo;

    
    private String nombreTipoVehiculo;

    /**
     * @return the nombreTipoVehiculo
     */
    public String getNombreTipoVehiculo() {
        return nombreTipoVehiculo;
    }

    /**
     * @param nombreTipoVehiculo the nombreTipoVehiculo to set
     */
    public void setNombreTipoVehiculo(String nombreTipoVehiculo) {
        this.nombreTipoVehiculo = nombreTipoVehiculo;
    }
}
