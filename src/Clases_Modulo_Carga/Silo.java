/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Carga;

import Clases_Modulo_Transporte.Estado;

import javax.persistence.*;

@Entity
@Table(name="Silo")

public class Silo {
    
@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long numeroSilo; 

//@ManyToOne(targetEntity = Estado.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
//private Estado estado;
    
    private double alto;
    private String capacidad;
    private double diametro;
    private String estado;

    /**
     * @return the alto
     */
    public double getAlto() {
        return alto;
    }

    /**
     * @param alto the alto to set
     */
    public void setAlto(double alto) {
        this.alto = alto;
    }

    /**
     * @return the capacidad
     */
    public String getCapacidad() {
        return capacidad;
    }

    /**
     * @param capacidad the capacidad to set
     */
    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * @return the diametro
     */
    public double getDiametro() {
        return diametro;
    }

    /**
     * @param diametro the diametro to set
     */
    public void setDiametro(double diametro) {
        this.diametro = diametro;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the numeroSilo
     */
    public long getNumeroSilo() {
        return numeroSilo;
    }

    /**
     * @param numeroSilo the numeroSilo to set
     */
    public void setNumeroSilo(long numeroSilo) {
        this.numeroSilo = numeroSilo;
    }

   
}
