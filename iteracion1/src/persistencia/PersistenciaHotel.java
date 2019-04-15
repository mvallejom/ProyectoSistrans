package persistencia;



import java.util.ArrayList;
import java.util.Date;
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

import iteracion1.hotelandes.negocio.Cliente;
import iteracion1.hotelandes.negocio.Consumo;
import iteracion1.hotelandes.negocio.Habitacion;
import iteracion1.hotelandes.negocio.Hotel;
import iteracion1.hotelandes.negocio.InfoConsumo;
import iteracion1.hotelandes.negocio.Lugar;
import iteracion1.hotelandes.negocio.PlanConsumo;
import iteracion1.hotelandes.negocio.Producto;
import iteracion1.hotelandes.negocio.ReservaHabitacion;
import iteracion1.hotelandes.negocio.ReservaServicio;
import iteracion1.hotelandes.negocio.Servicio;
import iteracion1.hotelandes.negocio.TipoHabitacion;
import iteracion1.hotelandes.negocio.Usuario;



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

	private Hotel hotel;
	private static PersistenciaHotel instance;


	private PersistenceManagerFactory pmf;


	private List <String> tablas;


	private SQLUtil sqlUtil;


	private SQLCliente sqlCliente;			//1
	private SQLConsumo sqlConsumo;			//2
	private SQLHabitacion sqlHabitacion;	//3
	private SQLHotel sqlHotel;				//4
	private SQLInfoConsumo sqlInfoCosumo;	//5
	private SQLLugar sqlLugar;				//6
	private SQLPlanConsumo sqlPlanConsumo;	//7
	private SQLProducto sqlProducto;		//8
	private SQLReservaHabitacion sqlReservaHabitacion;	//9
	private SQLReservaServicio sqlReservaServicio;		//10
	private SQLRol sqlrol;								//11
	private SQLServicio sqlServicio;					//12
	private SQLTipoHabitacion sqlTipoHabitacion;		//13
	private SQLUsuario sqlUsuario;						//14






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


	private PersistenciaHotel (JsonObject tableConfig)
	{
		crearClasesSQL ();
		tablas = leerNombresTablas (tableConfig);

		String unidadPersistencia = tableConfig.get ("unidadPersistencia").getAsString ();
		log.trace ("Accediendo unidad de persistencia: " + unidadPersistencia);
		pmf = JDOHelper.getPersistenceManagerFactory (unidadPersistencia);
	}

	/**
	 * @return Retorna el Ãºnico objeto PersistenciaHotel existente - PatrÃ³n SINGLETON
	 */
	public static PersistenciaHotel getInstance ()
	{
		if (instance == null)
		{
			instance = new PersistenciaHotel ();
		}
		return instance;
	}


	public static PersistenciaHotel getInstance (JsonObject tableConfig)
	{
		if (instance == null)
		{
			instance = new PersistenciaHotel (tableConfig);
		}
		return instance;
	}

	/**
	 * Cierra la conexiÃ³n con la base de datos
	 */
	public void cerrarUnidadPersistencia ()
	{
		pmf.close ();
		instance = null;
	}


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
		sqlInfoCosumo=new SQLInfoConsumo(this);
		sqlLugar=new SQLLugar(this);
		sqlPlanConsumo=new SQLPlanConsumo(this);
		sqlProducto=new SQLProducto(this);
		sqlReservaHabitacion=new SQLReservaHabitacion(this);
		sqlReservaServicio=new SQLReservaServicio(this);
		//  sqlrol=new SQLrol(this);
		sqlServicio=new SQLServicio(this);
		sqlTipoHabitacion=new SQLTipoHabitacion(this);
		sqlUsuario=new SQLUsuario(this);



	}

	public String darHotel ()
	{
		return tablas.get (0);
	}

	/* ***********************************************************************
	 * *					CLIENTE
	 * ***********************************************************************/


	public String darTablaCliente ()
	{
		return tablas.get (1);
	}

	public Cliente adicionarCliente(long documento, int numeroHabitacion)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long identificacion = documento;
			long tuplasInsertadas = sqlCliente.adicionarCliente(pm, identificacion, numeroHabitacion);
			tx.commit();

			log.trace ("Inserción de Consumo: " + identificacion + ": " + tuplasInsertadas + " tuplas insertadas");
			Usuario u =sqlUsuario.darUsuarioPorId(pm, identificacion);
			return new Cliente(u.getTipoDocumento(), identificacion, u.getNombre(), u.getCorreo(), numeroHabitacion);

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


	public long eliminarConsumoorId (long idCliente) 
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

	public List<Cliente> darClientes ()
	{
		return sqlCliente.darClientees(pmf.getPersistenceManager());
	}

	public Cliente darClientePorId (long idCliente)
	{
		return sqlCliente.darClientePorId(pmf.getPersistenceManager(), idCliente);
	}



	/* ***********************************************************************
	 * *					Consumo
	 * ***********************************************************************/


	public String darTablaConsumo ()
	{
		return tablas.get (2);
	}

	public Consumo adicionarConsumo(String lugar, int numeroHabitacion,double costoTotal, int numH,Date fecha ,long documento)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long idConsumo = nextval();
			long tuplasInsertadas = sqlConsumo.adicionarConsumo(pm, idConsumo, lugar, costoTotal, numH, documento, fecha);
			tx.commit(); sqlConsumo.adicionarConsumo(pm, idConsumo, lugar, costoTotal, numH, documento, fecha);

			log.trace ("Inserción de Consumo: " + idConsumo + ": " + tuplasInsertadas + " tuplas insertadas");

			List<Producto>productos=new ArrayList<Producto>();
			Habitacion h=hotel.darHabitacionPorNumero(numeroHabitacion);
			return new Consumo(lugar,h,productos,fecha);

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


	public long eliminarConsumoPorId (long idConsumo) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long resp = sqlConsumo.eliminarConsumoPorId(pm, idConsumo);
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

	public List<Consumo> darConsumos ()
	{
		return sqlConsumo.darConsumos(pmf.getPersistenceManager());
	}

	public Consumo darConsumoPorId (long idConsumo)
	{
		return sqlConsumo.darConsumoPorId (pmf.getPersistenceManager(), idConsumo);
	}



	/* ***********************************************************************
	 * *					Habitacion
	 * ***********************************************************************/


	public String darTablaHabitacion()
	{
		return tablas.get (3);
	}

	public Habitacion adicionarHabitacion(long documento, int numeroHabitacion, String descripcion, int capacidad , int tipo,int idHotel,double costo,int idPlanConsumo)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long identificacion = documento;
			long tuplasInsertadas = sqlHabitacion.adicionarHabitacion(pm, numeroHabitacion, descripcion, capacidad, tipo, costo, idHotel, idPlanConsumo);
			tx.commit();

			log.trace ("Inserción de Habitacion: " + identificacion + ": " + tuplasInsertadas + " tuplas insertadas");

			Hotel h;
			List<Cliente> clientes = new ArrayList<Cliente>();
			List<Servicio> servicios = new ArrayList<Servicio>();
			List<Consumo> consumos = new ArrayList<Consumo>();
			Habitacion hab=new Habitacion(numeroHabitacion, capacidad, TipoHabitacion.SENCILLA, servicios, costo, idHotel, consumos, clientes, idPlanConsumo); 

			return hab;
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


	public int eliminarHabitacionPorId (int idHabitacion) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			int resp = sqlHabitacion.eliminarHabitacionPornumero(pm, idHabitacion);
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

	public List<Habitacion> darHabitacions ()
	{
		return sqlHabitacion.darHabitaciones(pmf.getPersistenceManager());
	}

	public Habitacion darHabitacionPorId (int idHabitacion)
	{
		return sqlHabitacion.darHabitacionPorId (pmf.getPersistenceManager(), idHabitacion);

	}

	/* ***********************************************************************
	 * *					InfoConsumo
	 * ***********************************************************************/


	public String darTablaInfoConsumo()
	{
		return tablas.get (3);
	}

	public InfoConsumo adicionarInfoConsumo( Producto p,Servicio s,int cantidad,String nombre,double costoTotal, long doc,Date fecha)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long idInfoConsumo=nextval();
			long tuplasInsertadas = sqlInfoCosumo.adicionarInfoInfoConsumo(pm, idInfoConsumo, nombre, p.getId(), s.getId());
			tx.commit();

			log.trace ("Inserción de InfoConsumo: " + idInfoConsumo + ": " + tuplasInsertadas + " tuplas insertadas");			
			return new InfoConsumo(cantidad, p, s);

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


	public long eliminarInfoConsumoPorId (long idInfoConsumo) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long resp = sqlInfoCosumo.eliminarInfoConsumoPorId(pm, idInfoConsumo);
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

	public List<InfoConsumo> darInfoConsumos ()
	{
		return sqlInfoCosumo.darInfoConsumoes(pmf.getPersistenceManager());
	}

	public InfoConsumo darInfoConsumoPorId (long idInfoConsumo)
	{
		return sqlInfoCosumo.darInfoConsumoPorId (pmf.getPersistenceManager(), idInfoConsumo);

	}


	/* ***********************************************************************
	 * *					Lugar
	 * ***********************************************************************/


	public String darTablaLugar()
	{
		return tablas.get (3);
	}
