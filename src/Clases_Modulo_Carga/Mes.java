/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Carga;

import javax.persistence.*;

@Entity
@Table(name="Mes")

public class Mes {

@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idMes;  
    
    private String nombreMes;

    /**
     * @return the nombreMes
     */
    public String getNombreMes() {
        return nombreMes;
    }

    /**
     * @param nombreMes the nombreMes to set
     */
    public void setNombreMes(String nombreMes) {
        this.nombreMes = nombreMes;
    }
}
