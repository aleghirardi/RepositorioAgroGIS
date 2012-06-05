/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Carga;

import javax.persistence.*;

@Entity
@Table(name="Temporada")

public class Temporada {
 
@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idTemporada;  


@ManyToOne(targetEntity = Mes.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Mes mesDesde;

@ManyToOne(targetEntity = Mes.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private Mes mesHasta;


    /**
     * @return the idTemporada
     */
    public long getIdTemporada() {
        return idTemporada;
    }

    /**
     * @param idTemporada the idTemporada to set
     */
    public void setIdTemporada(long idTemporada) {
        this.idTemporada = idTemporada;
    }

    /**
     * @return the mesDesde
     */
    public Mes getMesDesde() {
        return mesDesde;
    }

    /**
     * @param mesDesde the mesDesde to set
     */
    public void setMesDesde(Mes mesDesde) {
        this.mesDesde = mesDesde;
    }

    /**
     * @return the mesHasta
     */
    public Mes getMesHasta() {
        return mesHasta;
    }

    /**
     * @param mesHasta the mesHasta to set
     */
    public void setMesHasta(Mes mesHasta) {
        this.mesHasta = mesHasta;
    }

   

    

}
