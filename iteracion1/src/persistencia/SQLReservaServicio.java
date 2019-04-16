package persistencia;



import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import iteracion1.hotelandes.negocio.ReservaServicio;
class SQLReservaServicio 
{

	private final static String SQL = PersistenciaHotel.SQL;

	
	private PersistenciaHotel pp;


	public SQLReservaServicio (PersistenciaHotel pp)
	{
		this.pp = pp;
	}
	
	
	public long adicionarReservaServicio (PersistenceManager pm, long idReservaServicio,String fechaEntrada,String fechaSalida,long idSErv,long clienteDoc) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaReservaServicio () + "(id, fecha_entrada, fecha_salida, id_servicio, documento_cliente) values (?, ?, ?, ?, ?)");
        q.setParameters( idReservaServicio, fechaEntrada, fechaSalida, idSErv, clienteDoc );
        return (long) q.executeUnique();
	}

	
	public long eliminarReservaServicioPorId (PersistenceManager pm, long idReservaServicio)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaReservaServicio () + " WHERE id = ?");
        q.setParameters(idReservaServicio);
        return (long) q.executeUnique();
	}

	
	public ReservaServicio darReservaServicioPorId (PersistenceManager pm, long idReservaServicio) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaReservaServicio () + " WHERE id = ?");
		q.setResultClass(ReservaServicio.class);
		q.setParameters(idReservaServicio);
		return (ReservaServicio) q.executeUnique();
	}

	public List<ReservaServicio> darReservaServicioes (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaReservaServicio ());
		q.setResultClass(ReservaServicio.class);
		return (List<ReservaServicio>) q.executeList();
	}

	
}
