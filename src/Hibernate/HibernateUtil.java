
package Hibernate;
//librerias de hibernate annotaciones
import org.hibernate.*;
import org.hibernate.cfg.*;

public class HibernateUtil {
    public static SessionFactory sessionFactory;
    public static Session session;
    public static void inicializar() {
        try {
            AnnotationConfiguration conf = new AnnotationConfiguration();
            
                conf.setProperty("hibernate.connection.driver_class","org.postgresql.Driver");
                conf.setProperty("hibernate.dialect","org.hibernate.dialect.PostgreSQLDialect");                
                conf.setProperty("hibernate.connection.url","jdbc:postgresql://localhost:5432/AgroGIS");
                conf.setProperty("hibernate.connection.username","postgres");
                conf.setProperty("hibernate.connection.password","postgres");
                conf.setProperty("hibernate.connection.pool_size","10");                
                conf.setProperty("show_sql","true");
                conf.setProperty("hibernate.hbm2ddl.auto","update");
            
            //carga de paquetes
                conf.addPackage("Hibernate");
                
                conf.addPackage("Clases_Modulo_transporte");
                conf.addAnnotatedClass(Clases_Modulo_Transporte.Acoplado.class);
                conf.addAnnotatedClass(Clases_Modulo_Transporte.Ambito.class);
                conf.addAnnotatedClass(Clases_Modulo_Transporte.AnioCompra.class);
                conf.addAnnotatedClass(Clases_Modulo_Transporte.ArregloEfectuado.class);
                conf.addAnnotatedClass(Clases_Modulo_Transporte.Barrio.class);
                conf.addAnnotatedClass(Clases_Modulo_Transporte.CargaCombustible.class);
                conf.addAnnotatedClass(Clases_Modulo_Transporte.CondicionContratacion.class);
                conf.addAnnotatedClass(Clases_Modulo_Transporte.CondicionIva.class);
                conf.addAnnotatedClass(Clases_Modulo_Transporte.Departamento.class);
                conf.addAnnotatedClass(Clases_Modulo_Transporte.DetalleCarga.class);
                conf.addAnnotatedClass(Clases_Modulo_Transporte.DetalleConsumo.class);
                conf.addAnnotatedClass(Clases_Modulo_Transporte.DetalleEnvio.class);
                conf.addAnnotatedClass(Clases_Modulo_Transporte.DetalleReparacion.class);
                conf.addAnnotatedClass(Clases_Modulo_Transporte.Domicilio.class);
                conf.addAnnotatedClass(Clases_Modulo_Transporte.EnvioTaller.class);
                conf.addAnnotatedClass(Clases_Modulo_Transporte.Especialidad.class);
                conf.addAnnotatedClass(Clases_Modulo_Transporte.EstacionDeServicio.class);
                conf.addAnnotatedClass(Clases_Modulo_Transporte.Estado.class);
                conf.addAnnotatedClass(Clases_Modulo_Transporte.Localidad.class);
                conf.addAnnotatedClass(Clases_Modulo_Transporte.Marca.class);
                conf.addAnnotatedClass(Clases_Modulo_Transporte.Modelo.class);
                conf.addAnnotatedClass(Clases_Modulo_Transporte.Motivo.class);
                conf.addAnnotatedClass(Clases_Modulo_Transporte.OrdenServicio.class);
                conf.addAnnotatedClass(Clases_Modulo_Transporte.Pais.class);
                conf.addAnnotatedClass(Clases_Modulo_Transporte.Transportista.class);
                conf.addAnnotatedClass(Clases_Modulo_Transporte.ProveedorCombustible.class);
                conf.addAnnotatedClass(Clases_Modulo_Transporte.Provincia.class);
                conf.addAnnotatedClass(Clases_Modulo_Transporte.TallerReparacion.class);
                conf.addAnnotatedClass(Clases_Modulo_Transporte.TipoCombustible.class);
                conf.addAnnotatedClass(Clases_Modulo_Transporte.TipoDocumento.class);
                conf.addAnnotatedClass(Clases_Modulo_Transporte.TipoServicio.class);
                conf.addAnnotatedClass(Clases_Modulo_Transporte.TipoTelefono.class);
                conf.addAnnotatedClass(Clases_Modulo_Transporte.TipoVehiculo.class);
                conf.addAnnotatedClass(Clases_Modulo_Transporte.Producto.class);
//                conf.addAnnotatedClass(Clases_Modulo_Transporte.Transportista.class);
                conf.addAnnotatedClass(Clases_Modulo_Transporte.Vehiculo.class);
                conf.addAnnotatedClass(Clases_Modulo_Transporte.OpcionEditar.class);
                
                conf.addAnnotatedClass(Clases_Modulo_Carga.CaracteristicasCereal.class);
                conf.addAnnotatedClass(Clases_Modulo_Carga.Descarga.class);
                conf.addAnnotatedClass(Clases_Modulo_Carga.Destino.class);
                conf.addAnnotatedClass(Clases_Modulo_Carga.EspecialidadLaboratorio.class);
                conf.addAnnotatedClass(Clases_Modulo_Carga.HistorialProductor.class);     
                conf.addAnnotatedClass(Clases_Modulo_Carga.InformeLaboratorio.class);
                conf.addAnnotatedClass(Clases_Modulo_Carga.Laboratorio.class);
                conf.addAnnotatedClass(Clases_Modulo_Carga.Mes.class);
                conf.addAnnotatedClass(Clases_Modulo_Carga.MuestraTomada.class);
                conf.addAnnotatedClass(Clases_Modulo_Carga.Puerto.class);
                conf.addAnnotatedClass(Clases_Modulo_Carga.Retiro.class);
                conf.addAnnotatedClass(Clases_Modulo_Carga.Silo.class);
                conf.addAnnotatedClass(Clases_Modulo_Carga.SolicitudRetiro.class);
                conf.addAnnotatedClass(Clases_Modulo_Carga.Temporada.class);
                conf.addAnnotatedClass(Clases_Modulo_Carga.TipoCereal.class);
                conf.addAnnotatedClass(Clases_Modulo_Carga.TipoOperacion.class);
                conf.addAnnotatedClass(Clases_Modulo_Carga.TipoTemporada.class);
                conf.addAnnotatedClass(Clases_Modulo_Carga.Establecimiento.class);
                conf.addAnnotatedClass(Clases_Modulo_Carga.Productor.class);
                
            sessionFactory = conf.buildSessionFactory();
            session=sessionFactory.openSession();

        } catch (Throwable ex) {
// Log exception!
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static Session getSession()
    throws HibernateException {
        return session;
    }
}