package persistencia;



import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import iteracion1.hotelandes.negocio.InfoConsumo;

class SQLInfoConsumo 
{

	private final static String SQL = PersistenciaHotel.SQL;

	
	private PersistenciaHotel pp;


	public SQLInfoConsumo (PersistenciaHotel pp)
	{
		this.pp = pp;
	}
	
	
	public long adicionarInfoInfoConsumo (PersistenceManager pm, long idInfoConsumo, String nombre, long idProducto, long idserv) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaInfoConsumo () + "(id, cantidad, id_producto, id_servicio) values (?, ?, ?, ?)");
        q.setParameters(idInfoConsumo, nombre, idProducto, idserv);
        return (long) q.executeUnique();
	}

	
	public long eliminarInfoConsumoPorId (PersistenceManager pm, long idInfoConsumo)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaInfoConsumo () + " WHERE id = ?");
        q.setParameters(idInfoConsumo);
        return (long) q.executeUnique();
	}

	
	public InfoConsumo darInfoConsumoPorId (PersistenceManager pm, long idInfoConsumo) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaInfoConsumo () + " WHERE id = ?");
		q.setResultClass(InfoConsumo.class);
		q.setParameters(idInfoConsumo);
		return (InfoConsumo) q.executeUnique();
	}

	public List<InfoConsumo> darInfoConsumoes (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaInfoConsumo ());
		q.setResultClass(InfoConsumo.class);
		return (List<InfoConsumo>) q.executeList();
	}

	
}
