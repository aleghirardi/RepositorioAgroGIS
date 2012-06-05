/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores_Vista;

import Clases_Modulo_Transporte.*;
import Hibernate.GestorHibernate;
import java.util.Iterator;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Charito
 */
public class gestorRegistroTransportista extends GestorHibernate{ 
   
     public DefaultComboBoxModel rellenaCombo(String seleccion){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(Provincia.class).iterator();
       while(ite.hasNext()){
           Provincia provincia =(Provincia) ite.next();
           Pais pais = provincia.getPais();
           if (pais.getNombrePais().equals(seleccion)){
               modelo.addElement(provincia);
           }
       }
       
       return modelo;
   }
     
    public DefaultComboBoxModel rellenaComboDepartamento(String seleccion){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(Departamento.class).iterator();
       while(ite.hasNext()){
           Departamento departamento =(Departamento) ite.next();
           Provincia provincia = departamento.getProvincia();
           if (provincia.getNombreProvincia().equals(seleccion)){
               modelo.addElement(departamento);
           }
       }
       
       return modelo;
   }  
    
    public DefaultComboBoxModel rellenaComboLocalidad(String seleccion){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(Localidad.class).iterator();
       while(ite.hasNext()){
           Localidad localidad =(Localidad) ite.next();
           Departamento departamento = localidad.getDepartamento();
           if (departamento.getNombreDepartamento().equals(seleccion)){
               modelo.addElement(localidad);
           }
       }
       
       return modelo;
   } 
    
    public DefaultComboBoxModel rellenaComboBarrio(String seleccion){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(Barrio.class).iterator();
       while(ite.hasNext()){
           Barrio barrio =(Barrio) ite.next();
           Localidad localidad = barrio.getLocalidad();
           if (localidad.getNombreLocalidad().equals(seleccion)){
               modelo.addElement(barrio);
           }
       }
       
       return modelo;
   } 
    
//   public DefaultTableModel rellenaTablaVehiculo (String documento, JTable tabla){
//       DefaultTableModel modeloT = new DefaultTableModel();
//       Iterator ite = this.listarClase(Vehiculo.class).iterator();
//       while(ite.hasNext()){
//           Vehiculo vehiculo =(Vehiculo) ite.next();
//           Transportista transportista = vehiculo.getTransportista();
//           if (transportista.getNumeroDocumento().equals(documento)){
//               Iterator ite2= this.listarClase(Modelo.class).iterator();
//               while(ite.hasNext()){
//               Modelo modelo = (Modelo) ite2.next();
//               Marca marca = modelo.getMarca();
//               if(marca.equals(vehiculo.getMarca())){
//                    Object fila[]={vehiculo.getDominio(), vehiculo.getMarca(),modelo};
//                    modeloT.addRow(fila);
//                    tabla.setModel(modeloT);
//               }
//              }
//           }
//       }
//       
//       return modeloT;
//   }  
    
    public void deshabilitarCombo(JComboBox combo1, JComboBox combo2, JComboBox combo3, 
            JComboBox combo4, JComboBox combo5, JComboBox combo6){
        combo1.setEnabled(false);
        combo2.setEnabled(false);
        combo3.setEnabled(false);
        combo4.setEnabled(false);
        combo5.setEnabled(false);
        combo6.setEnabled(false);   
//        boton.setEnabled(false);
    }
    
    public void deshabilitarTxt(JTextField txt1, JTextField txt2, JTextField txt3, JTextField txt4, JTextField txt5,
                                JTextField txt6, JTextField txt7, JTextField txt8, JTextField txt9, JTextField txt10){
        
        txt1.setEnabled(false);
        txt2.setEnabled(false);
        txt3.setEnabled(false);
        txt4.setEnabled(false);
        txt5.setEnabled(false);
        txt6.setEnabled(false);
        txt7.setEnabled(false);
        txt8.setEnabled(false);
        txt9.setEnabled(false);
        txt10.setEnabled(false);
        
    }
    
