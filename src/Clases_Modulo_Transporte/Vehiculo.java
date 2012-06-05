/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Transporte;

import javax.persistence.*;

@Entity
@Table(name="Vehiculo")


public class Vehiculo {
    
@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idVehiculo;

@ManyToOne(targetEntity = AnioCompra.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private AnioCompra anioCompra;
    
@ManyToOne(targetEntity = Estado.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Estado estado;    

@ManyToOne(targetEntity = Modelo.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Modelo modelo; 

@ManyToOne(targetEntity = TipoVehiculo.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private TipoVehiculo tipoVehiculo;    

@ManyToOne(targetEntity = Transportista.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Transportista transportista;    


    private double ancho;
    private double cantidadKms;
    private String dominio;
    private double largo;
    private double tara;
    private double carga;


    /**
     * @return the ancho
     */
    public double getAncho() {
        return ancho;
    }

    /**
     * @param ancho the ancho to set
     */
    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    /**
     * @return the anioCompra
     */
    public AnioCompra getAnioCompra() {
        return anioCompra;
    }

    /**
     * @param anioCompra the anioCompra to set
     */
    public void setAnioCompra(AnioCompra anioCompra) {
        this.anioCompra = anioCompra;
    }

    /**
     * @return the cantidadKms
     */
    public double getCantidadKms() {
        return cantidadKms;
    }

    /**
     * @param cantidadKms the cantidadKms to set
     */
    public void setCantidadKms(double cantidadKms) {
        this.cantidadKms = cantidadKms;
    }

    /**
     * @return the dominio
     */
    public String getDominio() {
        return dominio;
    }

    /**
     * @param dominio the dominio to set
     */
    public void setDominio(String dominio) {
        this.dominio = dominio;
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
     * @return the largo
     */
    public double getLargo() {
        return largo;
    }

    /**
     * @param largo the largo to set
     */
    public void setLargo(double largo) {
        this.largo = largo;
    }

    /**
     * @return the marca
     */
    

    /**
     * @return the tara
     */
    public double getTara() {
        return tara;
    }

    /**
     * @param tara the tara to set
     */
    public void setTara(double tara) {
        this.tara = tara;
    }

    /**
     * @return the tipoVehiculo
     */
    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    /**
     * @param tipoVehiculo the tipoVehiculo to set
     */
    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    /**
     * @return the idVehiculo
     */
    public long getIdVehiculo() {
        return idVehiculo;
    }

    /**
     * @param idVehiculo the idVehiculo to set
     */
    public void setIdVehiculo(long idVehiculo) {
        this.idVehiculo = idVehiculo;
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
     * @return the modelo
     */
    public Modelo getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the carga
     */
    public double getCarga() {
        return carga;
    }

    /**
     * @param carga the carga to set
     */
    public void setCarga(double carga) {
        this.carga = carga;
    }
}
