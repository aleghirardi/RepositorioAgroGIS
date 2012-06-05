/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Viaje;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 *
 * @author ale
 */
import javax.persistence.*;

@Entity
@Table(name="Agenda")

public class Agenda {
    
    @Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
    private long idAgenda;
    
    @ManyToOne(targetEntity = Viaje.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
    private Viaje viaje;
    
    @ManyToOne(targetEntity = Semana.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
    private Semana semana;
    
    @ManyToOne(targetEntity = Dia.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
    private Dia dia;
    
    @ManyToOne(targetEntity = Anio.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
    private Anio anio;

    /**
     * @return the viaje
     */
    public Viaje getViaje() {
        return viaje;
    }

    /**
     * @param viaje the viaje to set
     */
    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
    }

    /**
     * @return the semana
     */
    public Semana getSemana() {
        return semana;
    }

    /**
     * @param semana the semana to set
     */
    public void setSemana(Semana semana) {
        this.semana = semana;
    }

    /**
     * @return the dia
     */
    public Dia getDia() {
        return dia;
    }

    /**
     * @param dia the dia to set
     */
    public void setDia(Dia dia) {
        this.dia = dia;
    }

    /**
     * @return the anio
     */
    public Anio getAnio() {
        return anio;
    }

    /**
     * @param anio the anio to set
     */
    public void setAnio(Anio anio) {
        this.anio = anio;
    }
}
