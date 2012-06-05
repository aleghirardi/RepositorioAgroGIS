/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Transporte;

import javax.persistence.*;

@Entity
@Table(name="TipoDocumento")

public class TipoDocumento {

@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idTipoDoc;

    private String nombreTipoDocumento;

    /**
     * @return the nombreTipoDocumento
     */
    public String getNombreTipoDocumento() {
        return nombreTipoDocumento;
    }

    /**
     * @param nombreTipoDocumento the nombreTipoDocumento to set
     */
    public void setNombreTipoDocumento(String nombreTipoDocumento) {
        this.nombreTipoDocumento = nombreTipoDocumento;
    }
    
     public String toString(){
        return getNombreTipoDocumento();
    }
}
