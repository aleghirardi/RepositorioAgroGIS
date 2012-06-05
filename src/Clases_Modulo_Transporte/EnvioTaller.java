/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Transporte;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="EnvioTaller")

public class EnvioTaller {

@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idEnvio;  

@ManyToOne(targetEntity = DetalleEnvio.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private DetalleEnvio detalle;
    
@ManyToOne(targetEntity = Motivo.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Motivo motivo;

@ManyToOne(targetEntity = TallerReparacion.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private TallerReparacion taller;


private String fecha;
private String hora;
private double importeTotal;
private String responsable;

    /**
     * @return the detalle
     */
    public DetalleEnvio getDetalle() {
        return detalle;
    }

    /**
     * @param detalle the detalle to set
     */
    public void setDetalle(DetalleEnvio detalle) {
        this.detalle = detalle;
    }

    /**
     * @return the motivo
     */
    public Motivo getMotivo() {
        return motivo;
    }

    /**
     * @param motivo the motivo to set
     */
    public void setMotivo(Motivo motivo) {
        this.motivo = motivo;
    }

    /**
     * @return the taller
     */
    public TallerReparacion getTaller() {
        return taller;
    }

    /**
     * @param taller the taller to set
     */
    public void setTaller(TallerReparacion taller) {
        this.taller = taller;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * @return the importeTotal
     */
    public double getImporteTotal() {
        return importeTotal;
    }

    /**
     * @param importeTotal the importeTotal to set
     */
    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }

    /**
     * @return the responsable
     */
    public String getResponsable() {
        return responsable;
    }

    /**
     * @param responsable the responsable to set
     */
    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }
    

   
           
}
