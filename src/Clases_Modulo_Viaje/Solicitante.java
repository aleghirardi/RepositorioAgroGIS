/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Viaje;

import java.util.Date;
import javax.persistence.*;
import Clases_Modulo_Transporte.*;

/**
 *
 * @author ale
 */
@Entity
@Table(name="Solicitante")

public class Solicitante {
    
    @Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
    private long idSolicitante;  
    
    @ManyToOne(targetEntity = TipoDocumento.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
    private TipoDocumento tipoDocumento;
    
    @ManyToOne(targetEntity = Domicilio.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
    private Domicilio domicilio;
    
    @ManyToOne(targetEntity = TipoTelefono.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
    private TipoTelefono tipoTelefono;
    
    private String apellido;
    private String nombre;
    private int numeroDocumento;
    private String numeroTelefono;
    private Date fechaNacimiento;
    private String email;

    /**
     * @return the tipoDocumento
     */
    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * @param tipoDocumento the tipoDocumento to set
     */
    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
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
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the numeroDocumento
     */
    public int getNumeroDocumento() {
        return numeroDocumento;
    }

    /**
     * @param numeroDocumento the numeroDocumento to set
     */
    public void setNumeroDocumento(int numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    /**
     * @return the numeroTelefono
     */
    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    /**
     * @param numeroTelefono the numeroTelefono to set
     */
    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    /**
     * @return the fechaNacimiento
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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
    
}
