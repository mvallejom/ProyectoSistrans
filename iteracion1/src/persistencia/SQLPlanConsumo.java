package persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import iteracion1.hotelandes.negocio.PlanConsumo;
class SQLPlanConsumo 
{

	private final static String SQL = PersistenciaHotel.SQL;

	
	private PersistenciaHotel pp;


	public SQLPlanConsumo (PersistenciaHotel pp)
	{
		this.pp = pp;
	}
	
	
	public long adicionarPlanConsumo (PersistenceManager pm, long idPlanConsumo, String tipoPlan, String descripcion,int idhotel, int numH, long doc,String fecha) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaPlanConsumo() + "(id, tipo_plan, descripcion, id_hotel) values (?, ?, ?, ?)");
        q.setParameters(idPlanConsumo, tipoPlan, descripcion, idhotel);
        return (long) q.executeUnique();
	}

	
	public long eliminarPlanConsumoPorId (PersistenceManager pm, long idPlanConsumo)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaPlanConsumo () + " WHERE id = ?");
        q.setParameters(idPlanConsumo);
        return (long) q.executeUnique();
	}

	
	public PlanConsumo darPlanConsumoPorId (PersistenceManager pm, long idPlanConsumo) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPlanConsumo () + " WHERE id = ?");
		q.setResultClass(PlanConsumo.class);
		q.setParameters(idPlanConsumo);
		return (PlanConsumo) q.executeUnique();
	}

	public List<PlanConsumo> darPlanConsumoes (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPlanConsumo ());
		q.setResultClass(PlanConsumo.class);
		return (List<PlanConsumo>) q.executeList();
	}

	
}
