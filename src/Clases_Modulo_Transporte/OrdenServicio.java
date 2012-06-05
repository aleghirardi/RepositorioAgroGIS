/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Transporte;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="OrdenServicio")

public class OrdenServicio {

@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
 private int numeroOrden;

//@ManyToOne(targetEntity = Estado.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
//private Estado estado;

@ManyToOne(targetEntity = TipoServicio.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private TipoServicio tipoServicio;

@ManyToOne(targetEntity = Vehiculo.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Vehiculo vehiculo;

@ManyToOne(targetEntity = EstacionDeServicio.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private EstacionDeServicio estacionServicio;

    private String fecha;
    private String hora;
    private String responsable;
    private String estado;
   
   

    /**
     * @return the estado
//     */
//    public Estado getEstado() {
//        return estado;
//    }
//
//    /**
//     * @param estado the estado to set
//     */
//    public void setEstado(Estado estado) {
//        this.estado = estado;
//    }

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
     * @return the numeroOrden
     */
    public int getNumeroOrden() {
        return numeroOrden;
    }

    /**
     * @param numeroOrden the numeroOrden to set
     */
    public void setNumeroOrden(int numeroOrden) {
        this.numeroOrden = numeroOrden;
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

    /**
     * @return the tipoServicio
     */
    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }

    /**
     * @param tipoServicio the tipoServicio to set
     */
    public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
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
     * @return the transportista
     */
    
}
