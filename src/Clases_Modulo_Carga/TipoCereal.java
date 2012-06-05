/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Carga;


import javax.persistence.*;

@Entity
@Table(name="TipoCereal")

public class TipoCereal {
    
@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idTipoCereal;    
   
    private String nombreCereal;

@ManyToOne(targetEntity = Temporada.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private TipoTemporada temporadaCosecha;

@ManyToOne(targetEntity = Temporada.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private TipoTemporada temporadaSiembra;
    
@ManyToOne(targetEntity = CaracteristicasCereal.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private CaracteristicasCereal caracteristicas;

    /**
     * @return the nombreCereal
     */
    public String getNombreCereal() {
        return nombreCereal;
    }

    /**
     * @param nombreCereal the nombreCereal to set
     */
    public void setNombreCereal(String nombreCereal) {
        this.nombreCereal = nombreCereal;
    }

    /**
     * @return the temporadaCosecha
     */
    public TipoTemporada getTemporadaCosecha() {
        return temporadaCosecha;
    }

    /**
     * @param temporadaCosecha the temporadaCosecha to set
     */
    public void setTemporadaCosecha(TipoTemporada temporadaCosecha) {
        this.temporadaCosecha = temporadaCosecha;
    }

    /**
     * @return the temporadaSiembra
     */
    public TipoTemporada getTemporadaSiembra() {
        return temporadaSiembra;
    }

    /**
     * @param temporadaSiembra the temporadaSiembra to set
     */
    public void setTemporadaSiembra(TipoTemporada temporadaSiembra) {
        this.temporadaSiembra = temporadaSiembra;
    }

    /**
     * @return the caracteristicas
     */
    public CaracteristicasCereal getCaracteristicas() {
        return caracteristicas;
    }

    /**
     * @param caracteristicas the caracteristicas to set
     */
    public void setCaracteristicas(CaracteristicasCereal caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    
    
}
