package persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

class SQLUtil
{
	private final static String SQL = PersistenciaHotel.SQL;

	
	private PersistenciaHotel pp;

	public SQLUtil (PersistenciaHotel pp)
	{
		this.pp = pp;
	}
	
	
	public long nextval (PersistenceManager pm)
	{
        Query q = pm.newQuery(SQL, "SELECT "+ pp.darTablaHotel() + ".nextval FROM DUAL");
        q.setResultClass(Long.class);
        long resp = (long) q.executeUnique();
        return resp;
	}

	
	public long [] limpiarParranderos (PersistenceManager pm)
	{
        Query qCliente = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCliente ());          
        Query qConsumo = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaConsumo ());
        Query qHabitacion = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHabitacion ());
        Query qHotel = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHotel ());
        Query qInfoConsumo = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaInfoConsumo ());
        Query qLugar = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaLugar ());
        Query qPlanConsumo = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaPlanConsumo ());
        Query qReservaHabitacion = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaReservaHabitacion ());
        Query qReservaServicio = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaReservaServicio ());
        Query qRol = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaRol ());
        Query qServicioHotel = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicio ());
        Query qTipoHabitacion = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaTipoHabitacion ());
        Query qUsuario = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaUsuario ());
        Query qConvencion = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaConvencion());
        Query qMantenimiento = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaMantenimiento ());

        
       

        long ClienteEliminados = (long) qCliente.executeUnique ();
        long ConsumoEliminados = (long) qConsumo.executeUnique ();
        long HabitacionEliminados = (long) qHabitacion.executeUnique ();
        long HotelEliminados = (long) qHotel.executeUnique ();
        long InfoConsumoEliminados = (long) qInfoConsumo.executeUnique ();
        long LugarEliminados = (long) qLugar.executeUnique ();
        long PlanConsumoEliminados = (long) qPlanConsumo.executeUnique ();
        long ReservaHabitacionEliminados = (long) qReservaHabitacion.executeUnique ();
        long ReservaServicioEliminados = (long) qReservaServicio.executeUnique ();
        long RolEliminados = (long) qRol.executeUnique ();
        long ServicioHotelEliminados = (long) qServicioHotel.executeUnique ();
        long TipoHabitacionEliminados = (long) qTipoHabitacion.executeUnique ();
        long TipoUsuario = (long) qUsuario.executeUnique ();
        long convencionEliminados = (long) qConvencion.executeUnique ();
        long mantenimientoEliminados = (long) qMantenimiento.executeUnique ();


      
        return new long[] {ClienteEliminados, ConsumoEliminados, HabitacionEliminados, HotelEliminados, 
        		InfoConsumoEliminados, LugarEliminados, PlanConsumoEliminados,ReservaHabitacionEliminados,ReservaServicioEliminados,RolEliminados,
        		ServicioHotelEliminados,TipoHabitacionEliminados,TipoUsuario,convencionEliminados,mantenimientoEliminados};
	}

}
