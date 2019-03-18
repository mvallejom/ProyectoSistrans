package iteracion1.hotelandes.negocio;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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
	public boolean servicioDisponible(Date inicio, Date fin,Servicio s) {
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

}


