/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Carga;

import javax.persistence.*;

@Entity
@Table(name="TipoOperacion")

public class TipoOperacion {
    
@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idTipoOperacion;    
    
    private String nombreTipoOperacion;

    /**
     * @return the nombreTipoOperacion
     */
    public String getNombreTipoOperacion() {
        return nombreTipoOperacion;
    }

    /**
     * @param nombreTipoOperacion the nombreTipoOperacion to set
     */
    public void setNombreTipoOperacion(String nombreTipoOperacion) {
        this.nombreTipoOperacion = nombreTipoOperacion;
    }
}
