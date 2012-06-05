/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Viaje;

import javax.persistence.*;
import Clases_Modulo_Carga.*;
/**
 *
 * @author ale
 */

@Entity
@Table(name="Semana")

public class Semana {
    
    
    @Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
    private long numeroSemana;  
    
    @ManyToOne(targetEntity = Dia.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
    private Dia diaDesde;
    
    @ManyToOne(targetEntity = Dia.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
    private Dia diaHasta;
    
      
    @ManyToOne(targetEntity = Mes.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
    private Mes mes;
    

    /**
     * @return the mes
     */
    public Mes getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(Mes mes) {
        this.mes = mes;
    }

    /**
     * @return the diaDesde
     */
    public Dia getDiaDesde() {
        return diaDesde;
    }

    /**
     * @param diaDesde the diaDesde to set
     */
    public void setDiaDesde(Dia diaDesde) {
        this.diaDesde = diaDesde;
    }

    /**
     * @return the diaHasta
     */
    public Dia getDiaHasta() {
        return diaHasta;
    }

    /**
     * @param diaHasta the diaHasta to set
     */
    public void setDiaHasta(Dia diaHasta) {
        this.diaHasta = diaHasta;
    }

    
}
