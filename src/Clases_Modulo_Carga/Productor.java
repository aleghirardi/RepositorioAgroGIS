/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Modulo_Carga;

import Clases_Modulo_Transporte.Domicilio;
import Clases_Modulo_Transporte.TipoDocumento;
import Clases_Modulo_Transporte.TipoTelefono;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name="Productor")

public class Productor {

@Id @GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
private long idProductor; 



//@ManyToOne(targetEntity = TipoDocumento.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
//private String tipoDocumento;
//
//@ManyToMany(targetEntity = TipoTelefono.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
//private Set<TipoTelefono> tipoTelefono = new HashSet();
//
//@ManyToOne(targetEntity = Domicilio.class, cascade= CascadeType.ALL, fetch=FetchType.LAZY )
//private Domicilio domicilio;

//private String numeroTelefono;
private String nombre;
private String numeroDocumento;
//private String apellido;
//private String eMail;
//private TipoProductor tipoProductor;
//private CondicionIva condicion;

    /**
     * @return the idProductor
     */
    public long getIdProductor() {
        return idProductor;
    }

    /**
     * @param idProductor the idProductor to set
     */
    public void setIdProductor(long idProductor) {
        this.idProductor = idProductor;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the numeroDocumento
     */
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    /**
     * @param numeroDocumento the numeroDocumento to set
     */
    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    /**
     * @return the establecimiento
     */
  
    
     public String toString(){
        return getNombre();
    }

    /**
     * @return the apellido
     */
//    public String getApellido() {
//        return apellido;
//    }
//
//    /**
//     * @param apellido the apellido to set
//     */
//    public void setApellido(String apellido) {
//        this.apellido = apellido;
//    }
//
//    /**
//     * @return the tipoDocumento
//     */
//    public String getTipoDocumento() {
//        return tipoDocumento;
//    }
//
//    /**
//     * @param tipoDocumento the tipoDocumento to set
//     */
//    public void setTipoDocumento(String tipoDocumento) {
//        this.tipoDocumento = tipoDocumento;
//    }
//
//    /**
//     * @return the eMail
//     */
//    public String geteMail() {
//        return eMail;
//    }
//
//    /**
//     * @param eMail the eMail to set
//     */
//    public void seteMail(String eMail) {
//        this.eMail = eMail;
//    }
//
//      /**
//     * @return the tipoTelefono
//     */
//    public Set<TipoTelefono> getTipoTelefono() {
//        return tipoTelefono;
//    }
//
//    /**
//     * @param tipoTelefono the tipoTelefono to set
//     */
//    public void setTipoTelefono(Set<TipoTelefono> tipoTelefono) {
//        this.tipoTelefono = tipoTelefono;
//    }
//
//    /**
//     * @return the numeroTelefono
//     */
//    public String getNumeroTelefono() {
//        return numeroTelefono;
//    }
//
//    /**
//     * @param numeroTelefono the numeroTelefono to set
//     */
//    public void setNumeroTelefono(String numeroTelefono) {
//        this.numeroTelefono = numeroTelefono;
//    }






}
