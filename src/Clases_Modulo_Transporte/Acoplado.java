/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Transporte;

import javax.persistence.*;

@Entity
@Table(name="Acoplado")

public class Acoplado {
    
@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idAcoplado;

@ManyToOne(targetEntity = AnioCompra.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private AnioCompra anioCompra;
    
@ManyToOne(targetEntity = Estado.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Estado estado;    

@ManyToOne(targetEntity = Marca.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Marca marca; 


@OneToOne(targetEntity = Vehiculo.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Vehiculo vehiculo; 

    private double ancho;
    private String dominio;
    private double largo;
    private double tara;

    /**
     * @return the idAcoplado
     */
    public long getIdAcoplado() {
        return idAcoplado;
    }

    /**
     * @param idAcoplado the idAcoplado to set
     */
    public void setIdAcoplado(long idAcoplado) {
        this.idAcoplado = idAcoplado;
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
     * @return the marca
     */
    public Marca getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(Marca marca) {
        this.marca = marca;
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
    
    
}
