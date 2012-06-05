/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Carga;

import Clases_Modulo_Transporte.Vehiculo;

import javax.persistence.*;

@Entity
@Table(name="Retiro")

public class Retiro {
@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idRetiro; 

@ManyToOne(targetEntity = SolicitudRetiro.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private SolicitudRetiro solicitud;
   
@ManyToOne(targetEntity = Vehiculo.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )    
private Vehiculo vehiculo;
    
private double pesoTotal;
private double pesoNeto;

    /**
     * @return the idRetiro
     */
    public long getIdRetiro() {
        return idRetiro;
    }

    /**
     * @param idRetiro the idRetiro to set
     */
    public void setIdRetiro(long idRetiro) {
        this.idRetiro = idRetiro;
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
     * @return the vehiculo
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     * @param vehiculo the vehiculo to set
     */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * @return the pesoTotal
     */
    public double getPesoTotal() {
        return pesoTotal;
    }

    /**
     * @param pesoTotal the pesoTotal to set
     */
    public void setPesoTotal(double pesoTotal) {
        this.pesoTotal = pesoTotal;
    }

    /**
     * @return the pesoNeto
     */
    public double getPesoNeto() {
        return pesoNeto;
    }

    /**
     * @param pesoNeto the pesoNeto to set
     */
    public void setPesoNeto(double pesoNeto) {
        this.pesoNeto = pesoNeto;
    }
    
    
    
    
   
}
