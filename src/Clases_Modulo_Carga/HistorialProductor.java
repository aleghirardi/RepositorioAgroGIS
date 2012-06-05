/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Carga;

import javax.persistence.*;

@Entity
@Table(name="HistorialProductor")

public class HistorialProductor {

@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idHistorial;    
    
@ManyToOne(targetEntity = Descarga.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Descarga descarga;

@ManyToOne(targetEntity = Productor.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Productor productor;

@ManyToOne(targetEntity = SolicitudRetiro.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private SolicitudRetiro solicitud;

private double toneladasDisponibles;

    /**
     * @return the descarga
     */
    public Descarga getDescarga() {
        return descarga;
    }

    /**
     * @param descarga the descarga to set
     */
    public void setDescarga(Descarga descarga) {
        this.descarga = descarga;
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

    /**
     * @return the solicitud
     */
    public SolicitudRetiro getSolicitud() {
        return solicitud;
    }

    /**
     * @param solicitud the solicitud to set
     */
    public void setSolicitud(SolicitudRetiro solicitud) {
        this.solicitud = solicitud;
    }

    /**
     * @return the toneladasDisponibles
     */
    public double getToneladasDisponibles() {
        return toneladasDisponibles;
    }

    /**
     * @param toneladasDisponibles the toneladasDisponibles to set
     */
    public void setToneladasDisponibles(double toneladasDisponibles) {
        this.toneladasDisponibles = toneladasDisponibles;
    }
}
