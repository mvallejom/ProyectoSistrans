package persistencia;



import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import iteracion1.hotelandes.negocio.Habitacion;
class SQLHabitacion 
{

	private final static String SQL = PersistenciaHotel.SQL;

	
	private PersistenciaHotel pp;


	public SQLHabitacion (PersistenciaHotel pp)
	{
		this.pp = pp;
	}
	
	
	public int adicionarHabitacion (PersistenceManager pm, int num, String descrp, int cap, int tipo, double costo ,int idh,int idPlancons) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaHabitacion () + "(numero, descripcion, capacidad, tipo_habitacion, costo_noche,cuenta,id_hotel,plan_consumo) values (?, ?, ?, ?, ?,?,?,?)");
        q.setParameters(num, descrp, cap, tipo, costo,0,idh,idPlancons);
        return (int) q.executeUnique();
	}

	
	public int eliminarHabitacionPornumero (PersistenceManager pm, int idHabitacion)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHabitacion () + " WHERE numero = ?");
        q.setParameters(idHabitacion);
        return (int) q.executeUnique();
	}

	
	public Habitacion darHabitacionPorId (PersistenceManager pm, int idHabitacion) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHabitacion () + " WHERE numero = ?");
		q.setResultClass(Habitacion.class);
		q.setParameters(idHabitacion);
		return (Habitacion) q.executeUnique();
	}

	public List<Habitacion> darHabitaciones (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHabitacion ());
		q.setResultClass(Habitacion.class);
		return (List<Habitacion>) q.executeList();
	}

	
}
