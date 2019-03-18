package persistencia;



import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import iteracion1.hotelandes.negocio.ProductoConsumo;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto ProductoConsumo de hotel
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 * 
 * @author Germán Bravo
 */
class SQLProductoConsumo 
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
	public SQLProductoConsumo(PersistenciaHotel pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un ProductoConsumo a la base de datos de hotel
	 * @param pm - El manejador de persistencia
	 * @param idProductoConsumo - El identificador del ProductoConsumo
	 * @param nombre - El nombre del ProductoConsumo
	 * @param ciudad - La ciudad del ProductoConsumo
	 * @param presupuesto - El presupuesto del ProductoConsumo (ALTO, MEDIO, BAJO)
	 * @param sedes - El número de sedes del ProductoConsumo
	 * @return El número de tuplas insertadas
	 */
	public long adicionarProductoConsumo (PersistenceManager pm, long idConsumo, long idProducto) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaProductoConsumo () + "(id_consumo, id_producto) values (?, ?)");
        q.setParameters(idConsumo, idProducto);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar ProductoConsumoES de la base de datos de hotel, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param nombreProductoConsumo - El nombre del ProductoConsumo
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarProductosConsumoPorConsumo (PersistenceManager pm, String idProductoConsumo)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaProductoConsumo () + " WHERE nombre = ?");
        q.setParameters(idProductoConsumo);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar UN ProductoConsumo de la base de datos de hotel, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idProductoConsumo - El identificador del ProductoConsumo
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarProductoConsumoPorId (PersistenceManager pm, long idProductoConsumo)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaProductoConsumo () + " WHERE id = ?");
        q.setParameters(idProductoConsumo);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN ProductoConsumo de la 
	 * base de datos de hotel, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idProductoConsumo - El identificador del ProductoConsumo
	 * @return El objeto ProductoConsumo que tiene el identificador dado
	 */
	public ProductoConsumo darProductoConsumoPorId (PersistenceManager pm, long idProductoConsumo) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaProductoConsumo () + " WHERE id = ?");
		q.setResultClass(ProductoConsumo.class);
		q.setParameters(idProductoConsumo);
		return (ProductoConsumo) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS ProductoConsumoES de la 
	 * base de datos de hotel, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param idConsumo - El id de ProductoConsumo buscado
	 * @return Una lista de objetos ProductoConsumo que tienen el nombre dado
	 */
	public List<ProductoConsumo> darProductoConsumoesPorConsumo (PersistenceManager pm, String idConsumo) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaProductoConsumo () + " WHERE nombre = ?");
		q.setResultClass(ProductoConsumo.class);
		q.setParameters(idConsumo);
		return (List<ProductoConsumo>) q.executeList();
	}
	
}
