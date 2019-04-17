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
	
	private int numero;

	private String descripcion; 
	
	private boolean disponible;
	
	private int capacidad;

	private TipoHabitacion tipoHabitacion;



	private double costoNoche;

	private double cuenta;

	private int hotel;


	private List<Consumo> consumo;

	private List<Cliente> clientes;

	private int planConsumo;
	
	public Habitacion(){
		super();
	}


	public Habitacion(int numero, int capacidad, TipoHabitacion tipoHabitacion, List<Servicio> servicios,
			double costoNoche, int idHotel, List<Consumo> consumo, List<Cliente> clientes,
			int planConsumo) {
		super();
		this.numero = numero;
		this.capacidad = capacidad;
		this.tipoHabitacion = tipoHabitacion;
		this.costoNoche = costoNoche;
		this.cuenta = 0;
		this.hotel = idHotel;
		this.consumo = consumo;
		this.clientes = clientes;
		this.planConsumo = planConsumo;
		disponible=false;
	}


	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
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

	public int getHotel() {
		return hotel;
	}

	public void setHotel(int hotel) {
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

	public int getPlanConsumo() {
		return planConsumo;
	}

	public void setPlanConsumo(int planConsumo) {
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
		Consumo con=new Consumo(Lugar.HABIATCION.toString(), this, prod,new String())	;
		cuenta+=con.calcularCostoTotal();
	}

	public void agrgarConsumoALaHabitacion(Consumo con) {
		cuenta+=con.calcularCostoTotal();
	}
}

