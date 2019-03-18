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

	
	public String darHotel ()
	{
		return tablas.get (0);
	}

	public String darTablaCliente ()
	{
		return tablas.get (1);
	}

	public String darTablaConsumo ()
	{
		return tablas.get (2);
	}

	
	public String darTablaHabitacion ()
	{
		return tablas.get (3);
	}

	
	public String darTablaHotel ()
	{
		return tablas.get (4);
	}

	
	public String darTablaInfoConsumo ()
	{
		return tablas.get (5);
	}

	
	public String darTablaLugar ()
	{
		return tablas.get (6);
	}

	
	
	
	public String darTablaProducto()
	{
		return tablas.get (8);
	}
	public String darTablaProductoConsumo()
	{
		return tablas.get (9);
	}
	public String darTablaReservaHabitacion()
	{
		return tablas.get (10);
	}
	public String darTablaReservaServicio()
	{
		return tablas.get (11);
	}
	public String darTablaRol()
	{
		return tablas.get (12);
	}
	public String darTablaServicioHotel()
	{
		return tablas.get (13);
	}
	public String darTablaTipoHabitacion()
	{
		return tablas.get (14);
	}
	public String darTablaUsuario()
	{
		return tablas.get (15);
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
