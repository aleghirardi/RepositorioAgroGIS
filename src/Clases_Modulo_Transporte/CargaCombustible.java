/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Transporte;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="CargaCombustible")

public class CargaCombustible {

@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idCargaCombustible;
 
@ManyToOne(targetEntity = DetalleCarga.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
 private DetalleCarga detalle;
    
@ManyToOne(targetEntity = EstacionDeServicio.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )  
 private EstacionDeServicio estacionServicio;

@ManyToOne(targetEntity = OrdenServicio.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
 private OrdenServicio ordenServicio;
  
private String tipoOperacion;
private String producto;
private String fecha;
private String hora;
private double importeTotal;
private String responsableVenta;
 

    /**
     * @return the detalle
     */
    public DetalleCarga getDetalle() {
        return detalle;
    }

    /**
     * @param detalle the detalle to set
     */
    public void setDetalle(DetalleCarga detalle) {
        this.detalle = detalle;
    }

    /**
     * @return the estacionServicio
     */
    public EstacionDeServicio getEstacionServicio() {
        return estacionServicio;
    }

    /**
     * @param estacionServicio the estacionServicio to set
     */
    public void setEstacionServicio(EstacionDeServicio estacionServicio) {
        this.estacionServicio = estacionServicio;
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
    public Double getImporteTotal() {
        return importeTotal;
    }

    /**
     * @param importeTotal the importeTotal to set
     */
    public void setImporteTotal(Double importeTotal) {
        this.importeTotal = importeTotal;
    }

    /**
     * @return the responsableVenta
     */
    public String getResponsableVenta() {
        return responsableVenta;
    }

    /**
     * @param responsableVenta the responsableVenta to set
     */
    public void setResponsableVenta(String responsableVenta) {
        this.responsableVenta = responsableVenta;
    }

    /**
     * @return the tipoOperacion
     */
    public String getTipoOperacion() {
        return tipoOperacion;
    }

    /**
     * @param tipoOperacion the tipoOperacion to set
     */
    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    /**
     * @return the producto
     */
    public String getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(String producto) {
        this.producto = producto;
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
           
   
   
}
