/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Transporte;

import javax.persistence.*;

@Entity
@Table(name="Pais")

public class Pais {

@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idPais;

    private String nombrePais;

    /**
     * @return the nombrePais
     */
    public String getNombrePais() {
        return nombrePais;
    }

    /**
     * @param nombrePais the nombrePais to set
     */
    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }
     public String toString(){
        return getNombrePais();
    }

    /**
     * @return the idPais
     */
    public long getIdPais() {
        return idPais;
    }

    /**
     * @param idPais the idPais to set
     */
    public void setIdPais(long idPais) {
        this.idPais = idPais;
    }
}
