/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Transporte;

import javax.persistence.*;

@Entity
@Table(name="Provincia")

public class Provincia {

@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idProvincia;

@ManyToOne(targetEntity = Pais.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Pais pais;

private String nombreProvincia;

    /**
     * @return the nombreProvincia
     */
    public String getNombreProvincia() {
        return nombreProvincia;
    }

    /**
     * @param nombreProvincia the nombreProvincia to set
     */
    public void setNombreProvincia(String nombreProvincia) {
        this.nombreProvincia = nombreProvincia;
    }

    /**
     * @return the pais
     */
    public Pais getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(Pais pais) {
        this.pais = pais;
    }
    
     public String toString(){
        return getNombreProvincia();
    }

    /**
     * @return the idProvincia
     */
    public long getIdProvincia() {
        return idProvincia;
    }

    /**
     * @param idProvincia the idProvincia to set
     */
    public void setIdProvincia(long idProvincia) {
        this.idProvincia = idProvincia;
    }
}
