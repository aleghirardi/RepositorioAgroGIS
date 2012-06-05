/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Transporte;

import javax.persistence.*;

@Entity
@Table(name="Producto")

public class Producto {

@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idProducto;  

@ManyToOne(targetEntity = TipoServicio.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private TipoServicio tipo;

private String nombreProducto;

    /**
     * @return the idProducto
     */
    public long getIdProducto() {
        return idProducto;
    }

    /**
     * @param idProducto the idProducto to set
     */
    public void setIdProducto(long idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * @return the tipo
     */
    public TipoServicio getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(TipoServicio tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the nombreProducto
     */
    public String getNombreProducto() {
        return nombreProducto;
    }

    /**
     * @param nombreProducto the nombreProducto to set
     */
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }


    public String toString(){
        return getNombreProducto();
    }




}
