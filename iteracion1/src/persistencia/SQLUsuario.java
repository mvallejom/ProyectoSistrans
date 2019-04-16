package persistencia;



import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import iteracion1.hotelandes.negocio.Usuario;
class SQLUsuario 
{

	private final static String SQL = PersistenciaHotel.SQL;

	
	private PersistenciaHotel pp;


	public SQLUsuario (PersistenciaHotel pp)
	{
		this.pp = pp;
	}
	
	
	public long adicionarUsuario (PersistenceManager pm, long numDoc, String tipoDoc, String nombre , String correo, String  rol,long idH) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaUsuario () + "(tipo_documento, numero_documento, nombre, correo, rol,id_hotel) values (?, ?, ?, ?, ?,?)");
        q.setParameters(tipoDoc, numDoc, nombre, correo, rol,idH);
        return (long) q.executeUnique();
	}

	
	public long eliminarUsuarioPorId (PersistenceManager pm, long idUsuario)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaUsuario () + " WHERE id = ?");
        q.setParameters(idUsuario);
        return (long) q.executeUnique();
	}

	
	public Usuario darUsuarioPorId (PersistenceManager pm, long idUsuario) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaUsuario () + " WHERE id = ?");
		q.setResultClass(Usuario.class);
		q.setParameters(idUsuario);
		return (Usuario) q.executeUnique();
	}

	public List<Usuario> darUsuarioes (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaUsuario ());
		q.setResultClass(Usuario.class);
		return (List<Usuario>) q.executeList();
	}

	
}
