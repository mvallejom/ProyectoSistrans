package persistencia;



import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import javax.jdo.JDODataStoreException;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import org.apache.log4j.Logger;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import uniandes.isis2304.parranderos.negocio.Bar;
import uniandes.isis2304.parranderos.negocio.Bebedor;
import uniandes.isis2304.parranderos.negocio.Bebida;
import uniandes.isis2304.parranderos.negocio.Gustan;
import uniandes.isis2304.parranderos.negocio.Sirven;
import uniandes.isis2304.parranderos.negocio.Cliente;
import uniandes.isis2304.parranderos.negocio.Visitan;

public class PersistenciaHotel 
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	
	private static Logger log = Logger.getLogger(PersistenciaHotel.class.getName());
	
	
	public final static String SQL = "javax.jdo.query.SQL";

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	private static PersistenciaHotel instance;
	
	
	private PersistenceManagerFactory pmf;
	
	
	private List <String> tablas;
	
	
	private SQLUtil sqlUtil;
	
	
	private SQLCliente sqlCliente;
	
	private SQLConsumo sqlConsumo;
	
	
	private SQLHabitacion sqlHabitacion;
	
	
	private SQLHotel sqlHotel;
	
	
	private SQLInfoConsumo sqlInfoCosumo;
	
	
	private SQLLugar sqlLugar;
	
	
	private SQLPlanConsumo sqlPlanConsumo;
	
	private SQLProducto sqlProducto;
	private SQLReservaHabitacion sqlReservaHabitacion;
	private SQLReservaServicio sqlReservaServicio;
	private SQLrol sqlrol;
	private SQLServicioHotel sqlServicio;

	private SQLTipoHabitacion sqlTipoHabitacion;

	private SQLUsuario sqlUsuario;

	

	
	
	
	private PersistenciaHotel ()
	{
		pmf = JDOHelper.getPersistenceManagerFactory("Hotel");		
		crearClasesSQL ();
		
		// Define los nombres por defecto de las tablas de la base de datos
		tablas = new LinkedList<String> ();
		tablas.add ("Hotel_sequence");
		tablas.add ("CLIENTE");
		tablas.add ("CONSUMO");
		tablas.add ("HABITACION");
		tablas.add ("INFOCONSUMO");
		tablas.add ("LUGAR");
		tablas.add ("PLANCONSUMO");
		tablas.add ("PRODUCTO");
		tablas.add ("PRODUCTOCONSUMO");
		tablas.add ("RESERVAHABITACION");
		tablas.add ("RESERVASERVICIO");
		tablas.add ("ROL");
		tablas.add ("SERVICIOHOTEL");
		tablas.add ("TIPOHABITACION");
		tablas.add ("USUARIO");
		
}

	/**
	 * Constructor privado, que recibe los nombres de las tablas en un objeto Json - Patrón SINGLETON
	 * @param tableConfig - Objeto Json que contiene los nombres de las tablas y de la unidad de persistencia a manejar
	 */
	private PersistenciaHotel (JsonObject tableConfig)
	{
		crearClasesSQL ();
		tablas = leerNombresTablas (tableConfig);
		
		String unidadPersistencia = tableConfig.get ("unidadPersistencia").getAsString ();
		log.trace ("Accediendo unidad de persistencia: " + unidadPersistencia);
		pmf = JDOHelper.getPersistenceManagerFactory (unidadPersistencia);
	}

	/**
	 * @return Retorna el único objeto PersistenciaHotel existente - Patrón SINGLETON
	 */
	public static PersistenciaHotel getInstance ()
	{
		if (instance == null)
		{
			instance = new PersistenciaHotel ();
		}
		return instance;
	}
	
	/**
	 * Constructor que toma los nombres de las tablas de la base de datos del objeto tableConfig
	 * @param tableConfig - El objeto JSON con los nombres de las tablas
	 * @return Retorna el único objeto PersistenciaHotel existente - Patrón SINGLETON
	 */
	public static PersistenciaHotel getInstance (JsonObject tableConfig)
	{
		if (instance == null)
		{
			instance = new PersistenciaHotel (tableConfig);
		}
		return instance;
	}

	/**
	 * Cierra la conexión con la base de datos
	 */
	public void cerrarUnidadPersistencia ()
	{
		pmf.close ();
		instance = null;
	}
	
	/**
	 * Genera una lista con los nombres de las tablas de la base de datos
	 * @param tableConfig - El objeto Json con los nombres de las tablas
	 * @return La lista con los nombres del secuenciador y de las tablas
	 */
	private List <String> leerNombresTablas (JsonObject tableConfig)
	{
		JsonArray nombres = tableConfig.getAsJsonArray("tablas") ;

		List <String> resp = new LinkedList <String> ();
		for (JsonElement nom : nombres)
		{
			resp.add (nom.getAsString ());
		}
		
		return resp;
	}
	
	/**
	 * Crea los atributos de clases de apoyo SQL
	 */
	private void crearClasesSQL ()
	{
		
		  sqlUtil=new SQLUtil(this);
		  sqlCliente=new SQLCliente(this);
		  sqlConsumo=new SQLConsumo(this);
		  sqlHabitacion=new SQLHabitacion(this);
		  sqlHotel=new SQLHotel(this);
		  sqlInfoCosumo=new SQLInfoCosumo(this);
		  sqlLugar=new SQLLugar(this);
		  sqlPlanConsumo=new SQLPlanConsumo(this);
		  sqlProducto=new SQLProducto(this);
		  sqlReservaHabitacion=new SQLReservaHabitacion(this);
		  sqlReservaServicio=new SQLReservaServicio(this);
		  sqlrol=new SQLrol(this);
		  sqlServicio=new SQLServicio(this);
		  sqlTipoHabitacion=new SQLTipoHabitacion(this);
		  sqlUsuario=new SQLUsuario(this);
		
		
	
	}

	/**
	 * @return La cadena de caracteres con el nombre del secuenciador de parranderos
	 */
	public String darHotel ()
	{
		return tablas.get (0);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Cliente de parranderos
	 */
	public String darTablaCliente ()
	{
		return tablas.get (1);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Bebida de parranderos
	 */
	public String darTablaBebida ()
	{
		return tablas.get (2);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Bar de parranderos
	 */
	public String darTablaBar ()
	{
		return tablas.get (3);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Bebedor de parranderos
	 */
	public String darTablaBebedor ()
	{
		return tablas.get (4);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Gustan de parranderos
	 */
	public String darTablaGustan ()
	{
		return tablas.get (5);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Sirven de parranderos
	 */
	public String darTablaSirven ()
	{
		return tablas.get (6);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Visitan de parranderos
	 */
	public String darTablaVisitan ()
	{
		return tablas.get (7);
	}
	
	/**
	 * Transacción para el generador de secuencia de Parranderos
	 * Adiciona entradas al log de la aplicación
	 * @return El siguiente número del secuenciador de Parranderos
	 */
	private long nextval ()
	{
        long resp = sqlUtil.nextval (pmf.getPersistenceManager());
        log.trace ("Generando secuencia: " + resp);
        return resp;
    }
	
	/**
	 * Extrae el mensaje de la exception JDODataStoreException embebido en la Exception e, que da el detalle específico del problema encontrado
	 * @param e - La excepción que ocurrio
	 * @return El mensaje de la excepción JDO
	 */
	private String darDetalleException(Exception e) 
	{
		String resp = "";
		if (e.getClass().getName().equals("javax.jdo.JDODataStoreException"))
		{
			JDODataStoreException je = (javax.jdo.JDODataStoreException) e;
			return je.getNestedExceptions() [0].getMessage();
		}
		return resp;
	}

	/* ****************************************************************
	 * 			Métodos para manejar los TIPOS DE BEBIDA
	 *****************************************************************/

	/**
	 * Método que inserta, de manera transaccional, una tupla en la tabla Cliente
	 * Adiciona entradas al log de la aplicación
	 * @param nombre - El nombre del tipo de bebida
	 * @return El objeto Cliente adicionado. null si ocurre alguna Excepción
	 */
	public Cliente adicionarCliente(String nombre)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long idCliente = nextval ();
            long tuplasInsertadas = sqlCliente.adicionarCliente(pm, idCliente, nombre);
            tx.commit();
            
            log.trace ("Inserción de tipo de bebida: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new Cliente (idCliente, nombre);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

	/**
	 * Método que elimina, de manera transaccional, una tupla en la tabla Cliente, dado el nombre del tipo de bebida
	 * Adiciona entradas al log de la aplicación
	 * @param nombre - El nombre del tipo de bebida
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarClientePorNombre (String nombre) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlCliente.eliminarClientePorNombre(pm, nombre);
            tx.commit();
            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

	/**
	 * Método que elimina, de manera transaccional, una tupla en la tabla Cliente, dado el identificador del tipo de bebida
	 * Adiciona entradas al log de la aplicación
	 * @param idCliente - El identificador del tipo de bebida
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarClientePorId (long idCliente) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlCliente.eliminarClientePorId(pm, idCliente);
            tx.commit();
            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

	/**
	 * Método que consulta todas las tuplas en la tabla Cliente
	 * @return La lista de objetos Cliente, construidos con base en las tuplas de la tabla Cliente
	 */
	public List<Cliente> darTiposBebida ()
	{
		return sqlCliente.darTiposBebida (pmf.getPersistenceManager());
	}
 
	/**
	 * Método que consulta todas las tuplas en la tabla Cliente que tienen el nombre dado
	 * @param nombre - El nombre del tipo de bebida
	 * @return La lista de objetos Cliente, construidos con base en las tuplas de la tabla Cliente
	 */
	public List<Cliente> darClientePorNombre (String nombre)
	{
		return sqlCliente.darTiposBebidaPorNombre (pmf.getPersistenceManager(), nombre);
	}
 
	/**
	 * Método que consulta todas las tuplas en la tabla Cliente con un identificador dado
	 * @param idCliente - El identificador del tipo de bebida
	 * @return El objeto Cliente, construido con base en las tuplas de la tabla Cliente con el identificador dado
	 */
	public Cliente darClientePorId (long idCliente)
	{
		return sqlCliente.darClientePorId (pmf.getPersistenceManager(), idCliente);
	}
 
	/* ****************************************************************
	 * 			Métodos para manejar las BEBIDAS
	 *****************************************************************/
	
	/**
	 * Método que inserta, de manera transaccional, una tupla en la tabla Bebida
	 * Adiciona entradas al log de la aplicación
	 * @param nombre - El nombre de la bebida
	 * @param idCliente - El identificador del tipo de bebida (Debe existir en la tabla Cliente)
	 * @param gradoAlcohol - El grado de alcohol de la bebida (mayor que 0)
	 * @return El objeto Bebida adicionado. null si ocurre alguna Excepción
	 */
	public Bebida adicionarBebida(String nombre, long idCliente, int gradoAlcohol) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();            
            long idBebida = nextval ();
            long tuplasInsertadas = sqlBebida.adicionarBebida(pm, idBebida, nombre, idCliente, gradoAlcohol);
            tx.commit();
            
            log.trace ("Inserción bebida: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
            return new Bebida (idBebida,nombre, idCliente, gradoAlcohol);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

	/**
	 * Método que elimina, de manera transaccional, una tupla en la tabla Bebida, dado el nombre de la bebida
	 * Adiciona entradas al log de la aplicación
	 * @param nombreBebida - El nombre de la bebida
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarBebidaPorNombre (String nombreBebida) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlBebida.eliminarBebidaPorNombre(pm, nombreBebida);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

	/**
	 * Método que elimina, de manera transaccional, una tupla en la tabla Bebida, dado el identificador de la bebida
	 * Adiciona entradas al log de la aplicación
	 * @param idBebida - El identificador de la bebida
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarBebidaPorId (long idBebida) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlBebida.eliminarBebidaPorId (pm, idBebida);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

	/**
	 * Método que consulta todas las tuplas en la tabla Bebida que tienen el nombre dado
	 * @param nombreBebida - El nombre de la bebida
	 * @return La lista de objetos Bebida, construidos con base en las tuplas de la tabla BEBIDA
	 */
	public List<Bebida> darBebidasPorNombre (String nombreBebida)
	{
		return sqlBebida.darBebidasPorNombre (pmf.getPersistenceManager(), nombreBebida);
	}
 
	/**
	 * Método que consulta todas las tuplas en la tabla Bebida
	 * @return La lista de objetos Bebida, construidos con base en las tuplas de la tabla BEBIDA
	 */
	public List<Bebida> darBebidas ()
	{
		return sqlBebida.darBebidas (pmf.getPersistenceManager());
	}
 
	/**
	 * Método que elimina, de manera transaccional, las bebidas que no son referenciadas en la tabla SIRVEN de Parranderos
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarBebidasNoServidas ()
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlBebida.eliminarBebidasNoServidas(pm);
            tx.commit();
            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

	/* ****************************************************************
	 * 			Métodos para manejar los BEBEDORES
	 *****************************************************************/
	
	/**
	 * Método que inserta, de manera transaccional, una tupla en la tabla BEBEDOR
	 * Adiciona entradas al log de la aplicación
	 * @param nombre - El nombre del bebedor
	 * @param ciudad - La ciudad del bebedor
	 * @param presupuesto - El presupuesto del bebedor (ALTO, MEDIO, BAJO)
	 * @return El objeto BEBEDOR adicionado. null si ocurre alguna Excepción
	 */
	public Bebedor adicionarBebedor(String nombre, String ciudad, String presupuesto) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long idBebedor = nextval ();
            long tuplasInsertadas = sqlBebedor.adicionarBebedor(pmf.getPersistenceManager(), idBebedor, nombre, ciudad, presupuesto);
            tx.commit();

            log.trace ("Inserción de bebedor: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new Bebedor (idBebedor, nombre, ciudad, presupuesto);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

	/**
	 * Método que elimina, de manera transaccional, una tupla en la tabla BEBEDOR, dado el nombre del bebedor
	 * Adiciona entradas al log de la aplicación
	 * @param nombre - El nombre del bebedor
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarBebedorPorNombre(String nombre) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlBebedor.eliminarBebedorPorNombre (pm, nombre);
            tx.commit();
            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

	/**
	 * Método que elimina, de manera transaccional, una tupla en la tabla BEBEDOR, dado el identificador del bebedor
	 * Adiciona entradas al log de la aplicación
	 * @param idBebedor - El identificador del bebedor
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarBebedorPorId (long idBebedor) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlBebedor.eliminarBebedorPorId (pm, idBebedor);
            tx.commit();
            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

	/**
	 * Método que consulta todas las tuplas en la tabla BEBEDOR que tienen el nombre dado
	 * @param nombreBebedor - El nombre del bebedor
	 * @return La lista de objetos BEBEDOR, construidos con base en las tuplas de la tabla BEBEDOR
	 */
	public List<Bebedor> darBebedoresPorNombre (String nombreBebedor) 
	{
		return sqlBebedor.darBebedoresPorNombre (pmf.getPersistenceManager(), nombreBebedor);
	}

	/**
	 * Método que consulta todas las tuplas en la tabla BEBEDOR que tienen el identificador dado
	 * @param idBebedor - El identificador del bebedor
	 * @return El objeto BEBEDOR, construido con base en la tuplas de la tabla BEBEDOR, que tiene el identificador dado
	 */
	public Bebedor darBebedorPorId (long idBebedor) 
	{
		return (Bebedor) sqlBebedor.darBebedorPorId (pmf.getPersistenceManager(), idBebedor);
	}

	/**
	 * Método que consulta TODA LA INFORMACIÓN DE UN BEBEDOR con el identificador dado. Incluye la información básica del bebedor,
	 * las visitas realizadas y las bebidas que le gustan.
	 * @param idBebedor - El identificador del bebedor
	 * @return El objeto BEBEDOR, construido con base en las tuplas de la tablas BEBEDOR, VISITAN, BARES, GUSTAN, BEBIDAS y Cliente,
	 * relacionadas con el identificador de bebedor dado
	 */
	public Bebedor darBebedorCompleto (long idBebedor) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Bebedor bebedor = (Bebedor) sqlBebedor.darBebedorPorId (pm, idBebedor);
		bebedor.setVisitasRealizadas(armarVisitasBebedor (sqlBebedor.darVisitasRealizadas (pm, idBebedor)));
		bebedor.setBebidasQueLeGustan(armarGustanBebedor (sqlBebedor.darBebidasQueLeGustan (pm, idBebedor)));
		return bebedor;
	}

	/**
	 * Método que consulta todas las tuplas en la tabla BEBEDOR
	 * @return La lista de objetos BEBEDOR, construidos con base en las tuplas de la tabla BEBEDOR
	 */
	public List<Bebedor> darBebedores ()
	{
		return sqlBebedor.darBebedores (pmf.getPersistenceManager());
	}
 
	/**
	 * Método que consulta los bebedores y el número de visitas que ha realizado
	 * @return La lista de parejas de objetos, construidos con base en las tuplas de la tabla BEBEDOR y VISITAN. 
	 * El primer elemento de la pareja es un bebedor; 
	 * el segundo elemento es el número de visitas de ese bebedor (0 en el caso que no haya realizado visitas)
	 */
	public List<Object []> darBebedoresYNumVisitasRealizadas ()
	{
		List<Object []> respuesta = new LinkedList <Object []> ();
		List<Object> tuplas = sqlBebedor.darBebedoresYNumVisitasRealizadas (pmf.getPersistenceManager());
        for ( Object tupla : tuplas)
        {
			Object [] datos = (Object []) tupla;
			long idBebedor = ((BigDecimal) datos [0]).longValue ();
			String nombreBebedor = (String) datos [1];
			String ciudadBebedor = (String) datos [2];
			String presupuesto = (String) datos [3];
			int numBares = ((BigDecimal) datos [4]).intValue ();

			Object [] resp = new Object [2];
			resp [0] = new Bebedor (idBebedor, nombreBebedor, ciudadBebedor, presupuesto);
			resp [1] = numBares;	
			
			respuesta.add(resp);
        }

		return respuesta;
	}
 
	/**
	 * Método que consulta CU�?NTOS BEBEDORES DE UNA CIUDAD VISITAN BARES
	 * @param ciudad - La ciudad que se quiere consultar
	 * @return El número de bebedores de la ciudad dada que son referenciados en VISITAN
	 */
	public long darCantidadBebedoresCiudadVisitanBares (String ciudad)
	{
		return sqlBebedor.darCantidadBebedoresCiudadVisitanBares (pmf.getPersistenceManager(), ciudad);
	}
	
	/**
	 * Método que actualiza, de manera transaccional, la ciudad de un  BEBEDOR
	 * @param idBebedor - El identificador del bebedor
	 * @param ciudad - La nueva ciudad del bebedor
	 * @return El número de tuplas modificadas. -1 si ocurre alguna Excepción
	 */
	public long cambiarCiudadBebedor (long idBebedor, String ciudad)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlBebedor.cambiarCiudadBebedor (pm, idBebedor, ciudad);
            tx.commit();
            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

	/**
	 * Método que elimima, de manera transaccional, un BEBEDOR y las VISITAS que ha realizado
	 * Si el bebedor está referenciado en alguna otra relación, no se borra ni el bebedor NI las visitas
	 * @param idBebedor - El identificador del bebedor
	 * @return Un arreglo de dos números que representan el número de bebedores eliminados y 
	 * el número de visitas eliminadas, respectivamente. [-1, -1] si ocurre alguna Excepción
	 */
	public long []  eliminarBebedorYVisitas_v1 (long idBebedor)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long [] resp = sqlBebedor.eliminarBebedorYVisitas_v1 (pm, idBebedor);
            tx.commit();
            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return new long[] {-1, -1};
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	/**
	 * Método que elimima, de manera transaccional, un BEBEDOR y las VISITAS que ha realizado
	 * Si el bebedor está referenciado en alguna otra relación, no se puede borrar, SIN EMBARGO S�? SE BORRAN TODAS SUS VISITAS
	 * @param idBebedor - El identificador del bebedor
	 * @return Un arreglo de dos números que representan el número de bebedores eliminados y 
	 * el número de visitas eliminadas, respectivamente. [-1, -1] si ocurre alguna Excepción
	 */
	public long [] eliminarBebedorYVisitas_v2 (long idBebedor)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long visitasEliminadas = eliminarVisitanPorIdBebedor(idBebedor);
            long bebedorEliminado = eliminarBebedorPorId (idBebedor);
            tx.commit();
            return new long [] {bebedorEliminado, visitasEliminadas};
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return new long [] {-1, -1};
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}	

	/**
	 * Método privado para generar las información completa de las visitas realizadas por un bebedor: 
	 * La información básica del bar visitado, la fecha y el horario, en el formato esperado por los objetos BEBEDOR
	 * @param tuplas - Una lista de arreglos de 7 objetos, con la información del bar y de la visita realizada, en el siguiente orden:
	 *   bar.id, bar.nombre, bar.ciudad, bar.presupuesto, bar.cantsedes, vis.fechavisita, vis.horario
	 * @return Una lista de arreglos de 3 objetos. El primero es un objeto BAR, el segundo corresponde a la fecha de la visita y
	 * el tercero corresponde al horaario de la visita
	 */
	private List<Object []> armarVisitasBebedor (List<Object []> tuplas)
	{
		List<Object []> visitas = new LinkedList <Object []> ();
		for (Object [] tupla : tuplas)
		{
			long idBar = ((BigDecimal) tupla [0]).longValue ();
			String nombreBar = (String) tupla [1];
			String ciudadBar = (String) tupla [2];
			String presupuestoBar = (String) tupla [3];
			int sedesBar = ((BigDecimal) tupla [4]).intValue ();
			Timestamp fechaVisita = (Timestamp) tupla [5];
			String horarioVisita = (String) tupla [6];
			
			Object [] visita = new Object [3];
			visita [0] = new Bar (idBar, nombreBar, ciudadBar, presupuestoBar, sedesBar);
			visita [1] = fechaVisita;
			visita [2] = horarioVisita;

			visitas.add (visita);
		}
		return visitas;
	}
	
	/**
	 * Método privado para generar las información completa de las bebidas que le gustan a un bebedor: 
	 * La información básica de la bebida, especificando también el nombre de la bebida, en el formato esperado por los objetos BEBEDOR
	 * @param tuplas - Una lista de arreglos de 5 objetos, con la información de la bebida y del tipo de bebida, en el siguiente orden:
	 * 	 beb.id, beb.nombre, beb.idCliente, beb.gradoalcohol, Cliente.nombre
	 * @return Una lista de arreglos de 2 objetos. El primero es un objeto BEBIDA, el segundo corresponde al nombre del tipo de bebida
	 */
	private List<Object []> armarGustanBebedor (List<Object []> tuplas)
	{
		List<Object []> gustan = new LinkedList <Object []> ();
		for (Object [] tupla : tuplas)
		{			
			long idBebida = ((BigDecimal) tupla [0]).longValue ();
			String nombreBebida = (String) tupla [1];
			long idCliente = ((BigDecimal) tupla [2]).longValue ();
			int gradoAlcohol = ((BigDecimal) tupla [3]).intValue ();
			String nombreTipo = (String) tupla [4];

			Object [] gusta = new Object [2];
			gusta [0] = new Bebida (idBebida, nombreBebida, idCliente, gradoAlcohol);
			gusta [1] = nombreTipo;	
			
			gustan.add(gusta);
		}
		return gustan;
	}
	
	/* ****************************************************************
	 * 			Métodos para manejar los BARES
	 *****************************************************************/
	
	/**
	 * Método que inserta, de manera transaccional, una tupla en la tabla BAR
	 * Adiciona entradas al log de la aplicación
	 * @param nombre - El nombre del bar
	 * @param ciudad - La ciudad del bar
	 * @param presupuesto - El presupuesto del bar (ALTO, MEDIO, BAJO)
	 * @param sedes - El número de sedes del bar en la ciudad (Mayor que 0)
	 * @return El objeto Bar adicionado. null si ocurre alguna Excepción
	 */
	public Bar adicionarBar(String nombre, String ciudad, String presupuesto, int sedes) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long idBar = nextval ();
            long tuplasInsertadas = sqlBar.adicionarBar(pm, idBar, nombre, ciudad, presupuesto, sedes);
            tx.commit();

            log.trace ("Inserción de Bar: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");

            return new Bar (idBar, nombre, ciudad, presupuesto, sedes);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

	/**
	 * Método que elimina, de manera transaccional, una tupla en la tabla BAR, dado el nombre del bar
	 * Adiciona entradas al log de la aplicación
	 * @param nombreBar - El nombre del bar
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarBarPorNombre (String nombreBar) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlBar.eliminarBaresPorNombre(pm, nombreBar);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

	/**
	 * Método que elimina, de manera transaccional, una tupla en la tabla BAR, dado el identificador del bar
	 * Adiciona entradas al log de la aplicación
	 * @param idBar - El identificador del bar
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarBarPorId (long idBar) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlBar.eliminarBarPorId (pm, idBar);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

	/**
	 * Método que consulta todas las tuplas en la tabla BAR
	 * @return La lista de objetos BAR, construidos con base en las tuplas de la tabla BAR
	 */
	public List<Bar> darBares ()
	{
		return sqlBar.darBares (pmf.getPersistenceManager());
	}
 
	/**
	 * Método que consulta todas las tuplas en la tabla BAR que tienen el nombre dado
	 * @param nombreBar - El nombre del bar
	 * @return La lista de objetos BAR, construidos con base en las tuplas de la tabla BAR
	 */
	public List<Bar> darBaresPorNombre (String nombreBar)
	{
		return sqlBar.darBaresPorNombre (pmf.getPersistenceManager(), nombreBar);
	}
 
	/**
	 * Método que consulta todas las tuplas en la tabla BAR que tienen el identificador dado
	 * @param idBar - El identificador del bar
	 * @return El objeto BAR, construido con base en la tuplas de la tabla BAR, que tiene el identificador dado
	 */
	public Bar darBarPorId (long idBar)
	{
		return sqlBar.darBarPorId (pmf.getPersistenceManager(), idBar);
	}
 
	/**
	 * Método que actualiza, de manera transaccional, aumentando en 1 el número de sedes de todos los bares de una ciudad
	 * @param ciudad - La ciudad que se quiere modificar
	 * @return El número de tuplas modificadas. -1 si ocurre alguna Excepción
	 */
	public long aumentarSedesBaresCiudad (String ciudad)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlBar.aumentarSedesBaresCiudad(pm, ciudad);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	/* ****************************************************************
	 * 			Métodos para manejar la relación GUSTAN
	 *****************************************************************/
	
	/**
	 * Método que inserta, de manera transaccional, una tupla en la tabla GUSTAN
	 * Adiciona entradas al log de la aplicación
	 * @param idBebedor - El identificador del bebedor - Debe haber un bebedor con ese identificador
	 * @param idBebida - El identificador de la bebida - Debe haber una bebida con ese identificador
	 * @return Un objeto GUSTAN con la información dada. Null si ocurre alguna Excepción
	 */
	public Gustan adicionarGustan(long idBebedor, long idBebida) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasInsertadas = sqlGustan.adicionarGustan (pm, idBebedor, idBebida);
            tx.commit();

            log.trace ("Inserción de gustan: [" + idBebedor + ", " + idBebida + "]. " + tuplasInsertadas + " tuplas insertadas");

            return new Gustan (idBebedor, idBebida);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

	/**
	 * Método que elimina, de manera transaccional, una tupla en la tabla GUSTAN, dados los identificadores de bebedor y bebida
	 * @param idBebedor - El identificador del bebedor
	 * @param idBebida - El identificador de la bebida
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarGustan(long idBebedor, long idBebida) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlGustan.eliminarGustan(pm, idBebedor, idBebida);           
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

	/**
	 * Método que consulta todas las tuplas en la tabla GUSTAN
	 * @return La lista de objetos GUSTAN, construidos con base en las tuplas de la tabla GUSTAN
	 */
	public List<Gustan> darGustan ()
	{
		return sqlGustan.darGustan (pmf.getPersistenceManager());
	}
 
 
	/* ****************************************************************
	 * 			Métodos para manejar la relación SIRVEN
	 *****************************************************************/
	
	/**
	 * Método que inserta, de manera transaccional, una tupla en la tabla SIRVEN
	 * Adiciona entradas al log de la aplicación
	 * @param idBar - El identificador del bar - Debe haber un bar con ese identificador
	 * @param idBebida - El identificador de la bebida - Debe haber una bebida con ese identificador
	 * @param horario - El hororio en que se sirve (DIURNO, NOCTURNO, TODOS)
	 * @return Un objeto SIRVEN con la información dada. Null si ocurre alguna Excepción
	 */
	public Sirven adicionarSirven (long idBar, long idBebida, String horario) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasInsertadas = sqlSirven.adicionarSirven (pmf.getPersistenceManager(), idBar, idBebida, horario);
    		tx.commit();

            log.trace ("Inserción de gustan: [" + idBar + ", " + idBebida + "]. " + tuplasInsertadas + " tuplas insertadas");

            return new Sirven (idBar, idBebida, horario);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
 
	/**
	 * Método que elimina, de manera transaccional, una tupla en la tabla SIRVEN, dados los identificadores de bar y bebida
	 * @param idBar - El identificador del bar
	 * @param idBebida - El identificador de la bebida
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarSirven (long idBar, long idBebida) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
	        Transaction tx=pm.currentTransaction();
	        try
	        {
	            tx.begin();
	            long resp = sqlSirven.eliminarSirven (pm, idBar, idBebida);	            
	            tx.commit();

	            return resp;
	        }
	        catch (Exception e)
	        {
//	        	e.printStackTrace();
	        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
	        	return -1;
	        }
	        finally
	        {
	            if (tx.isActive())
	            {
	                tx.rollback();
	            }
	            pm.close();
	        }
	}
 
	/**
	 * Método que consulta todas las tuplas en la tabla SIRVEN
	 * @return La lista de objetos SIRVEN, construidos con base en las tuplas de la tabla SIRVEN
	 */
	public List<Sirven> darSirven ()
	{
		return sqlSirven.darSirven (pmf.getPersistenceManager());
	}
 
	/**
	 * Método que encuentra el identificador de los bares y cuántas bebidas sirve cada uno de ellos. Si una bebida se sirve en diferentes horarios,
	 * cuenta múltiples veces
	 * @return Una lista de arreglos de 2 números. El primero corresponde al identificador del bar, el segundo corresponde al nombre del tipo de bebida
	 */
	public List<long []> darBaresYCantidadBebidasSirven ()
	{
		List<long []> resp = new LinkedList<long []> ();
		List<Object []> tuplas =  sqlSirven.darBaresYCantidadBebidasSirven (pmf.getPersistenceManager());
        for ( Object [] tupla : tuplas)
        {
			long [] datosResp = new long [2];
			
			datosResp [0] = ((BigDecimal) tupla [0]).longValue ();
			datosResp [1] = ((BigDecimal) tupla [1]).longValue ();
			resp.add (datosResp);
        }
        return resp;
	}
 
	/* ****************************************************************
	 * 			Métodos para manejar la relación VISITAN
	 *****************************************************************/

	/**
	 * Método que inserta, de manera transaccional, una tupla en la tabla VISITAN
	 * Adiciona entradas al log de la aplicación
	 * @param idBebedor - El identificador del bebedor - Debe haber un bebedor con ese identificador
	 * @param idBar - El identificador del bar - Debe haber un bar con ese identificador
	 * @param fecha - La fecha en que se realizó la visita
	 * @param horario - El hororio en que se sirve (DIURNO, NOCTURNO, TODOS)
	 * @return Un objeto VISITAN con la información dada. Null si ocurre alguna Excepción
	 */	
	public Visitan adicionarVisitan (long idBebedor, long idBar, Timestamp fecha, String horario) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasInsertadas = sqlVisitan.adicionarVisitan(pm, idBebedor, idBar, fecha, horario);
            tx.commit();

            log.trace ("Inserción de gustan: [" + idBebedor + ", " + idBar + "]. " + tuplasInsertadas + " tuplas insertadas");

            return new Visitan (idBebedor, idBar, fecha, horario);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}


	/**
	 * Método que elimina, de manera transaccional, una tupla en la tabla VISITAN, dados los identificadores de bebedor y bar
	 * @param idBebedor - El identificador del bebedor
	 * @param idBar - El identificador del bar
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarVisitan (long idBebedor, long idBar) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlVisitan.eliminarVisitan(pm, idBebedor, idBar);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

	/**
	 * Método que elimina, de manera transaccional, una tupla en la tabla VISITAN, dados el identificador del bebedor
	 * @param idBebedor - El identificador del bebedor
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarVisitanPorIdBebedor (long idBebedor) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long visitasEliminadas = sqlVisitan.eliminarVisitanPorIdBebedor (pm, idBebedor);
            tx.commit();

            return visitasEliminadas;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	

	/**
	 * Método que elimina, de manera transaccional, una tupla en la tabla VISITAN, dados el identificador del bar
	 * @param idBar - El identificador del bar
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarVisitanPorIdBar (long idBar) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long visitasEliminadas = sqlVisitan.eliminarVisitanPorIdBar (pm, idBar);
            tx.commit();

            return visitasEliminadas;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

	/**
	 * Método que consulta todas las tuplas en la tabla VISITAN
	 * @return La lista de objetos VISITAN, construidos con base en las tuplas de la tabla VISITAN
	 */
	public List<Visitan> darVisitan ()
	{
		return sqlVisitan.darVisitan (pmf.getPersistenceManager());
	}	

	/**
	 * Elimina todas las tuplas de todas las tablas de la base de datos de Parranderos
	 * Crea y ejecuta las sentencias SQL para cada tabla de la base de datos - EL ORDEN ES IMPORTANTE 
	 * @return Un arreglo con 7 números que indican el número de tuplas borradas en las tablas GUSTAN, SIRVEN, VISITAN, BEBIDA,
	 * Cliente, BEBEDOR y BAR, respectivamente
	 */
	public long [] limpiarHotel ()
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long [] resp = sqlUtil.limpiarParranderos (pm);
            tx.commit ();
            log.info ("Borrada la base de datos");
            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return new long[] {-1, -1, -1, -1, -1, -1, -1};
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
		
	}

	public String darTablaPlanConsumo() {
		// TODO Auto-generated method stub
		return null;
	}
	

 }
