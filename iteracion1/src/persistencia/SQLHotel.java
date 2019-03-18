package persistencia;



import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import iteracion1.hotelandes.negocio.Hotel;
class SQLHotel 
{

	private final static String SQL = PersistenciaHotel.SQL;

	
	private PersistenciaHotel pp;


	public SQLHotel (PersistenciaHotel pp)
	{
		this.pp = pp;
	}
	
	
	public long adicionarHotel (PersistenceManager pm, long idHotel, String lugar, double costoTotal, int numH, int doc,Date fecha) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaHotel () + "(id, lugar, costo_total, numero_habitacion, documento_cliente,fecha) values (?, ?, ?, ?, ?)");
        q.setParameters(idHotel, lugar, costoTotal, numH, doc,fecha);
        return (long) q.executeUnique();
	}

	
	public long eliminarHotelPorId (PersistenceManager pm, long idHotel)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHotel () + " WHERE id = ?");
        q.setParameters(idHotel);
        return (long) q.executeUnique();
	}

	
	public Hotel darHotelPorId (PersistenceManager pm, long idHotel) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHotel () + " WHERE id = ?");
		q.setResultClass(Hotel.class);
		q.setParameters(idHotel);
		return (Hotel) q.executeUnique();
	}

	public List<Hotel> darHoteles (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHotel ());
		q.setResultClass(Hotel.class);
		return (List<Hotel>) q.executeList();
	}

	
}
