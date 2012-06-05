/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Carga;

import javax.persistence.*;

@Entity
@Table(name="Destino")

public class Destino {
   
@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idDestino;   

@ManyToOne(targetEntity = Establecimiento.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Establecimiento establecimiento;
    
@ManyToOne(targetEntity = Puerto.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Puerto puerto;

    /**
     * @return the establecimiento
     */
    public Establecimiento getEstablecimiento() {
        return establecimiento;
    }

    /**
     * @param establecimiento the establecimiento to set
     */
    public void setEstablecimiento(Establecimiento establecimiento) {
        this.establecimiento = establecimiento;
    }

    /**
     * @return the puerto
     */
    public Puerto getPuerto() {
        return puerto;
    }

    /**
     * @param puerto the puerto to set
     */
    public void setPuerto(Puerto puerto) {
        this.puerto = puerto;
    }
}