//
//	public Lugar adicionarLugar(String nombre, int numH,double costoTotal,long doc,Date fecha)
//	{
//		PersistenceManager pm = pmf.getPersistenceManager();
//		Transaction tx=pm.currentTransaction();
//		try
//		{
//			tx.begin();
//			long idLugar = nextval();
//			long tuplasInsertadas = sqlLugar.adicionarLugar(pm, idLugar, nombre, costoTotal, numH, doc, fecha);
//			tx.commit();
//
//			log.trace ("Inserción de Lugar: " + idLugar + ": " + tuplasInsertadas + " tuplas insertadas");
//Lugar l=LUGAR.
//			return new 
//
//		}
//		catch (Exception e)
//		{
//			//        	e.printStackTrace();
//			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
//			return null;
//		}
//		finally
//		{
//			if (tx.isActive())
//			{
//				tx.rollback();
//			}
//			pm.close();
//		}
//	}


//	public long eliminarLugarPorId (long idLugar) 
//	{
//		PersistenceManager pm = pmf.getPersistenceManager();
//		Transaction tx=pm.currentTransaction();
//		try
//		{
//			tx.begin();
//			long resp = sqlInfoCosumo.eliminarLugarPornumero(pm, idLugar);
//			tx.commit();
//			return resp;
//		}
//		catch (Exception e)
//		{
//			//        	e.printStackTrace();
//			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
//			return -1;
//		}
//		finally
//		{
//			if (tx.isActive())
//			{
//				tx.rollback();
//			}
//			pm.close();
//		}
//	}

