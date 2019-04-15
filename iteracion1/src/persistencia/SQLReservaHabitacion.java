package persistencia;



import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import iteracion1.hotelandes.negocio.ReservaHabitacion;
class SQLReservaHabitacion 
{

	private final static String SQL = PersistenciaHotel.SQL;

	
	private PersistenciaHotel pp;


	public SQLReservaHabitacion (PersistenciaHotel pp)
	{
		this.pp = pp;
	}
	
	
	public long adicionarReservaHabitacion (PersistenceManager pm, long idReservaHabitacion, Date fechaEtrada, Date fechaSalida, int numPersonas, long docCliente,long idHotel) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaReservaHabitacion () + "(id, fecha_entrada,fecha_salida, numero_personas, documento_cliente,id_hotel) values (?, ?, ?, ?, ?,?)");
        q.setParameters(idReservaHabitacion, fechaEtrada, fechaSalida, numPersonas, docCliente,idHotel);
        return (long) q.executeUnique();
	}

	
	public long eliminarReservaHabitacionPorId (PersistenceManager pm, long idReservaHabitacion)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaReservaHabitacion () + " WHERE id = ?");
        q.setParameters(idReservaHabitacion);
        return (long) q.executeUnique();
	}

	
	public ReservaHabitacion darReservaHabitacionPorId (PersistenceManager pm, long idReservaHabitacion) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaReservaHabitacion () + " WHERE id = ?");
		q.setResultClass(ReservaHabitacion.class);
		q.setParameters(idReservaHabitacion);
		return (ReservaHabitacion) q.executeUnique();
	}

	public List<ReservaHabitacion> darReservaHabitaciones (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaReservaHabitacion ());
		q.setResultClass(ReservaHabitacion.class);
		return (List<ReservaHabitacion>) q.executeList();
	}

	
}
