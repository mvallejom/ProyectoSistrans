package persistencia;

import java.awt.List;

import javax.jdo.PersistenceManager;
import javax.jdo.annotations.Query;

import iteracion1.hotelandes.negocio.Cliente;

class SQLCliente 
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	
	private final static String SQL = PersistenciaHotel.SQL;

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	private PersistenciaHotel pp;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/

	public SQLCliente (PersistenciaHotel pp)
	{
		this.pp = pp;
	}
	
	
	public long adicionarCliente (PersistenceManager pm, int numero , int numero_habitacion) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaCliente () + "(numero, numero_habitacion) values (?, ?)");
        q.setParameters(numero, numero_habitacion);
        return (long) q.executeUnique();
	}

	
	public long eliminarClienteesPornumero (PersistenceManager pm,  int numero)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCliente () + " WHERE numero = ?");
        q.setParameters(numero);
        return (long) q.executeUnique();
	}

	
	

	public Cliente darClientePorNumero (PersistenceManager pm, int numero) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCliente () + " WHERE numero = ?");
		q.setResultClass(Cliente.class);
		q.setParameters(numero);
		return (Cliente) q.executeUnique();
	}

	
	

	public List<Cliente> darClientees (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCliente ());
		q.setResultClass(Cliente.class);
		return (List<Cliente>) q.executeList();
	}

	
	public long aumentarSedesClienteesCiudad (PersistenceManager pm, String ciudad)
	{
        Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaCliente () + " SET cantsedes = cantsedes + 1 WHERE ciudad = ?");
        q.setParameters(ciudad);
        return (long) q.executeUnique();
	}
	
}
