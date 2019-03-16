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

public class Spa
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private int capacidad;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private Hotel hotel;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private List<Servicio> serviciosSpa;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private List<ReservaServicio> reservaSpa;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public Spa(){
		super();
	}
	

	public Spa(int capacidad, Hotel hotel, List<Servicio> serviciosSpa, List<ReservaServicio> reservaSpa) {
		super();
		this.capacidad = capacidad;
		this.hotel = hotel;
		this.serviciosSpa = serviciosSpa;
		this.reservaSpa = reservaSpa;
	}


	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public List<Servicio> getServiciosSpa() {
		return serviciosSpa;
	}

	public void setServiciosSpa(List<Servicio> serviciosSpa) {
		this.serviciosSpa = serviciosSpa;
	}

	public List<ReservaServicio> getReservaSpa() {
		return reservaSpa;
	}

	public void setReservaSpa(List<ReservaServicio> reservaSpa) {
		this.reservaSpa = reservaSpa;
	}

	
	public void reservaSpa(Cliente cliente, List<Servicio>servicios, Date fecha) {
			
	}
	
}

