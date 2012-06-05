/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Transporte;
import javax.persistence.*;

@Entity
@Table(name="DetalleReparacion")

public class DetalleReparacion {

@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idDetalleReparacion;  
    
@OneToOne(targetEntity = EnvioTaller.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private EnvioTaller envioTaller;  

@OneToOne(targetEntity = OrdenServicio.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
private OrdenServicio orden;

    /**
     * @return the envioTaller
     */
    public EnvioTaller getEnvioTaller() {
        return envioTaller;
    }

    /**
     * @param envioTaller the envioTaller to set
     */
    public void setEnvioTaller(EnvioTaller envioTaller) {
        this.envioTaller = envioTaller;
    }

    /**
     * @return the orden
     */
    public OrdenServicio getOrden() {
        return orden;
    }

    /**
     * @param orden the orden to set
     */
    public void setOrden(OrdenServicio orden) {
        this.orden = orden;
    }
    
    


    
    
}
