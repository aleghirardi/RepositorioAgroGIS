/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Transporte;

import javax.persistence.*;

@Entity
@Table(name="EstacionDeServicio")

public class EstacionDeServicio {

@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idEstacionDeServicio;

@ManyToOne(targetEntity = CondicionIva.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private CondicionIva condicionIva;

@ManyToOne(targetEntity = Domicilio.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Domicilio domicilio;

@ManyToOne(targetEntity = ProveedorCombustible.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private ProveedorCombustible proveedor;

@ManyToOne(targetEntity = TipoTelefono.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private TipoTelefono tipoTelefono;

private String email;
private String razonSocial;
private String telefono;
private String CUIT;
    

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
     * @return the proveedor
     */
    public ProveedorCombustible getProveedor() {
        return proveedor;
    }

    /**
     * @param proveedor the proveedor to set
     */
    public void setProveedor(ProveedorCombustible proveedor) {
        this.proveedor = proveedor;
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
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the CUIT
     */
    public String getCUIT() {
        return CUIT;
    }

    /**
     * @param CUIT the CUIT to set
     */
    public void setCUIT(String CUIT) {
        this.CUIT = CUIT;
    }
        
    public String toString(){
        return getRazonSocial();
    }
}
