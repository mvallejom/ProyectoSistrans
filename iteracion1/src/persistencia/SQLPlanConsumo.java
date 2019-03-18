package persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import iteracion1.hotelandes.negocio.PlanConsumo;

class SQLPlanConsumo 
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
	public SQLPlanConsumo (PersistenciaHotel pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un PlanConsumo a la base de datos de Hotel
	 * @param pm - El manejador de persistencia
	 * @param tipoPlan - Nombre del plan
	 * @param descripcion - Descripcion del plan
	 * @param idHotel - Id del hotel
	 * @return El número de tuplas insertadas
	 */
	public long adicionarPlanConsumo (PersistenceManager pm, String tipoPlan, String descripcion, Long idHotel) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaPlanConsumo () + "(tipo_plan, descripcion, id_hotel) values (?, ?, ?)");
        q.setParameters(tipoPlan, descripcion, idHotel);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar PlanConsumoES de la base de datos de Hotel, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param tipoPlan - El nombre del PlanConsumo
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarPlanConsumoesPorNombre (PersistenceManager pm, String tipoPlan)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaPlanConsumo () + " WHERE nombre = ?");
        q.setParameters(tipoPlan);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar UN PlanConsumo de la base de datos de hotel, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idPlanConsumo - El identificador del PlanConsumo
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarPlanConsumoPorId (PersistenceManager pm, long idPlanConsumo)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaPlanConsumo () + " WHERE id = ?");
        q.setParameters(idPlanConsumo);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN PlanConsumo de la 
	 * base de datos de hotel, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idPlanConsumo - El identificador del PlanConsumo
	 * @return El objeto PlanConsumo que tiene el identificador dado
	 */
	public PlanConsumo darPlanConsumoPorId (PersistenceManager pm, long idPlanConsumo) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPlanConsumo () + " WHERE id = ?");
		q.setResultClass(PlanConsumo.class);
		q.setParameters(idPlanConsumo);
		return (PlanConsumo) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS PlanConsumoES de la 
	 * base de datos de hotel
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos PlanConsumo
	 */
	public List<PlanConsumo> darPlanConsumos (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPlanConsumo ());
		q.setResultClass(PlanConsumo.class);
		return (List<PlanConsumo>) q.executeList();
	}
	
}
