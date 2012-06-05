/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Carga;

import javax.persistence.*;

@Entity
@Table(name="EspecialidadLaboratorio")

public class EspecialidadLaboratorio {
   
@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idEspecialidadLaboratorio;    
    
    private String nombreEspecialidad;

    /**
     * @return the nombreEspecialidad
     */
    public String getNombreEspecialidad() {
        return nombreEspecialidad;
    }

    /**
     * @param nombreEspecialidad the nombreEspecialidad to set
     */
    public void setNombreEspecialidad(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }
    
}
