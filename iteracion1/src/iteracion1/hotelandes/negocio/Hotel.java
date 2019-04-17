package iteracion1.hotelandes.negocio;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import persistencia.PersistenciaHotel;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class Hotel
{

	private List<Mantenimiento> mantenimientos;
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

	private List<OrganizadorEventos> organizadores;

	private List <Convencion> convenciones;



	public Hotel(String nombre, List<Habitacion> habitaciones, List<PlanConsumo> planesConsumo, List<Recepcionista> recepcionistas, List<Empleado> empleados,
			Administrador administrador, Gerente gerente, List<Servicio> servicios, List<OrganizadorEventos> organizadores
			) {
		super();
		this.nombre = nombre;
		this.habitaciones = habitaciones;
		this.planesConsumo = planesConsumo;
		this.reservaHabitacion = new ArrayList<ReservaHabitacion>();
		this.recepcionistas = recepcionistas;
		this.empleados = empleados;
		this.administrador = administrador;
		this.gerente = gerente;
		this.servicios = servicios;
		this.clientes = new ArrayList<Cliente>();
		this.reservasServicio= new ArrayList<ReservaServicio>();
		this.organizadores=organizadores;
		this.convenciones= new ArrayList<Convencion>();
		this.mantenimientos= new ArrayList<Mantenimiento>();

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



	public PersistenciaHotel getPh() {
		return ph;
	}



	public void setPh(PersistenciaHotel ph) {
		this.ph = ph;
	}



	public List<OrganizadorEventos> getOrganizadores() {
		return organizadores;
	}



	public void setOrganizadores(List<OrganizadorEventos> organizadores) {
		this.organizadores = organizadores;
	}



	public List<Convencion> getConvenciones() {
		return convenciones;
	}



	public void setConvenciones(List<Convencion> convenciones) {
		this.convenciones = convenciones;
	}




	public List<Mantenimiento> getMantenimientos() {
		return mantenimientos;
	}



	public void setMantenimientos(List<Mantenimiento> mantenimientos) {
		this.mantenimientos = mantenimientos;
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
	public Servicio darServicioPorNombre(String nombre){
		Servicio resp = null;
		for (Servicio s :getServicios()) {
			if(s.getNombre().equals(nombre)) {
				resp= s;
			}
		}
		return resp;
	}

	public boolean servicioDisponible(String inicio, String fin,Servicio s) throws ParseException {
		Date inicioS= convertirAFecha(inicio);
		Date finS=convertirAFecha(fin);
		List <ReservaServicio> serviciosEnfecha = new ArrayList<ReservaServicio>();
		int cont =0;
		boolean resp=false;
		for(ReservaServicio rs:getReservasServicio()) {
			Date reservaInicio=convertirAFecha(rs.getFechaEntrada());
			Date reservaFin= convertirAFecha(rs.getFechaSalida());
			if(rs.getServicio().equals(s)) {
				if(inicioS.after(reservaInicio) && inicioS.before(reservaFin)) {
					cont++;
				}
				else if(finS.after(reservaInicio) && finS.before(reservaFin)) {
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

	public Convencion agregarConvencion(ReservaHabitacion reserva, OrganizadorEventos org,List<ReservaHabitacion>habs,List<ReservaServicio>servicio) {
		return ph.adicionarConvencion(this, nombre, org, habs, servicio);
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

	public Mantenimiento agregarMantenimiento(String fechaInicio, String fechaFin, List<Servicio> s, List<Habitacion> h) {
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



	public List<Servicio> darServicioes() {
		return ph.darServicios();
	}

	public Servicio darServicioPorId(long idServicio) {
		return ph.darServicioPorId(idServicio);
	}

	public long eliminarServicioPorId(int idServicio) {
		return ph.eliminarServicioPorId(idServicio);
	}

	//----------------------------------------------------------------------------------------------------
	//TipoHabitacion
	//----------------------------------------------------------------------------------------------------



	public List<TipoHabitacion> darTipoHabitaciones() {
		return ph.darTipoHabitacions();
	}

	public TipoHabitacion darTipoHabitacionPorId(int idTipoHabitacion) {
		return ph.darTipoHabitacionPorId(idTipoHabitacion);
	}

	public long eliminarTipoHabitacionPorId(int idTipoHabitacion) {
		return ph.eliminarTipoHabitacionPorId(idTipoHabitacion);
	}

	/*************************************************************************************************
	 *										REQUERIMIENTOS
	 *************************************************************************************************************/
	/*RF1 - REGISTRAR ROLES DE USUARIOS
	Se registran los roles de usuario definidos en la descripción del negocio. Esta operación es realizada por
	el administrador del sistema. Debe incluir todos los roles de usuario indicados en el enunciado.
	 */
	public String agregarRol(String nombre) {
		return ph.adicionarRol(nombre);
	}


	/*RF2 - REGISTRAR USUARIO
	Los usuarios tienen una identificación (Tipo de documento, número de documento), un nombre, un correo
	electrónico y su rol respectivo. Esta operación es realizada por el administrador de datos del hotel.
	Considere inicialmente un gerente, un administrador de datos, 2 recepcionistas, 4 empleados y 4 clientes.

	1 Para efectos del curso, no todos los requerimientos descritos acá deben tener interacción con el usuario (interfaz gráfica
	de usuario). Lea atentamente el enunciado de la iteración para saber a cuáles se les debe desarrollar interfaz gráfica y
	cuáles se implementan directamente sobre la base de datos utilizando SQL Developer.
	4*/
	public Usuario agregarUsuario(int numDoc, String tipoDoc,String descripcion, String correo,String  rol, Hotel h) {
		return ph.adicionarUsuario(numDoc, tipoDoc, descripcion, correo, rol, h);
	}
	/*
	RF3 - REGISTRAR TIPO DE HABITACIÓN
	Registra la descripción de los tipos de habitaciones de los cuales dispone el hotel con su dotación
	correspondiente. Esta operación es realizada por el administrador de datos del hotel. Considere
	inicialmente por lo menos 3 tipos de habitaciones.
	 */
	public String agregarTipoHabitacion(String tipo) {
		return ph.adicionarTipoHabitacion(tipo);
	}
	/*
	RF4 - REGISTRAR HABITACIÓN
	Registra las instancias de las habitaciones de las cuales dispone el hotel. Esta operación es realizada por
	el administrador de datos del hotel. Considere inicialmente por lo menos 3 habitaciones de cada tipo de
	habitación disponible
	 */
	public Habitacion agregarHabitacion(int documento, int numeroHabitacion,String descripcion, int capacidad,int  idTipo, double costo,int idPlanConsumo, int idHotel) {
		return ph.adicionarHabitacion(documento, numeroHabitacion, descripcion, capacidad, idTipo, idHotel, costo, idPlanConsumo);

	}
	/*RF5 - REGISTRAR UN SERVICIO DEL HOTEL
	Registra la descripción de los servicios de los cuales dispone el hotel. Esta operación es realizada por el
	administrador de datos del hotel. Considere inicialmente por lo menos 1 servicio de cada uno de los tipos
	de servicio descritos en el enunciado (piscina, spa, bar, … El menú de los bares y restaurantes debe tener
	por lo menos tres productos)*/
	public Servicio agregarServicio(String nombre, double costo, String horaApertura, String horaCierre, int capacidad,String descripcion,Lugar lugar,boolean disponible) {
		return ph.adicionarServicio(nombre, costo, horaApertura, horaCierre, capacidad, descripcion, lugar, disponible);
	}
	/*
	RF6 - REGISTRAR UN PLAN DE CONSUMO
	Registra los planes de consumo disponibles en el hotel. Esta operación es realizada por el administrador
	de datos del hotel. Considere los planes descritos en el enunciado y por lo menos uno de promoción
	particular.*/
	public PlanConsumo agregarPlanConsumo(int numDoc, String tipoPlan,String descripcion, Hotel h, Habitacion hab, String fecha,Cliente c) {
		return ph.adicionarPlanConsumo(numDoc, tipoPlan, descripcion, h, hab, fecha, c);
	}









	/*RF12 - RESERVAR ALOJAMIENTO Y SERVICIOS PARA UNA CONVENCIÓN
	Dada una lista de tipos de habitación y la cantidad deseada y una lista de los servicios del hotel requeridos por
	la convención, se debe encontrar las habitaciones y servicios que los satisfacen y hacer las reservas
	individuales correspondientes. La respuesta debe ser precisamente la lista de las habitaciones y de los servicios
	reservados.*/
	public boolean reservaParaConvencion(String nombre,TipoHabitacion tipoHabitacion, int cantidadHabitaciones, List<Servicio> serviciosRequeridos,String fechaEntrada, String fechaSalida, long docOrganizador) {
		boolean resp=true;
		ArrayList<ReservaHabitacion> habitacionesAReservar= new ArrayList<ReservaHabitacion>();
		ArrayList <ReservaServicio> serviciosReservados= new ArrayList<ReservaServicio>();
		OrganizadorEventos org=null;

		List<Habitacion> habitacionesDisponibles=darHabitacionesPorTipo(tipoHabitacion);
		if(habitacionesDisponibles.size()<cantidadHabitaciones) {
			resp=false;
		}

		int cont=0;
		for(Habitacion h : habitacionesDisponibles) {

			ReservaHabitacion reservaH=new ReservaHabitacion(fechaEntrada, fechaSalida,h);
			habitacionesAReservar.add(reservaH);
			reservaHabitacion.add(reservaH);
			cont++;
			if(cont==cantidadHabitaciones) {break;}
		}
		for(Servicio s : serviciosRequeridos) {
			ReservaServicio reservaS=new ReservaServicio(fechaEntrada, fechaSalida, s);
			serviciosReservados.add(reservaS);
			reservasServicio.add(reservaS);
		}

		for(OrganizadorEventos o : organizadores) {

			if(o.getNumeroDocumento()==docOrganizador) {
				org=o;
			}
		}
		Convencion c = new Convencion(this,nombre, org, habitacionesAReservar, serviciosReservados);
		convenciones.add(c);
		return resp;
	}
	/*
	RF13 - CANCELAR RESERVAS ASOCIADAS A UNA CONVENCIÓN
	De acuerdo con la dinámica de la convención, es posible que haya algunas habitaciones o servicios que deben
	ser desreservados, pues no van a ser utilizados. En el caso extremo que la convención no logró el número 
	8
	mínimo de participantes para ser viable económicamente, la convención y todas las habitaciones y todos los
	servicios reservados deben ser vueltos a poner a disposición de los clientes del hotel.*/
	public void cancelarReservasDeConvencion(String nombre) {
		Convencion convencion=null;
		for (Convencion c: convenciones) {
			if(c.getName().contentEquals(nombre)) {
				convencion=c;
			}

			for(ReservaHabitacion reservaHabitacionHotel:reservaHabitacion) {

				for(ReservaHabitacion reservaHabitacionConvencion: convencion.getReservas()) {
					if(reservaHabitacionHotel.getId()==reservaHabitacionConvencion.getId()) {
						reservaHabitacion.remove(reservaHabitacionHotel);
					}
				}
			}


			for(ReservaServicio reservaServicioHotel:reservasServicio) {

				for(ReservaServicio reservaServicioConvencion: convencion.getServicios()) {
					if(reservaServicioHotel.getId()==reservaServicioConvencion.getId()) {
						reservaHabitacion.remove(reservaServicioHotel
								);
					}
				}
			}
		}

	}
	/*
	RF14 - REGISTRAR EL FIN DE UNA CONVENCIÓN
	Es equivalente a registrar la salida de un cliente del hotel, haciendo las verificaciones de estado de todas las
	habitaciones y servicios asociados a la convención y las cuentas de todos los consumos asociados a la misma
	(alimentación, alquiler de salas, por ejemplo)*/
	public boolean registrarFinConvencion(String nombre) {
		boolean resp=false;

		Convencion convencion=null;
		for (Convencion c: convenciones) {
			if(c.getName().contentEquals(nombre)) {
				convencion=c;
			}
		}
		convencion.calcularCuenta();
		convencion.getCuenta();
		convencion.pagar();
		if(convencion.getCuenta()==0) {
			resp=true;
		}
		return resp;





	}
	/*
	RF15 - REGISTRAR LA ENTRADA A MANTENIMIENTO DE ALOJAMIENTOS O SERVICIOS DEL HOTEL
	Dada una lista de habitaciones o de servicios del hotel y un rango de fechas, dichas habitaciones y servicios no
	son susceptibles de ser reservados ni usados en ese rango de fechas. Para los casos que haya reservas, se
	debe reasignar dichas reservas a habitaciones o servicios equivalentes disponibles. Para los casos en estén
	en uso, se debe trasladar al cliente Y SUS CONSUMOS a una nueva habitación disponible equivalente. En
	caso de no tener disponible una equivalente, se asigna alguna de mejor perfil de comodidad, pero se respeta
	el precio convenido anteriormente con el cliente.*/
	private void registrarMantenimiento(List<Habitacion> habitaciones, List<Servicio> servicios,String inicio,String fin) throws ParseException {
		Date inicioMantenimiento= convertirAFecha(inicio);
		Date finMantenimiento=convertirAFecha(fin);
		boolean disponible=true;
		//Si la habitacion esta ocupada
		for(Habitacion h : habitaciones) {
			if(!h.isDisponible()) {
				if(!cambiarAHabitacionDisponible(h))
					cambiarMejorHabitacion(h);
			}

		}

		//Si hay reservas para la habitacion en las mismas fechas
		for (ReservaHabitacion reserva:this.reservaHabitacion) {
			Date inicioReserva= convertirAFecha(reserva.getFechaEntrada());
			Date finReserva= convertirAFecha(reserva.getFechaSalida());
			if (inicioMantenimiento.after(inicioReserva)&&inicioMantenimiento.before(finReserva)) {
				if(!cambiarAHabitacionDisponible(reserva.getHabitacion())) {
					cambiarMejorHabitacion(reserva.getHabitacion());
				}
			}
			if(finMantenimiento.after(inicioReserva)&&finMantenimiento.before(finReserva)) {
				if(!cambiarAHabitacionDisponible(reserva.getHabitacion())) {
					cambiarMejorHabitacion(reserva.getHabitacion());
				}
			}
		}

		//si hay reserva de servicios para la mismas fechas
		for (ReservaServicio servicio:this.reservasServicio) {
			Date inicioReserva= convertirAFecha(servicio.getFechaEntrada());
			Date finReserva= convertirAFecha(servicio.getFechaSalida());
			if (inicioMantenimiento.after(inicioReserva)&&inicioMantenimiento.before(finReserva)) {
			}
			if(finMantenimiento.after(inicioReserva)&&finMantenimiento.before(finReserva)) {
			}
		}
		Mantenimiento m= new Mantenimiento(inicio, fin, servicios, habitaciones);
		mantenimientos.add(m);
	}
	/*
	RF16 - REGISTRAR EL FIN DEL MANTENIMIENTO DE ALOJAMIENTOS O SERVICIOS DEL HOTEL
	Dada una lista de habitaciones o de servicios del hotel, pone fin a las actividades de mantenimiento, quedando
	nuevamente disponibles para reservas y utilización por parte de los clientes.*/
	private void registrarFinMantenimiento(int id) {
		for(Mantenimiento m: mantenimientos) {
			if(m.getId()==id) {
				for(Habitacion h:m.getHabitacion()) {
					h.setDisponible(true);
				}
				for(Servicio s : m.getServicio()) {
					int actuales=darServicioPorNombre(s.getNombre()).getDisponible();
					s.setDisponible(actuales+1);
				}
			}
		}
	}

	/***************************************************************************************************
	 * 										MetodosAdicionales
	 ***************************************************************************************************/
	public List<Habitacion> darHabitacionesPorTipo(TipoHabitacion tipo){
		List<Habitacion> resp=new ArrayList<Habitacion>();
		for(Habitacion h:habitaciones) {
			if(h.getTipoHabitacion().equals(tipo)) {
				resp.add(h);
			}
		}
		return resp;
	}

	public boolean cambiarAHabitacionDisponible(Habitacion vieja) {
		boolean encontro=false;
		for(Habitacion nueva:habitacionesDisponibles()) {
			if(vieja.getTipoHabitacion().equals(nueva.getTipoHabitacion())) {

				intercambiarHabitaciones(nueva, vieja);
				encontro=true;
			}
		}
		return encontro;

	}

	public void intercambiarServicio(Servicio viejo) {


	}

	public void intercambiarHabitaciones(Habitacion nueva,Habitacion vieja) {
		nueva.setClientes(vieja.getClientes());
		nueva.setConsumo(vieja.getConsumo());
		nueva.setDisponible(false);
		nueva.setCuenta(vieja.getCuenta());
		vieja.setDisponible(true);
		vieja.setClientes(null);
		vieja.setCuenta(0);
		vieja.setConsumo(null);

	}

	public void cambiarMejorHabitacion(Habitacion vieja) {


		for(Habitacion nueva:habitacionesDisponibles()) {

			if(	vieja.getTipoHabitacion().equals(TipoHabitacion.SENCILLA)) {
				if(nueva.getTipoHabitacion().equals(TipoHabitacion.DOBLE)) {
					intercambiarHabitaciones(nueva, vieja);
				}
			}

			if(	vieja.getTipoHabitacion().equals(TipoHabitacion.DOBLE)) {
				if(nueva.getTipoHabitacion().equals(TipoHabitacion.FAMILIAR)) {
					intercambiarHabitaciones(nueva, vieja);

				}
			}


			if(	vieja.getTipoHabitacion().equals(TipoHabitacion.FAMILIAR)) {
				if(nueva.getTipoHabitacion().equals(TipoHabitacion.SUITE)) {
					intercambiarHabitaciones(nueva, vieja);

				}
			}


			if(	vieja.getTipoHabitacion().equals(TipoHabitacion.SUITE)) {
				if(nueva.getTipoHabitacion().equals(TipoHabitacion.SUITE_PRESIDENCIAL)) {
					intercambiarHabitaciones(nueva, vieja);

				}
			}
		}
	}


	public Date convertirAFecha(String fecha) throws ParseException {
		SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");  
		Date resp= formatter.parse(fecha);
		return resp;
	}
}