    public void habilitar(JTextField txt1, JTextField txt2, JTextField txt3, JTextField txt4, JTextField txt5,
                           JComboBox combo1, JComboBox combo2, JComboBox combo3){
        txt1.setEnabled(true);
        txt2.setEnabled(true);
        txt3.setEnabled(true);
        txt4.setEnabled(true);
        txt5.setEnabled(true);
        combo1.setEnabled(true);
        combo2.setEnabled(true);
        combo3.setEnabled(true);    
    }
    
    public void deshabilitar(JTextField txt1, JTextField txt2, JTextField txt3, JTextField txt4, JTextField txt5,
                           JComboBox combo1, JComboBox combo2, JComboBox combo3){
        txt1.setEnabled(false);
        txt2.setEnabled(false);
        txt3.setEnabled(false);
        txt4.setEnabled(false);
        txt5.setEnabled(false);
        combo1.setEnabled(false);
        combo2.setEnabled(false);
        combo3.setEnabled(false);

    }
    
       public Vehiculo editar(String dominio){
       Iterator ite = this.listarClase(Vehiculo.class).iterator();
       Vehiculo vehiculo = new Vehiculo();
       while(ite.hasNext()){
           vehiculo = (Vehiculo) ite.next();
           if(vehiculo.getDominio().equals(dominio)){
                break;
           }
           }
       return vehiculo;
    }
    
       public Modelo buscarModelo(Marca marca){
        Iterator ite = this.listarClase(Modelo.class).iterator();
        Modelo modelo = new Modelo();
        while(ite.hasNext()){
            modelo = (Modelo) ite.next();
            if(modelo.getMarca().equals(marca)){
                break;
            }
        }
        return modelo;
    }
       
       public DefaultComboBoxModel rellenaComboTipoDoc(){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(TipoDocumento.class).iterator();
       while(ite.hasNext()){
           TipoDocumento tipoDoc =(TipoDocumento) ite.next();
               modelo.addElement(tipoDoc);
           }

       return modelo;
   }
       
       
        public DefaultComboBoxModel rellenaComboModelo(String seleccion){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(Modelo.class).iterator();
       while(ite.hasNext()){
           Modelo mod =(Modelo) ite.next();
           Marca marca = mod.getMarca();
           if (marca.getNombreMarca().equals(seleccion)){
               modelo.addElement(mod);
           }
       }

       return modelo;
   }
        
      public DefaultComboBoxModel rellenaComboMarca(){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(Marca.class).iterator();
       while(ite.hasNext()){
           Marca marca =(Marca) ite.next();
               modelo.addElement(marca);
           }

       return modelo;
   }
      
      public DefaultComboBoxModel rellenaComboAnio(){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(AnioCompra.class).iterator();
       while(ite.hasNext()){
           AnioCompra anio =(AnioCompra) ite.next();
               modelo.addElement(anio);
           }

       return modelo;
   }
      
      public DefaultComboBoxModel rellenaComboTipoTel(){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(TipoTelefono.class).iterator();
       while(ite.hasNext()){
           TipoTelefono tipoTel =(TipoTelefono) ite.next();
               modelo.addElement(tipoTel);
           }

       return modelo;
   } 
      
      public DefaultComboBoxModel rellenaComboTipoContratacion(){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(CondicionContratacion.class).iterator();
       while(ite.hasNext()){
           CondicionContratacion condicion =(CondicionContratacion) ite.next();
               modelo.addElement(condicion);
           }

       return modelo;
   }    
      
      public DefaultComboBoxModel rellenaComboTransportista(){
       DefaultComboBoxModel modelo = new DefaultComboBoxModel();
       Iterator ite = this.listarClase(Transportista.class).iterator();
       while(ite.hasNext()){
           Transportista transportista =(Transportista) ite.next();
               modelo.addElement(transportista);
           }

       return modelo;
   }    
      
      
      
 
}
