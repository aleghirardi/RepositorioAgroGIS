/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Carga;

import javax.persistence.*;

@Entity
@Table(name="Establecimiento")


public class Establecimiento {

@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idEstablecimiento;     

@ManyToOne(targetEntity = Productor.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Productor productor;

private String nombreEstablecimiento;

    /**
     * @return the nombreEstablecimiento
     */
    public String getNombreEstablecimiento() {
        return nombreEstablecimiento;
    }

    /**
     * @param nombreEstablecimiento the nombreEstablecimiento to set
     */
    public void setNombreEstablecimiento(String nombreEstablecimiento) {
        this.nombreEstablecimiento = nombreEstablecimiento;
    }

    /**
     * @return the productor
     */
    public Productor getProductor() {
        return productor;
    }

    /**
     * @param productor the productor to set
     */
    public void setProductor(Productor productor) {
        this.productor = productor;
    }

}
