package persistencia;



import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import iteracion1.hotelandes.negocio.Consumo;
class SQLConsumo 
{

	private final static String SQL = PersistenciaHotel.SQL;

	
	private PersistenciaHotel pp;


	public SQLConsumo (PersistenciaHotel pp)
	{
		this.pp = pp;
	}
	
	
	public long adicionarConsumo (PersistenceManager pm, long idConsumo, String lugar, double costoTotal, int numH, long documento,Date fecha) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaConsumo () + "(id, lugar, costo_total, numero_habitacion, documento_cliente,fecha) values (?, ?, ?, ?, ?)");
        q.setParameters(idConsumo, lugar, costoTotal, numH, documento,fecha);
        return (long) q.executeUnique();
	}

	
	public long eliminarConsumoPorId (PersistenceManager pm, long idConsumo)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaConsumo () + " WHERE id = ?");
        q.setParameters(idConsumo);
        return (long) q.executeUnique();
	}

	
	public Consumo darConsumoPorId (PersistenceManager pm, long idConsumo) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConsumo () + " WHERE id = ?");
		q.setResultClass(Consumo.class);
		q.setParameters(idConsumo);
		return (Consumo) q.executeUnique();
	}

	public List<Consumo> darConsumos (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConsumo ());
		q.setResultClass(Consumo.class);
		return (List<Consumo>) q.executeList();
	}

	
}
