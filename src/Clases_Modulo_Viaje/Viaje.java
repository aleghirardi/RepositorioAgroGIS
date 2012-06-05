/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Viaje;

import Clases_Modulo_Carga.*;
import java.sql.Time;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import Clases_Modulo_Transporte.*;
import javax.persistence.*;
/**
 *
 * @author ale
 */

@Entity
@Table(name="Viaje")

public class Viaje {
    
    @Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
    private long idViaje;
    
    @ManyToOne(targetEntity = TipoCereal.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
    private TipoCereal cerealATransportar;
    
    @ManyToOne(targetEntity = Destino.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
    private Destino destino;
    
    @ManyToOne(targetEntity = Estado.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
    private Estado estado;
    
    @ManyToOne(targetEntity = Solicitante.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
    private Solicitante solicitante;
    
    @ManyToOne(targetEntity = TipoViaje.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
    private TipoViaje tipoViaje;
    
    @ManyToOne(targetEntity = Vehiculo.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
    private Vehiculo vehiculo;
    
    private Date fecha;
    private Time hora;

    /**
     * @return the cerealATransportar
     */
    public TipoCereal getCerealATransportar() {
        return cerealATransportar;
    }

    /**
     * @param cerealATransportar the cerealATransportar to set
     */
    public void setCerealATransportar(TipoCereal cerealATransportar) {
        this.cerealATransportar = cerealATransportar;
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
     * @return the estado
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    /**
     * @return the solicitante
     */
    public Solicitante getSolicitante() {
        return solicitante;
    }

    /**
     * @param solicitante the solicitante to set
     */
    public void setSolicitante(Solicitante solicitante) {
        this.solicitante = solicitante;
    }

    /**
     * @return the tipoViaje
     */
    public TipoViaje getTipoViaje() {
        return tipoViaje;
    }

    /**
     * @param tipoViaje the tipoViaje to set
     */
    public void setTipoViaje(TipoViaje tipoViaje) {
        this.tipoViaje = tipoViaje;
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
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the hora
     */
    public Time getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(Time hora) {
        this.hora = hora;
    }

    /**
     * @return the idViaje
     */
    public long getIdViaje() {
        return idViaje;
    }

    /**
     * @param idViaje the idViaje to set
     */
    public void setIdViaje(long idViaje) {
        this.idViaje = idViaje;
    }
    
}
