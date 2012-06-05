/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Carga;

import Clases_Modulo_Transporte.Transportista;

import javax.persistence.*;

@Entity
@Table(name="Descarga")

public class Descarga {
    
@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long numeroMuestraTomada;;    
    
@ManyToOne(targetEntity = Silo.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Silo silo;

@ManyToOne(targetEntity = TipoTemporada.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private TipoTemporada temporada;

@ManyToOne(targetEntity = TipoCereal.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private TipoCereal cereal;

@ManyToOne(targetEntity = Transportista.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Transportista transportista;

@ManyToOne(targetEntity = Productor.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Productor productor;

    private String fecha;
    private String hora; 
    private double toneladas;
    

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
     * @return the numeroMuestraTomada
     */
    public long getNumeroMuestraTomada() {
        return numeroMuestraTomada;
    }

    /**
     * @param numeroMuestraTomada the numeroMuestraTomada to set
     */
    public void setNumeroMuestraTomada(int numeroMuestraTomada) {
        this.numeroMuestraTomada = numeroMuestraTomada;
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
     * @return the temporada
     */
    public TipoTemporada getTemporada() {
        return temporada;
    }

    /**
     * @param temporada the temporada to set
     */
    public void setTemporada(TipoTemporada temporada) {
        this.temporada = temporada;
    }

    /**
     * @return the cereal
     */
    public TipoCereal getCereal() {
        return cereal;
    }

    /**
     * @param cereal the cereal to set
     */
    public void setCereal(TipoCereal cereal) {
        this.cereal = cereal;
    }

    /**
     * @return the toneladas
     */
    public double getToneladas() {
        return toneladas;
    }

    /**
     * @param toneladas the toneladas to set
     */
    public void setToneladas(double toneladas) {
        this.toneladas = toneladas;
    }

    /**
     * @return the transportista
     */
    public Transportista getTransportista() {
        return transportista;
    }

    /**
     * @param transportista the transportista to set
     */
    public void setTransportista(Transportista transportista) {
        this.transportista = transportista;
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
    
}
