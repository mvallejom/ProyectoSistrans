package persistencia;



import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import iteracion1.hotelandes.negocio.TipoHabitacion;
class SQLTipoHabitacion 
{

	private final static String SQL = PersistenciaHotel.SQL;

	
	private PersistenciaHotel pp;


	public SQLTipoHabitacion (PersistenciaHotel pp)
	{
		this.pp = pp;
	}
	
	
	public int adicionarTipoHabitacion (PersistenceManager pm, int numero, String tipo) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaTipoHabitacion () + "(id, tipo) values (?, ?)");
        q.setParameters(numero, tipo);
        return (int) q.executeUnique();
	}

	
	public int eliminarTipoHabitacionPorId (PersistenceManager pm, int idTipoHabitacion)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaTipoHabitacion () + " WHERE id = ?");
        q.setParameters(idTipoHabitacion);
        return (int) q.executeUnique();
	}

	
	public TipoHabitacion darTipoHabitacionPorId (PersistenceManager pm, int idTipoHabitacion) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaTipoHabitacion () + " WHERE id = ?");
		q.setResultClass(TipoHabitacion.class);
		q.setParameters(idTipoHabitacion);
		return (TipoHabitacion) q.executeUnique();
	}

	public List<TipoHabitacion> darTipoHabitaciones (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaTipoHabitacion ());
		q.setResultClass(TipoHabitacion.class);
		return (List<TipoHabitacion>) q.executeList();
	}

	
}
