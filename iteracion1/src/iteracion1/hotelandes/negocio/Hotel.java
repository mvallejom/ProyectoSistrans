package iteracion1.hotelandes.negocio;
import java.util.ArrayList;
import java.util.List;

import persistencia.PersistenciaHotel;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class Hotel
{

	private String nombre;

	private List<Habitacion> habitaciones;

	private List<PlanConsumo> planesConsumo;

	private List<ReservaHabitacion> reservaHabitacion;

	private List<Recepcionista> recepcionistas;

	private List<Empleado> empleados;

	private Administrador administrador;

	private Gerente gerente;

	private List<Servicio> servicios;

	private List<ReservaServicio> reservasServicio;

	private List<Cliente> clientes;

	private int id;

	private PersistenciaHotel ph;



	public Hotel(String nombre, List<Habitacion> habitaciones, List<PlanConsumo> planesConsumo,
			List<ReservaHabitacion> reservaHabitacion, List<Recepcionista> recepcionistas, List<Empleado> empleados,
			Administrador administrador, Gerente gerente, List<Servicio> servicios, List<ReservaServicio> reservas,
			List<Cliente> clientes) {
		super();
		this.nombre = nombre;
		this.habitaciones = habitaciones;
		this.planesConsumo = planesConsumo;
		this.reservaHabitacion = reservaHabitacion;
		this.recepcionistas = recepcionistas;
		this.empleados = empleados;
		this.administrador = administrador;
		this.gerente = gerente;
		this.servicios = servicios;
		this.reservasServicio = reservas;
		this.clientes = clientes;



		ph = PersistenciaHotel.getInstance();

	}



	public List<Servicio> getServicios() {
		return servicios;
	}



	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}



	public List<ReservaServicio> getReservasServicio() {
		return reservasServicio;
	}



	public void setReservasServicio(List<ReservaServicio> reservas) {
		this.reservasServicio = reservas;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

	public List<PlanConsumo> getPlanesConsumo() {
		return planesConsumo;
	}

	public void setPlanesConsumo(List<PlanConsumo> planesConsumo) {
		this.planesConsumo = planesConsumo;
	}

	public List<ReservaHabitacion> getReservaHabitacion() {
		return reservaHabitacion;
	}

	public void setReservaHabitacion(List<ReservaHabitacion> reservaHabitacion) {
		this.reservaHabitacion = reservaHabitacion;
	}

	public List<Recepcionista> getRecepcionistas() {
		return recepcionistas;
	}

	public void setRecepcionistas(List<Recepcionista> recepcionistas) {
		this.recepcionistas = recepcionistas;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id=id;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public void adicionarCliente(Cliente c) {
		clientes.add(c);
	}

	public List<Habitacion> habitacionesDisponibles()
	{
		List<Habitacion> resp = null;
		for(Habitacion hab: habitaciones) {
			if( hab.isDisponible()==true) {
				resp.add(hab);
			}
		}
		return resp;
	}
	public List<Servicio> darServicioPorNombre(String nombre){
		List<Servicio> resp=new ArrayList<Servicio>();
		for (Servicio s :getServicios()) {
			if(s.getNombre().equals(nombre)) {
				resp.add(s);
			}
		}
		return resp;
	}

	public boolean servicioDisponible(String inicio, String fin,Servicio s) {
		List <ReservaServicio> serviciosEnfecha = new ArrayList<ReservaServicio>();
		int cont =0;
		boolean resp=false;
		for(ReservaServicio rs:getReservasServicio()) {
			if(rs.getServicio().equals(s)) {
				if(inicio.after(rs.getFechaEntrada()) && inicio.before(rs.getFechaSalida())) {
					cont++;
				}
				else if(inicio.before(rs.getFechaEntrada())&&(fin.before(rs.getFechaSalida())&&fin.after(rs.getFechaEntrada()))) {
					cont++;
				}
			}
		}
		if(cont<s.getCapacidad()) {
			resp= true;
		}
		return resp;
	}

	public Habitacion darHabitacionPorNumero(int numero) {
		Habitacion resp=null;
		for(Habitacion h:habitaciones) {
			if(h.getNumero()==numero) {
				resp= h;

			}
		}
		return resp;
	}


	/***********************************************************************
	 *							REQUERIMIENTOS FUNCIONALES
	 *************************************************************************/








	//----------------------------------------------------------------------------------------------------
	//Habitacion
	//----------------------------------------------------------------------------------------------------

	public Habitacion agregarHabitacion(int documento, int numeroHabitacion,String descripcion, int capacidad,int  idTipo, double costo,int idPlanConsumo, int idHotel) {
		return ph.adicionarHabitacion(documento, numeroHabitacion, descripcion, capacidad, idTipo, idHotel, costo, idPlanConsumo);

	}

	public List<Habitacion> darHabitaciones() {
		return ph.darHabitacions();
	}

	public Habitacion darHabitacionPorId(int idHabitacion) {
		return ph.darHabitacionPorId(idHabitacion);
	}

	public int eliminarHabitacionPorId(int idHabitacion) {
		return ph.eliminarHabitacionPorId(idHabitacion);
	}

	

	//----------------------------------------------------------------------------------------------------
	//Usuario
	//----------------------------------------------------------------------------------------------------

	public Usuario agregarUsuario(int numDoc, String tipoDoc,String descripcion, String correo,String  rol, Hotel h) {
		return ph.adicionarUsuario(numDoc, tipoDoc, descripcion, correo, rol, h);

	}

	public List<Usuario> darUsuarioes() {
		return ph.darUsuarios();
	}

	public Usuario darUsuarioPorId(int idUsuario) {
		return ph.darUsuarioPorId(idUsuario);
	}

	public long eliminarUsuarioPorId(int idUsuario) {
		return ph.eliminarUsuarioPorId(idUsuario);
	}

	//----------------------------------------------------------------------------------------------------
	//Consumo
	//----------------------------------------------------------------------------------------------------

	public Consumo agregarConsumo(String lugar,double costoTotal, int numeroHabitacion, String fecha, long documento) {
		return ph.adicionarConsumo(lugar, numeroHabitacion, costoTotal, fecha, documento);
	}

	public List<Consumo> darConsumoes() {
		return ph.darConsumos();
	}

	public Consumo darConsumoPorId(int idConsumo) {
		return ph.darConsumoPorId(idConsumo);
	}

	public long eliminarConsumoPorId(int idConsumo) {
		return ph.eliminarConsumoPorId(idConsumo);
	}


	//----------------------------------------------------------------------------------------------------
	//Cliente
	//----------------------------------------------------------------------------------------------------

	public Cliente agregarCliente( int numeroHabitacion, long documento) {
		return ph.adicionarCliente(documento, numeroHabitacion);
	}

	public List<Cliente> darClientees() {
		return ph.darClientes();
	}

	public Cliente darClientePorId(int idCliente) {
		return ph.darClientePorId(idCliente);
	}

	public long eliminarClientePorId(long idCliente) {
		
		return ph.eliminarClientePorId(idCliente);
	}

	//----------------------------------------------------------------------------------------------------
	//Convencion
	//----------------------------------------------------------------------------------------------------

	public Convencion agregarConvencion(ReservaHabitacion reserva, OrganizadorEventos org) {
		return ph.adicionarConvencion(this, reserva, org);
	}

	public List<Convencion> darConvenciones() {
		return ph.darConvencions();
	}

	public Convencion darConvencionPorId(int idConvencion) {
		return ph.darConvencionPorId(idConvencion);
	}

	public long eliminarConvencionPorId(int idConvencion) {
		return ph.eliminarConvencionPorId(idConvencion);
	}

	//----------------------------------------------------------------------------------------------------
	//InfoConsumo
	//----------------------------------------------------------------------------------------------------

	public InfoConsumo agregarInfoConsumo(Producto p, Servicio s, int cantidad, Lugar lugar, double costoTotal,int doc,String fecha) {
		return ph.adicionarInfoConsumo(p, s, cantidad, fecha, costoTotal, doc, fecha);
	}

	public List<InfoConsumo> darInfoConsumoes() {
		return ph.darInfoConsumos();
	}

	public InfoConsumo darInfoConsumoPorId(int idInfoConsumo) {
		return ph.darInfoConsumoPorId(idInfoConsumo);
	}

	public long eliminarInfoConsumoPorId(int idInfoConsumo) {
		return ph.eliminarInfoConsumoPorId(idInfoConsumo);
	}


	//----------------------------------------------------------------------------------------------------
	//Lugar
	//----------------------------------------------------------------------------------------------------

	public String agregarLugar(String nombre) {
		return ph.adicionarLugar(nombre);
	}

	public List<Lugar> darLugares() {
		return ph.darLugars();
	}

	public Lugar darLugarPorId(int idLugar) {
		return ph.darLugarPorId(idLugar);
	}

	public long eliminarLugarPorId(int idLugar) {
		return ph.eliminarLugarPorId(idLugar);
	}

	//----------------------------------------------------------------------------------------------------
	//Mantenimiento
	//----------------------------------------------------------------------------------------------------

	public Mantenimiento agregarMantenimiento(String fechaInicio, String fechaFin, Servicio s, Habitacion h) {
		return ph.adicionarMantenimiento(fechaInicio, fechaFin, s, h);
	}

	public List<Mantenimiento> darMantenimientoes() {
		return ph.darMantenimientos();
	}

	public Mantenimiento darMantenimientoPorId(int idMantenimiento) {
		return ph.darMantenimientoPorId(idMantenimiento);
	}

	public long eliminarMantenimientoPorId(int idMantenimiento) {
		return ph.eliminarMantenimientoPorId(idMantenimiento);
	}


	//----------------------------------------------------------------------------------------------------
	//PlanConsumo
	//----------------------------------------------------------------------------------------------------

	public PlanConsumo agregarPlanConsumo(int numDoc, String tipoPlan,String descripcion, Hotel h, Habitacion hab, String fecha,Cliente c) {
		return ph.adicionarPlanConsumo(numDoc, tipoPlan, descripcion, h, hab, fecha, c);
	}

	public List<PlanConsumo> darPlanConsumoes() {
		return ph.darPlanConsumos();
	}

	public PlanConsumo darPlanConsumoPorId(int idPlanConsumo) {
		return ph.darPlanConsumoPorId(idPlanConsumo);
	}

	public long eliminarPlanConsumoPorId(int idPlanConsumo) {
		return ph.eliminarPlanConsumoPorId(idPlanConsumo);
	}

	//----------------------------------------------------------------------------------------------------
	//Producto
	//----------------------------------------------------------------------------------------------------

	public Producto agregarProducto(String nombre, double costo, Servicio s) {
		return ph.adicionarProducto(nombre, costo, s);
	}

	public List<Producto> darProductoes() {
		return ph.darProductos();
	}

	public Producto darProductoPorId(int idProducto) {
		return ph.darProductoPorId(idProducto);
	}

	public long eliminarProductoPorId(int idProducto) {
		return ph.eliminarProductoPorId(idProducto);
	}

	//----------------------------------------------------------------------------------------------------
	//ReservaHabitacion
	//----------------------------------------------------------------------------------------------------

	public ReservaHabitacion agregarReservaHabitacion(String fechaEntrada, String fechaSalida, int numeroPersonas,Habitacion hab, List<Cliente> clientes) {
		return ph.adicionarReservaHabitacion(fechaEntrada, fechaSalida, numeroPersonas, clientes, hab);
	}

	public List<ReservaHabitacion> darReservaHabitaciones() {
		return ph.darReservaHabitacions();
	}

	public ReservaHabitacion darReservaHabitacionPorId(int idReservaHabitacion) {
		return ph.darReservaHabitacionPorId(idReservaHabitacion);
	}

	public long eliminarReservaHabitacionPorId(int idReservaHabitacion) {
		return ph.eliminarReservaHabitacionPorId(idReservaHabitacion);
	}

	//----------------------------------------------------------------------------------------------------
	//ReservaServicio
	//----------------------------------------------------------------------------------------------------

	public ReservaServicio agregarReservaServicio(String fechaEntrada, String fechaSalida, Cliente c , Servicio s) {
		return ph.adicionarReservaServicio(fechaEntrada, fechaSalida, s, c);
	}

	public List<ReservaServicio> darReservaServicioes() {
		return ph.darReservaServicios();
	}

	public ReservaServicio darReservaServicioPorId(int idReservaServicio) {
		return ph.darReservaServicioPorId(idReservaServicio);
	}

	public long eliminarReservaServicioPorId(int idReservaServicio) {
		return ph.eliminarReservaServicioPorId(idReservaServicio);
	}

	//----------------------------------------------------------------------------------------------------
	//Rol
	//----------------------------------------------------------------------------------------------------

	public String agregarRol(String nombre) {
		return ph.adicionarRol(nombre);
	}

	public List<String> darRoles() {
		return ph.darRols();
	}

	public String darRolPorId(int idRol) {
		return ph.darRolPorId(idRol);
	}

	public long eliminarRolPorId(int idRol) {
		return ph.eliminarRolPorId(idRol);
	}


	//----------------------------------------------------------------------------------------------------
	//Servicio
	//----------------------------------------------------------------------------------------------------

	public Servicio agregarServicio(String nombre, double costo, String horaApertura, String horaCierre, int capacidad,String descripcion,Lugar lugar,boolean disponible) {
		return ph.adicionarServicio(nombre, costo, horaApertura, horaCierre, capacidad, descripcion, lugar, disponible);
	}

	public List<Servicio> darServicioes() {
		return ph.darServicios();
	}

	public Servicio darServicioPorId(int idServicio) {
		return ph.darServicioPorId(idServicio);
	}

	public long eliminarServicioPorId(int idServicio) {
		return ph.eliminarServicioPorId(idServicio);
	}

	//----------------------------------------------------------------------------------------------------
	//TipoHabitacion
	//----------------------------------------------------------------------------------------------------

	public String agregarTipoHabitacion(String tipo) {
		return ph.adicionarTipoHabitacion(tipo);
	}

	public List<TipoHabitacion> darTipoHabitaciones() {
		return ph.darTipoHabitacions();
	}

	public TipoHabitacion darTipoHabitacionPorId(int idTipoHabitacion) {
		return ph.darTipoHabitacionPorId(idTipoHabitacion);
	}

	public long eliminarTipoHabitacionPorId(int idTipoHabitacion) {
		return ph.eliminarTipoHabitacionPorId(idTipoHabitacion);
	}



}


