package persistencia;



import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

class SQLRol 
{

	private final static String SQL = PersistenciaHotel.SQL;

	
	private PersistenciaHotel pp;


	public SQLRol (PersistenciaHotel pp)
	{
		this.pp = pp;
	}
	
	
	public long adicionarRol (PersistenceManager pm, long id , String nombre) 
	{
        Query q = pm.newQuery(SQL, "INSERT longO " + pp.darTablaRol () + "(id, nombre) values (?, ?)");
        q.setParameters(id,nombre);
        return (long) q.executeUnique();
	}

	
	public long eliminarRol(PersistenceManager pm, long idRol)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaRol () + " WHERE numero = ?");
        q.setParameters(idRol);
        return (long) q.executeUnique();
	}

	
	public String darRolPorId (PersistenceManager pm, long idRol) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaRol () + " WHERE numero = ?");
		q.setResultClass(String.class);
		q.setParameters(idRol);
		return (String) q.executeUnique();
	}

	public List<String> darRoles (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaRol ());
		q.setResultClass(String.class);
		return (List<String>) q.executeList();
	}

	
}
