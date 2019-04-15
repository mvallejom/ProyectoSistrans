package persistencia;



import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import iteracion1.hotelandes.negocio.Servicio;
class SQLServicio 
{

	private final static String SQL = PersistenciaHotel.SQL;

	
	private PersistenciaHotel pp;


	public SQLServicio (PersistenciaHotel pp)
	{
		this.pp = pp;
	}
	
	
	public long adicionarServicio (PersistenceManager pm, long idServicio, String nombre, Date horaApertura,Date horaCierre,String descipcion,int capacidad,double costo,String lugar,boolean disponible) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaServicio () + "(id, nombre, hora_apertura, hora_cierre, descripcion,capacidad,costo,lugar,disponible) values (?, ?, ?, ?, ?.?,?,?,?)");
        q.setParameters( idServicio,  nombre,  horaApertura, horaCierre, descipcion, capacidad, costo, lugar, disponible);
        return (long) q.executeUnique();
	}

	
	public long eliminarServicioPorId (PersistenceManager pm, long idServicio)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicio () + " WHERE id = ?");
        q.setParameters(idServicio);
        return (long) q.executeUnique();
	}

	
	public Servicio darServicioPorId (PersistenceManager pm, long idServicio) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio() + " WHERE id = ?");
		q.setResultClass(Servicio.class);
		q.setParameters(idServicio);
		return (Servicio) q.executeUnique();
	}

	public List<Servicio> darServicioes (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio());
		q.setResultClass(Servicio.class);
		return (List<Servicio>) q.executeList();
	}

	
}
