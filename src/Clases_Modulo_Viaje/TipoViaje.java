/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Viaje;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ale
 */
@Entity
@Table(name="TipoViaje")

public class TipoViaje {
    
    @Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
    private long idTipoViaje;
    
    private String nombreTipoViaje;

    /**
     * @return the nombreTipoViaje
     */
    public String getNombreTipoViaje() {
        return nombreTipoViaje;
    }

    /**
     * @param nombreTipoViaje the nombreTipoViaje to set
     */
    public void setNombreTipoViaje(String nombreTipoViaje) {
        this.nombreTipoViaje = nombreTipoViaje;
    }
    
}
