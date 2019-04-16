package persistencia;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import iteracion1.hotelandes.negocio.Habitacion;
import iteracion1.hotelandes.negocio.Mantenimiento;
import iteracion1.hotelandes.negocio.Servicio;
class SQLMantenimiento 
{

	private final static String SQL = PersistenciaHotel.SQL;

	
	private PersistenciaHotel pp;


	public SQLMantenimiento (PersistenciaHotel pp)
	{
		this.pp = pp;
	}
	
	
	public long adicionarMantenimiento (PersistenceManager pm, long idMantenimiento, String fechaInicio, String fechaFin,Servicio s, Habitacion h) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaMantenimiento () + "(id, fecha_inicio, fecha_fin,id_servicio,id_habitacion) values (?,?,?,?, ?)");
        q.setParameters(idMantenimiento, fechaInicio, fechaFin,s.getId(),h.getNumero());
        return (long) q.executeUnique();
	}

	
	public long eliminarMantenimientoPorId (PersistenceManager pm, long idMantenimiento)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaMantenimiento () + " WHERE id = ?");
        q.setParameters(idMantenimiento);
        return (long) q.executeUnique();
	}

	
	public Mantenimiento darMantenimientoPorId (PersistenceManager pm, long idMantenimiento) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaMantenimiento () + " WHERE id = ?");
		q.setResultClass(Mantenimiento.class);
		q.setParameters(idMantenimiento);
		return (Mantenimiento) q.executeUnique();
	}

	public List<Mantenimiento> darMantenimientos (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaMantenimiento ());
		q.setResultClass(Mantenimiento.class);
		return (List<Mantenimiento>) q.executeList();
	}

	
}
