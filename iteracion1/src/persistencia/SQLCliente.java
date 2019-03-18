package persistencia;


	import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import iteracion1.hotelandes.negocio.Cliente;
	class SQLCliente 
	{

		private final static String SQL = PersistenciaHotel.SQL;

		
		private PersistenciaHotel pp;


		public SQLCliente (PersistenciaHotel pp)
		{
			this.pp = pp;
		}
		
		
		public long adicionarCliente (PersistenceManager pm, int n, int nh ) 
		{
	        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaCliente () + "(numero, numero_habitacion) values (?, ?");
	        q.setParameters(n, nh);
	        return (long) q.executeUnique();
		}

		
		public long eliminarClientePorId (PersistenceManager pm, long idCliente)
		{
	        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCliente () + " WHERE id = ?");
	        q.setParameters(idCliente);
	        return (long) q.executeUnique();
		}

		
		public Cliente darClientePorId (PersistenceManager pm, long idCliente) 
		{
			Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCliente () + " WHERE id = ?");
			q.setResultClass(Cliente.class);
			q.setParameters(idCliente);
			return (Cliente) q.executeUnique();
		}

		public List<Cliente> darClientees (PersistenceManager pm)
		{
			Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCliente ());
			q.setResultClass(Cliente.class);
			return (List<Cliente>) q.executeList();
		}

		
	}

	

