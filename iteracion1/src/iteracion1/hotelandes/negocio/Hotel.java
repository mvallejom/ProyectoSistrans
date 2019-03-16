package iteracion1.hotelandes.negocio;
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
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */

	private String nombre;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */

	private List<Habitacion> habitaciones;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */

	private List<Piscina> piscina;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */

	private List<Gimnasio> gimnasio;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */

	private Internet internet;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */

	private List<Bar> bares;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */

	private List<Restaurante> restaurantes;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */

	private Supermercado supermercado;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */

	private List<Tienda> tiendas;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */

	private Spa spa;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */

	private List<Lavanderia> lavanderias;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */

	private List<Prestamo> prestamos;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */

	private List<Salon> salones;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */

	private List<PlanConsumo> planesConsumo;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */

	private List<ReservaHabitacion> reservaHabitacion;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */

	private List<Recepcionista> recepcionistas;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */

	private List<Empleado> empleados;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */

	private Administrador administrador;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */

	private Gerente gerente;

	private List<ReservaServicio> reservas;

	private List<Cliente> clientes;
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public Hotel(){
		super();
	}

	public Hotel(String nombre, List<Habitacion> habitaciones, List<Piscina> piscina, List<Gimnasio> gimnasio,
			Internet internet, List<Bar> bares, List<Restaurante> restaurantes, Supermercado supermercado,
			List<Tienda> tiendas, Spa spa, List<Lavanderia> lavanderias, List<Prestamo> prestamos, List<Salon> salones,
			List<PlanConsumo> planesConsumo, List<ReservaHabitacion> reservaHabitacion,
			List<Recepcionista> recepcionistas, List<Empleado> empleados, Administrador administrador,
			Gerente gerente) {
		super();
		this.nombre = nombre;
		this.habitaciones = habitaciones;
		this.piscina = piscina;
		this.gimnasio = gimnasio;
		this.internet = internet;
		this.bares = bares;
		this.restaurantes = restaurantes;
		this.supermercado = supermercado;
		this.tiendas = tiendas;
		this.spa = spa;
		this.lavanderias = lavanderias;
		this.prestamos = prestamos;
		this.salones = salones;
		this.planesConsumo = planesConsumo;
		this.reservaHabitacion = reservaHabitacion;
		this.recepcionistas = recepcionistas;
		this.empleados = empleados;
		this.administrador = administrador;
		this.gerente = gerente;
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

	public List<Piscina> getPiscina() {
		return piscina;
	}

	public void setPiscina(List<Piscina> piscina) {
		this.piscina = piscina;
	}

	public List<Gimnasio> getGimnasio() {
		return gimnasio;
	}

	public void setGimnasio(List<Gimnasio> gimnasio) {
		this.gimnasio = gimnasio;
	}

	public Internet getInternet() {
		return internet;
	}

	public void setInternet(Internet internet) {
		this.internet = internet;
	}

	public List<Bar> getBares() {
		return bares;
	}

	public void setBares(List<Bar> bares) {
		this.bares = bares;
	}

	public List<Restaurante> getRestaurantes() {
		return restaurantes;
	}

	public void setRestaurantes(List<Restaurante> restaurantes) {
		this.restaurantes = restaurantes;
	}

	public Supermercado getSupermercado() {
		return supermercado;
	}

	public void setSupermercado(Supermercado supermercado) {
		this.supermercado = supermercado;
	}

	public List<Tienda> getTiendas() {
		return tiendas;
	}

	public void setTiendas(List<Tienda> tiendas) {
		this.tiendas = tiendas;
	}

	public Spa getSpa() {
		return spa;
	}

	public void setSpa(Spa spa) {
		this.spa = spa;
	}

	public List<Lavanderia> getLavanderias() {
		return lavanderias;
	}

	public void setLavanderias(List<Lavanderia> lavanderias) {
		this.lavanderias = lavanderias;
	}

	public List<Prestamo> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(List<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}

	public List<Salon> getSalones() {
		return salones;
	}

	public void setSalones(List<Salon> salones) {
		this.salones = salones;
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

	public Habitacion buscarHabitacion(TipoHabitacion tipo, int capacidad)
	{
		Habitacion resp = null;
		for(Habitacion hab: habitaciones) {
			if(hab.getTipoHabitacion()==tipo && hab.getCapacidad()==capacidad && hab.isDisponible()==true) {
				resp=hab;break;
			}
		}
		return resp;
	}


}


