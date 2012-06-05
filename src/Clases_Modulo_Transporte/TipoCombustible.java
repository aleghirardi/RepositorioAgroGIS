/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Transporte;

import javax.persistence.*;

@Entity
@Table(name="TipoCombustible")

public class TipoCombustible {

@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idTipo;
 
    private String nombreTipoCombustible;

    /**
     * @return the nombreTipoCombustible
     */
    public String getNombreTipoCombustible() {
        return nombreTipoCombustible;
    }

    /**
     * @param nombreTipoCombustible the nombreTipoCombustible to set
     */
    public void setNombreTipoCombustible(String nombreTipoCombustible) {
        this.nombreTipoCombustible = nombreTipoCombustible;
    }
}
