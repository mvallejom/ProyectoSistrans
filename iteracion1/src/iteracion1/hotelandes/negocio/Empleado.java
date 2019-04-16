package iteracion1.hotelandes.negocio;

import java.util.List;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class Empleado extends Usuario
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
	public Empleado(){
		super();
	}

	public Empleado(String tipoDocumento, long numeroDocumento, String nombre, String correo,Hotel hotel) {
		super(tipoDocumento, numeroDocumento, nombre, correo);
		this.hotel=hotel;// TODO Auto-generated constructor stub
	}



	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	//-------------------------------------------
	//
	//----------------------------------------
	public void registrarConsumo(String lugar,Cliente cliente,List<Producto> productos,boolean añadirHabitacion,List<Servicio> servicios) {
		double totalPagar=0;
		for(Producto p:productos) {
			totalPagar+=p.getCosto();
		}
		for(Servicio s:servicios) {
			totalPagar+=s.getCosto();
		}

		if(añadirHabitacion) {
			Consumo m=new Consumo(lugar, cliente.getHabitacion(), productos,new String());
		}
		else {
			cliente.pagar(totalPagar);
		}

	}

	public void generarReservaServicio( String fechaEntrada,String fechaSalida, int horas,Servicio servicio,Cliente c) throws Exception {

		if(hotel.servicioDisponible(fechaEntrada, fechaSalida, servicio)==true) {
			ReservaServicio r = new ReservaServicio(fechaEntrada, fechaSalida, c, servicio);
			Consumo m=new Consumo(c.getHabitacion(), servicio.getCosto());
		}
		else {
			throw new Exception();
		}
	}

}


