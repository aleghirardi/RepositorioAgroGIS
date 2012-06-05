/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Hibernate;
import java.awt.Component;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;


public class GestorHibernate extends HibernateUtil {
/**
     * Elimina un objeto del repositorio
     * @param objeto Objeto a eliminar
     */
private Transaction tx;
    public void eliminarObjeto(Object objeto){
         try{
            Session s = HibernateUtil.getSession();
            Transaction tx = s.beginTransaction();
            s.delete(objeto);
            tx.commit();
               } catch(Exception ex){
                System.out.println("Repositorio.eliminarObjeto(Object objeto)"+ex);
            ex.printStackTrace();
                JOptionPane.showMessageDialog((Component)null,"El elemento no se puede eliminar:"+ex.getMessage(),"Error",0);
                getTx().rollback();
            }
    }
 public void guardarObjeto(Object objeto){
        try{
        Session s = HibernateUtil.getSession();
        Transaction tx = s.beginTransaction();
        s.save(objeto);
        tx.commit();
        } catch(Exception ex){
            System.out.println("error "+ex);
            System.out.println("Repositorio.guardarObjeto(Object objeto)"+objeto.getClass()+": "+objeto.toString()+ex);
            ex.printStackTrace();
            getTx().rollback();
        }
    }
/**
     * Actualiza un objeto en el repositorio
     * @param objeto Objeto a actualizar
     */

    public void actualizarObjeto(Object objeto){
        try{
            Session s = HibernateUtil.getSession();
            Transaction tx = s.beginTransaction();
            s.update(objeto);
            tx.commit();

            System.out.println(" actualizarObjeto() " +objeto.getClass()+": "+objeto.toString());
            } catch(Exception ex){
            System.out.println("Repositorio.actualizarObjeto(Object objeto)"+ex);
           }
    }


    public Transaction getTx() {
        return tx;
    }

    public void setTx(Transaction tx) {
        this.tx = tx;
    }

    public List listarClase(Class clase){
        Criteria crit = getSession().createCriteria(clase);
        return crit.list();
    }


    public List listarClaseFitradaPorString(Class clase,String campo,String texto){
        Criteria crit = getSession().createCriteria(clase)
            .add( Restrictions.like(campo, texto+"%") );
        return crit.list();
    }


    public List listarClaseFitradaPorInteger(Class clase,String campo,int valor){

         Criteria crit = getSession().createCriteria(clase)
                 .add( Restrictions.idEq(valor));
    return crit.list();
}

    public List listarClaseFitradaPorLong(Class clase,String campo,long valor){
         Criteria crit = getSession().createCriteria(clase)
                 .add( Restrictions.idEq(valor));
    return crit.list();
}

    public List listarClaseFitradaPorObjeto(Class clase,String campo,Object objeto){

         Criteria crit = getSession().createCriteria(clase)
                 .add( Restrictions.eq(campo, objeto) );
    return crit.list();
}

    public List listarClaseFitradaPorObjetoPorString(Class clase,String campo,Object objeto,String campo2,String valor){

         Criteria crit = getSession().createCriteria(clase)
                 .add( Restrictions.eq(campo, objeto))
                 .add(Restrictions.like(campo2, valor));

    return crit.list();
}
//agrego sole 08/11/2008
    public List listarClaseOrdenada(Class clase,String atributoOrden){
        Criteria crit = getSession().createCriteria(clase)
        .addOrder(Order.asc(atributoOrden));
        return crit.list();
    }
    //agrego sole 05112008
    public List listarClaseFitradaPorStringOrdenada(Class clase,String campo,String texto,String campoOrden){
        Criteria crit = getSession().createCriteria(clase)
            .add( Restrictions.like(campo, texto+"%"))
            .addOrder(Order.asc(campoOrden));
        return crit.list();
    }
    public List listarClaseFitradaPorObjetoPorInteger(Class clase,String campo,Object objeto,String campo2,int valor){

         Criteria crit = getSession().createCriteria(clase)
                 .add( Restrictions.eq(campo, objeto))
                 .add(Restrictions.eq(campo2,valor));

    return crit.list();
    }

} 
 