//	public List<Lugar> darLugars ()
//	{
//		return sqlLugar.darLugares(pmf.getPersistenceManager());
//	}
//
//	public Lugar darLugarPorId (long idLugar)
//	{
//		return sqlInfoCosumo.darLugarPorId (pmf.getPersistenceManager(), idLugar);
//
//	}


	/* ***********************************************************************
	 * *					Producto
	 * ***********************************************************************/


	public String darTablaProducto()
	{
		return tablas.get (3);
	}

	public Producto adicionarProducto( String nombre,double costo,Servicio s)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long idProducto=nextval();
			long tuplasInsertadas = sqlProducto.adicionarProducto(pm, idProducto, nombre, costo, s.getId());
			tx.commit();

			log.trace ("Inserción de Producto: " + idProducto + ": " + tuplasInsertadas + " tuplas insertadas");	
			List<Consumo> consumos=new ArrayList<Consumo>();
			return new Producto(idProducto, nombre, costo, consumos);

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


	public long eliminarProductoPorId (long idProducto) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long resp = sqlProducto.eliminarProductoPorId(pm, idProducto);
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

	public List<Producto> darProductos ()
	{
		return sqlProducto.darProductoes(pmf.getPersistenceManager());
	}

	public Producto darProductoPorId (long idProducto)
	{
		return sqlProducto.darProductoPorId (pmf.getPersistenceManager(), idProducto);

	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/* ***********************************************************************
	 * *					ReservaHabitacion
	 * ***********************************************************************/


	public String darTablaReservaHabitacion()
	{
		return tablas.get (3);
	}

	public ReservaHabitacion adicionarReservaHabitacion( Date fechaEntrada,Date fechaSalida,int numeroPersonas,List<Cliente> clientes)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long idReservaHabitacion=nextval();
			long tuplasInsertadas = sqlReservaHabitacion.adicionarReservaHabitacion(pm, idReservaHabitacion, fechaEntrada, fechaSalida, numeroPersonas, clientes.get(0).getNumeroDocumento(), hotel.getId());
			tx.commit();

			log.trace ("Inserción de ReservaHabitacion: " + idReservaHabitacion + ": " + tuplasInsertadas + " tuplas insertadas");	
			List<Consumo> consumos=new ArrayList<Consumo>();
			return new ReservaHabitacion(fechaEntrada, fechaSalida, numeroPersonas, hotel.getNombre(), clientes);

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


	public long eliminarReservaHabitacionPorId (long idReservaHabitacion) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long resp = sqlReservaHabitacion.eliminarReservaHabitacionPorId(pm, idReservaHabitacion);
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

	public List<ReservaHabitacion> darReservaHabitacions ()
	{
		return sqlReservaHabitacion.darReservaHabitaciones(pmf.getPersistenceManager());
	}

	public ReservaHabitacion darReservaHabitacionPorId (long idReservaHabitacion)
	{
		return sqlReservaHabitacion.darReservaHabitacionPorId (pmf.getPersistenceManager(), idReservaHabitacion);

	}







	/* ***********************************************************************
	 * *					ReservaServicio
	 * ***********************************************************************/


	public String darTablaReservaServicio()
	{
		return tablas.get (3);
	}

	public ReservaServicio adicionarReservaServicio( Date fechaEntrada,Date fechaSalida,Servicio s,Cliente c)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long idReservaServicio=nextval();
			long tuplasInsertadas = sqlReservaServicio.adicionarReservaServicio(pm, idReservaServicio, fechaEntrada, fechaSalida, s.getId(), c.getNumeroDocumento());
			tx.commit();

			log.trace ("Inserción de ReservaServicio: " + idReservaServicio + ": " + tuplasInsertadas + " tuplas insertadas");	
			List<Consumo> consumos=new ArrayList<Consumo>();
			return new ReservaServicio(fechaEntrada, fechaSalida, c, s);

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


	public long eliminarReservaServicioPorId (long idReservaServicio) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long resp = sqlReservaServicio.eliminarReservaServicioPorId(pm, idReservaServicio);
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

	public List<ReservaServicio> darReservaServicios ()
	{
		return sqlReservaServicio.darReservaServicioes(pmf.getPersistenceManager());
	}

	public ReservaServicio darReservaServicioPorId (long idReservaServicio)
	{
		return sqlReservaServicio.darReservaServicioPorId (pmf.getPersistenceManager(), idReservaServicio);

	}


	
	
	
	
	
	

	/* ***********************************************************************
	 * *					Rol
	 * ***********************************************************************/


	public String darTablaRol()
	{
		return tablas.get (3);
	}
//
//	public Rol adicionarRol( String nombre,double costo,Servicio s)
//	{
//		PersistenceManager pm = pmf.getPersistenceManager();
//		Transaction tx=pm.currentTransaction();
//		try
//		{
//			tx.begin();
//			long idRol=nextval();
//			long tuplasInsertadas = sqlRol.adicionarRo
//			tx.commit();
//
//			log.trace ("Inserción de Rol: " + idRol + ": " + tuplasInsertadas + " tuplas insertadas");	
//			List<Consumo> consumos=new ArrayList<Consumo>();
//			return new Rol(idRol, nombre, costo, consumos);
//
//		}
//		catch (Exception e)
//		{
//			//        	e.printStackTrace();
//			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
//			return null;
//		}
//		finally
//		{
//			if (tx.isActive())
//			{
//				tx.rollback();
//			}
//			pm.close();
//		}
//	}
//
//
//	public long eliminarRolPorId (long idRol) 
//	{
//		PersistenceManager pm = pmf.getPersistenceManager();
//		Transaction tx=pm.currentTransaction();
//		try
//		{
//			tx.begin();
//			long resp = sqlRol.eliminarRolPorId(pm, idRol);
//			tx.commit();
//			return resp;
//		}
//		catch (Exception e)
//		{
//			//        	e.printStackTrace();
//			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
//			return -1;
//		}
//		finally
//		{
//			if (tx.isActive())
//			{
//				tx.rollback();
//			}
//			pm.close();
//		}
//	}
//
//	public List<Rol> darRols ()
//	{
//		return sqlRol.darRoles(pmf.getPersistenceManager());
//	}
//
//	public Rol darRolPorId (long idRol)
//	{
//		return sqlRol.darRolPorId (pmf.getPersistenceManager(), idRol);
//
//	}
//
//
//	
//	
//	
//	
//	
	

	/* ***********************************************************************
	 * *					Servicio
	 * ***********************************************************************/


	public String darTablaServicio()
	{
		return tablas.get (3);
	}

	public Servicio adicionarServicio( String nombre,double costo,Servicio s,Date horaApertura, Date horaCierre,int capacidad, String descripcion, Lugar lugar,boolean disponible )
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long idServicio=nextval();
			long tuplasInsertadas = sqlServicio.adicionarServicio(pm, idServicio, nombre, horaApertura, horaCierre, descripcion, capacidad, costo, lugar.name(), disponible);
			tx.commit();

			log.trace ("Inserción de Servicio: " + idServicio + ": " + tuplasInsertadas + " tuplas insertadas");	
			List<Consumo> consumos=new ArrayList<Consumo>();
			return new Servicio(nombre, horaApertura, horaCierre, descripcion, hotel, costo, capacidad, lugar);

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


	public long eliminarServicioPorId (long idServicio) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long resp = sqlServicio.eliminarServicioPorId(pm, idServicio);
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

	public List<Servicio> darServicios ()
	{
		return sqlServicio.darServicioes(pmf.getPersistenceManager());
	}

	public Servicio darServicioPorId (long idServicio)
	{
		return sqlServicio.darServicioPorId (pmf.getPersistenceManager(), idServicio);

	}


	
	
	
	
	
	

	/* ***********************************************************************
	 * *					TipoHabitacion
	 * ***********************************************************************/


	public String darTablaTipoHabitacion()
	{
		return tablas.get (3);
	}
//
//	public TipoHabitacion adicionarTipoHabitacion( String tipo,int numero)
//	{
//		PersistenceManager pm = pmf.getPersistenceManager();
//		Transaction tx=pm.currentTransaction();
//		try
//		{
//			tx.begin();
//			long idTipoHabitacion=nextval();
//			long tuplasInsertadas = sqlTipoHabitacion.adicionarTipoHabitacion(pm, numero, tipo);
//			tx.commit();
//
//			log.trace ("Inserción de TipoHabitacion: " + idTipoHabitacion + ": " + tuplasInsertadas + " tuplas insertadas");	
//			List<Consumo> consumos=new ArrayList<Consumo>();
//			return new TipoHabitacion
//
//		}
//		catch (Exception e)
//		{
//			//        	e.printStackTrace();
//			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
//			return null;
//		}
//		finally
//		{
//			if (tx.isActive())
//			{
//				tx.rollback();
//			}
//			pm.close();
//		}
//	}
//
//
//	public long eliminarTipoHabitacionPorId (long idTipoHabitacion) 
//	{
//		PersistenceManager pm = pmf.getPersistenceManager();
//		Transaction tx=pm.currentTransaction();
//		try
//		{
//			tx.begin();
//			long resp = sqlTipoHabitacion.eliminarTipoHabitacionPorId(pm, idTipoHabitacion);
//			tx.commit();
//			return resp;
//		}
//		catch (Exception e)
//		{
//			//        	e.printStackTrace();
//			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
//			return -1;
//		}
//		finally
//		{
//			if (tx.isActive())
//			{
//				tx.rollback();
//			}
//			pm.close();
//		}
//	}
//
//	public List<TipoHabitacion> darTipoHabitacions ()
//	{
//		return sqlTipoHabitacion.darTipoHabitaciones(pmf.getPersistenceManager());
//	}
//
//	public TipoHabitacion darTipoHabitacionPorId (long idTipoHabitacion)
//	{
//		return sqlTipoHabitacion.darTipoHabitacionPorId (pmf.getPersistenceManager(), idTipoHabitacion);
//
//	}
//
//
//	
//	
//	
//	
//	
	

	/* ***********************************************************************
	 * *					Usuario
	 * ***********************************************************************/


	public String darTablaUsuario()
	{
		return tablas.get (3);
	}

	public Usuario adicionarUsuario( int numDoc,String  tipoDoc,String nombre, String correo, String rol, Hotel h)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long idUsuario=nextval();
			long tuplasInsertadas = sqlUsuario.adicionarUsuario(pm, numDoc, tipoDoc, nombre, correo, rol, h.getId());
			tx.commit();

			log.trace ("Inserción de Usuario: " + idUsuario + ": " + tuplasInsertadas + " tuplas insertadas");	
			List<Consumo> consumos=new ArrayList<Consumo>();
			return new Usuario(tipoDoc, numDoc, nombre, correo);

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


	public long eliminarUsuarioPorId (long idUsuario) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long resp = sqlUsuario.eliminarUsuarioPorId(pm, idUsuario);
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

	public List<Usuario> darUsuarios ()
	{
		return sqlUsuario.darUsuarioes(pmf.getPersistenceManager());
	}

	public Usuario darUsuarioPorId (long idUsuario)
	{
		return sqlUsuario.darUsuarioPorId (pmf.getPersistenceManager(), idUsuario);

	}
	
	/* ***********************************************************************
	 * *					PlanConsumo
	 * ***********************************************************************/


	public String darTablaPlanConsumo()
	{
		return tablas.get (3);
	}

	public PlanConsumo adicionarPlanConsumo( int numDoc,String  tipoPlan,String descripcion, Hotel h, Habitacion hab, Date fecha, Cliente c)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long idPlanConsumo=nextval();
			long tuplasInsertadas = sqlPlanConsumo.adicionarPlanConsumo(pm, idPlanConsumo, tipoPlan, descripcion, h.getId(), hab.getNumero(), c.getNumeroDocumento(), fecha);
			tx.commit();

			log.trace ("Inserción de PlanConsumo: " + idPlanConsumo + ": " + tuplasInsertadas + " tuplas insertadas");	
			List<Consumo> consumos=new ArrayList<Consumo>();
			return new PlanConsumo(tipoPlan, descripcion, h, hab);
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


	public long eliminarPlanConsumoPorId (long idPlanConsumo) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long resp = sqlPlanConsumo.eliminarPlanConsumoPorId(pm, idPlanConsumo);
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

	public List<PlanConsumo> darPlanConsumos ()
	{
		return sqlPlanConsumo.darPlanConsumoes(pmf.getPersistenceManager());
	}

	public PlanConsumo darPlanConsumoPorId (long idPlanConsumo)
	{
		return sqlPlanConsumo.darPlanConsumoPorId (pmf.getPersistenceManager(), idPlanConsumo);

	}
	
	
	
	
	
	
	


	
	
	
	
	
	public String darTablaHotel ()
	{
		return tablas.get (4);
	}




	



	





	private long nextval ()
	{
		long resp = sqlUtil.nextval (pmf.getPersistenceManager());
		log.trace ("Generando secuencia: " + resp);
		return resp;
	}


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



}
