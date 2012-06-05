/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Transporte;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name="TallerReparacion")

public class TallerReparacion {

@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idTallerReparacion;

@ManyToOne(targetEntity = CondicionIva.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private CondicionIva condicionIva;

@ManyToOne(targetEntity = Domicilio.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Domicilio domicilio;
   
@ManyToOne(targetEntity = TipoTelefono.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private TipoTelefono tipoTelefono;

@ManyToMany(targetEntity = Especialidad.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Set<Especialidad> especialidad = new HashSet();


    private String email;
    private int numeroTelefono;
    private String razonSocial;
    
    /**
     * @return the condicionIva
     */
    public CondicionIva getCondicionIva() {
        return condicionIva;
    }

    /**
     * @param condicionIva the condicionIva to set
     */
    public void setCondicionIva(CondicionIva condicionIva) {
        this.condicionIva = condicionIva;
    }

    /**
     * @return the domicilio
     */
    public Domicilio getDomicilio() {
        return domicilio;
    }

    /**
     * @param domicilio the domicilio to set
     */
    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }


    /**
     * @return the numeroTelefono
     */
    public int getNumeroTelefono() {
        return numeroTelefono;
    }

    /**
     * @param numeroTelefono the numeroTelefono to set
     */
    public void setNumeroTelefono(int numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    /**
     * @return the razonSocial
     */
    public String getRazonSocial() {
        return razonSocial;
    }

    /**
     * @param razonSocial the razonSocial to set
     */
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    /**
     * @return the tipoTelefono
     */
    public TipoTelefono getTipoTelefono() {
        return tipoTelefono;
    }

    /**
     * @param tipoTelefono the tipoTelefono to set
     */
    public void setTipoTelefono(TipoTelefono tipoTelefono) {
        this.tipoTelefono = tipoTelefono;
    }

    /**
     * @param especialidad the especialidad to set
     */
    public void setEspecialidad(Set<Especialidad> especialidad) {
        this.especialidad = especialidad;
    }

    /**
     * @return the especialidad
     */
    public Set<Especialidad> getEspecialidad() {
        return especialidad;
    }

  
}
