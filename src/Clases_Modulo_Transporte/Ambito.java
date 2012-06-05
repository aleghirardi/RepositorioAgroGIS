/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Transporte;

import javax.persistence.*;

@Entity
@Table(name="Ambito")

public class Ambito {

@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idAmbito;
    
    private String nombreAmbito;

    /**
     * @return the nombreAmbito
     */
    public String getNombreAmbito() {
        return nombreAmbito;
    }

    /**
     * @param nombreAmbito the nombreAmbito to set
     */
    public void setNombreAmbito(String nombreAmbito) {
        this.nombreAmbito = nombreAmbito;
    }
}
