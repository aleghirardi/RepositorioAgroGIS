/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Transporte;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="Transportista")

public class Transportista {

@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idTransportista;

@ManyToOne(targetEntity = Domicilio.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Domicilio domicilio;

@ManyToOne(targetEntity = TipoDocumento.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private TipoDocumento tipoDocumento;

@ManyToMany(targetEntity = TipoTelefono.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Set<TipoTelefono> tipoTelefono = new HashSet();

@ManyToOne(targetEntity = CondicionContratacion.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private CondicionContratacion condicionContratacion;



private String apellido;
private String email;
private String fechaNacimiento;
private String nombre;
private String numeroDocumento;
private String numeroTelefono;
private String fechaIngreso;
private String fechaSalida;
private String cuil;
private String estadoCivil;

    /**
     * @return the idTransportista
     */
    public long getIdTransportista() {
        return idTransportista;
    }

    /**
     * @param idTransportista the idTransportista to set
     */
    public void setIdTransportista(long idTransportista) {
        this.idTransportista = idTransportista;
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
     * @return the tipoTelefono
     */
    public Set<TipoTelefono> getTipoTelefono() {
        return tipoTelefono;
    }

    /**
     * @param tipoTelefono the tipoTelefono to set
     */
    public void setTipoTelefono(Set<TipoTelefono> tipoTelefono) {
        this.tipoTelefono = tipoTelefono;
    }

    /**
     * @return the condicionContratacion
     */
    public CondicionContratacion getCondicionContratacion() {
        return condicionContratacion;
    }

    /**
     * @param condicionContratacion the condicionContratacion to set
     */
    public void setCondicionContratacion(CondicionContratacion condicionContratacion) {
        this.condicionContratacion = condicionContratacion;
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
     * @return the fechaNacimiento
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    /**
     * @param numeroDocumento the numeroDocumento to set
     */
    public void setNumeroDocumento(String numeroDocumento) {
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
     * @return the fechaIngreso
     */
    public String getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     * @param fechaIngreso the fechaIngreso to set
     */
    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    /**
     * @return the fechaSalida
     */
    public String getFechaSalida() {
        return fechaSalida;
    }

    /**
     * @param fechaSalida the fechaSalida to set
     */
    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    /**
     * @return the cuil
     */
    public String getCuil() {
        return cuil;
    }

    /**
     * @param cuil the cuil to set
     */
    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    /**
     * @return the estadoCivil
     */
    public String getEstadoCivil() {
        return estadoCivil;
    }

    /**
     * @param estadoCivil the estadoCivil to set
     */
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
    
}
