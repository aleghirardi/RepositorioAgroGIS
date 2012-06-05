/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Viaje;

import javax.persistence.*;

@Entity
@Table(name="Dia")

public class Dia {
    
    @Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
    private long idDia;
    
    private String nombreDia;

    /**
     * @return the nombreDia
     */
    public String getNombreDia() {
        return nombreDia;
    }

    /**
     * @param nombreDia the nombreDia to set
     */
    public void setNombreDia(String nombreDia) {
        this.nombreDia = nombreDia;
    }
    
}
