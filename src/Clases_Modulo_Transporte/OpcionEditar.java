/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Transporte;

import javax.persistence.*;

@Entity
@Table(name="OpcionEditar")



public class OpcionEditar {
    
    @Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
    private long idOpcion;  
    
    private int editar=0;

    /**
     * @return the editar
     */
    public int getEditar() {
        return editar;
    }

    /**
     * @param editar the editar to set
     */
    public void setEditar(int editar) {
        this.editar = editar;
    }
}
