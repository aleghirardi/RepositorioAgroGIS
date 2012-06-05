/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Transporte;

import javax.persistence.*;

@Entity
@Table(name="DetalleConsumo")

public class DetalleConsumo {

@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idDetalleConsumo;

@OneToOne(targetEntity = OrdenServicio.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private OrdenServicio ordenServicio;

@OneToOne(targetEntity = CargaCombustible.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private CargaCombustible cargaCombustible;

    /**
     * @return the idDetalleConsumo
     */
    public long getIdDetalleConsumo() {
        return idDetalleConsumo;
    }

    /**
     * @param idDetalleConsumo the idDetalleConsumo to set
     */
    public void setIdDetalleConsumo(long idDetalleConsumo) {
        this.idDetalleConsumo = idDetalleConsumo;
    }

    /**
     * @return the ordenServicio
     */
    public OrdenServicio getOrdenServicio() {
        return ordenServicio;
    }

    /**
     * @param ordenServicio the ordenServicio to set
     */
    public void setOrdenServicio(OrdenServicio ordenServicio) {
        this.ordenServicio = ordenServicio;
    }

    /**
     * @return the cargaCombustible
     */
    public CargaCombustible getCargaCombustible() {
        return cargaCombustible;
    }

    /**
     * @param cargaCombustible the cargaCombustible to set
     */
    public void setCargaCombustible(CargaCombustible cargaCombustible) {
        this.cargaCombustible = cargaCombustible;
    }
        
      
}
