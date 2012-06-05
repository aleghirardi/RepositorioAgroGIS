/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Carga;

import Clases_Modulo_Transporte.Domicilio;
import Clases_Modulo_Transporte.TipoTelefono;
import javax.persistence.*;

@Entity
@Table(name="Laboratorio")

public class Laboratorio {

@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idLaboratorio;   
    
@ManyToOne(targetEntity = EspecialidadLaboratorio.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private EspecialidadLaboratorio especialidad;

@OneToOne(targetEntity = Domicilio.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Domicilio domicilio;

@ManyToOne(targetEntity = TipoTelefono.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private TipoTelefono tipoTel;
    
    private String razonSocial;
    private String telefono;
    private String eMail;

    /**
     * @return the idLaboratorio
     */
    public long getIdLaboratorio() {
        return idLaboratorio;
    }

    /**
     * @param idLaboratorio the idLaboratorio to set
     */
    public void setIdLaboratorio(long idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
    }

    /**
     * @return the especialidad
     */
    public EspecialidadLaboratorio getEspecialidad() {
        return especialidad;
    }

    /**
     * @param especialidad the especialidad to set
     */
    public void setEspecialidad(EspecialidadLaboratorio especialidad) {
        this.especialidad = especialidad;
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
     * @return the tipoTel
     */
    public TipoTelefono getTipoTel() {
        return tipoTel;
    }

    /**
     * @param tipoTel the tipoTel to set
     */
    public void setTipoTel(TipoTelefono tipoTel) {
        this.tipoTel = tipoTel;
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
     * @return the eMail
     */
    public String geteMail() {
        return eMail;
    }

    /**
     * @param eMail the eMail to set
     */
    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String toString(){
        return getRazonSocial();
    }
}
