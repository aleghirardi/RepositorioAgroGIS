/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Carga;

import Clases_Modulo_Transporte.Estado;

import javax.persistence.*;

@Entity
@Table(name="SolicitudRetiro")

public class SolicitudRetiro {
    
@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long numeroSolicitud;    

@ManyToOne(targetEntity = HistorialProductor.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private HistorialProductor datosDescarga;

@ManyToOne(targetEntity = Destino.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Destino destino;
    
//@ManyToOne(targetEntity = Estado.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
//private Estado estado;   
    
@ManyToOne(targetEntity = Productor.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Productor productor;

@ManyToOne(targetEntity = Silo.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Silo silo;

@ManyToOne(targetEntity = TipoOperacion.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private TipoOperacion operacion; 
    
    
    private String toneladasAExtraer;
    private String estado;
    private String fechaSolicitud;
    /**
     * @return the datosDescarga
     */
    public HistorialProductor getDatosDescarga() {
        return datosDescarga;
    }

    /**
     * @param datosDescarga the datosDescarga to set
     */
    public void setDatosDescarga(HistorialProductor datosDescarga) {
        this.datosDescarga = datosDescarga;
    }

    /**
     * @return the destino
     */
    public Destino getDestino() {
        return destino;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(Destino destino) {
        this.destino = destino;
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
     * @return the silo
     */
    public Silo getSilo() {
        return silo;
    }

    /**
     * @param silo the silo to set
     */
    public void setSilo(Silo silo) {
        this.silo = silo;
    }

    /**
     * @return the operacion
     */
    public TipoOperacion getOperacion() {
        return operacion;
    }

    /**
     * @param operacion the operacion to set
     */
    public void setOperacion(TipoOperacion operacion) {
        this.operacion = operacion;
    }

    

    /**
     * @return the toneladasAExtraer
     */
    public String getToneladasAExtraer() {
        return toneladasAExtraer;
    }

    /**
     * @param toneladasAExtraer the toneladasAExtraer to set
     */
    public void setToneladasAExtraer(String toneladasAExtraer) {
        this.toneladasAExtraer = toneladasAExtraer;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the numeroSolicitud
     */
    public long getNumeroSolicitud() {
        return numeroSolicitud;
    }

    /**
     * @param numeroSolicitud the numeroSolicitud to set
     */
    public void setNumeroSolicitud(long numeroSolicitud) {
        this.numeroSolicitud = numeroSolicitud;
    }

    /**
     * @return the fechaSolicitud
     */
    public String getFechaSolicitud() {
        return fechaSolicitud;
    }

    /**
     * @param fechaSolicitud the fechaSolicitud to set
     */
    public void setFechaSolicitud(String fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }
}
