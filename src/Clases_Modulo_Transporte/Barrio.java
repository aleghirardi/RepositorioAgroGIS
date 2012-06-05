/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Transporte;

import javax.persistence.*;

@Entity
@Table(name="Barrio")

public class Barrio {

@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idBarrio;

@ManyToOne(targetEntity = Localidad.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Localidad localidad;
    
    private String nombreBarrio;
  

    /**
     * @return the nombreBarrio
     */
    public String getNombreBarrio() {
        return nombreBarrio;
    }

    /**
     * @param nombreBarrio the nombreBarrio to set
     */
    public void setNombreBarrio(String nombreBarrio) {
        this.nombreBarrio = nombreBarrio;
    }

    /**
     * @return the localidad
     */
    public Localidad getLocalidad() {
        return localidad;
    }

    /**
     * @param localidad the localidad to set
     */
    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }
    
    public String toString(){
        return getNombreBarrio();
    }

    /**
     * @return the idBarrio
     */
    public long getIdBarrio() {
        return idBarrio;
    }

    /**
     * @param idBarrio the idBarrio to set
     */
    public void setIdBarrio(long idBarrio) {
        this.idBarrio = idBarrio;
    }
}
