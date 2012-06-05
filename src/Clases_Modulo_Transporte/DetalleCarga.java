/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Transporte;

import javax.persistence.*;

@Entity
@Table(name="DetalleCarga")

public class DetalleCarga {
    
@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idDetalleCarga;    
    
@ManyToOne(targetEntity = TipoCombustible.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private TipoCombustible tipoCombustible;

@ManyToOne(targetEntity = CargaCombustible.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private CargaCombustible cargaCombustible;

    private int litrosCargados;
    private double precioPorLitro;


    /**
     * @return the litrosCargados
     */
    public int getLitrosCargados() {
        return litrosCargados;
    }

    /**
     * @param litrosCargados the litrosCargados to set
     */
    public void setLitrosCargados(int litrosCargados) {
        this.litrosCargados = litrosCargados;
    }

    /**
     * @return the precioPorLitro
     */
    public double getPrecioPorLitro() {
        return precioPorLitro;
    }

    /**
     * @param precioPorLitro the precioPorLitro to set
     */
    public void setPrecioPorLitro(double precioPorLitro) {
        this.precioPorLitro = precioPorLitro;
    }

    /**
     * @return the tipoCombustible
     */
    public TipoCombustible getTipoCombustible() {
        return tipoCombustible;
    }

    /**
     * @param tipoCombustible the tipoCombustible to set
     */
    public void setTipoCombustible(TipoCombustible tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    /**
     * @return the cargaCombustible
     */
    public CargaCombustible getCargaCombustible() {
        return cargaCombustible;
    }

    /**
     * @param cargaCombustible the cargaCombustible to set
     */
    public void setCargaCombustible(CargaCombustible cargaCombustible) {
        this.cargaCombustible = cargaCombustible;
    }
    
}
