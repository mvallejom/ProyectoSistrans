package iteracion1.hotelandes.negocio;
import java.util.Date;
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

	private List<Prestamo>prestamos;
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private List<ReservaServicio> servicios;

	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private Habitacion habitacion;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	

	public Cliente(String tipoDocumento, long numeroDocumento, String nombre, String correo,Habitacion hab) {
		super(tipoDocumento,numeroDocumento,nombre,correo);
		this.habitacion=hab;
	}


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
	
	
	
	public List<Prestamo> getPrestamos() {
		return prestamos;
	}


	public void setPrestamos(List<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}


	public void hacerReserva(Date fechaEntrada, Date fechaSalida,int numPersonas,Pago pago,String nombreHotel,TipoHabitacion tipo,PlanConsumo plan) {
		ReservaHabitacion reserva=new ReservaHabitacion(fechaEntrada, fechaSalida, numPersonas, pago, nombreHotel, tipo, plan);
		reservasHabitacion.add(reserva);
		
	}
	
	public void pagar(double deuda) {
		this.getHabitacion().setCuenta(0);
	}
	
	public void generarReserva( Date fecha, int horas,String tipo) {
		ReservaServicio r= new ReservaServicio(fecha, horas, tipo, this);
		Consumo m=new Consumo(getHabitacion(), r.generarCosto());
	}

}

