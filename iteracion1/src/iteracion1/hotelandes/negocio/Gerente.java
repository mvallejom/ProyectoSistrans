package iteracion1.hotelandes.negocio;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class Gerente extends Usuario
{
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
	 */
	public Gerente(){
		super();
	}

	public Gerente(String tipoDocumento, long numeroDocumento, String nombre, String correo,Hotel hotel) {
		super(tipoDocumento, numeroDocumento, nombre, correo);
		this.hotel = hotel;
		// TODO Auto-generated constructor stub
	}


	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

}

