/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Transporte;

import javax.persistence.*;

@Entity
@Table(name="DetalleEnvio")

public class DetalleEnvio {

@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idDetalleEnvio;  
    
@ManyToOne(targetEntity = ArregloEfectuado.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private ArregloEfectuado arregloEfectuado;
    
   
private double precio;

  
    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @return the arregloEfectuado
     */
    public ArregloEfectuado getArregloEfectuado() {
        return arregloEfectuado;
    }

    /**
     * @param arregloEfectuado the arregloEfectuado to set
     */
    public void setArregloEfectuado(ArregloEfectuado arregloEfectuado) {
        this.arregloEfectuado = arregloEfectuado;
    }
    
}
