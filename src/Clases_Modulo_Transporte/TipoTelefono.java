/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Transporte;

import javax.persistence.*;

@Entity
@Table(name="TipoTelefono")

public class TipoTelefono {

@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idTipoTel;

    private String nombreTipoTelefono;

    /**
     * @return the nombreTipoTelefono
     */
    public String getNombreTipoTelefono() {
        return nombreTipoTelefono;
    }

    /**
     * @param nombreTipoTelefono the nombreTipoTelefono to set
     */
    public void setNombreTipoTelefono(String nombreTipoTelefono) {
        this.nombreTipoTelefono = nombreTipoTelefono;
    }
    
    public String toString(){
    return getNombreTipoTelefono();
    }
            
}
