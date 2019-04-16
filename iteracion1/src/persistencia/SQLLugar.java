package persistencia;



import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import iteracion1.hotelandes.negocio.Lugar;
class SQLLugar 
{

	private final static String SQL = PersistenciaHotel.SQL;

	
	private PersistenciaHotel pp;


	public SQLLugar (PersistenciaHotel pp)
	{
		this.pp = pp;
	}
	
	
	public long adicionarLugar (PersistenceManager pm, long idLugar, String nombre) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaLugar () + "(id, nombre)) values (?, ?)");
        q.setParameters(idLugar, nombre);
        return (long) q.executeUnique();
	}

	
	public long eliminarLugarPorId (PersistenceManager pm, long idLugar)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaLugar () + " WHERE id = ?");
        q.setParameters(idLugar);
        return (long) q.executeUnique();
	}

	
	public Lugar darLugarPorId (PersistenceManager pm, long idLugar) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaLugar () + " WHERE id = ?");
		q.setResultClass(Lugar.class);
		q.setParameters(idLugar);
		return (Lugar) q.executeUnique();
	}

	public List<Lugar> darLugares (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaLugar ());
		q.setResultClass(Lugar.class);
		return (List<Lugar>) q.executeList();
	}

	
}
