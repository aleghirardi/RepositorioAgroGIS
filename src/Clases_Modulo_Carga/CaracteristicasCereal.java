/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Carga;


import javax.persistence.*;

@Entity
@Table(name="CaracteristicasCereal")

public class CaracteristicasCereal { 
    
@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idCaracteristicasCereal;    
    
private String nombreCaracteristica;
private double valorDesde;
private double valorHasta;

    /**
     * @return the nombreCaracteristica
     */
    public String getNombreCaracteristica() {
        return nombreCaracteristica;
    }

    /**
     * @param nombreCaracteristica the nombreCaracteristica to set
     */
    public void setNombreCaracteristica(String nombreCaracteristica) {
        this.nombreCaracteristica = nombreCaracteristica;
    }

    /**
     * @return the valorDesde
     */
    public double getValorDesde() {
        return valorDesde;
    }

    /**
     * @param valorDesde the valorDesde to set
     */
    public void setValorDesde(double valorDesde) {
        this.valorDesde = valorDesde;
    }

    /**
     * @return the valorHasta
     */
    public double getValorHasta() {
        return valorHasta;
    }

    /**
     * @param valorHasta the valorHasta to set
     */
    public void setValorHasta(double valorHasta) {
        this.valorHasta = valorHasta;
    }

}
