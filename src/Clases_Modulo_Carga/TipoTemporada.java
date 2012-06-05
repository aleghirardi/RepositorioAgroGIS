/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Carga;

import javax.persistence.*;

@Entity
@Table(name="TipoTemporada")

public class TipoTemporada {
    
@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idTipoTemporada;   
    
    private String nombreTipoTemporada;

@ManyToOne(targetEntity = Temporada.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Temporada temporada;

    /**
     * @return the nombreTipoTemporada
     */
    public String getNombreTipoTemporada() {
        return nombreTipoTemporada;
    }

    /**
     * @param nombreTipoTemporada the nombreTipoTemporada to set
     */
    public void setNombreTipoTemporada(String nombreTipoTemporada) {
        this.nombreTipoTemporada = nombreTipoTemporada;
    }

    /**
     * @return the temporada
     */
    public Temporada getTemporada() {
        return temporada;
    }

    /**
     * @param temporada the temporada to set
     */
    public void setTemporada(Temporada temporada) {
        this.temporada = temporada;
    }
}
