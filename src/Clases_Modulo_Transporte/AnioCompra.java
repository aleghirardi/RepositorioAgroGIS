/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Transporte;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="AnioCompra")


public class AnioCompra {
@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idAnio;
    
    
  //Atributos 
  private String anioCompra;

    /**
     * @return the anioCompra
     */
    public String getAnioCompra() {
        return anioCompra;
    }

    /**
     * @param anioCompra the anioCompra to set
     */
    public void setAnioCompra(String anioCompra) {
        this.anioCompra = anioCompra;
    }
}
