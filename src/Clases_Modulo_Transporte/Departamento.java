/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Transporte;

import javax.persistence.*;

@Entity
@Table(name="Departamento")

public class Departamento {

@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idDepartamento;

@ManyToOne(targetEntity = Provincia.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
 private Provincia provincia;
   
private String nombreDepartamento;
   

    /**
     * @return the nombreDepartamento
     */
    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    /**
     * @param nombreDepartamento the nombreDepartamento to set
     */
    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    /**
     * @return the provincia
     */
    public Provincia getProvincia() {
        return provincia;
    }

    /**
     * @param provincia the provincia to set
     */
    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }
    
    public String toString(){
        return getNombreDepartamento();
    }

    /**
     * @return the idDepartamento
     */
    public long getIdDepartamento() {
        return idDepartamento;
    }

    /**
     * @param idDepartamento the idDepartamento to set
     */
    public void setIdDepartamento(long idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
}
