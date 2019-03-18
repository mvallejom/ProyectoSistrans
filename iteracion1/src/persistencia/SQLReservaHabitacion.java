package persistencia;



import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import iteracion1.hotelandes.negocio.ReservaHabitacion;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto ReservaHabitacion de Hotel
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 * 
 * @author Germán Bravo
 */
class SQLReservaHabitacion 
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el tipo de consulta que se va a realizar en las sentencias de acceso a la base de datos
	 * Se renombra acá para facilitar la escritura de las sentencias
	 */
	private final static String SQL = PersistenciaHotel.SQL;

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia general de la aplicación
	 */
	private PersistenciaHotel pp;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/

	/**
	 * Constructor
	 * @param pp - El Manejador de persistencia de la aplicación
	 */
	public SQLReservaHabitacion (PersistenciaHotel pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un ReservaHabitacion a la base de datos de Hotel
	 * @return El número de tuplas insertadas
	 */
	public long adicionarReservaHabitacion (PersistenceManager pm, String fechaEntrada, String fechaSalida, int numeroPersonas, long docCliente, long idHotel) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaReservaHabitacion () + "(fecha_entrada, fecha_salida, numero_personas, documento_cliente, id_hotel) values (?, ?, ?, ?, ?)");
        q.setParameters(fechaEntrada, fechaSalida, numeroPersonas, docCliente, idHotel);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar UN ReservaHabitacion de la base de datos de Hotel, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idReservaHabitacion - El identificador del ReservaHabitacion
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarReservaHabitacionPorId (PersistenceManager pm, long idReservaHabitacion)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaReservaHabitacion () + " WHERE id = ?");
        q.setParameters(idReservaHabitacion);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN ReservaHabitacion de la 
	 * base de datos de Hotel, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idReservaHabitacion - El identificador del ReservaHabitacion
	 * @return El objeto ReservaHabitacion que tiene el identificador dado
	 */
	public ReservaHabitacion darReservaHabitacionPorId (PersistenceManager pm, long idReservaHabitacion) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaReservaHabitacion () + " WHERE id = ?");
		q.setResultClass(ReservaHabitacion.class);
		q.setParameters(idReservaHabitacion);
		return (ReservaHabitacion) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS ReservaHabitacionES de la 
	 * base de datos de Hotel
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos ReservaHabitacion
	 */
	public List<ReservaHabitacion> darReservaHabitaciones (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaReservaHabitacion ());
		q.setResultClass(ReservaHabitacion.class);
		return (List<ReservaHabitacion>) q.executeList();
	}
	
}
