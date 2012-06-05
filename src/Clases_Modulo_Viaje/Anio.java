/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Viaje;

import javax.persistence.*;

/**
 *
 * @author ale
 */
import javax.persistence.*;

@Entity
@Table(name="Anio")

public class Anio {
    
    @Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
    private long anio;

    /**
     * @return the anio
     */
    public long getAnio() {
        return anio;
    }

    /**
     * @param anio the anio to set
     */
    public void setAnio(long anio) {
        this.anio = anio;
    }
   
}
