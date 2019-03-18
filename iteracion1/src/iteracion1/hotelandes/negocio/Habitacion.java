package iteracion1.hotelandes.negocio;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class Habitacion
{
	
	private String numero;

	private String descripcion; 
	
	private boolean disponible;
	
	private int capacidad;

	private TipoHabitacion tipoHabitacion;



	private double costoNoche;

	private double cuenta;

	private Hotel hotel;


	private List<Consumo> consumo;

	private List<Cliente> clientes;

	private PlanConsumo planConsumo;

	public Habitacion(){
		super();
	}


	public Habitacion(String numero, int capacidad, TipoHabitacion tipoHabitacion, List<String> servicios,
			double costoNoche, double cuenta, Hotel hotel, List<Consumo> consumo, List<Cliente> clientes,
			PlanConsumo planConsumo) {
		super();
		this.numero = numero;
		this.capacidad = capacidad;
		this.tipoHabitacion = tipoHabitacion;
		this.costoNoche = costoNoche;
		this.cuenta = cuenta;
		this.hotel = hotel;
		this.consumo = consumo;
		this.clientes = clientes;
		this.planConsumo = planConsumo;
		disponible=false;
	}


	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public TipoHabitacion getTipoHabitacion() {
		return tipoHabitacion;
	}

	public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}

	

	public double getCostoNoche() {
		return costoNoche;
	}

	public void setCostoNoche(double costoNoche) {
		this.costoNoche = costoNoche;
	}

	public double getCuenta() {
		return cuenta;
	}

	public void setCuenta(double cuenta) {
		this.cuenta = cuenta;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public List<Consumo> getConsumo() {
		return consumo;
	}

	public void setConsumo(List<Consumo> consumo) {
		this.consumo = consumo;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public PlanConsumo getPlanConsumo() {
		return planConsumo;
	}

	public void setPlanConsumo(PlanConsumo planConsumo) {
		this.planConsumo = planConsumo;
	}

	//------------------------------------
	//
	//-----------------------------------

	public boolean isDisponible() {
		return disponible;
	}


	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}


	public void AgregarConsumoDeHabitacion(List<Producto> prod) {
		Consumo con=new Consumo(Lugar.HABIATCION, this, prod)	;
		cuenta+=con.calcularCostoTotal();
	}

	public void agrgarConsumoALaHabitacion(Consumo con) {
		cuenta+=con.calcularCostoTotal();
	}
}

