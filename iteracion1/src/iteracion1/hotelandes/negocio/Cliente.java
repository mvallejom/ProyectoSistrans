package iteracion1.hotelandes.negocio;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class Cliente extends Usuario
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private List<ReservaHabitacion> reservasHabitacion;
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private List<ReservaServicio> servicios;
 private List<Consumo> consumos;
	
	public List<Consumo> getConsumos() {
	return consumos;
}



public void setConsumos(List<Consumo> consumos) {
	this.consumos = consumos;
}


	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private boolean estaEnElHotel;
	
	public boolean isEstaEnElHotel() {
		return estaEnElHotel;
	}



	public void setEstaEnElHotel(boolean estaEnElHotel) {
		this.estaEnElHotel = estaEnElHotel;
	}


	private Habitacion habitacion;

private Hotel hotel;
	
	private Consumo consumo;
	
	
	
	public Cliente(String tipoDocumento, Long numeroDocumento, String nombre, String correo,int  hab) {
		this.habitacion=hotel.darHabitacionPorNumero(hab);
		
		estaEnElHotel=false;
	}

	
	
	
	public List<ReservaServicio> getServicios() {
		return servicios;
	}


	public void setServicios(List<ReservaServicio> servicios) {
		this.servicios = servicios;
	}


	public Hotel getHotel() {
		return hotel;
	}


	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}


	public Consumo getConsumo() {
		return consumo;
	}


	public void setConsumo(Consumo consumo) {
		this.consumo = consumo;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	



	public List<ReservaHabitacion> getReservasHabitacion() {
		return reservasHabitacion;
	}

	public void setReservasHabitacion(List<ReservaHabitacion> reservasHabitacion) {
		this.reservasHabitacion = reservasHabitacion;
	}

	public List<ReservaServicio> getReservaServicio() {
		return servicios;
	}

	public void setReservaServicio(List<ReservaServicio> reservasSalon) {
		this.servicios = reservasSalon;
	}


	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	/*********************************************************************************
	 * *						REQUERIMIENTOS
	 **********************************************************************************/
	
	/*
	RF7 - REGISTRAR UNA RESERVA DE ALOJAMIENTO
	Reserva una habitación por un período de tiempo, por parte de un cliente, siempre y cuando esté disponible.
	Esta operación es realizada por un cliente.*/
	
	public void hacerReservaAlojamiento(String fechaEntrada, String fechaSalida,int numPersonas	,Habitacion h,List<Cliente>clientes) {
		ReservaHabitacion reserva = new ReservaHabitacion(fechaEntrada, fechaSalida, numPersonas, h, clientes);
		reservasHabitacion.add(reserva);
		for (Cliente c:reserva.getClientes())
		{	
		hotel.adicionarCliente(this);
		}
		
		hotel.getReservaHabitacion().add(reserva);
		
	}
	
	public void pagar(double deuda) {
		this.getHabitacion().setCuenta(0);
	}
	
	
	/*RF8 - REGISTRAR UNA RESERVA DE UN SERVICIO DEL HOTEL POR PARTE DE UN CLIENTE
	Reserva la prestación de un servicio por parte de un cliente, siempre y cuando haya disponibilidad. Esta
	operación es realizada por un cliente.*/
	
	public void generarReservaServicio( String fechaEntrada,String fechaSalida, int horas,Servicio servicio) throws Exception {
		
		if(hotel.servicioDisponible(fechaEntrada, fechaSalida, servicio)==true) {
			ReservaServicio r = new ReservaServicio(fechaEntrada, fechaSalida, this, servicio);
			Consumo m=new Consumo(getHabitacion(), servicio.getCosto());
		}
		else {
			throw new Exception();
			}
	}

	
}

