package persistencia;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import iteracion1.hotelandes.negocio.Convencion;
class SQLConvencion 
{

	private final static String SQL = PersistenciaHotel.SQL;

	
	private PersistenciaHotel pp;


	public SQLConvencion (PersistenciaHotel pp)
	{
		this.pp = pp;
	}
	
	
	public long adicionarConvencion (PersistenceManager pm, long idConvencion, long doc, long idOrganizador) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaConvencion () + "(id, cuenta, documento, id_organizador) values (?, ?, ?, ?)");
        q.setParameters(idConvencion, 0	, doc, idOrganizador);
        return (long) q.executeUnique();
	}

	
	public long eliminarConvencionPorId (PersistenceManager pm, long idConvencion)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaConvencion () + " WHERE id = ?");
        q.setParameters(idConvencion);
        return (long) q.executeUnique();
	}

	
	public Convencion darConvencionPorId (PersistenceManager pm, long idConvencion) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConvencion () + " WHERE id = ?");
		q.setResultClass(Convencion.class);
		q.setParameters(idConvencion);
		return (Convencion) q.executeUnique();
	}

	public List<Convencion> darConvencions (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaConvencion ());
		q.setResultClass(Convencion.class);
		return (List<Convencion>) q.executeList();
	}

	
}
