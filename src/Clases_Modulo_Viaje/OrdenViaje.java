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

@Entity
@Table(name="OrdenViaje")


public class OrdenViaje {
    
    @Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
    private long numeroOrden;  
    
    
    @ManyToOne(targetEntity = Viaje.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
    private Viaje viaje;
    
    
    private String responsable;

    /**
     * @return the viaje
     */
    public Viaje getViaje() {
        return viaje;
    }

    /**
     * @param viaje the viaje to set
     */
    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
    }


    /**
     * @return the responsable
     */
    public String getResponsable() {
        return responsable;
    }

    /**
     * @param responsable the responsable to set
     */
    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    /**
     * @return the numeroOrden
     */
    public long getNumeroOrden() {
        return numeroOrden;
    }

    /**
     * @param numeroOrden the numeroOrden to set
     */
    public void setNumeroOrden(long numeroOrden) {
        this.numeroOrden = numeroOrden;
    }
 
}
