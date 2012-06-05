/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Transporte;

import javax.persistence.*;

@Entity
@Table(name="Localidad")

public class Localidad {

@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idLocalidad;

@ManyToOne(targetEntity = Departamento.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Departamento departamento;

    private String nombreLocalidad;
    private String codigoPostal;
  

    /**
     * @return the nombreLocalidad
     */
    public String getNombreLocalidad() {
        return nombreLocalidad;
    }

    /**
     * @param nombreLocalidad the nombreLocalidad to set
     */
    public void setNombreLocalidad(String nombreLocalidad) {
        this.nombreLocalidad = nombreLocalidad;
    }

    /**
     * @return the codigoPostal
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * @param codigoPostal the codigoPostal to set
     */
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    /**
     * @return the departamento
     */
    public Departamento getDepartamento() {
        return departamento;
    }

    /**
     * @param departamento the departamento to set
     */
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    
    public String toString(){
        return getNombreLocalidad();
    }

    /**
     * @return the idLocalidad
     */
    public long getIdLocalidad() {
        return idLocalidad;
    }

    /**
     * @param idLocalidad the idLocalidad to set
     */
    public void setIdLocalidad(long idLocalidad) {
        this.idLocalidad = idLocalidad;
    }
}
